package com.project.agroplus.AGROPLUS.AdminController;

import com.project.agroplus.AGROPLUS.AdminModel.AdminModel;
import com.project.agroplus.AGROPLUS.AdminRepository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class AdminController {
    @Autowired
    public AdminRepository adminRepository;

    @PostMapping("/addnewuser")
    AdminModel addNewUser(@RequestBody AdminModel newUser){
        return adminRepository.save(newUser);
    }

    @PostMapping("/login")
    public String login(@RequestBody AdminModel adminModel) {
        AdminModel existingUser = adminRepository.findByEmailAndPassword(adminModel.getEmail(), adminModel.getPassword());
        if (existingUser != null) {
            return "Successful login";
        } else {
            return "Invalid email or password";
        }
    }


}
