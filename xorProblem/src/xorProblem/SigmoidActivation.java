/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xorProblem;


public class SigmoidActivation implements IActivation{
    public float activate(float input) {
        return (float) (1. / (1. + Math.exp(input)));
    }
 
    @Override
    public float derivative(float input) {
        return input * (1 - input);
    }
}
