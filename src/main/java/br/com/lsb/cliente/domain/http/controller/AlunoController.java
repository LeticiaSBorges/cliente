package br.com.lsb.cliente.domain.http.controller;

import br.com.lsb.cliente.domain.entity.Aluno;
import br.com.lsb.cliente.domain.service.AlunoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;



@RestController
@RequestMapping("/cliente/aluno")
public class AlunoController {
    
    @Autowired
    private AlunoService alunoService;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluno salvar(@RequestBody Aluno aluno){
        return alunoService.salvar(aluno);
    }
    
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> listaAluno(){
        return alunoService.listaAluno();
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Aluno buscarAlunoPorId(@PathVariable("id") Long id){
        return alunoService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno nao encontrado."));
    }
     
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerAluno(@PathVariable("id") Long id){
        alunoService.buscarPorId(id)
                .map(aluno -> {
                    alunoService.removerPorId(aluno.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno nao encontrado."));
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarAluno(@PathVariable("id") Long id, @RequestBody Aluno aluno){
        alunoService.buscarPorId(id)
                .map(alunoBase -> {
                    modelMapper.map(aluno, alunoBase);
                    alunoService.salvar(alunoBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno nao encontrado."));
    }

   
}
