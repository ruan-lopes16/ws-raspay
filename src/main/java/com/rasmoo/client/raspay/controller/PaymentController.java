package com.rasmoo.client.raspay.controller;

import com.rasmoo.client.raspay.dto.PaymentDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

@Tag(name = "Pagamento", description = "Para a última etapa, é necessário informar o 'customer_id', o 'order_id' e as informações do cartão de crédito. Um mesmo cartão de crédito não poderá ser usado por clientes diferentes e, além disso, um mesmo cliente não poderá fazer dois pagamentos fora do período de renovação, mesmo que com um cartão de crédito novo.")
public interface PaymentController {

    @Operation(summary = "Processar pagamento", description = "Processa o pagamento com cartão de crédito")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pagamento realizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao processar pagamento"),
            @ApiResponse(responseCode = "401", description = "Pagamento não autorizado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no serviço"),
    })
    ResponseEntity<Boolean> process(@Valid @RequestBody PaymentDto dto);
}