package com.project.agroplus.AGROPLUS.AdminRepository;

import com.project.agroplus.AGROPLUS.AdminModel.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminModel, Long> {
    AdminModel findByEmailAndPassword(String email, String password);
}
