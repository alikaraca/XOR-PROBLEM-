
package xorProblem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class xorProblem {
    public static String quantizeResult(float result) {
        return Integer.toString(Math.round(result)) + " (" + Float.toString(result) + ")";
    }
    JButton buton1,buton2;
    JLabel label1,label2,label3,label4,label5;
    public xorProblem(){
        NN nn=new NN(5E-3f, 1.0f, 0.1f);
        SigmoidActivation sa = new SigmoidActivation();
        DummyActivation da = new DummyActivation();
        float BIAS = -1f;
 
        Neuron input1 = new Neuron(da, 0);
        Neuron input2 = new Neuron(da, 0);
        Neuron input3 = new Neuron(da, 0); // BIAS.
        Neuron hidden1 = new Neuron(sa, 3);
        Neuron hidden2 = new Neuron(sa, 3);
        Neuron hidden3 = new Neuron(da, 3); // Dummy neuron.
        Neuron output1 = new Neuron(sa, 3);
 
        nn.addInputNeuron(input1);
        nn.addInputNeuron(input2);
        nn.addInputNeuron(input3);
 
        nn.addHiddenNeuron(hidden1);
        nn.addHiddenNeuron(hidden2);
        nn.addHiddenNeuron(hidden3);
 
        nn.addOutNeuron(output1);
 
        hidden3.setDummy(true);
        input3.setOutput(BIAS);
 
        JFrame frame=new JFrame("XOR Problem");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setBounds(400,400, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buton1=new JButton("Eğitimi Başlat");
        frame.getContentPane().add(buton1);
        label1=new JLabel("Eğitim Sonuç");
        frame.getContentPane().add(label1);
        buton2=new JButton("Tahmini Başlat");
        frame.getContentPane().add(buton2);
        label2=new JLabel("Tahmin Sonuç");
        frame.getContentPane().add(label2);
        label3=new JLabel();
        frame.getContentPane().add(label3);
        label4=new JLabel();
        frame.getContentPane().add(label4);
        label5=new JLabel();
        frame.getContentPane().add(label5);
        
        buton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 
                input1.setOutput(0);
                input2.setOutput(0);
                nn.test();
                input1.setOutput(0);
                input2.setOutput(1);
                nn.test();
                input1.setOutput(1);
                input2.setOutput(0);
                nn.test();
                input1.setOutput(1);
                input2.setOutput(1);
                nn.test();
                label2.setText("0 XOR 0= "+ quantizeResult(nn.getOutput(0).getOutput()));
                label3.setText("0 XOR 1= "+ quantizeResult(nn.getOutput(0).getOutput()));
                label4.setText("1 XOR 0= "+ quantizeResult(nn.getOutput(0).getOutput()));
                label5.setText("1 XOR 1= "+ quantizeResult(nn.getOutput(0).getOutput()));
            }
        });
        buton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int iteration = 0;
                do {
                    iteration++;
             
                    input1.setOutput(0);
                    input2.setOutput(0);
  
                    output1.desired = 0;
 
                    nn.train();
 
                    input1.setOutput(0);
                    input2.setOutput(1);
 
                    output1.desired = 1;
 
                    nn.train();
 
                    input1.setOutput(1);
                    input2.setOutput(0);
 
                    output1.desired = 1;
 
                    nn.train();
 
                    input1.setOutput(1);
                    input2.setOutput(1);
 
                    output1.desired = 0;
 
                    nn.train();
             
                    if (iteration % 50000 == 0) {
                        System.out.println("-------------------------------");
                        System.out.println("Current iteration:" + iteration);
                        System.out.println("Current error:" + nn.getE());
                        System.out.println("-------------------------------");
                    }
                    } while(!nn.learnt() && iteration < 3000000);
        
                    label1.setText("Eğitim Tamamlandı");
            }    
        });
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        
        xorProblem p=new xorProblem();
        
        
    }
    
}
