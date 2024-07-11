package com.example._5.controller;

import com.example._5.dto.PhoneDTO;
import com.example._5.model.Phone;
import com.example._5.service.impl.PhoneServiceImpl;
import com.example._5.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserServiceImpl userService;

    private PhoneServiceImpl phoneService;

    private RestTemplate restTemplate;


    @Autowired
    public UserController(UserServiceImpl userService, PhoneServiceImpl phoneService, RestTemplate restTemplate) {
        this.userService = userService;
        this.phoneService = phoneService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/basket")
    public ResponseEntity<List<PhoneDTO>> showBasket(){
        return ResponseEntity.ok(userService.showBasket());
    }

    @GetMapping("/buy/{id}")
    public ResponseEntity<Void> buyPhone(@PathVariable("id") Long id){
        Phone phone = phoneService.getPhoneById(id);
        userService.buyPhone(phone);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/delete/{index}")
    public ResponseEntity<Void> deletePhone(@PathVariable("index") int index){
        userService.deleteFromBasket(index);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/pay")
    public RedirectView payPhones(){

        userService.pay();
        return new RedirectView("/email/sendEmail");
    }
}
