/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recombination;

import representation.Individual;

/**
 *
 * @author rjesteban
 */
public interface Recombination {
    public Individual[] generateOffsprings(Individual[] parent);
}
