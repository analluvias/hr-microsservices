package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payroll {

    // vem da api de usuários
    private String workerName;

    //passo como parametro (no insomnia por exemplo)
    private String description;

    // vem da api de usuários
    private Double hourlyPrice;

    //passo como parametro (no insomnia por exemplo)
    private Double workedHours;

    //calculado pela pŕopria api
    private Double totalPayment;
}
