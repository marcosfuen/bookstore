package cu.cmg.bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cu.cmg.bookstore.dao.BookDao;
import cu.cmg.bookstore.model.Book;
import cu.cmg.bookstore.service.BookService;


@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookDao bookDao;
    
	@Transactional
	public void saveBook(Book book) {
		// TODO Auto-generated method stub
		bookDao.saveBook(book);
		
	}
	
    @Transactional(readOnly = true)
	public List<Book> listBooks() {
		// TODO Auto-generated method stub
		return bookDao.listBooks();
	}
    
    @Transactional(readOnly = true)
	public Book getBook(Long id) {
		// TODO Auto-generated method stub
		return bookDao.getBook(id);
	}
    
    @Transactional
	public void deleteBook(Long id) {
		// TODO Auto-generated method stub
		bookDao.deleteBook(id);
	}

}
