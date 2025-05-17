package com.sergey.wizardcli.service;

import com.sergey.wizardcli.dto.Ingredient;
import com.sergey.wizardcli.webclient.WizardClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


@Slf4j
@AllArgsConstructor
@Service
public class IngredientService {

    private final WizardClient wizardClient;


    public List<Ingredient> getIngredients() {
        return wizardClient.ingredients();
    }

    public Set<Ingredient> getIngredientsByNames(String ingredientsNames) {
        Map<String, Ingredient> ingredientMap = ingredientHashMap();
        return Arrays.stream(ingredientsNames.split(","))
                .map(name -> {
                    name = name.trim();
                    if (ingredientMap.containsKey(name.toLowerCase())) {
                        return ingredientMap.get(name.toLowerCase());
                    } else {
                        log.warn("Ingredient not found: {}", name);
                    }

                    return null;
                })
                .collect(Collectors.toCollection(HashSet::new));
    }

    private Map<String, Ingredient> ingredientHashMap() {
        return getIngredients().stream().collect(Collectors.toMap(i -> i.name().toLowerCase(), Function.identity()));
    }

    public List<String> getIngredientsNames() {
        return getIngredients().stream().sorted(Comparator.comparing(Ingredient::name)).map(Ingredient::name).toList();

    }
}
