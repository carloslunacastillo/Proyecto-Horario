/* Sistema para generar un horario de un alumno
 *  - Lista de materias a escoger
 *  - Permitir escoger materia (añadir y quitar)
 *  - Genera el horario (Salida en PDF)
*/
import java.sql.*;
import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) {
        try{
            Connection conexion = DriverManager.getConnection("jdbc:mysql://loc"
                    + "alhost:3306/horario", "root", "");
            Statement declaracion = conexion.createStatement();
            new LogIn(conexion, declaracion);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION");
        }
    }    
}