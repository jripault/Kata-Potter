import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: JRI <julien.ripault@atos.net>
 * Date: 23/03/13
 */
public class Basket {
    private Double price = 0.0;
    private List<Book> books = new ArrayList<>();
    private List<List<Book>> booksGroup;

    private static final int BOOK_PRICE = 8;
    private static final double TWO_BOOKS_REDUCTION = 0.05;
    private static final double THREE_BOOKS_REDUCTION = 0.10;
    private static final double FOUR_BOOKS_REDUCTION = 0.20;
    private static final double FIVE_BOOKS_REDUCTION = 0.25;

    public Basket() {

    }

    public Double getPrice() {
        return price;
    }

    public void addBook(Book book) {
        books.add(book);
        computePrice();
    }

    private void computePrice() {
        price = 0.0;
        groupDifferentBooks();
        for (List<Book> bookList : booksGroup) {
            switch (bookList.size()){
                case 1:
                    price += BOOK_PRICE;
                    break;
                case 2:
                    price += (BOOK_PRICE*2*(1- TWO_BOOKS_REDUCTION));
                    break;
                case 3:
                    price += (BOOK_PRICE*3*(1- THREE_BOOKS_REDUCTION));
                    break;
                case 4:
                    price += (BOOK_PRICE*4*(1- FOUR_BOOKS_REDUCTION));
                    break;
                case 5:
                    price += (BOOK_PRICE*5*(1- FIVE_BOOKS_REDUCTION));
                    break;
                default:
                    break;
            }
        }
    }

    private void groupDifferentBooks(){
        booksGroup = new ArrayList<>();
        booksGroup.add(new ArrayList<Book>());
        boolean inserted;
        for (Book book : books) {
            inserted = false;
            for (List<Book> bookList : booksGroup) {
                if(!inserted && !bookList.contains(book)){
                    bookList.add(book);
                    inserted = true;
                    continue;
                }
            }
            if(!inserted){
                ArrayList<Book> newList = new ArrayList<>();
                newList.add(book);
                booksGroup.add(newList);
            }
        }
    }
}
