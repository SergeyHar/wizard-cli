package com.sergey.wizardcli.service;

import com.sergey.wizardcli.dto.Elixir;
import com.sergey.wizardcli.dto.Ingredient;
import com.sergey.wizardcli.webclient.WizardClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class ElixirService {

    private final WizardClient wizardClient;

    public List<Elixir> getElixirs() {
        return wizardClient.elixirs();
    }

    public List<Elixir> getElixirsIngredients(Set<Ingredient> ingredients) {
        return getElixirs().stream()
                .filter(elixir -> !elixir.ingredients().isEmpty())
                .filter(elixir -> ingredients.containsAll(elixir.ingredients()))
                .toList();
    }

    public List<Elixir> getElixirsWithoutIngredients() {
        return getElixirs().stream()
                .filter(elixir -> elixir.ingredients().isEmpty())
                .toList();
    }



}
