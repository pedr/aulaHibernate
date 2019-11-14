/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import model.Produto;

/**
 *
 * @author Alunos
 */
public class ProdutoDao {
    
    public boolean store(Produto p) {
        if (p.getId() != 0) {
            return this.update(p);
        }
        return this.create(p);
    }
    
    public boolean create(Produto produto) {
        EntityManager em = Conexao.getConexao();
        try {
            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();
            return true;
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            em.close();
        }
        return false;
    }
    
    public boolean update(Produto p) {
        EntityManager em = Conexao.getConexao();
        
        try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
            return true;
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            em.close();
        }
        
        return false;
    }
    
    public Produto findById(int id) {
        EntityManager em = Conexao.getConexao();
        
        try {
            Produto p = em.find(Produto.class, id);
            return p;
        } catch (Exception exception) {
            System.out.println(exception);
        } finally {
            em.close();
        }
        
        return null;
    }
    
}
