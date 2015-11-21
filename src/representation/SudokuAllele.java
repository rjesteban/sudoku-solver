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
public class SudokuAllele implements Allele{
    private boolean editable;
    private int value;

    public SudokuAllele(int value){
        if(value==0)
            editable = true;
        editable = false;
        this.value = value;
             
    }
    
    public boolean isEditable() {
        return editable;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }
}
