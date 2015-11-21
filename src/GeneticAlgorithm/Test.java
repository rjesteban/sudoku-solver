/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneticAlgorithm;

import java.util.Arrays;
import representation.Allele;
import representation.SudokuIndividual;

/**
 *
 * @author rjesteban
 */
public class Test {
    public static void main(String[] args) {
        SudokuSolver ga = new SudokuSolver();
        //ga.solve("sudoku9_01.in");
        SudokuIndividual si1 = new SudokuIndividual(ga.readInput("sudoku9_01.in"));
        SudokuIndividual si2 = new SudokuIndividual(ga.readInput("sudoku9_01.in"));
        SudokuIndividual si3 = new SudokuIndividual(ga.readInput("sudoku9_01.in"));
        SudokuIndividual si4 = new SudokuIndividual(ga.readInput("sudoku9_01.in"));
        SudokuIndividual si5 = new SudokuIndividual(ga.readInput("sudoku9_01.in"));
        System.out.println(si1.calculateFitness());
        System.out.println(si2.calculateFitness());
        System.out.println(si3.calculateFitness());
        System.out.println(si4.calculateFitness());
        System.out.println(si5.calculateFitness());
        SudokuIndividual[] ar = {si1, si2, si3, si4, si5};
        Arrays.sort(ar);
        System.out.println("---------");
        for(SudokuIndividual s: ar){
            for(Allele a: s.getGenotype())
                System.out.print(a.getValue() + " ");
            System.out.println("");
        }
    }
}
