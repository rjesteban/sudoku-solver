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
public class SudokuAllele implements Allele{
    private boolean editable;
    private int value;

    public SudokuAllele(int value){
        if(value==0)
            editable = true;
        editable = false;
        this.value = value;
    }
    
    @Override
    public boolean isEditable() {
        return editable;
    }
    
    @Override
    public void setEditable(boolean value){
        editable = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.value;
        return hash;
    }
}
