package com.rio.userAuth.repo;

import com.rio.userAuth.modal.signup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface sign_repo extends JpaRepository<signup,Integer > {
//    @Query("SELECT s FROM signup s WHERE s.email = ?1 and s.password = ?2")
    List<signup> findByEmailAndPassword(String email, String password);
    List<signup>findByEmail(String email);
}
