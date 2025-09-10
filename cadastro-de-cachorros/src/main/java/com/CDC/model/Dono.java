package com.CDC.model;

public class Dono {
    //vamos utilizar atributos privados pois queremos protejer os dados do nosso cliente
    private String nome;
    private String telefone;
    private String endereco;


public Dono (String nome, String telefone, String endereco) {
    this.nome = nome;
    this.telefone = telefone;
    this.endereco = endereco;
}

// Getters
public String getNome() { 
    return nome; }
public String getTelefone() { 
    return telefone; }
public String getEndereco() { 
    return endereco; }

// Setters
public void setNome(String nome) { 
    this.nome = nome; }
public void setTelefone(String telefone) { 
    this.telefone = telefone; }
public void setEndereco(String endereco) { 
    this.endereco = endereco; }

// nosso toString serve para imprimirmos de forma mais bonita o objeto sem ter que escrever cada atributo    
@Override
public String toString() {
    return "Nome: " + nome + ", Telefone: " + telefone + ", Endereço: " + endereco;
}

}

