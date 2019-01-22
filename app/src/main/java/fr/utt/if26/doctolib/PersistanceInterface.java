package fr.utt.if26.doctolib;

import java.util.ArrayList;



public interface PersistanceInterface<T>{

    // ajoute dans la base
    public void add( T entity );

    // mise à jour  dans la base
    public void update(T entity);

    // recherche dans la base via la clé primaire
    public T get(int key);

    // recherche dans la base
    public T get(String email, String mdp,String profil);
    // supprime dans la base
    public void delete(T entity );

    // retourne le nombre de module
    public int count();

    // retourne l'ensemble des utilisateurs  de la base
    public ArrayList<T> getAll();

    public void initData();

}




