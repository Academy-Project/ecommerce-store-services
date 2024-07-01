package com.example.storeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.storeservice.model.store;
import com.example.storeservice.service.StoreService;

@RestController
@RequestMapping("/store")
public class StoreController {
            @Autowired
            private StoreService storeService;

            @GetMapping
            public List<store> getAllStores() {
                return storeService.getAllStores();
            }

            @GetMapping("/{storeId}")
            public ResponseEntity<store> getStoreById(@PathVariable int storeId) {
                store store = storeService.getStoreById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
                return ResponseEntity.ok(store);
            }

            @PostMapping
            public store addStore(@RequestBody store store) {
                return storeService.addStore(store);
            }

            @PutMapping("/{storeId}")
            public ResponseEntity<store> updateStore(@PathVariable int storeId, @RequestBody store storeDetails) {
                store updatedStore = storeService.updateStore(storeId, storeDetails);
                return ResponseEntity.ok(updatedStore);
            }
            
            @DeleteMapping("/{storeId}")
            public ResponseEntity<Void> deleteStore(@PathVariable int storeId) {
                storeService.deleteStore(storeId);
                return ResponseEntity.noContent().build();
            }

}
