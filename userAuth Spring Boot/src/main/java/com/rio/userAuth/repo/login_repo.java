package com.rio.userAuth.repo;

import com.rio.userAuth.modal.login;
import com.rio.userAuth.modal.signup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface login_repo extends JpaRepository<login,Integer > {
//    Boolean findByEmailAndPassword(String email, String password);
    login findByEmail(String email);
}
