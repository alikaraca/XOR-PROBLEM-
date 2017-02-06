package xorProblem;



import java.util.ArrayList;
import java.util.List;



public class NN {
    private List<Neuron> inputLayer;
    private List<Neuron> hiddenLayer;
    private List<Neuron> outputLayer;
    private float E;
    private float e;
    private float lambda;
    private float nu;
     
    public NN(float E, float lambda, float nu) {
        inputLayer = new ArrayList<>();
        hiddenLayer = new ArrayList<>();
        outputLayer = new ArrayList<>();
        this.E = E;
        e = 0;
        this.lambda = lambda;
        this.nu = nu;
    }
     
    public void addInputNeuron(Neuron neuron) {
        inputLayer.add(neuron);
    }
     
    public void addHiddenNeuron(Neuron neuron) {
        hiddenLayer.add(neuron);
    }
     
    public void addOutNeuron(Neuron neuron) {
        outputLayer.add(neuron);
    }
     
    public Neuron getOutput(int index) {
        return outputLayer.get(index);
    } 
     
    public void train() {
        feedForward();
        calculateError();
        backPropagation();
        //System.out.println("Error value: " + e);
    }
     
    public void test() {
        feedForward();
    }
     
    protected void feedForward() {
        for (Neuron nH : hiddenLayer) {
            float inputs = 0;
            for (Neuron nI : inputLayer) {
                int i = inputLayer.indexOf(nI);
                inputs += nI.getOutput() * nH.getWeight(i);
            }
            nH.setInput(inputs);
            nH.activate(lambda);
        }
         
        for (Neuron nO : outputLayer) {
            float inputs = 0;
            for (Neuron nH : hiddenLayer) {
                int i = hiddenLayer.indexOf(nH);
                inputs += nH.getOutput() * nO.getWeight(i);
            }
            nO.setInput(inputs);
            nO.activate(lambda);
        }
    }
     
    protected void calculateError() {
        e = 0;
        for (Neuron nO : outputLayer) {
            nO.error = nO.desired - nO.getOutput();
            e += (float) Math.pow(nO.error, 2);
        }
         
        e = (float)Math.sqrt(e); 
    }
     
    protected void backPropagation() {
        for (Neuron nO : outputLayer) {
            nO.calculateDelta(lambda, nO.error);
            for (Neuron nH : hiddenLayer) {
                int i = hiddenLayer.indexOf(nH);
                nH.calculateDelta(lambda, nO.getDelta() * nO.getWeight(i));
                float diff = nu * nO.getDelta() * nH.getOutput();
                nO.setWeight(i, nO.getWeight(i) + diff);
            }
        }
         
        for (Neuron nH : hiddenLayer) {
            for (Neuron nI : inputLayer) {
                int i = inputLayer.indexOf(nI);
                float diff = nu * nH.getDelta() * nI.getOutput();
                nH.setWeight(i, nH.getWeight(i) + diff);
            }
        }
    }
 
    public float getE() {
        return e;
    }
     
    public boolean learnt() {
        return (e < E);
    }
}
