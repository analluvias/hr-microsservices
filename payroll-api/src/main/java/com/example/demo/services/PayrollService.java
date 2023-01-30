package com.example.demo.services;

import com.example.demo.domain.Payroll;
import com.example.demo.feingClients.UserFeign;
import com.example.demo.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PayrollService {

    //variável que consegue dizer em qual porta
    // o meu servidor está rodando
    private final Environment env;

    //variável que permite o acesso a user-api
    private final UserFeign userFeign;

    public Payroll getPayment(Long id, Payroll payroll){

        // a propriedade que me diz a porta
        // que o servicor está rodando
        log.info("PAYROLL_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port");

        try {

            //acessando a api de user e guardando
            // o body do ResponseEntity na var user
            var user = userFeign.findById(id).getBody();

            if (Objects.nonNull(user)){

                return new Payroll(
                        user.getName(),
                        payroll.getDescription(),
                        user.getHourlyPrice(),
                        payroll.getWorkedHours(),
                        payroll.getWorkedHours() * user.getHourlyPrice()
                        );

            }

        } catch (FeignException.NotFound ex){

            throw new ObjectNotFoundException("Object not found");

        } catch (Exception ex){

            throw new IllegalArgumentException("Illegal argument exception");

        }

        return null;
    }
}
