package com.example.comparateur.forfaitmob;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ForfaitMobileService1 {


    private final ForfaitMobileRepository forfaitMobileRepository;

    private final ForfaitMapper forfaitMapper;
    @Autowired
    public ForfaitMobileService1(ForfaitMobileRepository forfaitMobileRepository, ForfaitMapper forfaitMapper) {
        this.forfaitMobileRepository = forfaitMobileRepository;
        this.forfaitMapper = forfaitMapper;
    }

    public ForfaitMobile createForfait(ForfaitDto forfaitDto) {
        return forfaitMobileRepository.save(forfaitMapper.toEntity(forfaitDto));

    }
    public List<ForfaitMobile> getForfait() {
        return StreamSupport.stream(forfaitMobileRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<ForfaitMobile> getForfaitById(UUID id) {

        return forfaitMobileRepository.findForfaitMobilesById(id);


    }
    public ForfaitMobile updateForfait(ForfaitMobile forfaitMobile) {
        return forfaitMobileRepository.save(forfaitMobile);
    }
    public void deleteForfait(UUID id) {
        forfaitMobileRepository.deleteById(id);
        System.out.println("Forfait Mobile Deleted Successfully");
    }

}
