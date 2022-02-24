import java.util.Scanner;

public class NotaFiscal {	
	//menu do usu�rio
	public static void abrirMenu() {			
		System.out.println("  \n    Energ�ticos Accelerator ");
		System.out.println("   --------------------------");
		System.out.println(" Digite [1] para novo pedido ou [0] para encerrar atividades");		
		System.out.println("  \n   Digite a sua op��o: ");		
	}	    
			
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String nome;
		int pedido, opcao;	
		Fabrica f1 = new Fabrica();	
					
		abrirMenu();
		opcao = input.nextInt();
		input.nextLine();		
			
		while(opcao!=0) {	//enquanto o usu�rio n�o digitar zero
			if(opcao == 1) {
				System.out.println("Digite o nome do cliente: "); nome = input.nextLine();
				System.out.println("Digite a quantidade comprada: "); pedido = input.nextInt();
				Cliente novoCliente = new Cliente(nome, pedido);	//cria um novo objeto do tipo cliente				
				f1.Cliente.add(novoCliente);	//adiciona o novo cliente no arraylist
				f1.calculaVendas(); //chama o m�todo para realizar o c�lculo da f�brica
				f1.info();		//chama o m�todo para exibir as informa��es da f�brica
			}
			abrirMenu();
			opcao = input.nextInt();
			input.nextLine();
		}
		System.out.println("Sistema encerrado!");				
	}
}
