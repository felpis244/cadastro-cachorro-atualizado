package com.CDC.app;

// imports
import com.CDC.model.Cachorro;
import com.CDC.model.Dono;
import com.CDC.repository.CachorroRepository;
import com.CDC.util.Validacoes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // criar repositório para armazenar os cachorros
        CachorroRepository repositorio = new CachorroRepository();

        // criar scanner para receber input do usuário
        Scanner scanner = new Scanner(System.in);

        boolean sair = false; // variável de controle do menu

        while (!sair) { // loop principal do menu
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar cachorro");
            System.out.println("2 - Listar cachorros");
            System.out.println("3 - Buscar cachorro por nome");
            System.out.println("4 - Atualizar cachorro");
            System.out.println("5 - Remover cachorro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = Validacoes.validarOpcaoMenu(scanner, 0, 5);
            scanner.nextLine(); // limpar buffer do scanner

            // ---------------------- CADASTRO ----------------------
            if (opcao == 1) {
                System.out.print("Nome do cachorro: ");
                String nomeC = scanner.nextLine();
                // validação do nome: apenas letras e espaços
                if (!Validacoes.validarNome(nomeC)) {
                    System.out.println("Nome inválido! Apenas letras.");
                    continue; // volta ao menu principal
                }

                System.out.print("Idade: ");
                int idade = scanner.nextInt();
                scanner.nextLine();
                // validação da idade: número positivo
                if (!Validacoes.validarIdade(idade)) {
                    System.out.println("Idade inválida! Digite um número positivo.");
                    continue;
                }

                System.out.print("Raça: ");
                String raca = scanner.nextLine();
                if (!Validacoes.validarRaca(raca)) {
                    System.out.println("Raça inválida! Apenas letras.");
                    continue; // volta para o menu
                }

                System.out.print("Cachorro vacinado? (sim/não): ");
                String vacinadoStr = scanner.nextLine().trim().toLowerCase(); // remove espaços e deixa em minúsculo
                boolean vacinado;

                if (vacinadoStr.equals("sim")) {
                    vacinado = true;
                } else if (vacinadoStr.equals("não") || vacinadoStr.equals("nao")) { // aceita sem acento
                    vacinado = false;
                } else {
                    System.out.println("Entrada inválida! Digite 'sim' ou 'não'.");
                    continue; // volta para o menu
                }

                System.out.print("Nome do dono: ");
                String nomeDono = scanner.nextLine();
                // validação do nome do dono
                if (!Validacoes.validarNome(nomeDono)) {
                    System.out.println("Nome do dono inválido! Apenas letras e espaços.");
                    continue;
                }

                System.out.print("Telefone do dono: ");
                String telefone = scanner.nextLine();
                // validação do telefone: apenas números
                if (!Validacoes.validarTelefone(telefone)) {
                    System.out.println("Telefone inválido! Apenas números.");
                    continue;
                }

                System.out.print("Endereço do dono: ");
                String endereco = scanner.nextLine();

                // cria objetos e salva no repositório
                Dono dono = new Dono(nomeDono, telefone, endereco);
                Cachorro cachorro = new Cachorro(nomeC, idade, raca, vacinado, dono);
                repositorio.salvar(cachorro);
                System.out.println("Cachorro cadastrado com sucesso!");
            }

            //  LISTAR 
            else if (opcao == 2) {
                // olha se tem cadastro antes de sair listando
                if (!Validacoes.verificarListaVazia(repositorio.listar().size())) {
                    System.out.println("Nada cadastrado ainda!");
                    continue;
                }

                System.out.println("\n--- Lista de Cachorros ---");
                for (Cachorro c : repositorio.listar()) {
                    System.out.println(c);
                }
            }

            //  BUSCAR POR NOME 
            else if (opcao == 3) {
                if (!Validacoes.verificarListaVazia(repositorio.listar().size())) {
                    System.out.println("Nada cadastrado ainda!");
                    continue;
                }

                System.out.print("Digite o nome do cachorro: ");
                String nomeBusca = scanner.nextLine();
                Cachorro c = repositorio.buscarPorNome(nomeBusca);
                if (c != null) {
                    System.out.println("Cachorro encontrado: " + c);
                } else {
                    System.out.println("Cachorro não encontrado.");
                }
            }

            // ATUALIZAR 
            else if (opcao == 4) {
                if (!Validacoes.verificarListaVazia(repositorio.listar().size())) {
                    System.out.println("Nada cadastrado ainda!");
                    continue;
                }

                System.out.print("Digite o nome do cachorro que deseja atualizar: ");
                String nomeAntigo = scanner.nextLine();

                System.out.print("Novo nome: ");
                String novoNome = scanner.nextLine();
                if (!Validacoes.validarNome(novoNome)) {
                    System.out.println("Nome inválido! Apenas letras e espaços.");
                    continue;
                }

                System.out.print("Nova idade: ");
                int novaIdade = scanner.nextInt();
                scanner.nextLine();
                if (!Validacoes.validarIdade(novaIdade)) {
                    System.out.println("Idade inválida! Digite um número positivo.");
                    continue;
                }

                System.out.print("Nova raça: ");
                String novaRaca = scanner.nextLine();
                if (!Validacoes.validarRaca(novaRaca)) {
                    System.out.println("Raça inválida! Apenas letras e espaços.");
                    continue;
                }

                System.out.print("Cachorro vacinado? (sim/não): ");
                String vacinadoStr = scanner.nextLine().trim().toLowerCase(); // remove espaços e deixa em minúsculo
                boolean vacinado;

                if (vacinadoStr.equals("sim")) {
                    vacinado = true;
                } else if (vacinadoStr.equals("não") || vacinadoStr.equals("nao")) { // aceita sem acento
                    vacinado = false;
                } else {
                    System.out.println("Entrada inválida! Digite 'sim' ou 'não'.");
                    continue; // volta para o menu
                }

                System.out.print("Nome do dono: ");
                String nomeDono = scanner.nextLine();
                if (!Validacoes.validarNome(nomeDono)) {
                    System.out.println("Nome do dono inválido! Apenas letras e espaços.");
                    continue;
                }

                System.out.print("Telefone do dono: ");
                String telefone = scanner.nextLine();
                if (!Validacoes.validarTelefone(telefone)) {
                    System.out.println("Telefone inválido! Apenas números.");
                    continue;
                }

                System.out.print("Endereço do dono: ");
                String endereco = scanner.nextLine();

                Dono novoDono = new Dono(nomeDono, telefone, endereco);
                Cachorro novoCachorro = new Cachorro(novoNome, novaIdade, novaRaca, vacinado, novoDono);

                boolean atualizado = repositorio.atualizar(nomeAntigo, novoCachorro);
                if (atualizado) {
                    System.out.println("Cachorro atualizado com sucesso!");
                } else {
                    System.out.println("Cachorro não encontrado.");
                }
            }

            //  REMOVER 
            else if (opcao == 5) {
                if (!Validacoes.verificarListaVazia(repositorio.listar().size())) {
                    System.out.println("Nada cadastrado ainda!");
                    continue;
                }

                System.out.print("Digite o nome do cachorro que deseja remover: ");
                String nomeRemover = scanner.nextLine();
                boolean removido = repositorio.remover(nomeRemover);
                if (removido) {
                    System.out.println("Cachorro removido com sucesso!");
                } else {
                    System.out.println("Cachorro não encontrado.");
                }
            }

            //  SAIR 
            else if (opcao == 0) {
                sair = true;
                System.out.println("Saindo...");
            }
        }

        scanner.close(); // fecha o scanner ao sair
    }
}

