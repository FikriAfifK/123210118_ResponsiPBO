/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOdatalomba;
import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOimplement.*;
import java.util.logging.*;
/**
 *
 * @author Lab Informatika
 */
public class datalombaDAO implements datalombaimplement {
    Connection connection;
    final String select = "SELECT * FROM `lomba`;";
    final String insert = "INSERT INTO `lomba`(judul, alur, orisinalitas, pemilihanKata, nilai) VALUES (?,?,?,?,?);";
    final String update = "UPDATE `lomba` SET alur = ?, orisinalitas = ?,pemilihanKata = ?, nilai = ? WHERE judul = ?;";
    final String delete = "DELETE FROM `lomba` WHERE lomba.judul = ?;";
    public datalombaDAO(){
        connection = connector.connection();
    }

    @Override
    public void insert(datalomba l) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(0, l.getJudul());
            statement.setDouble(1, l.getAlur());
            statement.setDouble(2, l.getOrisinalitas());
            statement.setDouble(3, l.getPemilihanKata());
            statement.setDouble(4, l.getNilai());
            statement.executeUpdate();
        }catch(SQLException ex){
             ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(datalomba l) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setDouble(1, l.getAlur());
            statement.setDouble(2, l.getOrisinalitas());
            statement.setDouble(3, l.getPemilihanKata());
            statement.setDouble(4, l.getNilai());
            statement.setString(5, l.getJudul());
            statement.executeUpdate();
        }catch(SQLException ex){
             ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String judul) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1, judul);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<datalomba> getAll() {
        List<datalomba> dl = null;
        try{
            dl = new ArrayList<datalomba>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                datalomba l = new datalomba();
                l.setJudul(rs.getString("judul"));
                l.setAlur(rs.getDouble("alur"));
                l.setOrisinalitas(rs.getDouble("orisinalitas"));
                l.setPemilihanKata(rs.getDouble("pemilihanKata"));
                l.setNilai(rs.getDouble("nilai"));
                dl.add(l);
            }
        }catch(SQLException ex){
            Logger.getLogger(datalombaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dl;
    } 
}
