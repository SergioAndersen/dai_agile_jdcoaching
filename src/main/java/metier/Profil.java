/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Objects;

/**
 *
 * @author eunicerigo
 */
public class Profil {
    
    private  int codepro ; 
    private String descriptionPro ; 

    public Profil(int codepro, String descriptionPro) {
        this.codepro = codepro;
        this.descriptionPro = descriptionPro;
    }

    public Profil(String descriptionPro) {
        this.descriptionPro = descriptionPro;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
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
        final Profil other = (Profil) obj;
        if (!Objects.equals(this.descriptionPro, other.descriptionPro)) {
            return false;
        }
        return true;
    }

    public int getCodepro() {
        return codepro;
    }

    public String getDescriptionPro() {
        return descriptionPro;
    }

    public void setCodepro(int codepro) {
        this.codepro = codepro;
    }

    public void setDescriptionPro(String descriptionPro) {
        this.descriptionPro = descriptionPro;
    }
    
    
    
    
}
