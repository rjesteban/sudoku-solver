/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package representation;

import java.util.Random;

/**
 *
 * @author rjesteban
 */
public class SudokuIndividual implements Individual, Comparable<SudokuIndividual>{
    public SudokuAllele[][] phenotype;
    public int rows;
    public int cols;
    public int block_rows;
    public int block_cols;
    public double fitness;
    
    public SudokuIndividual(SudokuAllele[][] phenotype) {
        this.phenotype = phenotype;
        this.rows = phenotype.length;
        this.cols = phenotype[0].length;
        
        if (this.rows==9){
            this.block_rows = this.block_cols = 3;
        } else {
            this.block_rows = this.rows/2;
            this.block_cols = 2;
        }
        this.initialize();    
    }    
    
    private void initialize(){
        for(SudokuAllele[] chromosome:phenotype){
            for(SudokuAllele allele:chromosome){
                if(allele.getValue()==0){
                    Random r = new Random();
                    allele.setValue(r.nextInt(8)+1);
                }
            }
        }
        //this.showPhenotype();
     }
    
    @Override
    public SudokuAllele[] getGenotype() {
        SudokuAllele[] genotype = new SudokuAllele[this.rows*this.cols];
        for (int r = 0; r < this.rows; r++) 
            System.arraycopy(phenotype[r], 0, genotype, phenotype[r].length * r, phenotype[r].length);
        return genotype;
    }
    
    @Override
    public void showGenotype(){
        for(SudokuAllele allele:getGenotype())
            System.out.print(allele.getValue() + " ");
    }
    
    @Override
    public void showPhenotype(){
        for (SudokuAllele[] phenotype1 : phenotype) {
            for(int c = 0; c < phenotype[0].length; c++)
                System.out.print(phenotype1[c].getValue() + " ");
            System.out.println();
        }
    }
    
    /*
        Calculates the fitness of the Sudoku Individual by
        its phenotype. Calculate how many numbers are not
        called every column, every row, every block. add them
        all, that would be the fitness.
    
        Alternative solution/our implementation: 
        determine the worst fitness the individual
        would get, subtract everytime the desired numbers would appear
        once for every column, row, block.
    
        worst fitness: (2rc)+(((b_r)*(b_c))^2)
        in this implementation worst fitness for each column,
        row, and block, is determined by the dimension of the sudoku board
    */
    @Override
    public double calculateFitness(){
        double fitness = 0;
        //calculate all rows
        //calculate all cols
        //calculate all blocks
        
        
        for(int i=0; i<this.rows; i++) {
           fitness += calculateRowFitness(i);
           fitness += calculateColFitness(i);
           fitness += calculateBlockFitness(i);
        }
        this.fitness = (-1)*fitness;
        return this.fitness;
    }
    
    private double calculateRowFitness(int r){
        double fitnesss = this.rows;
        
        for(int i=1;i<=this.cols;i++){
            for(int c=0; c<this.cols; c++){
                if(this.phenotype[r][c].getValue()==i){
                    fitnesss--;
                    break;
                }
            }
        }
        return fitnesss;
    }
    
    private double calculateColFitness(int c){
        double fitnesss = this.rows;
        
        for(int i=1;i<=this.cols;i++){
            for(int r=0; r<this.rows; r++){
                if(this.phenotype[r][c].getValue()==i){
                    fitnesss--;
                    break;
                }
            }
        }
        return fitnesss;
    }
    
    private double calculateBlockFitness(int block){
        double fitnesss = this.rows;
        int[] w = new int[this.rows];
        
        for(int row = block*this.block_rows%this.rows, r = 0,i = 0; r < this.block_rows; r++){            
            for(int col = (block/this.block_cols)*this.block_cols, c = 0; c < this.block_cols; c++, i++){
                w[i] = this.phenotype[row+r][col+c].getValue();
            }
        }
        
        for(int i=1;i<=this.cols;i++){
            for(int r=0; r<this.rows; r++){
                if(w[r]==i){
                    fitnesss--;
                    break;
                }
            }
        }
        
        return fitnesss;
    }

    /**
     * Descending sort; since we assume GA solves maximization problems
    */
    @Override
    public int compareTo(SudokuIndividual o) {
        if(this.fitness<o.fitness)
            return 1;
        else if(this.fitness>o.fitness)
            return -1;
        else
            return 0;
    }
    
    @Override
    public String toString(){
        return String.valueOf(fitness);
    }
}
