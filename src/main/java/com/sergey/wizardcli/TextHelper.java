package com.sergey.wizardcli;

public interface TextHelper {

    String HELP_TEXT = """
            ╔═══════════════════════════════════════════════════════════════════════╗
            ║                       WIZARD CLI                                      ║
            ║                                                                       ║
            ║  → To list all ingredients, enter:                ingredients         ║
            ║  → To list all elixirs, enter:                    elixirs             ║
            ║  → To see elixirs without ingredients, enter:     phantom elixirs     ║
            ║  → To view help, enter:                           help                ║
            ║  → To stop the program, enter:                    exit                ║
            ║                                                                       ║
            ║   Please enter a list of ingredients separated by commas              ║
            ║           to find possible elixirs you can create.                    ║
            ╚═══════════════════════════════════════════════════════════════════════╝
            """;


    String NEXT_STEP_TEXT = "\nPlease enter ingredient names to prepare elixirs.\n";

}
