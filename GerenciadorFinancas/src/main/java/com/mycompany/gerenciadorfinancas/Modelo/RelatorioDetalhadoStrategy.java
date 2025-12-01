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
public class RelatorioDetalhadoStrategy implements RelatorioStrategy {

    @Override
    public String gerarRelatorio(List<Transacao> transacoes) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Relatório Detalhado ===\n");

        double saldo = 0;
        for (Transacao t : transacoes) {
            sb.append(String.format("[%s] %s - R$ %.2f\n",
                    t.getTipo(), t.getDescricao(), t.getValor()));

            if (t.getTipo().equalsIgnoreCase("RECEITA")) {
                saldo += t.getValor();
            } else {
                saldo -= t.getValor();
            }
        }
        sb.append("---------------------------\n");
        sb.append("Saldo Final: R$ ").append(String.format("%.2f", saldo));
        return sb.toString();
    }
}
