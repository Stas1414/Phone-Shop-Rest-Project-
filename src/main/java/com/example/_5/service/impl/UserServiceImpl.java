package com.example._5.service.impl;

import com.example._5.dto.PhoneDTO;
import com.example._5.model.Phone;
import com.example._5.model.User;
import com.example._5.repository.PhoneRepository;
import com.example._5.repository.UserRepository;
import com.example._5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private PhoneRepository phoneRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PhoneRepository phoneRepository) {
        this.userRepository = userRepository;
        this.phoneRepository = phoneRepository;
    }

    @Override
    @Transactional
    public void buyPhone(Phone phone) {
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        user.getPhones().add(phone);
        phone.getUsers().add(user);
        userRepository.save(user);
        phoneRepository.save(phone);

    }

    @Override
    public List<PhoneDTO> showBasket() {
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Phone> phonesList = user.getPhones();
        List<PhoneDTO> result = new ArrayList<>();
        for(Phone phone : phonesList){
            PhoneDTO phoneDTO = new PhoneDTO(phone);
            result.add(phoneDTO);
        }
        return result;
    }

    @Override
    @Transactional
    public void deleteFromBasket(int index) {
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        user.getPhones().remove(index-1);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void pay() {
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        user.getPhones().clear();
        userRepository.save(user);
    }
}
