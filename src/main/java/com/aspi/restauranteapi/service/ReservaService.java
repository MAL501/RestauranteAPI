package com.aspi.restauranteapi.service;

import com.aspi.restauranteapi.dto.ReservaDTO;
import com.aspi.restauranteapi.entity.Reserva;
import com.aspi.restauranteapi.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    public List<ReservaDTO> findAll() {
        List<ReservaDTO> reservas = reservaRepository.findAllDTO();
        return reservas;
    }

    public List<ReservaDTO> findAllByDate(LocalDate day) {
        List<ReservaDTO> reservas = reservaRepository.findAllDTO(day);
        return reservas;
    }
    public ReservaDTO findById(Long id) {
        ReservaDTO reserva = reservaRepository.findAllDTO(id);
        return reserva;
    }
    public ResponseEntity<Reserva> save(Reserva reserva) {
        Reserva reservaSaved = reservaRepository.save(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaSaved);
    }
    public ResponseEntity<Reserva> edit(Long id, Reserva reserva) {
        Optional<Reserva> reservaOptional = reservaRepository.findById(id);
        if (reservaOptional.isPresent()) {
            reserva.setId(id);
            reservaRepository.save(reserva);
            return ResponseEntity.ok(reserva);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    public ResponseEntity<Reserva> delete(Long id) {
        Optional<Reserva> reservaOptional = reservaRepository.findById(id);
        if (reservaOptional.isPresent()) {
            reservaRepository.deleteById(id);
            return ResponseEntity.ok(reservaOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
