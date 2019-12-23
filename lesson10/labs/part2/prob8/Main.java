package lesson10.labs.part2.prob8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
	static List<OrderItem> orderItems = new ArrayList<>();
	private static List<Optional<OrderItem>> items;

	public static void main(String[] args) {
		Main m = new Main();
		m.loadOrderItemData();
		items = orderItems.stream().map(Optional::ofNullable).collect(Collectors.toList());

		System.out.println("Do any of these Order Items have an order of flowers? " + m.findProduct("Flowers"));
	}

	private boolean findProduct(String prodName) {
//		for(OrderItem item : orderItems) {
//			if(item != null) {
//				Product p=item.getProduct();
//				if(p != null) {
//					String name = p.getProductName();
//					if(name != null) {
//						if(name.equals(prodName)) return true;
//					}
//				}
//			}
//		}
//		return false;

		for (Optional<OrderItem> item : items) {
			String ipName = item.flatMap(OrderItem::getProduct).flatMap(Product::getProductName).orElse("");

			if (ipName.equals(prodName)) {
				return true;
			}
		}
		return false;
	}

	private void loadOrderItemData() {
		orderItems.add(new OrderItem(new Product("1016", "Tools", 131.00), 3));
		orderItems.add(new OrderItem(new Product("1017", "Fishing Rod", 111.00), 1));
		orderItems.add(new OrderItem(new Product("1018", "Game of Go", 66.00), 2));
		orderItems.add(new OrderItem(new Product("1019", "Flowers", 221.00), 5));
	}
}
