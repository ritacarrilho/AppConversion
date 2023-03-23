import javax.swing.*;
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
    private JPanel topPannel;
    private JPanel bottomPannel;
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
//        Convertor convertor = new Convertor();
//        convertor.makeConversion();
        Gui gui = new Gui();
        gui.convertor = new Convertor();
        gui.appFrame = new JFrame("Conversion App");
        gui.interfaceGui();
    }

    public void interfaceGui() {
        // Title
        title = new JLabel("Conversion Application");

        // inputbox1
        inputBoxes();

        // Dropdown
        dropDownChoice();

        // main frame
        mainFrame();
    }

    // App frame
    public void mainFrame() {
        topPannel = new JPanel();
        topPannel.add(valueLabel);
        topPannel.add(valueInput);
        topPannel.add(valueTaxLabel);
        topPannel.add(valueTaxInput);
        topPannel.add(conversionBtn);

        bottomPannel = new JPanel();
        result = new JLabel();
        bottomPannel.add(result);

        appFrame.getContentPane().setLayout(new BoxLayout(appFrame.getContentPane(), BoxLayout.Y_AXIS));

        appFrame.getContentPane().add(BorderLayout.NORTH,title);
        appFrame.getContentPane().add(BorderLayout.NORTH, optionsList);
        appFrame.getContentPane().add(BorderLayout.CENTER,topPannel);
        appFrame.getContentPane().add(BorderLayout.SOUTH,bottomPannel);
        appFrame.setSize(350, 350);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setVisible(true);
    }

    public void dropDownChoice() {
        optionsList = new JComboBox();

        for (int i = 0; i < options.length; i++ ) {
            optionsList.addItem(options[i]);
        }

        optionsList.setSelectedIndex(0);
        optionsList.addActionListener(new choiceListenner());
    }

    public void inputBoxes() {
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
    }

    // User conversion option
    private class choiceListenner implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            switch (optionsList.getSelectedItem().toString()) {
                case "Fahrenheit => Celsius":
                    valueInput.setVisible(true);
                    valueLabel.setText("Fahrenheit");
                    valueLabel.setVisible(true);
                    conversionBtn.setVisible(true);
                    System.out.println("Fahrenheit => Celsius");
                    break;
                case "Miles => Kilometers/hour":
                    valueInput.setVisible(true);
                    valueLabel.setText("Miles");
                    valueLabel.setVisible(true);
                    conversionBtn.setVisible(true);
                    System.out.println("Miles => Kilometers/hour");
                    break;
                case "Euro => Dollar":
                    valueInput.setVisible(true);
                    valueTaxInput.setVisible(true);
                    valueTaxLabel.setText("Tax");
                    valueTaxLabel.setVisible(true);
                    valueLabel.setText("Euro");
                    valueLabel.setVisible(true);
                    conversionBtn.setVisible(true);
                    System.out.println("Euro => Dollar");
                    break;
                case "Euro => Pound sterling":
                    valueInput.setVisible(true);
                    valueTaxLabel.setText("Tax");
                    valueTaxLabel.setVisible(true);
                    valueTaxInput.setVisible(true);
                    valueLabel.setText("Euro");
                    valueLabel.setVisible(true);
                    conversionBtn.setVisible(true);
                    System.out.println("Euro => Pound sterling");
                    break;
                case "Euro => Rouble":
                    valueInput.setVisible(true);
                    valueTaxLabel.setText("Tax");
                    valueTaxLabel.setVisible(true);
                    valueTaxInput.setVisible(true);
                    valueLabel.setText("Euro");
                    valueLabel.setVisible(true);
                    conversionBtn.setVisible(true);
                    System.out.println("Euro => Rouble");
                    break;
                default:
                    System.out.println("Choose a conversion option");
                    valueInput.setVisible(false);
                    valueLabel.setVisible(false);
                    valueTaxInput.setVisible(false);
                    valueTaxLabel.setVisible(false);
                    conversionBtn.setVisible(false);
                    break;
            }
        }
    }

    private class convertListenner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(optionsList.getSelectedItem().toString() == "Fahrenheit => Celsius") {
                tempResult =  convertor.temperatureConversion(Double.parseDouble(valueInput.getText()));
                resultStr = Double.toString(tempResult);
                result.setText(resultStr + "°C");
            } else if (optionsList.getSelectedItem().toString() == "Miles => Kilometers/hour") {
                distResult = convertor.distanceConversion(Float.parseFloat(valueInput.getText()));
                resultStr = Float.toString(distResult);
                result.setText(resultStr + " km/h");
            } else if (
                optionsList.getSelectedItem().toString() == "Euro => Dollar" ||
                optionsList.getSelectedItem().toString() == "Euro => Pound sterling" ||
                optionsList.getSelectedItem().toString() == "Euro => Rouble"
                ) {
                coinResult = convertor.coinConversion(Float.parseFloat(valueInput.getText()), Float.parseFloat(valueTaxInput.getText()));
                resultStr = Float.toString(coinResult);
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
            }
            result.setVisible(true);
        }
    }
}
