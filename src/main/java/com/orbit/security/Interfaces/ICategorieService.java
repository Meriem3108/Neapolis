package com.orbit.security.Interfaces;

import com.orbit.security.Entities.Categorie;

import java.util.List;

public interface ICategorieService {
    public Categorie ajouterCategorie(Categorie categorie);
    public Categorie modifierCategorie(Categorie categorie);
    public List<Categorie> afficherListeCategories();
    public void deleteCategorie(int id);
    public Categorie retrieveCategorie(int id);
    //public void recursiveTree(Categorie categorie);
  //  public void addCategoryWithSubCategories(Categorie category);
}
