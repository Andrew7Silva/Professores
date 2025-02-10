package dev.andrew.exercicio.professores.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "instituto")
@NamedQueries({
    @NamedQuery(name = "Instituto.findAll", query = "SELECT i FROM Instituto i"),
    @NamedQuery(name = "Instituto.findById", query = "SELECT i FROM Instituto i WHERE i.id = :id"),
    @NamedQuery(name = "Instituto.findByNome", query = "SELECT i FROM Instituto i WHERE i.nome = :nome"),
    @NamedQuery(name = "Instituto.findBySigla", query = "SELECT i FROM Instituto i WHERE i.sigla = :sigla")})
public class Instituto implements Serializable {
    private static final long serialVersionUID = 2L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "sigla", nullable = false, length = 10)
    private String sigla;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instituto")
    private List<Professor> professorList;

    public Instituto() {
    }

    public Instituto(Integer id) {
        this.id = id;
    }

    public Instituto(Integer id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List<Professor> getProfessorList() {
        return professorList;
    }

    public void setProfessorList(List<Professor> professorList) {
        this.professorList = professorList;
    }


    /**
     *
     * @author Fabio
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instituto)) {
            return false;
        }
        Instituto other = (Instituto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ufra.entidade.Instituto[ id=" + id + " ]";
    }

}