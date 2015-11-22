/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneticAlgorithm;

import mutation.CreepMutation;
import recombination.UniformCrossover;
import selection.Elitism;
import selection.TournamentSelection;

/**
 *
 * @author rjesteban
 */
public class Test {
    public static void main(String[] args) {
        
        GeneticAlgorithm solver = new SudokuSolver();
        solver.setMethods(new Elitism(solver.Sr), 
                new TournamentSelection(3, solver.Sr), 
                new UniformCrossover(solver.pc),
                new CreepMutation(solver.pm));
        solver.solve("sudoku9_01.in").showPhenotype();
        
        /*
        SudokuIndividual si = new SudokuIndividual(new SudokuSolver().readInput("sudoku9_01.in"));
        si.randomize();
        si.calculateFitness();
        si.showGenotype();
        Individual s = si.copy();
        si.getGenotype()[0].setValue(100);
        si.showGenotype();
        System.out.println(si);
        s.showGenotype();
        System.out.println(s);
        */
    }
}
