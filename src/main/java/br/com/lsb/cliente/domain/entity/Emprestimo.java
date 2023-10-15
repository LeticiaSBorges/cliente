/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.lsb.cliente.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author letic
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
   
    @ManyToOne
    @JoinColumn(name="idaluno")
    private Aluno aluno;
    
    @ManyToOne
    @JoinColumn(name="idpublicacao")
    private Publicacao publicacao;
    
    @Column(name= "dtdevolucao")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dtdevolucao;
    
    @Column(name= "dtemprestimo")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dtemprestimo;
    
    
    
}
