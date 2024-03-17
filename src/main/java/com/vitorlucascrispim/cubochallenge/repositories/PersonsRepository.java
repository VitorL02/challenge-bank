package com.vitorlucascrispim.cubochallenge.repositories;

import com.vitorlucascrispim.cubochallenge.entities.Persons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonsRepository extends JpaRepository<Persons,Long> {
}
