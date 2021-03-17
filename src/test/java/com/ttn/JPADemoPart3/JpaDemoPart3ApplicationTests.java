package com.ttn.JPADemoPart3;

import com.ttn.JPADemoPart3.entities.Address;
import com.ttn.JPADemoPart3.entities.Author;
import com.ttn.JPADemoPart3.entities.Books;
import com.ttn.JPADemoPart3.entities.Subjects;
import com.ttn.JPADemoPart3.repos.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaDemoPart3ApplicationTests {

	@Autowired
	AuthorRepository authorRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testAddSubjectsOfAuthors()
	{
		Author author1 = new Author();
		author1.setName("Vardan");
		Address address = new Address();

		address.setLocation("Janak Puri");
		address.setState("Delhi");
		address.setStreetNumber(9);

		author1.setAddress(address);

		Subjects subjects = new Subjects();
		subjects.setSubjectName("Python");

		Subjects subjects2 = new Subjects();
		subjects2.setSubjectName("C++");

		Subjects subjects3 = new Subjects();
		subjects3.setSubjectName("Spring");

		author1.addSubjects(subjects);
		author1.addSubjects(subjects2);
		author1.addSubjects(subjects3);

		authorRepository.save(author1);
	}

	@Test
	public void testForOneToOne()
	{
		Author author = new Author();
		author.setName("John");

		Address address = new Address();
		address.setStreetNumber(19);
		address.setState("Maharashtra");
		address.setLocation("Mumbai");
		author.setAddress(address);

		Books book = new Books();
		book.setBookName("The Human Fly");
		//book.setAuthor(author);
		//author.setBooks(book);

		authorRepository.save(author);
	}

	@Test
	public void testForManyToMany()
	{
		Author author = new Author();
		author.setName("Ram");

		Address address = new Address();
		address.setStreetNumber(19);
		address.setState("Maharashtra");
		address.setLocation("Mumbai");
		author.setAddress(address);

		Books book = new Books();
		book.setBookName("SciFi");

		Books book1 = new Books();
		book1.setBookName("Spring MVC");

		author.addBooks(book);
		author.addBooks(book1);

		authorRepository.save(author);
	}

	@Test
	public void testOneToManyBiDirectional()
	{
		Author author1 = new Author();
		author1.setName("Richard");
		Address address = new Address();

		address.setLocation("Janak Puri");
		address.setState("Delhi");
		address.setStreetNumber(9);

		author1.setAddress(address);

		Books book1 = new Books();
		book1.setBookName("Python");

		Books book2 = new Books();
		book2.setBookName("Cavalry Knights");

		author1.addBooks(book1);
		author1.addBooks(book2);

		authorRepository.save(author1);
	}

	@Test
	public void testForOneToManyUniDirectionalAndWithoutAdditionalTable()
	{
		Author author1 = new Author();
		author1.setName("Carter");
		Address address = new Address();

		address.setLocation("CP");
		address.setState("Delhi");
		address.setStreetNumber(23);

		author1.setAddress(address);

		Books book1 = new Books();
		book1.setBookName("JS");

		Books book2 = new Books();
		book2.setBookName("Linux");

		author1.addBooks(book1);
		author1.addBooks(book2);

		authorRepository.save(author1);

	}
}
