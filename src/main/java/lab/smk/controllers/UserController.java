package lab.smk.controllers;

import lab.smk.models.system.User;
import lab.smk.services.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/system/user")
    public String getUsers(Model model){

        model.addAttribute("userList", userService.findAll());
        return "/system/user";
    }

    @GetMapping("/system/user/delete-all")
    public @ResponseBody String deleteUsers(Model model){
        userService.deleteAll();
        userService.addDefaultUser();

        return "Все пользователи удалены. Создан пользователь по умолчанию admin::admin";
    }

    @PostMapping("/system/user/add")
    public @ResponseBody String addUser(@ModelAttribute User user, Model model)
    {
        return userService.addUser(user);
    }

    @GetMapping("/system/user/{username}")
    public String showProfile(@PathVariable String username, Model model)
    {
        model.addAttribute("user", userService.findByUserName(username));
        return "/system/user-profile";
    }

//    @GetMapping("/system/user/edit")
//    public @ResponseBody String editUser(@RequestParam("username") String username, Model model)
//    {
//        return userService.editUser(username);
//    }

//    @PostMapping("/user/delete")
//    public @ResponseBody String deleteUser(
//            @RequestParam String username,
//            Model model)
//    {
//        User foundUser = ur.findByUsername(username);
//        if (foundUser != null){
//            ur.deleteById(foundUser.getId());
//            return "User deleted.";
//        } else {
//            return "User not found!";
//        }
//    }
}
