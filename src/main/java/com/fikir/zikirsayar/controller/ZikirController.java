package com.fikir.zikirsayar.controller;

import com.fikir.zikirsayar.entity.ZikirEntity;
import com.fikir.zikirsayar.service.ZikirService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    List zikirs = zikirService.getZikirs();
    return new ResponseEntity<>(zikirs, HttpStatus.OK);
}

}
