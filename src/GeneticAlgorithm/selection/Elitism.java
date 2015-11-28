/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneticAlgorithm.selection;

import java.util.Arrays;
import GeneticAlgorithm.representation.Individual;

/**
 *
 * @author rjesteban
 */
public class Elitism implements SurvivorSelection{
    private final double survival_rate;
    
    public Elitism(double survival_rate){
        this.survival_rate = survival_rate;
    }
    
    
    @Override
    public String toString() {
        return "Parent Selection: Elitism";
    }

    @Override
    public Individual[] select(Individual[] candidate) {
        int size = Double.valueOf(survival_rate*candidate.length).intValue();
        Individual[] survivor = new Individual[size];
        for(int i = 0; i< size; i++){
            survivor[i] = candidate[i];
        }
        return survivor;
    }
}
