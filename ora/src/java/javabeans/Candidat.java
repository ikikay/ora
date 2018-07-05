/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ikikay
 */
@Entity
@Table(name = "candidat")
public class Candidat implements Serializable {

    private static final long serialVersionUID = -5892169641074303723L;
    @Id
    @Column(name = "idCandidat", nullable = false, length = 255)
    private String idCandidat;

    @Column(name = "nom", nullable = false, length = 255)
    private String nom;
    
    @Column(name = "prenom", nullable = false, length = 255)
    private String prenom;
    
    @Column(name = "codePostal", nullable = false, length = 255)
    private String codePostal;
    
    @Column(name = "ville", nullable = false, length = 255)
    private String ville;
    
    @Column(name = "rue", nullable = false, length = 255)
    private String rue;
    
    @Column(name = "dteNaissance", nullable = false, length = 255)
    private LocalDate dteNaissance;
    
    @Column(name = "tel", nullable = false, length = 255)
    private String tel;
    
}
