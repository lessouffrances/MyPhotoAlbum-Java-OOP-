package view;

import album.Snapshot;
import controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the GraphicalView class.
 * It extends the JFrame interface.
 * It creates a user interface and allows users to navigate through buttons.
 */
public class GraphicalView extends JFrame {
    private Controller controller;
    private JLabel timestampLabel;
    private JLabel descriptionLabel;
    private DrawingPanel drawingPanel;
    private JButton previousButton;
    private JButton selectButton;
    private JButton nextButton;
    private JButton quitButton;

    /**
     * This is the constructor for the GraphicalView class.
     * @param controller is the controller of the MVC architect.
     */
    public GraphicalView(Controller controller) {
        this.controller = controller;
        initView();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // initialize the view with the first snapshot, if any.
        if (!controller.hasNextSnapshot()) {
            JOptionPane.showMessageDialog(this, "No Snapshots!", "Message"
              , JOptionPane.INFORMATION_MESSAGE);
            previousButton.setEnabled(false);
            selectButton.setEnabled(false);
            nextButton.setEnabled(false);
        } else {
            controller.nextSnapshot();
            Snapshot snapshot = controller.getCurrentSnapshot();
            timestampLabel.setText(snapshot.getTimestampString());
            descriptionLabel.setText(snapshot.getDescription());
            drawingPanel.setCurrentSnapshot(snapshot);
            drawingPanel.repaint();
        }
    }

    /**
     * This is the view setup private method.
     * It helps to arrange the GUI components.
     */
    private void initView() {
        setTitle("cs5004 Shapes Photo Album Viewer");
        JPanel contentPanel = new JPanel();
        contentPanel.setPreferredSize(new Dimension(controller.getWidth() + 200, controller.getHeight() + 100));
        setContentPane(contentPanel);
        pack();
        contentPanel.setLayout(null);

        JPanel topPanel = new JPanel();
        topPanel.setBounds(0, 0, controller.getWidth() + 200, 50);
        topPanel.setBackground(Color.pink);
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        timestampLabel = new JLabel(" ");
        topPanel.add(timestampLabel);

        descriptionLabel = new JLabel(" ");
        topPanel.add(descriptionLabel);
        contentPanel.add(topPanel);

        drawingPanel = new DrawingPanel();
        drawingPanel.setBounds(0, 50, controller.getWidth(), controller.getHeight());
        drawingPanel.setMaximumSize(new Dimension(controller.getWidth(), controller.getHeight()));
        drawingPanel.setMinimumSize(new Dimension(controller.getWidth(), controller.getHeight()));
        drawingPanel.setBackground(Color.WHITE);
        contentPanel.add(drawingPanel);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBounds(0, controller.getHeight() + 50, controller.getWidth() + 200, 50);
        bottomPanel.setBackground(Color.orange);
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // buttons:
        previousButton = new JButton("<< Prev <<");
        previousButton.setEnabled(false);
        bottomPanel.add(previousButton);
        selectButton = new JButton("^^ Select ^^");
        bottomPanel.add(selectButton);
        nextButton = new JButton(">> Next >>");
        bottomPanel.add(nextButton);
        quitButton = new JButton("xx Quit xx");
        bottomPanel.add(quitButton);
        contentPanel.add(bottomPanel);

        // evt listeners for buttons:
        // previous button:
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextButton.setEnabled(true);
                controller.previousSnapshot();
                Snapshot snapshot = controller.getCurrentSnapshot();
                timestampLabel.setText(snapshot.getTimestampString());
                descriptionLabel.setText(snapshot.getDescription());
                drawingPanel.setCurrentSnapshot(snapshot);
                drawingPanel.repaint();
                if (!controller.hasPreviousSnapshot()) {
                    previousButton.setEnabled(false);
                }
            }
        });

        // next button:
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                previousButton.setEnabled(true);
                controller.nextSnapshot();
                Snapshot snapshot = controller.getCurrentSnapshot();
                timestampLabel.setText(snapshot.getTimestampString());
                descriptionLabel.setText(snapshot.getDescription());
                drawingPanel.setCurrentSnapshot(snapshot);
                drawingPanel.repaint();
                if (!controller.hasNextSnapshot()) {
                    nextButton.setEnabled(false);
                }
            }
        });

        // select button:
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] timestamps = controller.getAllSnapshotTimestamps();
                JComboBox<String> comboBox = new JComboBox<>(timestamps);
                int result = JOptionPane.showOptionDialog(GraphicalView.this, comboBox, "Choose"
                  , JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, timestamps[0]);
                if (result == JOptionPane.OK_OPTION) {
                    Snapshot snapshot = controller.getSnapshotByIndex(comboBox.getSelectedIndex());
                    System.out.println(comboBox.getSelectedIndex());

                    timestampLabel.setText(snapshot.getTimestampString());
                    descriptionLabel.setText(snapshot.getDescription());
                    drawingPanel.setCurrentSnapshot(snapshot);
                    drawingPanel.repaint();
                    nextButton.setEnabled(controller.hasNextSnapshot());
                    previousButton.setEnabled(controller.hasPreviousSnapshot());
                }
            }
        });

        // quit button:
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
