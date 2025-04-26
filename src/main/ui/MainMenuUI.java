package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Connection;
import model.ConnectionField;
import model.LogPrinting;
import model.Network;
import persistence.JsonReader;
import persistence.JsonWriter;

//Represents application's main window Jframe.
public class MainMenuUI extends JFrame {
    private static final String JSON_STORE = "./data/network.json";
    private Connection currSelected;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private JPanel mainMenu;

    private Network network;
    private JFrame frame;

    // EFFECTS: contrut JSwing display for main menu constructor for initial gui
    // launch
    // CITATION: Refered to LabelChanger and DrawingEditor,
    // additionaly Java Code Junki "Learnn Java Swing Programming" Playlist
    public MainMenuUI() {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        initNetwork();

        initJFrame();

    }

    ////////////////////////////////////////////////////////

    /* ---------- Initialization Methods ------------ */

    ////////////////////////////////////////////////////////

    // MODIFIES: this
    // EFFECTS: initialize the application with the starting values
    public void initNetwork() {
        this.network = new Network("Fabiano");
        currSelected = null;
    }

    // MODIFIES: this
    // EFFECTS: initialize the application JFrame starting values
    // CITATION: Refered to Java Code Junki "Learnn Java Swing Programming" Playlist
    // and https://stackoverflow.com/questions/7073412/awt-window-close-listener-event
    public void initJFrame() {

        frame = new JFrame();
        frame.setTitle("NetIt App");

        mainMenuDisplay();

        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(175, 200);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.add(mainMenu, BorderLayout.CENTER);

        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                LogPrinting.printLog();
            }

        });

    }

    ////////////////////////////////////////////////////////

    /* ---------- Display ------------ */

    ////////////////////////////////////////////////////////

    // MODIFIES: this
    // EFFECTS: creates main menu display
    public void mainMenuDisplay() {
        mainMenu = new JPanel();
        mainMenu.setLayout(new FlowLayout());
        mainMenu.setBackground(Color.red);
        mainMenuHandButtons();

    }

    // MODIFIES: this
    // EFFECTS: creates and set up all main menu buttons for display & functionality
    public void mainMenuHandButtons() {
        createAddConnectioneButton();
        createViewNetworkButton();
        createSaveNetworkButton();
        createLoadNetworkButton();
        createExitWithoutSavingButton();
        // mainMenu.add(new JButton(new PrintLogAction()));
        // mainMenu.add(createPrintCombo());

    }

    ////////////////////////////////////////////////////////

    /* ---------- Button Functionality ------------ */

    ////////////////////////////////////////////////////////

    // MODIFIES: this
    // EFFECTS: creates add Connection button and adds to mainMenu
    public void createAddConnectioneButton() {
        JButton button = createButton("Add Connection");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEditConnectionUI(network);

            }
        });

        mainMenu.add(button);

    }

    // MODIFIES: this
    // EFFECTS: creates view list button and adds to mainMenu
    public void createViewNetworkButton() {
        JButton button = createButton("View List");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewConnections();
            }
        });

        mainMenu.add(button);

    }

    // MODIFIES: this
    // EFFECTS: creates save button and adds to mainMenu
    public void createSaveNetworkButton() {
        JButton button = createButton("Save");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveNetwork();
            }
        });

        mainMenu.add(button);

    }

    // MODIFIES: this
    // EFFECTS: creates load button and adds to mainMenu
    public void createLoadNetworkButton() {
        JButton button = createButton("Load");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadNetwork();
            }
        });

        mainMenu.add(button);

    }

    // MODIFIES: this
    // EFFECTS: creates exit button and adds to mainMenu
    public void createExitWithoutSavingButton() {
        JButton button = createButton("Exit");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogPrinting.printLog();
                System.exit(0);
            }
        });

        mainMenu.add(button);

    }

    // MODIFIES: this
    // EFFECTS: creates button with set dimention and givin name
    public JButton createButton(String name) {
        JButton button = new JButton(name);

        button.setFocusable(false);
        button.setPreferredSize(new Dimension(150, 25));

        return button;
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
            // System.out.println("Saved " + network.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            // System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads Network from file
    // CITATION: code pulled, used or inspired from JsonSerialization
    private void loadNetwork() {
        try {
            network = jsonReader.read();
            // System.out.println("Loaded " + network.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            // System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    ////////////////////////////////////////////////////////

    /* ---------- View Connection ------------ */

    ////////////////////////////////////////////////////////

    // MODIFIES: this
    // EFFECTS: displays all Network Connections list one at a time
    // CITATION: code pulled, used or inspired from Lab4.2 class FlashcardReview
    // USED METHOD: viewFlashcards()
    public void viewConnections() {
        List<Connection> networkList = network.getConnections();
        displayGivenConnections(networkList);
        new NetworkListUI(network);

    }

    ////////////////////////////////////////////////////////

    /* ---------- TMP view print ------------ */

    ////////////////////////////////////////////////////////

    // MODIFIES: this
    // EFFECTS: displays the given list of Connections name and company
    // CITATION: code pulled, used or inspired from Lab4.2 class FlashcardReview
    // USED METHOD: displayGivenFlashcards()
    public void displayGivenConnections(List<Connection> networkList) {
        if (networkList.isEmpty()) {
            // System.out.println("Error: No Connections to view. Try adding a Connection
            // first!");
            return;
        }

        for (Connection connection : networkList) {
            displayConnectionNameAndCompany(connection);

        }

    }

    // EFFECTS: displays the answer of the given Connection
    // CITATION: code pulled, used or inspired from Lab4.2 class FlashcardReview
    // USED METHOD: displayFlashcardAnswer()
    public void displayConnectionNameAndCompany(Connection connection) {
        String name = connection.getField(ConnectionField.NAME);
        String company = connection.getField(ConnectionField.COMPANY);

    }

}
