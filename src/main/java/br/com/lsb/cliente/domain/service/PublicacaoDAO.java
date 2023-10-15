/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.lsb.cliente.domain.service;

import br.com.lsb.cliente.domain.entity.Publicacao;
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
public class PublicacaoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Publicacao salvar(Publicacao publicacao) {
        entityManager.persist(publicacao);
        return publicacao;
    }

    public List<Publicacao> listarPublicacoes() {
        String jpql = "SELECT p FROM Publicacao p";
        TypedQuery<Publicacao> query = entityManager.createQuery(jpql, Publicacao.class);
        return query.getResultList();
    }

    public Publicacao buscarPorId(Long id) {
        return entityManager.find(Publicacao.class, id);
    }

    public void excluirPorId(Long id) {
        Publicacao publicacao = entityManager.find(Publicacao.class, id);
        if (publicacao != null) {
            entityManager.remove(publicacao);
        }
    }
}