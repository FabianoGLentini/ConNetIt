package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// create splash screen for visual impact 
public class RIP extends JFrame {
    private JFrame frame;
    private JPanel trashed;
    private JLabel label;

    public RIP(String name) {
        frame = new JFrame();
        frame.setTitle("NetIt App");

        label = new JLabel(name);
        label.setForeground(Color.white);
        label.setFont(new Font("Sans-serif", Font.BOLD, 36));
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.TOP);
        ImageIcon image = new ImageIcon("images\\giphy.gif");

        label.setIcon(image);

        trashed = new JPanel();
        trashed.add(label);

        trashed.setLayout(new FlowLayout());
        trashed.setBackground(Color.red);

        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);

        frame.add(trashed, BorderLayout.CENTER);

        frame.setVisible(true);

    }

}
