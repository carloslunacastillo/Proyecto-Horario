public class Alumno {
    private int noControl;
    private int password;
    private String nombre;
    private int semestre;
    private int noGrupos;

    public int getNoControl() {
        return noControl;
    }

    public void setNoControl(int noControl) {
        this.noControl = noControl;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getNoGrupos() {
        return noGrupos;
    }

    public void setNoGrupos(int noGrupos) {
        this.noGrupos = noGrupos;
    }
    
    public void setMasNoGrupos(){
        this.noGrupos++;
    }
    
    public void setMenossNoGrupos(){
        this.noGrupos--;
    }
}