package com.project.agroplus.AGROPLUS.AccountController;

import com.project.agroplus.AGROPLUS.AccountModel.UserActivity;
import com.project.agroplus.AGROPLUS.AccountRepository.UserActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin//("http://localhost:3000")
public class UserActivityController {
    @Autowired
    private UserActivityRepository userActivityRepository;

    @PostMapping("/addAct")
    public UserActivity addActivity(@RequestBody UserActivity userActivity) {
        return userActivityRepository.save(userActivity);
    }

    @GetMapping("/allAct")
    public List<UserActivity> getAllActivities() {
        return userActivityRepository.findAll();
    }
}
