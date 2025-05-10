package ui;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.List;
import java.util.Scanner;

import model.Connection;
import model.ConnectionField;
import model.Network;
import persistence.JsonReader;
import persistence.JsonWriter;

// A network cataloging application that allows users to add, filter, sort and update Connections within network
// CITATION: Most of this class is code pulled, used or inspired from Lab4.2 class FlashcardReview
public class TerminalNetworkManager {
    private static final String JSON_STORE = "./data/network.json";
    private Scanner scanner;
    private boolean isProgramRunning;
    private Connection currSelected;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private Network network;

    // EFFECTS: Creates instance of NetworkManager console ui application
    // CITATION: code pulled, used or inspired from Lab4.2 class FlashcardReview
    // USED METHOD: FlashcardReviewer()
    // CITATION: code pulled, used or inspired from JsonSerialization
    public TerminalNetworkManager() throws FileNotFoundException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        this.network = new Network("Fabiano");

        init();

        printDivider();
        System.out.print("Welcome to the NetIt app! Map your connections today!");
        printDivider();

        while (isProgramRunning) {
            handleMenu();

        }

    }

    // MODIFIES: this
    // EFFECTS: initialize the application with the starting values
    // CITATION: code pulled, used or inspired from Lab4.2 class FlashcardReview
    // USED METHOD: init()
    public void init() {
        this.scanner = new Scanner(System.in);
        currSelected = null;
        this.isProgramRunning = true;

    }

    // EFFECTS: display and handles inputs for the main menu
    // CITATION: code pulled, used or inspired from Lab4.2 class FlashcardReview
    // USED METHOD: handleMenu()
    public void handleMenu() {
        displayMenu();
        String input = this.scanner.nextLine();
        processMenuCommands(input);
    }

    // EFFECTS: displays a list of commands that can be used in the main menu
    // CITATION: code pulled, used or inspired from Lab4.2 class FlashcardReview
    // USED METHOD: displayMenu()
    public void displayMenu() {
        System.out.println("Please select an option:\n");
        System.out.println("a: add new Connection");
        System.out.println("v: View Network List, name and company");
        System.out.println("s: save network");
        System.out.println("l: load network");
        System.out.println("q: Exit the application");
        printDivider();
    }

    // EFFECTS: processes the user's input in the main menu
    // CITATION: code pulled, used or inspired from Lab4.2 class FlashcardReview
    // USED METHOD: processMenuCommands()
    public void processMenuCommands(String input) {
        printDivider();
        switch (input) {
            case "a":
                createNewConnection();
                break;
            case "v":
                viewConnections();
                break;
            case "s":
                saveNetwork();
                break;
            case "l":
                loadNetwork();
                break;
            case "q":
                quitApplication();
                break;
            default:
                System.out.println("Invalid option inputted. Please try again.");
        }
        printDivider();
    }

    // MODIFIES: this
    // EFFECTS: prints a closing message and marks the program as not running
    // CITATION: code pulled, used or inspired from Lab4.2 class FlashcardReview
    // USED METHOD: quitApplication()
    public void quitApplication() {
        System.out.println("Net you later!");
        this.isProgramRunning = false;
    }

    // MODIFIES: this
    // EFFECTS: adds a Connection to the list of Connections in network
    // CITATION: code pulled, used or inspired from Lab4.2 class FlashcardReview
    // USED METHOD: addNewFlashcard()
    public void createNewConnection() {
        System.out.println("Please enter the connection's name:");
        String name = this.scanner.nextLine();

        System.out.println("\nPlease enter the connection's pronouns:");
        String pronouns = this.scanner.nextLine();

        System.out.println("\nPlease enter the connection's company:");
        String company = this.scanner.nextLine();

        System.out.println("\nPlease enter the connection's jobTittle:");
        String jobTittle = this.scanner.nextLine();

        System.out.println("\nPlease enter the connection's description; where you met and how:");
        String description = this.scanner.nextLine();

        Connection connection = new Connection(name, pronouns, company, jobTittle, description);

        network.addConnection(connection);
        System.out.println("\nNew connection successfully created!");
    }

    // MODIFIES: this
    // EFFECTS: displays all Network Connections list one at a time
    // CITATION: code pulled, used or inspired from Lab4.2 class FlashcardReview
    // USED METHOD: viewFlashcards()
    public void viewConnections() {
        List<Connection> networkList = network.getConnections();
        displayGivenConnections(networkList);

    }

    // MODIFIES: this
    // EFFECTS: displays the given list of Connections name and company
    // CITATION: code pulled, used or inspired from Lab4.2 class FlashcardReview
    // USED METHOD: displayGivenFlashcards()
    public void displayGivenConnections(List<Connection> networkList) {
        if (networkList.isEmpty()) {
            System.out.println("Error: No Connections to view. Try adding a Connection first!");
            return;
        }

        for (Connection connection : networkList) {
            displayConnectionNameAndCompany(connection);

        }

        displayViewMenu();
        String input = this.scanner.nextLine();
        handleViewCommands(input);
    }

    // EFFECTS: displays the answer of the given Connection
    // CITATION: code pulled, used or inspired from Lab4.2 class FlashcardReview
    // USED METHOD: displayFlashcardAnswer()
    public void displayConnectionNameAndCompany(Connection connection) {
        String name = connection.getField(ConnectionField.NAME);
        String company = connection.getField(ConnectionField.COMPANY);

        System.out.println("Name: " + name);
        System.out.println("Company: " + company);
        printDivider();
    }

    // EFFECTS: displays a list of commands that can be used in the view network
    // menu
    // CITATION: code pulled, used or inspired from Lab4.2 class FlashcardReview
    // USED METHOD: displayViewMenu()
    public void displayViewMenu() {
        System.out.println("Enter 's'select a Connection's");
        System.out.println("Enter 'q' to return to the menu.");
    }

    // MODIFIES: this
    // EFFECTS: processes the user's input in the view viewConnections menu
    // CITATION: code pulled, used or inspired from Lab4.2 class FlashcardReview
    // USED METHOD: handleViewCommands()
    public void handleViewCommands(String input) {
        System.out.print("\n");

        switch (input) {
            case "s":
                handleSelectionCommands();
                break;
            case "e":
                handleEditConnection();
                break;
            case "x":
                network.removeConnection(currSelected);
                System.out.println("Connection Deleted");
                break;
            case "q":
                System.out.println("Returning to the menu...");
                break;
            default:
                System.out.println("Invalid option inputted. Please try again.");

        }

        currSelected = null;
    }

    // MODDIFIES: this
    // EFFECTS: handles commands for selection and changes this.currSelected to
    // named connection
    // CITATION: code pulled, used or inspired from Lab4.2 class FlashcardReview
    // USED METHOD: displayGivenFlashcards()
    public void handleSelectionCommands() {
        String inputName = "";

        while (!inputName.equals("q")) {
            displaySelectionView();
            inputName = scanner.nextLine();
            printDivider();

            if (inputName.equals("q")) {
                continue;
            }

            if (this.network.getConnection(inputName) == null) {
                System.out.println("Invalid name " + inputName + " not in Network");

            } else {
                currSelected = network.getConnection(inputName);
                selectAndView();

            }
        }

    }

    // EFFECTS: displays a list of commands to be used for handleSelectionCommands
    // CITATION: code pulled, used or inspired from Lab4.2 class FlashcardReview
    // USED METHOD: displayViewMenu()
    public void displaySelectionView() {
        System.out.println("Enter: 'q' to return to the menu.");
        System.out.println("Enter: name of connection you wish to select");

    }

    // REQUIRE: currentSelecte != null
    // MODDIFIES: this
    // EFFECTS: displays selection and provides options to manage connection
    public void selectAndView() {

        String input = "";

        printDivider();
        System.out.println("Name:" + currSelected.getField(ConnectionField.NAME));
        System.out.println("Pronouns:" + currSelected.getField(ConnectionField.PRONOUNS));
        System.out.println("Company:" + currSelected.getField(ConnectionField.COMPANY));
        System.out.println("Job Tittle:" + currSelected.getField(ConnectionField.JOBTITLE));
        System.out.println("Description:" + currSelected.getField(ConnectionField.DESCRIPTION));

        connectionViewMenu();
        input = scanner.nextLine();

        handleViewCommands(input);
    }

    // EFFECTS: displays a list of commands that can be used in the for selection
    // selectAndView menu
    // CITATION: code pulled, used or inspired from Lab4.2 class FlashcardReview
    // USED METHOD: displayViewMenu()
    public void connectionViewMenu() {
        System.out.println("Enter 'e' to edit selected connection info");
        System.out.println("Enter 'x' to delete connection");
        System.out.println("Enter 'q' to return to the menu.");

    }
    ////////////////////////////////////////////////////////

    /* ---------- Connection Editing Methods ------------ */

    ////////////////////////////////////////////////////////

    // EFFECTS: display and handles inputs for the editing selected connection
    public void handleEditConnection() {
        editConnectionDisplay();
        String input = this.scanner.nextLine();
        processeEditConnectionCommands(input);
    }

    // EFFECTS: processes inputed commmand for editing selected connection
    public void processeEditConnectionCommands(String input) {
        System.out.print("\n");

        switch (input) {
            case "n":
                editConnectionVar(ConnectionField.NAME, "name");
                break;
            case "p":
                editConnectionVar(ConnectionField.PRONOUNS, "pronouns");
                break;
            case "c":
                editConnectionVar(ConnectionField.COMPANY, "compnay");
                break;
            case "j":
                editConnectionVar(ConnectionField.JOBTITLE, "job tittle");
                break;
            case "d":
                editConnectionVar(ConnectionField.DESCRIPTION, "discription");
                break;
            case "q":
                System.out.println("Returning to the menu...");
            default:
                System.out.println("Invalid option inputted. Please try again.");

        }

    }

    // EFFECTS: displays editing connection options
    public void editConnectionDisplay() {
        System.out.println("Enter 'n' to edit connection name");
        System.out.println("Enter 'p' to edit connection pronouns");
        System.out.println("Enter 'c' to edit connection company");
        System.out.println("Enter 'j' to edit connection job tittle");
        System.out.println("Enter 'd' to edit connection description");
        System.out.println("Enter: 'q' to return to the menu.");
    }

    // MODIFFIES: this
    // EFFECTS: Display sub edit menu view based on editing
    public void editSubMenuDisplay(String editing) {
        System.out.println("Enter updated " + editing);

    }

    /*------- Edit For Connections Field -------*/

    // MODIFIES: this
    // EFFECTS: changes connection name base on user input
    public void editConnectionVar(ConnectionField field, String fieldStr) {

        editSubMenuDisplay(fieldStr);

        String input = this.scanner.nextLine();
        currSelected.setField(field, input);

        System.out.println("Succefully Edidted " + fieldStr + "!");
    }

    // EFFECTS: prints out a line of dashes to act as a divider
    // CITATION: code pulled, used or inspired from Lab4.2 class FlashcardReview
    // USED METHOD: printDivider()
    private void printDivider() {
        System.out.println("<---------------------------------------->");
    }

    ////////////////////////////////////////////////////////

    /* ---------- Save And Load------------ */

    ////////////////////////////////////////////////////////

    // EFFECTS: saves the Network to file
    // CITATION: code pulled, used or inspired from JsonSerialization
    private void saveNetwork() {
        try {
            jsonWriter.open();
            jsonWriter.write(network);
            jsonWriter.close();
            System.out.println("Saved " + network.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads Network from file
    // CITATION: code pulled, used or inspired from JsonSerialization
    private void loadNetwork() {
        try {
            network = jsonReader.read();
            System.out.println("Loaded " + network.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}
