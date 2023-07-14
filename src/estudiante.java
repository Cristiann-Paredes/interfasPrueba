import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class estudiante extends JPanel {
    private JTextField ingresarapellido;
    private JTextField ingresarnombre;
    private JTextField ingresarcedula;
    private JTextField ingresarcodigo;
    private JComboBox<String> anos;
    private JComboBox<String> mes;
    private JComboBox<String> dia;
    private JCheckBox rojoCheckBox;
    private JCheckBox verdeCheckBox;
    private JCheckBox ningunoCheckBox;
    private JRadioButton siRadioButton;
    private JRadioButton noRadioButton;
    private JComboBox<String> signos;
    private JButton cargarButton;
    private JButton guardarButton;

    public estudiante(DefaultListModel<String> estudiantesListModel) {
        setLayout(new GridLayout(6, 2));

        JLabel etiquetaCodigo = new JLabel("Código:");
        ingresarcodigo = new JTextField();
        JLabel etiquetaCedula = new JLabel("Cédula:");
        ingresarcedula = new JTextField();
        JLabel etiquetaNombre = new JLabel("Nombre:");
        ingresarnombre = new JTextField();
        JLabel etiquetaApellido = new JLabel("Apellido:");
        ingresarapellido = new JTextField();
        JLabel etiquetaFechaNacimiento = new JLabel("Fecha de Nacimiento:");
        anos = new JComboBox<>(new String[]{"1990", "1991", "1992", "1993"}); // Año
        mes = new JComboBox<>(new String[]{"Enero", "Febrero", "Marzo", "Abril"}); // Mes
        dia = new JComboBox<>(new String[]{"1", "2", "3", "4"}); // Día
        JLabel etiquetaColorFavorito = new JLabel("Color Favorito:");
        rojoCheckBox = new JCheckBox("Rojo");
        verdeCheckBox = new JCheckBox("Verde");
        ningunoCheckBox = new JCheckBox("Ninguno");
        JLabel etiquetaEstudia = new JLabel("¿Estudia? ");
        siRadioButton = new JRadioButton("Sí");
        noRadioButton = new JRadioButton("No");
        ButtonGroup estudiaButtonGroup = new ButtonGroup();
        estudiaButtonGroup.add(siRadioButton);
        estudiaButtonGroup.add(noRadioButton);
        JLabel etiquetaSigno = new JLabel("Signo Zodiacal:");
        signos = new JComboBox<>(new String[]{"Aries", "Tauro", "Géminis", "Cáncer"});
        cargarButton = new JButton("Cargar");
        guardarButton = new JButton("Guardar");

        add(etiquetaCodigo);
        add(ingresarcodigo);
        add(etiquetaCedula);
        add(ingresarcedula);
        add(etiquetaNombre);
        add(ingresarnombre);
        add(etiquetaApellido);
        add(ingresarapellido);
        add(etiquetaFechaNacimiento);
        add(anos);
        add(mes);
        add(dia);
        add(etiquetaColorFavorito);
        add(rojoCheckBox);
        add(verdeCheckBox);
        add(ningunoCheckBox);
        add(etiquetaEstudia);
        add(siRadioButton);
        add(noRadioButton);
        add(etiquetaSigno);
        add(signos);
        add(cargarButton);
        add(guardarButton);

        cargarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarEstudiantes(estudiantesListModel);
            }
        });

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarEstudiante(estudiantesListModel);
            }
        });
    }

    private void cargarEstudiantes(DefaultListModel<String> estudiantesListModel) {
        // Simulación de carga de estudiantes desde una fuente de datos
        estudiantesListModel.clear();
        estudiantesListModel.addElement("Estudiante 1");
        estudiantesListModel.addElement("Estudiante 2");
        estudiantesListModel.addElement("Estudiante 3");
    }

    private void guardarEstudiante(DefaultListModel<String> estudiantesListModel) {
        String codigo = ingresarcodigo.getText();
        String cedula = ingresarcedula.getText();
        String nombre = ingresarnombre.getText();
        String apellido = ingresarapellido.getText();
        String fechaNacimiento = anos.getSelectedItem() + "-" + mes.getSelectedItem() + "-" + dia.getSelectedItem();
        String colorFavorito = "";
        if (rojoCheckBox.isSelected()) {
            colorFavorito = "Rojo";
        } else if (verdeCheckBox.isSelected()) {
            colorFavorito = "Verde";
        } else if (ningunoCheckBox.isSelected()) {
            colorFavorito = "Ninguno";
        }
        String estudia = siRadioButton.isSelected() ? "Sí" : "No";
        String signo = (String) signos.getSelectedItem();

        // Aquí puedes realizar la lógica para guardar el estudiante en tu sistema o en una base de datos
        // Por ahora, simplemente mostraremos los datos ingresados en la lista
        String estudianteInfo = "Código: " + codigo + ", Cédula: " + cedula + ", Nombre: " + nombre +
                ", Apellido: " + apellido + ", Fecha de Nacimiento: " + fechaNacimiento +
                ", Color Favorito: " + colorFavorito + ", ¿Estudia?: " + estudia + ", Signo Zodiacal: " + signo;
        estudiantesListModel.addElement(estudianteInfo);

        // Limpiar los campos de entrada después de guardar
        ingresarcodigo.setText("");
        ingresarcedula.setText("");
        ingresarnombre.setText("");
        ingresarapellido.setText("");
        rojoCheckBox.setSelected(false);
        verdeCheckBox.setSelected(false);
        ningunoCheckBox.setSelected(false);
        siRadioButton.setSelected(false);
        noRadioButton.setSelected(false);
        signos.setSelectedIndex(0);
    }
}
