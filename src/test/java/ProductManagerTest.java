import domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

        private final ProductRepository repository = new ProductRepository();
        private final ProductManager manager = new ProductManager(repository);
        private final Book oneBook = new Book(1,"One", 1150, "Don");
        private final Book secondBook = new Book(2, "Two", 450, "Yar");
        private final Smartphone oneSmartphone = new Smartphone(3, "A52", 25_000, "Samsung");
        private final Smartphone secondSmartphone = new Smartphone(4, "A53", 29_900, "Son");

        @BeforeEach
        void setUp() {
            manager.add(oneBook);
            manager.add(secondBook);
            manager.add(oneSmartphone);
            manager.add(secondSmartphone);
        }

        @Test
        public void shouldGetAll() {
            Product[] expected = new Product[]{oneBook, secondBook, oneSmartphone, secondSmartphone};
            Product[] actual = manager.getAll();
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldFindSeveralByBookAuthor() {
            Product[] expected = new Product[]{oneBook, secondBook};
            Product[] actual = manager.searchBy("Yar");
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldFindByBookName() {
            Product[] expected = new Product[]{oneBook};
            Product[] actual = manager.searchBy("One");
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldFindBySmartphoneConstructor() {
            Product[] expected = new Product[]{oneSmartphone, secondSmartphone};
            Product[] actual = manager.searchBy("Samsung");
            Assertions.assertArrayEquals(expected, actual);
        }

        @Test
        public void shouldFindBySmartphoneName() {
            Product[] expected = new Product[]{secondSmartphone};
            Product[] actual = manager.searchBy("A53");
            Assertions.assertArrayEquals(expected, actual);
        }
    }


