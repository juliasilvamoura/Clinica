/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.model.DAO;

import br.com.clinica.model.bean.Paciente;
import com.connection.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Julia
 */
public class PacienteDAO {
    
    
      public Paciente save(Paciente paciente) {
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.persist(paciente);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return paciente;
    }
    
      
       public Paciente update(Paciente paciente) {
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();
            em.merge(paciente);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return paciente;
    }
      
     public List<Paciente> FindAll() {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Paciente> paciente = null;

        try {
            paciente = em.createQuery("from paciente p").getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar " + e);
        } finally {
            em.close();
        }

        return paciente;
    } 
     
     public Paciente remove(Long id) {
        EntityManager em = new ConnectionFactory().getConnection();
        Paciente paciente = null;
        try {
            paciente = em.find(Paciente.class, id);
            em.getTransaction().begin();
            em.remove(paciente);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Removido com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover " + e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return paciente;
    }
}
