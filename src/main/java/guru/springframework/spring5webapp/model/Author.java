package guru.springframework.spring5webapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String firstName, lastName;
    
    @ManyToMany
    @JoinTable(name ="book_author",joinColumns = @JoinColumn(name = "author_id"),inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books = new HashSet<>();
    
    public Author()
    {
    
    }
    
    private Author(String firstName, String lastName, Set<Book> books)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }
    
    private Author(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    private Long getId()
    {
        return id;
    }
    
    private void setId(Long id)
    {
        this.id = id;
    }
    
    private String getFirstName()
    {
        return firstName;
    }
    
    private void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    private String getLastName()
    {
        return lastName;
    }
    
    private void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    private Set<Book> getBooks()
    {
        return books;
    }
    
    private void setBooks(Set<Book> books)
    {
        this.books = books;
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
        final Author author = (Author) o;
        return Objects.equals(id, author.id);
    }
    
    @Override
    public int hashCode()
    {
        
        return Objects.hash(id);
    }
    
    @Override
    public String toString()
    {
        return "Author{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", books=" + books +
               '}';
    }
}
