package com.omunguia.mypuppy.bean;

/**
 * Created by omunguia on 13/05/2016.
 */
public class Mascota {
    private String nombre;
    private int likes;
    private String imgStr;


    public Mascota(){
    }

    public Mascota(String nombre, int likes, String imgStr) {
        this.nombre = nombre;
        this.likes = likes;
        this.imgStr = imgStr;
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

    public String getImgStr() {
        return imgStr;
    }

    public void setImgStr(String imgStr) {
        this.imgStr = imgStr;
    }
}
