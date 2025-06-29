package com.example.comparateur.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;



@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserDto {
    private UUID id;

    private String favori;

    private String lieuHabitation;

    private Double consommation;

}
