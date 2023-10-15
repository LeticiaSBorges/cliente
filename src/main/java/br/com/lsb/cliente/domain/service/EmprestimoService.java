/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.lsb.cliente.domain.service;

import br.com.lsb.cliente.domain.entity.Emprestimo;
import br.com.lsb.cliente.domain.repository.EmprestimoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author letic
 */
@Service
public class EmprestimoService {
    @Autowired
    private EmprestimoDAO emprestimoDAO;

    @Transactional
    public Emprestimo salvar(Emprestimo emprestimo) {
        return emprestimoDAO.salvar(emprestimo);
    }

    public List<Emprestimo> listaEmprestimo() {
        return emprestimoDAO.listarEmprestimos();
    }

    public Optional<Emprestimo> buscarPorId(Long id) {
        return Optional.ofNullable(emprestimoDAO.buscarPorId(id));
    }

    @Transactional
    public void removerPorId(Long id) {
        emprestimoDAO.excluirPorId(id);
    }
}