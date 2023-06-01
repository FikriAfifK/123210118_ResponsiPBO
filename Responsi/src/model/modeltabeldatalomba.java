/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import javax.swing.table.*;
/**
 *
 * @author Lab Informatika
 */
public class modeltabeldatalomba extends AbstractTableModel {
    List<datalomba> dl;
    public modeltabeldatalomba(List<datalomba>dl){
        this.dl = dl;
    }

    @Override
    public int getRowCount() {
        return dl.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Judul";
            case 1:
                return "Alur";
            case 2:
                return "Orisinalitas";
            case 3:
                return "Pemilihan_Kata";
            case 4:
                return "Nilai";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dl.get(row).getJudul();
            case 1:
                return dl.get(row).getAlur();
            case 2:
                return dl.get(row).getOrisinalitas();
            case 3:
                return dl.get(row).getPemilihanKata();
            case 4:
                return dl.get(row).getNilai();
            default:
                return null;
        }
    }
}
