package ui;

import java.io.FileNotFoundException;

public class TerminalLauncher {

    public static void main(String[] args) throws Exception {
        try {
            new TerminalNetworkManager();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }

    }
}
