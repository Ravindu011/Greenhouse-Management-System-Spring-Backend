package com.project.agroplus.AGROPLUS.AccountRepository;

import com.project.agroplus.AGROPLUS.AccountModel.UserActivity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserActivityRepository extends JpaRepository<UserActivity, Long> {

    Page<UserActivity> findAllByOrderByIdDesc(Pageable pageable);
}
