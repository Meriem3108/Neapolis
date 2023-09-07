package com.orbit.security.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orbit.security.Entities.Produit;
import com.orbit.security.Interfaces.IProduitService;
import com.orbit.security.Repositories.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Produit")
@PreAuthorize("hasRole('ADMIN')")
@AllArgsConstructor
@Validated
public class ProduitController {
    IProduitService produitService;
    ProduitRepository produitRepository;
    @Autowired
    private ObjectMapper objectMapper;
/*
    @PostMapping(value= "/ajouterProduit", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> ajouterProduit(@RequestParam("file") MultipartFile file, @RequestParam String pp) throws JsonProcessingException {
        Produit p = objectMapper.readValue(pp, Produit.class);
        try {
            p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
            produitService.ajouterProduit(p);
            return ResponseEntity.ok("Image uploaded successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image");
        }
    }
*/
    @PutMapping("/modifierProduit")
    @PreAuthorize("hasAuthority('admin:update')")
    Produit modifierProduit(@RequestBody Produit p) {
        return produitService.modifierProduit(p);
    }

    @GetMapping("/afficherProduits")
    List<Produit> afficherProduit() {
        return produitService.afficherListeProduit();
    }

    @DeleteMapping("/supprimerProduit/{id}")
    void supprimerProduit(@PathVariable int id) {
        produitService.deleteProduit(id);
    }

    @GetMapping("afficherProduit/{id}")
    Produit retriveProduit(@PathVariable int id) {
        return produitService.retrieveProduit(id);
    }




    @GetMapping("/search")
    public List<Produit> searchProducts(@RequestParam("q") String query) {
        return produitService.findProductsByName(query);
    }

    //récupérer les produits pertinents après une recherche et recommander des produits
// similaires basés sur les descriptions associés à ces produits.
    @GetMapping("/searchByDescription")
    public List<Produit> rechercheProducts(@RequestParam("q") String query) {
        List<Produit> relevantProducts = produitService.findProductsByDescription(query);
        List<Produit> recommendedProducts = new ArrayList<>();
        for (Produit product : relevantProducts) {
            List<Produit> similarProducts = findSimilarProducts(product);
            recommendedProducts.addAll(similarProducts);
        }
        return recommendedProducts;
    }

    private List<Produit> findSimilarProducts(Produit product) {
        List<Produit> allProducts = produitService.afficherListeProduit();
        List<Produit> similarProducts = new ArrayList<>();

        for (Produit p : allProducts) {
            if (p != product && p.getDescription().equals(product.getDescription())) {
                similarProducts.add(p);
            }
        }
        return similarProducts;
    }


}
