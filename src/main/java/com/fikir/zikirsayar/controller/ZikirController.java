package com.fikir.zikirsayar.controller;

import com.fikir.zikirsayar.entity.ZikirDTO;
import com.fikir.zikirsayar.entity.ZikirEntity;
import com.fikir.zikirsayar.service.AuthService;
import com.fikir.zikirsayar.service.ZikirService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RestController
@RequestMapping("/zikirs")
public class ZikirController {

    private static final Logger log = LoggerFactory.getLogger(ZikirController.class);

    private final ZikirService zikirService;
    private final AuthService authService;

    @GetMapping
    public ResponseEntity<List<ZikirEntity>> getZikirs() {
        List<ZikirEntity> zikirs = zikirService.getZikirs();
        return ResponseEntity.ok(zikirs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ZikirEntity> getZikir(@PathVariable Long id) {
        ZikirEntity zikir = zikirService.getZikir(id);
        return ResponseEntity.ok(zikir);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateZikir(@PathVariable Long id, @RequestBody ZikirDTO zikir) throws IllegalArgumentException {
        if (id == null || !id.equals(zikir.getId())) {
            log.error("Mismatch or missing ID: Path ID = {}, Zikir ID = {}", id, zikir.getId());
            throw new IllegalArgumentException("Path ID doesn't match with Zikir ID or is missing");
        }
        zikirService.updateZikir(zikir);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<ZikirEntity> postZikir(
            @RequestHeader("password") String password,
            @RequestBody ZikirEntity zikir) {
        if (!authService.validatePassword(password)) {
            log.warn("Unauthorized access attempt with password: {}", password);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        ZikirEntity savedZikir = zikirService.saveZikir(zikir);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedZikir);
    }
}