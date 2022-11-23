package Entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutosUsados extends Produtos {
	
	private static final SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date dataFabricacao;

	public ProdutosUsados(String name, Double price, Date dataFabricacao) {
		super(name, price);
		this.dataFabricacao = dataFabricacao;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	
	@Override
	public String etiquetaPreço() {
		return getName()
				+ "(used)  $ " +
				String.format("%.2f", getPrice())
				+ "(data fabricacao: " 
				+data.format(dataFabricacao) 
				+ ")";
	}	
	
}
