//Main class for HW2.

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {

            Room room = new Room();

            String[] lines = Files.readString(Path.of("src/instructions.txt")).split("\n");
            for (String line : lines) {
                if (line != null) {
                    String[] parsedInstruction = line.split(",");
                    String user = parsedInstruction[0];
                    String operation = parsedInstruction[1];
                    room.operate(user, operation);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
