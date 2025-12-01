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
public interface RelatorioStrategy {

    String gerarRelatorio(List<Transacao> transacoes);
}
