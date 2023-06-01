/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOimplement;
import java.util.List;
import model.*;
/**
 *
 * @author Lab Informatika
 */
public interface datalombaimplement {
    public void insert(datalomba l);
    public void update(datalomba l);
    public void delete(String judul);
    public List<datalomba> getAll();
}
