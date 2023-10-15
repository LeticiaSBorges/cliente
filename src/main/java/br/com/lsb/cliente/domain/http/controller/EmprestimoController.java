/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.lsb.cliente.domain.http.controller;

import br.com.lsb.cliente.domain.entity.Emprestimo;
import br.com.lsb.cliente.domain.service.EmprestimoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;



@RestController
@RequestMapping("/cliente/emprestimo")
public class EmprestimoController {
    @Autowired
    private EmprestimoService emprestimoService;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Emprestimo salvar(@RequestBody Emprestimo emprestimo){
        return emprestimoService.salvar(emprestimo);
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Emprestimo> listaEmprestimo(){
        return emprestimoService.listaEmprestimo();
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Emprestimo buscarEmprestimoPorId(@PathVariable("id") Long id){
        return emprestimoService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Emprestimo nao encontrado."));
    }
     
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerEmprestimo(@PathVariable("id") Long id){
        emprestimoService.buscarPorId(id)
                .map(emprestimo -> {
                    emprestimoService.removerPorId(emprestimo.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Emprestimo nao encontrado."));
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarEmprestimo(@PathVariable("id") Long id, @RequestBody Emprestimo emprestimo){
        emprestimoService.buscarPorId(id)
                .map(emprestimoBase -> {
                    modelMapper.map(emprestimo, emprestimoBase);
                    emprestimoService.salvar(emprestimoBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Emprestimo nao encontrado."));
    }
}
