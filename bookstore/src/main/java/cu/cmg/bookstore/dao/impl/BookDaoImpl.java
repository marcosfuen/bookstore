package cu.cmg.bookstore.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cu.cmg.bookstore.dao.BookDao;
import cu.cmg.bookstore.model.Book;

@Repository
public class BookDaoImpl implements BookDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void saveBook(Book book) {
		// TODO Auto-generated method stub
		getSession().merge(book);
		
	}

	public List<Book> listBooks() {
		// TODO Auto-generated method stub
		return getSession().createCriteria(Book.class).list();
	}

	public Book getBook(Long id) {
		// TODO Auto-generated method stub
		return (Book)getSession().get(Book.class, id);
	}

	public void deleteBook(Long id) {
		// TODO Auto-generated method stub
		Book book = getBook(id);
		if(null != book){
			getSession().delete(book);
			
		}
		
	}
	
	private Session getSession(){
		Session sess = getSessionFactory().getCurrentSession();
		if(sess == null){
			sess = getSessionFactory().openSession();
		}
		return sess;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
