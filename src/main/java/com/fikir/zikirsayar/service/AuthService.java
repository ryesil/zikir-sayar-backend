package com.fikir.zikirsayar.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
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
