package dispaching.excel.writer.grabarczyk.tomasz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AddValuesToFields extends WriteToExcel implements ActionListener {
    private void addNewValueToField(String[] value, JRadioButton[] button, JFrame frame, ButtonGroup group) {
        for (int i = 0; i < value.length; i++) {
            button[i] = new JRadioButton(value[i]);
            button[i].addActionListener(this);
            group.add(button[i]);
            frame.add(button[i]);
        }
    }

    void addValuesToFields() {
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
