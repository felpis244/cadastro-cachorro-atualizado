package com.CDC.util;

public class Validacoes {

    public static boolean validarNome(String nome) {
        return nome != null && nome.matches("[A-Za-zÀ-ÿ ]+");
    }

    public static boolean validarRaca(String raca) {
        return raca != null && raca.matches("[A-Za-zÀ-ÿ ]+");
    }    
    public static boolean validarTelefone(String telefone) {
        return telefone != null && telefone.matches("\\d+");
    }

    public static boolean validarIdade(int idade) {
        return idade > 0 && idade <= 18;
    }

    public static boolean verificarListaVazia(int tamanhoLista) {
        return tamanhoLista > 0;
    }

    public static int validarOpcaoMenu(Scanner scanner, int min, int max) {
        int opcao;
        while (true) {
            String entrada = scanner.nextLine().trim();

            if (!entrada.matches("\\d+")) {
                continue; // ignora se não for número
            }

            opcao = Integer.parseInt(entrada);

            if (opcao < min || opcao > max) {
                continue; // ignora se for fora do intervalo
            }

            return opcao; // retorna apenas se for válido
        }
    }

}




