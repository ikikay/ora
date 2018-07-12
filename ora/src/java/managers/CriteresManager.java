/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import facades.CritereFacade;
import java.io.Serializable;
import java.util.List;
import javabeans.Critere;
import javax.ejb.EJB;
import javax.ejb.EJBException;

/**
 *
 * @author LAMBERT Ludovic
 */
abstract public class CriteresManager implements Serializable {

    private List<Critere> lesCriteres;
    @EJB
    private CritereFacade critereFacade;

    public List<Critere> getLesCriteres() {
        try {
            lesCriteres = critereFacade.findAll();

        } catch (EJBException ee) {
            // return lescriteres = new ArrayList<>();
        }
        return lesCriteres;
    }

    public void setLescriteres(List<Critere> lesCriteres) {
        this.lesCriteres = lesCriteres;
    }
}
