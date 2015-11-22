/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selection;

import java.util.Arrays;
import representation.Individual;

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
    public String getName() {
        return "Parent Selection: Elitism";
    }

    @Override
    public Individual[] select(Individual[] candidate) {
        int size = Double.valueOf(survival_rate*candidate.length).intValue();
        Individual[] survivor = new Individual[size];
        Individual[] copy = new Individual[candidate.length];
        for(int i = 0; i < copy.length; i++)
            copy[i] = candidate[i].copy();
        Arrays.sort(copy);
        for(int i = 0; i< size; i++){
            survivor[i] = copy[i];
        }
        return survivor;
    }
}
