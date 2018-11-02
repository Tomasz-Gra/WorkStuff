package dispaching.excel.writer.grabarczyk.tomasz;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Variables {
    String[]
            bottomButtonsValues = {"Change Impact/Urgency/Priority", "Priority Was Changed", "PH", "RESTART"},
            textFieldValues = {"assignedGroup", "ticketTypeValues", "incidentNumber", "sapArea", "consultant", "status", "statusReason", "impact", "urgency", "priority", "reportedDate", "inProgressStart", "pendingStartDate", "resolutionDateResolved", "resolutionTime", "cr", "crTwoTenDays", "slaFirstReactionValues", "slaSolutionValues", "wronglyAssignedValues", "destinationGroupValues", "priorityWasChangedValues", "priorityChangeValues", "initialPriorityValues", "customer", "customerMail", "crAcceptanceDate"},
            labelValues = {"Assigned Group", "Ticket Type", "Incident Number", "SAP Area", "Consultant", "Status", "Status Reason", "Impact", "Urgency", "Priority", "Reported Date", "In Progress Start", "Pending Start Date", "Resolution Date (Resolved)", "Resolution Time", "CR", "CR (2-10) Days", "SLA First Reaction", "SLA Solution", "Wrongly Assigned", "Destination Group", "Priority Was Changed", "Priority Change", "Initial Priority", "Customer", "Customer E-Mail", "CR Acceptance Date"};

    String[]
            initialVersionValues = {},
            versionValues = {},
            initialStatusValues = {},
            initialTicketTypeValues = {},
            initialSapAreaValues = {},
            initialSalesConsultantValues = {},
            initialLogisticsConsultantValues = {},
            initialFicoConsultantValues = {},
            initialDevelopmentConsultantValues = {},
            initialHrConsultantValues = {},
            initialStatusReasonValues = {},

            impactChangeValues = {"1-Extensive/Widespread", "2-Significant/Large", "3-Moderate/Limited", "4-Minor/Localized"},
            urgencyChangeValues = {"1-Critical", "2-High", "3-Medium", "4-Low"},
            priorityChangeValues = {"Critical", "High", "Medium", "Low"},




            assignedGroupValues = {},
            slaFirstReactionValuesChange = {"IN", "OUT"},
            slaSolutionValuesChange = {"IN", "OUT"},
            wronglyAssignmentValuesChange = {"1", "NULL"},
            destinationGroupValuesChange = {},
            priorityWasChangedValuesChange = {"Yes", "NULL"},
            priorityChangeValuesChange = {"INCREASE", "DECREASE"},
            initialPriorityValuesChange = {"CRITICAL", "HIGH", "MEDIUM", "LOW"};

    JFrame
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



            drawFrame = new JFrame("Dispatching Desk Excel Report Filler - ver 0.0.1"),

            assignedGroup_FR = new JFrame("Change Assigned Group"),


            slaFirstReactionChange_FR = new JFrame("Change SLA First Reaction"),
            slaSolutionChange_FR = new JFrame("Change SLA Solution"),
            wronglyAssignedChange_FR = new JFrame("Change Wrongly Assignment"),
            destinationGroupChange_FR = new JFrame("Change Destination Group"),
            priorityWasChangedChange_FR = new JFrame("Change Priority Was Changed"),
            priorityWasChangedPriorityChange_FR = new JFrame("Change Priority Change"),
            initialPriorityChange_FR = new JFrame("Change Initial Priority");

    JRadioButton[]
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
            priorityChange_RB = new JRadioButton[priorityChangeValues.length];



    JTextField[] textFields = new JTextField[textFieldValues.length];
    JLabel[] labels = new JLabel[labelValues.length];
    JButton[] bottomButton = new JButton[bottomButtonsValues.length];

    ButtonGroup
            version_BG = new ButtonGroup(),
            status_BG = new ButtonGroup(),
            ticketType_BG = new ButtonGroup(),
            sapArea_BG = new ButtonGroup(),
            consultant_BG = new ButtonGroup(),
            statusReason_BG = new ButtonGroup(),


            impactChange_BG = new ButtonGroup(),
            urgencyChange_BG = new ButtonGroup(),
            priorityChange_BG = new ButtonGroup();



    int incrementByValue = 190;

    void changeImpactFields() {
        textFields[7].setText("");
        textFields[8].setText("");
        textFields[9].setText("");

        textFields[7].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textFields[7].setText("4-Minor/Localized");
                textFields[7].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        textFields[7].setText("3-Moderate/Limited");
                        textFields[7].addMouseListener(new MouseListener() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                textFields[7].setText("2-Significant/Large");
                                textFields[7].addMouseListener(new MouseListener() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        textFields[7].setText("1-Extensive/Widespread");
                                        textFields[7].addMouseListener(new MouseListener() {
                                            @Override
                                            public void mouseClicked(MouseEvent e) {
                                                textFields[7].setText("");
                                            }
                                            @Override
                                            public void mousePressed(MouseEvent e) {
                                            }
                                            @Override
                                            public void mouseReleased(MouseEvent e) { }
                                            @Override
                                            public void mouseEntered(MouseEvent e) { }
                                            @Override
                                            public void mouseExited(MouseEvent e) { }
                                        });
                                    }
                                    @Override
                                    public void mousePressed(MouseEvent e) {
                                    }
                                    @Override
                                    public void mouseReleased(MouseEvent e) { }
                                    @Override
                                    public void mouseEntered(MouseEvent e) { }
                                    @Override
                                    public void mouseExited(MouseEvent e) { }
                                });
                            }
                            @Override
                            public void mousePressed(MouseEvent e) {
                            }
                            @Override
                            public void mouseReleased(MouseEvent e) { }
                            @Override
                            public void mouseEntered(MouseEvent e) { }
                            @Override
                            public void mouseExited(MouseEvent e) { }
                        });
                    }
                    @Override
                    public void mousePressed(MouseEvent e) {
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) { }
                    @Override
                    public void mouseEntered(MouseEvent e) { }
                    @Override
                    public void mouseExited(MouseEvent e) { }
                });
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        });
        textFields[8].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textFields[8].setText("4-Low");
                textFields[8].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        textFields[8].setText("3-Medium");
                        textFields[8].addMouseListener(new MouseListener() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                textFields[8].setText("2-High");
                                textFields[8].addMouseListener(new MouseListener() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        textFields[8].setText("1-Critical");
                                        textFields[8].addMouseListener(new MouseListener() {
                                            @Override
                                            public void mouseClicked(MouseEvent e) {
                                                textFields[8].setText("");
                                            }
                                            @Override
                                            public void mousePressed(MouseEvent e) {
                                            }
                                            @Override
                                            public void mouseReleased(MouseEvent e) { }
                                            @Override
                                            public void mouseEntered(MouseEvent e) { }
                                            @Override
                                            public void mouseExited(MouseEvent e) { }
                                        });
                                    }
                                    @Override
                                    public void mousePressed(MouseEvent e) {
                                    }
                                    @Override
                                    public void mouseReleased(MouseEvent e) { }
                                    @Override
                                    public void mouseEntered(MouseEvent e) { }
                                    @Override
                                    public void mouseExited(MouseEvent e) { }
                                });
                            }
                            @Override
                            public void mousePressed(MouseEvent e) {
                            }
                            @Override
                            public void mouseReleased(MouseEvent e) { }
                            @Override
                            public void mouseEntered(MouseEvent e) { }
                            @Override
                            public void mouseExited(MouseEvent e) { }
                        });
                    }
                    @Override
                    public void mousePressed(MouseEvent e) {
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) { }
                    @Override
                    public void mouseEntered(MouseEvent e) { }
                    @Override
                    public void mouseExited(MouseEvent e) { }
                });
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        });
        textFields[9].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textFields[9].setText("Low");
                textFields[9].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        textFields[9].setText("Medium");
                        textFields[9].addMouseListener(new MouseListener() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                textFields[9].setText("High");
                                textFields[9].addMouseListener(new MouseListener() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        textFields[9].setText("Critical");
                                        textFields[9].addMouseListener(new MouseListener() {
                                            @Override
                                            public void mouseClicked(MouseEvent e) {
                                                textFields[9].setText("");
                                            }
                                            @Override
                                            public void mousePressed(MouseEvent e) {
                                            }
                                            @Override
                                            public void mouseReleased(MouseEvent e) { }
                                            @Override
                                            public void mouseEntered(MouseEvent e) { }
                                            @Override
                                            public void mouseExited(MouseEvent e) { }
                                        });
                                    }
                                    @Override
                                    public void mousePressed(MouseEvent e) {
                                    }
                                    @Override
                                    public void mouseReleased(MouseEvent e) { }
                                    @Override
                                    public void mouseEntered(MouseEvent e) { }
                                    @Override
                                    public void mouseExited(MouseEvent e) { }
                                });
                            }
                            @Override
                            public void mousePressed(MouseEvent e) {
                            }
                            @Override
                            public void mouseReleased(MouseEvent e) { }
                            @Override
                            public void mouseEntered(MouseEvent e) { }
                            @Override
                            public void mouseExited(MouseEvent e) { }
                        });
                    }
                    @Override
                    public void mousePressed(MouseEvent e) {
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) { }
                    @Override
                    public void mouseEntered(MouseEvent e) { }
                    @Override
                    public void mouseExited(MouseEvent e) { }
                });
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        });
    }

    void changePriorityFields() {
        textFields[21].setText("");
        textFields[22].setText("");
        textFields[23].setText("");

        textFields[21].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textFields[21].setText("YES");
                textFields[21].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        textFields[21].setText("");
                    }
                    @Override
                    public void mousePressed(MouseEvent e) {
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) { }
                    @Override
                    public void mouseEntered(MouseEvent e) { }
                    @Override
                    public void mouseExited(MouseEvent e) { }
                });
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        });
        textFields[22].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textFields[22].setText("INCREASE");
                textFields[22].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        textFields[22].setText("DECREASE");
                        textFields[22].addMouseListener(new MouseListener() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                textFields[22].setText("");
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
        textFields[23].addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textFields[23].setText("LOW");
                textFields[23].addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        textFields[23].setText("MEDIUM");
                        textFields[23].addMouseListener(new MouseListener() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                textFields[23].setText("HIGH");
                                textFields[23].addMouseListener(new MouseListener() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        textFields[23].setText("CRITICAL");
                                        textFields[23].addMouseListener(new MouseListener() {
                                            @Override
                                            public void mouseClicked(MouseEvent e) {
                                                textFields[23].setText("");
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
    }
}
