/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Date;

/**
 *
 * @author 21101690
 */
public class Utilisateur {
    private int codeu;
    private String nomu;
    private String prenomu;
    private String mailu;
    private String mdpu;
    private String genreu;
    private Date datenaissanceu;
    private String telu;
    private String infooptionnelle;
    private String typeu;
    private Date dateinscri;
    private Date datevalid;

    /**
     * Constructeur avec tout les éléments de l'utilisateur
     * @param codeu
     * @param nomu
     * @param prenomu
     * @param mailu
     * @param mdpu
     * @param genreu
     * @param datenaissanceu
     * @param telu
     * @param infooptionnelle
     * @param typeu
     * @param dateinscri
     * @param datevalid 
     */
    public Utilisateur(int codeu, String nomu, String prenomu, String mailu, String mdpu, String genreu, Date datenaissanceu, String telu, String infooptionnelle, String typeu, Date dateinscri, Date datevalid) {
        this.codeu = codeu;
        this.nomu = nomu;
        this.prenomu = prenomu;
        this.mailu = mailu;
        this.mdpu = mdpu;
        this.genreu = genreu;
        this.datenaissanceu = datenaissanceu;
        this.telu = telu;
        this.infooptionnelle = infooptionnelle;
        this.typeu = typeu;
        this.dateinscri = dateinscri;
        this.datevalid = datevalid;
    }

    public Utilisateur(int codeu, String nomu, String prenomu, String mailu, String mdpu, String genreu, String telu) {
        this.codeu = codeu;
        this.nomu = nomu;
        this.prenomu = prenomu;
        this.mailu = mailu;
        this.mdpu = mdpu;
        this.genreu = genreu;
        this.telu = telu;
    }

    public Utilisateur(String nomu, String prenomu) {
        this.nomu = nomu;
        this.prenomu = prenomu;
    }
    
    

    public int getCodeu() {
        return codeu;
    }

    public void setCodeu(int codeu) {
        this.codeu = codeu;
    }

    public String getNomu() {
        return nomu;
    }

    public void setNomu(String nomu) {
        this.nomu = nomu;
    }

    public String getPrenomu() {
        return prenomu;
    }

    public void setPrenomu(String prenomu) {
        this.prenomu = prenomu;
    }

    public String getMailu() {
        return mailu;
    }

    public void setMailu(String mailu) {
        this.mailu = mailu;
    }

    public String getMdpu() {
        return mdpu;
    }

    public void setMdpu(String mdpu) {
        this.mdpu = mdpu;
    }

    public String getGenreu() {
        return genreu;
    }

    public void setGenreu(String genreu) {
        this.genreu = genreu;
    }

    public Date getDatenaissanceu() {
        return datenaissanceu;
    }

    public void setDatenaissanceu(Date datenaissanceu) {
        this.datenaissanceu = datenaissanceu;
    }

    public String getTelu() {
        return telu;
    }

    public void setTelu(String telu) {
        this.telu = telu;
    }

    public String getInfooptionnelle() {
        return infooptionnelle;
    }

    public void setInfooptionnelle(String infooptionnelle) {
        this.infooptionnelle = infooptionnelle;
    }

    public String getTypeu() {
        return typeu;
    }

    public void setTypeu(String typeu) {
        this.typeu = typeu;
    }

    public Date getDateinscri() {
        return dateinscri;
    }

    public void setDateinscri(Date dateinscri) {
        this.dateinscri = dateinscri;
    }

    public Date getDatevalid() {
        return datevalid;
    }

    public void setDatevalid(Date datevalid) {
        this.datevalid = datevalid;
    }
    
    
    
}
