import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Display extends JFrame {
    private final JTextArea itemArea;
    private final JLabel subtotalLabel;
    private final JButton scanButton;

    public Display() {
        setTitle("Cash Register");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        itemArea = new JTextArea();
        itemArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(itemArea);
        add(scrollPane, BorderLayout.CENTER);

        subtotalLabel = new JLabel("Subtotal: $0.00");
        add(subtotalLabel, BorderLayout.SOUTH);

        scanButton = new JButton("Scan");
        add(scanButton, BorderLayout.NORTH);
    }

    public void addScanListener(ActionListener listener) {
        scanButton.addActionListener(listener);
    }

    public void addItem(String item) {
        itemArea.append(item + "\n");
    }

    public void updateSubtotal(double subtotal) {
        subtotalLabel.setText("Subtotal: $" + String.format("%.2f", subtotal));
    }
}