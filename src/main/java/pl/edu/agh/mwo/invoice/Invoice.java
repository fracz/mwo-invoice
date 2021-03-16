package pl.edu.agh.mwo.invoice;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import pl.edu.agh.mwo.invoice.product.Product;

public class Invoice {
    private Map<Product, Integer> products = new LinkedHashMap<>();
    private static int currentNumber = 0;
    private int invoiceNumber;


    public Invoice() {
        currentNumber ++;
        invoiceNumber = currentNumber;
    }

    public void addProduct(Product product) {
        if (products.containsKey(product)){
            int quantity = products.get(product);
            products.replace(product, quantity, quantity + 1);
        }
        else {
            this.products.put(product, 1);
        }
    }

    public void addProduct(Product product, Integer quantity) {
        if (quantity > 0 ){
            if (products.containsKey(product)){
                int quantityInInvoice = products.get(product);
                products.replace(product, quantity, quantityInInvoice + quantity);
            }
            else {
                this.products.put(product, quantity);
            }
        }else {
            throw new IllegalArgumentException();
        }
    }

    public BigDecimal getSubtotal() {
        BigDecimal sum = BigDecimal.ZERO;
        for (Product product: this.products.keySet()) {
            Integer quantity = this.products.get(product);
            sum = sum.add(product.getPrice().multiply(new BigDecimal(quantity)));
        }
        return sum;
    }

    public BigDecimal getTax() {
        BigDecimal result = BigDecimal.ZERO;

        Set<Map.Entry<Product, Integer>> entries = products.entrySet();
        for (Map.Entry<Product, Integer> entry : entries) {
            result = result.add(entry.getKey().getTaxPercent().multiply(entry.getKey().getPrice()));
        }
        return result;
    }

    public BigDecimal getTotal() {
        BigDecimal result = BigDecimal.ZERO;

        Set<Map.Entry<Product, Integer>> entries = products.entrySet();
        for (Map.Entry<Product, Integer> entry : entries) {
            result = result.add(entry.getKey().getPriceWithTax().multiply(BigDecimal.valueOf(entry.getValue())));
        }
        return result;
    }

    public int getProductQuantity(Product product){
        if (products.containsKey(product)){
            return products.get(product);
        }
        return 0;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public boolean printInvoice (){
        if (products.size() == 0){
            System.out.println("Pusta FV!!! Brak dodanych produktow!!!");
            return false;
        }

        String line = "---------------------------------------------";
        System.out.println("\nFaktura nr: " + invoiceNumber + "\n" + line);
        System.out.printf("%1$-15s %2$-13s %3$-10s %4$-1s", "Nazwa produktu", "Liczba sztuk", "Cena", "\n");

        Set<Map.Entry<Product, Integer>> entries = products.entrySet();
        for (Map.Entry<Product, Integer> entry : entries) {
            System.out.printf("%1$-15s %2$-13s %3$-10s %4$-1s", entry.getKey().getName(), entry.getValue(), entry.getKey().getPrice(), "\n");
        }
        System.out.println(line +"\nLiczba pozycji: " + products.size());

        return true;
    }
}
