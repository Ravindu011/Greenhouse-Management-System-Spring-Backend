package com.project.agroplus.AGROPLUS.AccountRepository;

import com.project.agroplus.AGROPLUS.AccountModel.AdminModel;
import com.project.agroplus.AGROPLUS.AccountModel.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <UserModel, Long> {
    UserModel findByEmailAndPassword(String email, String password);

}
