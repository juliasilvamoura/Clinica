/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.model.DAO;

import br.com.clinica.model.bean.Medico;
import com.connection.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Julia
 */
public class MedicoDAO {
    
      public Medico save(Medico medico) {
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.persist(medico);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return medico;
       
    }
      
      public Medico findByID(Long ID){
      
          EntityManager em = new ConnectionFactory().getConnection();
          Medico medico = null;
          
          try{
              medico = em.find(Medico.class, ID);
              
          }
          catch(Exception e){
              JOptionPane.showMessageDialog(null, "Médico não encontrado"+e);
          }
          finally{
              em.close();
          }
          return medico;
      }
      
      public Medico update(Medico medico) {
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.merge(medico);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return medico;
    }
    
    
       public List<Medico> FindAll() {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Medico> medico = null;

        try {
            medico = em.createQuery("from medico p").getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar " + e);
        } finally {
            em.close();
        }

        return medico;
    } 
       
       public Medico remove(Long id) {
        EntityManager em = new ConnectionFactory().getConnection();
        Medico medico = null;
        try {
            medico = em.find(Medico.class, id);
            em.getTransaction().begin();
            em.remove(medico);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Removido com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return medico;
    }
}
