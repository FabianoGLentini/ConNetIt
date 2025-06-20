package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Connection;
import model.ConnectionField;

// window to edits current connection fields
public class EditMenuUI extends JFrame implements ActionListener {
    private JFrame frame;
    private JTextField name;
    private JTextField pronouns;
    private JTextField company;
    private JTextField jobTittle;
    private JTextField description;
    private JPanel fullOptions;
    private JPanel section;
    private JPanel btnSection;
    private JButton btnConfirm;
    private Connection connection;

    // EFFECTS: set up window to edit connection
    public EditMenuUI(Connection connection) {
        this.connection = connection;

        frame = new JFrame();
        frame.setTitle("Connection");

        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        addEditDisplay();

        frame.add(fullOptions);
        frame.setVisible(true);

    }

    // MODIFIES: this
    // EFFECTS: creates and set up all add edit display & functionality
    public void addEditDisplay() {
        fullOptions = new JPanel();

        fullOptions.setLayout(new BoxLayout(fullOptions, BoxLayout.Y_AXIS));
        fullOptions.setSize(500, 600);

        JPanel namePanel = createName();
        JPanel pronounsPanel = createPonoun();
        JPanel companyPanel = createCompany();
        JPanel jobTittlePanel = createJobTittlePanel();
        JPanel descriptionPanel = createPonounDescription();

        fullOptions.add(namePanel);
        fullOptions.add(pronounsPanel);
        fullOptions.add(companyPanel);
        fullOptions.add(jobTittlePanel);
        fullOptions.add(descriptionPanel);

        JPanel btnDiv = btnSection();
        fullOptions.add(btnDiv);
    }

    // MODIFIES: this
    // EFFECTS: creates name panel
    public JPanel createName() {
        name = new JTextField(20);
        name.setText(connection.getField(ConnectionField.NAME));

        return createPanelField("Name: ", name);
    }

    // MODIFIES: this
    // EFFECTS: creates pronoun panel
    public JPanel createPonoun() {
        pronouns = new JTextField(20);
        pronouns.setText(connection.getField(ConnectionField.PRONOUNS));

        return createPanelField("pronouns: ", pronouns);
    }

    // MODIFIES: this
    // EFFECTS: creates company panel
    public JPanel createCompany() {
        company = new JTextField(20);
        company.setText(connection.getField(ConnectionField.COMPANY));

        return createPanelField("company: ", company);
    }

    // MODIFIES: this
    // EFFECTS: creates jobTittle panel
    public JPanel createJobTittlePanel() {
        jobTittle = new JTextField(20);
        jobTittle.setText(connection.getField(ConnectionField.JOBTITTLE));

        return createPanelField("jobTittle: ", jobTittle);
    }

    // MODIFIES: this
    // EFFECTS: creates Description panel
    public JPanel createPonounDescription() {
        description = new JTextField(20);
        description.setText(connection.getField(ConnectionField.DESCRIPTION));

        return createPanelField("Description: ", description);
    }

    // MODIFIES: this
    // EFFECTS: creates panel with input text field
    public JPanel createPanelField(String title, JTextField input) {
        section = new JPanel();

        section.setMaximumSize(new Dimension(500, 100));
        section.setMinimumSize(new Dimension(200, 50));
        section.setBackground(Color.green);

        JLabel label = new JLabel(title);

        input.setPreferredSize(new Dimension(150, 25));

        section.add(label);
        section.add(input);

        section.setBorder(BorderFactory.createLineBorder(Color.red));
        return section;
    }

    ////////////////////////////////////////////////////////

    /* ---------- Button Functionality ------------ */

    ////////////////////////////////////////////////////////

    // MODIFIES: this
    // EFFECTS: creates button section display
    public JPanel btnSection() {
        btnSection = new JPanel(new FlowLayout());
        btnSection.setMaximumSize(new Dimension(500, 50));
        btnSection.setMinimumSize(new Dimension(200, 50));
        btnSection.setBackground(Color.red);

        btnConfirm = createSubmitButton();

        btnSection.add(btnConfirm);

        return btnSection;
    }

    // MODIFIES: this
    // EFFECTS: creates confirm button to create new connection
    // CITATION: reference java textfield by Bro Code
    // https://www.youtube.com/watch?v=dyDDUndlMnU
    public JButton createSubmitButton() {
        JButton button = createButton("Submit");
        button.addActionListener(this);

        return button;

    }

    // MODIFIES: this
    // EFFECTS: creates button with set dimention and givin name
    public JButton createButton(String name) {
        JButton button = new JButton(name);

        button.setFocusable(false);
        button.setPreferredSize(new Dimension(100, 25));

        return button;
    }

    // MODIFIES: this
    // EFFECTS: creates new Connection and adds to network from textfield
    // CITATION: reference java textfield by Bro Code
    // https://www.youtube.com/watch?v=dyDDUndlMnU
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConfirm) {
            String nameInput = name.getText();
            String pronounsInput = pronouns.getText();
            String companyInput = company.getText();
            String jobTittleInput = jobTittle.getText();
            String descriptionInput = description.getText();

            connection.setField(ConnectionField.NAME, nameInput);
            connection.setField(ConnectionField.PRONOUNS, pronounsInput);
            connection.setField(ConnectionField.COMPANY, companyInput);
            connection.setField(ConnectionField.JOBTITTLE, jobTittleInput);
            connection.setField(ConnectionField.DESCRIPTION, descriptionInput);

            frame.dispose();
        }
    }

}
