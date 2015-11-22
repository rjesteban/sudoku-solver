/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import GeneticAlgorithm.GeneticAlgorithm;
import GeneticAlgorithm.SudokuSolver;
import GeneticAlgorithm.mutation.CreepMutation;
import GeneticAlgorithm.recombination.nPointCrossover;
import GeneticAlgorithm.selection.Elitism;
import GeneticAlgorithm.selection.TournamentSelection;

/**
 *
 * @author rjesteban
 */
public class Test {
    public static void main(String[] args) {
        
        long start = System.currentTimeMillis();
        
        GeneticAlgorithm solver = new SudokuSolver();
        solver.setMethods(new Elitism(solver.Sr), 
                new TournamentSelection(3, solver.Sr), 
                /*new UniformCrossover(solver.pc),*/
                new nPointCrossover(3),
                new CreepMutation(solver.pm));
        solver.solve("sudoku9_01.in").showPhenotype();
        
          //==============
        long end = System.currentTimeMillis();
        showTimeOut(start, end);

    }
    
    
    public static void showTimeOut(long start, long end){
        long dif = end - start;
        if (dif > 1000) {
            dif = (end - start) / 1000;
            System.out.println("Speed:" + dif + " seconds");
        } else {
            System.out.println("Speed:" + dif + " milliseconds");
        }
    }
}
