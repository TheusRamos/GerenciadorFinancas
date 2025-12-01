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
public abstract class TransacaoDecorator implements Transacao {

    protected Transacao transacaoDecorada;

    public TransacaoDecorator(Transacao transacao) {
        this.transacaoDecorada = transacao;
    }

    @Override
    public String getTipo() {
        return transacaoDecorada.getTipo();
    }
}
