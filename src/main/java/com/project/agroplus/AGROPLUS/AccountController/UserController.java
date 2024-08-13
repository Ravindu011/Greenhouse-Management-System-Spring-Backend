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
    public UserResponse userLogin(@RequestBody UserModel userModel) {
        UserModel existingUser = userRepository.findByEmailAndPassword(userModel.getEmail(), userModel.getPassword());
        if (existingUser != null) {
            return new UserResponse("Welcome, " + existingUser.getUsername()); // Include the username in the response
        } else {
            return new UserResponse("Invalid email or password");
        }
    }


    @PostMapping("/getUsername")
    public UserResponse login(@RequestBody LoginRequest loginRequest) {
        UserModel existingUser = userRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if (existingUser != null) {
            return new UserResponse(existingUser.getUsername());
        } else {
            return new UserResponse("Invalid email or password");
        }
    }
    public static class UserResponse {
        private String User;

        public UserResponse(String message) {
            this.User = message;
        }

        public String getMessage() {
            return User;
        }

        public void setMessage(String message) {
            this.User = message;
        }
    }

    // Request class for login
    public static class LoginRequest {
        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
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
