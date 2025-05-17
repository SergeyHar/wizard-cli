package com.sergey.wizardcli.service.command;

import com.sergey.wizardcli.TextHelper;
import com.sergey.wizardcli.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component("ingredients")
@RequiredArgsConstructor
public class IngredientsCommand implements CommandStrategy {


    private final IngredientService ingredientService;

    @Override
    public void execute(String input) {
        List<String> ingredientsName = ingredientService.getIngredientsNames();
        System.out.println("*** Available ingredients are: ***");
        printIngredients(ingredientsName);
        System.out.println(TextHelper.NEXT_STEP_TEXT);

    }

    /**
     * Prints the list of ingredient names grouped by their first uppercase letter.
     * <p>
     * For each group, it prints the first letter as the key, and a comma-separated
     * list of ingredients that start with that letter.
     * <p>
     * Example output:
     * <pre>
     * A -> angelica, ashwagandha
     * M -> mandrake, mint
     * W -> wormwood, water
     * </pre>
     *
     * @param ingredientsName the list of ingredient names to group and print
     */
    private void printIngredients(List<String> ingredientsName) {
        Map<String, List<String>> grouped = ingredientsName.stream()
                .collect(Collectors.groupingBy(name -> name.substring(0, 1).toUpperCase()));
        grouped.forEach((String firstLetter, List<String> ingredients) -> System.out.printf("%s -> %s%n", firstLetter, String.join(", ", ingredients)));
    }

}
