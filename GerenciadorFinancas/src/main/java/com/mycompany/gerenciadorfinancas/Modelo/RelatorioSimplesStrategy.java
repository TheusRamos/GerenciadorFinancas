/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciadorfinancas.Modelo;

import com.mycompany.gerenciadorfinancas.Interface.Transacao;
import java.util.List;

/**
 *
 * @author MT
 */
public class RelatorioSimplesStrategy implements RelatorioStrategy {

    @Override
    public String gerarRelatorio(List<Transacao> transacoes) {
        double saldo = 0;
        for (Transacao t : transacoes) {
            if (t.getTipo().equalsIgnoreCase("RECEITA")) {
                saldo += t.getValor();
            } else {
                saldo -= t.getValor();
            }
        }
        return "=== Relatório Simples ===\n"
                + "Saldo Total Atual: R$ " + String.format("%.2f", saldo);
    }
}
