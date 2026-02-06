import javax.swing.*;
import java.awt.*;

public class TimePanel extends JPanel {
    private final RadiographyService service;

    private JTextField textOldSFD = new JTextField();
    private JTextField textOldTime = new JTextField();
    private JTextField textNewSFD = new JTextField();
    private JTextArea resultArea = new JTextArea();

    public TimePanel(RadiographyService service){
        this.service = service;
        init();
    }
    private void init(){
        setLayout(new BorderLayout(10, 10));

        JPanel inputs = new JPanel(new GridLayout(4, 2, 8, 8));

        inputs.add(new JLabel("Old SFD (mm):"));
        inputs.add(textOldSFD);

        inputs.add(new JLabel("Old time (minutes):"));
        inputs.add(textOldTime);

        inputs.add(new JLabel("New SFD (mm):"));
        inputs.add(textNewSFD);

        JButton btnCalculate = new JButton("Calculate New Time");
        inputs.add(btnCalculate);

        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        add(inputs, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        btnCalculate.addActionListener(e -> calculate());
    }

    private void calculate() {
        try {
            double oldSFD = Double.parseDouble(textOldSFD.getText());
            double oldTime = Double.parseDouble(textOldTime.getText());
            double newSFD = Double.parseDouble(textNewSFD.getText());

            String result = service.calculateNewTime(oldSFD, oldTime, newSFD);
            resultArea.setText(result);
            resultArea.setForeground(result.startsWith("Error") ? Color.RED : Color.BLACK);
        } catch (NumberFormatException ex) {
            resultArea.setForeground(Color.RED);
            resultArea.setText("Please enter correct numbers!");
        }
    }
}
