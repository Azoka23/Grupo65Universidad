package grupo65universidad.Vistas;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class Utilidades {

    public static boolean confirmarSalida(JInternalFrame internalFrame) {
        int confirmacion = JOptionPane.showOptionDialog(
                internalFrame,
                "¿Estás seguro que quieres salir de la aplicación?",
                "Salir de la aplicación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"Sí", "No"},
                "No"
        );

        return confirmacion == JOptionPane.YES_OPTION;
    }

    public static void limpiarSetText(javax.swing.JTextField... campos) {
        for (javax.swing.JTextField campo : campos) {
            campo.setText("");
        }
    }

    public static void mostrarError(Exception ex,JInternalFrame internalFrame) {
        JOptionPane.showMessageDialog(internalFrame, "Error: " + ex.getMessage());
    }
}
