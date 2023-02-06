package com.example.demo.feingClients;

import com.example.demo.domain.User;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// "user-api" nome que definimos para a api de user no application.xml daquela api
@FeignClient(name = "user-api")
public interface UserFeign {

    // colocamos aqui as assinaturas de todos os métodos os quais essa api poderá acessar,
    // modificando as urls dos mappings para as quais nós acessamos no navegador

    // como não temos a entidade User aqui, basta copiar a do ms-user e colar em domain,
    // retirando todas as tags de banco de dados e de id.

    @GetMapping(value = "/v1/api/users/{id}")
    ResponseEntity<User> findById(@PathVariable Long id);

    @GetMapping("/v1/api/users")
    ResponseEntity<List<User>> findAll();

}
