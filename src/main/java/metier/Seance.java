/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.HashMap;

/**
 *
 * @author Sergio
 */
public class Seance {
    
    private int codeST;
    private String libelleST;
    private String descriptionST;
    private TypeS typeST;
    private HashMap<Integer,Exercice> mapExo;
    private int nbrepet ;
    private Programme pro ;

    public Seance(int codeST, String libelleST, String descriptionST, TypeS typeST) {
        this.codeST = codeST;
        this.libelleST = libelleST;
        this.descriptionST = descriptionST;
        this.typeST = typeST;
        this.mapExo = new HashMap();
    }
    
    public Seance(String libelleST, String descriptionST, TypeS typeST) {
        this.libelleST = libelleST;
        this.descriptionST = descriptionST;
        this.typeST = typeST;
        this.mapExo = new HashMap();
    }
    
    public Seance(String libelleST, String descriptionST) {
        this.libelleST = libelleST;
        this.descriptionST = descriptionST;
        this.mapExo = new HashMap();
    }
     public Seance(String libelleST, String descriptionST, TypeS typeST, int nbrepet) {
        this.libelleST = libelleST;
        this.descriptionST = descriptionST;
        this.typeST = typeST;
        this.mapExo = new HashMap();
        this.nbrepet =nbrepet ;
    }
    public Seance(int codeST) {
        this.codeST = codeST;
        this.mapExo = new HashMap();
    }
    
     public Seance(int codeST, String libelleST, String descriptionST, TypeS typeST, int nbrepet, Programme pro) {
        this.codeST = codeST;
        this.libelleST = libelleST;
        this.descriptionST = descriptionST;
        this.typeST = typeST;
        this.nbrepet = nbrepet;
        this.pro = pro;
    }
    
    public int getCodeST() {
        return codeST;
    }
    
     public int getNbrepet() {
        return nbrepet;
    }

    public Programme getPro() {
        return pro;
    }

    public void setCodeST(int codeST) {
        this.codeST = codeST;
    }

    public String getLibelleST() {
        return libelleST;
    }

    public void setLibelleST(String libelleST) {
        this.libelleST = libelleST;
    }

    public String getDescriptionST() {
        return descriptionST;
    }

    public void setDescriptionST(String descriptionST) {
        this.descriptionST = descriptionST;
    }

    public TypeS getTypeST() {
        return typeST;
    }

    public void setTypeST(TypeS typeST) {
        this.typeST = typeST;
    }

    public HashMap<Integer,Exercice> getMapExo() {
        return mapExo;
    }

    public void setMapExo(HashMap<Integer,Exercice> mapExo) {
        this.mapExo = mapExo;
    }
    
    public void ajouterExo(Exercice ex) {
        int i = this.mapExo.size()+1;
        this.mapExo.put(i, ex);
        
    }
    
}
