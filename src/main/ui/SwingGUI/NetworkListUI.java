package ui.SwingGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Connection;
import model.ConnectionField;
import model.Network;

public class NetworkListUI extends JFrame {

    private JFrame frame;
    private JPanel networkView;
    private Network network;
    private List<Connection> connections;

    // EFFECTS: contrut JSwing display for network list view constructor
    // CITATION: Refered to LabelChanger and DrawingEditor,
    // additionaly Java Code Junki "Learnn Java Swing Programming" Playlist
    public NetworkListUI(Network network) {
        this.network = network;
        connections = network.getConnections();
        initJFrame();

    }

    ////////////////////////////////////////////////////////

    /* ---------- Initialization Methods ------------ */

    ////////////////////////////////////////////////////////

    // MODIFIES: this
    // EFFECTS: initialize the application JFrame starting values
    // CITATION: Refered to Java Code Junki "Learnn Java Swing Programming" Playlist
    public void initJFrame() {
        frame = new JFrame();
        frame.setTitle("Network List");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);

        networkListDisplay();

        frame.setVisible(true);

    }

    // MODIFIES: this
    // EFFECTS: creates main menu display
    public void networkListDisplay() {
        networkView = new JPanel();
        networkView.setLayout(new BoxLayout(networkView, BoxLayout.Y_AXIS));

        for (Connection connection : connections) {

            networkView.add(card(connection));
        }

        JScrollPane scroll = new JScrollPane(networkView);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        frame.add(scroll);

    }

    // MODIFIES: this
    // EFFECTS: creates card for connection
    public JPanel card(Connection connection) {
        JPanel card = new JPanel();

        card.setMaximumSize(new Dimension(500, 300));
        card.setMinimumSize(new Dimension(200, 300));

        card.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        card.setBorder(BorderFactory.createLineBorder(Color.red));

        JLabel name = createInfo("Name: ", connection.getField(ConnectionField.NAME));
        card.add(name, BorderLayout.LINE_END);

        JLabel jobTitle = createInfo("Job Title: ", connection.getField(ConnectionField.JOBTITLE));
        card.add(jobTitle, BorderLayout.LINE_END);

        createEditButton(card, connection);
        createDeleteButton(card, connection);

        return card;
    }

    // MODIFIES: this
    // EFFECTS: creates card info
    public JLabel createInfo(String title, String text) {

        JLabel info = new JLabel(title + text);
        info.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 10));

        return info;
    }

    ////////////////////////////////////////////////////////

    /* ---------- Button Functionality ------------ */

    ////////////////////////////////////////////////////////

    // MODIFIES: this
    // EFFECTS: creates edit button for connection card
    public void createEditButton(JPanel card, Connection connection) {
        JButton button = createButton("Edit");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new EditMenuUI(connection);

                networkView.revalidate();
                networkView.repaint();

            }
        });

        card.add(button);

    }

    // MODIFIES: this
    // EFFECTS: creates edit button for connection card
    public void createDeleteButton(JPanel card, Connection connection) {
        JButton button = createButton("Delete");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RIP(connection.getField(ConnectionField.NAME));

                networkView.remove(card);
                networkView.revalidate();
                networkView.repaint();

                network.removeConnection(connection);

            }
        });

        card.add(button);

    }

    // MODIFIES: this
    // EFFECTS: creates button with set dimention and givin name
    public JButton createButton(String name) {
        JButton button = new JButton(name);

        button.setFocusable(false);
        button.setPreferredSize(new Dimension(100, 25));

        return button;
    }

}
