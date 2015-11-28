/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneticAlgorithm.selection;

import java.util.Arrays;
import java.util.Random;
import GeneticAlgorithm.representation.Individual;

/**
 *
 * @author rjesteban
 */
public class TournamentSelection implements ParentSelection{
    private final double survival_rate;
    private final int k;
    
    public TournamentSelection(int k, double survival_rate){
        this.survival_rate = survival_rate;
        this.k = k;
    }
    
    @Override
    public String toString(){
        return "Selection: Tournament selection";
    }

    @Override
    public Individual[] select(Individual[] candidates) {
        int size = Double.valueOf((1-survival_rate)*candidates.length).intValue();
        Individual[] elites = new Individual[size];
        
        for (int i=0; i < elites.length; i++) {
            elites[i] = pick(candidates);
        }
        return elites;
    }
    
    public Individual pick(Individual[] candidate){
        Random r = new Random();
        Individual[] pick;
        pick = new Individual[this.k];
        for(int i = 0; i < pick.length; i++)
            pick[i] = candidate[r.nextInt(candidate.length)];
        Arrays.sort(pick);
        return pick[0];
    }
}
