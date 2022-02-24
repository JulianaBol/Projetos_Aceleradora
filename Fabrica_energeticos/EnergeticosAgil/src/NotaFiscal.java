import java.util.Scanner;

public class NotaFiscal {	
	//menu do usuário
	public static void abrirMenu() {			
		System.out.println("  \n    Energéticos Accelerator ");
		System.out.println("   --------------------------");
		System.out.println(" Digite [1] para novo pedido ou [0] para encerrar atividades");		
		System.out.println("  \n   Digite a sua opção: ");		
	}	    
			
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String nome;
		int pedido, opcao;	
		Fabrica f1 = new Fabrica();	
					
		abrirMenu();
		opcao = input.nextInt();
		input.nextLine();		
			
		while(opcao!=0) {	//enquanto o usuário não digitar zero
			if(opcao == 1) {
				System.out.println("Digite o nome do cliente: "); nome = input.nextLine();
				System.out.println("Digite a quantidade comprada: "); pedido = input.nextInt();
				Cliente novoCliente = new Cliente(nome, pedido);	//cria um novo objeto do tipo cliente				
				f1.Cliente.add(novoCliente);	//adiciona o novo cliente no arraylist
				f1.calculaVendas(); //chama o método para realizar o cálculo da fábrica
				f1.info();		//chama o método para exibir as informações da fábrica
			}
			abrirMenu();
			opcao = input.nextInt();
			input.nextLine();
		}
		System.out.println("Sistema encerrado!");				
	}
}
