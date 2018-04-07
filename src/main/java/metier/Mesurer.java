/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author FLEXICSSS
 */
public class Mesurer {
    private Utilisateur utilisateur;
    private ProfilSportif profilSportif;
    private Date dateps;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.utilisateur);
        hash = 37 * hash + Objects.hashCode(this.profilSportif);
        hash = 37 * hash + Objects.hashCode(this.dateps);
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
        final Mesurer other = (Mesurer) obj;
        if (!Objects.equals(this.utilisateur, other.utilisateur)) {
            return false;
        }
        if (!Objects.equals(this.profilSportif, other.profilSportif)) {
            return false;
        }
        if (!Objects.equals(this.dateps, other.dateps)) {
            return false;
        }
        return true;
    }
    

    public Mesurer() {
    }

    public Mesurer(Utilisateur utilisateur, ProfilSportif profilSportif, Date dateps) {
        this.utilisateur = utilisateur;
        this.profilSportif = profilSportif;
        this.dateps = dateps;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public ProfilSportif getProfilSportif() {
        return profilSportif;
    }

    public void setProfilSportif(ProfilSportif profilSportif) {
        this.profilSportif = profilSportif;
    }

    public Date getDateps() {
        return dateps;
    }

    public void setDateps(Date dateps) {
        this.dateps = dateps;
    }
 
   
}
