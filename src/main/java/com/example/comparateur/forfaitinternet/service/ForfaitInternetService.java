package com.example.comparateur.forfaitinternet.service;

import com.example.comparateur.forfait.entity.Forfait;
import com.example.comparateur.forfaitinternet.dto.ForfaitInternetDto;
import com.example.comparateur.forfaitinternet.entity.ForfaitInternet;
import com.example.comparateur.forfaitinternet.mapper.ForfaitInternetMapper;
import com.example.comparateur.forfaitinternet.repository.ForfaitInternetRepository;
import com.example.comparateur.forfaitmobile.dto.ForfaitMobileDTO;
import com.example.comparateur.forfaitmobile.entity.ForfaitM;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ForfaitInternetService {


    private final ForfaitInternetRepository forfaitInternetRepository;
    private final ForfaitInternetMapper forfaitInternetMapper;

    public ForfaitInternetService(ForfaitInternetRepository forfaitInternetRepository, ForfaitInternetMapper forfaitInternetMapper) {
        this.forfaitInternetRepository = forfaitInternetRepository;
        this.forfaitInternetMapper = forfaitInternetMapper;
    }

    public ForfaitInternetDto createForfaitInternet(ForfaitInternetDto forfaitInternetDTO) {

        ForfaitInternet forfaitI = new ForfaitInternet();


        forfaitI.setTitle(forfaitInternetDTO.getTitle());
        forfaitI.setDescription(forfaitInternetDTO.getDescription());
        forfaitI.setLien(forfaitInternetDTO.getLien());
        forfaitI.setResume(forfaitInternetDTO.getResume());
        forfaitI.setPricebase(forfaitInternetDTO.getPricebase());
        forfaitI.setPriceoffre(forfaitInternetDTO.getPriceoffre());
        forfaitI.setPeriodoffre(forfaitInternetDTO.getPeriodoffre());
        forfaitI.setIswitheng(forfaitInternetDTO.isIswitheng());
        forfaitI.setDureeofeng(forfaitInternetDTO.getDureeofeng());
        forfaitI.setVisibilite(forfaitInternetDTO.isVisibilite());
        forfaitI.setDtype("Forfait Internet");

        // Set ForfaitM-specific attributes
        forfaitI.setDebit(forfaitInternetDTO.getDebit());
        forfaitI.setNbchaine(forfaitInternetDTO.getNbchaine());
        forfaitI.setNbr_Heure(forfaitInternetDTO.getNbrheure());
        forfaitI.setTechnologie(forfaitInternetDTO.getTechnologie());
        forfaitI.setVitesse(forfaitInternetDTO.getVitesse());
        forfaitI.setWithmobile(forfaitInternetDTO.isWithmobile());
        forfaitI.setWithTV(forfaitInternetDTO.isWithTV());
        forfaitI.setOperateur(forfaitInternetDTO.getOperateur());
        forfaitI.setTypeBox(forfaitInternetDTO.getTypeBox());

        // Save the ForfaitM entity to the repository
        ForfaitInternet savedForfaitInternet = forfaitInternetRepository.save(forfaitI);

        return forfaitInternetMapper.toDto(savedForfaitInternet );
    }



    public List<ForfaitInternetDto> getAllForfaitInternet() {
        List<ForfaitInternet> forfaits = new ArrayList<>();
        forfaitInternetRepository.findAll().forEach(forfaits::add);  // Convert Iterable to List
        return forfaits.stream()
                .map(forfaitInternetMapper::toDto)
                .toList();
    }


    public ResponseEntity<ForfaitInternetDto> getForfaitInternetById(UUID id) {
        Optional<ForfaitInternet> forfaitInternetOptional = forfaitInternetRepository.findById(id);
        return forfaitInternetOptional.map(forfaitInternetMapper::toDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }




    public ResponseEntity<String> updateForfaitInternet(ForfaitInternetDto forfaitInternetDTO) {
        if (forfaitInternetDTO == null || forfaitInternetDTO.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request data");
        }

        Optional<ForfaitInternet> forfaitInternetOptional = forfaitInternetRepository.findById(forfaitInternetDTO.getId());
        if (forfaitInternetOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Forfait Mobile not found");
        }

        ForfaitInternet existingForfaitI= forfaitInternetOptional.get();

        // Update base Forfait properties
        existingForfaitI.setTitle(forfaitInternetDTO.getTitle());
        existingForfaitI.setDescription(forfaitInternetDTO.getDescription());
        existingForfaitI.setLien(forfaitInternetDTO.getLien());
        existingForfaitI.setResume(forfaitInternetDTO.getResume());
        existingForfaitI.setPricebase(forfaitInternetDTO.getPricebase());
        existingForfaitI.setPriceoffre(forfaitInternetDTO.getPriceoffre());
        existingForfaitI.setPeriodoffre(forfaitInternetDTO.getPeriodoffre());
        existingForfaitI.setIswitheng(forfaitInternetDTO.isIswitheng());
        existingForfaitI.setDureeofeng(forfaitInternetDTO.getDureeofeng());
        existingForfaitI.setVisibilite(forfaitInternetDTO.isVisibilite());

        // Update ForfaitM-specific properties
        existingForfaitI.setDebit(forfaitInternetDTO.getDebit());
        existingForfaitI.setNbchaine(forfaitInternetDTO.getNbchaine());
        existingForfaitI.setNbr_Heure(forfaitInternetDTO.getNbrheure());
        existingForfaitI.setTechnologie(forfaitInternetDTO.getTechnologie());
        existingForfaitI.setVitesse(forfaitInternetDTO.getVitesse());
        existingForfaitI.setWithmobile(forfaitInternetDTO.isWithmobile());
        existingForfaitI.setWithTV(forfaitInternetDTO.isWithTV());
        existingForfaitI.setOperateur(forfaitInternetDTO.getOperateur());
        existingForfaitI.setTypeBox(forfaitInternetDTO.getTypeBox());

        // Save the updated entity
        forfaitInternetRepository.save(existingForfaitI);

        return ResponseEntity.ok("Forfait Mobile Updated Successfully");
    }



    public ResponseEntity<String> deleteForfaitInternet (UUID id) {
        if (!forfaitInternetRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Forfait Internet not found");
        }

        forfaitInternetRepository.deleteById(id );

        return ResponseEntity.ok("Forfait Internet Deleted Successfully");
    }
}

