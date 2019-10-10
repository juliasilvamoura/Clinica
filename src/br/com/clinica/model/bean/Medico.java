/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Julia
 */
@Entity
public class Medico {
    
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long Id;
    private String nomeM;
   // @Column(unique==true)
    private String scnes;
    private String endM;
    private String numM;
    private String telefoneM;
    private String cepM;
   // @Column(unique==true)
    private String cpfM;
    

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNomeM() {
        return nomeM;
    }

    public void setNomeM(String nomeM) {
        this.nomeM = nomeM;
    }

    public String getScnes() {
        return scnes;
    }

    public void setScnes(String scnes) {
        this.scnes = scnes;
    }

    public String getEndM() {
        return endM;
    }

    public void setEndM(String endM) {
        this.endM = endM;
    }

    public String getNumM() {
        return numM;
    }

    public void setNumM(String numM) {
        this.numM = numM;
    }

    public String getTelefoneM() {
        return telefoneM;
    }

    public void setTelefoneM(String telefoneM) {
        this.telefoneM = telefoneM;
    }

    public String getCepM() {
        return cepM;
    }

    public void setCepM(String cepM) {
        this.cepM = cepM;
    }

    public String getCpfM() {
        return cpfM;
    }

    public void setCpfM(String cpfM) {
        this.cpfM = cpfM;
    }   
    
}
