/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.lsb.cliente.domain.service;

import br.com.lsb.cliente.domain.entity.Aluno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author letic
 */

import org.springframework.stereotype.Repository;

@Repository
public class AlunoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Aluno salvar(Aluno aluno) {
        entityManager.persist(aluno);
        return aluno;
    }

    public List<Aluno> listarAlunos() {
        String jpql = "SELECT a FROM Aluno a";
        TypedQuery<Aluno> query = entityManager.createQuery(jpql, Aluno.class);
        return query.getResultList();
    }

    public Aluno buscarPorId(Long id) {
        return entityManager.find(Aluno.class, id);
    }

    public void excluirPorId(Long id) {
        Aluno aluno = entityManager.find(Aluno.class, id);
        if (aluno != null) {
            entityManager.remove(aluno);
        }
    }

    public Aluno atualizar(Aluno aluno) {
        return entityManager.merge(aluno);
    }
}
