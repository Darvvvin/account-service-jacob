package com.apper;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateAccountResponse {
    private LocalDateTime lastUpdate;
}
