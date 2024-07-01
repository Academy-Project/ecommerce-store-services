package com.example.storeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storeservice.model.store;

public interface StoreRepository extends JpaRepository<store, Integer> {
}
