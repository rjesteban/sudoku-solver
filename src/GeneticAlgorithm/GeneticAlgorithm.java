/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneticAlgorithm;

import mutation.Mutation;
import recombination.Recombination;
import representation.Individual;
import representation.SudokuIndividual;
import selection.ParentSelection;
import selection.SurvivorSelection;

/**
 *
 * @author rjesteban
 */
public abstract class GeneticAlgorithm {
    protected ParentSelection p_selection;
    protected SurvivorSelection s_selection;
    protected Recombination recombination;
    protected Mutation mutation;
    
    public abstract Individual solve(String file);
}
