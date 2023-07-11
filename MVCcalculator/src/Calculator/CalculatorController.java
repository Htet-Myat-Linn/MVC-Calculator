package Calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

public class CalculatorController {
    private CalculatorView view;
    private CalculatorModel model;
    
    public CalculatorController(CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;
        
        this.view.addCalculationListener(new CalculateListener());
    }
    
    class CalculateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int firstNumber, secondNumber = 0;
            
            try {
                firstNumber = view.getFirstNumber();
                secondNumber = view.getSecondNumber();
                
                model.addTwoNumbers(firstNumber, secondNumber);
                
                view.setCalcSolution(model.getCalculationValue());
            } catch (NumberFormatException ex) {
                System.out.println(ex);
                view.displayErrorMessage("You need to enter 2 integers");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CalculatorView view = new CalculatorView();
                CalculatorModel model = new CalculatorModel();
                CalculatorController controller = new CalculatorController(view, model);
                view.setVisible(true);
            }
        });
    }
}
