package com.rio.userAuth.service;


import com.rio.userAuth.DTO.DTO_login;
import com.rio.userAuth.modal.login;
import com.rio.userAuth.modal.signup;
import com.rio.userAuth.repo.login_repo;
import com.rio.userAuth.repo.sign_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class login_service {
    @Autowired
    private login_repo loginRepo;
    @Autowired
    private sign_repo signRepo;
    @Autowired
    private JavaMailSender javaMailSender;
    public ResponseEntity<String> saveLogin(DTO_login l){
        if(l.getEmail().isEmpty() || l.getPassword().isEmpty()){
            return new ResponseEntity<>("Email or Password is Empty", HttpStatus.BAD_REQUEST) ;
        }
        else{
            List<signup> s = signRepo.findByEmailAndPassword(l.getEmail(),l.getPassword());
            if(!s.isEmpty()){
                login l1 = new login();
                l1.setEmail(l.getEmail());
                l1.setPassword(l.getPassword());
                loginRepo.save(l1);
                try {
                    SimpleMailMessage msg = new SimpleMailMessage();
                    msg.setTo(l1.getEmail());
                    msg.setSubject("Registration Successful");
                    msg.setText("Hello "+s.get(0).getName()+"\n\n Login  successfully .\n\nRegards,\nRio");
                    javaMailSender.send(msg);
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
                return new ResponseEntity<>(s.get(0).getName(), HttpStatus.OK) ;
            }
            else{
                return new ResponseEntity<>("Login Failed", HttpStatus.NOT_FOUND) ;
            }
        }
    }
}
