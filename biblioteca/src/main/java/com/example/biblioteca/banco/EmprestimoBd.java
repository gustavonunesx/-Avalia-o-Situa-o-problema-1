package com.example.biblioteca.banco;

import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class EmprestimoBd {

    public List<Emprestimo> emprestimos;

   public EmprestimoBd(){
       this.emprestimos = new ArrayList<>();
   }

   //buscar todos emprestimos realizados
    public  List<Emprestimo> findAll(){
       //retorna apenas lista completa dos emprestimos
       return new ArrayList<>(emprestimos);
    }

    //buscar por data final
    public List<Emprestimo> findByDate(String dataFim){
       return emprestimos.stream()
               .filter(e -> e.getDataFim().equals(dataFim))
               .toList();

    }


    //inserir um emprestimo
    public boolean insert (Emprestimo emprestimo){
       emprestimos.add(emprestimo);
       return true;
    }

    //inserir outro livro em um emprestimo existente
    public Emprestimo insertLivro(Long idEmprestimo, Livro livro){
        Emprestimo emprestimo = emprestimos.stream()
                .filter(e -> e.getIdEmprestimo().equals(idEmprestimo))
                .findFirst()
                .orElse(null);

        if (emprestimo == null){
            return null;
        }

        emprestimo.getLivros().add(livro);

        return emprestimo;
    }



    //atualizar DATA FINAL
    public boolean updateFinalData(Long idEmprestimo, String novaDataFim) {
        Emprestimo emprestimo = emprestimos.stream()
                .filter(e -> e.getIdEmprestimo().equals(idEmprestimo))
                .findFirst()
                .orElse(null);

        if (emprestimo == null) {
            return false; // Retorna falso se o empréstimo não for encontrado
        }

        emprestimo.setDataFim(novaDataFim); // Atualiza a data final
        return true;
    }


    //deletar emprestimo

    public boolean delete(Long idEmprestimo) {
        Emprestimo emprestimo = emprestimos.stream()
                .filter(e -> e.getIdEmprestimo().equals(idEmprestimo))
                .findFirst()
                .orElse(null);

        if (emprestimo == null) {
            return false; // Retorna falso se não encontrar o empréstimo
        }

        emprestimos.remove(emprestimo);
        return true; // Retorna verdadeiro se deletou com sucesso
    }



}
