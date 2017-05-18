import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;
import java.util.Calendar;

public class GenerarPDF {
    private Calendar c = Calendar.getInstance();
    private FileOutputStream archivo;
    private Document doc;
    private Alumno alumno;
    private Grupo[] grupos;
    
    public GenerarPDF(Alumno a, Grupo[] g){
        alumno = a;
        grupos = g;
        int dia = c.get(Calendar.DATE);
        int mes = c.get(Calendar.MONTH);
        int año = c.get(Calendar.YEAR);
        File directorio = new File("C:/Horario");
        if(!directorio.exists()){
            directorio.mkdir();
        }
        
        try {
            archivo = new FileOutputStream("C:/Horario/"+alumno.getNoControl()
                    + "horario.PDF");
            doc = new Document(PageSize.A1);
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            Font t = new Font();
            t.setSize(30);
            t.setFamily(FontFamily.COURIER.toString());
            t.setStyle(Font.BOLD);
            Font font1 = new Font();
            font1.setSize(15);
            font1.setFamily(FontFamily.COURIER.toString());
            Font font2 = new Font();
            font2.setSize(20);
            font2.setFamily(FontFamily.COURIER.toString());
            font2.setStyle(Font.BOLD);
            
            Paragraph titulo = new Paragraph("INSTITUTO TECNOLOGICO DE LEON",t);
            titulo.setAlignment(Paragraph.ALIGN_CENTER);
            Paragraph sub = new Paragraph("DEPARTAMENTO DE SERVICIOS ESCOLARES"
                    , font2);
            sub.setAlignment(Paragraph.ALIGN_CENTER);
            Paragraph st = new Paragraph("H O R A R I O  D E L  A L U M N O"
                    , font1);
            st.setAlignment(Paragraph.ALIGN_CENTER);
            Paragraph vacio = new Paragraph("  ",t);
            Paragraph noControl = new Paragraph("NO CONTROL: "
                    + alumno.getNoControl(), font2);
            Paragraph nombre = new Paragraph("ALUMNO: "
                    + alumno.getNombre(), font2);
            Paragraph carrera = new Paragraph("CARRERA: INGENIERIA EN SISTEMAS "
                    + "COMPUTACIONALES                   SEMESTRE: "
                    + alumno.getSemestre()+"                   FECHA: "
                    + dia+"/"+mes+"/"+año, font2);
            Paragraph marco = new Paragraph("+-----+-----+---------------------"
                    + "-------------------+------------------------------------"
                    + "----+--------------+--------------+--------------+------"
                    + "--------+--------------+", font1);
            Paragraph tabla = new Paragraph("|GPO. |MAT. |MATERIA              "
                    + "                   |PROFESOR (A)                        "
                    + "    |LUNES         |MARTES        |MIERCOLES     |JUEVES"
                    + "        |VIERNES       |", font1);
            doc.add(titulo);
            doc.add(sub);
            doc.add(st);
            doc.add(vacio);
            doc.add(noControl);
            doc.add(nombre);
            doc.add(carrera);
            doc.add(marco);
            doc.add(tabla);
            doc.add(marco);
            for(int z = 0; z < alumno.getNoGrupos(); z++){
                String materia = grupos[z].getMateria();
                String profe = grupos[z].getProfesor();
                String v = "              |";
                String lun;
                String mar;
                String mie;
                String jue;
                String vie;
                char l = grupos[z].getCodigo().charAt(0);
                char r = grupos[z].getCodigo().charAt(1);
                if (l == 'M') {
                    lun = v;
                    mar = grupos[z].getMartes() + " |";
                    mie = v;
                    jue = grupos[z].getJueves() + " |";
                } 
                else {
                    lun = grupos[z].getLunes() + " |";
                    mar = v;
                    mie = grupos[z].getMiercoles() + " |";
                    jue = v;
                }
                if (r == 'X') {
                    vie = v;
                } 
                else {
                    vie = grupos[z].getViernes() + " |";
                }
                int x = 40 - materia.length();
                for (int y = 0; y < x; y++) {
                    materia += " ";
                }
                x = 40 - profe.length();
                for (int y = 0; y < x; y++) {
                    profe += " ";
                }
                Paragraph mat = new Paragraph("|"+grupos[z].getCodigo()+" |"
                        + grupos[z].getClaveMat()+" |"+materia +"|"+ profe+"|" 
                        + lun+mar+mie+jue+vie, font1);
                doc.add(mat);
                doc.add(marco);
            }
            doc.close();
        } 
        catch (FileNotFoundException | DocumentException ex) {}
    }
}