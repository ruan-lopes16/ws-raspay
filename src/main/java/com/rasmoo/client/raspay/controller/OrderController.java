package com.rasmoo.client.raspay.controller;

import com.rasmoo.client.raspay.dto.OrderDto;
import com.rasmoo.client.raspay.model.OrderModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

@Tag(name = "Pedido", description = "Para enviar os dados do produto e do cliente, é preciso enviar o 'customer_id' obtido na última chamada. A API irá retornar o 'order_id' que será utilizado na etapa de pagamento. A única opção transação liberada é por meio de um cartão de crédito.")
public interface OrderController {

    @Operation(summary = "Cadastrar um novo pedido", description = "Cria um pedido vinculando cliente e produto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pedido criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição do pedido"),
            @ApiResponse(responseCode = "500", description = "Erro interno no serviço"),
    })
    ResponseEntity<OrderModel> create(@Valid @RequestBody OrderDto orderDto);
}