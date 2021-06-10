package com.pratice.springdata.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.pratice.springdata.model.Book;

public interface BookRepository extends MongoRepository<Book, String> {

	List<Book> findByBookNameStartingWith(String bookName);
	
	@Query(value = "{'price':{$gte:?0}}")
	List<Book> filterByprice(int price);

	//if need to filter with more then one condition
//	@Query(value = "{'price':{$gte:?0},'edition':{$gte:?1}}")
//	List<Book> filterByprice(int price,int edition);
}
