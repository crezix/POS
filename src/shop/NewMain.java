/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author iresh
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POSPU");
        EntityManager em = emf.createEntityManager();
        db.LoginDetails ld = new db.LoginDetails("admin");
        db.LoginDetailsJpaController ldjc = new db.LoginDetailsJpaController(emf);
        ldjc.findLoginDetails("admin");
        System.out.print(ldjc.findLoginDetails("adm").getPassword());// TODO code application logic here
    }
    
}
