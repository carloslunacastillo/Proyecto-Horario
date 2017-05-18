import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
public class Abrir extends JFrame implements ActionListener{
    private final JPanel panel;
    private final JButton si;
    private final JButton no;
    private final JLabel l;
    private Alumno alumno;
    
    public Abrir(Alumno a){
        alumno = a;
        panel = new JPanel();
        panel.setFont(new Font("Arial",Font.BOLD,12));
        panel.setBackground(Color.blue);
        panel.setLayout(new FlowLayout());
        si = new JButton("SI");
        si.setBackground(Color.white);
        si.setForeground(Color.blue);
        si.addActionListener(this);
        no = new JButton("NO");
        no.setBackground(Color.white);
        no.setForeground(Color.blue);
        no.addActionListener(this);
        l = new JLabel("¿DESEAS ABRIR EL ARCHIVO?");
        l.setForeground(Color.white);
        
        panel.add(l);
        panel.add(si);
        panel.add(no);
        add(panel);
        setVisible(true);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setBounds(200,200,180,100);
        setResizable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == si){
            try {
                File archivo = new File ("C:/Horario/"+alumno.getNoControl()
                        + "horario.PDF");
                Desktop.getDesktop().open(archivo);
            }
            catch (IOException ex) {}
        }
        dispose();
    }
}
