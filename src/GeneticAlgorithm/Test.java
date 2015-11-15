/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneticAlgorithm;

/**
 *
 * @author rjesteban
 */
public class Test {
    public static void main(String[] args) {
        GeneticAlgorithm ga = new SudokuSolver();
        ga.solve("sudoku9_01.in");
    }
}
