/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.lsb.cliente.domain.repository;

import br.com.lsb.cliente.domain.entity.Publicacao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author letic
 */

public interface PublicacaoRepository extends JpaRepository<Publicacao,Long>{
    
}
