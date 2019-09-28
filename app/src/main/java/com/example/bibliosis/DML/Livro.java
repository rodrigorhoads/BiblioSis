package com.example.bibliosis.DML;

import java.util.Date;

public class Livro {


    private  long id;
    private String codigo;
    private String issbn;
    private String título;
    private CategoriaDeLivros categoriaDeLivro;
    private String[] autores;
    private String [] palavrasChave;
    private String dataPublicacao;
    private int nrEdicao;
    private String editora;
    private int nrPaginas;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIssbn() {
        return issbn;
    }

    public void setIssbn(String issbn) {
        this.issbn = issbn;
    }

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
    }

    public CategoriaDeLivros getCategoriaDeLivro() {
        return categoriaDeLivro;
    }

    public void setCategoriaDeLivro(CategoriaDeLivros categoriaDeLivro) {
        this.categoriaDeLivro = categoriaDeLivro;
    }

    public String[] getAutores() {
        return autores;
    }

    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    public String[] getPalavrasChave() {
        return palavrasChave;
    }

    public void setPalavrasChave(String[] palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public int getNrEdicao() {
        return nrEdicao;
    }

    public void setNrEdicao(int nrEdicao) {
        this.nrEdicao = nrEdicao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getNrPaginas() {
        return nrPaginas;
    }

    public void setNrPaginas(int nrPaginas) {
        this.nrPaginas = nrPaginas;
    }
}
