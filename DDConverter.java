package dispatching.converter.grabarczyk.tomasz;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Main {

    public static void main(String[] args) {
        DrawGUI drawGUI = new DrawGUI();
        drawGUI.drawGUI();
    }
}

class NameConverter {
    JFrame drawFrame = new JFrame("Dispatching Desk Converter - ver 0.0.3");
    JTextField dateField, customerField, eMailField, inProgressField;
    JButton convertButton, resetButton, copyDateField, copyCustomerField, copyEMailField, copyInProgressField;
    JLabel dateLabel, customerLabel, eMailLabel, inProgressLabel;
    JRadioButton newRadioButton, fullRadioButton, inProgressRadioButton;

    private List<String> listName = new ArrayList<>();
    private List<String> swap = new ArrayList<>();

    void nameConverter() {
        String changeDate = customerField.getText();
        String[] splitString = changeDate.trim().split("\\s+");

        listName.add(splitString[0]);
        listName.add(splitString[1]);

        swap.add(listName.get(0));
        listName.set(0, listName.get(1));
        listName.set(1, swap.get(0));

        customerField.setText(String.format("%s %s", listName.get(0), listName.get(1)));
        eMailField.setText(String.format("%s.%s@ardaghgroup.com", listName.get(0), listName.get(1)));
    }
}

class InProgressConverter extends NameConverter {
    void inProgressConverter() {
        String changeInProgress = inProgressField.getText();
        String[] splitInProgress = changeInProgress.trim().split("\\s+");
        String[] a = splitInProgress[0].split("/");
        String[] b = splitInProgress[1].trim().split(":");

        inProgressField.setText(String.format("%s.%s.%s %s:%s", a[2], a[1], a[0], b[0], b[1]));
    }
}

class CopyToClipboard extends InProgressConverter{
    void copyToClipboard(JTextField copyField) {
        StringSelection stringSelection = new StringSelection(copyField.getText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}

class DrawGUI extends CopyToClipboard implements ActionListener {
    void drawGUI() {
        convertButton = new JButton("Convert");
        convertButton.setBounds(150, 240, 140, 50);
        convertButton.setFocusPainted(false);
        convertButton.addActionListener(this);
        drawFrame.add(convertButton);

        resetButton = new JButton("Reset");
        resetButton.setBounds(310, 240, 140, 50);
        resetButton.setFocusPainted(false);
        resetButton.addActionListener(this);
        drawFrame.add(resetButton);

        dateField = new JTextField();
        dateField.setBounds(150,40,300,40);
        dateField.addActionListener(this);
        drawFrame.add(dateField);

        customerField = new JTextField();
        customerField.setBounds(150,90,300,40);
        customerField.addActionListener(this);
        drawFrame.add(customerField);

        eMailField = new JTextField();
        eMailField.setBounds(150,140,300,40);
        eMailField.addActionListener(this);
        drawFrame.add(eMailField);

        inProgressField = new JTextField();
        inProgressField.setBounds(150,190,300,40);
        inProgressField.addActionListener(this);
        drawFrame.add(inProgressField);

        copyDateField = new JButton("Copy");
        copyDateField.setBounds(460,40,70,40);
        copyDateField.setFocusPainted(false);
        copyDateField.addActionListener(this);
        drawFrame.add(copyDateField);

        copyCustomerField = new JButton("Copy");
        copyCustomerField.setBounds(460,90,70,40);
        copyCustomerField.setFocusPainted(false);
        copyCustomerField.addActionListener(this);
        drawFrame.add(copyCustomerField);

        copyEMailField = new JButton("Copy");
        copyEMailField.setBounds(460,140,70,40);
        copyEMailField.setFocusPainted(false);
        copyEMailField.addActionListener(this);
        drawFrame.add(copyEMailField);

        copyInProgressField = new JButton("Copy");
        copyInProgressField.setBounds(460,190,70,40);
        copyInProgressField.setFocusPainted(false);
        copyInProgressField.addActionListener(this);
        drawFrame.add(copyInProgressField);

        newRadioButton = new JRadioButton("New");
        newRadioButton.setBounds(200, 15, 50, 15);
        newRadioButton.setFocusPainted(false);
        drawFrame.add(newRadioButton);

        fullRadioButton = new JRadioButton("Full");
        fullRadioButton.setBounds(260, 15, 50, 15);
        fullRadioButton.setFocusPainted(false);
        drawFrame.add(fullRadioButton);

        inProgressRadioButton = new JRadioButton("In Progress");
        inProgressRadioButton.setBounds(310, 15, 100, 15);
        inProgressRadioButton.setFocusPainted(false);
        drawFrame.add(inProgressRadioButton);

        dateLabel = new JLabel("Date from e-mail: ");
        dateLabel.setBounds(30,40,120,40);
        drawFrame.add(dateLabel);

        customerLabel = new JLabel("Customer name: ");
        customerLabel.setBounds(30,90,120,40);
        drawFrame.add(customerLabel);

        eMailLabel = new JLabel("Customer e-mail: ");
        eMailLabel.setBounds(30,140,120,40);
        drawFrame.add(eMailLabel);

        inProgressLabel = new JLabel("In Progress date: ");
        inProgressLabel.setBounds(30,190,120,40);
        drawFrame.add(inProgressLabel);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(newRadioButton);
        buttonGroup.add(fullRadioButton);
        buttonGroup.add(inProgressRadioButton);

        drawFrame.setLayout(null);
        drawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawFrame.setSize(570, 360);
        drawFrame.setLocation(460, 40);
        drawFrame.setVisible(true);
    }

    private void convertName() {
        dateField.setText(dateField.getText().replace("-", "."));
        nameConverter();
        copyToClipboard(dateField);
    }

    @Override
    public void actionPerformed(ActionEvent eventActionListener) {
        if (eventActionListener.getSource() == copyDateField) {
            copyToClipboard(dateField);
        } else if (eventActionListener.getSource() == copyCustomerField) {
            copyToClipboard(customerField);
        } else if (eventActionListener.getSource() == copyEMailField) {
            copyToClipboard(eMailField);
        } else if (eventActionListener.getSource() == copyInProgressField) {
            copyToClipboard(inProgressField);
        }

        if (newRadioButton.isSelected()) {
            if (eventActionListener.getSource() == convertButton) {
                convertName();
            } else if (eventActionListener.getSource() == resetButton) {
                drawFrame.dispose();DrawGUI drawGUI = new DrawGUI();drawGUI.drawGUI();
            }
        } else if (fullRadioButton.isSelected()) {
            if (eventActionListener.getSource() == convertButton) {
                convertName();
                inProgressConverter();
            } else if (eventActionListener.getSource() == resetButton) {
                drawFrame.dispose();DrawGUI drawGUI = new DrawGUI();drawGUI.drawGUI();
            }
        } else if (inProgressRadioButton.isSelected()) {
            if (eventActionListener.getSource() == convertButton) {
                inProgressConverter();
                copyToClipboard(inProgressField);
            } else if (eventActionListener.getSource() == resetButton) {
                drawFrame.dispose();DrawGUI drawGUI = new DrawGUI();drawGUI.drawGUI();
            }
        }
    }
}
