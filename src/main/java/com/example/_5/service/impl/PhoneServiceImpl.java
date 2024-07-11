package com.example._5.service.impl;

import com.example._5.dto.PhoneDTO;
import com.example._5.model.Phone;
import com.example._5.repository.PhoneRepository;
import com.example._5.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {

    private PhoneRepository phoneRepository;

    @Autowired
    public PhoneServiceImpl(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public List<PhoneDTO> getAllPhones() {
        List<Phone> phonesList = phoneRepository.findAll();
        List<PhoneDTO> result = new ArrayList<>();
        for(Phone phone : phonesList){
            PhoneDTO phoneDTO = new PhoneDTO(phone);
            result.add(phoneDTO);
        }
        return result;
    }

    @Override
    public Phone getPhoneById(Long id) {
        return phoneRepository.findById(id).orElse(null);
    }
}
