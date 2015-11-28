/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneticAlgorithm.mutation;

import GeneticAlgorithm.representation.Individual;

/**
 *
 * @author rjesteban
 */
public class RandomResettingMutation implements Mutation{
    private final double pm;
    
    public RandomResettingMutation(double pm){
        this.pm = pm;
    }
    
    @Override
    public void mutate(Individual[] child) {
        for(Individual i:child){
           mutate(i);
        }
    }
   
    public Individual mutate(Individual individual) {
        for (int i = 0; i < individual.getGenotype().length; i++) {
            double prob = Math.random();
            if (prob <= pm && individual.getGenotype()[i].isEditable()) {
                individual.getGenotype()[i].setValue(
                        //Double.valueOf(Math.random()*Math.sqrt(individual.getGenotype().length)).intValue()+1
                        individual.getGenotype()[Double.valueOf(Math.random()*individual.getGenotype().length).intValue()].getValue()
                );
            }
        }
        return individual;
    }
    
    @Override
    public String toString(){
        return "Mutation: Random Resetting";
    }
    
}
