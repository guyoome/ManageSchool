/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author clara
 */
public class TableauClasses extends AbstractTableModel {
 ArrayList<classe> Classes;
 
 public TableauClasses (){
     this.Classes = new ArrayList<classe>();
 }
 
 public TableauClasses (ArrayList<classe> Classes){
     this.Classes = Classes ;
 }
 
 
 
         
    @Override
    public int getRowCount() {
        return Classes.size();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 1;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return Classes.get(rowIndex).getNom();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
