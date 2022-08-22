import domain.Book;
import domain.Product;
import domain.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book oneBook = new Book(1,"One", 1150, "Don");
    private Book secondBook = new Book(2, "Two", 450, "Yar" );

    @Test
    public void shouldRemoveByID() {
        repository.save(oneBook);
        repository.save(secondBook);
        Product[] expected = new Product[]{secondBook};
        repository.removeById(1);
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}