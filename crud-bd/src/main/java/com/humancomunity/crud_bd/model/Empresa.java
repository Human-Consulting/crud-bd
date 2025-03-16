package com.humancomunity.crud_bd.model;

public class Empresa {
    private Integer id;
    private String cnpj;
    private String nome;
    private Integer diretor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDiretor() {
        return diretor;
    }

    public void setDiretor(Integer diretor) {
        this.diretor = diretor;
    }
}
