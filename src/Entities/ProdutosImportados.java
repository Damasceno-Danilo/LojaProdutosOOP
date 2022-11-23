package Entities;

public class ProdutosImportados extends Produtos {
	
	private Double taxaAlfandega;

	public ProdutosImportados() {
		super();
	}

	public ProdutosImportados(String name, Double price, Double taxaAlfandega) {
		super(name, price);
		this.taxaAlfandega = taxaAlfandega;
	}

	public Double getTaxaAlfandega() {
		return taxaAlfandega;
	}

	public void setTaxaAlfandega(Double taxaAlfandega) {
		this.taxaAlfandega = taxaAlfandega;
	}
	
	public double precoTotal() {
		return getPrice() + taxaAlfandega;
	}
	
	@Override
	public String etiquetaPreço() {
		return getName()
				+ " $ " 
				+ String.format("%.2f", precoTotal())
				+ "(Taxa da alfandega $" 
				+ String.format("%.2f", taxaAlfandega)
				+ ")";

	}
	
}
