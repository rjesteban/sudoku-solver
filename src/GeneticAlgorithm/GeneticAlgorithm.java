/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneticAlgorithm;

import mutation.Mutation;
import recombination.Recombination;
import representation.Individual;
import selection.ParentSelection;
import selection.SurvivorSelection;

/**
 *
 * @author rjesteban
 */
public abstract class GeneticAlgorithm {
    protected Individual initial_state;
    protected ParentSelection p_selection;
    protected SurvivorSelection s_selection;
    protected Recombination recombination;
    protected Mutation mutation;
    protected int population;
    protected int max_restarts;
    protected int max_iterations;
    protected double pm;
    protected double pc;
    protected double Sr;
    
    public GeneticAlgorithm(){
        max_restarts = 3;
        max_iterations = 50000;
        population = 10;
        Sr = 0.2;
        pm = 0.05;
        pc = 0.5;
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
