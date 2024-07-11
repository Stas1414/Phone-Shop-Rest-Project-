package com.example._5.controller;

import com.example._5.dto.PhoneDTO;
import com.example._5.model.Phone;
import com.example._5.service.impl.PhoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phones")
public class PhoneController {

    private PhoneServiceImpl phoneService;

    @Autowired
    public PhoneController(PhoneServiceImpl phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping("/all")

    public ResponseEntity<List<PhoneDTO>> getAllPhones(){
        return ResponseEntity.ok(phoneService.getAllPhones());

    }

    @GetMapping("/all/{id}")
    public ResponseEntity<Phone> getPhoneById(@PathVariable("id") Long id){
        return ResponseEntity.ok(phoneService.getPhoneById(id));
    }

}
