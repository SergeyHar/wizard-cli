package com.sergey.wizardcli.webclient;

import com.sergey.wizardcli.dto.Elixir;
import com.sergey.wizardcli.dto.Ingredient;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange("https://wizard-world-api.herokuapp.com")
public interface WizardClient {

    @GetExchange("/ingredients")
    List<Ingredient> ingredients();

    @GetExchange("/Elixirs")
    List<Elixir> elixirs();


}
