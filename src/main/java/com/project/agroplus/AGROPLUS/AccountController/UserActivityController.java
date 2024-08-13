package com.project.agroplus.AGROPLUS.AccountController;

import com.project.agroplus.AGROPLUS.AccountModel.UserActivity;
import com.project.agroplus.AGROPLUS.AccountRepository.UserActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin // or specify your frontend URL
public class UserActivityController {

    @Autowired
    private UserActivityRepository userActivityRepository;

    @PostMapping("/addAct")
    public UserActivity addActivity(@RequestBody UserActivity userActivity) {
        return userActivityRepository.save(userActivity);
    }

    @GetMapping("/allAct")
    public Page<UserActivity> getAllActivities(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return userActivityRepository.findAllByOrderByIdDesc(pageable);
    }
}
