package com.fikir.zikirsayar.service;

import com.fikir.zikirsayar.entity.ZikirEntity;
import com.fikir.zikirsayar.repository.ZikirRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ZikirService {

    private ZikirRepository repo;


    public List<ZikirEntity> getZikirs(){
        return this.repo.findAll();
    }

}
