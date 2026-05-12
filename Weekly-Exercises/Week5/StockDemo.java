public class StockDemo {
    private StockList stockList;

    public StockDemo() {
        stockList = new StockList();
    }

    public void testAddProducts() {
        System.out.println("=== Test: Add Products ===");
        stockList.addProduct(new Product(1, "Laptop", 15));
        stockList.addProduct(new Product(2, "Wireless Mouse", 42));
        stockList.addProduct(new Product(3, "USB-C Hub", 30));
        System.out.println();
    }

    public void testPrintProducts() {
        System.out.println("=== Test: Print All Products ===");
        stockList.printAll();
        System.out.println();
    }

    public void testSearchProduct() {
        System.out.println("=== Test: Search by Name ===");
        Product found = stockList.findByName("Wireless Mouse");
        if (found != null) {
            System.out.println("Found: ");
            found.print();
        } else {
            System.out.println("Not found.");
        }
        System.out.println();
    }

    public void testRemoveProduct() {
        System.out.println("=== Test: Remove Product (ID: 2) ===");
        stockList.removeProduct(2);
        System.out.println();
        stockList.printAll();
        System.out.println();
    }

    public void testRemoveNonExistent() {
        System.out.println("=== Test: Remove Non-Existent Product (ID: 99) ===");
        stockList.removeProduct(99);
        System.out.println();
    }

    public void run() {
        testAddProducts();
        testPrintProducts();
        testSearchProduct();
        testRemoveProduct();
        testRemoveNonExistent();
    }
}
