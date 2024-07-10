package com.project.agroplus.AGROPLUS.AccountController;

import com.project.agroplus.AGROPLUS.AccountModel.AdminModel;
import com.project.agroplus.AGROPLUS.AccountModel.UserModel;
import com.project.agroplus.AGROPLUS.AccountRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin//("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @PostMapping("/adduser")
    UserModel addNewUser(@RequestBody UserModel newUser){
        return userRepository.save(newUser);
    }

    @PostMapping("/userlogin")
    public String userLogin(@RequestBody UserModel userModel) {
        UserModel existingUser = userRepository.findByEmailAndPassword(userModel.getEmail(), userModel.getPassword());
        if (existingUser != null) {
            return "Successful User Login";
        } else {
            return "Invalid email or password";
        }
    }

    @GetMapping("/allusers")
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @DeleteMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "User deleted with id : " + id;
    }
}
