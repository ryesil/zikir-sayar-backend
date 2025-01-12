package com.fikir.zikirsayar.service;

import com.fikir.zikirsayar.entity.ZikirDTO;
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

    public ZikirEntity getZikir(Long id) {
        return this.repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("There is no data related to given ID"));
    }

    public void updateZikir(ZikirDTO zk) {
        ZikirEntity zkDb = this.getZikir(zk.getId());
        if(zkDb != null){
            int amount = zk.getAmount() + zkDb.getAmount();
            zkDb.setAmount(amount);
            this.repo.save(zkDb);
        }
    }

    public ZikirEntity saveZikir(ZikirEntity zikir) {
        return this.repo.save(zikir);
    }
}
