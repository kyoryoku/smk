package lab.smk.controllers;

import lab.smk.models.system.Role;
import lab.smk.models.system.User;
import lab.smk.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashSet;

@Controller
public class UserController {

    @Autowired
    private UserRepository ur;


    @GetMapping("/user")
    public @ResponseBody Iterable<User> getUser(){
        return ur.findAll();
    }

    @PostMapping("/user/add")
    public @ResponseBody String addUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam boolean active,
            Model model)
    {
        HashSet<Role> roles = new HashSet<Role>();
        roles.add(Role.ADMIN);
        User newUser = new User(username, password, active, roles );
        ur.save(newUser);
        return "User added. " + newUser.toString();
    }

    @PostMapping("/user/delete")
    public @ResponseBody String deleteUser(
            @RequestParam String username,
            Model model)
    {
        User foundUser = ur.findByUsername(username);
        if (foundUser != null){
            ur.deleteById(foundUser.getId());
            return "User deleted.";
        } else {
            return "User not found!";
        }
    }
}
