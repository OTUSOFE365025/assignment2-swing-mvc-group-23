import java.io.InputStream;
import java.util.*;

public class CashRegister {
    private final Map<String, Product> productMap = new HashMap<>();
    private final List<Product> scannedItems = new ArrayList<>();
    private final Random random = new Random();

    public CashRegister() {
        loadProductsFromResource();
    }

    private void loadProductsFromResource() {
        try (InputStream input = getClass().getResourceAsStream("/products.txt");
             Scanner scanner = new Scanner(input)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue;
                String[] parts = line.split(" ");
                if (parts.length >= 3) {
                    String upc = parts[0];
                    String name = parts[1];
                    String priceStr = parts[2].replace("$", "");
                    double price = Double.parseDouble(priceStr);
                    productMap.put(upc, new Product(upc, name, price));
                }
            }
        } catch (Exception e) {
            System.err.println("Could not load products.txt");
        }
    }

    public Product scanRandomProduct() {
        if (productMap.isEmpty()) return null;
        List<Product> products = new ArrayList<>(productMap.values());
        Product p = products.get(random.nextInt(products.size()));
        scannedItems.add(p);
        return p;
    }

    public double getSubtotal() {
        return scannedItems.stream().mapToDouble(Product::getPrice).sum();
    }

    public List<Product> getScannedItems() {
        return scannedItems;
    }
}