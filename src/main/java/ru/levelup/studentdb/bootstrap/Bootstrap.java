package ru.levelup.studentdb.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.levelup.studentdb.service.CommandProcessor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private final CommandProcessor processor;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Please, enter command");
        System.out.print(">");

        // create student FirstName LastName
        // list students
        // create group GroupName
        // list groups
        // save
        // load

        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //check:at least 2 words should be entered in line
        //need to enter: 'create group' to add new group
        //need to enter: 'list group' to show list of groups
        while (!(line = reader.readLine()).equals("exit")) {
            String[] tokens = line.split(" ");
            if (tokens.length < 2) {
                System.out.println("wrong number of params");
            } else {
                String operation = tokens[0] + " " + tokens[1];
                if (operation.equals("create group")) {
                    tokens[0] = tokens[1];
                } else if (operation.equals("list group")) {
                    tokens[0] = "grouplist";
                }
                processor.process(tokens[0], Arrays.copyOfRange(tokens, 1, tokens.length));
            }
        }

        System.out.println();
    }

}
