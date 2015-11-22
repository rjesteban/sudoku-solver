/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneticAlgorithm.representation;

/**
 *
 * @author rjesteban
 */
public interface Allele {
    public boolean isEditable();
    public int getValue();
    public void setValue(int data);
    public void setEditable(boolean value);
}
