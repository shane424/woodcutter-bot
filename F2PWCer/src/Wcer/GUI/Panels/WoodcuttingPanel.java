package Wcer.GUI.Panels;

import Wcer.Wcer;
import Wcer.Locations.WCLocs;
import Wcer.Skills.WCJob;
import org.osbot.rs07.script.Script;

import Wcer.GUI.GUI;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WoodcuttingPanel extends JPanel{
    public String[] contains(String test) {
        java.util.List<String> s = new ArrayList<String>();
        s.add("-- Select Location --");
        for (int i = 0; i < WCLocs.values().length; i++) {
            for(int j = 0; j < WCLocs.values()[i].getTreeNames().length; j++) {
                if (WCLocs.values()[i].getTreeNames()[j].equals(test)) {
                    s.add(WCLocs.values()[i].name());
                }
            }
        }
        String[] res = s.toArray(new String[0]);
        return res;
    }

    public static JPanel panel;
    private JButton addQueueButton;
    private boolean isBanking;
    private String selectedTree;
    private String selectedLocation;

    /* Options */
    private JComboBox<String> queueTypecomboBox;
    private JLabel desiredLevelLabel;
    private JTextField desiredLevelText;
    private JComboBox<String> woodcuttingComboBox;
    private JComboBox<String> woodcuttingLocationComboBox;
    private JComboBox<String> treeSelector;

    private void showAddQueueButton(){
        if(!desiredLevelText.getText().isEmpty() &&
                !woodcuttingComboBox.getSelectedItem().equals("-- Select Type --") &&
                    !woodcuttingLocationComboBox.getSelectedItem().equals("-- Select Location --") &&
                        !treeSelector.getSelectedItem().equals("-- Select Tree --")) {
            addQueueButton.setEnabled(true);
        }
        else{
            addQueueButton.setEnabled(false);
        }
    }

    public WoodcuttingPanel(Script script){
        panel = new JPanel();
        panel.setVisible(false);
        panel.setBounds(80, 50, 350, 380);
        GUI.mainPanel.add(panel);
        panel.setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(0, 0, 350, 380);
        panel.add(tabbedPane);

        JPanel optionsPanel = new JPanel();
        tabbedPane.addTab("Configurations", null, optionsPanel, null);
        optionsPanel.setLayout(null);

        desiredLevelLabel = new JLabel("Desired Level: ");
        desiredLevelLabel.setBounds(10,40,170,15);
        optionsPanel.add(desiredLevelLabel);

        desiredLevelText = new JTextField();
        desiredLevelText.getDocument().addDocumentListener(new DocumentListener() {

            public void changedUpdate(DocumentEvent e) {
                updateButton();
                showAddQueueButton();
            }

            public void removeUpdate(DocumentEvent e) {
                updateButton();
                showAddQueueButton();
            }

            public void insertUpdate(DocumentEvent e) {
                updateButton();
                showAddQueueButton();
            }

            private void checkInput(){
                Runnable assist = () -> {
                    String input = desiredLevelText.getText();

                    if(!input.matches("[0-9]+")){
                        desiredLevelText.setText("");
                    }
                };
                SwingUtilities.invokeLater(assist);
            }

            private void updateButton(){
                if(!desiredLevelText.getText().equals("") && !desiredLevelText.getText().matches("[0-9]+")){ //^[0-9]{1,2}$
                    checkInput();
                }
            }
        });

        desiredLevelText.setHorizontalAlignment(SwingConstants.CENTER);
        desiredLevelText.setBounds(120,40,200,20);
        optionsPanel.add(desiredLevelText);
        desiredLevelText.setColumns(10); // idk what this does

        JLabel methodLabel = new JLabel("Chopping method: ");
        methodLabel.setBounds(10,70,170,16);
        optionsPanel.add(methodLabel);

        String[] methodList = {"-- Select Type --", "BANK", "DROP"};
        DefaultComboBoxModel<String> woodcuttingMethodBox = new DefaultComboBoxModel<>(methodList);

        woodcuttingComboBox = new JComboBox<>(woodcuttingMethodBox);
        woodcuttingComboBox.addActionListener(e -> {
            showAddQueueButton();
            if(woodcuttingComboBox.getSelectedItem().equals("BANK")){
                isBanking = true;
            }
            else if(woodcuttingComboBox.getSelectedItem().equals("DROP")){
                isBanking = false;
            }
        });
        woodcuttingComboBox.setBounds(120, 70, 200, 20);
        optionsPanel.add(woodcuttingComboBox);

        JLabel labelTree = new JLabel("Select a tree type:"); // Create a label
        labelTree.setForeground(Color.white); // Set text colour to white
        optionsPanel.add(labelTree); // Add it to the JPanel
        optionsPanel.setBorder(new EmptyBorder(new Insets(0, 70, 150, 80)));

        // Create a select box for tree options
        treeSelector = new JComboBox<>(new String[]{"-- Select Tree --","Tree", "Oak", "Willow", "Maple", "Yew", "Magic", "Redwood"});

        // Add an action listener, to listen for user's selections, assign to a variable called selectedTree on selection.
        treeSelector.addActionListener(e -> selectedTree = treeSelector.getSelectedItem().toString());
        //log(treeSelector.getSelectedItem().toString());
        // Add the select box to the JPanel
        optionsPanel.add(treeSelector);

        JLabel treeTypeLabel = new JLabel("Tree Type: ");
        treeTypeLabel.setBounds(10,100,170,15);
        optionsPanel.add(treeTypeLabel);
        optionsPanel.add(treeSelector);
        treeSelector.setBounds(120,100,200,20);
        treeSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if(!treeSelector.getSelectedItem().equals("-- Select Tree --")) {

                    JComboBox<String> comboBox = (JComboBox<String>) event.getSource();
                    //JLabel label2 = new JLabel("Select a location:");
                    String[] locations = contains(treeSelector.getSelectedItem().toString());
                    DefaultComboBoxModel<String> wcLocationsModel = new DefaultComboBoxModel<>(locations);
                    woodcuttingLocationComboBox.setModel(wcLocationsModel);
                    woodcuttingLocationComboBox.setEnabled(true);
                }
                else{
                    String[] locations = {"-- Select Tree --"};
                    DefaultComboBoxModel<String> wcLocationsModel = new DefaultComboBoxModel<>(locations);
                    woodcuttingLocationComboBox.setModel(wcLocationsModel);
                    woodcuttingLocationComboBox.setEnabled(false);
                }

            }
        });

        JLabel treeLocationLabel = new JLabel("Select a location:");
        treeLocationLabel.setBounds(10,130,170,15);
        optionsPanel.add(treeLocationLabel);

        String[] treeLocations = {"-- Select Location --"};
        DefaultComboBoxModel<String> treeLocationBox = new DefaultComboBoxModel<>(treeLocations);

        woodcuttingLocationComboBox = new JComboBox<>(treeLocationBox);
        woodcuttingLocationComboBox.addActionListener(e -> showAddQueueButton());
        woodcuttingLocationComboBox.setEnabled(false);
        woodcuttingLocationComboBox.setBounds(120,130,200,20);
        optionsPanel.add(woodcuttingLocationComboBox);

        addQueueButton = new JButton("Add To Queue");
        addQueueButton.addActionListener(e -> {
            script.log("Add Button Pressed");
            int queueRank = GUI.table.getRowCount() + 1; // 0 based
            String goal = desiredLevelText.getText() + " Woodcutting";
            String type = "Level";

            GUI.model.addRow(new Object[]{queueRank, type, goal});
            script.log("Adding WC Job");
            script.log( treeSelector.getSelectedItem().toString() + " " + woodcuttingLocationComboBox.getSelectedItem().toString() + " " + Integer.parseInt(desiredLevelText.getText()) + " " + isBanking);
            Wcer.jobs.add(new WCJob(script, treeSelector.getSelectedItem().toString(), woodcuttingLocationComboBox.getSelectedItem().toString(), Integer.parseInt(desiredLevelText.getText()), isBanking));
        });
        addQueueButton.setBounds(0, 180, 50, 25);
        addQueueButton.setVisible(true);
        addQueueButton.setEnabled(false);
        optionsPanel.add(addQueueButton);
    }
}
