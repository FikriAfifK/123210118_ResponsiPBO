/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import DAOdatalomba.datalombaDAO;
import DAOimplement.datalombaimplement;
import model.*;
import view.*;
/**
 *
 * @author Lab Informatika
 */
public class datalombacontroller {
    MainView frame;
    datalombaimplement impldatalomba;
    List<datalomba> dl;
    public datalombacontroller(MainView frame){
        this.frame = frame;
        impldatalomba = new datalombaDAO();
        dl = impldatalomba.getAll();
    }
    
    public void isitabel(){
        dl = impldatalomba.getAll();
        modeltabeldatalomba ml = new modeltabeldatalomba(dl);
        frame.getTabelDataLomba().setModel(ml);
    }
    
    public void insert(){
        datalomba dl = new datalomba();
        dl.setJudul(frame.getJTjudul().getText());
        dl.setAlur(Integer.parseInt(frame.getJTalur().getText()));
        dl.setOrisinalitas(Integer.parseInt(frame.getJTorisinalitas().getText()));
        dl.setPemilihanKata(Integer.parseInt(frame.getJTpemilihanKata().getText()));
        impldatalomba.insert(dl);
    }
    
    public void update(){
        datalomba dl = new datalomba();
        dl.setJudul(frame.getJTjudul().getText());
        dl.setAlur(Integer.parseInt(frame.getJTalur().getText()));
        dl.setOrisinalitas(Integer.parseInt(frame.getJTorisinalitas().getText()));
        dl.setPemilihanKata(Integer.parseInt(frame.getJTpemilihanKata().getText()));
        impldatalomba.update(dl);
    }
    
    public void delete(){
        String judul = frame.getJTjudul().getText();
        impldatalomba.delete(judul);
    }
    
    public void nilai(){
        
    }
}
