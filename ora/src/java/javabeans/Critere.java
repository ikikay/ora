/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author iLaziKx
 */
@Entity
@Table(name = "critere")
public class Critere implements Serializable {

    private static final long serialVersionUID = -5892169641074303723L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_critere", nullable = false, length = 255)
    private int idCritere;

    @Column(name = "libelle")
    private String libelle;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "critere")
    private List<Entretien_critere> lesEntretienCritere;

    @ManyToOne
    @JoinColumn(name = "fk_categorieCritere")
    private Categorie_critere categorieCritere;

    public Critere() {

    }

    public Critere(int idCritere, String libelle, List<Entretien_critere> lesEntretienCritere, Categorie_critere categorieCritere) {
        this.idCritere = idCritere;
        this.libelle = libelle;
        this.lesEntretienCritere = lesEntretienCritere;
        this.categorieCritere = categorieCritere;
    }

    public int getIdCritere() {
        return idCritere;
    }

    public void setIdCritere(int idCritere) {
        this.idCritere = idCritere;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Entretien_critere> getLesEntretienCritere() {
        return lesEntretienCritere;
    }

    public void setLesEntretienCritere(List<Entretien_critere> lesEntretienCritere) {
        this.lesEntretienCritere = lesEntretienCritere;
    }

    public Categorie_critere getCategorieCritere() {
        return categorieCritere;
    }

    public void setCategorieCritere(Categorie_critere categorieCritere) {
        this.categorieCritere = categorieCritere;
    }

}
