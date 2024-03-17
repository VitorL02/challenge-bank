package com.vitorlucascrispim.cubochallenge.services;

import com.vitorlucascrispim.cubochallenge.dtos.ParticipationsDTO;
import com.vitorlucascrispim.cubochallenge.entities.Persons;
import com.vitorlucascrispim.cubochallenge.exceptions.ExceptionGenerica;
import com.vitorlucascrispim.cubochallenge.repositories.PersonsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParticipationsService {

    @Autowired
    private PersonsRepository personsRepository;
    public List<ParticipationsDTO> findAllParticipations() {
        List<ParticipationsDTO> listParticipationsDTOS = new ArrayList<>();
        try{
            List<Persons> allPersons = personsRepository.findAll();
            if(allPersons != null && !allPersons.isEmpty()){
                for(Persons person : allPersons){
                    ParticipationsDTO participationsDTO = new ParticipationsDTO();
                    BeanUtils.copyProperties(person,participationsDTO);
                    listParticipationsDTOS.add(participationsDTO);
                }
            }

        }catch (Exception e){
            throw new ExceptionGenerica(new StringBuilder().append("Erro ao buscar todos os participantes: ").append(e).toString());
        }
        return listParticipationsDTOS;
    }

    public void saveParticipation(ParticipationsDTO participationsDTO) {
        try{
            Persons persons = new Persons();
            BeanUtils.copyProperties(participationsDTO,persons);
            personsRepository.save(persons);
        }catch (Exception e){
            throw new ExceptionGenerica(new StringBuilder().append("Erro ao realizar cadastro de participação: ").append(e).toString());
        }

    }
}
