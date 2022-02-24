package Biblioteca;

import java.util.ArrayList;

public class Pessoa {
	//atributos
	String nome;
	int codSocio;
	ArrayList<Livro> Lidos = new ArrayList<>();
	//m�todo construtor
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
	//m�todo para imprimir as informa��es do s�cio
	public void info() {
		System.out.println("===== Dados do S�cio");
		System.out.println("Nome: "+this.getNome());
		System.out.println("Cod: "+this.getCodSocio());
		
	}
	//m�todo para imprimir informa��es dos livros lidos pelo s�cio
	public void infoLidos() {
		Livro b;
		for(int i = 0; i < Lidos.size(); i++) {
			b = Lidos.get(i);
			b.infoLivro();
		}		
	}
	//m�todo para fazer um empr�stimo de um livro
	public void retirarLivro(Livro livro) {
		this.Lidos.add(livro);					//adiciona no array de livros lidos
		livro.setDisponivel(false); 			// seta o estado do livro para indispon�vel
		livro.setStatus("Indispon�vel");		
		livro.Leitores.add(this);				//adiciona o leitor no array do livro
		livro.setEmprestado(this.getNome());	//adiciona o nome do leitor que est� com o livro
	}
	//m�todo para fazer a devolu��o de um livro
	public void devolverLivro(Livro livro) {
		livro.setDisponivel(true);				//retorna o status do livro para dispon�vel
		livro.setStatus("Dispon�vel");
		livro.setEmprestado("");				
	}	
}
