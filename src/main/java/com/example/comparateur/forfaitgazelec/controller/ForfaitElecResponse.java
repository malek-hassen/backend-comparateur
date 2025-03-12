package com.example.comparateur.forfaitgazelec.controller;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class ForfaitElecResponse {

    private UUID Id;
    private String title;
}
