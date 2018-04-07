/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author eunicerigo
 */
public class Exercice {
    
    private int codeEx ; 
    private String libelleEx ;
    private String descriptionEx ;
    private String image ; 
    private String video ; 
    private String dureeRecup;
    private String dureeEx ;
    private int nbRepetitionEx ;
    private String objectif ; 

    public Exercice(int codeEx, String libelleEx, String descriptionEx, String image, String video, String dureeRecup, String dureeEx, int nbRepetitionEx, String objectif) {
        this.codeEx = codeEx;
        this.libelleEx = libelleEx;
        this.descriptionEx = descriptionEx;
        this.image = image;
        this.video = video;
        this.dureeRecup = dureeRecup;
        this.dureeEx = dureeEx;
        this.nbRepetitionEx = nbRepetitionEx;
        this.objectif = objectif;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Exercice(int codeEx, String libelleEx, String dureeRecup, String dureeEx, int nbRepetitionEx, String video) {
        this.codeEx = codeEx;
        this.libelleEx = libelleEx;
        this.dureeRecup = dureeRecup;
        this.dureeEx = dureeEx;
        this.nbRepetitionEx = nbRepetitionEx;
        this.video = video;
    }
    
    public Exercice(int codeEx, String libelleEx, String dureeRecup, String dureeEx, int nbRepetitionEx) {
        this.codeEx = codeEx;
        this.libelleEx = libelleEx;
        this.dureeRecup = dureeRecup;
        this.dureeEx = dureeEx;
        this.nbRepetitionEx = nbRepetitionEx;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    public Exercice(int codeEx, String libelleEx) {
        this.codeEx = codeEx;
        this.libelleEx = libelleEx;
    }
    
    public Exercice(int codeEx, String libelleEx, String descriptionEx, String video, String dureeRecup, String dureeEx, int nbRepetitionEx, String objectif) {
        this.codeEx = codeEx;
        this.libelleEx = libelleEx;
        this.descriptionEx = descriptionEx;
        this.video = video;
        this.dureeRecup = dureeRecup;
        this.dureeEx = dureeEx;
        this.nbRepetitionEx = nbRepetitionEx;
        this.objectif = objectif;
    }
    
    public Exercice(int codeEx) {
        this.codeEx = codeEx;
    }

    public int getCodeEx() {
        return codeEx;
    }

    public void setCodeEx(int codeEx) {
        this.codeEx = codeEx;
    }

    public String getLibelleEx() {
        return libelleEx;
    }

    public void setLibelleEx(String libelleEx) {
        this.libelleEx = libelleEx;
    }

    public String getDescriptionEx() {
        return descriptionEx;
    }

    public void setDescriptionEx(String descriptionEx) {
        this.descriptionEx = descriptionEx;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getDureeRecup() {
        return dureeRecup;
    }

    public void setDureeRecup(String dureeRecup) {
        this.dureeRecup = dureeRecup;
    }

    public String getDureeEx() {
        return dureeEx;
    }

    public void setDureeEx(String dureeEx) {
        this.dureeEx = dureeEx;
    }

    public int getNbRepetitionEx() {
        return nbRepetitionEx;
    }

    public void setNbRepetitionEx(int nbRepetitionEx) {
        this.nbRepetitionEx = nbRepetitionEx;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

      
}
