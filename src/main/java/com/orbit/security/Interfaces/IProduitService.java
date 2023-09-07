package com.orbit.security.Interfaces;

import com.orbit.security.Entities.Produit;

import java.util.List;

public interface IProduitService {
    public Produit ajouterProduit(Produit produit);
    public Produit modifierProduit(Produit produit);
    public List<Produit> afficherListeProduit();
    public void deleteProduit(int id);
    public Produit retrieveProduit(int id);
    public List<String> getBasicColors();
    public List<Produit> findProductsByName(String name);
    public List<Produit> findProductsByDescription(String tags);
    public List<Produit> getSimilarProducts(Produit product);

}
