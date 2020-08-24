package lab.smk.services.system;

import lab.smk.models.system.Role;
import lab.smk.models.system.User;
import lab.smk.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
    public User findByUserName(String username){
        return userRepository.findByUsername(username);
    }

    public String addUser(User user){

        if ( userRepository.findByUsername(user.getUsername()) == null) {
            userRepository.save(user);
            return "Пользователь добавлен: " + user.toString();
        } else {
            return "Ошибка! Имя пользователя уже существует.";
        }
    }


    public void deleteAll() {
        userRepository.deleteAll();
    }


    public void addDefaultUser() {

        HashSet<Role> defaultRoles = new HashSet<Role>();
        defaultRoles.add(Role.ADMIN);
        defaultRoles.add(Role.USER);

        User defaultUser = new User();
        defaultUser.setUsername("admin");
        defaultUser.setPassword("admin");
        defaultUser.setRoles(defaultRoles);
        defaultUser.setActive(true);

        if (userRepository.findByUsername(defaultUser.getUsername()) == null){
            userRepository.save(defaultUser);
        }
    }


//    public String editUser(String username) {
//
//        User foundUser = userRepository.findByUsername(username);
//
//        if (foundUser == null){
//            return "Пользователь не найден!";
//        }
//
//
//
//    }
}
