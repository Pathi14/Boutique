package com.bringover.Boutique.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bringover.Boutique.modele.Produit;
import com.bringover.Boutique.repository.ProduitRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProduitServiceImplement implements ProduitService{

    private final ProduitRepository produitRepository;

    @Override
    public Produit creer(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public List<Produit> lire() {
        return produitRepository.findAll();
    }

    @Override
    public Produit modifier(Long id, Produit produit) {
        return produitRepository.findById(id)
            .map(p->{
                p.setPrix(produit.getPrix());
                p.setNom(produit.getNom());
                p.setDescription(produit.getDescription());
                return produitRepository.save(p);
            }).orElseThrow(()->new RuntimeException("Produit non trouvé !"));
    }

    @Override
    public String supprimer(Long id) {
        produitRepository.deleteById(id);
        return "Produit supprimé !";
    }
    
}
