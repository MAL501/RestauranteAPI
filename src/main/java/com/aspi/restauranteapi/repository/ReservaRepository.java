package com.aspi.restauranteapi.repository;

import com.aspi.restauranteapi.dto.ReservaDTO;
import com.aspi.restauranteapi.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    @Query("SELECT new com.aspi.restauranteapi.dto.ReservaDTO(r.cliente.name,r.cliente.email,r.bookingDate,r.mesa.number)"+
            "FROM Reserva r")
    List<ReservaDTO> findAllDTO();
    @Query("SELECT new com.aspi.restauranteapi.dto.ReservaDTO(r.cliente.name,r.cliente.email,r.bookingDate,r.mesa.number)"+
            "FROM Reserva r WHERE r.bookingDate = :day")
    List<ReservaDTO> findAllDTO(LocalDate day);
    @Query("SELECT new com.aspi.restauranteapi.dto.ReservaDTO(r.cliente.name,r.cliente.email,r.bookingDate,r.mesa.number)"+
            "FROM Reserva r WHERE r.id = :id")
    ReservaDTO findAllDTO(Long id);
}
