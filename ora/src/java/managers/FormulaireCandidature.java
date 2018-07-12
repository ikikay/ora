package managers;

import facades.CandidatFacade;
import facades.Categorie_critere_entretienFacade;
import facades.EntretienFacade;
import facades.Entretien_critereFacade;
import facades.ParcoursFacade;
import facades.PromotionFacade;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javabeans.Candidat;
import javabeans.Entretien;
import javabeans.Categorie_critere_entretien;
import javabeans.Entretien_critere;
import javabeans.Parcours;
import javabeans.Promotion;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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

    private Entretien entretien;

    /*
    Formulaire
     */
    //Candidat
    @NotNull(message = "Champs 'Nom' obligatoire")
    @Size(min = 2, max = 255, message = "Taille du champs 'Nom' inccorect !")
    private String nom;

    @NotNull(message = "Champs 'Prénom' obligatoire")
    @Size(min = 2, max = 255, message = "Taille du champs 'Prénom' inccorect !")
    private String prenom;

    @NotNull(message = "Champs 'Rue' obligatoire")
    @Size(min = 2, max = 255, message = "Taille du champs 'Rue' inccorect !")
    private String rue;

    @NotNull(message = "Champs 'Code Postal' obligatoire")
    @Size(min = 5, max = 6, message = "Taille du champs 'Code Postal' inccorect !")
    private String codePostal;

    @NotNull(message = "Champs 'Ville' obligatoire")
    @Size(min = 2, max = 255, message = "Taille du champs 'Ville' inccorect !")
    private String ville;

    @NotNull(message = "Champs 'Date de naissance' obligatoire")
    @Size(min = 8, max = 10, message = "Taille du champs 'Date de naissance' inccorect !")
    private String dateDeNaissance;

    @Size(min = 0, max = 14, message = "Taille du champs 'Téléphone fixe' inccorect !")
    private String tel;

    @NotNull(message = "Champs 'Téléphone Portable' obligatoire")
    @Size(min = 0, max = 14, message = "Taille du champs 'Téléphone Portable' inccorect !")
    private String portable;

    @NotNull(message = "Champs 'E-Mail' obligatoire")
    @Size(min = 2, max = 255, message = "Taille du champs 'E-Mail' inccorect !")
    @Pattern(regexp = ".*@*\\..{2,3}", message = "E-Mail inccorrect !")
    private String email;

    private String secuSocial;

    //Projet
    @NotNull(message = "Champs 'Diplome obligatoire")
    private Promotion projet;

    //Etudes/ Situation professionnelle
    @NotNull(message = "Champs 'Diplome le plus récent' obligatoire")
    @Size(min = 3, max = 255, message = "Taille du champs 'Diplome le plus récent' inccorect !")
    private String actuelle;

    @NotNull(message = "Champs 'Etablissement (et lieu)' obligatoire")
    @Size(min = 3, max = 255, message = "Taille du champs 'Etablissement (et lieu)' inccorect !")
    private String etablissement;

    @NotNull(message = "Champs 'Etat du diplome' obligatoire")
    private Boolean diplome;

    private String commentaire;

    //Mobilité
    private Boolean permisB = false;
    private Boolean voiture = false;
    private Boolean permisA = false;
    private Boolean moto = false;
    private Boolean scooter = false;

    private String observationScolaire;

    private String observationEntretien;
    //Conclusion
    @NotNull(message = "Champs 'Ressenti par rapport à la candidature [...]' obligatoire")
    private String conclusion;
    @NotNull(message = "Champs Avis' obligatoire")
    private String avis;

    /*
    Objets pour base
     */
    private List<Promotion> lesPromotions;
    @EJB
    private PromotionFacade promotionFacade;

    private Candidat leCadidatToEdit;
    @EJB
    private CandidatFacade candidatFacade;

    private Entretien unEntretientToAdd;
    @EJB
    private EntretienFacade entretienFacade;

    private Categorie_critere_entretien unEntretientCategorieCritereToAdd;
    @EJB
    private Categorie_critere_entretienFacade categorieCritereEntretienFacade;

    private Entretien_critere unEntretientCritereToAdd;
    @EJB
    private Entretien_critereFacade entretienCritereFacade;

    private Parcours unParcoursToAdd;
    @EJB
    private ParcoursFacade parcoursFacade;

    @PostConstruct
    public void init() {
        if (entretien != null) {
            // Pré remplissage des champs
            this.nom = entretien.getCandidat().getNom();
            this.prenom = entretien.getCandidat().getPrenom();
            this.rue = entretien.getCandidat().getRue();
            this.codePostal = entretien.getCandidat().getCodePostal();
            this.ville = entretien.getCandidat().getVille();
            this.dateDeNaissance = localDateToString(entretien.getCandidat().getDteNaissance());
            this.tel = entretien.getCandidat().getTel();
            this.portable = entretien.getCandidat().getPortable();
            this.email = entretien.getCandidat().getEmail();
            this.secuSocial = entretien.getCandidat().getSecuSocial();

            this.permisB = entretien.getCandidat().getPermisB();
            this.voiture = entretien.getCandidat().getVoiture();
            this.permisA = entretien.getCandidat().getPermisA();
            this.moto = entretien.getCandidat().getMoto();
            this.scooter = entretien.getCandidat().getScooter();
        }
    }

    public String toFormulaireCandidature(Entretien unEntretien) {
        entretien = unEntretien;
        init();
        return "toFormulaireCandidature";
    }

    /*
    Getters et Setters
     */
    public Entretien getEntretien() {
        return entretien;
    }

    public void setEntretien(Entretien entretien) {
        this.entretien = entretien;
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

    public Promotion getProjet() {
        return projet;
    }

    public void setProjet(Promotion projet) {
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

    public Boolean getDiplome() {
        return diplome;
    }

    public void setDiplome(Boolean diplome) {
        this.diplome = diplome;
    }

    public List<Promotion> getLesPromotions() {
        try {
            lesPromotions = promotionFacade.findAll();

        } catch (EJBException ee) {
            // return lesPromotions = new ArrayList<>();
        }
        return lesPromotions;
    }

    public void setLesPromotions(List<Promotion> lesPromotions) {
        this.lesPromotions = lesPromotions;
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

    public String getObservationScolaire() {
        return observationScolaire;
    }

    public void setObservationScolaire(String observationScolaire) {
        this.observationScolaire = observationScolaire;
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
    Fonctions 
     */
    public LocalDate stringToLocalDate(String unString) {
        try {
            DateTimeFormatter formatterStringToDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate laDate = LocalDate.parse(unString, formatterStringToDate);

            return laDate;
        } catch (Exception e) {
            return null; //TODO Trouvé quoi retourner ou retourner formulaire précédent.
        }
    }

    public String localDateToString(LocalDate uneDate) {
        try {
            DateTimeFormatter formatterDateToString = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String laDateFormate = uneDate.format(formatterDateToString);

            return laDateFormate;
        } catch (Exception e) {
            return null; //TODO Trouvé quoi retourner ou retourner formulaire précédent.
        }
    }

    public void validationFormulaire() {
        //System.out.println("Nom : " + this.nom);
        //System.out.println("Prenom : " + this.prenom);
        //System.out.println("Rue : " + this.rue);
        //System.out.println("Code Postal : " + this.codePostal);
        //System.out.println("Ville : " + this.ville);
        //System.out.println("Date de naissance : " + stringToLocalDate(this.dateDeNaissance) + " : " + this.dateDeNaissance);
        //System.out.println("Téléphone : " + this.tel);
        //System.out.println("Portable : " + this.portable);
        //System.out.println("Email : " + this.email);
        //System.out.println("Sécurité Social : " + this.secuSocial);
        //System.out.println("Diplome le plus récent : " + this.actuelle);
        //System.out.println("Etablissement(et lieu) : " + this.etablissement);
        //System.out.println("Etat du diplome : " + this.diplome + " + note : " + this.commentaire);
        //System.out.println("Permis voiture : " + this.permisB);
        //System.out.println("Voiture : " + this.voiture);
        //System.out.println("Permis Moto : " + this.permisA);
        //System.out.println("Moto : " + this.moto);
        //System.out.println("Scooter : " + this.scooter);
        System.out.println("Observation Dossier Scolaire : " + this.observationScolaire);
        System.out.println("Observation Entretien : " + this.observationEntretien);
        //System.out.println("Conclusion : " + this.conclusion);
        System.out.println("Avis : " + this.avis);

        unParcoursToAdd.setActuelle(this.actuelle);
        unParcoursToAdd.setEtablissement(this.etablissement);
        unParcoursToAdd.setDiplome(this.diplome);
        unParcoursToAdd.setCommentaire(this.commentaire);

        unEntretientToAdd.setAvis(this.avis);
        unEntretientToAdd.setConclusion(this.conclusion);
        unEntretientToAdd.setDateEntretien(LocalDate.now());
        unEntretientToAdd.setParcours(unParcoursToAdd);
        unEntretientToAdd.setCandidat(entretien.getCandidat());
        //ENTRETIENSCRITERES
        //CATEGORIESCRITERES
        unEntretientToAdd.setPromotion(this.projet);
        unEntretientToAdd.setIs_apprenti(false);

        entretien.getCandidat().setNom(this.nom);
        entretien.getCandidat().setPrenom(this.prenom);
        entretien.getCandidat().setCodePostal(this.codePostal);
        entretien.getCandidat().setVille(this.ville);
        entretien.getCandidat().setRue(this.rue);
        entretien.getCandidat().setDteNaissance(stringToLocalDate(this.dateDeNaissance));
        entretien.getCandidat().setTel(this.tel);
        entretien.getCandidat().setPortable(this.portable);
        entretien.getCandidat().setEmail(this.email);
        entretien.getCandidat().setSecuSocial(this.secuSocial);
        entretien.getCandidat().setPermisA(this.permisA);
        entretien.getCandidat().setPermisB(this.permisB);
        entretien.getCandidat().setVoiture(this.voiture);
        entretien.getCandidat().setMoto(this.moto);
        entretien.getCandidat().setScooter(this.scooter);
        entretien.getCandidat().getLesEntretiens().add(unEntretientToAdd);

    }

}
