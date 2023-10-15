/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.lsb.cliente.domain.http.controller.example;

import br.com.lsb.cliente.domain.entity.Aluno;
import br.com.lsb.cliente.domain.entity.Emprestimo;
import br.com.lsb.cliente.domain.entity.Publicacao;
import br.com.lsb.cliente.domain.service.AlunoService;
import br.com.lsb.cliente.domain.service.EmprestimoService;
import br.com.lsb.cliente.domain.service.PublicacaoService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author letic
 */
@RestController
@RequestMapping("/cliente/emprestimo/exemplo")
    public class EmprestimoExampleController {
    @Autowired
    private EmprestimoService emprestimoService;
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private PublicacaoService publicacaoService;

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Emprestimo> criarEmprestimosExemplo() {
        List<Emprestimo> emprestimosCriados = new ArrayList();

        // Três alunos de exemplo
        Aluno aluno1 = new Aluno();
        aluno1.setNome("Leticia de Sousa Borges");
        aluno1.setMatricula("20220792102");
        alunoService.salvar(aluno1);

        Aluno aluno2 = new Aluno();
        aluno2.setNome("José Aldo da Silva");
        aluno2.setMatricula("20220792105");
        alunoService.salvar(aluno2);

        Aluno aluno3 = new Aluno();
        aluno3.setNome("Ana Carolina Sousa");
        aluno3.setMatricula("20220792106");
        alunoService.salvar(aluno3);

        // Três publicações de exemplo
        Publicacao publicacao1 = new Publicacao();
        publicacao1.setCodigo(1);
        publicacao1.setTitulo("A arte da estatística: Como aprender a partir de dados");
        publicacao1.setAno(2022);
        publicacao1.setAutor("David Spiegelhalter");
        publicacao1.setTipo("Estatística");
        publicacaoService.salvar(publicacao1);

        Publicacao publicacao2 = new Publicacao();
        publicacao2.setCodigo(2);
        publicacao2.setTitulo("O andar do bêbado: Como o acaso determina nossas vidas");
        publicacao2.setAno(2009);
        publicacao2.setAutor("Leonard Mlodinow");
        publicacao2.setTipo("Estatística");
        publicacaoService.salvar(publicacao2);

        Publicacao publicacao3 = new Publicacao();
        publicacao3.setCodigo(3);
        publicacao3.setTitulo("Python Para Data Science Para Leigos");
        publicacao3.setAno(2020);
        publicacao3.setAutor("Luca Massaron");
        publicacao3.setTipo("Ciências de Dados");
        publicacaoService.salvar(publicacao3);

        // Três empréstimos diferentes
        Emprestimo emprestimo1 = new Emprestimo();
        emprestimo1.setAluno(aluno1);
        emprestimo1.setPublicacao(publicacao1);
        emprestimo1.setDtemprestimo(LocalDate.now());
        emprestimo1.setDtdevolucao(LocalDate.now().plusDays(14)); // Devolução em 14 dias
        emprestimosCriados.add(emprestimoService.salvar(emprestimo1));

        Emprestimo emprestimo2 = new Emprestimo();
        emprestimo2.setAluno(aluno2);
        emprestimo2.setPublicacao(publicacao2);
        emprestimo2.setDtemprestimo(LocalDate.now());
        emprestimo2.setDtdevolucao(LocalDate.now().plusDays(10)); // Devolução em 10 dias
        emprestimosCriados.add(emprestimoService.salvar(emprestimo2));

        Emprestimo emprestimo3 = new Emprestimo();
        emprestimo3.setAluno(aluno3);
        emprestimo3.setPublicacao(publicacao3);
        emprestimo3.setDtemprestimo(LocalDate.now());
        emprestimo3.setDtdevolucao(LocalDate.now().plusDays(12)); // Devolução em 12 dias
        emprestimosCriados.add(emprestimoService.salvar(emprestimo3));

        return emprestimosCriados;
    }
    
    @PutMapping("/atualizar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarEmprestimo(@PathVariable("id") Long id, @RequestBody Emprestimo emprestimo) {
        Emprestimo emprestimoExistente = emprestimoService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empréstimo não encontrado."));

        // Atualize os campos necessários do empréstimo existente com base no empréstimo recebido no corpo da solicitação.
        emprestimoExistente.setDtemprestimo(emprestimo.getDtemprestimo());
        emprestimoExistente.setDtdevolucao(emprestimo.getDtdevolucao());

        emprestimoService.salvar(emprestimoExistente);
    }

    @DeleteMapping("/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarEmprestimo(@PathVariable("id") Long id) {
        emprestimoService.removerPorId(id);
    }

    @GetMapping("/consultar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Emprestimo consultarEmprestimo(@PathVariable("id") Long id) {
        return emprestimoService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empréstimo não encontrado."));
    }
    
    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<Emprestimo> listarEmprestimos() {
        return emprestimoService.listaEmprestimo();
    }
}
