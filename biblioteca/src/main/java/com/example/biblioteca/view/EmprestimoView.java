package com.example.biblioteca.view;

import com.example.biblioteca.controller.EmprestimoController;
import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.model.Livro;
import org.springframework.http.ResponseEntity;
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
    @PutMapping("/{idEmprestimo}/dataFim")
    public boolean updateFinalData(@PathVariable Long idEmprestimo, @RequestBody String novaDataFim) {
        return emprestimoController.updateFinalData(idEmprestimo, novaDataFim);
    }

    //deletar emprestimo
    @DeleteMapping("/{idEmprestimo}")
    public ResponseEntity<String> delete(@PathVariable Long idEmprestimo) {
        boolean sucesso = emprestimoController.delete(idEmprestimo);
        if (sucesso) {
            return ResponseEntity.ok("Empréstimo removido com sucesso!");
        } else {
            return ResponseEntity.badRequest().body("Erro: Empréstimo não encontrado.");
        }
    }
}
