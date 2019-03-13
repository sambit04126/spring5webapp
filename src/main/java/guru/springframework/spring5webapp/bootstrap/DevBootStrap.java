package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepo;
    private BookRepository bookRepo;
    private PublisherRepository pubRepo;

    public DevBootStrap(AuthorRepository authRepo, BookRepository bookRepo, PublisherRepository
            publisherRepository){
        this.authorRepo=authRepo;
        this.bookRepo=bookRepo;
        this.pubRepo=publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
           initData();
    }

    private void initData() {
        Author eric = new Author("Eric","Evans");
        Book ddd= new Book("Domain Driven Design","1234");
        Publisher publisher= new Publisher("Harper Collins","Harper Collins","Harper Collins","Harper Collins");
        ddd.setPublisher(publisher);
        eric.getBook().add(ddd);
        ddd.getAuthors().add(eric);
        pubRepo.save(publisher);
        authorRepo.save(eric);
        bookRepo.save(ddd);

    }
}

