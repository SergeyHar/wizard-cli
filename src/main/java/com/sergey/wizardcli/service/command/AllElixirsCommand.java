package com.sergey.wizardcli.service.command;

import com.sergey.wizardcli.TextHelper;
import com.sergey.wizardcli.dto.Elixir;
import com.sergey.wizardcli.dto.Ingredient;
import com.sergey.wizardcli.service.ElixirService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("elixirs")
@RequiredArgsConstructor
public class AllElixirsCommand implements CommandStrategy {


    private final ElixirService elixirService;

    @Override
    public void execute(String input) {
        List<Elixir> elixirs = elixirService.getElixirs();
        if (elixirs.isEmpty()) {
            System.out.println("Elixirs Not Found.");
            return;
        }

        elixirs.forEach(e -> System.out.printf("* %s, ingredients: %s%n", e.name(), e.ingredients().stream().map(Ingredient::name).toList()));
        System.out.println(TextHelper.NEXT_STEP_TEXT);

    }
}
