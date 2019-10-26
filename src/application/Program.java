package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entities.Client;
import Entities.Order;
import Entities.OrderItem;
import Entities.Product;
import Entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException{
		
		// Função para aceitar decimais separados por pontos
		Locale.setDefault(Locale.US);
		
		// Variavel de entrada e leitura de dados via teclado
		Scanner tec = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		// Entrada de dados iniciais do programa
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = tec.nextLine();
		System.out.print("Email: ");
		String email = tec.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date date = sdf.parse(tec.nextLine());
		
		// Instanciando um cliente
		Client client = new Client(name, email, date);
		
		System.out.println("Enter order data:");
		System.out.print("Status:");
		String status = tec.nextLine();
		
		// Instanciando uma ordem de serviço, passando um cliente
		// Aqui é feita a associação entre cliente e ordem de serviço
		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);
		
		// Lendo quantos itens serão adicionados a ordem
		System.out.print("How many items to this order? ");
		int n = tec.nextInt();
		
		for(int i = 1; i <= n; i++)
		{
			System.out.println("Enter #" +i +" item data: ");
			System.out.print("Product name: ");
			tec.nextLine();
			String productName = tec.nextLine();
			System.out.print("Product price: ");
			double productPrice = tec.nextDouble();
			System.out.print("Quantity: ");
			int productQuant = tec.nextInt();
			
			// Instanciando uma ordem de itens e ao mesmo tempo em seu construtor
			// Instanciando um produto
			OrderItem item = new OrderItem(productQuant, productPrice, new Product(productName, productPrice));
			
			// Adicionando essa ordem de itens para a ordem de serviço do cliente
			order.addItem(item);
			System.out.println();
		}
		
		// Imprimindo a ordem	
		System.out.println(order);
		
		tec.close();
	}

}
