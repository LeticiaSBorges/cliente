/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.lsb.cliente.domain.service;

import br.com.lsb.cliente.domain.entity.Emprestimo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author letic
 */
    @Repository
    public class EmprestimoDAO {

        @PersistenceContext
        private EntityManager entityManager;

        public Emprestimo salvar(Emprestimo emprestimo) {
            entityManager.persist(emprestimo);
            return emprestimo;
        }

        public List<Emprestimo> listarEmprestimos() {
            String jpql = "SELECT e FROM Emprestimo e";
            TypedQuery<Emprestimo> query = entityManager.createQuery(jpql, Emprestimo.class);
            return query.getResultList();
        }

        public Emprestimo buscarPorId(Long id) {
            return entityManager.find(Emprestimo.class, id);
        }

        public void excluirPorId(Long id) {
            Emprestimo emprestimo = entityManager.find(Emprestimo.class, id);
            if (emprestimo != null) {
                entityManager.remove(emprestimo);
            }
        }
    }