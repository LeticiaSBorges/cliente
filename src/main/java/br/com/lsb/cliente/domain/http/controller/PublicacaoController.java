/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.lsb.cliente.domain.http.controller;


import br.com.lsb.cliente.domain.entity.Publicacao;
import br.com.lsb.cliente.domain.service.PublicacaoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;



@RestController
@RequestMapping("/cliente/publicacao")
public class PublicacaoController {
    @Autowired
    private PublicacaoService publicacaoService;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publicacao salvar(@RequestBody Publicacao publicacao){
        return publicacaoService.salvar(publicacao);
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Publicacao> listaPublicacao(){
        return publicacaoService.listaPublicacao();
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publicacao buscarPublicacaoPorId(@PathVariable("id") Long id){
        return publicacaoService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Publicacao nao encontrado."));
    }
     
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerPublicacao(@PathVariable("id") Long id){
        publicacaoService.buscarPorId(id)
                .map(publicacao -> {
                    publicacaoService.removerPorId(publicacao.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Publicacao nao encontrado."));
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarPublicacao(@PathVariable("id") Long id, @RequestBody Publicacao publicacao){
        publicacaoService.buscarPorId(id)
                .map(publicacaoBase -> {
                    modelMapper.map(publicacao, publicacaoBase);
                    publicacaoService.salvar(publicacaoBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Publicacao nao encontrado."));
    }
}
