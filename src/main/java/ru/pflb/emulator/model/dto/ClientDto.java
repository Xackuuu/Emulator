package ru.pflb.emulator.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    private long id;
    private String firstName;
    private String lastName;
    private String cardNumber;
    private boolean isActive;
}
