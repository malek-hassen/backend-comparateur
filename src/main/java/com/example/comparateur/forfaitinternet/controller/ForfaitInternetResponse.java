package com.example.comparateur.forfaitinternet.controller;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class ForfaitInternetResponse {
    private UUID id;
    private String title;
}
