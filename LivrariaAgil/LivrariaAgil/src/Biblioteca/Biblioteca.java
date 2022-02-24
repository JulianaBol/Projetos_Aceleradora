package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
	//atributos
	static ArrayList<Livro> Acervo = new ArrayList<>();		
	static ArrayList<Pessoa> Socios = new ArrayList<>();
	//m�todo para adicionar um livro no array e setar o c�digo do livro
	public static void adicionaLivro(Livro novoLivro) {		
		Acervo.add(novoLivro);
		novoLivro.setNum(Acervo.size());
	}
	//m�todo para adicionar um s�cio no array e setar o c�digo do s�cio
	public static void adicionaSocio(Pessoa novoSocio) {
		Socios.add(novoSocio);
		novoSocio.setCodSocio(Socios.size());
	}
	//m�todo para listar os livros do acervo
	public static void listaAcervo() {
		System.out.println("=== Livros da Biblioteca ===\n");
		Livro b;
		for(int i = 0; i < Acervo.size(); i++) {
			b = Acervo.get(i);
			b.infoLivro();
		}		
	}
	//m�todo para listar os s�cios
	public static void listaSocios() {
		System.out.println("=== S�cios da Biblioteca ===\n");
		Pessoa socios;
		for(int i = 0; i < Socios.size(); i++) {
			socios = Socios.get(i);
			socios.info();
		}		
	}
	//m�todo para o empr�stimo de livros
	public static void emprestarLivro(Pessoa socio, Livro livro) {
		if(livro.getStatus().equals("Dispon�vel")) {//verifica se o livro est� dispon�vel
			socio.retirarLivro(livro);					//chama o m�todo retirarLivro
			System.out.println("T�tulo "+livro.getTitulo()+" emprestado para "+socio.getNome()+ " com sucesso!\n");
		} else {
			System.out.println("T�tulo indispon�vel!\n");
		}
	}
	//MENU DO USU�RIO
	public static void abrirMenu() {		
		System.out.println("      Biblioteca �gil ");
		System.out.println("   --------------------------");
		System.out.println("       MENU DE OP��ES:");
		System.out.println("   --------------------------");
		System.out.println("   [1] - Retirar um livro");
		System.out.println("   [2] - Devolver um livro");
		System.out.println("   [3] - Listar acervo");
		System.out.println("   [4] - Buscar livros por t�tulo");
		System.out.println("   [5] - Doar um livro");
		System.out.println("   [0] - Encerrar atividades");		
		System.out.println("  \n   Digite a sua op��o: ");		
	    }	    
	//m�todo main
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//vari�veis globais
		int opcao, ano, cod, codSocio;
		String titulo, autor, nome;		
		//criando os objetos do tipo Livro que j� constam no sistema
		Livro L1 = new Livro("Como fazer sentido e bater o martelo" , "Alexandro Aolchique" , 2017);
        adicionaLivro(L1);
        Livro L2 = new Livro("Sejamos todos feministas" , "Chimamanda Ngozi Adichie" , 2015);
        adicionaLivro(L2);
        Livro L3 = new Livro("Basquete 101" , "Hort�ncia Marcari" , 2015);
        adicionaLivro(L3);
		
		abrirMenu();
		opcao = input.nextInt();
		input.nextLine();
		//enquanto o usu�rio n�o digitar a op��o zero
		while (opcao != 0) {
			if(opcao == 1) {
				//vari�veis locais
				Livro livro = null;
				Pessoa socio = null;
				boolean contem = false;
				
				System.out.println("Digite o c�digo do s�cio ou digite [0] para novo s�cio: "); codSocio = input.nextInt(); input.nextLine();
				//assume-se que os s�cios tem uma carteirinha com um c�digo de identifica��o
				if(codSocio == 0) {		
					System.out.println("Informe seu nome: "); nome = input.nextLine();
					adicionaSocio(socio = new Pessoa(nome));	//cria um novo s�cio
					System.out.println("\nS�cio cadastrado com sucesso!\n");
					socio.info();
					
				} else if(codSocio > Socios.size()){				
					System.out.println("C�digo n�o encontrado!\n"); 
					continue;		
					
				} else {
					for(int i = 0; i < Socios.size(); i++) {	//busca o s�cio existente atrav�s do c�digo
						if(Socios.get(i).getCodSocio() == codSocio) {
							socio = Socios.get(i);
						}
					}
				}						
				listaAcervo();				
				System.out.println("Digite o c�digo do livro que deseja retirar:"); cod = input.nextInt(); 
				for(int i = 0; i < Acervo.size(); i++) {		//busca pelo livro no acervo atrav�s do c�digo
					if(Acervo.get(i).getNum() == cod) {
						livro = Acervo.get(i);
						contem = true;							// vari�vel auxiliar para verificar se foi encontrado o livro
					}
				}
				if(contem == false) {							// caso n�o encontre o livro no acervo
					System.out.println("Livro n�o encontrado!\n");					
				} else {
					emprestarLivro(socio,livro);				//se encontrar chama o m�todo para emprestar o livro
				}
			}
			
			if(opcao == 2) {
				Pessoa socio = null;				
				ArrayList <Livro> aux = new ArrayList(); // array para auxiliar na busca pelos livros em posse do s�cio
				
				System.out.println("Digite o c�digo do s�cio: "); codSocio = input.nextInt(); 				
				if(codSocio > Socios.size() || codSocio == 0){		//descarta c�digos inv�lidos
					System.out.println("C�digo n�o encontrado!\n"); 
					continue;						
				}							
				for(int i = 0; i < Socios.size(); i++) {					
					if(Socios.get(i).getCodSocio() == codSocio) {	//busca o s�cio atrav�s do c�digo
						socio = Socios.get(i);						
					}
				}		
				for(int i = 0; i < socio.getLidos().size(); i++) {
					if(socio.getLidos().get(i).disponivel == false) {	//verifica entre os livros lidos pelo s�cio os que est�o em sua posse					
						aux.add(socio.getLidos().get(i));				//salva no arraylist auxiliar os livros encontrados
						socio.getLidos().get(i).infoLivro();			//mostra ao usu�rio as informa��es dos livros que ele tem que devolver
					}
				}
				System.out.println("Digite o c�digo do livro que deseja devolver: "); cod = input.nextInt();
				for(int i = 0; i < aux.size(); i++) {
					if(aux.get(i).getNum() == cod) {		//busca no arraylist auxiliar o c�digo do livro que o s�cio vai devolver
						socio.devolverLivro(aux.get(i));	//chama o m�todo para devolu��o
						System.out.println("Livro "+ aux.get(i).getTitulo()+" devolvido com sucesso!\n ");
					}					
				}
			}
			
			if(opcao == 3) {
				listaAcervo();
			}
			
			if(opcao == 4) {
				System.out.println("Digite o t�tulo que deseja consultar:"); titulo = input.nextLine();
				boolean contem = false;
				for(int i = 0; i < Acervo.size(); i++) {
					if(Acervo.get(i).getTitulo().contains(titulo)) { 	//busca no acervo t�tulos que contenham a palavra digitada
						contem = true;									// vari�vel auxiliar para verificar se foi encontrado o livro
						Acervo.get(i).infoLivro();						// retorna as informa��es do livro encontrado
					}
				}
				if (contem == false) {									// caso n�o encontre nenhum t�tulo
					System.out.println("T�tulo indispon�vel!\n");
				}
			}
			
			if(opcao == 5) {
				Livro livro = null;
				System.out.println("Digite o t�tulo do livro:"); titulo = input.nextLine();
				System.out.println("Digite o nome do autor:"); autor = input.nextLine();
				System.out.println("Digite o ano do livro:"); ano = input.nextInt();
				
				adicionaLivro(livro = new Livro(titulo, autor, ano)); // cria um novo livro para o acervo
				System.out.println("Agradecemos a doa��o do t�tulo "+titulo+ "!\n");				
			}
			abrirMenu();
			opcao = input.nextInt();
			input.nextLine();
		}
		System.out.println("Sistema encerrado!");		
	}
}
