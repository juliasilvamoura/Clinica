/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import br.com.clinica.model.DAO.PacienteDAO;
import br.com.clinica.model.bean.Paciente;

/**
 *
 * @author Julia
 */
public class Teste {
    public static void main(String[] args) {
        
        Paciente p=new Paciente();
        
        p.setId((long)3);
        p.setNome("Lucas Andrei");
        p.setNascimento("28/09/1998");
        PacienteDAO pao=new PacienteDAO();
        
        pao.update(p);
    }
}
