package dispaching.excel.writer.grabarczyk.tomasz;

import javax.swing.*;
import java.awt.*;

class DrawFields extends AddValuesToFields {
    void drawPopUpFrame(JFrame nameOfFrame, String[] value) {
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

    void drawFields() {
        addValuesToFields();

        // Draw buttons on bottom
        int x = 100, fieldX = 18, labelFirstX = 18;
        for (int i = 0; i < bottomButton.length; i++) {
            bottomButton[i] = new JButton(bottomButtonsValues[i]);
            bottomButton[i].addActionListener(this);
            bottomButton[i].setFocusPainted(false);
            bottomButton[i].setBounds(x, 350, 200, 40);
            x += 300;
            drawFrame.add(bottomButton[i]);
        }

        // Draw all fields in frame
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
            } else {
                if (fieldX == 1348) fieldX = 18;
                drawAllFields(fieldX, 290, i);
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
            } else {
                if (labelFirstX == 1348) labelFirstX = 18;
                drawAllLabels(labelFirstX, 260, i);
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
        drawFrame.setSize(1366, 448);
        drawFrame.setLocationRelativeTo(null);
        drawFrame.setResizable(false);
        drawFrame.setVisible(true);
    }
}
