package dev.andrew.exercicio.professores.bean;

import dev.andrew.exercicio.professores.entidade.Professor;
import dev.andrew.exercicio.professores.rn.ProfessorRN;

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
public class ProfessorBean {

    private List<Professor> professores;
    private Professor professor = new Professor();
    private final ProfessorRN PROFESSOR_RN = new ProfessorRN();

    public ProfessorBean() {
    }

    @PostConstruct
    public void init() {
        professores = PROFESSOR_RN.listar();
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor){
        this.professor = professor;
    }

    public void excluir() {
        FacesContext currentInstance = FacesContext.getCurrentInstance();
        if (PROFESSOR_RN.excluir(professor)) {
            FacesMessage fm = new FacesMessage("Sucesso", "Professor excluído");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            currentInstance.addMessage(null, fm);
            professores = PROFESSOR_RN.listar();
        } else {
            FacesMessage fm = new FacesMessage("Erro", "Não foi possível excluir o professor");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            currentInstance.addMessage(null, fm);
        }
    }

    public void salvar() {
        FacesContext currentInstance = FacesContext.getCurrentInstance();
        if (PROFESSOR_RN.salvar(professor)) {
            FacesMessage fm = new FacesMessage("Sucesso", "Professor salvo");
            fm.setSeverity(FacesMessage.SEVERITY_INFO);
            currentInstance.addMessage(null, fm);
            professor = new Professor();
        } else {
            FacesMessage fm = new FacesMessage("Erro", "Não foi possível salvar o professor");
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);
            currentInstance.addMessage(null, fm);
        }
    }
}
