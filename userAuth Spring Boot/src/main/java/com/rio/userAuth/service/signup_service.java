package com.rio.userAuth.service;


import com.rio.userAuth.DTO.DTO_signup;
import com.rio.userAuth.modal.signup;
import com.rio.userAuth.repo.sign_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class signup_service {
    @Autowired
    private sign_repo signRepo;
    public void saveSignup(DTO_signup s){
        signup s1 = new signup();
        s1.setEmail(s.getEmail());
        s1.setName(s.getName());
        s1.setPassword(s.getPassword());
         signRepo.save(s1);
    }

}
