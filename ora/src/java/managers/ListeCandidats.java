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
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author LAMBERT Ludovic
 */
@ManagedBean
@SessionScoped
public class ListeCandidats implements Serializable {

    private List<Candidat> lesCandidats;
    @EJB
    private CandidatFacade candidatFacade;

    private List<Promotion> lesPromotions;
    @EJB
    private PromotionFacade promotionFacade;

    public String toAddCandidat() {
        return "toFormulaireCandidature";
    }

    /*
    Getters and Setters
     */
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
