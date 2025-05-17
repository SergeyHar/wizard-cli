package com.sergey.wizardcli.service.command;

import com.sergey.wizardcli.TextHelper;
import com.sergey.wizardcli.dto.Elixir;
import com.sergey.wizardcli.service.ElixirService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("phantom elixirs")
@RequiredArgsConstructor
public class PhantomElixirCommand implements CommandStrategy {

    private final ElixirService elixirService;

    @Override
    public void execute(String input) {
        List<Elixir> elixirsWithoutIngredients = elixirService.getElixirsWithoutIngredients();
        if (elixirsWithoutIngredients.isEmpty()) {
            System.out.println("Elixirs without any ingredients don't exist.");
            return;
        }

        System.out.println("No ingredients required for this elixirs.");
        elixirsWithoutIngredients.forEach(e -> System.out.printf("* %s%n", e.name()));
        System.out.println(TextHelper.NEXT_STEP_TEXT);

    }
}
