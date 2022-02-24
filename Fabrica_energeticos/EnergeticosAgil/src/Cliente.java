public class Cliente {
	//atributos
	protected String nome;
	protected int pedido;
	protected double totalValor, totalImpostos, icms, ipi, pis, cofins;
	protected Produto produto;
	
	//método construtor
	public Cliente(String nome, int pedido) {//entrando com o nome e pedido, cria o produto e chama o método comprar
		this.nome = nome;
		this.produto = new Produto( "Energético Accelerator", 4.5f);	
		this.pedido = pedido;
		this.comprar(pedido);				
	}
	//getters e setters
	protected String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected int getPedido() {
		return pedido;
	}

	protected void setPedido(int pedido) {
		this.pedido = pedido;
	}
	
	public void comprar(int pedido) { //verifica o tamanho do pedido, concede desconto se for o caso e chama os métodos de cálculo de impostos
		if(pedido >= 450) {
			double desc = ((this.produto.getValor() * 10)/100);
			this.produto.setValor(this.produto.getValor() - desc);			
		}
		if(pedido >= 750) {
			double desc = ((this.produto.getValor() * 15)/100);
			this.produto.setValor(this.produto.getValor() - desc);			
		}
		this.totalValor = this.pedido * (this.produto.getValor());
		calcIcms();
		calcIpi();
		calcPis();
		calcCofins();
		info();	
	}
		//métodos para cálculo dos impostos em cima do valor do pedido sobre o valor do produto na venda
	public double calcIcms() {
		this.icms = this.pedido * this.produto.calcIcms(this.produto.getValor());
		this.totalImpostos += this.icms;
		this.totalValor += this.icms;
		return this.icms;
	}
	
	public double calcIpi() {
		this.ipi = this.pedido * this.produto.calcIpi(this.produto.getValor());
		this.totalImpostos += this.ipi;
		this.totalValor += this.ipi;
		return this.ipi;
	}
	
	public double calcPis() {
		this.pis = this.pedido * this.produto.calcPis(this.produto.getValor());
		this.totalImpostos += this.pis;
		this.totalValor += this.pis;
		return this.pis;
	}
	
	public double calcCofins() {
		this.cofins = this.pedido * this.produto.calcCofins(this.produto.getValor());
		this.totalImpostos += this.cofins;
		this.totalValor += this.cofins;
		return this.cofins;
	}
	//método para mostrar informações do cliente
	public void info() {
		System.out.println("\n===== Dados do Comprador");
	    System.out.println("Nome: " + this.nome);
	    System.out.printf("%s%.2f%s%.2f%s%.2f%s%.2f%s%.2f ","ICMS: R$ " ,this.icms,"; IPI: R$ ",
	    		this.ipi,"; PIS: R$ ",this.pis,"; COFINS: R$ ",this.cofins,"; TOTAL: R$ ",this.totalValor);
	    System.out.println();  
	    
	}
}

