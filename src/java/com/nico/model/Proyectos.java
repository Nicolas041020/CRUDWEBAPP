/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nico.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author nicoc
 */
@Entity
@Table
@NamedQueries(@NamedQuery(name="Proyectos.getAll",query="SELECT e FROM Proyectos e"))
public class Proyectos implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    private int proyectoId;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private String localidad;
    @Column
    private String presupuesto;
    @Column
    private int n_habitantes;

    public Proyectos(int proyectoId, String nombre, String descripcion, String localidad, String presupuesto, int n_habitantes) {
        this.proyectoId = proyectoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.localidad = localidad;
        this.presupuesto = presupuesto;
        this.n_habitantes = n_habitantes;
    }

    
    
    public Proyectos(){}

    public int getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(int proyectoId) {
        this.proyectoId = proyectoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(String presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getN_habitantes() {
        return n_habitantes;
    }

    public void setN_habitantes(int n_habitantes) {
        this.n_habitantes = n_habitantes;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    
    
    
    
}
