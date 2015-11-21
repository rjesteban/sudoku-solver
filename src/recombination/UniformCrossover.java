/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recombination;

import java.util.Random;
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
        Individual[] child = new Individual[parent.length/2];
        for (int i = 0; i < child.length; i++) {
            int a = i;
            int b = a+1;
            child[a] = mate(parent[a],parent[b]);
            child[b] = mate(parent[b],parent[a]);
        }
        return child;
    }

    
    private Individual mate(Individual male, Individual female) {
        double[] probability = new double[male.getGenotype().length];
        Random r = new Random();
        for (int i = 0; i<male.getGenotype().length; i++ ) {
            probability[i] = r.nextDouble();
            //do the shizz stuff here
            
        }
        
        return null;
    }
    
}
