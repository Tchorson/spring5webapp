package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }



    private void initData() {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "3333", " Harper Collins");
        ddd.getAuthors().add(eric);
        eric.getBooks().add(ddd);

        bookRepository.save(ddd);
        authorRepository.save(eric);


        Author Tolkien = new Author("John Ronald Reuel","Tolkien");
        Book hobbit = new Book ("Hobbit","3919","I dont know");
        Tolkien.getBooks().add(hobbit);
        hobbit.getAuthors().add(Tolkien);

        bookRepository.save(hobbit);
        authorRepository.save(Tolkien);

    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
