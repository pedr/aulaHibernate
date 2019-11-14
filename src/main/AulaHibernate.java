/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Produto;

/**
 *
 * @author Alunos
 */
public class AulaHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puProjeto");
        EntityManager em = emf.createEntityManager();
        
        Produto prod = new Produto(101, "Batat", 2, true);
        
        em.getTransaction().begin();
        em.persist(prod);
        em.getTransaction().commit();
        System.out.println("Id inserido: " + prod.getId());
        
        prod = em.find(Produto.class, 2);
        System.out.println("Id achado: " + prod.getId());
        
        List<Produto> produtos;
        produtos = em.createQuery("from Produto where descricao = 'Batat'").getResultList();
        for (Produto p : produtos) {
            System.out.println("Lista:: " + p.getId());
        }
        
        em.close();
        emf.close();
         
    }
    
}
