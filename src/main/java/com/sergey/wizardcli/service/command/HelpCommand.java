package com.sergey.wizardcli.service.command;


import com.sergey.wizardcli.TextHelper;
import org.springframework.stereotype.Component;

@Component("help")
public class HelpCommand implements CommandStrategy {

    @Override
    public void execute(String input) {
        System.out.println(TextHelper.HELP_TEXT);
    }
}
