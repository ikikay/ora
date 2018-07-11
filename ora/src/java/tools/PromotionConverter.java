package tools;

import javabeans.Promotion;
import java.util.HashMap;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/* 
Penser à ajouter sur l'objet :
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Promotion)) { //Modifier ici le type de l'objet
            return false;
        }
        Promotion article = (Promotion) o; //Modifier ici le type de l'objet
        return Objects.equals(getId(), article.getId()); //Modifier ici le type de l'objet
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
 */
@FacesConverter("promotionConverter")
public class PromotionConverter implements Converter {

    private static final String key = "tools.PromotionConverter"; //Modifier ici le chemin
    private static final String empty = "";

    private Map<String, Object> getViewMap(FacesContext context) {
        Map<String, Object> viewMap = context.getViewRoot().getViewMap();
        @SuppressWarnings({"unchecked", "rawtypes"})
        Map<String, Object> idMap = (Map) viewMap.get(key);
        if (idMap == null) {
            idMap = new HashMap<String, Object>();
            viewMap.put(key, idMap);
        }
        return idMap;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent c, String value) {
        if (value.isEmpty()) {
            return null;
        }
        return getViewMap(context).get(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent c, Object value) {
        if (value == null) {
            return empty;
        }
        String id = String.valueOf(((Promotion) value).getId()); //Modifier ici le type de l'objet
        getViewMap(context).put(id, value);
        return id;
    }
}
