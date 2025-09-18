package com.rasmoo.client.raspay.controller;

import com.rasmoo.client.raspay.dto.ProductDto;
import com.rasmoo.client.raspay.model.ProductModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;
import java.util.List;

@Tag(name = "Produto", description = "Um produto é criado para que seja efetuada o pagamento. Esse produto possui um nome e uma sigla única identificadora, que deverá ser informado pelo requisitante. Caso a sigla informada, que deverá ter de 6 a 10 caracteres já esteja criada no banco, a API retornará erro.")
public interface ProductController {

    @Operation(summary = "Criar novo produto", description = "Cria um novo produto com sigla única")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Produto criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao criar produto"),
            @ApiResponse(responseCode = "500", description = "Erro interno no serviço"),
    })
    ResponseEntity<ProductModel> create(@Valid @RequestBody ProductDto dto);

    @Operation(summary = "Lista todos os produtos", description = "Retorna lista completa de produtos cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso na consulta"),
            @ApiResponse(responseCode = "500", description = "Erro interno no serviço"),
    })
    ResponseEntity<List<ProductModel>> readAll();
}