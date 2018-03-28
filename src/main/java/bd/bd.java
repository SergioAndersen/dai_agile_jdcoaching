/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import metier.Utilisateur;



/**
 *
 * @author 21101690
 */
public class bd {

    private Connection cx;

    //Données de connexion
    private String url = "jdbc:mysql://ivgz2rnl5rh7sphb.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/pef1s12npqjzdjql";
    private String login = "vaburf7btkwebup2";
    private String password = "yd1h1k477wysphga";

    //Constructeur
    public bd() {
        //Chargement du pilote pour la base de données
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Echec lors du chargement du driver" + e.getMessage());
        }

        //Ouverture de la connexcion
        try {
            cx = DriverManager.getConnection(url, login, password);
        } catch (SQLException ex) {
            System.out.println("Echec lors de la tentative de connexion à la bd" + ex.getMessage());
        }
    }

    //Methode de récuperration des utilisateurs
    public ArrayList<Utilisateur> obtenirutilisateurs() {
        ArrayList<Utilisateur> listeUtilisateur = new ArrayList();
        //Espace d'exécution de la requête
        Statement st = null;
        try {
            //Espace d'exécution de la requête
            st = cx.createStatement();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la création de l'espace d'exécution " + ex.getMessage());
        }

        //Requête SQL
        String recupererUtilisateur = "SELECT NOMU, PRENOMU FROM utilisateur";

        //Ouverture de l'espace de requête
        ResultSet rs = null;
        try {
            rs = st.executeQuery(recupererUtilisateur);
        } catch (SQLException ex) {
            System.out.println("Echec lors de l'interrogation de la base de données " + ex.getMessage());
        }

        //Ecriture des résultats de la requête dans la liste des messages
        try {
            while (rs.next()) {
                listeUtilisateur.add(new Utilisateur(rs.getString("NOMU"), rs.getString("PRENOMU")));
            }
        } catch (SQLException ex) {
            System.out.println("Echec lors de l'écriture dans la liste des messages " + ex.getMessage());
        }

        //Fermeture de l'espace de requête
        try {
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de l'espace de requête " + ex.getMessage());
        }

        //Fermeture de l'espace d'exécution de la requête
        try {
            st.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de l'espace d'exécution de la requête " + ex.getMessage());
        }

        //Fermeture de la connexion à la base de données
        try {
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de la connexion à la base de données " + ex.getMessage());
        }
        return listeUtilisateur;
    }

    public int inscrirebaseutilisateur(Utilisateur lutilisateur) {
        //Espace d'exécution de la requête
        Statement st = null;
        try {
            //Espace d'exécution de la requête
            st = cx.createStatement();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la création de l'espace d'exécution " + ex.getMessage());
        }

        //Requête SQL
        String inscrirebase = "INSERT INTO utilisateur "
        + "(CODEU, NOMU, PRENOMU, MAILU, MDPU, GENREU, TELU) "
        + "VALUES ('" + lutilisateur.getCodeu() + "','" + lutilisateur.getNomu() + "','"
        + lutilisateur.getPrenomu() + "','" + lutilisateur.getMailu() + "','" + lutilisateur.getMdpu() + "','"
        + lutilisateur.getGenreu() + "','" + lutilisateur.getTelu()
        + "');";

        int nb_ligne_modifie = 0;
        try {
            //Ouverture de l'espace de requête
            nb_ligne_modifie = st.executeUpdate(inscrirebase);
        } catch (SQLException ex) {
            System.out.println("Echec lors de l'insertion de l'utilisateur " + ex.getMessage());
        }

        //Fermeture de l'espace d'exécution de la requête
        try {
            st.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de l'espace d'exécution de la requête " + ex.getMessage());
        }

        /*Commit de la modification de la base de donnére
        try {
            System.out.println("test du commit");
            cx.commit();
        } catch (SQLException ex) {
            System.out.println("Echec lors du commit d ela base de données "+ex.getMessage());
        }*/
        //Fermeture de la connexion à la base de données
        try {
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de la connexion à la base de données " + ex.getMessage());
        }
        return nb_ligne_modifie;
    }

    //Programme de test de la connexion à la bd
    public static void main(String[] args) throws ParseException {
        bd unebd = new bd();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        /*Utilisateur u1 = new Utilisateur(1, "Setilahy", "Sergio", "sergio@example.com", 
                "12test", "M", "01-23-45-67-89" );

        int nb_ligne_mod = unebd.inscrirebaseutilisateur(u1);

        System.out.println("nombre de ligne modifiée " + nb_ligne_mod);*/
        
        ArrayList<Utilisateur> listeUtilisateur = unebd.obtenirutilisateurs();
        for (Utilisateur user : listeUtilisateur) {
            System.out.println(user.getNomu() + " " + user.getPrenomu());
        }
    }
}
