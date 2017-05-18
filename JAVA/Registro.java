import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Registro extends JFrame implements ActionListener{
    private final JPanel[] p = new JPanel[6];
    private final JButton acept;
    private final JButton cancel;
    private final JLabel ctrl;
    private final JLabel pass;
    private final JLabel name;
    private final JLabel sem;
    private final JLabel terminos;
    private final JCheckBox acepto;
    private final String[] s = {"<Elige una>","1","2","3","4"};
    private JTextField noControl;
    private JTextField password;
    private JTextField nombre;
    private JComboBox<String> semestre;
    private Connection conexion;
    private Statement declaracion;
    private ResultSet tabla;
    
    public Registro(Connection c, Statement d){
        super("Registro de alumnos");
        
        conexion = c;
        declaracion = d;
        
        for(int x = 0; x < p.length; x++){
            p[x] = new JPanel();
            p[x].setLayout(new FlowLayout(FlowLayout.LEFT));
        }
        
        acept = new JButton("Aceptar");
        acept.setEnabled(false);
        acept.addActionListener(this);
        cancel = new JButton("Cancelar");
        cancel.addActionListener(this);
        ctrl = new JLabel("No. Control");
        pass = new JLabel("Contraseña");
        name = new JLabel("Nombre");
        sem = new JLabel("Semestre");
        terminos = new JLabel("Acepto los terminos y condiciones de uso");
        terminos.setForeground(Color.blue);
        terminos.setFont(new Font("Arial", Font.BOLD, 12));
        terminos.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                JOptionPane.showMessageDialog(null, "No hay terminos ni condici"
                        + "ones de uso\nNo creimos que alguien las leeria");
            }
        });
        acepto = new JCheckBox();
        acepto.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(acepto.isSelected()){
                    acept.setEnabled(true);
                }
                else{
                    acept.setEnabled(false);
                }
            }
        });
        try {
            tabla = declaracion.executeQuery("SELECT * FROM ALUMNO");
            tabla.last();
            int num = Integer.parseInt(tabla.getString("NoControl"))+1;
            noControl = new JTextField(""+num);
        } 
        catch (SQLException ex) {}
        noControl.setEditable(false);
        int z = (int)(Math.random()*1000000);
        String con = z+"";
        int y = 6-con.length();
        for(int x = 0; x < y; x++){
            con = "0"+con;
        }
        password = new JTextField(con);
        password.setEditable(false);
        nombre = new JTextField(20);
        semestre = new JComboBox<>(s);
        
        p[0].add(ctrl);
        p[0].add(noControl);
        p[1].add(pass);
        p[1].add(password);
        p[2].add(name);
        p[2].add(nombre);
        p[3].add(sem);
        p[3].add(semestre);
        p[4].add(acepto);
        p[4].add(terminos);
        p[5].setLayout(new FlowLayout(FlowLayout.CENTER));
        p[5].add(acept);
        p[5].add(cancel);
        
        for(int x = 0; x < p.length; x++){
            add(p[x]);
        }
        
        setLayout(new GridLayout(6,1));
        setVisible(true);
        setBounds(500,300,300,220);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == acept) {
            if (nombre.getText().isEmpty() || semestre.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "LO SENTIMOS HAY DATOS "
                        + "INCORRECTOS.\nVERIFIQUE SU INFORMACION E INTENTE"
                        + " DE NUEVO");
            } 
            else {
                String n = nombre.getText().toUpperCase();
                JOptionPane.showMessageDialog(null, "No Control: "
                        + noControl.getText() + "\nContraseña: "
                        + password.getText() + "\nNombre: " + n + "\nSemestre: "
                        + semestre.getSelectedIndex(), "Datos del alumno", 1);
                try {
                    declaracion.executeUpdate("INSERT INTO ALUMNO VALUES ('"
                            + noControl.getText() + "','"
                            + password.getText() + "','" + n + "',"
                            + semestre.getSelectedIndex() + ",0)");
                    JOptionPane.showMessageDialog(null, "GUARDANDO DATOS");
                } 
                catch (SQLException ex) {
                    ex.printStackTrace();
                }
                dispose();
                JOptionPane.showMessageDialog(null, "DATOS GUARDADOS");
                new LogIn(conexion, declaracion);
            }
        } 
        else {
            new LogIn(conexion, declaracion);
            dispose();
        }
    }
}