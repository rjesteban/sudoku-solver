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
public class SudokuIndividual implements Individual{
    public SudokuAllele[][] phenotype;

    public SudokuIndividual(SudokuAllele[][] phenotype) {
        this.phenotype = phenotype;
        
    }
    
    public SudokuAllele[] getGenotype() {
        int[] rep = new int[phenotype[0].length * phenotype.length];
        SudokuAllele[] genotype = new SudokuAllele[phenotype[0].length * phenotype.length];
        for (int r = 0; r < phenotype.length; r++) {
            System.arraycopy(phenotype[r], 0, genotype, phenotype[r].length * r, phenotype[r].length);
        }
        return genotype;
    }
    
    public void showGenotype(){
        for(SudokuAllele allele:getGenotype())
            System.out.print(allele.getValue() + " ");
    }
    
    public void showPhenotype(){
        for (SudokuAllele[] phenotype1 : phenotype) {
            for(int c = 0; c < phenotype[0].length; c++)
                System.out.print(phenotype1[c].getValue() + " ");
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
