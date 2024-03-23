package com.bringover.Boutique.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bringover.Boutique.modele.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    
}