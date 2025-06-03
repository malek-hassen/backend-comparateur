package com.example.comparateur.operateur.dto;

import lombok.*;


import java.util.UUID;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperateurDTO {
    private UUID id;
    private String nom;
    private String url;


}
