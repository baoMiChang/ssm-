package mapper;

import com.liuc.config.SpringConfig;
import com.liuc.mapper.BookMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookMapperTest {
//    @Autowired
//    private BookService bookService;
    @Test
    public void test(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookMapper bookMapper = applicationContext.getBean(BookMapper.class);
//        List<Book> books = bookService.selectAll();
//        System.out.println(books);
        System.out.println(bookMapper.selectAll());
    }
}
