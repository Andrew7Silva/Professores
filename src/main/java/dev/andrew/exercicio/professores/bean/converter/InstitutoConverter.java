package dev.andrew.exercicio.professores.bean.converter;

import dev.andrew.exercicio.professores.entidade.Instituto;
import dev.andrew.exercicio.professores.rn.InstitutoRN;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author hugolima
 */
@FacesConverter(value = "institutoConverter")
public class InstitutoConverter implements Converter {

    private InstitutoRN RN = new InstitutoRN();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.trim().isEmpty() || "null".equalsIgnoreCase(string)) {
            return null;
        }
        try {
            return RN.obter(Integer.valueOf(string));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null || !(o instanceof Instituto)) {
            return null;
        }
        Instituto instituto = (Instituto) o;
        if (instituto.getId() == null) {
            return null;
        }
        return String.valueOf(instituto.getId());
    }
}
