import domain.Book;
import domain.Product;
import domain.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

    private final Book firstBook = new Book(1, "Wood", 450, "Sting");
    private final Book secondBook = new Book(2, "Folder", 857, "Sten");
    @Test
    public void shouldRemoveByID() {
        repository.save(firstBook);
        repository.save(secondBook);
        Product[] expected = new Product[]{secondBook};
        repository.removeById(1);
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}