/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author iLaziKx
 */
@Entity
@Table(name = "critere")
public class Critere implements Serializable{

    private static final long serialVersionUID = -5892169641074303723L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCritere", nullable = false, length = 255)
    private int idCandidat;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "niveau")
    private int niveau;

    @ManyToOne
    @JoinColumn(name="fk_categorieCritere")
    private Categorie_critere categorieCritere;

}
