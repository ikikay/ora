/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import javabeans.Categorie_critere_entretien;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author iLaziKx
 */
@Stateless
public class Entretien_categorie_critereFacade extends AbstractFacade<Categorie_critere_entretien> {

    @PersistenceContext(unitName = "oraPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Entretien_categorie_critereFacade() {
        super(Categorie_critere_entretien.class);
    }
    
}
