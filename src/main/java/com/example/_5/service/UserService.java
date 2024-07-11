package com.example._5.service;

import com.example._5.dto.PhoneDTO;
import com.example._5.model.Phone;

import java.util.List;

public interface UserService {
    void buyPhone(Phone phone);
    List<PhoneDTO> showBasket();
    void deleteFromBasket(int index);
    void pay();
}
