package domain;

public class ProductManager {
    ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
    public void add(Product item) {
        repository.save(item);
    }

    public Product[] getAll() {
        return repository.findAll();
    }
    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            return book.getAuthor().equalsIgnoreCase(search);
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().equalsIgnoreCase(search)) {
                return true;
            }
            return !smartphone.getConstructor().equalsIgnoreCase(search);
        }
        return false;
    }
}
