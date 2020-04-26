//Main class for HW2.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        try {

            //creating room object
            Room room = new Room();

            //getting all lines from file.
            Path path = Paths.get("src/instructions.txt");
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                if (line != null) {

                    //Parsing the line
                    String[] parsedInstruction = line.split(",");
                    String opr = parsedInstruction[0];
                    String opn = parsedInstruction[1];

                    //creating operation object
                    Operation operation = new Operation(opr, opn);

                    //operating the operation
                    room.operate(operation);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException ignored) {

        }
    }
}
