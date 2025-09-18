package com.rasmoo.client.raspay.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditCardDto {

    @NotBlank(message = "number é obrigatório")
    @Size(min = 16, max = 16, message = "Cartão inválido")
    private String number;

    @NotNull(message = "cvv é obrigatório")
    @Min(value = 100, message = "CVV deve ter 3 dígitos")
    @Max(value = 999, message = "CVV deve ter 3 dígitos")
    private Long cvv;

    @NotNull(message = "month é obrigatório")
    @Min(value = 1, message = "month não pode ser menor que 1")
    @Max(value = 12, message = "month não pode ser maior que 12") // Correção aqui
    private Long month;

    @NotNull(message = "year é obrigatório")
    @Min(value = 23, message = "year deve ser maior que ano atual")
    @Max(value = 99, message = "year não pode ser maior que 99")
    private Long year;

    @NotBlank(message = "documentNumber é obrigatório")
    @CPF(message = "CPF precisa ser válido")
    private String documentNumber;

    @NotNull(message = "installments é obrigatório")
    @Min(value = 1, message = "Número de parcelas deve ser pelo menos 1")
    @Max(value = 12, message = "Máximo 12 parcelas")
    private Long installments;
}