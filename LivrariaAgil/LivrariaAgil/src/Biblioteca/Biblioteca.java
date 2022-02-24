package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
	//atributos
	static ArrayList<Livro> Acervo = new ArrayList<>();		
	static ArrayList<Pessoa> Socios = new ArrayList<>();
	//método para adicionar um livro no array e setar o código do livro
	public static void adicionaLivro(Livro novoLivro) {		
		Acervo.add(novoLivro);
		novoLivro.setNum(Acervo.size());
	}
	//método para adicionar um sócio no array e setar o código do sócio
	public static void adicionaSocio(Pessoa novoSocio) {
		Socios.add(novoSocio);
		novoSocio.setCodSocio(Socios.size());
	}
	//método para listar os livros do acervo
	public static void listaAcervo() {
		System.out.println("=== Livros da Biblioteca ===\n");
		Livro b;
		for(int i = 0; i < Acervo.size(); i++) {
			b = Acervo.get(i);
			b.infoLivro();
		}		
	}
	//método para listar os sócios
	public static void listaSocios() {
		System.out.println("=== Sócios da Biblioteca ===\n");
		Pessoa socios;
		for(int i = 0; i < Socios.size(); i++) {
			socios = Socios.get(i);
			socios.info();
		}		
	}
	//método para o empréstimo de livros
	public static void emprestarLivro(Pessoa socio, Livro livro) {
		if(livro.getStatus().equals("Disponível")) {//verifica se o livro está disponível
			socio.retirarLivro(livro);					//chama o método retirarLivro
			System.out.println("Título "+livro.getTitulo()+" emprestado para "+socio.getNome()+ " com sucesso!\n");
		} else {
			System.out.println("Título indisponível!\n");
		}
	}
	//MENU DO USUÁRIO
	public static void abrirMenu() {		
		System.out.println("      Biblioteca Ágil ");
		System.out.println("   --------------------------");
		System.out.println("       MENU DE OPÇÕES:");
		System.out.println("   --------------------------");
		System.out.println("   [1] - Retirar um livro");
		System.out.println("   [2] - Devolver um livro");
		System.out.println("   [3] - Listar acervo");
		System.out.println("   [4] - Buscar livros por título");
		System.out.println("   [5] - Doar um livro");
		System.out.println("   [0] - Encerrar atividades");		
		System.out.println("  \n   Digite a sua opção: ");		
	    }	    
	//método main
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//variáveis globais
		int opcao, ano, cod, codSocio;
		String titulo, autor, nome;		
		//criando os objetos do tipo Livro que já constam no sistema
		Livro L1 = new Livro("Como fazer sentido e bater o martelo" , "Alexandro Aolchique" , 2017);
        adicionaLivro(L1);
        Livro L2 = new Livro("Sejamos todos feministas" , "Chimamanda Ngozi Adichie" , 2015);
        adicionaLivro(L2);
        Livro L3 = new Livro("Basquete 101" , "Hortência Marcari" , 2015);
        adicionaLivro(L3);
		
		abrirMenu();
		opcao = input.nextInt();
		input.nextLine();
		//enquanto o usuário não digitar a opção zero
		while (opcao != 0) {
			if(opcao == 1) {
				//variáveis locais
				Livro livro = null;
				Pessoa socio = null;
				boolean contem = false;
				
				System.out.println("Digite o código do sócio ou digite [0] para novo sócio: "); codSocio = input.nextInt(); input.nextLine();
				//assume-se que os sócios tem uma carteirinha com um código de identificação
				if(codSocio == 0) {		
					System.out.println("Informe seu nome: "); nome = input.nextLine();
					adicionaSocio(socio = new Pessoa(nome));	//cria um novo sócio
					System.out.println("\nSócio cadastrado com sucesso!\n");
					socio.info();
					
				} else if(codSocio > Socios.size()){				
					System.out.println("Código não encontrado!\n"); 
					continue;		
					
				} else {
					for(int i = 0; i < Socios.size(); i++) {	//busca o sócio existente através do código
						if(Socios.get(i).getCodSocio() == codSocio) {
							socio = Socios.get(i);
						}
					}
				}						
				listaAcervo();				
				System.out.println("Digite o código do livro que deseja retirar:"); cod = input.nextInt(); 
				for(int i = 0; i < Acervo.size(); i++) {		//busca pelo livro no acervo através do código
					if(Acervo.get(i).getNum() == cod) {
						livro = Acervo.get(i);
						contem = true;							// variável auxiliar para verificar se foi encontrado o livro
					}
				}
				if(contem == false) {							// caso não encontre o livro no acervo
					System.out.println("Livro não encontrado!\n");					
				} else {
					emprestarLivro(socio,livro);				//se encontrar chama o método para emprestar o livro
				}
			}
			
			if(opcao == 2) {
				Pessoa socio = null;				
				ArrayList <Livro> aux = new ArrayList(); // array para auxiliar na busca pelos livros em posse do sócio
				
				System.out.println("Digite o código do sócio: "); codSocio = input.nextInt(); 				
				if(codSocio > Socios.size() || codSocio == 0){		//descarta códigos inválidos
					System.out.println("Código não encontrado!\n"); 
					continue;						
				}							
				for(int i = 0; i < Socios.size(); i++) {					
					if(Socios.get(i).getCodSocio() == codSocio) {	//busca o sócio através do código
						socio = Socios.get(i);						
					}
				}		
				for(int i = 0; i < socio.getLidos().size(); i++) {
					if(socio.getLidos().get(i).disponivel == false) {	//verifica entre os livros lidos pelo sócio os que estão em sua posse					
						aux.add(socio.getLidos().get(i));				//salva no arraylist auxiliar os livros encontrados
						socio.getLidos().get(i).infoLivro();			//mostra ao usuário as informações dos livros que ele tem que devolver
					}
				}
				System.out.println("Digite o código do livro que deseja devolver: "); cod = input.nextInt();
				for(int i = 0; i < aux.size(); i++) {
					if(aux.get(i).getNum() == cod) {		//busca no arraylist auxiliar o código do livro que o sócio vai devolver
						socio.devolverLivro(aux.get(i));	//chama o método para devolução
						System.out.println("Livro "+ aux.get(i).getTitulo()+" devolvido com sucesso!\n ");
					}					
				}
			}
			
			if(opcao == 3) {
				listaAcervo();
			}
			
			if(opcao == 4) {
				System.out.println("Digite o título que deseja consultar:"); titulo = input.nextLine();
				boolean contem = false;
				for(int i = 0; i < Acervo.size(); i++) {
					if(Acervo.get(i).getTitulo().contains(titulo)) { 	//busca no acervo títulos que contenham a palavra digitada
						contem = true;									// variável auxiliar para verificar se foi encontrado o livro
						Acervo.get(i).infoLivro();						// retorna as informações do livro encontrado
					}
				}
				if (contem == false) {									// caso não encontre nenhum título
					System.out.println("Título indisponível!\n");
				}
			}
			
			if(opcao == 5) {
				Livro livro = null;
				System.out.println("Digite o título do livro:"); titulo = input.nextLine();
				System.out.println("Digite o nome do autor:"); autor = input.nextLine();
				System.out.println("Digite o ano do livro:"); ano = input.nextInt();
				
				adicionaLivro(livro = new Livro(titulo, autor, ano)); // cria um novo livro para o acervo
				System.out.println("Agradecemos a doação do título "+titulo+ "!\n");				
			}
			abrirMenu();
			opcao = input.nextInt();
			input.nextLine();
		}
		System.out.println("Sistema encerrado!");		
	}
}
