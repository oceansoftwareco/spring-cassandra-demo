package com.example.demo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VetRepository extends CassandraRepository<Vet, VetKey> {
    List<Vet> findByKeyFirstName(String firstName);

    List<Vet> findByKeyFirstNameAndLastName(String firstName, String lastName);
}