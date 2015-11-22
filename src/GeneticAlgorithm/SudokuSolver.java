/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneticAlgorithm;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import GeneticAlgorithm.representation.Individual;
import GeneticAlgorithm.representation.SudokuAllele;
import GeneticAlgorithm.representation.SudokuIndividual;

/**
 *
 * @author rjesteban
 */
public class SudokuSolver extends GeneticAlgorithm {
    //use default
    public SudokuSolver(){
        super();
    }
    
    public SudokuSolver(int individuals, int max_iterations, 
            int pc, int pm, double Sr, int max_restarts){
        super();
        this.population = individuals;
        this.max_iterations = max_iterations;
        this.pc = pc;
        this.pm = pm;
        this.Sr = Sr;
        this.max_restarts = max_restarts;
    }
    
    @Override
    public Individual solve(String file) {
            initial_state = new SudokuIndividual(readInput(file));
            
            //stopping critera: reach
            for (int restarts = 0; restarts < this.max_restarts; restarts++) {
                Individual[] individual = generatePopulation(initial_state);
                boolean reached = maxFitnessReached(individual, 0);
                for (int iterations = 0;
                        iterations < max_iterations;
                        iterations++, reached = maxFitnessReached(individual, iterations)) {
                    if(reached)
                        break;
                    Individual[] survivor = this.s_selection.select(individual);
                    Individual[] parent = this.p_selection.select(individual);
                    Individual[] offspring = this.recombination.generateOffsprings(parent);
                    individual = this.combine(survivor, offspring);
                    this.mutation.mutate(individual);
                    this.generation = iterations;
                    this.restart = restarts;
                }
                if (reached){
                    this.isSolved = true;
                    return maxFitnessQualifier(individual);
                }
                else{
                    System.out.println("-------Random Restart #" + restarts + " ");
                }
            }
            return null;
    }
    
    public Individual[] combine(Individual[] survivor, Individual[] offspring){
        int size = survivor.length;
        Individual[] combined = new Individual[size+offspring.length];
        for (int i = 0; i<= size; i++) {
            if(i<size)
                combined[i] = survivor[i];
            else if(i==size){
                for (int r = 0; r < offspring.length; r++, i++)
                    combined[i] = offspring[r];
            }
        }
        return combined;
    }
    
    public Individual maxFitnessQualifier(Individual[] population){
        Individual fit = null;
        for (Individual i:population) {
            double fitness = i.calculateFitness();
            if(fitness==0.0)
                fit = i;
        }
        System.out.println("");
        return fit;
    }
    
    public boolean maxFitnessReached(Individual[] population, int iteration){
        boolean flag = false;
        System.out.print("Iteration "+ iteration + ": ");
        for (Individual i:population) {
            double fitness = i.calculateFitness();
            System.out.print(fitness + " ");
            if(fitness == 0.0)
                flag = true;
        }
        System.out.println("");
        return flag;
    }
    
    
    public SudokuAllele[][] readInput(String file) {
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
    
    @Override
    public Individual[] generatePopulation(Individual initial_state) {
        Individual[] individual = new SudokuIndividual[this.population];
        for (int i = 0; i < this.population; i++) {
            //initial_state.showGenotype();
            individual[i] = initial_state.copy();
            //individual[i].showGenotype();
            individual[i].randomize();
            //individual[i].showGenotype();
            //System.out.println("---------");
        }
        //System.out.println("///---------------///");
        return individual;
    }
}
