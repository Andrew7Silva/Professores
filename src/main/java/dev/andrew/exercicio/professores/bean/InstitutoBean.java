package dev.andrew.exercicio.professores.bean;

import dev.andrew.exercicio.professores.entidade.Instituto;
import dev.andrew.exercicio.professores.rn.InstitutoRN;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 *
 * @author Fabio
 */
@ManagedBean
@RequestScoped
public class InstitutoBean {

    private List<Instituto> institutos;
    private Instituto instituto = new Instituto();
    private final InstitutoRN INSTITUTO_RN = new InstitutoRN();

    public InstitutoBean() {
    }

    @PostConstruct
    public void init() {
        institutos = INSTITUTO_RN.listar();
    }

    public List<Instituto> getInstitutos() {
        return institutos;
    }

    public void setInstitutos(List<Instituto> institutos) {
        this.institutos = institutos;
    }

    public Instituto getInstituto() {
        return instituto;
    }

    public void setInstituto(Instituto instituto){
        this.instituto = instituto;
    }

    public void excluir() {
        FacesContext currentInstance = FacesContext.getCurrentInstance();
        if (INSTITUTO_RN.excluir(instituto)) {
            FacesMessage fm = new FacesMessage("Sucesso", "Instituto excluído");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            currentInstance.addMessage(null, fm);
            institutos = INSTITUTO_RN.listar();
        } else {
            FacesMessage fm = new FacesMessage("Erro", "Não foi possível excluir o instituto");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            currentInstance.addMessage(null, fm);
        }
    }

    public void salvar() {
        FacesContext currentInstance = FacesContext.getCurrentInstance();
        if (INSTITUTO_RN.salvar(instituto)) {
            FacesMessage fm = new FacesMessage("Sucesso", "Instituto salvo");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            currentInstance.addMessage(null, fm);
            instituto = new Instituto();
        } else {
            FacesMessage fm = new FacesMessage("Erro", "Não foi possível salvar o instituto");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            currentInstance.addMessage(null, fm);
        }
    }
}
