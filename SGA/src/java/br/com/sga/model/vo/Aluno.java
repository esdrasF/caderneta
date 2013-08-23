/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sga.model.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author DIGITACAOFUND
 */
@Entity
@Table(name="tb_aluno")
public class Aluno implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="alu_id")
    private Integer id;
    @Column(name="alu_nome")
    private String nome;
    @Column(name="alu_sexo")
    private String sexo;
    @Column(name="alu_dataNasc")
    private String dataNasc;
    @Column(name="alu_naturalidade")
    private String naturalidade;
    @Column(name="alu_nacionalidade")
    private String nacionalidade;
    @Column(name="alu_fone")
    private String foneAluno;
    @Column(name="alu_foneContato1")
    private String foneContato1;
    @Column(name="alu_foneContato2")
    private String foneContato2;
    @Column(name="alu_foneContato3")
    private String foneContato3;
    @Column(name="alu_nomeContato1")
    private String nomeContato1;
    @Column(name="alu_nomeContato2")
    private String nomeContato2;
    @Column(name="alu_nomeContato3")
    private String nomeContato3;
    @Column(name="alu_email")
    private String email;
    @Column(name="alu_status")
    private String status;
    @Temporal(TemporalType.DATE)
    @Column(name="alu_dataMatricula")
    private Date dataMatricula;
    //
    // MAPEAMENTOS
    //
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "serie_ser_id")
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Serie serie = new Serie();
    //
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_endereco_id")
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.ALL)
    private Endereco endereco = new Endereco();
    //
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "anoLetivo_anoLetivo_id")
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private AnoLetivo anoLetivo = new AnoLetivo();
    //
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TB_Filiacao", joinColumns =
    @JoinColumn(name = "TB_Aluno_id"),
    inverseJoinColumns =
    @JoinColumn(name = "TB_Pessoa_id"))
    @Cascade(CascadeType.ALL)
    private List<Pessoa> filiacao;

    public Aluno() {
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getFoneAluno() {
        return foneAluno;
    }

    public void setFoneAluno(String foneAluno) {
        this.foneAluno = foneAluno;
    }

    public String getFoneContato1() {
        return foneContato1;
    }

    public void setFoneContato1(String foneContato1) {
        this.foneContato1 = foneContato1;
    }

    public String getFoneContato2() {
        return foneContato2;
    }

    public void setFoneContato2(String foneContato2) {
        this.foneContato2 = foneContato2;
    }

    public String getFoneContato3() {
        return foneContato3;
    }

    public void setFoneContato3(String foneContato3) {
        this.foneContato3 = foneContato3;
    }

    public String getNomeContato1() {
        return nomeContato1;
    }

    public void setNomeContato1(String nomeContato1) {
        this.nomeContato1 = nomeContato1;
    }

    public String getNomeContato2() {
        return nomeContato2;
    }

    public void setNomeContato2(String nomeContato2) {
        this.nomeContato2 = nomeContato2;
    }

    public String getNomeContato3() {
        return nomeContato3;
    }

    public void setNomeContato3(String nomeContato3) {
        this.nomeContato3 = nomeContato3;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMAtricula) {
        this.dataMatricula = dataMAtricula;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public AnoLetivo getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(AnoLetivo anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public List<Pessoa> getFiliacao() {
        return filiacao;
    }

    public void setFiliacao(List<Pessoa> filiacao) {
        this.filiacao = filiacao;
    }

    @Override
    public String toString() {
        return "Aluno{" + "id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", dataNasc=" + dataNasc + ", naturalidade=" + naturalidade + ", nacionalidade=" + nacionalidade + ", foneAluno=" + foneAluno + ", foneContato1=" + foneContato1 + ", foneContato2=" + foneContato2 + ", foneContato3=" + foneContato3 + ", nomeContato1=" + nomeContato1 + ", nomeContato2=" + nomeContato2 + ", nomeContato3=" + nomeContato3 + ", email=" + email + ", status=" + status + ", dataMAtricula=" + dataMatricula + ", serie=" + serie + ", endereco=" + endereco + ", anoLetivo=" + anoLetivo + ", filiacao=" + filiacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
