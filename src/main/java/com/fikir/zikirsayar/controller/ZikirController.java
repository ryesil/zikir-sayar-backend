package com.fikir.zikirsayar.controller;

import com.fikir.zikirsayar.entity.ZikirEntity;
import com.fikir.zikirsayar.service.ZikirService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RestController
@Produces(MediaType.APPLICATION_JSON)
@RequestMapping("/zikirs")
public class ZikirController {

private ZikirService zikirService;

@GetMapping()
public ResponseEntity<List<ZikirEntity>> getZikirs(){
    List<ZikirEntity> zikirs = zikirService.getZikirs();
    return new ResponseEntity<>(zikirs, HttpStatus.OK);
}



@PostMapping()
public ResponseEntity<ZikirEntity> postZikir(@RequestBody ZikirEntity zikir){
if(zikir.getId() != null){
  ZikirEntity ze = this.zikirService.updateZikir(zikir);
    return new ResponseEntity<>(ze, HttpStatus.OK);
} else {
    this.zikirService.setZikir(zikir);
    return new ResponseEntity<>(zikir, HttpStatus.CREATED);
}
}


}
