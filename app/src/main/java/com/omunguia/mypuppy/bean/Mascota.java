package com.omunguia.mypuppy.bean;

/**
 * Created by omunguia on 13/05/2016.
 */
public class Mascota {
    private String nombre;
    private int likes;
    private int imgIdRecurso;


    public Mascota(){
    }

    public Mascota(int imgIdRecurso, String nombre, int likes) {
        this.nombre = nombre;
        this.likes = likes;
        this.imgIdRecurso = imgIdRecurso;
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
