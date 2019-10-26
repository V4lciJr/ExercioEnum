package Entities;

public class OrderItem {
	 	
		// Definição dos atributos normais da classe
		private Integer quantity;
		private Double price;
		
		// Composição tem um, ou seja uma classe OrderItem, tem um produto
		private Product product;
		
		// Construtor padrão da classe
		public OrderItem()
		{
			
		}
		
		// Construtor com atributos
		public OrderItem(Integer quantity, Double price, Product product)
		{
			this.quantity = quantity;
			this.price = price;
			this.product = product;
		}
		
		// Getters e setter padrão
		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}
		
		// Método que retorna o sub total da ordem de itens, preço multiplicado pela quantidade
		public Double subTotal()
		{
			return quantity * price;
		}
		
		// Método toString básico, pois possuem poucas Strings e poucos atributos
		// a serem impressos na tela e dessa forma não consumirá muita memória
		public String toString()
		{
			return product.getName()
					+", $"
					+String.format("%.2f", price)
					+", Quantity: "
					+quantity
					+", subtotal: $"
					+String.format("%.2f", subTotal());
		}
}
