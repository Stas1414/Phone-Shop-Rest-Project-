package com.example._5.service;

import com.example._5.dto.PhoneDTO;
import com.example._5.model.Phone;

import java.util.List;

public interface PhoneService {

    List<PhoneDTO> getAllPhones();
    Phone getPhoneById(Long id);

}
