/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciadorfinancas.Modelo;

import com.mycompany.gerenciadorfinancas.Interface.Transacao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MT
 */
public class RepositorioDados {

    private static RepositorioDados instancia;
    private List<Transacao> transacoes;

    private final String ARQUIVO = "Banco.txt";

    private RepositorioDados() {
        transacoes = new ArrayList<>();
        carregarDados();
    }

    public static RepositorioDados getInstancia() {
        if (instancia == null) {
            instancia = new RepositorioDados();
        }
        return instancia;
    }

    public void adicionarTransacao(Transacao t) {
        transacoes.add(t);
        salvarDados();
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    private void salvarDados() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Transacao t : transacoes) {

                writer.write(t.getTipo() + ";" + t.getDescricao() + ";" + t.getValor());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    private void carregarDados() {
        File file = new File(ARQUIVO);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    String tipo = partes[0];
                    String descricao = partes[1];
                    double valor = Double.parseDouble(partes[2]);

                    Transacao t = new TransacaoSimples(descricao, valor, tipo);
                    transacoes.add(t);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Erro ao carregar dados: " + e.getMessage());
        }
    }
}
