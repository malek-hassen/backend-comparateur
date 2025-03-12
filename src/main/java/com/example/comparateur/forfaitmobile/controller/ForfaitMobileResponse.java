package com.example.comparateur.forfaitmobile.controller;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class ForfaitMobileResponse {
    private UUID Id;
    private String titre;
}
