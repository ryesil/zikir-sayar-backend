package com.fikir.zikirsayar.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthService {


    public boolean validatePassword(String password) {
        if(!password.equals("ArapFaik")){
            return false;
        } else {
            return true;
        }
    }
}
