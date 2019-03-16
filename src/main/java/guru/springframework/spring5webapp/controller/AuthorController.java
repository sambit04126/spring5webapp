package guru.springframework.spring5webapp.controller;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    private AuthorRepository authorRepository;

    @RequestMapping("/authors")
    public String getBooks(Model model){
        model.addAttribute("authors",authorRepository.findAll());
        return "authors";

    }
}
