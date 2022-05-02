package kr.ac.kopo.bookshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.bookshop.dao.BookDao;
import kr.ac.kopo.bookshop.model.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDao dao;

	@Override
	public List<Book> list() {
		return dao.list();
	}

	@Override
	public void add(Book item) {
		dao.add(item);		
	}

	@Override
	public Book item(int bookId) {
		return dao.item(bookId);
	}

	@Override
	public void update(Book item) {
		dao.update(item);
	}

	@Override
	public void delete(int bookId) {
		dao.delete(bookId);
	}

	@Override
	public void dummy() {
		for(int i=0; i<100; i++) {
			Book item = new Book();

			item.setBookname("이름" + i);
			item.setPrice( (i +1 ) * 1000);
			item.setPublisher("출판사" + i);
			
			dao.add(item);
		}
		
	}

	@Override
	public void init() {
		List<Book> list = dao.list();
		
		for(Book item : list) {
			dao.delete(item.getBookId());
		}
	}

}
