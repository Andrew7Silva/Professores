package dev.andrew.exercicio.professores.rn;

import dev.andrew.exercicio.professores.dao.GenericDAO;
import dev.andrew.exercicio.professores.entidade.Professor;
import java.util.List;

public class ProfessorRN {

    private final GenericDAO<Professor> PROFESSOR_DAO = new GenericDAO<>();

    public boolean salvar(Professor professor) {
        if (professor == null || professor.getNome().isEmpty() || professor.getTitulacao().isEmpty()) {
            return false;
        } else {
            if (professor.getId() == null || professor.getId() == 0) {
                return PROFESSOR_DAO.criar(professor);
            } else {
                return PROFESSOR_DAO.alterar(professor);
            }
        }
    }

    public List<Professor> listar() {
        return PROFESSOR_DAO.obterTodos(Professor.class);
    }

    public Professor obter(Integer id) {
        return PROFESSOR_DAO.obter(Professor.class, id);
    }

    public boolean excluir(Professor professor) {
        if (professor == null) {
            return false;
        } else {
            return PROFESSOR_DAO.excluir(professor);
        }
    }
}
