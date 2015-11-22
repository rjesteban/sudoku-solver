/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import GeneticAlgorithm.GeneticAlgorithm;
import GeneticAlgorithm.SudokuSolver;
import GeneticAlgorithm.mutation.RandomResetingMutation;
import GeneticAlgorithm.recombination.nPointCrossover;
import GeneticAlgorithm.representation.Individual;
import GeneticAlgorithm.selection.Elitism;
import GeneticAlgorithm.selection.TournamentSelection;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rjesteban
 */
public class Test {
    public static void main(String[] args) {
        String filename = "sudoku9_01.in";
        long start = System.currentTimeMillis();
        //==================
        GeneticAlgorithm solver = new SudokuSolver();
        solver.setMethods(new Elitism(solver.Sr), 
                new TournamentSelection(3, solver.Sr), 
                /*new UniformCrossover(solver.pc),*/
                new nPointCrossover(2),
               /*new CreepMutation(solver.pm)*/
               new RandomResetingMutation(solver.pm)
        );
        Individual fittest = solver.solve(filename);
        fittest.showPhenotype();
          //==============
        long end = System.currentTimeMillis();
        
        String runningTime = showTimeOut(start, end);
        
        System.out.println(runningTime);
        
        String representationUsed = "Representation: Integer";
        saveSolution(solver, fittest, representationUsed, runningTime, filename);
    }
    
    
    public static String showTimeOut(long start, long end){
        long dif = end - start;
        if (dif > 1000) {
            dif = (end - start) / 1000;
            return "Total Running Time: " + dif + " seconds";
        } else {
            return "Total Running Time: " +  dif + " milliseconds";
        }
    }
    
    public static void saveSolution(GeneticAlgorithm ga,
            Individual fittest,
            String representationUsed, 
            String runningTime, String filename){
        
        String file_name = filename.split("\\s.\\s")[0];
        file_name += ".out";
        
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file_name, "UTF-8");
            writer.println("Parameters used by GA: ");
            writer.println("Representation: " + representationUsed);
            writer.println("Population size: " + ga.getPopulation());
            writer.println("Max Generation): " + ga.getMaxGenerations());
            writer.println("Recombination Method: " + ga.recombination);
            writer.println("Mutation Method: " + ga.mutation);
            writer.println("Parent Selection: " + ga.p_selection);
            writer.println("Survivor Selection: " + ga.s_selection);
            writer.println("Pc: " + ga.pc);
            writer.println("Pm: " + ga.pm);
            writer.println("Survival Rate: " + ga.Sr);
            writer.println("----------");
            writer.println("Number of generations ran: " + ga.generation);
            writer.println(runningTime);
            writer.println("Number of population restarts: " + ga.restart);
            writer.println("Phenotype of Best performing individual: ");
            writer.println("Faye di nko kbaw ani, himu nalang bago class nga muformat"
                    + " sa puzzle");
            if(ga.isSolved())
                writer.println("The sudoku puzzle was solved");
            else
                writer.println("The puzzle wasn't solved. Either the given"
                        + "\n puzzle was wrongly configured or the GA "
                        + "has limitations");
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            writer.close();
        }
        
    }
}
