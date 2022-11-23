package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.xml.crypto.Data;

import Entities.Produtos;
import Entities.ProdutosImportados;
import Entities.ProdutosUsados;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

		List<Produtos> list = new ArrayList<>();

		System.out.print("Entre com o número de produtos: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Prduct # " + i + "data: ");
			System.out.println("Comum, usado ou importado (c/u/i)? ");
			char ch = sc.next().charAt(0);
			System.out.println("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.println("Preço: ");
			double price = sc.nextDouble();

			if (ch == 'c') {
				list.add(new Produtos(name, price));

			} 
			else if (ch == 'u') {
				System.out.print("data Fabricacao (DD/MM/YYYY): ");
				Date date =  data.parse(sc.next());
				list.add(new ProdutosUsados(name, price, date));
			}
			else {
				System.out.print("taxa da alfandega: ");
				double taxa = sc.nextDouble();
				list.add(new ProdutosImportados(name, price, taxa));
			}
		}
		
		System.out.println();
		System.out.println("Etiqueta de preço: ");
		for (Produtos prod : list) {
			System.out.println(prod.etiquetaPreço());
		}

		sc.close();
	}

}
