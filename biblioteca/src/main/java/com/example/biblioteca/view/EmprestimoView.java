package com.example.biblioteca.view;

import com.example.biblioteca.controller.EmprestimoController;
import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.model.Livro;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoView {

    EmprestimoController emprestimoController = new EmprestimoController();


    //mostrar todos emprestimos
    @GetMapping
    public List<Emprestimo> getAll(
            @RequestParam(required = false) String dataFim
    ){
        if (dataFim != null){
            return emprestimoController.getByData(dataFim);
        }else{
            return emprestimoController.getAll();
        }
    }



    //inserir emprestimo
    @PostMapping
    public boolean insert(@RequestBody Emprestimo emprestimo) {
        return emprestimoController.insert(emprestimo);
    }

    //inserir livro em emprestimo existente
    @PostMapping("/{idEmprestimo}/livro")
    public Emprestimo insertLivro(@RequestBody Livro livro, @PathVariable Long idEmprestimo){
        return emprestimoController.insertLivro(idEmprestimo,livro);
    }

    //atualizar data final
    @PutMapping("/{dataFim}/livro")
    public boolean updateFinalData( @RequestBody Emprestimo emprestimo, @PathVariable String dataFim){
        return emprestimoController.updateFinalData(dataFim);
    }


    //deletar emprestimo
    @DeleteMapping("/{idEmprestimo}/")
    public boolean delete(@PathVariable Long idEmprestimo){
        return emprestimoController.delete(idEmprestimo);
    }



}
