/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author iLaziKx
 */

@Entity
@Table(name = "entretien_critere")
public class Entretien_critere implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_critere_entretien", nullable = false, length = 255)
    private int idCategorie_critere;

    @ManyToOne
    @JoinColumn(name = "fk_critere")
    private Critere critere;

    @ManyToOne
    @JoinColumn(name = "fk_entretien")
    private Entretien entretien;

    @Column(name = "note")
    private String observation;   

    public Entretien_critere() {
    }

    public Entretien_critere(int idCategorie_critere, Critere critere, Entretien entretien, String observation) {
        this.idCategorie_critere = idCategorie_critere;
        this.critere = critere;
        this.entretien = entretien;
        this.observation = observation;
    }

    public int getIdCategorie_critere() {
        return idCategorie_critere;
    }

    public void setIdCategorie_critere(int idCategorie_critere) {
        this.idCategorie_critere = idCategorie_critere;
    }

    public Critere getCritere() {
        return critere;
    }

    public void setCritere(Critere critere) {
        this.critere = critere;
    }

    public Entretien getEntretien() {
        return entretien;
    }

    public void setEntretien(Entretien entretien) {
        this.entretien = entretien;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
   
}
