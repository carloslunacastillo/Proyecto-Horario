import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class LogIn extends JFrame implements ActionListener{
    private final JPanel panel;
    private final JButton aceptar;
    private final JButton registrar;
    private final JLabel titulo;
    private final JLabel noCtrl;
    private final JLabel pass;
    private final JTextField noControl;
    private final JTextField password;;
    private Connection conexion;
    private Statement declaracion;
    private Alumno alumno;
    
    public LogIn(Connection c, Statement s){
        super("Log In");
        conexion = c;
        declaracion = s;
        alumno = new Alumno();
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.red);
        aceptar = new JButton("Aceptar");
        aceptar.setBackground(Color.white);
        aceptar.setForeground(Color.red);
        aceptar.addActionListener(this);
        registrar = new JButton("Registrate");
        registrar.setBackground(Color.white);
        registrar.setForeground(Color.red);
        registrar.addActionListener(this);
        titulo = new JLabel("    MODIFICACION DE HORARIO.");
        titulo.setFont(new Font("Arial", Font.BOLD, 13));
        titulo.setForeground(Color.red);
        noCtrl = new JLabel("No Control");
        noCtrl.setForeground(Color.WHITE);
        pass = new JLabel("Contraseña");
        pass.setForeground(Color.WHITE);
        noControl = new JTextField(10);
        password = new JTextField(10);
        
        panel.add(noCtrl);
        panel.add(noControl);
        panel.add(pass);
        panel.add(password);
        panel.add(aceptar);
        panel.add(registrar);
        
        add(titulo, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        setResizable(false);
        setBounds(500,200,220,130);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aceptar) {
            try {
                ResultSet tabla = declaracion.executeQuery("SELECT * FROM ALUMN"
                        + "O");
                while (tabla.next()) {
                    int num;
                    try {
                        num = Integer.parseInt(noControl.getText());
                    } 
                    catch (Exception ex) {
                        num = 0;
                    }
                    if (num == tabla.getInt("NoControl")) {
                        int p;
                        try {
                            p = Integer.parseInt(password.getText());
                        } 
                        catch (Exception ex) {
                            p = 0;
                        }
                        if (p == tabla.getInt("Contraseña")) {
                            alumno.setNoControl(
                                    tabla.getInt("NoControl"));
                            alumno.setPassword(
                                    tabla.getInt("Contraseña"));
                            alumno.setNombre(tabla.getString("Nombre"));
                            alumno.setSemestre(tabla.getInt("Semestre"));
                            alumno.setNoGrupos(tabla.getInt("NoGrupos"));
                            new Modificar(conexion, declaracion, alumno);
                            dispose();
                        } 
                        else {
                            JOptionPane.showMessageDialog(null, "Contraseña "
                                    + "incorrecta.\nIntente otra vez");
                            password.setText("");
                        }
                        tabla.last();
                    } 
                    else if (tabla.isLast()) {
                        JOptionPane.showMessageDialog(null, "El numero de co"
                                + "ntrol no existe. \nIntente otra vez");
                        noControl.setText("");
                        password.setText("");
                    }
                }
            } 
            catch (SQLException ex) {}
        } 
        else {
            new Registro(conexion, declaracion);
            dispose();
        }
    }
}