import javax.swing.*;
import java.awt.*;


public class Main {
    private DefaultListModel<String> estudiantesListModel;

    public Main() {
        JFrame frame = new JFrame("Registro de Estudiantes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        estudiantesListModel = new DefaultListModel<>();
        JList<String> estudiantesList = new JList<>(estudiantesListModel);
        JScrollPane scrollPane = new JScrollPane(estudiantesList);

        frame.add(scrollPane, BorderLayout.CENTER);

        estudiante panelEstudiantes = new estudiante(estudiantesListModel);
        frame.add(panelEstudiantes, BorderLayout.WEST);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

            }
        }
