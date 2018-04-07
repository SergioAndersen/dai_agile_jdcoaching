/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author FLEXICSSS
 */
public class ProfilSportif {
    
    private int codePs;
    private String taille;
    private String poids;
    private String hanche;
    private String cuisse;
    private String bras;
    private String poitrine;
    private HashMap<Date,Utilisateur> mesurer;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.codePs;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProfilSportif other = (ProfilSportif) obj;
        if (this.codePs != other.codePs) {
            return false;
        }
        return true;
    }

    public ProfilSportif() {
    }
    

    /**
     * 
     * @param codePs
     * @param taille
     * @param hanche
     * @param cuisse
     * @param bras
     * @param poitrine 
     */
    public ProfilSportif(int codePs, String taille, String poids, String hanche, String cuisse, String bras, String poitrine) {
        this.codePs = codePs;
        this.taille = taille;
        this.poids = poids;
        this.hanche = hanche;
        this.cuisse = cuisse;
        this.bras = bras;
        this.poitrine = poitrine;
        this.mesurer = new HashMap();
    }

    

    public ProfilSportif(String taille, String poids, String hanche, String cuisse, String bras, String poitrine) {
        this.taille = taille;
        this.poids = poids;
        this.hanche = hanche;
        this.cuisse = cuisse;
        this.bras = bras;
        this.poitrine = poitrine;
    }
    
    public void setPoids(String poids) {
        this.poids = poids;
    }
    
    public String getPoids() {
        return poids;
    }

    public int getCodePs() {
        return codePs;
    }

    public void setCodePs(int codePs) {
        this.codePs = codePs;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getHanche() {
        return hanche;
    }

    public void setHanche(String hanche) {
        this.hanche = hanche;
    }

    public String getCuisse() {
        return cuisse;
    }

    public void setCuisse(String cuisse) {
        this.cuisse = cuisse;
    }

    public String getBras() {
        return bras;
    }

    public void setBras(String bras) {
        this.bras = bras;
    }

    public String getPoitrine() {
        return poitrine;
    }

    public void setPoitrine(String poitrine) {
        this.poitrine = poitrine;
    }
    
    public HashMap<Date,Utilisateur> getMesurer() {
        return this.mesurer;
    }
    
    public void setMesurer(HashMap<Date,Utilisateur> mesurer) {
        this.mesurer = mesurer;
    }
    
    public void ajouterMesurer(Date d, Utilisateur u) {
        this.mesurer.put(d, u);
    }
    
    public void retirerUtilisateur(Utilisateur u) {
        for(HashMap.Entry<Date,Utilisateur> entry : this.mesurer.entrySet()) {
            if(u.getCodeu()==entry.getValue().getCodeu()) {
                this.mesurer.remove(entry.getKey());
            }
        }
    }
}
