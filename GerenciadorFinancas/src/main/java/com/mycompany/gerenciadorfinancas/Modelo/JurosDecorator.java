/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciadorfinancas.Modelo;

import com.mycompany.gerenciadorfinancas.Interface.Transacao;

/**
 *
 * @author MT
 */
public class JurosDecorator extends TransacaoDecorator {

    public JurosDecorator(Transacao transacao) {
        super(transacao);
    }

    @Override
    public String getDescricao() {
        return transacaoDecorada.getDescricao() + " (Com Juros/Multa)";
    }

    @Override
    public double getValor() {

        return transacaoDecorada.getValor() * 1.10;
    }
}
