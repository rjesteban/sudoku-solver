/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneticAlgorithm.mutation;

import GeneticAlgorithm.representation.Individual;

/**
 *
 * @author rjesteban
 */
public class SwapMutation implements Mutation {
    private final double mutation;
    
    
    public SwapMutation(double mutation){
        this.mutation = mutation;
    }
    
    @Override
    public void mutate(Individual[] child) {
        for(Individual i:child){
            if (Math.random() <= mutation)
                swap(i);
        }
    }
    
    public void swap(Individual i){
        int max = Double.valueOf(Math.sqrt(i.getGenotype().length)).intValue();
        for(int row = 0; row < max*max; row+= max){
            int a = Double.valueOf(Math.random()*max).intValue() + max;
            int b = Double.valueOf(Math.random()*max).intValue() + max;
            while(!i.getGenotype()[a].isEditable() || !i.getGenotype()[b].isEditable()){
                if(!i.getGenotype()[a].isEditable())
                    a = Double.valueOf(Math.random()*max).intValue() + max;
                if(!i.getGenotype()[b].isEditable())
                    b = Double.valueOf(Math.random()*max).intValue() + max;
            }
            int aa = i.getGenotype()[a].getValue();
            i.getGenotype()[a].setValue(i.getGenotype()[b].getValue());
            i.getGenotype()[b].setValue(aa);
        }
    }
    
    @Override
    public String toString(){
        return "Swap Mutation";
    }
}
