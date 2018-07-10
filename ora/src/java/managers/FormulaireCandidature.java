package managers;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javabeans.Candidat;
import javabeans.Entretien;
import javabeans.Parcours;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @NotNull(message="Champs 'Nom' obligatoire")
    @Size(min=2, max=255, message = "Taille du champs 'Nom' inccorect !")
    private String nom;
    
    @NotNull(message="Champs 'Prénom' obligatoire")
    @Size(min=2, max=255, message = "Taille du champs 'Prénom' inccorect !")
    private String prenom;
    
    @NotNull(message="Champs 'Rue' obligatoire")
    @Size(min=2, max=255, message = "Taille du champs 'Rue' inccorect !")
    private String rue;
    
    @NotNull(message="Champs 'Code Postal' obligatoire")
    @Size(min=5, max=5, message = "Taille du champs 'Code Postal' inccorect !")
    private String codePostal;
    
    @NotNull(message="Champs 'Ville' obligatoire")
    @Size(min=2, max=255, message = "Taille du champs 'Ville' inccorect !")
    private String ville;
    
    @NotNull(message="Champs 'Date de naissance' obligatoire")
    @Size(min=8, max=10, message = "Taille du champs 'Date de naissance' inccorect !")
    private String dateDeNaissance; //TODO LocalDate
    
    @Size(min=0, max=10, message = "Taille du champs 'Téléphone fixe' inccorect !")
    private String tel;
    
    @Size(min=0, max=10, message = "Taille du champs 'Téléphone Portable' inccorect !")
    private String portable;
    
    @NotNull(message="Champs 'E-Mail' obligatoire")
    @Size(min=2, max=255, message = "Taille du champs 'E-Mail' inccorect !")
    @Pattern(regexp=".*@*\\..{2,3}", message ="E-Mail inccorrect !")
    private String email;
    
    @Size(min=15, max=15, message = "Taille du champs 'Sécurité Social' inccorect !")
    private String secuSocial;
    
    //Projet
    private String projet; // TODO OBJET
    
    //Etudes/ Situation professionnelle
    private String actuelle;
    private String etablissement;
    private String diplome;
    private String commentaire;
    //Mobilité
    private Boolean permisB;
    private Boolean voiture;
    private Boolean permisA;
    private Boolean moto;
    private Boolean scooter;
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

    public Candidat getLeCandidat() {
        return leCandidat;
    }

    public void setLeCandidat(Candidat leCandidat) {
        this.leCandidat = leCandidat;
    }

    public Entretien getlEntretien() {
        return lEntretien;
    }

    public void setlEntretien(Entretien lEntretien) {
        this.lEntretien = lEntretien;
    }

    public Parcours getLeParcours() {
        return leParcours;
    }

    public void setLeParcours(Parcours leParcours) {
        this.leParcours = leParcours;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPortable() {
        return portable;
    }

    public void setPortable(String portable) {
        this.portable = portable;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    

    public String getSecuSocial() {
        return secuSocial;
    }

    public void setSecuSocial(String secuSocial) {
        this.secuSocial = secuSocial;
    }

    public String getProjet() {
        return projet;
    }

    public void setProjet(String projet) {
        this.projet = projet;
    }

    public String getActuelle() {
        return actuelle;
    }

    public void setActuelle(String actuelle) {
        this.actuelle = actuelle;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Boolean getPermisB() {
        return permisB;
    }

    public void setPermisB(Boolean permisB) {
        this.permisB = permisB;
    }

    public Boolean getVoiture() {
        return voiture;
    }

    public void setVoiture(Boolean voiture) {
        this.voiture = voiture;
    }

    public Boolean getPermisA() {
        return permisA;
    }

    public void setPermisA(Boolean permisA) {
        this.permisA = permisA;
    }

    public Boolean getMoto() {
        return moto;
    }

    public void setMoto(Boolean moto) {
        this.moto = moto;
    }

    public Boolean getScooter() {
        return scooter;
    }

    public void setScooter(Boolean scooter) {
        this.scooter = scooter;
    }

    public String getDs1() {
        return ds1;
    }

    public void setDs1(String ds1) {
        this.ds1 = ds1;
    }

    public String getDs2() {
        return ds2;
    }

    public void setDs2(String ds2) {
        this.ds2 = ds2;
    }

    public String getDs3() {
        return ds3;
    }

    public void setDs3(String ds3) {
        this.ds3 = ds3;
    }

    public String getObservationScolaire() {
        return observationScolaire;
    }

    public void setObservationScolaire(String observationScolaire) {
        this.observationScolaire = observationScolaire;
    }

    public String getE1() {
        return e1;
    }

    public void setE1(String e1) {
        this.e1 = e1;
    }

    public String getE2() {
        return e2;
    }

    public void setE2(String e2) {
        this.e2 = e2;
    }

    public String getE3() {
        return e3;
    }

    public void setE3(String e3) {
        this.e3 = e3;
    }

    public String getE4() {
        return e4;
    }

    public void setE4(String e4) {
        this.e4 = e4;
    }

    public String getE5() {
        return e5;
    }

    public void setE5(String e5) {
        this.e5 = e5;
    }

    public String getE6() {
        return e6;
    }

    public void setE6(String e6) {
        this.e6 = e6;
    }

    public String getE7() {
        return e7;
    }

    public void setE7(String e7) {
        this.e7 = e7;
    }

    public String getObservationEntretien() {
        return observationEntretien;
    }

    public void setObservationEntretien(String observationEntretien) {
        this.observationEntretien = observationEntretien;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getAvis() {
        return avis;
    }

    public void setAvis(String avis) {
        this.avis = avis;
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

    public void clickOnMoto() {
        System.out.println("Click on Moto");
        inverseVisibiliteScooter();
    }

    /*
    Fonctions 
     */
    public LocalDate stringToLocalDate(String unString) {
        unString = "28/09/16";
        DateTimeFormatter formatterFormulaireCandidature = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate laDate = LocalDate.parse(unString, formatterFormulaireCandidature);

        return laDate;
    }
    
    public void testLudovic(){
        System.out.println("Nom : " + this.nom);
        System.out.println("Prenom : " + this.prenom);
        System.out.println("Rue : " + this.rue);
        System.out.println("Code Postal : " + this.codePostal);
        System.out.println("Ville : " + this.ville);
        System.out.println("Date de naissance : " + stringToLocalDate(this.dateDeNaissance) + " : " + this.dateDeNaissance);
        System.out.println("Téléphone : " + this.tel);
        System.out.println("Portable : " + this.portable);
        System.out.println("Email : " + this.email);
        System.out.println("Sécurité Social : " + this.secuSocial);
    }

}