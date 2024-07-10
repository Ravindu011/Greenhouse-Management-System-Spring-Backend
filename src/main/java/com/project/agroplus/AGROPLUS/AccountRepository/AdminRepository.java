package com.project.agroplus.AGROPLUS.AccountRepository;

import com.project.agroplus.AGROPLUS.AccountModel.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminModel, Long> {
    AdminModel findByEmailAndPassword(String email, String password);
}
