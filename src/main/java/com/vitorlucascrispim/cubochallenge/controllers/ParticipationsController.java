package com.vitorlucascrispim.cubochallenge.controllers;

import com.vitorlucascrispim.cubochallenge.dtos.ParticipationsDTO;
import com.vitorlucascrispim.cubochallenge.services.ParticipationsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/participations")
public class ParticipationsController {

    @Autowired
    private ParticipationsService participationsService;

    @GetMapping
    public ResponseEntity<List<ParticipationsDTO>> findAllParticipations(){
        List<ParticipationsDTO> allParticipations = new ArrayList<>();
        try{
            allParticipations =  participationsService.findAllParticipations();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(allParticipations);
    }
    @PostMapping
    public ResponseEntity saveParticipation(@Valid  @RequestBody ParticipationsDTO participationsDTO){
        try{
            participationsService.saveParticipation(participationsDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar participante, tente novamente mais tarde!");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Participante salvo com sucesso!");
    }
}
