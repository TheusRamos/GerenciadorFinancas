/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciadorfinancas.Controlador;

import com.mycompany.gerenciadorfinancas.Interface.Transacao;
import com.mycompany.gerenciadorfinancas.Modelo.JurosDecorator;
import com.mycompany.gerenciadorfinancas.Modelo.RelatorioSimplesStrategy;
import com.mycompany.gerenciadorfinancas.Modelo.RelatorioStrategy;
import com.mycompany.gerenciadorfinancas.Modelo.RepositorioDados;
import com.mycompany.gerenciadorfinancas.Modelo.TransacaoSimples;

/**
 *
 * @author MT
 */
public class FinancasController {

    private RepositorioDados repositorio;
    private RelatorioStrategy estrategiaRelatorio;

    public FinancasController() {

        this.repositorio = RepositorioDados.getInstancia();

        this.estrategiaRelatorio = new RelatorioSimplesStrategy();
    }

    public void adicionarReceita(String descricao, double valor) {
        repositorio.adicionarTransacao(new TransacaoSimples(descricao, valor, "RECEITA"));
    }

    public void adicionarDespesa(String descricao, double valor, boolean aplicarJuros) {
        Transacao despesa = new TransacaoSimples(descricao, valor, "DESPESA");

        if (aplicarJuros) {
            despesa = new JurosDecorator(despesa);
        }

        repositorio.adicionarTransacao(despesa);
    }

    public void setEstrategiaRelatorio(RelatorioStrategy estrategia) {
        this.estrategiaRelatorio = estrategia;
    }

    public String obterRelatorio() {
        return estrategiaRelatorio.gerarRelatorio(repositorio.getTransacoes());
    }
}
