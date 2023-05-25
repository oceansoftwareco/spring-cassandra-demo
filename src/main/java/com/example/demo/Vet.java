package com.example.demo;


import java.util.Set;
import java.util.UUID;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;

@Data
@Table
public class Vet {

    @PrimaryKey
    private VetKey key;

    @Column("last_name")
    private String lastName;

    private Set<String> specialties;

    public Vet(VetKey key, String lastName, Set<String> specialties) {
        this.key = key;
        this.lastName = lastName;
        this.specialties = specialties;
    }
}