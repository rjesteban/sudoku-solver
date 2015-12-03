/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneticAlgorithm;

import GeneticAlgorithm.mutation.Mutation;
import GeneticAlgorithm.recombination.Recombination;
import GeneticAlgorithm.representation.Individual;
import GeneticAlgorithm.selection.ParentSelection;
import GeneticAlgorithm.selection.SurvivorSelection;

/**
 *
 * @author rjesteban
 */
public abstract class GeneticAlgorithm {
    public Individual initial_state;
    public ParentSelection p_selection;
    public SurvivorSelection s_selection;
    public Recombination recombination;
    public Mutation mutation;
    protected int population;
    protected int max_restarts;
    protected int max_iterations;
    public double pm;
    public double pc;
    public double Sr;
    public int restart;
    public int generation;
    public boolean isSolved;
    
    public GeneticAlgorithm(){
        max_restarts = 3;
        max_iterations = 500000;
        population = 100;
        Sr = 0.4;
        pm = 0.01;
        pc = 0.9;
        isSolved = false;
    }
    
    public int getPopulation(){
        return this.population;
    }
    
    public int getMaxRestarts(){
        return this.max_restarts;
    }
    
    public int getMaxGenerations(){
        return this.max_iterations;
    }
    
    public boolean isSolved(){
        return this.isSolved;
    }
    
    public void setMethods(SurvivorSelection ss, ParentSelection ps, 
            Recombination rc, Mutation mu){
        this.s_selection = ss;
        this.p_selection = ps;
        this.recombination = rc;
        this.mutation = mu;
    }
    
    public abstract Individual solve(String file);
    public abstract Individual[] generatePopulation(Individual initial_state);
}
