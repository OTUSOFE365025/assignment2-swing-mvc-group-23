import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private final CashRegister register;
    private final Display view;

    public Controller(CashRegister register, Display view) {
        this.register = register;
        this.view = view;

        this.view.addScanListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Product product = register.scanRandomProduct();
                if (product != null) {
                    view.addItem(product.toString());
                    view.updateSubtotal(register.getSubtotal());
                }
            }
        });
    }
}