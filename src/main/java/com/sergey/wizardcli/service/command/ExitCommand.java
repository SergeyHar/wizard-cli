package com.sergey.wizardcli.service.command;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component("exit")
@RequiredArgsConstructor
public class ExitCommand implements CommandStrategy {

    private final ApplicationContext context;

    @Override
    public void execute(String input) {
        System.exit(SpringApplication.exit(context, () -> 0));
    }
}
