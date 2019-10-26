package Entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entities.enums.OrderStatus;

public class Order {
		
		// Definição de atributos para tratamento de datas, de modo estático
		private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		
		// Atributos normais da Classe
		private Date moment;
		private OrderStatus status;
		
		// Composição tem um, ou seja uma classe ordem tem um cliente
		private Client client;
		
		// Composião tem vários, uma classe ordem, tem várias Ordens Itens
		private List<OrderItem> items = new ArrayList<>();
		
		// Construtor padrão da classe
		public Order()
		{
			
		}
		
		// Constrtutor com atributos
		public Order(Date moment, OrderStatus status, Client client)
		{
			this.moment = moment;
			this.client = client;
			this.status = status;
		}
		
		// Getters e setters padrão
		public Date getMoment() {
			return moment;
		}

		public void setMoment(Date moment) {
			this.moment = moment;
		}

		public OrderStatus getStatus() {
			return status;
		}

		public void setStatus(OrderStatus status) {
			this.status = status;
		}

		public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}
		
		public List<OrderItem> getItem()
		{
			return items;
		}
		/* Foi retirado o método setItem, pois não podemos permitir que a lista de ordens
		 * seja trocada e dessa forma criando uma nova lista de ordens 
		 * e tirando a associação com cliente, portanto para adicioar e remover itens,
		 * foram adicionados os métodos addItem e removeItem.
		 */
		public void addItem(OrderItem item)
		{
			items.add(item);
		}
		
		public void removeItem(OrderItem item)
		{
			items.remove(item);
		}
		
		// Método onde calcula o total da ordem de pagamento de acordo com
		// a lista de itens do cliente
		public Double total()
		{
			double sum = 0.0;
			for(OrderItem item: items)
			{
				sum += item.subTotal();
			}
			
			return sum;
		}
		
		// Método toString usando a classe String Builder para o processo ser mais rápido
		// e consumir menos memória
		public String toString()
		{
			StringBuilder sb = new StringBuilder();
			sb.append("ORDER SUMARY:\n");
			sb.append("Order Moment ");
			sb.append(sdf.format(moment) +"\n");
			sb.append("Order Status: ");
			sb.append(status +"\n");
			sb.append("Client: ");
			sb.append(client.getName() +" ");
			sb.append("("+sdf2.format(client.getBirthDate())+")" +" - ");
			sb.append(client.getEmail() +"\n");
			sb.append("Order Items: \n");
			for(OrderItem it: items)
			{
				sb.append(it +"\n");
			}
			sb.append("Total price: $");
			sb.append(String.format("%.2f", total()) +"\n");
			
			
			return sb.toString();
		}
	
	}
