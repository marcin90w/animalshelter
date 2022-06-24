package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class AnimalRepository {

    private Set<AnimalService> animals;

    public AnimalRepository() {
        animals = new HashSet<>();
        animals.add(new AnimalService("Azor", "dog", "Piesek porzucony 3 lata temu przez właścicieli", "/dog.jpg"));
        animals.add(new AnimalService("Rudy", "cat", "Kotek porzucony 3 lata temu przez właścicieli", "/cat.jpg"));
    }

    public AnimalService findByName(String name) {
        for (AnimalService animal : animals) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }

    public Set<AnimalService> findAll() {
        return animals;
    }
}
