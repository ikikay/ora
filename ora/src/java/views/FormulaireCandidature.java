package views;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author LAMBERT Ludovic
 */
@ManagedBean
@SessionScoped
public class FormulaireCandidature implements Serializable {

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
