public class Produto {
	//atributos
	protected String nome;
	protected double valor, totalValor, icms, ipi, pis, cofins;
	
	//método construtor, cria o produto e chama os métodos pra cálculo de impostos 
	public Produto( String nome, double valor){
		this.nome = nome;
		this.valor = valor;	
		calcIcms(this.valor);
		calcIpi(this.valor);
		calcPis(this.valor);
		calcCofins(this.valor);
		totProduto();
	}
	//getters e setters
	protected String getNome() {
		return nome;
	}
	protected void setNome(String nome) {
		this.nome = nome;
	}
	protected double getValor() {
		return valor;
	}
	protected void setValor(double valor) {
		this.valor = valor;
	}
	
	public double calcIcms(double valor) {
		this.icms = valor * 0.18f;
		return icms;
	}
	
	public double calcIpi(double valor) {
		this.ipi = valor * 0.04f;
		return ipi;
	}
	
	public double calcPis(double valor) {
		this.pis = valor * 0.0186f;
		return pis;
	}
	
	public double calcCofins(double valor) {
		this.cofins = valor * 0.0854f;
		return cofins;
	}
	
	public void totProduto() {
		this.totalValor = (valor + icms + ipi + pis + cofins);
	}
	//método para mostrar informações do produto
	public void info() {
		System.out.println("===== Dados do Produto");
		System.out.println("Nome: " + this.nome);
		System.out.printf("%s%.2f%n","Valor unit: ",this.valor);
		System.out.printf("%s%.2f%n","Valor total: ",this.totalValor);
		System.out.println();
	}

}
	
