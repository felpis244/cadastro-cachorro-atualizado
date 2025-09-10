package com.CDC.repository;

//imports 
import com.CDC.model.Cachorro;
import java.util.ArrayList;
import java.util.List;

public class CachorroRepository {
    //lista onde iremos guardar os cachorros
    private List<Cachorro> listaCachorros;

    //contrutor
public CachorroRepository() {
        this.listaCachorros = new ArrayList<>(); //cria uma nova lista vazia na memória
    }

public void salvar(Cachorro cachorro) {
    listaCachorros.add(cachorro);
}

public List<Cachorro> listar() {
    return new ArrayList<>(listaCachorros); // devolve uma cópia
}

//COMEÇO DO NOSSO CRUD

//metodo para buscar um cachorro
 public Cachorro buscarPorNome(String nome) {
    for (Cachorro c : listaCachorros)// c variavel temporaria para buscar os cachorros que estão armazenados na listaCachorros     
    {
        if (c.getNome().equalsIgnoreCase(nome))//Aqui verificamos se o nome do cachorro c é igual ao nome que estamos procurando. 
        {
            return c; //Se o nome bate, retornamos o objeto Cachorro que encontramos
        }
    }
    return null; // se não achar
}

public boolean remover(String nome) {
    for (Cachorro c : listaCachorros) // pega o cachorro que esta procurando na lista e Verifica se o nome dele é igual ao nome que você quer, ignorando maiúsculas/minúsculas.
    {
        if (c.getNome().equalsIgnoreCase(nome)) {
            listaCachorros.remove(c);
            return true; // removeu com sucesso
        }
    }
    return false; // não encontrou
}//utilizando o boolean para dar os resultados verdadeiro ou falso (foi removido, não foi removido)

public boolean atualizar(String nome, Cachorro novoCachorro) {
    for (int i = 0; i < listaCachorros.size(); i++) {
        if (listaCachorros.get(i).getNome().equalsIgnoreCase(nome)) {
            listaCachorros.set(i, novoCachorro); // atualiza os dados do cachorro dentro da lista 
            return true; // se tudo der certo vai retornar true (o nome do cachorro vai ser atualizado)
        }
    }
    return false; // se der false é porque o nome que estava procurando para atualizar não foi encontrado
}
// i = 0 é um contador, e ele esta falando que vai começar no numero 0 da lista
// i < lista de cachorro esta falando que enquanto i for menor que o tamanho da lista vai continuar rodando
// i++ a cada vez que roda ele vai aumentar o i em 1
// if (listaCachorros.get(i).getNome().equalsIgnoreCase(nome)) se resume em se o nome do cachorro na lista for o mesmo nome que passamos para atualizar então ele vai realizar o processo de atualização 

}