package com.crud.demo.entidad;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.data.annotation.Id;

@Entity
@Table(name= "evento")
@Transactional
public class Evento {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "imagePath")
    private String imagePath;

    public Evento() {
    }

    public Evento(Long id, String titulo, String descripcion, String imagePath) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagePath = imagePath;
    }

    public Evento(String titulo, String descripcion, String imagePath) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagePath = imagePath;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath){
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", Path de la imagen='" + imagePath + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
