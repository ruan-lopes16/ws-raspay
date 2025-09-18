package com.rasmoo.client.raspay.controller;

import com.rasmoo.client.raspay.dto.CustomerDto;
import com.rasmoo.client.raspay.model.CustomerModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Cliente", description = "Ao receber os dados do Cliente, o sistema deve verificar se já existe na base um cliente com o mesmo e-mail e telefone fornecidos. Caso positivo, o mesmo será atualizado com as novas informações enviadas. Caso não exista, o mesmo será criada. Ao criar ou atualizar o cadastro, a API retorna o 'customer_id' desse cliente, que será utilizado nas próximas etapas de pedido e pagamento.")
public interface CustomerController {

    @Operation(summary = "Cadastrar um novo cliente", description = "Cria ou atualiza um cliente baseado no email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Customer criado ou atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na requisição enviada pelo cliente"),
            @ApiResponse(responseCode = "500", description = "Erro interno no serviço"),
    })
    ResponseEntity<CustomerModel> createCustomer(CustomerDto customerDto);
}