/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import tools.LocalDateAttributeConverter;

/**
 *
 * @author dedeh
 */
@Entity
@Table(name = "entretien")
public class Entretien implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Entretien")
    private int id;
    @Column(name = "avis_Entretien")
    private String avis;
    @Column(name = "dte_Entretien")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate dateEntretien;

    @OneToOne(optional = false)
    @JoinColumn(name = "id_parcours", unique = false, nullable = false, updatable = true)
    private Parcours parcours;

    @OneToOne(optional = false)
    @JoinColumn(name = "id_Candidat", unique = false, nullable = false, updatable = true)
    private Candidat candidat;
    
    @ManyToOne
    @JoinColumn(name = "fk_promotion")
    private Promotion promotion;

    @Column(name = "is_apprenti")
    private Boolean is_apprenti;

    public Entretien() {
    }

    public Entretien(int id, String avis, LocalDate dateEntretien, Parcours parcours, Candidat candidat, Promotion promotion, Boolean is_apprenti) {
        this.id = id;
        this.avis = avis;
        this.dateEntretien = dateEntretien;
        this.parcours = parcours;
        this.candidat = candidat;
        this.promotion = promotion;
        this.is_apprenti = is_apprenti;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Boolean getIs_apprenti() {
        return is_apprenti;
    }

    public void setIs_apprenti(Boolean is_apprenti) {
        this.is_apprenti = is_apprenti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvis() {
        return avis;
    }

    public void setAvis(String avis) {
        this.avis = avis;
    }

    public LocalDate getDateEntretien() {
        return dateEntretien;
    }

    public void setDateEntretien(LocalDate dateEntretien) {
        this.dateEntretien = dateEntretien;
    }

    public Parcours getParcours() {
        return parcours;
    }

    public void setParcours(Parcours parcours) {
        this.parcours = parcours;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

}