package managers;

import java.io.Serializable;
import javabeans.Candidat;
import javabeans.Entretien;
import javabeans.Parcours;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author LAMBERT Ludovic
 */
@ManagedBean
@SessionScoped
public class FormulaireCandidature implements Serializable {
    
    private Candidat leCandidat;
    private Entretien lEntretien;
    private Parcours leParcours;
    
    //Candidat
    private String nom;
    private String prenom;
    private String rue;
    private String codePostal;
    private String ville;
    private String dateDeNaissance; //TODO LocalDate
    private String tel;
    private String telPortable;
    private String eMail;
    private String secuSocial;
    //Projet
    private String projet; // TODO OBJET
    //Etudes/ Situation professionnelle
    private String actuelle;
    private String etablissement;
    private String diplome;
    private String commentaire;
    //Mobilité
    private String permisB; // TODO Boolean
    private String voiture; // TODO Boolean
    private String permisA; // TODO Boolean
    private String moto; // TODO Boolean
    private String scooter; // TODO Boolean
    //Dossier Scolaire
    private String ds1;
    private String ds2;
    private String ds3;
    private String observationScolaire;
    //Entretien
    private String e1;
    private String e2;
    private String e3;
    private String e4;
    private String e5;
    private String e6;
    private String e7;
    private String observationEntretien;
    //Conclusion
    private String conclusion;
    private String avis;
    

    private boolean visibiliteVoiture = false;
    private boolean visibilitePermisMoto = true;
    private boolean visibiliteMoto = false;
    private boolean visibiliteScooter = false;

    /*
    Getters et Setters
     */
    public boolean isVisibiliteVoiture() {
        return visibiliteVoiture;
    }

    public void setVisibiliteVoiture(boolean visibiliteVoiture) {
        this.visibiliteVoiture = visibiliteVoiture;
    }

    public boolean isVisibilitePermisMoto() {
        return visibilitePermisMoto;
    }

    public void setVisibilitePermisMoto(boolean visibilitePermisMoto) {
        this.visibilitePermisMoto = visibilitePermisMoto;
    }

    public boolean isVisibiliteMoto() {
        return visibiliteMoto;
    }

    public void setVisibiliteMoto(boolean visibiliteMoto) {
        this.visibiliteMoto = visibiliteMoto;
    }

    public boolean isVisibiliteScooter() {
        return visibiliteScooter;
    }

    public void setVisibiliteScooter(boolean visibiliteScooter) {
        this.visibiliteScooter = visibiliteScooter;
    }

    /*
    Fonctions switch boolean
     */
    public void inverseVisibiliteVoiture() {
        if (visibiliteVoiture == true) {
            visibiliteVoiture = false;
        } else if (visibiliteVoiture == false) {
            visibiliteVoiture = true;
        }
    }

    public void inverseVisibilitePermisMoto() {
        if (visibilitePermisMoto == true) {
            visibilitePermisMoto = false;
        } else if (visibilitePermisMoto == false) {
            visibilitePermisMoto = true;
        }
    }

    public void inverseVisibiliteMoto() {
        if (visibiliteMoto == true) {
            visibiliteMoto = false;
        } else if (visibiliteMoto == false) {
            visibiliteMoto = true;
        }
    }

    public void inverseVisibiliteScooter() {
        if (visibiliteScooter == true) {
            visibiliteScooter = false;
        } else if (visibiliteScooter == false) {
            visibiliteScooter = true;
        }
    }

    /*
    Toggle buttons mobilité
     */
    public void clickOnPermisVoiture() {
        System.out.println("Click on Permis Voiture");
        inverseVisibiliteVoiture();
        inverseVisibilitePermisMoto();
        
    }

    public void clickOnVoiture() {
        System.out.println("Click on  Voiture");
        inverseVisibilitePermisMoto();
    }

    public void clickOnPermisMoto() {
        System.out.println("Click on Permis Moto");
        inverseVisibiliteMoto();
        inverseVisibiliteScooter();
    }
    
    public void clickOnMoto(){
        System.out.println("Click on Moto");
        inverseVisibiliteScooter();
    }

}
