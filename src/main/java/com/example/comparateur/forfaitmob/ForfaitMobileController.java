package com.example.comparateur.forfaitmob;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/forfait_mob")
@RequiredArgsConstructor
public class ForfaitMobileController {


    private final ForfaitMobileService1 forfaitMobileService1;
    @PostMapping("/create")
    public ForfaitMobile createForfait(@RequestBody ForfaitDto forfaitMobile) {

        return forfaitMobileService1.createForfait( forfaitMobile);
    }


    @GetMapping("/allforfait")
    public List<ForfaitMobile> getAllForfait() {
        return forfaitMobileService1.getForfait();
    }

    @GetMapping("/all_by_id")
    public List<ForfaitMobile> getAllById(@PathVariable UUID id) {
        return forfaitMobileService1.getForfaitById(id);
    }
    @PutMapping("/update")
    public ForfaitMobile updateForfait(@RequestBody ForfaitMobile forfaitMobile) {
        return forfaitMobileService1.updateForfait(forfaitMobile);
    }
    @DeleteMapping("/supp_forfait")
    public void deleteForfait(@RequestParam UUID id) {
        forfaitMobileService1.deleteForfait(id);
        System.out.println("Forfait Mobile Deleted Successfully");

    }
}
