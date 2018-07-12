/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import facades.CandidatFacade;
import facades.CritereFacade;
import facades.EntretienFacade;
import facades.Entretien_critereFacade;
import facades.PromotionFacade;
import java.io.Serializable;
import java.util.List;
import javabeans.Candidat;
import javabeans.Critere;
import javabeans.Entretien;
import javabeans.Entretien_critere;
import javabeans.Promotion;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;

/**
 *
 * @author LAMBERT Ludovic
 */
@ManagedBean
@SessionScoped
public class ListeCandidats implements Serializable {

    private List<Candidat> lesCandidats;
    private List<Entretien> lesEntretiens;

    private Candidat candidat;
    private Candidat candidatToAdd;
    private Candidat candidatToEdit;
    @EJB
    private CandidatFacade candidatFacade;

    private List<Promotion> lesPromotions;
    @EJB
    private PromotionFacade promotionFacade;

    private List<Critere> lesCriteres;
    @EJB
    private CritereFacade critereFacade;

    private Entretien entretienToAdd;
    @EJB
    private EntretienFacade entretienFacade;

    @EJB
    private Entretien_critereFacade entretien_critereFace;

    @PostConstruct
    public void init() {
        candidatToEdit = new Candidat();
        candidatToAdd = new Candidat();
        entretienToAdd = new Entretien();
    }

    public String toAddCandidat() {
        return "toFormulaireCandidature";

    }

    public String createCandidat() {
        if (entretienToAdd.getPromotion() == null) {
            System.out.println("Candidat non ajouté, manque diplome");
        } else {
            entretienFacade.create(entretienToAdd);
            candidatFacade.create(candidatToAdd);
            lesCriteres = critereFacade.findAll();
            for (Critere unCritere : lesCriteres) {
                Entretien_critere unEntretienCritere = new Entretien_critere();
                unEntretienCritere.setCritere(unCritere);
                unEntretienCritere.setEntretien(entretienToAdd);
                unEntretienCritere.setObservation(1);
                entretien_critereFace.create(unEntretienCritere);

            }
            candidatToAdd = new Candidat();
            entretienToAdd = new Entretien();
            System.out.println("Candidat ajouté avec succés !");
        }

        return "toListeCandidats";
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void removeCandidat(Candidat candidatToRemove) {
        System.out.println(candidatToRemove.getIdCandidat());
        candidatFacade.remove(candidatToRemove);

        addMessage("Candidat crée avec succes");
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public Candidat getCandidatToAdd() {
        return candidatToAdd;
    }

    public void setCandidatToAdd(Candidat candidatToAdd) {
        this.candidatToAdd = candidatToAdd;
    }

    public Candidat getCandidatToEdit() {
        return candidatToEdit;
    }

    public List<Critere> getLesCriteres() {
        try {
            lesCriteres = critereFacade.findAll();

        } catch (EJBException ee) {
            // return lescriteres = new ArrayList<>();
        }
        return lesCriteres;
    }

    public void setLesCriteres(List<Critere> lesCriteres) {
        this.lesCriteres = lesCriteres;
    }

    /*
    Getters and Setters
     */
    public void setCandidatToEdit(Candidat candidatToEdit) {
        this.candidatToEdit = candidatToEdit;
    }

    public List<Candidat> getLesCandidats() {
        try {
            lesCandidats = candidatFacade.findAll();

        } catch (EJBException ee) {
            //return lesCandidats = new ArrayList<>();
        }
        return lesCandidats;
    }

    public void setLesCandidats(List<Candidat> lesCandidats) {
        this.lesCandidats = lesCandidats;
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

    public Entretien getEntretienToAdd() {
        return entretienToAdd;
    }

    public void setEntretienToAdd(Entretien entretienToAdd) {
        this.entretienToAdd = entretienToAdd;
    }

    public List<Entretien> getLesEntretiens() {
        try {
            lesEntretiens = entretienFacade.findAll();

        } catch (EJBException ee) {
            // return lesEntretiens = new ArrayList<>();
        }
        return lesEntretiens;
    }

    public void setLesEntretiens(List<Entretien> lesEntretiens) {
        this.lesEntretiens = lesEntretiens;
    }

}
