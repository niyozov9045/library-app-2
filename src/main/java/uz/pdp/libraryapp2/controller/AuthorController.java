package uz.pdp.libraryapp2.controller;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.libraryapp2.dao.AuthorDao;
import uz.pdp.libraryapp2.model.Author;
import uz.pdp.libraryapp2.payload.ViewResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorDao authorDao;


    @GetMapping
    public String getAllAuthors(@RequestParam(value = "status", defaultValue = "") String status, Model model) {

        switch (status) {
            case "added" -> model.addAttribute("status", new ViewResponse("Successfully added!!!", true));
            case "deleted" -> model.addAttribute("status", new ViewResponse("Successfully deleted!!!", true));
            case "notFound" -> model.addAttribute("status", new ViewResponse("Topilmadi", false));
        }

        model.addAttribute("mualliflar", authorDao.getAllAuthorsFromDb());
        return "/authors/view-authors";
    }
    @GetMapping("/get-form")
    public String getAuthorForm() {
        return "/authors/add-author-form";
    }
    @SneakyThrows
    @PostMapping
    public String addNewAuthor(Author author) {
        try {
            authorDao.addNewAuthor(author);
            return "redirect:/authors?status=added";

        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalAccessException("Something went wrong...");
        }


    }

    @GetMapping("/edit/{id}")
    public String getFormForEditAuthor(@PathVariable Integer id, Model model) {

        Author authorById = authorDao.getAuthorById(id);
        model.addAttribute("muallif", authorById);
        return "/authors/edit-author-form";

    }


    @PostMapping("/edit")
    public String editAuthorById(Author author) {
        try {
            authorDao.editAuthor(author);
            return "redirect:/authors";
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthorById(@PathVariable Integer id) {
        try {
            authorDao.deleteAuthorById(id);
            return "redirect:/authors?status=deleted";
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
