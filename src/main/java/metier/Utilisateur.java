/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
    private String datenaissanceu;
    private String telu;
    private String infooptionnelle;
    private String typeu;
    private Date dateinscri;
    private Date datevalid;
    private String statutu;
    private HashMap<Date, ProfilSportif> mesurer;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.codeu;
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
        final Utilisateur other = (Utilisateur) obj;
        if (this.codeu != other.codeu) {
            return false;
        }
        return true;
    }
    

    /**
     * Constructeur d'un utilisateur pour l'inscription de base
     * UTILISER PAR SERVLETINSCRIPTIONUTILISATION
     * UTILISER PAR CONSULTER UTILISATEUR
     * 
     * @param nomu le nom de l'utilisateur
     * @param prenomu le prenom de l'utilisateur
     * @param mailu l'email de l'utilisateur
     * @param mdpu le mot de passe de 'lutilisateur
     * @param genreu le genre de l'utilisateur
     * @param datenaissanceu la date de naissance de l'utilisateur
     * @param telu le numéro de télaphone du client
     * @param typeu le type de l'utilisateur
     * @param dateinscri la date à laquele l'utilisateur s'est inscrit
     * @param statutu le statut de l'utilisateur
     */
    public Utilisateur(String nomu, String prenomu, String mailu, String mdpu,
            String genreu, String datenaissanceu, String telu, String typeu,
            Date dateinscri, String statutu) {
        this.nomu = nomu;
        this.prenomu = prenomu;
        this.mailu = mailu;
        this.mdpu = mdpu;
        this.genreu = genreu;
        this.datenaissanceu = datenaissanceu;
        this.telu = telu;
        this.typeu = typeu;
        this.dateinscri = dateinscri;
        this.statutu = statutu;
    }

    /**
     * Constructeur pour l'utilisateur récupérer dans la liste
     * UTILISER PAR OBTENIR UTILISATEUR
     * 
     * @param nomu le nom d el'utilisateur
     * @param prenomu le prenom de l'utilisateur
     * @param statutu le statut de l'utilisateur
     * @param dateinscri la date à laquele le client s'est inscrit
     */
    public Utilisateur(String nomu, String prenomu, String statutu,
            Date dateinscri) {
        this.nomu = nomu;
        this.prenomu = prenomu;
        this.statutu = statutu;
        this.dateinscri = dateinscri;
    }
    
    /**
     * Constructeur pour l'utilisateur récupérer det envoyé dans un formulaire
     * UTILISER PAR OBTENIRCLIENTSELONSTATUT
     * 
     * @param nomu le nom d el'utilisateur
     * @param prenomu le prenom de l'utilisateur
     * @param statutu le statut de l'utilisateur
     * @param dateinscri la date à laquele le client s'est inscrit
     * @param mailu l'email de l'utilisateur
     */
    public Utilisateur(String nomu, String prenomu, String statutu,
            Date dateinscri, String mailu) {
        this.codeu = codeu;
        this.nomu = nomu;
        this.prenomu = prenomu;
        this.statutu = statutu;
        this.dateinscri = dateinscri;
        this.mailu = mailu;
    }

    /**
     * 
     * UTILISER PAR USERCONNECT
     * 
     * @param nomu
     * @param prenomu
     * @param mailu
     * @param genreu
     * @param mdpu
     * @param datenaissanceu
     * @param telu
     * @param typeu
     */
    public Utilisateur(String nomu, String prenomu, String mailu,  String genreu,String mdpu, String datenaissanceu, String telu, String typeu) {
        this.nomu = nomu;
        this.prenomu = prenomu;
        this.mailu = mailu;
        this.mdpu = mdpu;
        this.genreu = genreu;
        this.datenaissanceu = datenaissanceu;
        this.telu = telu;
        this.typeu = typeu;
    }

    /**
     * 
     * UTILISER PAR USERINFO
     * 
     * @param nomu
     * @param prenomu
     * @param mailu
     * @param genreu
     * @param datenaissanceu
     * @param telu
     * @param statutu 
     */        
    public Utilisateur(String nomu, String prenomu, String mailu, String genreu, String datenaissanceu, String telu, String statutu) {
        this.nomu = nomu;
        this.prenomu = prenomu;
        this.mailu = mailu;
        this.genreu = genreu;
        this.datenaissanceu = datenaissanceu;
        this.telu = telu;
        this.statutu = statutu;
    }
    
    
    
    /**
     * Méthode permettant de récupérer le code de l'utilisateur
     *
     * @return le code de l'utilisateur
     */
    public int getCodeu() {
        return codeu;
    }

    /**
     * Méthode permettant de récupérer le nom de l'utilisateur
     *
     * @return le nom de l'utilisateur
     */
    public String getNomu() {
        return nomu;
    }

    /**
     * Procédure permettant de modifier le nom de l'utilisateur
     *
     * @param nomu le nouveau nom de l'utilisateur
     */
    public void setNomu(String nomu) {
        this.nomu = nomu;
    }

    /**
     * Méthode permettant de récupérer le prénom de l'utilisateur
     *
     * @return le prénom d l'utilisateur
     */
    public String getPrenomu() {
        return prenomu;
    }

    /**
     * Procédure permettant de modifier le prénom de l'utilisateur
     *
     * @param prenomu le nouveau prénom de l'utilisateur
     */
    public void setPrenomu(String prenomu) {
        this.prenomu = prenomu;
    }

    /**
     * Méthode permettant de récupérer l'email de l'utilisateur
     *
     * @return l'email de l'utilisateur
     */
    public String getMailu() {
        return mailu;
    }

    /**
     * Procédure permettant de modifier l'email de l'utilisateur
     *
     * @param mailu le nouvel email de l'utilisateur
     */
    public void setMailu(String mailu) {
        this.mailu = mailu;
    }

    /**
     * Méthode permettant de récupérer le mot de passe de l'utilisateur
     *
     * @return le mot de passe de l'utilisateur
     */
    public String getMdpu() {
        return mdpu;
    }

    /**
     * Procédure permettant de modifier le mot de passe d'un utilisateur
     *
     * @param mdpu le mot de passe de l'utilisateur
     */
    public void setMdpu(String mdpu) {
        this.mdpu = mdpu;
    }

    /**
     * Méthode permettant de récupérer le genre de l'utilisateur
     *
     * @return le genre de l'utilisateur
     */
    public String getGenreu() {
        return genreu;
    }

    /**
     * Procédure permettant de modifier le genre de l'utilisateur
     *
     * @param genreu le nouveau genre de l'utilisateur
     */
    public void setGenreu(String genreu) {
        this.genreu = genreu;
    }

    /**
     * Méthode permettant de récupérer la date de naissance de l'utilisateur
     *
     * @return la date de naissance de l'utilisateur
     */
    public String getDatenaissanceu() {
        return datenaissanceu;
    }

    /**
     * Procédure peremattant de modifier la date de naissance de l'utilisateur
     *
     * @param datenaissanceu la nouvelle date de naissance de l'utilisateur
     */
    public void setDatenaissanceu(String datenaissanceu) {
        this.datenaissanceu = datenaissanceu;
    }

    /**
     * Procédure permettant de récupérer le numéro de téléphone de l'utilisateur
     *
     * @return le numéro de téléphone de l'utilisateur
     */
    public String getTelu() {
        return telu;
    }

    /**
     * Procédure permettant de modifier le numéro de téléphone de l'utilisateur
     *
     * @param telu le nouveau numéro de téléphone de l'utilisateur
     */
    public void setTelu(String telu) {
        this.telu = telu;
    }

    /**
     * Méthode permettant de récupérer le sinformations optionnelles de
     * l'utilisateur
     *
     * @return les informations optionnelles de l'utilisateur
     */
    public String getInfooptionnelle() {
        return infooptionnelle;
    }

    /**
     * Procédure permettant de modifier les informations optionnelles de
     * l'utilisateur
     *
     * @param infooptionnelle les nouvelles informations optionnelles de
     * l'utilisateur
     */
    public void setInfooptionnelle(String infooptionnelle) {
        this.infooptionnelle = infooptionnelle;
    }

    /**
     * Méthode permettat de récupérer le type de l'utilisateur
     *
     * @return le type de l'utilisateur (Client, Coach, Admin)
     */
    public String getTypeu() {
        return typeu;
    }

    /**
     * Méthode permettant de récupérer la date d'inscription de l'utilisateur
     *
     * @return la date d'inscription de l'utilisateur
     */
    public Date getDateinscri() {
        return dateinscri;
    }

    /**
     * Procédure permettant de modifier la date d'inscrption de l'utilisateur
     *
     * @param dateinscri la nouvelle date d'inscription de l'utilisateur
     */
    public void setDateinscri(Date dateinscri) {
        this.dateinscri = dateinscri;
    }

    /**
     * Méthode permettant de récupérer la date de validation de l'inscription
     * d'un utilisateur
     *
     * @return la date de validation de l'inscription
     */
    public Date getDatevalid() {
        return datevalid;
    }

    /**
     * Procédure permettant de modifier la date de validation de l'inscription
     * d'un utilisateur
     *
     * @param datevalid la nouvelle date de validation de l'inscription d'un
     * utilisateur
     */
    public void setDatevalid(Date datevalid) {
        this.datevalid = datevalid;
    }

    /**
     * Méthode permettant de récupérer le statut d'un utilisateur
     *
     * @return le statut d'un utilisateur (Potentiel, En Attente, Abonné Actif,
     * Abonné Inactif, Ancien Abonné)
     */
    public String getStatutu() {
        return statutu;
    }

    /**
     * Procédure permettant de modifier le statut d'un utilisateur
     *
     * @param statutu le nouveau statut d'un utilisateur
     */
    public void setStatutu(String statutu) {
        this.statutu = statutu;
    }

    public HashMap<Date,ProfilSportif> getMesurer() {
        return mesurer;
    }

    public void setMesurer(HashMap<Date,ProfilSportif> mesurer) {
        this.mesurer = mesurer;
    }
    
    public void ajouterMesure(Date d, ProfilSportif ps) {
        this.mesurer.put(d, ps);
    }
    
    public void retirerProfilSportif(ProfilSportif ps) {
        for(HashMap.Entry<Date,ProfilSportif> entry : this.mesurer.entrySet()) {
            if(ps.getCodePs()==entry.getValue().getCodePs()) {
                this.mesurer.remove(entry.getKey());
            }
        }
    }
    

    /**
     * Méthode permettant de récupérer la date de naissance au format String
     *
     * @return la date de naissance au format String
     */
    public String getStringDate(Date d) {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        return formatDate.format(d);
    }

}
