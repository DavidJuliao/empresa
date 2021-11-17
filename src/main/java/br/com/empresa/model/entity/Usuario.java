package br.com.empresa.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "usu")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    private String nome;

    @Column(name = "rg")
    private String rg;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "cod_cad")
    private String codigoCadastro;

    @Column(name = "dat_ina")
    private LocalDate dataInativacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCodigoCadastro() {
        return codigoCadastro;
    }

    public void setCodigoCadastro(String codigoCadastro) {
        this.codigoCadastro = codigoCadastro;
    }

    public LocalDate getDataInativacao() {
        return dataInativacao;
    }

    public void setDataInativacao(LocalDate dataInativacao) {
        this.dataInativacao = dataInativacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        if (!id.equals(usuario.id)) return false;
        if (!nome.equals(usuario.nome)) return false;
        if (rg != null ? !rg.equals(usuario.rg) : usuario.rg != null) return false;
        if (cpf != null ? !cpf.equals(usuario.cpf) : usuario.cpf != null) return false;
        if (codigoCadastro != null ? !codigoCadastro.equals(usuario.codigoCadastro) : usuario.codigoCadastro != null)
            return false;
        return dataInativacao != null ? dataInativacao.equals(usuario.dataInativacao) : usuario.dataInativacao == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + nome.hashCode();
        result = 31 * result + (rg != null ? rg.hashCode() : 0);
        result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
        result = 31 * result + (codigoCadastro != null ? codigoCadastro.hashCode() : 0);
        result = 31 * result + (dataInativacao != null ? dataInativacao.hashCode() : 0);
        return result;
    }
}
