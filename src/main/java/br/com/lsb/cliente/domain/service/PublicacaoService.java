/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.lsb.cliente.domain.service;


import br.com.lsb.cliente.domain.entity.Publicacao;
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
public class PublicacaoService {
    @Autowired
    private PublicacaoDAO publicacaoDAO;

    @Transactional
    public Publicacao salvar(Publicacao publicacao) {
        return publicacaoDAO.salvar(publicacao);
    }

    @Transactional
    public List<Publicacao> listaPublicacao() {
        return publicacaoDAO.listarPublicacoes();
    }

    @Transactional
    public Optional<Publicacao> buscarPorId(Long id) {
        return Optional.ofNullable(publicacaoDAO.buscarPorId(id));
    }

    @Transactional
    public void removerPorId(Long id) {
        publicacaoDAO.excluirPorId(id);
    }
}
