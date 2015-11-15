/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneticAlgorithm;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import representation.Individual;
import representation.SudokuIndividual;

/**
 *
 * @author rjesteban
 */
public class SudokuSolver extends GeneticAlgorithm{

    @Override
    public Individual solve(String file) {
        SudokuIndividual si = new SudokuIndividual(readInput(file));
            
        return null;
    }
    
    
    public int[][] readInput(String file){
        try {
            Scanner sc = new Scanner(new File(file));
            int dimension = Integer.valueOf(sc.nextLine());
            int[][] phenotype = new int[dimension][dimension];
            
            for (int r = 0; r < phenotype.length; r++) {
                for (int c = 0; c < phenotype[0].length; c++) {
                    phenotype[r][c] = sc.nextInt();
                }
            }
            for (int r = 0; r < phenotype.length; r++) {
                for (int c = 0; c < phenotype[0].length; c++) {
                    System.out.print(phenotype[r][c]+" ");
                }
                System.out.println("");
            }
            return phenotype;
                    
        } catch (IOException | NumberFormatException e) {
            System.out.println("wrong input format");
            e.printStackTrace();
        }
        return null;
    }
    
}
