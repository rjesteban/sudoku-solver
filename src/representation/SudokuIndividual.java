/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package representation;

/**
 *
 * @author rjesteban
 */
public class SudokuIndividual extends Individual{
    public int[][] phenotype;
    public int[][] initial_state;
    

    public SudokuIndividual(int[][] phenotype) {
        this.phenotype = phenotype;
            
    }
    
    public void initialize(){
        for(int r = 0; r < phenotype.length; r++){
            for(int c = 0; c < phenotype[0].length; c++){
                
            }
        }
    }
    

    public int[] getGenotype() {
        int[] rep = new int[phenotype[0].length * phenotype.length];
        for (int r = 0; r < phenotype.length; r++) {
            System.arraycopy(phenotype[r], 0, rep, phenotype[r].length * r, phenotype[r].length);
        }
        return rep;
    }
    
    public void showGenotype(){
        for(int allele:getGenotype())
            System.out.println(allele + " ");
    }
    
    public void showPhenotype(){
        for (int[] phenotype1 : phenotype) {
            for(int c = 0; c < phenotype[0].length; c++)
                System.out.println(phenotype1[c] + " ");
            System.out.println();
        }
    }
    
    
    @Override
    public int calculateFitness(){
        if(phenotype.length!=9){
            return 1;
        }
        else{
            
        }
        
        return 0;
    }
}
