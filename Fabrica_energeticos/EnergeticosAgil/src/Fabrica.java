import java.util.ArrayList;

public class Fabrica {
	//atributos
	protected String nome;
	protected ArrayList<Cliente> Cliente = new ArrayList<>();	
	protected double totalImpostos, totalProdutos, totalGeral;
	
	//m�todo construtor
	public Fabrica() {
		this.nome =  "Energ�ticos Accelerator";			
	}

	protected ArrayList<Cliente> getCliente() {
		return Cliente;
	}

	protected void setCliente(ArrayList<Cliente> cliente) {
		Cliente = cliente;
	}

	protected double getTotalImpostos() {
		return totalImpostos;
	}

	protected void setTotalImpostos(double totImpostos) {
		this.totalImpostos = totImpostos;
	}

	protected double getTotalProdutos() {
		return totalProdutos;
	}

	protected void setTotalProdutos(double totalProdutos) {
		this.totalProdutos = totalProdutos;
	}

	protected double getTotalGeral() {
		return totalGeral;
	}

	protected void setTotalGeral(double totalGeral) {
		this.totalGeral = totalGeral;
	}	
	//m�todo para c�culo das vendas 
	public void calculaVendas() {
		this.totalImpostos = 0;
		this.totalProdutos = 0;
		this.totalGeral = 0;
		for(Cliente cliente : Cliente){ //para cada cliente do array � feita a soma dos valores de impostos e de produto
            this.totalImpostos += cliente.totalImpostos;
            this.totalProdutos += (cliente.produto.getValor() * cliente.pedido);
            this.totalGeral += cliente.totalValor;
        }					
	}
	//m�todo para mostrar informa��es da f�brica
	public void info() {		
		System.out.println("\n===== Dados do F�brica");
		System.out.printf("%s%.2f%n","Total Impostos: R$ ",this.totalImpostos);
		System.out.printf("%s%.2f%n","Total Mercadorias: R$ ",this.totalProdutos);
		System.out.printf("%s%.2f%n","Total Geral: R$ ",this.totalGeral);
		System.out.println("=======================");
	}
}
