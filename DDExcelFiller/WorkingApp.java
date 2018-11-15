package dispaching.excel.writer.grabarczyk.tomasz;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WorkingApp implements ActionListener {
    private String[]
            bottomButtonsValues = {"Push to Excel", "RESTART"},
            textFieldValues = {""},
            labelValues = {""};

    private String[]
            initialVersionValues = {"OUT OF SCOPE"},
            versionValues = {""},
            initialStatusValues = {"New", "In Progress", "Pending", "Resolved", "Closed"},
            initialTicketTypeValues = {"User Service Restoration", "User Service Request"},
            initialSapAreaValues = {""},
            initialSalesConsultantValues = {""},
            initialLogisticsConsultantValues = {""},
            initialFicoConsultantValues = {""},
            initialDevelopmentConsultantValues = {""},
            initialHrConsultantValues = {""},
            initialStatusReasonValues = {"Client Action Required", "Third Party Action Required", "Automated Resolution Reported", "Client Hold", "Future Enhancement", "Infrastructure Change", "Local Site Action Required", "Monitoring Incident", "Purchase Order Approval", "Request", "Supplier Delivery", "Support Contact Hold"},
            impactChangeValues = {"1-Extensive/Widespread", "2-Significant/Large", "3-Moderate/Limited", "4-Minor/Localized"},
            urgencyChangeValues = {"1-Critical", "2-High", "3-Medium", "4-Low"},
            priorityChangeValues = {"Critical", "High", "Medium", "Low"},
            priorityIncOrDecValues = {"Increase", "Decrease"},
            assignedGroupChangeValues = {""},
            caseHandlingValues = {"---", "XX", "IC", "BH", "IR", "IW", "OQ"},

            somethingWasChangedValues = {"Nothing was changed", "Impact / Urgency / Priority was changed", "Priority was increased / decreased", "Both were changed"};

    private JFrame
            initialVersion_FR = new JFrame("Enter Initial Version"),
            initialStatus_FR = new JFrame("Enter Initial Status"),
            initialTicketType_FR = new JFrame("Enter Initial Ticket Type"),
            initialSapArea_FR = new JFrame("Enter Initial SAP Area"),
            initialSalesConsultant_FR = new JFrame("Enter Initial Sales Consultant"),
            initialLogisticsConsultant_FR = new JFrame("Enter Initial Logistics Consultant"),
            initialFicoConsultant_FR = new JFrame("Enter Initial Fico Consultant"),
            initialDevelopmentConsultant_FR = new JFrame("Enter Initial Development Consultant"),
            initialHrConsultant_FR = new JFrame("Enter Initial HR Consultant"),
            initialStatusReason_FR = new JFrame("Enter Initial Status Reason"),
            impactChange_FR = new JFrame("Change Impact"),
            urgencyChange_FR = new JFrame("Change Urgency"),
            priorityChange_FR = new JFrame("Change Priority"),
            priorityIncOrDec_FR = new JFrame("Enter Priority Change"),
            initialPriority_FR = new JFrame("Enter Initial Priority"),
            assignedGroupChange_FR = new JFrame("Change Assigned Group"),
            caseHandling_FR = new JFrame("Change Case Handling"),
            somethingWasChanged_FR = new JFrame("Something Was Changed"),

            drawFrame = new JFrame("Dispatching Desk Excel Report Filler - ver 0.0.1");


    private JRadioButton[]
            initialVersion_RB = new JRadioButton[initialVersionValues.length],
            initialStatus_RB = new JRadioButton[initialStatusValues.length],
            initialTicketType_RB = new JRadioButton[initialTicketTypeValues.length],
            initialSapArea_RB = new JRadioButton[initialSapAreaValues.length],
            initialSalesConsultant_RB = new JRadioButton[initialSalesConsultantValues.length],
            initialLogisticsConsultant_RB = new JRadioButton[initialLogisticsConsultantValues.length],
            initialFicoConsultant_RB = new JRadioButton[initialFicoConsultantValues.length],
            initialDevelopmentConsultant_RB = new JRadioButton[initialDevelopmentConsultantValues.length],
            initialHrConsultant_RB = new JRadioButton[initialHrConsultantValues.length],
            initialStatusReason_RB = new JRadioButton[initialStatusReasonValues.length],
            impactChange_RB = new JRadioButton[impactChangeValues.length],
            urgencyChange_RB = new JRadioButton[urgencyChangeValues.length],
            priorityChange_RB = new JRadioButton[priorityChangeValues.length],
            assignedGroupChange_RB = new JRadioButton[assignedGroupChangeValues.length],
            priorityIncOrDec_RB = new JRadioButton[priorityIncOrDecValues.length],
            initialPriority_RB = new JRadioButton[priorityChangeValues.length],
            caseHandling_RB = new JRadioButton[caseHandlingValues.length],
            somethingWasChanged_RB = new JRadioButton[somethingWasChangedValues.length];


    private JTextField[] textFields = new JTextField[textFieldValues.length];
    private JLabel[] labels = new JLabel[labelValues.length];
    private JButton[] bottomButton = new JButton[bottomButtonsValues.length];

    private ButtonGroup
            version_BG = new ButtonGroup(),
            status_BG = new ButtonGroup(),
            ticketType_BG = new ButtonGroup(),
            sapArea_BG = new ButtonGroup(),
            consultant_BG = new ButtonGroup(),
            statusReason_BG = new ButtonGroup(),
            impactChange_BG = new ButtonGroup(),
            urgencyChange_BG = new ButtonGroup(),
            priorityChange_BG = new ButtonGroup(),
            assignedGroupChange_BG = new ButtonGroup(),
            priorityIncOrDec_BG = new ButtonGroup(),
            initialPriority_BG = new ButtonGroup(),
            caseHandling_BG = new ButtonGroup(),
            somethingWasChanged_BG = new ButtonGroup();

    private void addNewValueToField(String[] value, JRadioButton[] button, JFrame frame, ButtonGroup group) {
        for (int i = 0; i < value.length; i++) {
            button[i] = new JRadioButton(value[i]);
            button[i].addActionListener(this);
            group.add(button[i]);
            frame.add(button[i]);
        }
    }

    private void addValuesToFields() {
        // Pop-up frames
        addNewValueToField(initialVersionValues, initialVersion_RB, initialVersion_FR, version_BG);
        addNewValueToField(initialStatusValues, initialStatus_RB, initialStatus_FR, status_BG);
        addNewValueToField(initialTicketTypeValues, initialTicketType_RB, initialTicketType_FR, ticketType_BG);
        addNewValueToField(initialSapAreaValues, initialSapArea_RB, initialSapArea_FR, sapArea_BG);
        addNewValueToField(initialSalesConsultantValues, initialSalesConsultant_RB, initialSalesConsultant_FR, consultant_BG);
        addNewValueToField(initialLogisticsConsultantValues, initialLogisticsConsultant_RB, initialLogisticsConsultant_FR, consultant_BG);
        addNewValueToField(initialFicoConsultantValues, initialFicoConsultant_RB, initialFicoConsultant_FR, consultant_BG);
        addNewValueToField(initialDevelopmentConsultantValues, initialDevelopmentConsultant_RB, initialDevelopmentConsultant_FR, consultant_BG);
        addNewValueToField(initialHrConsultantValues, initialHrConsultant_RB, initialHrConsultant_FR, consultant_BG);
        addNewValueToField(initialStatusReasonValues, initialStatusReason_RB, initialStatusReason_FR, statusReason_BG);


        addNewValueToField(impactChangeValues, impactChange_RB, impactChange_FR, impactChange_BG);
        addNewValueToField(urgencyChangeValues, urgencyChange_RB, urgencyChange_FR, urgencyChange_BG);
        addNewValueToField(priorityChangeValues, priorityChange_RB, priorityChange_FR, priorityChange_BG);
        addNewValueToField(priorityIncOrDecValues, priorityIncOrDec_RB, priorityIncOrDec_FR, priorityIncOrDec_BG);
        addNewValueToField(priorityChangeValues, initialPriority_RB, initialPriority_FR, initialPriority_BG);
        addNewValueToField(assignedGroupChangeValues, assignedGroupChange_RB, assignedGroupChange_FR, assignedGroupChange_BG);
        addNewValueToField(caseHandlingValues, caseHandling_RB, caseHandling_FR, caseHandling_BG);


        addNewValueToField(somethingWasChangedValues, somethingWasChanged_RB, somethingWasChanged_FR, somethingWasChanged_BG);
    }

    private void drawPopUpFrame(JFrame nameOfFrame, String[] value) {
        nameOfFrame.setLayout(new GridLayout(value.length, 1));
        nameOfFrame.setSize(400, value.length * 50);
        nameOfFrame.setLocationRelativeTo(null);
        nameOfFrame.setAlwaysOnTop(true);
        nameOfFrame.setResizable(false);
        nameOfFrame.setVisible(true);
    }
    private void drawAllFields(int firstX, int y, int i) {
        textFields[i].setHorizontalAlignment(SwingConstants.CENTER);
        textFields[i].setBounds(firstX, y, 170, 35);
        drawFrame.add(textFields[i]);
    }
    private void drawAllLabels(int labelX, int y, int i) {
        labels[i].setHorizontalAlignment(SwingConstants.CENTER);
        labels[i].setBounds(labelX, y, 170, 35);
        drawFrame.add(labels[i]);
    }

    private void drawFields() {
        addValuesToFields();

        // Draw buttons on bottom
        int x = 100, fieldX = 18, labelFirstX = 18;
        for (int i = 0; i < bottomButton.length; i++) {
            bottomButton[i] = new JButton(bottomButtonsValues[i]);
            bottomButton[i].addActionListener(this);
            bottomButton[i].setFocusPainted(false);
            bottomButton[i].setBounds(x, 430, 200, 40);
            x += 300;
            drawFrame.add(bottomButton[i]);
        }

        // Draw all fields in frame
        int incrementByValue = 190;
        for (int i = 0; i < textFieldValues.length; i++) {
            textFields[i] = new JTextField();
            textFields[i].addActionListener(this);
            if (i < 7) {
                drawAllFields(fieldX, 50, i);
                fieldX += incrementByValue;
            } else if (i < 14) {
                if (fieldX == 1348) fieldX = 18;
                drawAllFields(fieldX, 130, i);
                fieldX += incrementByValue;
            } else if (i < 21) {
                if (fieldX == 1348) fieldX = 18;
                drawAllFields(fieldX, 210, i);
                fieldX += incrementByValue;
            } else if (i < 28) {
                if (fieldX == 1348) fieldX = 18;
                drawAllFields(fieldX, 290, i);
                fieldX += incrementByValue;
            } else {
                if (fieldX == 1348) fieldX = 18;
                drawAllFields(fieldX, 370, i);
                fieldX += incrementByValue;
            }
        }

        // Draw all labels in frame
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel(labelValues[i]);
            if (i < 7) {
                drawAllLabels(labelFirstX, 20, i);
                labelFirstX += incrementByValue;
            } else if (i < 14) {
                if (labelFirstX == 1348) labelFirstX = 18;
                drawAllLabels(labelFirstX, 100, i);
                labelFirstX += incrementByValue;
            } else if (i < 21) {
                if (labelFirstX == 1348) labelFirstX = 18;
                drawAllLabels(labelFirstX, 180, i);
                labelFirstX += incrementByValue;
            } else if (i < 28){
                if (labelFirstX == 1348) labelFirstX = 18;
                drawAllLabels(labelFirstX, 260, i);
                labelFirstX += incrementByValue;
            } else {
                if (labelFirstX == 1348) labelFirstX = 18;
                drawAllLabels(labelFirstX, 340, i);
                labelFirstX += incrementByValue;
            }
        }

        for (int i = 0; i < textFieldValues.length; i++) {
            textFields[i].setEditable(false); // Set all fields uneditable
        }

        drawPopUpFrame(initialVersion_FR, initialVersionValues); // Launch first selection frame

        //Launch main frame
        drawFrame.setLayout(null);
        drawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawFrame.setSize(1366, 528);
        drawFrame.setLocationRelativeTo(null);
        drawFrame.setResizable(false);
        drawFrame.setVisible(true);

        bottomButton[0].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pushToExcel();
            }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        }); // Restart main frame
        bottomButton[1].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drawFrame.dispose();
                WorkingApp workingApp = new WorkingApp();
                workingApp.fieldListeners();
            }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        }); // Restart main frame
    } // Bottom buttons are here


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
    private void impactUrgencyPriorityWasChanged() {
        textFields[7].setText("");
        textFields[8].setText("");
        textFields[9].setText("");

        somethingWasChanged_FR.dispose(); // Close Something Was Changed Frame
        drawPopUpFrame(impactChange_FR, impactChangeValues); // Draw Impact Change Frame and fill it with proper values
        for (JRadioButton impactChangeValue : impactChange_RB)
            if (impactChangeValue.isSelected()) { // Check which Impact Change was selected
                textFields[7].setText(impactChangeValue.getText());  // Fill Impact Field with selected value
                impactChange_FR.dispose(); // Close Impact Change Frame

                drawPopUpFrame(urgencyChange_FR, urgencyChangeValues); // Draw Urgency Change Frame and fill it with proper values
                for (JRadioButton urgencyChangeValue : urgencyChange_RB)
                    if (urgencyChangeValue.isSelected()) { // Check which Urgency Change was selected
                        textFields[8].setText(urgencyChangeValue.getText());  // Fill Urgency Field with selected value
                        urgencyChange_FR.dispose(); // Close Urgency Change Frame

                        drawPopUpFrame(priorityChange_FR, priorityChangeValues); // Draw Priority Change Frame and fill it with proper values
                        for (JRadioButton priorityChangeValue : priorityChange_RB)
                            if (priorityChangeValue.isSelected()) { // Check which Priority Change was selected
                                textFields[9].setText(priorityChangeValue.getText());  // Fill Priority Field with selected value
                                priorityChange_FR.dispose(); // Close Priority Change Frame

                                if (somethingWasChanged_RB[3].isSelected()) priorityWasIncreasedOrDecreased();
                            }
                    }
            }
    }
    private void priorityWasIncreasedOrDecreased() {
        textFields[21].setText("Yes");
        textFields[22].setText("");
        textFields[23].setText("");

        somethingWasChanged_FR.dispose(); // Close Something Was Changed Frame
        drawPopUpFrame(priorityIncOrDec_FR, priorityIncOrDecValues); // Draw Priority Change Frame and fill it with proper values
        for (JRadioButton priorityIncOrDecValue : priorityIncOrDec_RB)
            if (priorityIncOrDecValue.isSelected()) { // Check which Priority Change was selected
                textFields[22].setText(priorityIncOrDecValue.getText());  // Fill Priority Change with selected value
                priorityIncOrDec_FR.dispose(); // Close Priority Change Frame

                drawPopUpFrame(initialPriority_FR, priorityChangeValues); // Draw Initial Priority Frame and fill it with proper values
                for (JRadioButton initialPriorityValue :initialPriority_RB)
                    if (initialPriorityValue.isSelected()) { // Check which Initial Priority was selected
                        textFields[23].setText(initialPriorityValue.getText());  // Fill Initial Priority with selected value
                        initialPriority_FR.dispose(); // Close Initial Priority Frame
                    }
            }
    }
    private void somethingWasChanged() {
        drawPopUpFrame(somethingWasChanged_FR, somethingWasChangedValues); // Draw Something Was Changed Frame and fill it with proper values
        if (somethingWasChanged_RB[0].isSelected()) {
            somethingWasChanged_FR.dispose(); // Close Something Was Changed Frame
        } else if (somethingWasChanged_RB[1].isSelected()) { // If "Impact / Urgency / Priority was changed" value is selected
            impactUrgencyPriorityWasChanged();
        } else if (somethingWasChanged_RB[2].isSelected()) {
            priorityWasIncreasedOrDecreased();
        } else if (somethingWasChanged_RB[3].isSelected()) {
            impactUrgencyPriorityWasChanged();
        }
    }

    private void pendingStatus() {
        if (textFields[5].getText().equals("Pending")) { // If Status Field is Pending
            drawPopUpFrame(initialStatusReason_FR, initialStatusReasonValues); // Draw Status Reason Frame and fill it with proper values
            for (JRadioButton initialStatusReasonValue : initialStatusReason_RB)
                if (initialStatusReasonValue.isSelected()) // If Status Reason value is selected
                    textFields[6].setText(initialStatusReasonValue.getText()); // Fill Status Reason Field with selected value
            if (!textFields[6].getText().isEmpty()) { // If Status Reason Value is filled
                initialStatusReason_FR.dispose(); // Close Status Reason Frame
                somethingWasChanged();
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
                if (!textFields[5].getText().equals("Pending")) somethingWasChanged(); // If Status is not Pending then launch somethingWasChanged()
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

                    drawPopUpFrame(caseHandling_FR, caseHandlingValues); // Draw Ticket Type Frame and fill it with proper values
                    for (int caseHandlingNumber = 0; caseHandlingNumber < caseHandlingValues.length; caseHandlingNumber++) {
                        if (caseHandling_RB[caseHandlingNumber].isSelected()) { // If SAP Area value is selected
                            for (JRadioButton caseHandlingValue : caseHandling_RB)
                                if (caseHandlingValue.isSelected()) // Check which Ticket Type was selected
                                    textFields[31].setText(caseHandlingValue.getText());  // Fill Ticket Type Field with selected value
                            caseHandling_FR.dispose(); // Close Ticket Type Frame

                            if (!initialStatus_RB[0].isSelected()) { // If New wasn't selected
                                for (JRadioButton initialStatusValue : initialStatus_RB) // Check which Status was selected
                                    if (initialStatusValue.isSelected())
                                        textFields[5].setText(initialStatusValue.getText()); // Fill Status Field with selected value

                                if (initialStatus_RB[2].isSelected())
                                    textFields[12].setEditable(true); // If Status is Pending then set Pending Start Date field editable
                                if (initialStatus_RB[3].isSelected()) {
                                    textFields[11].setEditable(true); // If Status is Resolved then set In Progress Start Date field editable
                                    textFields[13].setEditable(true); // If Status is Resolved then set Resolved Date field editable
                                }

                                if (initialVersion_RB[0].isSelected()) { // If version is BP2
                                    version_BP2();
                                } else if (initialVersion_RB[1].isSelected()) {  // If version is BP5
                                    version_BP5();
                                }
                            } else {
                                somethingWasChanged();
                            }
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
            if (!textFields[5].getText().equals("Pending")) somethingWasChanged(); // If Status is not Pending then launch somethingWasChanged()
        }
    }
    private void version_ACE() {
        // Waiting for ACE to be on us
    }
    private void version_OutOfScope() {
        textFields[0].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textFields[0].setEditable(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
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

            drawPopUpFrame(assignedGroupChange_FR, assignedGroupChangeValues); // Draw Assigned Group Frame and fill it with proper values
            for (int groupNumber = 0; groupNumber < assignedGroupChangeValues.length; groupNumber++) {
                if (assignedGroupChange_RB[groupNumber].isSelected()) { // If Assigned Group value is selected
                    for (JRadioButton assignedGroupChangeValue : assignedGroupChange_RB)
                        if (assignedGroupChangeValue.isSelected()) // Check which Assigned Group was selected
                            textFields[0].setText(assignedGroupChangeValue.getText());  // Fill Assigned Group Field with selected value
                    assignedGroupChange_FR.dispose(); // Close Assigned Group Frame
                }
            }
        }
    }

    private void checkSLAContractTime() {
        switch (textFields[9].getText()) {
            case "Low":
                textFields[29].setText("20");break;
            case "Medium":
                textFields[29].setText("4");break;
            case "High":
                textFields[29].setText("0,8");break;
            case "Critical":
                textFields[29].setText("0,4");break;
        }
    }

    void fieldListeners() {
        drawFields();
    }

    @Override
    public void actionPerformed(ActionEvent eventActionListener) {
        if (initialVersion_RB[0].isSelected()) {
            textFields[0].setText(versionValues[0]);
            commonInBP2AndBP5();
            checkSLAContractTime();
        } else if (initialVersion_RB[1].isSelected()) {
            textFields[0].setText(versionValues[1]);
            commonInBP2AndBP5();
            checkSLAContractTime();
        } else if (initialVersion_RB[2].isSelected()) {
            textFields[0].setText(versionValues[2]);
            version_ACE();
        } else if (initialVersion_RB[3].isSelected()) {
            version_OutOfScope();
        }
    }

    private void pushToExcel() {
        System.out.println("Pushing to Excel...");

        final String FILE_NAME = "";

        try {
            FileInputStream inputStream = new FileInputStream(new File(FILE_NAME));
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            Object[][] bookData = {
                    {
                        textFields[0].getText(),
                            textFields[1].getText(),
                            textFields[2].getText(),
                            textFields[3].getText(),
                            textFields[4].getText(),
                            textFields[5].getText(),
                            textFields[6].getText(),
                            textFields[7].getText(),
                            textFields[8].getText(),
                            textFields[9].getText(),
                            textFields[10].getText(),
                            textFields[11].getText(),
                            textFields[12].getText(),
                            textFields[13].getText(),
                            textFields[14].getText(),
                            textFields[15].getText(),
                            textFields[16].getText(),
                            textFields[17].getText(),
                            textFields[18].getText(),
                            textFields[19].getText(),
                            textFields[20].getText(),
                            textFields[21].getText(),
                            textFields[22].getText(),
                            textFields[23].getText(),
                            textFields[24].getText(),
                            textFields[25].getText(),
                            textFields[26].getText(),
                            textFields[27].getText(),
                            textFields[28].getText(),
                            textFields[29].getText(),
                            textFields[30].getText(),
                            textFields[31].getText(),
                            textFields[32].getText(),
                            textFields[33].getText(),
                            textFields[34].getText()

                    },
            };

            int rowCount = sheet.getLastRowNum();

            for (Object[] aBook : bookData) {
                Row row = sheet.createRow(++rowCount);

                int columnCount = -1;

                Cell cell;

                for (Object field : aBook) {
                    cell = row.createCell(++columnCount);
                    cell.setCellValue((String) field);
                    cell.getCellStyle().setAlignment(HorizontalAlignment.CENTER);
                }
            }

            inputStream.close();

            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

            System.out.println("Excel completed");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
