package com.example.biblioteca.banco;

import com.example.biblioteca.model.Cliente;
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
                .filter(e -> e.getIdEmprestimo() == idEmprestimo)
                .findFirst()
                .orElse(null);

        if (emprestimo == null){
            return null;
        }

        emprestimo.getLivros().add(livro);

        return emprestimo;
    }



    //atualizar DATA FINAL
    public boolean updateFinalData(String dataFim){
       Emprestimo emprestimo = emprestimos.stream()
               .filter(e -> e.getDataFim() == dataFim)
               .findFirst()
               .orElse(null);

        if (emprestimo == null){
            return false;
        }

        emprestimo.setDataFim(emprestimo.getDataFim());

        return  true;
    }

    //deletar emprestimo

    public boolean delete(Long idEmprestimo){
        Emprestimo emprestimoBd = emprestimos.stream()
                .filter(e -> e.getIdEmprestimo() == idEmprestimo)
                .findFirst()
                .orElse(null);

        emprestimos.remove(emprestimoBd);

        return true;
    }


}
