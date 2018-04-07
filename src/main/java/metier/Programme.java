/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import static java.sql.JDBCType.VARCHAR;
import static java.sql.Types.VARCHAR;

/**
 *
 * @author wangziqi
 */
public class Programme {
    private int CodePT;
    private String LibellePT;
    private String DescriptionPT;
    private Profil pro ;  

    public Programme(int CodePT, String LibellePT, String DescriptionPT, Profil pro) {
        this.CodePT = CodePT;
        this.LibellePT = LibellePT;
        this.DescriptionPT = DescriptionPT;
        this.pro = pro;
    }

    public Programme(int CodePT, String LibellePT, String DescriptionPT) {
        this.CodePT = CodePT;
        this.LibellePT = LibellePT;
        this.DescriptionPT = DescriptionPT;
    }

//    public Programme(String titrepro, String descriptionPT) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public Programme(String LibellePT, String DescriptionPT) {
        this.LibellePT = LibellePT;
        this.DescriptionPT = DescriptionPT;
    }

    
    public Profil getPro() {
        return pro;
    }

    public void setPro(Profil pro) {
        this.pro = pro;
    }
    

    public Programme(String titre, String description, String ProfilProgramme) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCodePT() {
        return CodePT;
    }

    public String getLibellePT() {
        return LibellePT;
    }

    public String getDescriptionPT() {
        return DescriptionPT;
    }

    public void setCodePT(int CodePT) {
        this.CodePT = CodePT;
    }

    public void setLibellePT(String LibellePT) {
        this.LibellePT = LibellePT;
    }

    public void setDescriptionPT(String DescriptionPT) {
        this.DescriptionPT = DescriptionPT;
    }
    
    
    
    
    
    
    
    
}

