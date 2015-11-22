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
public class UniformCrossover implements Recombination {
    private final double pc;
    
    public UniformCrossover(double pc){
        this.pc = pc;
    }
    
    
    @Override
    public Individual[] generateOffsprings(Individual[] parent) {
        Individual[] child = new Individual[parent.length];
        for (int i = 0; i < child.length; i++) {
            int a = i;
            int b = ++i;
            child[a] = mate(parent[a].copy(),parent[b].copy());
            child[b] = mate(parent[b].copy(),parent[a].copy());
        }
        return child;
    }

    
    private Individual mate(Individual head, Individual tail) {
        Individual child = tail.copy();
        for (int i = 0; i<head.getGenotype().length; i++ ) {
            double probability = Math.random();
            //heads
            if (probability>=this.pc && head.getGenotype()[i].isEditable()) {
                child.getGenotype()[i].setValue(head.getGenotype()[i].getValue());
            }
            //tails: do nothing
        }
        child.calculateFitness();
        return child;
    }
    
}
