package dispaching.excel.writer.grabarczyk.tomasz;

import javax.swing.*;
import java.awt.event.*;

class FieldListeners extends DrawFields implements ActionListener {
    void fieldListeners() {
        drawFields();
    }

    private void setFieldDefaultValues() {
        textFields[2].setEditable(true);              // Incident Number Field
        textFields[7].setText("3-Moderate/Limited");  // Impact Field
        textFields[8].setText("4-Low");               // Urgency Field
        textFields[9].setText("Low");                 // Priority Field
        textFields[10].setEditable(true);             // Reported Date Field
        textFields[17].setText("IN");                 // SLA First Reaction Field
        textFields[18].setText("IN");                 // SLA Solution Field
        textFields[24].setEditable(true);             // Customer Field
    }

    private void pendingStatus() {
        if (textFields[5].getText().equals("Pending")) { // If Status Field is Pending
            drawPopUpFrame(initialStatusReason_FR, initialStatusReasonValues); // Draw Status Reason Frame and fill it with proper values
            for (JRadioButton initialStatusReasonValue : initialStatusReason_RB)
                if (initialStatusReasonValue.isSelected()) // If Status Reason value is selected
                    textFields[6].setText(initialStatusReasonValue.getText()); // Fill Status Reason Field with selected value
            if (!textFields[6].getText().isEmpty()) { // If Status Reason Value is filled
                initialStatusReason_FR.dispose(); // Close Status Reason Frame
            }
        }
    }

    private void checkConsultant(String[] initialValues, JRadioButton[] initialConsultant_RB, JFrame initialConsultant_FR) {
        drawPopUpFrame(initialConsultant_FR, initialValues); // Draw Consultant Frame and fill it with proper values
        for (int consultantNumber = 0; consultantNumber < initialValues.length; consultantNumber++)
            if (initialConsultant_RB[consultantNumber].isSelected()) { // If Consultant value is selected
                textFields[4].setText(initialConsultant_RB[consultantNumber].getText()); // Fill Consultant Field with selected value
                initialConsultant_FR.dispose(); // Close Consultant Frame
                pendingStatus(); // When Status is Pending then launch this
            }
    }

    private void commonInBP2AndBP5() {
        setFieldDefaultValues(); // Set default values

        initialVersion_FR.dispose(); // Close Version (BP2/BP5/ACE/OOS) Frame

        drawPopUpFrame(initialStatus_FR, initialStatusValues); // Draw Status Frame and fill it with proper values
        for (int statusNumber = 0; statusNumber < initialStatusValues.length; statusNumber++) {
            if (initialStatus_RB[statusNumber].isSelected()) { // If Status value is selected
                initialStatus_FR.dispose(); // Close Status Frame

                drawPopUpFrame(initialTicketType_FR, initialTicketTypeValues); // Draw Ticket Type Frame and fill it with proper values
                if (initialTicketType_RB[0].isSelected() || initialTicketType_RB[1].isSelected()) { // If Ticket Type value is selected
                    for (JRadioButton initialTicketTypeValue : initialTicketType_RB)
                        if (initialTicketTypeValue.isSelected()) // Check which Ticket Type was selected
                            textFields[1].setText(initialTicketTypeValue.getText());  // Fill Ticket Type Field with selected value
                    initialTicketType_FR.dispose(); // Close Ticket Type Frame

                    if (!initialStatus_RB[0].isSelected()) { // If New wasn't selected
                        for (JRadioButton initialStatusValue : initialStatus_RB) // Check which Status was selected
                            if (initialStatusValue.isSelected()) textFields[5].setText(initialStatusValue.getText()); // Fill Status Field with selected value

                        if (initialStatus_RB[2].isSelected()) textFields[12].setEditable(true); // If Status is Pending then set Pending Start Date field editable

                        if (initialVersion_RB[0].isSelected()) { // If version is BP2
                            version_BP2();
                        } else if (initialVersion_RB[1].isSelected()) {  // If version is BP5
                            version_BP5();
                        }
                    }
                }
            }
        }
    }

