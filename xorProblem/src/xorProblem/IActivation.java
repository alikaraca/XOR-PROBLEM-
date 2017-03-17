package xorProblem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author snow_
 */
public interface IActivation {
    public float activate(float input);
    public float derivative(float input);
}
