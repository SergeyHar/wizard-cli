package com.sergey.wizardcli.dto;

import java.util.List;

public record Elixir(String id, String name, String effect, String characteristics, String time,
                     String difficulty, List<Ingredient> ingredients) {

}
