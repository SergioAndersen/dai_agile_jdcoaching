/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Sergio
 */
public class TypeS {
    
    private int codeTS;
    private String libelleTS;
    private ArrayList<Seance> listeSeance;

    public TypeS(int codeTS, String libelleTS) {
        this.codeTS = codeTS;
        this.libelleTS = libelleTS;
        this.listeSeance = new ArrayList();
    }
    
    public TypeS(int codeTS) {
        this.codeTS = codeTS;
        this.listeSeance = new ArrayList();
    }
    
    public TypeS(String libelleTS) {
        this.libelleTS = libelleTS;
        this.listeSeance = new ArrayList();
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
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
        final TypeS other = (TypeS) obj;
        if (!Objects.equals(this.libelleTS, other.libelleTS)) {
            return false;
        }
        return true;
    }

    public int getCodeTS() {
        return codeTS;
    }

    public void setCodeTS(int codeTS) {
        this.codeTS = codeTS;
    }

    public String getLibelleTS() {
        return libelleTS;
    }

    public void setLibelleTS(String libelleTS) {
        this.libelleTS = libelleTS;
    }

    public ArrayList<Seance> getListeSeance() {
        return listeSeance;
    }

    public void setListeSeance(ArrayList<Seance> listeSeance) {
        this.listeSeance = listeSeance;
    }
    
    public void ajoutSeance(Seance s) {
        this.listeSeance.add(s);
    }
    
    public void retirerSeance(Seance s) {
        this.listeSeance.remove(s);
    }
}
