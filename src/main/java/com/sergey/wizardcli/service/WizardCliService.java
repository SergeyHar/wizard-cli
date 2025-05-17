package com.sergey.wizardcli.service;

import com.sergey.wizardcli.dto.Ingredient;
import com.sergey.wizardcli.service.command.CommandStrategy;
import com.sergey.wizardcli.service.command.DefaultCommand;
import com.sergey.wizardcli.TextHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Slf4j
@RequiredArgsConstructor
@Component
public class WizardCliService implements CommandLineRunner {

    private final Map<String, CommandStrategy> commandStrategyMap;
    private final DefaultCommand defaultCommand;
    private final IngredientService ingredientService;

    @Override
    public void run(String... args) {
        List<Ingredient> ingredients = ingredientService.getIngredients();
        if (ingredients.isEmpty()) {
            log.error("No ingredients found.");
            return;
        }

        System.out.println(TextHelper.HELP_TEXT);

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                continue;
            }
            CommandStrategy strategy = commandStrategyMap.getOrDefault(input, defaultCommand);
            strategy.execute(input);

        }
    }

//    Neem oil, Jewelweed,     Onion juice
}
