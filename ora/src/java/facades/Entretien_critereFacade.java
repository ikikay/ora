/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import javabeans.Entretien_critere;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ikikay
 */
@Stateless
public class Entretien_critereFacade extends AbstractFacade<Entretien_critere> {

    @PersistenceContext(unitName = "oraPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Entretien_critereFacade() {
        super(Entretien_critere.class);
    }
    
}
