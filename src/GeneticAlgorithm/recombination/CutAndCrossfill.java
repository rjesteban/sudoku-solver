/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneticAlgorithm.recombination;

import GeneticAlgorithm.representation.Allele;
import GeneticAlgorithm.representation.Individual;
import java.util.ArrayList;

/**
 *
 * @author rjesteban
 */
public class CutAndCrossfill implements Recombination {
private final double pc;
    
    public CutAndCrossfill(double pc){
        this.pc = pc;
    }
    
    @Override
    public Individual[] generateOffsprings(Individual[] parent) {
        Individual[] child = new Individual[parent.length];
        for (int i = 0; i < child.length; i++) {
            int a = i;
            int b = ++i;
            if(Math.random()<this.pc){
                child[a] = crossover(parent[a].copy(),parent[b].copy());
                child[b] = crossover(parent[b].copy(),parent[a].copy());
            } else{
                child[a] = parent[a];
                child[b] = parent[b];
            }    
        }
        return child;
    }
    
    private Individual crossover(Individual head, Individual tail) {
        Individual child = head.copy();
        int length = Double.valueOf(Math.sqrt(tail.getGenotype().length)).intValue();
        int point = Double.valueOf(length*Math.random()).intValue()+1;
        if (point>=length){
            point= length-1;
        }
        if (point<=0){
            point=1;
        }
        
        ArrayList<Integer> notAllowed = new ArrayList<Integer>();
        ArrayList<Integer> allowed = new ArrayList<Integer>();
       
        for(int base = 0; base <  length*length; base+=length){
            
            for(int start = base; start <  length+(base); start++){
                Allele A = child.getGenotype()[start];
                if(!A.isEditable() || start<base+point)
                    notAllowed.add(A.getValue());
            }
            
            for(int start = base; start <  length+(base); start++){
                Allele A = tail.getGenotype()[start];
                if(!notAllowed.contains(A.getValue())
                        && !allowed.contains(A.getValue()))
                    allowed.add(A.getValue());
            }
            for(int index = point+base, count = 0 ; count < allowed.size(); index++){
                /*if(index == point+base){
                    System.out.println("start----------daskljdkldjaskld");
                    System.out.println("size: " + allowed.size());
                    System.out.println("they are: " + allowed);
                    System.out.println("not: " + notAllowed);
                }
                System.out.println("index: " + index);
                System.out.println("\tbase: " + base);
                System.out.println("\tpoint: " + point);*/
                try{
                    if(child.getGenotype()[index].isEditable()){
                        child.getGenotype()[index].setValue(allowed.get(count));
                        count++;
                    }
                } catch(Exception e){
                    System.out.println("start----------daskljdkldjaskld");
                    System.out.println("size: " + allowed.size());
                    System.out.println("they are: " + allowed);
                    System.out.println("not: " + notAllowed);
                System.out.println("index: " + index);
                System.out.println("\tbase: " + base);
                System.out.println("\tpoint: " + point);
                }
            }
            allowed.clear();
            notAllowed.clear();
        }
        child.calculateFitness();
        return child;
    }
    
    @Override
    public String toString(){
        return "Cut and Crossfill";
    }
}
