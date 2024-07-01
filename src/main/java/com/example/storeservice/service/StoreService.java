package com.example.storeservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.storeservice.model.store;
import com.example.storeservice.repository.StoreRepository;

@Service
public class StoreService {
        @Autowired
        private StoreRepository storeRepository;

        public List<store> getAllStores() {
            return storeRepository.findAll();
        }

        public Optional<store> getStoreById(int id) {
            return storeRepository.findById(id);
        }
    
        public store addStore(store store) {
            return storeRepository.save(store);
        }
    
        public store updateStore(int id, store storeDetails) {
            store store = storeRepository.findById(id).orElseThrow(() -> new RuntimeException("Store not found"));
            store.setName(storeDetails.getName());
            store.setLocation(storeDetails.getLocation());
            store.setOwner(storeDetails.getOwner());
            return storeRepository.save(store);
        }
    
        public void deleteStore(int id) {
            store store = storeRepository.findById(id).orElseThrow(() -> new RuntimeException("Store not found"));
            storeRepository.delete(store);
        }
}
