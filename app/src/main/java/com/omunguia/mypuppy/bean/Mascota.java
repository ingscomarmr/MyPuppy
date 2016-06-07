package com.omunguia.mypuppy.bean;

/**
 * Created by omunguia on 13/05/2016.
 */
public class Mascota {

    private int idMascota;
    private String nombre;
    private int likes;
    private int imgIdRecurso;


    public Mascota(){
    }

    public Mascota(int imgIdRecurso, String nombre, int likes, int idMascota) {
        this.nombre = nombre;
        this.likes = likes;
        this.imgIdRecurso = imgIdRecurso;
        this.idMascota = idMascota;
    }

    public int getIdMascota() {
        return this.idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getImgStr() {
        return imgIdRecurso;
    }

    public void setImgStr(int imgStr) {
        this.imgIdRecurso = imgStr;
    }
}
