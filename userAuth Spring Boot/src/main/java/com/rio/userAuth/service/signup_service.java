package com.rio.userAuth.service;


import com.rio.userAuth.DTO.DTO_signup;
import com.rio.userAuth.modal.signup;
import com.rio.userAuth.repo.sign_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class signup_service {
    @Autowired
    private sign_repo signRepo;
    @Autowired
    private JavaMailSender javaMailSender;
    public void saveSignup(DTO_signup s){
        signup s1 = new signup();
        s1.setEmail(s.getEmail());
        s1.setName(s.getName());
        s1.setPassword(s.getPassword());
        signRepo.save(s1);
        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(s.getEmail());
            msg.setSubject("Registration Successful");
            msg.setText("Hello "+s.getName()+"\n\nYou have successfully registered with us.\n\nThank you for registering with us.\n\nRegards,\nRio");
            javaMailSender.send(msg);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
