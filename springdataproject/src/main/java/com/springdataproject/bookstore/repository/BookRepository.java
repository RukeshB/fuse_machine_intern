package com.springdataproject.bookstore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.springdataproject.bookstore.model.Book;

public interface BookRepository extends MongoRepository<Book, String>{

	Page<Book> findByBookName(String bookName, Pageable pageable);
	
	@Query(value = "{'price':{$gte:?0,$lte:?1}}}")
	Page<Book> filterByPriceRange(int startingPrice,int endingPrice, Pageable pageable);
	
	@Query(value = "{'price':{$gte:?0,$lte:?1},'bookName':'?2'}")
	Page<Book> filterByPriceRangeAndBookName(int startingPrice,int endingPrice, 
			String bookName,Pageable pageable);
}
