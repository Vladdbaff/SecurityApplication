package mvc_security.controller;

import mvc_security.model.Role;
import mvc_security.model.User;
import mvc_security.service.RoleService;
import mvc_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {


    private UserService userService;

    private RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    public AdminController(){}

    @GetMapping()
    public String mainPage(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "/main";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user){
        return "newUser";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user,
                         @RequestParam(name = "listRoles", required = false) String[] roles) {
        user.setRoles(roleService.getRoleByName(roles));
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @PatchMapping("/{id}")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute("user") User user) {
        userService.updateUser(user, id);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }

    @GetMapping("{id}")
    public String user(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "userPage";
    }

}
