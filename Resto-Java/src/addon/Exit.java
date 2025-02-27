package addon;

import java.io.IOException;
import java.util.Scanner;

public class Exit {
    public static void exitProgram(Scanner scanner) {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("⚠️ Impossible d'effacer la console.");
        }
    }
}
