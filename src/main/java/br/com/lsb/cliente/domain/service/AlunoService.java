/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.lsb.cliente.domain.service;

import br.com.lsb.cliente.domain.entity.Aluno;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import jakarta.persistence.metamodel.SingularAttribute;
//import java.io.Serializable;

import java.util.List;
import java.util.Optional;

//import org.springframework.data.jpa.domain.AbstractPersistable;


/**
 *
 * @author letic
 */
    @Service
    public class AlunoService {
        @Autowired
        private AlunoDAO alunoDAO;

        @Transactional
        public Aluno salvar(Aluno aluno) {
            return alunoDAO.salvar(aluno);
        }

        @Transactional
        public List<Aluno> listaAluno() {
            return alunoDAO.listarAlunos();
        }

        @Transactional
        public Optional<Aluno> buscarPorId(Long id) {
            return Optional.ofNullable(alunoDAO.buscarPorId(id));
        }

        @Transactional
        public void removerPorId(Long id) {
            alunoDAO.excluirPorId(id);
        }
    }
