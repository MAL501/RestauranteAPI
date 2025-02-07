package com.aspi.restauranteapi.controller;

import com.aspi.restauranteapi.dto.ReservaDTO;
import com.aspi.restauranteapi.entity.Reserva;
import com.aspi.restauranteapi.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController

public class ReservaController {
    @Autowired
    private ReservaService reservaService;
    @GetMapping("/reservas")
    public ResponseEntity<List<ReservaDTO>> getAllReservas() {
        List<ReservaDTO> reservas = reservaService.findAll();
        return ResponseEntity.ok(reservas);
    }
    @GetMapping("/reservas/dia")
    public ResponseEntity<List<ReservaDTO>> getAllReservasByDay(@RequestParam LocalDate fecha) {
        List<ReservaDTO> reservas = reservaService.findAllByDate(fecha);
        return ResponseEntity.ok(reservas);
    }
    @PostMapping("/reservas")
    public ResponseEntity<Reserva> saveReserva(@RequestBody Reserva reserva) {
        return reservaService.save(reserva);
    }
    @PutMapping("/reservas/{id}")
    public ResponseEntity<Reserva> updateReserva(@RequestBody Reserva reserva, @PathVariable Long id) {
        return reservaService.edit(id, reserva);
    }
    @DeleteMapping("/reservas/{id}")
    public ResponseEntity<Reserva> deleteReserva(@PathVariable Long id) {
        return reservaService.delete(id);
    }
    @GetMapping("/reservas/{id}")
    public ResponseEntity<ReservaDTO> findById(@PathVariable Long id) {
        ReservaDTO reserva = reservaService.findById(id);
        return ResponseEntity.ok(reserva);
    }
    
}
