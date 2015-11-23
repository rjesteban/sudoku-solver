/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneticAlgorithm.recombination;

import GeneticAlgorithm.representation.Individual;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author rjesteban
 */
public class nPointCrossover implements Recombination{
    private final int[] breakpoint;
    
    public nPointCrossover(int numBreakPoints){
        breakpoint = new int[numBreakPoints];
    }
    
    
    @Override
    public Individual[] generateOffsprings(Individual[] parent) {
        initializeBreakPoints(parent.length);
        Individual[] child = new Individual[parent.length];
        for (int i = 0; i < child.length; i++) {
            int a = i;
            int b = ++i;
            child[a] = crossover(parent[a].copy(),parent[b].copy());
            child[b] = crossover(parent[b].copy(),parent[a].copy());
        }
        return child;
    }
    
    private Individual crossover(Individual male, Individual female){
        Individual child = male.copy();
        if(breakpoint.length==1){
            for(int i = breakpoint[0]; i < male.getGenotype().length; i++){
                child.getGenotype()[i].setValue(female.getGenotype()[i].getValue());
                child.getGenotype()[i].setEditable(female.getGenotype()[i].isEditable());
            }
        }
        else{
            for(int br = 0; br < breakpoint.length-1; br+=2){
                for(int i = breakpoint[br]; i < breakpoint[br+1]; i++){
                    child.getGenotype()[i].setValue(female.getGenotype()[i].getValue());
                    child.getGenotype()[i].setEditable(female.getGenotype()[i].isEditable());
                }
            }
        }
        child.calculateFitness();
        return child;
    }
    
    private void initializeBreakPoints(int bound){
        bound-=2;
        Random r = new Random();
        ArrayList<Integer> bpoints = new ArrayList<Integer>();
        for(int i = 0 ; i < breakpoint.length; i++){
            int s = Double.valueOf((Math.random()*bound)+1).intValue();
            while(bpoints.contains(s))
                s = Double.valueOf((Math.random()*bound)+1).intValue();
            bpoints.add(s);
        }
        Collections.sort(bpoints);
        for(int i = 0; i < bpoints.size(); i++){
            this.breakpoint[i] = bpoints.get(i);
        }
    }
    
    @Override
    public String toString(){
        return "Recombination: N-Point Crossover (" + breakpoint.length + " points)";
    }
}
