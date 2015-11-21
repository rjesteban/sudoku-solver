/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneticAlgorithm;

import mutation.CreepMutation;
import recombination.Recombination;
import recombination.UniformCrossover;
import representation.Individual;
import representation.SudokuAllele;
import representation.SudokuIndividual;
import selection.Elitism;
import selection.TournamentSelection;

/**
 *
 * @author rjesteban
 */
public class Test {
    public static void main(String[] args) {
        SudokuSolver solver = new SudokuSolver();
        solver.setMethods(new Elitism(solver.Sr), 
                new TournamentSelection(3, solver.Sr), 
                new UniformCrossover(solver.pc),
                new CreepMutation(solver.pm));
        
        //survivor, parent, recom, mu
        solver.solve("sudoku9_01.in").showPhenotype();
        
        /*SudokuAllele[][] sa = {{new SudokuAllele(1),new SudokuAllele(2),new SudokuAllele(3),new SudokuAllele(4)},
                {new SudokuAllele(0),new SudokuAllele(0),new SudokuAllele(0),new SudokuAllele(0)},
                {new SudokuAllele(0),new SudokuAllele(0),new SudokuAllele(0),new SudokuAllele(0)},
                {new SudokuAllele(0),new SudokuAllele(0),new SudokuAllele(0),new SudokuAllele(0)}};
        SudokuIndividual s = new SudokuIndividual(sa);
        Individual i = s.copy();
        s.getGenotype()[0].setValue(9);
        i.showGenotype();
        System.out.println("");
        s.showGenotype();
        
        Recombination r = new UniformCrossover(0.5);*/
    }
}
