package com.project.agroplus.AGROPLUS.AccountRepository;

import com.project.agroplus.AGROPLUS.AccountModel.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserActivityRepository extends JpaRepository<UserActivity, Long> {
}
