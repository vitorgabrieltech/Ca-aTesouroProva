package com.bn.funcionario.controllers;


import com.bn.funcionario.models.FuncionarioModel;
import com.bn.funcionario.services.FuncionarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioServices funcionarioServices;

    @GetMapping
    public ResponseEntity<List<FuncionarioModel>> findAll(){
        return ResponseEntity.ok(funcionarioServices.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioModel> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(funcionarioServices.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<FuncionarioModel> criarFuncionario(@RequestBody FuncionarioModel funcionarioModel){
        FuncionarioModel response = funcionarioServices.criarPessoa(funcionarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioModel> atualizar(@PathVariable Long id, @RequestBody FuncionarioModel funcionarioModel){
        return ResponseEntity.ok(funcionarioServices.atualizar(id, funcionarioModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        funcionarioServices.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
