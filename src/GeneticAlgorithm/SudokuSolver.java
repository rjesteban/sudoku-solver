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
import representation.SudokuAllele;
import representation.SudokuIndividual;

/**
 *
 * @author rjesteban
 */
public class SudokuSolver extends GeneticAlgorithm{
    
    public SudokuSolver(){
        super();
    }
    
    @Override
    public Individual solve(String file) {
        initial_state = new SudokuIndividual(readInput(file));
        System.out.println("fitnes: " + initial_state.calculateFitness());
        return null;
    }
    
    
    public SudokuAllele[][] readInput(String file){
        try {
            Scanner sc = new Scanner(new File(file));
            int dimension = Integer.valueOf(sc.nextLine());
            SudokuAllele[][] phenotype = new SudokuAllele[dimension][dimension];
            
            for (int r = 0; r < phenotype.length; r++) {
                for (int c = 0; c < phenotype[0].length; c++) {
                    phenotype[r][c] = new SudokuAllele(sc.nextInt());
                }
            }
            return phenotype;       
        } catch (IOException | NumberFormatException e) {
            System.out.println("wrong input format");
            e.printStackTrace();
        }
        return null;
    }
    
    public void generatePopulation(int population){
        
    
    }
    
    
}
