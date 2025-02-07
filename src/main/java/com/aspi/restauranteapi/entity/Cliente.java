package com.aspi.restauranteapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3, message = "El nombre del clienet debe tener al menos 3 caracteres")
    private String name;
    private String phone;
    @Email(message = "El email debe ser de un formato válido")
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    @JsonIgnore
    private List<Reserva> reservas;

    public Cliente() {
    }

    public Cliente(Long id, String name, String phone, String email, List<Reserva> reservas) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.reservas = reservas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
