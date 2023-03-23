import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {
    String[] options = {
            "Choose a conversion option",
            "Fahrenheit => Celsius",
            "Miles => Kilometers/hour",
            "Euro => Dollar",
            "Euro => Pound sterling",
            "Euro => Rouble" };
    private JComboBox optionsList;
    private JFrame appFrame;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel middlePanel;
    private JLabel title;
    private JTextField valueInput;
    private JLabel valueLabel;
    private JTextField valueTaxInput;
    private JLabel valueTaxLabel;
    private JButton conversionBtn;
    private JLabel result;
    private String resultStr;
    private Float distResult;
    private Double tempResult;
    private Float coinResult;
    private Convertor convertor;

    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.convertor = new Convertor();
        gui.appFrame = new JFrame("Conversion App");
        gui.interfaceGui();
    }

    public void interfaceGui() {
        inputBoxes(); // inputbox
        dropDownChoice(); // Dropdown
        mainFrame(); // main frame
    }

    // App frame
    public void mainFrame() {
        try {
            // Title
            result = new JLabel();
            title = new JLabel("Conversion Application");
            // Top panel
            topPanel = new JPanel();
            topPanel.setLayout(new GridLayout(2,2));
            topPanel.add(valueLabel);
            topPanel.add(valueInput);
            topPanel.add(valueTaxLabel);
            topPanel.add(valueTaxInput);
            // Middle panel
            middlePanel = new JPanel();
            middlePanel.add(result);
            // Bottom panel
            bottomPanel = new JPanel();
            bottomPanel.add(conversionBtn);

            appFrame.getContentPane().setLayout(new BoxLayout(appFrame.getContentPane(), BoxLayout.Y_AXIS));
            appFrame.getContentPane().add(BorderLayout.NORTH,title);
            appFrame.getContentPane().add(BorderLayout.NORTH, optionsList);
            appFrame.getContentPane().add(BorderLayout.EAST,topPanel);
            appFrame.getContentPane().add(BorderLayout.SOUTH,bottomPanel);
            appFrame.getContentPane().add(BorderLayout.CENTER,middlePanel);
            appFrame.setSize(350, 350);
            appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            appFrame.setVisible(true);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // DropDown selection
    public void dropDownChoice() {
        try {
            optionsList = new JComboBox();

            for (int i = 0; i < options.length; i++ ) {
                optionsList.addItem(options[i]);
            }

            optionsList.setSelectedIndex(0);
            optionsList.addActionListener(new choiceListenner());
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // Inputs
    public void inputBoxes() {
        try {
            valueInput = new JTextField(20);
            valueLabel = new JLabel();
            valueTaxInput = new JTextField(20);
            valueTaxLabel = new JLabel();
            conversionBtn = new JButton("Convert!");

            valueInput.setVisible(false);
            valueLabel.setVisible(false);
            valueTaxInput.setVisible(false);
            valueTaxLabel.setVisible(false);
            conversionBtn.setVisible(false);

            conversionBtn.addActionListener(new convertListenner());
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // Show or hide ui elements with tax
    private void setVisibleToCoin() {
        try {
            valueLabel.setText("Euro");
            valueInput.setVisible(true);
            valueTaxLabel.setText("Tax");
            valueTaxLabel.setVisible(true);
            valueTaxInput.setVisible(true);
            valueLabel.setVisible(true);
            conversionBtn.setVisible(true);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // Show or hide ui elements without tax
    private void setVisibleDefault() {
        try {
            valueInput.setVisible(true);
            valueLabel.setVisible(true);
            conversionBtn.setVisible(true);
            valueTaxLabel.setVisible(false);
            valueTaxInput.setVisible(false);

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // Format result str
    private void setResultStr() {
        try {
            switch (optionsList.getSelectedItem().toString()) {
                case "Euro => Dollar":
                    result.setText(resultStr + "$");
                    break;
                case "Euro => Pound sterling":
                    result.setText(resultStr + "£");
                    break;
                case "Euro => Rouble":
                    result.setText(resultStr + "₽");
                    break;
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // Add input red border
    private void addErrorBorders() {
        valueInput.setBorder(new LineBorder(Color.red, 1));
        valueTaxInput.setBorder(new LineBorder(Color.red, 1));
    }

    // Remove input red border
    private void removeErrorBorders() {
        valueInput.setBorder(new LineBorder(Color.gray, 1));
        valueTaxInput.setBorder(new LineBorder(Color.gray, 1));
    }

    // User conversion option
    private class choiceListenner implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                valueInput.setText("");
                valueTaxInput.setText("0.00");
                result.setVisible(false);
                removeErrorBorders();

                switch (optionsList.getSelectedItem().toString()) {
                    case "Fahrenheit => Celsius":
                        valueLabel.setText("Fahrenheit");
                        setVisibleDefault();
                        break;
                    case "Miles => Kilometers/hour":
                        valueLabel.setText("Miles");
                        setVisibleDefault();
                        break;
                    case "Euro => Dollar":
                        setVisibleToCoin();
                        break;
                    case "Euro => Pound sterling":
                        setVisibleToCoin();
                        break;
                    case "Euro => Rouble":
                        setVisibleToCoin();
                        break;
                    default:
                        valueInput.setVisible(false);
                        valueLabel.setVisible(false);
                        valueTaxInput.setVisible(false);
                        valueTaxLabel.setVisible(false);
                        conversionBtn.setVisible(false);
                        break;
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    // Make conversion
    private class convertListenner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (!valueInput.getText().toString().matches("-?\\d+") || !valueTaxInput.getText().toString().matches("-?\\d+")) {
                    removeErrorBorders();

                    if (optionsList.getSelectedItem().toString() == "Fahrenheit => Celsius") {
                        tempResult = convertor.temperatureConversion(Double.parseDouble(valueInput.getText()));
                        resultStr = Double.toString(tempResult);
                        result.setText(resultStr + "°C");
                    } else if (optionsList.getSelectedItem().toString() == "Miles => Kilometers/hour") {
                        distResult = convertor.distanceConversion(Float.parseFloat(valueInput.getText()));
                        resultStr = Float.toString(distResult);
                        result.setText(resultStr + " km/h");
                    } else if (optionsList.getSelectedItem().toString() == "Euro => Dollar" || optionsList.getSelectedItem().toString() == "Euro => Pound sterling" || optionsList.getSelectedItem().toString() == "Euro => Rouble") {
                        coinResult = convertor.coinConversion(Float.parseFloat(valueInput.getText()), Float.parseFloat(valueTaxInput.getText()));
                        resultStr = Float.toString(coinResult);
                        setResultStr();
                    }

                    result.setVisible(true);
                }
            } catch(Exception ex) {
                System.out.println(ex);
                addErrorBorders();
                result.setText("");
            }
        }
    }
}
