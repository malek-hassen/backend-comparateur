package com.example.comparateur.admin.dto;


import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {
    private UUID id;
    private String username;
    private String mail;
    private String password;
    private String role;
}
