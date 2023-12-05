import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {

    private JFrame frame;
    private JTextField txtA, txtB, txtC;
    private JLabel lblResultado;
    
    public Calculadora() {
        frame = new JFrame("Calculadora de Ecuación Cuadrática");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2));

        // Cuadros de texto y etiquetas
        frame.add(new JLabel("A:"));
        txtA = new JTextField();
        frame.add(txtA);

        frame.add(new JLabel("B:"));
        txtB = new JTextField();
        frame.add(txtB);

        frame.add(new JLabel("C:"));
        txtC = new JTextField();
        frame.add(txtC);

        frame.add(new JLabel("Resultado:"));
        lblResultado = new JLabel();
        frame.add(lblResultado);

        // Botón Calcular
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularResultado();
            }
        });
        frame.add(btnCalcular);

        // Botón Limpiar
        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
        frame.add(btnLimpiar);

        frame.setVisible(true);
    }

    private void calcularResultado() {
        try {
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double c = Double.parseDouble(txtC.getText());

            double discriminante = b * b - 4 * a * c;

            if (discriminante < 0) {
                lblResultado.setText("No hay soluciones reales.");
            } else if (discriminante == 0) {
                double solucion = -b / (2 * a);
                lblResultado.setText("La solución es: " + solucion);
            } else {
                double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
                lblResultado.setText("Las soluciones son: " + raiz1 + " y " + raiz2);
            }
        } catch (NumberFormatException e) {
            lblResultado.setText("Ingrese valores numéricos en A, B y C.");
        }
    }

    private void limpiarCampos() {
        txtA.setText("");
        txtB.setText("");
        txtC.setText("");
        lblResultado.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculadoraEcuacionCuadratica();
            }
        });
    }
}