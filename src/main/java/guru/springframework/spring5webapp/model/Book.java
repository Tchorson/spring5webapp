package guru.springframework.spring5webapp.model;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book
{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String title, isbn, publisher;
    
    @ManyToMany(mappedBy = "books")
    private Set<Author> authors = new HashSet<>();
    
    private Book()
    {
    }
    
    private Book(String title, String isbn, String publisher)
    {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }
    
    private Book(String title, String isbn, String publisher, Set<Author> authors)
    {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authors = authors;
    }
    
    private Long getId()
    {
        return id;
    }
    
    private void setId(Long id)
    {
        this.id = id;
    }
    
    private String getTitle()
    {
        return title;
    }
    
    private void setTitle(String title)
    {
        this.title = title;
    }
    
    private String getIsbn()
    {
        return isbn;
    }
    
    private void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }
    
    private String getPublisher()
    {
        return publisher;
    }
    
    private void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }
    
    private Set<Author> getAuthors()
    {
        return authors;
    }
    
    private void setAuthors(Set<Author> authors)
    {
        this.authors = authors;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(o == null || getClass() != o.getClass())
        {
            return false;
        }
        final Book book = (Book) o;
        return Objects.equals(id, book.id);
    }
    
    @Override
    public int hashCode()
    {
        
        return Objects.hash(id);
    }
    
    @Override
    public String toString()
    {
        return "Book{" +
               "id=" + id +
               ", title='" + title + '\'' +
               ", isbn='" + isbn + '\'' +
               ", publisher='" + publisher + '\'' +
               ", authors=" + authors +
               '}';
    }
}
