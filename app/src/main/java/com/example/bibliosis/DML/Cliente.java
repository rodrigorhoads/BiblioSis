package com.example.bibliosis.DML;

import java.util.ArrayList;
import java.util.Date;

public class Cliente {

    private long id;
    private String nome;
    private ArrayList<Endereco> enderecos;
    private String celular;
    private String email;
    private String Cpf;
    private Date dataNascimento;
    private CategoriaLeitor categoriaLeitor;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public CategoriaLeitor getCategoriaLeitor() {
        return categoriaLeitor;
    }

    public void setCategoriaLeitor(CategoriaLeitor categoriaLeitor) {
        this.categoriaLeitor = categoriaLeitor;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                ", Cpf='" + Cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", categoriaLeitor=" + categoriaLeitor +
                '}';
    }
}
