package com.project.agroplus.AGROPLUS.AccountController;

import com.project.agroplus.AGROPLUS.AccountModel.AdminModel;
import com.project.agroplus.AGROPLUS.AccountModel.UserModel;
import com.project.agroplus.AGROPLUS.AccountRepository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin//("http://localhost:3000")
public class AdminController {
    @Autowired
    public AdminRepository adminRepository;

    @PostMapping("/addnewuser")
    AdminModel addNewUser(@RequestBody AdminModel newUser){
        return adminRepository.save(newUser);
    }

    @PostMapping("/login")
    public UserController.UserResponse userLogin(@RequestBody AdminModel adminModel) {
        AdminModel existingUser = adminRepository.findByEmailAndPassword(adminModel.getEmail(), adminModel.getPassword());
        if (existingUser != null) {
            return new UserController.UserResponse("Welcome, " + existingUser.getUsername()); // Include the username in the response
        } else {
            return new UserController.UserResponse("Invalid email or password");
        }
    }


}
