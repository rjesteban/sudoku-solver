/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneticAlgorithm.selection;

import GeneticAlgorithm.representation.Individual;

/**
 *
 * @author rjesteban
 */
public interface SurvivorSelection {
    
    public String getName();
    public Individual[] select(Individual[] candidates);
}
