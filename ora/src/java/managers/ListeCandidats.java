/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import facades.CandidatFacade;
import facades.PromotionFacade;
import java.io.Serializable;
import java.util.List;
import javabeans.Candidat;
import javabeans.Promotion;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author LAMBERT Ludovic
 */
@ManagedBean
@SessionScoped
public class ListeCandidats implements Serializable {

    private List<Candidat> lesCandidats;
    private Candidat candidat;
    private Promotion promotion;
    private Candidat candidatToAdd;
    private Candidat candidatToEdit;
    @EJB
    private CandidatFacade candidatFacade;

    private List<Promotion> lesPromotions;
    @EJB
    private PromotionFacade promotionFacade;

    @PostConstruct
    public void init() {
        candidatToEdit = new Candidat();
        candidatToAdd = new Candidat();
    }

    public String toAddCandidat() {
        return "toFormulaireCandidature";
    
    } 
    public void createCandidat(ActionEvent actionEvent) {
        candidatFacade.create(candidatToAdd);
        candidatToAdd = new Candidat();
        addMessage("Candidat ajoutÃ© avec succÃ¨s !");
    }
    
   public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public void removeCandidat( Candidat candidatToRemove) {
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

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
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

}
