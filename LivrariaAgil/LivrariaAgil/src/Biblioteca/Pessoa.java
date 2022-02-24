package Biblioteca;

import java.util.ArrayList;

public class Pessoa {
	//atributos
	String nome;
	int codSocio;
	ArrayList<Livro> Lidos = new ArrayList<>();
	//método construtor
	public Pessoa(String nome) {
		this.nome = nome;
		this.Lidos = new ArrayList<>();
	}
	
	protected int getCodSocio() {
		return codSocio;
	}

	protected void setCodSocio(int codSocio) {
		this.codSocio = codSocio;
	}

	protected String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected ArrayList<Livro> getLidos() {
		return Lidos;
	}

	protected void setLidos(ArrayList<Livro> lidos) {
		Lidos = lidos;
	}
	//método para imprimir as informações do sócio
	public void info() {
		System.out.println("===== Dados do Sócio");
		System.out.println("Nome: "+this.getNome());
		System.out.println("Cod: "+this.getCodSocio());
		
	}
	//método para imprimir informações dos livros lidos pelo sócio
	public void infoLidos() {
		Livro b;
		for(int i = 0; i < Lidos.size(); i++) {
			b = Lidos.get(i);
			b.infoLivro();
		}		
	}
	//método para fazer um empréstimo de um livro
	public void retirarLivro(Livro livro) {
		this.Lidos.add(livro);					//adiciona no array de livros lidos
		livro.setDisponivel(false); 			// seta o estado do livro para indisponível
		livro.setStatus("Indisponível");		
		livro.Leitores.add(this);				//adiciona o leitor no array do livro
		livro.setEmprestado(this.getNome());	//adiciona o nome do leitor que está com o livro
	}
	//método para fazer a devolução de um livro
	public void devolverLivro(Livro livro) {
		livro.setDisponivel(true);				//retorna o status do livro para disponível
		livro.setStatus("Disponível");
		livro.setEmprestado("");				
	}	
}
