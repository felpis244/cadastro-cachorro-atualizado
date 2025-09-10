package com.CDC.model;

public class Cachorro {
    private String nome ;
    private int idade; 
    private String raca;
    private boolean statusVacinacao;
    private Dono dono; //nossa composição onde esta erdando de outro objeto 

public Cachorro(String nome, int idade, String raca, boolean statusVacinacao, Dono dono ) {
    this.nome = nome;
    this.idade = idade;
    this.raca = raca; 
    this.statusVacinacao = statusVacinacao;
    this.dono = dono;
}

//getters e setters 

public String getNome() {
     return nome; }

public void setNome(String nome) {
     this.nome = nome; }

public int getIdade() {
     return idade; }

public void setIdade(int idade) {
     this.idade = idade; }

public String getRaca() {
     return raca; }

public void setRaca(String raca) {
     this.raca = raca; }

public boolean isStatusVacinacao()  { // porque is ao inves de  get: pode sim usar get porem is é mais usado no mercado para boolean pois é mais facil de ler no codigo e é uma semantica
     return statusVacinacao; }

public void setStatusVacinacao(boolean statusVacinacao) {
     this.statusVacinacao = statusVacinacao; }

public Dono getDono() {
     return dono; }

public void setDono(Dono dono) {
     this.dono = dono; }



@Override
public String toString() {
    return "Nome: " + nome +
           ", Idade: " + idade +
           ", Raça: " + raca +
           ", Vacinado: " + (statusVacinacao ? "Sim" : "Não") +
           ", Dono: [" + dono.toString() + "]";
}
//Aqui usamos dono.toString() para incluir os dados do Dono.
//Isso é o que chamamos de composição
}