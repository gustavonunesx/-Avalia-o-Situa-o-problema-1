package com.example.biblioteca.controller;

import com.example.biblioteca.banco.EmprestimoBd;
import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.model.Livro;

import java.util.List;

public class EmprestimoController {

    EmprestimoBd empRepository = new EmprestimoBd();

    //metodo para mostrar todos os emprestimos
    public List<Emprestimo> getAll(){
        return empRepository.findAll();
    }

    //mostrar por data final
    public List<Emprestimo> getByData(String dataFim){
        return empRepository.findByDate(dataFim);
    }



    //inserir emprestimo
    public boolean insert (Emprestimo emprestimo){
        return empRepository.insert(emprestimo);
    }

    //inserir livro em emprestimo existente
    public Emprestimo insertLivro(Long idEmprestimo, Livro livro){
        return empRepository.insertLivro(idEmprestimo, livro);
    }

    //atualizar data final
    public boolean updateFinalData(Long idEmprestimo, String novaDataFim) {
        return empRepository.updateFinalData(idEmprestimo, novaDataFim);
    }



    //deletar emrpstimo

    public boolean delete(Long idEmprestimo) {
        return empRepository.delete(idEmprestimo);
    }




}
