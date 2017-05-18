public class Grupo {
    private String codigo;
    private String claveMat;
    private String materia;
    private String profesor;
    private int maxAlumnos;
    private int noAlumnos;
    private String lunes;
    private String martes;
    private String miercoles;
    private String jueves;
    private String viernes;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getClaveMat() {
        return claveMat;
    }

    public void setClaveMat(String claveMat) {
        this.claveMat = claveMat;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public int getMaxAlumnos() {
        return maxAlumnos;
    }

    public void setMaxAlumnos(int maxAlumnos) {
        this.maxAlumnos = maxAlumnos;
    }

    public int getNoAlumnos() {
        return noAlumnos;
    }

    public void setNoAlumnos(int noAlumnos) {
        this.noAlumnos = noAlumnos;
    }
    
    public void setMasNoAlumnos(){
        this.noAlumnos++;
    }
    
    public void setMenosNoAlumnos(){
        this.noAlumnos--;
    }

    public String getLunes() {
        return lunes;
    }

    public void setLunes(String lunes) {
        this.lunes = lunes;
    }

    public String getMartes() {
        return martes;
    }

    public void setMartes(String martes) {
        this.martes = martes;
    }

    public String getMiercoles() {
        return miercoles;
    }

    public void setMiercoles(String miercoles) {
        this.miercoles = miercoles;
    }

    public String getJueves() {
        return jueves;
    }

    public void setJueves(String jueves) {
        this.jueves = jueves;
    }

    public String getViernes() {
        return viernes;
    }

    public void setViernes(String viernes) {
        this.viernes = viernes;
    }
}