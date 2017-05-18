import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Modificar extends JFrame implements ActionListener{
    private final JPanel[] panel = new JPanel[25];
    private final JLabel[] etiq = new JLabel[4];
    private final JTextField[] gpo = new JTextField[20];
    private final JTextField[] clave = new JTextField[20];
    private final JTextField[] mat = new JTextField[20];
    private final JTextField[] prof = new JTextField[20];
    private final JTextField[] lun = new JTextField[20];
    private final JTextField[] mar = new JTextField[20];
    private final JTextField[] mie = new JTextField[20];
    private final JTextField[] jue = new JTextField[20];
    private final JTextField[] vie = new JTextField[20];
    private final JButton[] agregar = new JButton[12];
    private final JButton[] quitar = new JButton[6];
    private final JButton genera;
    private final JButton salir;
    private Connection conexion;
    private Statement declaracion;
    private ResultSet tabla;
    private Grupo[] grupos = new Grupo[6];
    private Alumno alumno;
    
    public Modificar(Connection c, Statement d, Alumno a){
        super("Modificar Horario");
        
        conexion = c;
        declaracion = d;
        alumno = a;
        genera = new JButton("Generar PDF");
        genera.setFont(new Font("Arial",Font.PLAIN,10));
        genera.addActionListener(this);
        salir = new JButton("Salir");
        salir.setFont(new Font("Arial",Font.PLAIN,10));
        salir.addActionListener(this);
        
        for(int x = 0; x < grupos.length; x++){
            grupos[x] = new Grupo();
        }
        
        int y = 0;
        for(int x = 0; x < panel.length; x++){
            panel[x] = new JPanel();
            panel[x].setLayout(new FlowLayout(FlowLayout.LEFT));
            switch(x){
                case 0:
                    etiq[x] = new JLabel("NO CONTROL: "+alumno.getNoControl());
                    panel[x].add(etiq[x]);
                    break;
                case 1:
                    etiq[x] = new JLabel("ALUMNO: "+alumno.getNombre());
                    panel[x].add(etiq[x]);
                    break;
                case 2:
                    etiq[x] = new JLabel("CARRERA: INGENIERIA EN SISTEMAS COMPU"
                            + "TACIONALES           SEMESTRE: "
                            + alumno.getSemestre());
                    panel[x].add(etiq[x]);
                    break;
                case 3:
                case 11:
                    if(x == 3){
                        y = 3;
                    }
                    else{
                        y = 4;
                    }
                    gpo[x-y] = new JTextField("GPO.",3);
                    gpo[x-y].setBackground(Color.black);
                    gpo[x-y].setForeground(Color.white);
                    gpo[x-y].setEditable(false);
                    clave[x-y] = new JTextField("MAT.",3);
                    clave[x-y].setBackground(Color.black);
                    clave[x-y].setForeground(Color.white);
                    clave[x-y].setEditable(false);
                    mat[x-y] = new JTextField("MATERIA",25);
                    mat[x-y].setBackground(Color.black);
                    mat[x-y].setForeground(Color.white);
                    mat[x-y].setEditable(false);
                    prof[x-y] = new JTextField("PROFESOR (A)",24);
                    prof[x-y].setBackground(Color.black);
                    prof[x-y].setForeground(Color.white);
                    prof[x-y].setEditable(false);
                    lun[x-y] = new JTextField("LUNES",7);
                    lun[x-y].setBackground(Color.black);
                    lun[x-y].setForeground(Color.white);
                    lun[x-y].setEditable(false);
                    mar[x-y] = new JTextField("MARTES",7);
                    mar[x-y].setBackground(Color.black);
                    mar[x-y].setForeground(Color.white);
                    mar[x-y].setEditable(false);
                    mie[x-y] = new JTextField("MIERCOLES",7);
                    mie[x-y].setBackground(Color.black);
                    mie[x-y].setForeground(Color.white);
                    mie[x-y].setEditable(false);
                    jue[x-y] = new JTextField("JUEVES",7);
                    jue[x-y].setBackground(Color.black);
                    jue[x-y].setForeground(Color.white);
                    jue[x-y].setEditable(false);
                    vie[x-y] = new JTextField("VIERNES",7);
                    vie[x-y].setBackground(Color.black);
                    vie[x-y].setForeground(Color.white);
                    vie[x-y].setEditable(false);
                    panel[x].add(gpo[x-y]);
                    panel[x].add(clave[x-y]);
                    panel[x].add(mat[x-y]);
                    panel[x].add(prof[x-y]);
                    panel[x].add(lun[x-y]);
                    panel[x].add(mar[x-y]);
                    panel[x].add(mie[x-y]);
                    panel[x].add(jue[x-y]);
                    panel[x].add(vie[x-y]);
                    break;
                case 10:
                    etiq[x-7] = new JLabel("MATERIAS DISPONIBLES");
                    etiq[x-7].setFont(new Font("Ariel",Font.BOLD,20));
                    panel[x].add(etiq[x-7]);
                    break;
                case 24:
                    panel[x].add(genera);
                    panel[x].add(salir);
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    gpo[x-3] = new JTextField(3);
                    gpo[x-3].setEditable(false);
                    clave[x-3] = new JTextField(3);
                    clave[x-3].setEditable(false);
                    mat[x-3] = new JTextField(25);
                    mat[x-3].setEditable(false);
                    prof[x-3] = new JTextField(24);
                    prof[x-3].setEditable(false);
                    lun[x-3] = new JTextField(7);
                    lun[x-3].setEditable(false);
                    mar[x-3] = new JTextField(7);
                    mar[x-3].setEditable(false);
                    mie[x-3] = new JTextField(7);
                    mie[x-3].setEditable(false);
                    jue[x-3] = new JTextField(7);
                    jue[x-3].setEditable(false);
                    vie[x-3] = new JTextField(7);
                    vie[x-3].setEditable(false);
                    quitar[x-4] = new JButton("Quitar");
                    quitar[x-4].setFont(new Font("Arial",Font.PLAIN,10));
                    quitar[x-4].setEnabled(false);
                    quitar[x-4].addActionListener(this);
                    panel[x].add(gpo[x-3]);
                    panel[x].add(clave[x-3]);
                    panel[x].add(mat[x-3]);
                    panel[x].add(prof[x-3]);
                    panel[x].add(lun[x-3]);
                    panel[x].add(mar[x-3]);
                    panel[x].add(mie[x-3]);
                    panel[x].add(jue[x-3]);
                    panel[x].add(vie[x-3]);
                    panel[x].add(quitar[x-4]);
                    break;
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    gpo[x-4] = new JTextField(3);
                    gpo[x-4].setEditable(false);
                    clave[x-4] = new JTextField(3);
                    clave[x-4].setEditable(false);
                    mat[x-4] = new JTextField(25);
                    mat[x-4].setEditable(false);
                    prof[x-4] = new JTextField(24);
                    prof[x-4].setEditable(false);
                    lun[x-4] = new JTextField(7);
                    lun[x-4].setEditable(false);
                    mar[x-4] = new JTextField(7);
                    mar[x-4].setEditable(false);
                    mie[x-4] = new JTextField(7);
                    mie[x-4].setEditable(false);
                    jue[x-4] = new JTextField(7);
                    jue[x-4].setEditable(false);
                    vie[x-4] = new JTextField(7);
                    vie[x-4].setEditable(false);
                    panel[x].add(gpo[x-4]);
                    panel[x].add(clave[x-4]);
                    panel[x].add(mat[x-4]);
                    panel[x].add(prof[x-4]);
                    panel[x].add(lun[x-4]);
                    panel[x].add(mar[x-4]);
                    panel[x].add(mie[x-4]);
                    panel[x].add(jue[x-4]);
                    panel[x].add(vie[x-4]);
                    agregar[x-12] = new JButton("Agregar");
                    agregar[x-12].setFont(new Font("Arial",Font.PLAIN,10));
                    agregar[x-12].addActionListener(this);
                    panel[x].add(agregar[x-12]);
                    break;
            }
            add(panel[x]);
        }
        
        int cont=0;
        try {
            tabla = declaracion.executeQuery("SELECT * FROM ((ALUMNOGRUPOS LEFT"
                    + " JOIN GRUPO ON GRUPO.CODIGO = ALUMNOGRUPOS.CODIGOGPO) LE"
                    + "FT JOIN MATERIA ON MATERIA.CLAVE = GRUPO.CLAVEMAT) LEFT "
                    + "JOIN DIAS ON DIAS.CODIGOGPO = GRUPO.CODIGO WHERE NOCONTR"
                    + "OL = "+alumno.getNoControl());
            while(tabla.next()){
                grupos[cont].setCodigo(tabla.getString("Codigo"));
                grupos[cont].setClaveMat(tabla.getString("Clave"));
                grupos[cont].setMateria(tabla.getString("Nombre"));
                grupos[cont].setProfesor(tabla.getString("Profesor"));
                grupos[cont].setLunes(tabla.getString("Lunes"));
                grupos[cont].setMartes(tabla.getString("Martes"));
                grupos[cont].setMiercoles(tabla.getString("Miercoles"));
                grupos[cont].setJueves(tabla.getString("Jueves"));
                grupos[cont].setViernes(tabla.getString("Viernes"));
                grupos[cont].setNoAlumnos(tabla.getInt("NoAlumnos"));
                grupos[cont].setMaxAlumnos(tabla.getInt("MaxAlumnos"));
                cont++;
            }
        } 
        catch (SQLException ex) {}
        
        for(int x = 0; x < alumno.getNoGrupos(); x++){
            gpo[x+1].setText(grupos[x].getCodigo());
            clave[x+1].setText(grupos[x].getClaveMat());
            mat[x+1].setText(grupos[x].getMateria());
            prof[x+1].setText(grupos[x].getProfesor());
            lun[x+1].setText(grupos[x].getLunes());
            mar[x+1].setText(grupos[x].getMartes());
            mie[x+1].setText(grupos[x].getMiercoles());
            jue[x+1].setText(grupos[x].getJueves());
            vie[x+1].setText(grupos[x].getViernes());
            quitar[x].setEnabled(true);
        }
        
        cont = 8;
        try {
            tabla = declaracion.executeQuery("SELECT * FROM (GRUPO LEFT JOIN MA"
                    + "TERIA ON MATERIA.CLAVE = GRUPO.CLAVEMAT) LEFT JOIN DIAS "
                    + "ON DIAS.CODIGOGPO = GRUPO.CODIGO WHERE SEMESTRE = "
                    + alumno.getSemestre());
            while(tabla.next()){
                gpo[cont].setText(tabla.getString("Codigo"));
                clave[cont].setText(tabla.getString("Clave"));
                mat[cont].setText(tabla.getString("Nombre"));
                prof[cont].setText(tabla.getString("Profesor"));
                lun[cont].setText(tabla.getString("Lunes"));
                mar[cont].setText(tabla.getString("Martes"));
                mie[cont].setText(tabla.getString("Miercoles"));
                jue[cont].setText(tabla.getString("Jueves"));
                vie[cont].setText(tabla.getString("Viernes"));
                if(tabla.getInt("NoAlumnos") == tabla.getInt("MaxAlumnos")){
                    agregar[cont-8].setEnabled(false);
                }
                cont++;
            }
        } 
        catch (SQLException ex) {}
        
        setLayout(new GridLayout(25,1));
        setVisible(true);
        setResizable(false);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == genera){
            if(alumno.getNoGrupos() > 0){
                new GenerarPDF(alumno, grupos); 
                JOptionPane.showMessageDialog(null, "Archivo guardado en: \n"
                        + "C:/Horario");
                new Abrir(alumno);
            }
            else{
                JOptionPane.showMessageDialog(null,"NO HAS AGREGADO GRUPOS");
            }
        }
        if(e.getSource() == salir){
            dispose();
            new LogIn(conexion, declaracion);
        }
        for(int x = 1; x < quitar.length+1; x++){
            if (e.getSource() == quitar[x-1]) {
                quitar[x-1].setEnabled(false);
                alumno.setMenossNoGrupos();
                try {
                    declaracion.executeUpdate("DELETE FROM ALUMNOGRUPOS WHERE C"
                            + "ODIGOGPO = '"+gpo[x].getText()+"'");
                    declaracion.executeUpdate("UPDATE GRUPO SET NOALUMNOS = NOA"
                            + "LUMNOS - 1 WHERE CODIGO = '"+gpo[x].getText()
                            +"'");
                    declaracion.executeUpdate("UPDATE ALUMNO SET NOGRUPOS = NOG"
                            + "RUPOS - 1 WHERE NOCONTROL = '"
                            + alumno.getNoControl()+"'");
                } 
                catch (SQLException ex) {
                    ex.printStackTrace();
                }
                for(int y = 8; y < gpo.length; y++){
                    if(gpo[x].getText().equals(gpo[y].getText())){
                        agregar[y-8].setEnabled(true);
                    }
                }
                gpo[x].setText(null);
                clave[x].setText(null);
                mat[x].setText(null);
                prof[x].setText(null);
                lun[x].setText(null);
                mar[x].setText(null);
                mie[x].setText(null);
                jue[x].setText(null);
                vie[x].setText(null);
            }
            if(gpo[x-1].getText().isEmpty()){
                gpo[x-1].setText(gpo[x].getText());
                clave[x-1].setText(clave[x].getText());
                mat[x-1].setText(mat[x].getText());
                prof[x-1].setText(prof[x].getText());
                lun[x-1].setText(lun[x].getText());
                mar[x-1].setText(mar[x].getText());
                mie[x-1].setText(mie[x].getText());
                jue[x-1].setText(jue[x].getText());
                vie[x-1].setText(vie[x].getText());
                gpo[x].setText(null);
                clave[x].setText(null);
                mat[x].setText(null);
                prof[x].setText(null);
                lun[x].setText(null);
                mar[x].setText(null);
                mie[x].setText(null);
                jue[x].setText(null);
                vie[x].setText(null);
            }
        }
        for(int x = 0; x < agregar.length; x++){
            boolean a = true;
            if (e.getSource() == agregar[x]) {
                for(int y = 0; y < alumno.getNoGrupos(); y++){
                    if(!gpo[y+1].getText().equals(gpo[x+8].getText())){
                        if(!clave[y+1].getText().equals(clave[x+8].getText())){
                            if(!(lun[y+1].getText().equals(lun[x+8].getText())&&
                                mar[y+1].getText().equals(mar[x+8].getText()))){
                                a = true;
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"ESTE GRUPO "
                                        + "GENERA EMPALME CON \nUNO QUE YA TIEN"
                                        + "ES AGREGADO");
                                y = alumno.getNoGrupos();
                                a = false;
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"ESTA MATERIA SE"
                                  + " REPITE CON \nLA DE UN GRUPO YA AGREGADO");
                            y = alumno.getNoGrupos();
                            a = false;
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"YA TIENES ESTE GRUP"
                                + "O AGREGADO");
                        y = alumno.getNoGrupos();
                        a = false;
                    }
                }
                if (a) {
                    JOptionPane.showMessageDialog(null, "GRUPO AGREGADO");
                    int n = alumno.getNoGrupos();
                    grupos[n].setCodigo(gpo[x+8].getText());
                    grupos[n].setClaveMat(clave[x+8].getText());
                    grupos[n].setMateria(mat[x+8].getText());
                    grupos[n].setProfesor(prof[x+8].getText());
                    grupos[n].setLunes(lun[x+8].getText());
                    grupos[n].setMartes(mar[x+8].getText());
                    grupos[n].setMiercoles(mie[x+8].getText());
                    grupos[n].setJueves(jue[x+8].getText());
                    grupos[n].setViernes(vie[x+8].getText());
                    grupos[n].setMasNoAlumnos();
                    if(grupos[n].getNoAlumnos() == grupos[n].getMaxAlumnos()){
                        agregar[n].setEnabled(false);
                    }
                    alumno.setMasNoGrupos();
                    gpo[n+1].setText(grupos[n].getCodigo());
                    clave[n+1].setText(grupos[n].getClaveMat());
                    mat[n+1].setText(grupos[n].getMateria());
                    prof[n+1].setText(grupos[n].getProfesor());
                    lun[n+1].setText(grupos[n].getLunes());
                    mar[n+1].setText(grupos[n].getMartes());
                    mie[n+1].setText(grupos[n].getMiercoles());
                    jue[n+1].setText(grupos[n].getJueves());
                    vie[n+1].setText(grupos[n].getViernes());
                    quitar[n].setEnabled(true);
                    int c = 0;
                    try {
                        declaracion.executeUpdate("INSERT INTO ALUMNOGRUPOS VAL"
                                + "UES ("+alumno.getNoControl()+",'"
                                + gpo[n+1].getText()+"')");
                        declaracion.executeUpdate("UPDATE ALUMNO SET NOGRUPOS ="
                                + " NOGRUPOS + 1 WHERE NOCONTROL = '"
                                + alumno.getNoControl()+"'");
                        declaracion.executeUpdate("UPDATE GRUPO SET NOALUMNOS ="
                                + " NOALUMNOS + 1 WHERE CODIGO = '"
                                + gpo[n+1].getText()+"'");
                        tabla = declaracion.executeQuery("SELECT * FROM (GRUPO "
                                + "LEFT JOIN MATERIA ON MATERIA.CLAVE = GRUPO.C"
                                + "LAVEMAT) LEFT JOIN DIAS ON DIAS.CODIGOGPO = "
                                + "GRUPO.CODIGO WHERE SEMESTRE = "
                        + alumno.getSemestre());
                        while(tabla.next()){
                            if (tabla.getInt("NoAlumnos") == tabla.getInt("MaxA"
                                    + "lumnos")) {
                                agregar[c].setEnabled(false);
                            }
                            c++;
                        }
                    } 
                    catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
        
        for(int x = 1; x < quitar.length+1; x++){
            if(gpo[x].getText().isEmpty()){
                quitar[x-1].setEnabled(false);
            }
            else{
                quitar[x-1].setEnabled(true);
            }
            grupos[x-1].setCodigo(gpo[x].getText());
            grupos[x-1].setClaveMat(clave[x].getText());
            grupos[x-1].setMateria(mat[x].getText());
            grupos[x-1].setProfesor(prof[x].getText());
            grupos[x-1].setLunes(lun[x].getText());
            grupos[x-1].setMartes(mar[x].getText());
            grupos[x-1].setMiercoles(mie[x].getText());
            grupos[x-1].setJueves(jue[x].getText());
            grupos[x-1].setViernes(vie[x].getText());
        }
    }
}