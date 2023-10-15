/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.lsb.cliente.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

public class Publicacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name="codigo")
    private Integer codigo;
    
    @Column(name= "titulo", length= 100)
    private String titulo;
    
    @Column(name="ano")
    private Integer ano;
    
    @Column(name= "autor", length= 100)
    private String autor;
    
    @Column(name = "tipo", length = 100)
    private String tipo;

}
