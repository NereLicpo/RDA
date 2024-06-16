import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bathroom {

    private JFrame frame;
    private JPanel panelContainer;
    private JPanel panel1;
    private JPanel panel2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    bathroom window = new bathroom();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public bathroom() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Bathroom Adventure");
        
        // Initialize the panel container with CardLayout
        panelContainer = new JPanel(new CardLayout());

        // Initialize panel1 with BorderLayout
        panel1 = new JPanel(new BorderLayout());

        // Create and configure the text area
        JTextArea textArea = new JTextArea("You chose to go to the bathroom. Every good morning starts with you brushing your teeth and taking your daily medication. It’s not medication for your heart, but rather your mind. You sourly started to call them your ‘happy pills’ that you have to take if you want to remain somewhat functional and normal. You still remember the day when feeling a certain way was the least of your concerns, but now it got to the point where it is a priority no matter where you are headed.\n\nBrushing your teeth made you feel healthier.\n+ 1 resilience to infection\nDrinking your pills made it easier to think.\n+ 1 sanity");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        // Create and configure the "Next" button
        JButton btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (panelContainer.getLayout());
                cl.show(panelContainer, "2");
            }
        });

        // Add components to panel1
        panel1.add(textArea, BorderLayout.CENTER);
        panel1.add(btnNext, BorderLayout.SOUTH);

        // Initialize panel2 with BorderLayout
        panel2 = new JPanel(new BorderLayout());

        // Create and configure the decision label
        JLabel decisionLabel = new JLabel("Where will you go now?", SwingConstants.CENTER);
        decisionLabel.setFont(new Font("Serif", Font.PLAIN, 20));

        // Create buttons for choices
        JButton btnOutside = new JButton("Outside");
        JButton btnBackToBed = new JButton("Back to bed, you want to snooze for a while longer");

        // Add action listeners to the buttons
        btnOutside.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outside outside = new outside();
                outside.main(new String[0]);
                frame.dispose();
            }
        });

        btnBackToBed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panel2, "You died in sleep GG");
                System.exit(0);
            }
        });

        // Create a panel for buttons and add buttons to it
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnOutside);
        buttonPanel.add(btnBackToBed);

        // Add components to panel2
        panel2.add(decisionLabel, BorderLayout.CENTER);
        panel2.add(buttonPanel, BorderLayout.SOUTH);

        // Add both panels to the panel container
        panelContainer.add(panel1, "1");
        panelContainer.add(panel2, "2");

        // Add the panel container to the frame
        frame.getContentPane().add(panelContainer);
    }
}
