/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xorProblem;

import xorProblem.IActivation;

/**
 *
 * @author snow_
 */
public class DummyActivation implements IActivation{
    public float activate(float input) {
        return input;
    }
 
    @Override
    public float derivative(float input) {
        return input;
    }
}
