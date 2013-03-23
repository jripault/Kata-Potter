import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * User: JRI <julien.ripault@atos.net>
 * Date: 23/03/13
 */
@RunWith(JUnit4.class)
public class BasketPricerTest {
    @Test
    public void shouldEmptyBasketCostsZero(){
        Basket basket = new Basket();
        assertThat(basket.getPrice()).isEqualTo(0);
    }
    @Test
    public void shouldBasketWithOneBookCostsEight(){
        Basket basket = new Basket();
        basket.addBook(Book.One);
        assertThat(basket.getPrice()).isEqualTo(8);
    }
    @Test
    public void shouldBasketWithTwoDifferentBooksHasReduction(){
        Basket basket = new Basket();
        basket.addBook(Book.One);
        basket.addBook(Book.Two);
        assertThat(basket.getPrice()).isEqualTo(8 * 2 * (1 - 0.05));
    }
    @Test
    public void shouldBasketWithTwoIdenticBooksCostsSixteen(){
        Basket basket = new Basket();
        basket.addBook(Book.One);
        basket.addBook(Book.One);
        assertThat(basket.getPrice()).isEqualTo(16);
    }

    @Test
    public void shouldBasketWithThreeDifferentBooksCostsSixteen(){
        Basket basket = new Basket();
        basket.addBook(Book.One);
        basket.addBook(Book.Two);
        basket.addBook(Book.Three);
        assertThat(basket.getPrice()).isEqualTo(8 * 3 * (1 - 0.10));
    }
    @Test
    public void shouldBasketWithFourDifferentBooks(){
        Basket basket = new Basket();
        basket.addBook(Book.One);
        basket.addBook(Book.Two);
        basket.addBook(Book.Three);
        basket.addBook(Book.Four);
        assertThat(basket.getPrice()).isEqualTo(8 * 4 * (1 - 0.20));
    }
    @Test
    public void shouldBasketWithFiveDifferentBooks(){
        Basket basket = new Basket();
        basket.addBook(Book.One);
        basket.addBook(Book.Two);
        basket.addBook(Book.Three);
        basket.addBook(Book.Four);
        basket.addBook(Book.Five);
        assertThat(basket.getPrice()).isEqualTo(8 * 5 * (1 - 0.25));
    }


    @Test
    public void shouldBasket(){
        Basket basket = new Basket();
        basket.addBook(Book.One);
        basket.addBook(Book.One);
        basket.addBook(Book.Three);
        assertThat(basket.getPrice()).isEqualTo(8 + (8 * 2 * (1- 0.05)));
    }
    @Test
    public void shouldBasket2(){
        Basket basket = new Basket();
        basket.addBook(Book.One);
        basket.addBook(Book.One);
        basket.addBook(Book.Three);
        basket.addBook(Book.Three);
        assertThat(basket.getPrice()).isEqualTo(2 * (8 * 2 * 0.95));
    }
    @Test
    public void shouldBasket3(){
        Basket basket = new Basket();
        basket.addBook(Book.One);
        basket.addBook(Book.One);
        basket.addBook(Book.Two);
        basket.addBook(Book.Three);
        basket.addBook(Book.Three);
        basket.addBook(Book.Four);
        assertThat(basket.getPrice()).isEqualTo((8 * 4 * 0.8) + (8 * 2 * 0.95));
    }
    @Test
    public void shouldBasket4(){
        Basket basket = new Basket();
        basket.addBook(Book.One);
        basket.addBook(Book.Two);
        basket.addBook(Book.Two);
        basket.addBook(Book.Three);
        basket.addBook(Book.Four);
        basket.addBook(Book.Five);
        assertThat(basket.getPrice()).isEqualTo(8 + (8 * 5 * 0.75));
    }
    @Test
    public void shouldBasket5(){
        Basket basket = new Basket();
        basket.addBook(Book.One);
        basket.addBook(Book.One);
        basket.addBook(Book.Two);
        basket.addBook(Book.Two);
        basket.addBook(Book.Three);
        basket.addBook(Book.Three);
        basket.addBook(Book.Four);
        basket.addBook(Book.Five);
        assertThat(basket.getPrice()).isEqualTo(2 * (8 * 4 * 0.8));
    }
    @Test
    public void shouldBasket6(){
        Basket basket = new Basket();
        basket.addBook(Book.One);
        basket.addBook(Book.One);
        basket.addBook(Book.One);
        basket.addBook(Book.One);
        basket.addBook(Book.One);
        basket.addBook(Book.Two);
        basket.addBook(Book.Two);
        basket.addBook(Book.Two);
        basket.addBook(Book.Two);
        basket.addBook(Book.Two);
        basket.addBook(Book.Three);
        basket.addBook(Book.Three);
        basket.addBook(Book.Three);
        basket.addBook(Book.Three);
        basket.addBook(Book.Four);
        basket.addBook(Book.Four);
        basket.addBook(Book.Four);
        basket.addBook(Book.Four);
        basket.addBook(Book.Four);
        basket.addBook(Book.Four);
        basket.addBook(Book.Five);
        basket.addBook(Book.Five);
        basket.addBook(Book.Five);
        basket.addBook(Book.Five);
        assertThat(basket.getPrice()).isEqualTo(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8));
    }
    /*

    def testEdgeCases
    assert_equal(2 * (8 * 4 * 0.8), price([0, 0, 1, 1, 2, 2, 3, 4]))
    assert_equal(3 * (8 * 5 * 0.75) + 2 * (8 * 4 * 0.8),
    price([0, 0, 0, 0, 0,
              1, 1, 1, 1, 1,
              2, 2, 2, 2,
              3, 3, 3, 3, 3,
              4, 4, 4, 4]))
              */
}
