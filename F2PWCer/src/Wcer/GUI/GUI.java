package Wcer.GUI;

import Wcer.Wcer;
import Wcer.GUI.Panels.WoodcuttingPanel;
import org.osbot.rs07.script.Script;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;

@SuppressWarnings("serial")
public class GUI extends JFrame {
    public static JPanel mainPanel;
    private JLabel curSkill;

    private WoodcuttingPanel woodcuttingPanel;

    public static JTable table;
    public static DefaultTableModel model;

    /* ---------------------------------------------------------------------------------------- */

    public GUI(Script script) throws IOException{
        setResizable(false);
        setTitle("Bears Woodcutter!");
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 800);

        mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(mainPanel);
        mainPanel.setLayout(null);

        /* Buttons and Wcer.GUI.Panels */
        woodcuttingPanel = new WoodcuttingPanel(script);
        //curSkill.setText("Bears Woodcutter");
        WoodcuttingPanel.panel.setVisible(true);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(435, 72, 250, 358);
        mainPanel.add(scrollPane);

        model = new DefaultTableModel();
        table = new JTable(model){
            public boolean isEditable(int row, int columnn){
                return false;
            }
        };

        ((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        scrollPane.setViewportView(table);

        DefaultTableCellRenderer renderer_c = new DefaultTableCellRenderer();
        renderer_c.setHorizontalAlignment(JLabel.CENTER);

        for(int i = 0; i < table.getColumnCount(); i++){
            table.getColumnModel().getColumn(i).setCellRenderer(renderer_c);
        }

        JButton startScriptButton = new JButton("Start Script");
        startScriptButton.addActionListener(arg0 -> {
            Wcer.guiOpen = false;
            dispose();
        });

        startScriptButton.setBounds(0,480,500,25);
        startScriptButton.setVisible(true);
        mainPanel.add(startScriptButton);


        model.addColumn("Queue Place");
        model.addColumn("Task Type");
        model.addColumn("Task Goal");

        table.setRowSelectionAllowed(true);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);



        /*curSkill = new JLabel("");
        curSkill.setBounds(185, 15, 550, 25);
        mainPanel.add(curSkill);
        curSkill.setFont(new Font("Tahoma", Font.BOLD, 25));
        */
    }
}
