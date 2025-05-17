package com.sergey.wizardcli.service.command;

import com.sergey.wizardcli.TextHelper;
import com.sergey.wizardcli.dto.Elixir;
import com.sergey.wizardcli.dto.Ingredient;
import com.sergey.wizardcli.service.ElixirService;
import com.sergey.wizardcli.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component("default")
@RequiredArgsConstructor
public class DefaultCommand implements CommandStrategy {

    private final IngredientService ingredientService;
    private final ElixirService elixirService;

    @Override
    public void execute(String input) {
        Set<Ingredient> ingredientList = ingredientService.getIngredientsByNames(input);


        if (ingredientList.isEmpty()) {
            System.out.println("No ingredients found from provided list.");
            return;
        }

        List<Elixir> elixirList = elixirService.getElixirsIngredients(ingredientList);

        if (elixirList.isEmpty()) {
            System.out.printf("The provided ingredients are not enough to make an elixir.");
            return;
        }

        elixirList.forEach(e -> System.out.printf("* %s, ingredients: %s%n", e.name(), e.ingredients().stream().map(Ingredient::name).toList()));
        System.out.println(TextHelper.NEXT_STEP_TEXT);
    }


}
