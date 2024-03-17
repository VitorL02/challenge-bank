package com.vitorlucascrispim.cubochallenge;

import com.vitorlucascrispim.cubochallenge.entities.Persons;
import com.vitorlucascrispim.cubochallenge.repositories.PersonsRepository;
import com.vitorlucascrispim.cubochallenge.services.ParticipationsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ParticipationsTest {

    @InjectMocks
    private ParticipationsService participationsService;

    @Mock
    private PersonsRepository personsRepository;


    @Test
    public void testGetAllParticipations(){
        var primeiraParticipacao = new Persons(1l,"VITOR","LUCAS",new BigDecimal(0.80));
        var segundaParticipacao = new Persons(2l,"MATEUS","LUCAS",new BigDecimal(0.75));
        var mockTransaction = List.of(primeiraParticipacao,segundaParticipacao);
        when(personsRepository.findAll()).thenReturn(mockTransaction);
        var allParticipations = participationsService.findAllParticipations();
        assertEquals(2,allParticipations.size());
    }

}