    private void version_BP2() {
        drawPopUpFrame(initialSapArea_FR, initialSapAreaValues); // Draw SAP Area Frame and fill it with proper values
        for (int sapAreaNumber = 0; sapAreaNumber < initialSapAreaValues.length; sapAreaNumber++) {
            if (initialSapArea_RB[sapAreaNumber].isSelected()) { // If SAP Area value is selected
                for (JRadioButton initialSapAreaValue : initialSapArea_RB)
                    if (initialSapAreaValue.isSelected()) // Check which SAP Area was selected
                        textFields[3].setText(initialSapAreaValue.getText()); // Fill SAP Area with selected value
                initialSapArea_FR.dispose(); // Close SAP Area Frame

                if (initialSapArea_RB[0].isSelected()) { // If Sales value was selected
                    checkConsultant(initialSalesConsultantValues, initialSalesConsultant_RB, initialSalesConsultant_FR);
                } else if (initialSapArea_RB[1].isSelected()) { // If Logistics value was selected
                    checkConsultant(initialLogisticsConsultantValues, initialLogisticsConsultant_RB, initialLogisticsConsultant_FR);
                } else if (initialSapArea_RB[2].isSelected()) { // If Fico value was selected
                    checkConsultant(initialFicoConsultantValues, initialFicoConsultant_RB, initialFicoConsultant_FR);
                } else if (initialSapArea_RB[3].isSelected()) { // If Development value was selected
                    checkConsultant(initialDevelopmentConsultantValues, initialDevelopmentConsultant_RB, initialDevelopmentConsultant_FR);
                }
            }
        }
    }
    private void version_BP5() {
        drawPopUpFrame(initialHrConsultant_FR, initialHrConsultantValues);

        if (initialHrConsultant_RB[0].isSelected()) {
            for (JRadioButton initialModuleValue : initialHrConsultant_RB)
                if (initialModuleValue.isSelected())
                    textFields[4].setText(initialModuleValue.getText());
            initialHrConsultant_FR.dispose();
            pendingStatus();
        }
    }
    private void version_ACE() {
        // Waiting for ACE to be on us
    }
    private void version_OutOfScope() {
        textFields[0].setText("ARD BEV AMS SAP");     // Assigned Group Field
        textFields[2].setEditable(true);              // Incident Number Field
        textFields[7].setText("3-Moderate/Limited");  // Impact Field
        textFields[8].setText("4-Low");               // Urgency Field
        textFields[9].setText("Low");                 // Priority Field
        textFields[10].setEditable(true);             // Reported Date Field
        textFields[19].setText("1");                  // Wrongly Assigned
        textFields[20].setText("HELPDESK");           // Destination Group
        textFields[24].setEditable(true);             // Customer Field

        initialVersion_FR.dispose(); // Close Version (BP2/BP5/ACE/OOS) Frame

        drawPopUpFrame(initialTicketType_FR, initialTicketTypeValues); // Draw Ticket Type Frame and fill it with proper values
        if (initialTicketType_RB[0].isSelected() || initialTicketType_RB[1].isSelected()) { // If Ticket Type value is selected
            for (JRadioButton initialTicketTypeValue : initialTicketType_RB)
                if (initialTicketTypeValue.isSelected()) // Check which Ticket Type was selected
                    textFields[1].setText(initialTicketTypeValue.getText());  // Fill Ticket Type Field with selected value
            initialTicketType_FR.dispose(); // Close Ticket Type Frame
        }
    }

    @Override
    public void actionPerformed(ActionEvent eventActionListener) {
        bottomButton[0].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changeImpactFields();
            }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        });

        bottomButton[1].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                changePriorityFields();
            }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        });

        for (int versionNumber = 0; versionNumber < initialVersionValues.length; versionNumber++) {
            if (initialVersion_RB[versionNumber].isSelected()) {
                if (initialVersion_RB[0].isSelected()) {
                    textFields[0].setText(versionValues[0]);
                    commonInBP2AndBP5();
                } else if (initialVersion_RB[1].isSelected()) {
                    textFields[0].setText(versionValues[1]);
                    commonInBP2AndBP5();
                }
            /*
            else if (initialVersion_RB[2].isSelected()) {
                textFields[0].setText(versionValues[2]);
                version_ACE();
            }
            */
                else if (initialVersion_RB[3].isSelected()) {
                    textFields[0].setText(versionValues[3]);
                    version_OutOfScope();
                }
            }
        }
    }
}
