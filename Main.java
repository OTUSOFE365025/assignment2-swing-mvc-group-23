import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CashRegister register = new CashRegister();
            Display view = new Display();
            Controller controller = new Controller(register, view);
            view.setVisible(true);
        });
    }
}