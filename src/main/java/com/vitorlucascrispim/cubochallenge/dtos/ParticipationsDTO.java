package com.vitorlucascrispim.cubochallenge.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ParticipationsDTO {

    @NotBlank(message = "Nome do colaborador não pode estar em branco!")
    private String firstName;
    @NotBlank(message = "Sobrenome do colaborador não pode estar em branco!")
    private String lastName;
    @NotNull(message = "Participação do colaborador não pode ser nula!")
    private BigDecimal participation;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getParticipation() {

        return participation.setScale(2,  RoundingMode.HALF_EVEN);
    }

    public void setParticipation(BigDecimal participation) {
        this.participation = participation.setScale(2,  RoundingMode.HALF_EVEN);
    }
}
