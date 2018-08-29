package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData() {

        Publisher adrian = new Publisher("Adrian","Cracow 31-854 20/13");
        Publisher unknown = new Publisher();

        publisherRepository.save(adrian);
        publisherRepository.save(unknown);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "3333", adrian);
        ddd.getAuthors().add(eric);
        eric.getBooks().add(ddd);

        bookRepository.save(ddd);
        authorRepository.save(eric);


        Author Tolkien = new Author("John Ronald Reuel","Tolkien");
        Book hobbit = new Book ("Hobbit","3919",unknown);
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
