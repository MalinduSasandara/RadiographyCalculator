import javax.swing.*;
import java.awt.*;

public class SODPanel extends JPanel{
    private final RadiographyService service;

    private JTextField textSourceSize = new JTextField();
    private JTextField textOFD = new JTextField();
    private JTextField textMaxUg = new JTextField();
    private JTextArea resultArea = new JTextArea();

    public SODPanel(RadiographyService service){
        this.service = service;
        init();
    }
    public void init(){
        setLayout(new BorderLayout(10,10));
        JPanel inputs = new JPanel(new GridLayout(15,15,15,15));

        inputs.add(new JLabel("Source size (mm):"));
        inputs.add(textSourceSize);

        inputs.add(new JLabel("OFD - object to film (mm):"));
        inputs.add(textOFD);

        inputs.add(new JLabel("Max allowed Ug (mm):"));
        inputs.add(textMaxUg);

        JButton calculateBtn = new JButton("Calculate SOD");
        inputs.add(calculateBtn);

        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setFont(new Font("Monospaced",Font.PLAIN,14));

        add(inputs,BorderLayout.NORTH);
        calculateBtn.addActionListener(e -> calculate());
    }
    private void calculate(){
        try {
            double source = Double.parseDouble(textSourceSize.getText());
            double ofd = Double.parseDouble(textOFD.getText());
            double ug = Double.parseDouble(textMaxUg.getText());

            String result = service.calculateSOD(source, ofd, ug);
            resultArea.setText(result);
            resultArea.setForeground(result.startsWith("Error") ? Color.RED : Color.BLACK);
        } catch (NumberFormatException ex){
            resultArea.setForeground(Color.RED);
            resultArea.setText("Please enter correct numbers!");
        }
    }
}