package Biblioteca;

import java.util.ArrayList;

public class Livro {
	//atributos
	ArrayList<Pessoa> Leitores = new ArrayList<>();
	int num;
    String titulo;
    String autor;
    int ano;
    String emprestado;
    String status;    
    boolean disponivel;
  //método construtor
    public Livro(String titulo, String autor, int ano) {		
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.status = "Disponível";
		this.emprestado = " ";
		this.Leitores = new ArrayList<>();
	}    		
    //getters e setters
	protected ArrayList<Pessoa> getLeitores() {
		return Leitores;
	}

	protected void setLeitores(ArrayList<Pessoa> leitores) {
		Leitores = leitores;
	}

	protected int getNum() {
		return num;
	}

	protected void setNum(int num) {
		this.num = num;
	}

	protected String getTitulo() {
		return titulo;
	}

	protected void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	protected String getAutor() {
		return autor;
	}

	protected void setAutor(String autor) {
		this.autor = autor;
	}

	protected int getAno() {
		return ano;
	}

	protected void setAno(int ano) {
		this.ano = ano;
	}

	protected String getEmprestado() {
		return emprestado;
	}

	protected void setEmprestado(String nome) {
		this.emprestado = nome;
	}

	protected String getStatus() {
		return status;
	}	

	protected boolean getDisponivel() {
		return disponivel;
	}

	protected void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	protected void setStatus(String status) {
		this.status = status;
	}
	//método para imprimir as informações do livro
	public void infoLivro() {
        System.out.println("===== Dados do Livro");
        System.out.println("Cod: " + this.num);
        System.out.println("Título: " + this.titulo);
        System.out.println("Autor: " + this.autor);       
        System.out.println("Ano: " + this.ano);       
        System.out.println("Status: " + this.status);
        System.out.println("Emprestado para: " + this.emprestado);
        System.out.println();
    }        	
    
}
