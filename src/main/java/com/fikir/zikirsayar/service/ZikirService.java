package com.fikir.zikirsayar.service;

import com.fikir.zikirsayar.entity.ZikirEntity;
import com.fikir.zikirsayar.repository.ZikirRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.List;

@AllArgsConstructor
@Service
public class ZikirService {

    private ZikirRepository repo;

    public List<ZikirEntity> getZikirs(){
        return this.repo.findAll();
    }

    public void setZikir(ZikirEntity zikir){
        this.repo.save(zikir);
    }

    public ZikirEntity getZikir(Long id){
        return this.repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("There is no data related to given ID"));
    }

    public ZikirEntity updateZikir(ZikirEntity zk){
        ZikirEntity zkDb = this.getZikir(zk.getId());
        zkDb.setName(zk.getName());
        zkDb.setAmount(zk.getAmount());
        zkDb.setDate(zk.getDate());
        this.repo.save(zkDb);
        return zkDb;
    }
}
