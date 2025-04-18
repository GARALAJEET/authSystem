package com.rio.userAuth.service;


import com.rio.userAuth.DTO.DTO_signup;
import com.rio.userAuth.modal.signup;
import com.rio.userAuth.repo.sign_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class signup_service {
    @Autowired
    private sign_repo signRepo;
    @Autowired
    private JavaMailSender javaMailSender;
    public ResponseEntity<String> saveSignup(DTO_signup s){
        List<signup> s2 = signRepo.findByEmail(s.getEmail());
        if(!s2.isEmpty()){
            return new ResponseEntity<>("Email already exists", org.springframework.http.HttpStatus.BAD_REQUEST) ;
        }
        signup s1 = new signup();
        s1.setEmail(s.getEmail());
        s1.setName(s.getName());
        s1.setPassword(s.getPassword());
        signRepo.save(s1);
        System.out.println("User saved: " + s1);
        sendMail(s);
        System.out.println("Email sent to: " + s.getEmail());
        return new ResponseEntity<>("Registration Successful", org.springframework.http.HttpStatus.OK) ;
    }
    @Async
    void sendMail(DTO_signup s){
        Thread thread = new Thread(() -> {
            System.out.println("Sending email to " + s.getEmail());
            try {
                SimpleMailMessage msg = new SimpleMailMessage();
                msg.setTo(s.getEmail());
                msg.setSubject("Registration Successful");
                msg.setText("Hello "+s.getName()+"\n\nYou have successfully registered with us.\n\nThank you for registering with us.\n\nRegards,\nRio");
                javaMailSender.send(msg);
            } catch (Exception e) {
                System.out.println("Error sending email: " + e.getMessage());
            }
            System.out.println("Email sent to " + s.getEmail());
        });
       thread.start();

    }

}
