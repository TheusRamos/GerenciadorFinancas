/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciadorfinancas.Modelo;

/**
 *
 * @author MT
 */
import com.mycompany.gerenciadorfinancas.Interface.Transacao;
import java.io.Serializable;

public class TransacaoSimples implements Transacao, Serializable {

    private String descricao;
    private double valor;
    private String tipo;

    public TransacaoSimples(String descricao, double valor, String tipo) {
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public double getValor() {
        return valor;
    }

    @Override
    public String getTipo() {
        return tipo;
    }
}
