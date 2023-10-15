/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.lsb.cliente.domain.repository;

import br.com.lsb.cliente.domain.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author letic
 */
public interface AlunoRepository extends JpaRepository<Aluno,Long>{
    
}
