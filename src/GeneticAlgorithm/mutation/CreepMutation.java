/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneticAlgorithm.mutation;

import java.util.Random;
import GeneticAlgorithm.representation.Allele;
import GeneticAlgorithm.representation.Individual;

/**
 *
 * @author rjesteban
 */
public class CreepMutation implements Mutation{
    private final double pm;
    public CreepMutation(double pm){
        this.pm = pm;
    }
    
    @Override
    public void mutate(Individual[] child) {
        for(int i = 0; i < child.length; i++) {
            doCreep(child[i].getGenotype());
        }
    }
    
    private void doCreep(Allele[] chromosome){
        Random s = new Random();
        int bound = Double.valueOf(Math.sqrt(chromosome.length)).intValue();
        for(int i = 0; i < chromosome.length; i++){
            double prob = Math.random();
            if (prob <= this.pm && chromosome[i].isEditable()) {
                int value = chromosome[i].getValue();
                chromosome[i].setValue(
                        Double.valueOf(Math.abs(
                        (value+s.nextInt())%bound
                        )).intValue()+1
                        );
            }
        }
    }
}
