import java.util.ArrayList;

public class Fabrica {
	//atributos
	protected String nome;
	protected ArrayList<Cliente> Cliente = new ArrayList<>();	
	protected double totalImpostos, totalProdutos, totalGeral;
	
	//método construtor
	public Fabrica() {
		this.nome =  "Energéticos Accelerator";			
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
	//método para cáculo das vendas 
	public void calculaVendas() {
		this.totalImpostos = 0;
		this.totalProdutos = 0;
		this.totalGeral = 0;
		for(Cliente cliente : Cliente){ //para cada cliente do array é feita a soma dos valores de impostos e de produto
            this.totalImpostos += cliente.totalImpostos;
            this.totalProdutos += (cliente.produto.getValor() * cliente.pedido);
            this.totalGeral += cliente.totalValor;
        }					
	}
	//método para mostrar informações da fábrica
	public void info() {		
		System.out.println("\n===== Dados do Fábrica");
		System.out.printf("%s%.2f%n","Total Impostos: R$ ",this.totalImpostos);
		System.out.printf("%s%.2f%n","Total Mercadorias: R$ ",this.totalProdutos);
		System.out.printf("%s%.2f%n","Total Geral: R$ ",this.totalGeral);
		System.out.println("=======================");
	}
}
