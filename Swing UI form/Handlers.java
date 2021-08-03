package academy.Bentilzone;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class Handlers {
    private final ButtonGroup radioGroup;

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private JPanel rootPanel;
    private JPanel outputPanel;
    private JTextField outputTextField;
    private JPanel componentsPanel;
    private JRadioButton plainFontRadioButton;
    private JRadioButton boldFontRadioButton;
    private JRadioButton italicFontRadioButton;
    private JCheckBox boldCheckboxCheckBox;
    private JCheckBox italicCheckboxCheckBox;
    private JComboBox colorsSelector;
    private JScrollPane listScrollPanel;
    private JList programmingLanguages;
    private JButton copiedBetton;
    private JList copiedList;
    private JScrollPane copiedScollPane;

    private static final String[] colors = {
            "Red",
            "Blue",
            "Green",
            "Yellow"
    };
    private static final String[] languages = {
            "Java",
            "Python",
            "PHP",
            "JavaScript",
            "Angular JS",
            "Vue JS",
            "React JS",
            "Laravel",
            "Swift",
            "Kotlin",
    };
    public Handlers(){
        radioGroup = new ButtonGroup();
        radioGroup.add(plainFontRadioButton);
        radioGroup.add(boldFontRadioButton);
        radioGroup.add(italicFontRadioButton);
        programmingLanguages.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        plainFontRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                outputTextField.setText("Plain Font");
                outputTextField.setFont(new Font("Serif", Font.PLAIN, 12));
            }
        });
        boldFontRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                outputTextField.setText("Bold Font");
                outputTextField.setFont(new Font("Serif", Font.BOLD, 12));
            }
        });
        italicFontRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                outputTextField.setText("Italic Font");
                outputTextField.setFont(new Font("Serif", Font.ITALIC, 12));
            }
        });
        boldCheckboxCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                outputTextField.setText("Bold Checkbox Selected");
                outputTextField.setFont(new Font("Serif", Font.BOLD, 12));
            }
        });
        italicCheckboxCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                outputTextField.setText("Italic Checkbox Selected");
                outputTextField.setFont(new Font("Serif", Font.ITALIC, 12));
            }
        });
        colorsSelector.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                outputTextField.setText(colors[colorsSelector.getSelectedIndex()]);
            }
        });
        programmingLanguages.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                outputTextField.setText(languages[programmingLanguages.getSelectedIndex()]);
            }
        });
        copiedBetton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputTextField.setText("\"Copy Programming Language\" pressed");
                copiedList.setListData(programmingLanguages.getSelectedValuesList().toArray(new String[0]));
            }
        });
        MouseHandler mouseHandler = new MouseHandler();
        rootPanel.addMouseListener(mouseHandler);
        rootPanel.addMouseMotionListener(mouseHandler);
    }

    private class MouseHandler extends MouseAdapter implements MouseListener, MouseMotionListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.isMetaDown()){
                outputTextField.setText(String.format("Right Mouse clicked at [%d, %d]",
                        e.getX(), e.getY()));
            }else if(e.isAltDown()){
                outputTextField.setText(String.format("Middle Mouse clicked at [%d, %d]",
                        e.getX(), e.getY()));
            }else{
                outputTextField.setText(String.format("Left Mouse clicked at [%d, %d]",
                        e.getX(), e.getY()));
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            outputTextField.setText(String.format("Pressed at [%d, %d]",
                    e.getX(), e.getY()));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            outputTextField.setText(String.format("Released at [%d, %d]",
                    e.getX(), e.getY()));
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            outputTextField.setText(String.format("Mouse entered at [%d, %d]",
                    e.getX(), e.getY()));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            outputTextField.setText(String.format("Mouse exited at [%d, %d]",
                    e.getX(), e.getY()));
        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
}
