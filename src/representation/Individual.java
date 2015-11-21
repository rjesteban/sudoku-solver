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
public interface Individual {
    public double calculateFitness();
    public Allele[] getGenotype();
    public void showGenotype();
    public void showPhenotype();
    public Individual copy();
    public void randomize();
}
