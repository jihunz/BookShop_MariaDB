package kr.ac.kopo.bookshop.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.bookshop.model.Book;

@Repository
public class BookDaoImpl implements BookDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public List<Book> list() {
		return sql.selectList("book.list");
	}

	@Override
	public void add(Book item) {
		sql.insert("book.add", item);
		
	}

	@Override
	public Book item(int bookId) {
		return sql.selectOne("book.item", bookId);
	}

	@Override
	public void update(Book item) {
		sql.update("book.update", item);
	}

	@Override
	public void delete(int bookId) {
		sql.delete("book.delete", bookId);
	}

}
