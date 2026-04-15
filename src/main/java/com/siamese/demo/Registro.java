
package com.siamese.demo;


import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Data;


@Data
public class Registro {
    private int idRegistro;
    private String nombre;
    private String raza;
    private int edad;
    private String descripcion;
    
 
    
     public Registro(int idProducto, String detalle, int cantidad) {
        this.idRegistro = idRegistro;
        this.nombre = nombre;
        this.edad = edad;
        this.descripcion = descripcion;
        this.raza = raza;
    }
     public int getIdRegistro(){
         return idRegistro;
     }

   public void setIdRegistro(int idRegistro){
       this.idRegistro = idRegistro;
   }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
     public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    private Date getDateFormat(String formatPattern, String date) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(formatPattern);
            return formatter.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
