/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.gerenciadorfinancas;

import com.mycompany.gerenciadorfinancas.Controlador.FinancasController;
import com.mycompany.gerenciadorfinancas.Modelo.RelatorioDetalhadoStrategy;
import com.mycompany.gerenciadorfinancas.Modelo.RelatorioSimplesStrategy;
import java.util.Scanner;

/**
 *
 * @author MT
 */
public class GerenciadorFinancas {

    public static void main(String[] args) {
        FinancasController controller = new FinancasController();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        System.out.println("=== SISTEMA DE FINANÇAS PESSOAIS ===");

        while (opcao != 5) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Adicionar Receita");
            System.out.println("2. Adicionar Despesa");
            System.out.println("3. Ver Relatório Simples");
            System.out.println("4. Ver Relatório Detalhado");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                String ler = scanner.nextLine();
                opcao = Integer.parseInt(ler);
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite apenas números!");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Descrição da Receita: ");
                    String descRec = scanner.nextLine();
                    System.out.print("Valor da Receita: ");
                    double valRec = Double.parseDouble(scanner.nextLine());
                    controller.adicionarReceita(descRec, valRec);
                    System.out.println(">> Receita salva com sucesso!");
                    break;

                case 2:
                    System.out.print("Descrição da Despesa: ");
                    String descDesp = scanner.nextLine();
                    System.out.print("Valor da Despesa: ");
                    double valDesp = Double.parseDouble(scanner.nextLine());
                    System.out.print("Essa conta atrasou? Aplicar 10% de multa? (S/N): ");
                    String juros = scanner.nextLine();

                    boolean temJuros = juros.equalsIgnoreCase("S");
                    controller.adicionarDespesa(descDesp, valDesp, temJuros);

                    if (temJuros) {
                        System.out.println(">> Despesa salva com juros aplicados!");
                    } else {
                        System.out.println(">> Despesa salva!");
                    }
                    break;

                case 3:

                    controller.setEstrategiaRelatorio(new RelatorioSimplesStrategy());
                    System.out.println("\n" + controller.obterRelatorio());
                    break;

                case 4:

                    controller.setEstrategiaRelatorio(new RelatorioDetalhadoStrategy());
                    System.out.println("\n" + controller.obterRelatorio());
                    break;

                case 5:
                    System.out.println("Encerrando sistema... Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}
