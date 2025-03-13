package com.example.biblioteca.model;

import java.util.ArrayList;

public class Emprestimo {

    private Long idEmprestimo;
    private String dataInicio;
    private String dataFim;
    private ArrayList<Livro> livros;
    private Cliente cliente;

    public Emprestimo(Long idEmprestimo, String dataInicio, String dataFim, ArrayList<Livro> livros, Cliente cliente) {
        this.idEmprestimo = idEmprestimo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.livros = livros;
        this.cliente = cliente;
    }

    public Long getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Long idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
