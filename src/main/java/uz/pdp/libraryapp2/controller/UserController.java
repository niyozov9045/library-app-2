package uz.pdp.libraryapp2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.libraryapp2.dao.UserDao;
import uz.pdp.libraryapp2.model.User;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserDao userDao;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userDao.getALlUsersFromDb());
        return "/user/view-user-form";
    }

    @GetMapping("/get-form")
    public String getUserForm() {
        return "/user/add-user-form";
    }

    @PostMapping
    public String addNewUser(User user) {
        userDao.addNewUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String getForEditUser(@PathVariable Integer id, Model model) {
        User userBYId = userDao.getUserById(id);
        model.addAttribute("user", userBYId);
        return "/user/edit-user-form";
    }

    @PostMapping("/edit")
    public String editUserById(User user) {
        userDao.editUser(user);
        return "redirect:/users";

    }

    @GetMapping("/delete/{id}")
    public String deleteUserById(@PathVariable Integer id) {
        userDao.deleteUserById(id);
        return "redirect:/users";
    }
}
