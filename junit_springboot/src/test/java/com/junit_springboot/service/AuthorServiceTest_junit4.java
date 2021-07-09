package com.junit_springboot.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.junit_springboot.implementation.AuthorImpl;
import com.junit_springboot.model.Author;
import com.junit_springboot.repository.AuthorRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class AuthorServiceTest_junit4 {

	@Mock
	AuthorRepository authorRepo;
	
	@InjectMocks
	AuthorImpl authorService;
	
//	@Before
//	public void init()
//	{
//		MockitoAnnotations.initMocks(this);
//	}
	
	@Test
	public void testGetListOfAuthor()
	{
		List<Author> authorList = new ArrayList<>();
		authorList.add(new Author("abc","abc","abc","abc",9808797886L));
		authorList.add(new Author("xyz","xyz","xyz","xyz",9808598887L));
		when(authorRepo.findAll()).thenReturn(authorList);
		
		List<Author> result = authorService.getAuthorList();
		assertEquals(2, result.size());
	}
	
	@Test
	public void testGetAuthorById()
	{
		Author author = new Author("60c1bfef224bd5ed721cd8f9","xyz","xyz","xyz",9808798887L);
		when(authorRepo.findById("60c1bfef224bd5ed721cd8f9")).thenReturn(Optional.of(author));
		
		//assertThrows(NoSuchElementException.class, () -> authorService.getAuthorByid("60c1bfef224bd5ed721cd8f9"));
		
		Author result = authorService.getAuthorByid("60c1bfef224bd5ed721cd8f9");
		assertEquals(author, result);
	}
	
	@Test
	public void testAddAuthor()
	{
		Author author = new Author("aaa","aaa","aaa","aaa",9808798886L);
		when(authorRepo.insert(author)).thenReturn(author);
		
		Author result = authorService.addAuthor(author);
		assertEquals(author, result);
	}
}
