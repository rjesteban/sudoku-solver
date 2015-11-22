/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutation;

import java.util.Random;
import representation.Allele;
import representation.Individual;

/**
 *
 * @author rjesteban
 */
public class CreepMutation implements Mutation{
    private final double pm;
    public CreepMutation(double pm){
        this.pm = pm;
    }
    
    @Override
    public void mutate(Individual[] child) {
        for(int i = 0; i < child.length; i++) {
            doCreep(child[i].getGenotype(), i);
        }
    }
    
    private void doCreep(Allele[] chromosome, int iter){
        Random s = new Random();
        for(int i = 0; i < chromosome.length; i++){
            double prob = Math.random();
            if (prob <= this.pm && chromosome[i].isEditable()) {
                //System.out.println("creep[" + iter + "]");
                chromosome[i].setValue(
                        s.nextInt(Double.valueOf(Math.sqrt(chromosome.length)).intValue()-1)+1);
            }
        }
    }
}
