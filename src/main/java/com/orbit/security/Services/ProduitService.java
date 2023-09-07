package com.orbit.security.Services;

import com.orbit.security.Entities.Produit;
import com.orbit.security.Interfaces.IProduitService;
import com.orbit.security.Repositories.CategorieRepository;
import com.orbit.security.Repositories.ProduitRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ProduitService implements IProduitService {
    ProduitRepository produitRepository;

    CategorieRepository categorieRepository;

    @Override
    public Produit ajouterProduit(Produit produit)  {

        return produitRepository.save(produit);
    }

    @Override
    public Produit modifierProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public List<Produit> afficherListeProduit() {
        return produitRepository.findAll();
    }

    @Override
    public void deleteProduit(int id) {produitRepository.deleteById(id);}

    @Override
    public Produit retrieveProduit(int id) {
        return produitRepository.findById(id).orElse(null);
    }

    @Override
    public List<String> getBasicColors(){
        List<String> basicColors=new ArrayList<>();
        basicColors.add("#FF0000");//rouge
        basicColors.add("#00FF00");//vert
        basicColors.add("#0000FF");//bleu
        basicColors.add("#FFFF00");//jaune
        basicColors.add("#FFA500");//orange
        basicColors.add("#800080");//violet
        return basicColors;
    }

    @Override
    public List<Produit> findProductsByName(String name) {
        return null;
    }

    @Override
    public List<Produit> findProductsByDescription(String tags) {
        return null;
    }

    @Override
    public List<Produit> getSimilarProducts(Produit product) {
        return null;
    }

    private List<Produit> productList = new ArrayList<Produit>();
    // Recherche de produits par nom
  /*  public List<Produit> searchProducts(String query) {
        List<Produit> matchingProducts = new ArrayList<Produit>();
        for (Produit product : productList) {
            if (product.getName().toLowerCase().contains(query.toLowerCase())) {
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }*/
    // Récupération de la liste complète des produits
    public List<Produit> getAllProducts() {
        return productList;
    }




}
