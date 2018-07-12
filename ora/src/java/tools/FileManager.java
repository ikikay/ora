/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import javabeans.Entretien;
import javabeans.Entretien_critere;
import javabeans.Categorie_critere_entretien;
import java.util.List;

/**
 *
 * @author dedeh
 */
class FileManager {

    public static void Generate(Entretien ent) {
        String nom = ent.getCandidat().getNom();
        String prenom = ent.getCandidat().getPrenom();
        String adresse = ent.getCandidat().getCodePostal() + ent.getCandidat().getRue() + ent.getCandidat().getVille();
        String naissance = ent.getCandidat().getDteNaissance().toString();
        String telephone = ent.getCandidat().getTel();
        String portable = ent.getCandidat().getPortable();
        String email = ent.getCandidat().getEmail();
        String securiteSociale = ent.getCandidat().getSecuSocial();
        String projet = ent.getPromotion().getTitre();

        String actuellement = ent.getParcours().getActuelle();
        String etablissement = ent.getParcours().getEtablissement();
        String diplome = ent.getParcours().getCommentaire();
        boolean statutDiplome = ent.getParcours().getDiplome();

        boolean permisVoiture = ent.getCandidat().getPermisB();
        boolean voiture = ent.getCandidat().getVoiture();
        boolean scooter = ent.getCandidat().getScooter();
        boolean permisMoto = ent.getCandidat().getPermisA();
        boolean moto = ent.getCandidat().getMoto();

        List<Categorie_critere_entretien> listObservation = ent.getLesCategorieCritereEntretien();

        List<Entretien_critere> listCritères = ent.getLesEntretienCritere();

        String conclusion = ent.getConclusion();
        String avis = ent.getAvis();
        String responsablePromotion = ent.getPromotion().getUser().getName();
        String dateEntretien = ent.getDateEntretien().toString();
    }

}
