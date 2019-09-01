/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModele;


    

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author amine
 */
public class MonMondelePanier extends AbstractTableModel {
    private int NbreLignes=0 ;
    private int Nbcolonnes ;
    private String[]Titres ;
    private ArrayList<Vector<String> > MesLignes = new ArrayList<Vector<String>>();
            
    public MonMondelePanier(Vector<String> tab , String titre)
    { 
            Nbcolonnes = 1;
            Titres = new String[Nbcolonnes];
            for(int i=0 ; i< Nbcolonnes ;i++)
               Titres[i]= titre;
            Vector<String> Ligne ;
            for(int i=0 ; i<tab.size() ; i++)
            {
               Ligne = new Vector<String>();
                for(int j=0 ; j<Nbcolonnes ;j++)
                {
                String temp = ""+tab.get(i);
                Ligne.add(temp);
                }
                MesLignes.add(Ligne);
                NbreLignes++ ;
            }
    }
    
    public MonMondelePanier(){
        
    }

       
       
    @Override
    public int getRowCount() {
       return NbreLignes ;
    }

    @Override
    public int getColumnCount() {
       return Nbcolonnes ;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return MesLignes.get(rowIndex).get(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return Titres[column];
    }
}
