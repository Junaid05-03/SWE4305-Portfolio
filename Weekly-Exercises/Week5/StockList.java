import java.util.ArrayList;

public class StockList {
    private ArrayList<Product> products;

    public StockList() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Added: " + product.getName());
    }

    public boolean removeProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                System.out.println("Removed: " + product.getName());
                return true;
            }
        }
        System.out.println("Product with ID " + id + " not found.");
        return false;
    }

    public Product findByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public void printAll() {
        if (products.isEmpty()) {
            System.out.println("Stock list is empty.");
            return;
        }
        System.out.println("--- Stock List (" + products.size() + " items) ---");
        for (Product product : products) {
            product.print();
        }
    }
}
