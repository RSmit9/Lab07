import java.util.ArrayList;

public class Invoice {
    private String title;
    private String customerAddress;
    private ArrayList<LineItem> lineItems;
    private double totalAmountDue;

    public Invoice(String title, String Address) {
        this.title = title;
        this.customerAddress = customerAddress;
        this.lineItems = new ArrayList<>();
        this.totalAmountDue = 0.0;
    }

    public void addLineItem(LineItem item) {
        lineItems.add(item);
        totalAmountDue += item.getTotal();
    }

    public double getTotalAmountDue() {
        return totalAmountDue;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(title).append("\n");
        builder.append(customerAddress).append("\n");
        builder.append("| Item | Quantity | Price | Total |\n");
        for (LineItem item : lineItems) {
            builder.append("| ")
                    .append(item.getProduct().getName()).append(" | ")
                    .append(item.getQuantity()).append(" | ")
                    .append(item.getProduct().getUnitPrice()).append(" | ")
                    .append(item.getTotal()).append(" |\n");
        }
        builder.append("\nTotal: $").append(totalAmountDue);
        return builder.toString();
    }
}

class LineItem {
    private Product product;
    private int quantity;

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return product.getUnitPrice() * quantity;
    }
}

class Product {
    private String name;
    private double unitPrice;

    public Product(String name, double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
}
