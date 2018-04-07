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
import java.util.Map;
import metier.Exercice;
import metier.Profil;
import metier.ProfilSportif;
import metier.Programme;
import metier.Seance;
import metier.TypeS;
import metier.Utilisateur;

/**
 *
 * @author SERBI Society
 */
public class bd {

    private static Connection cx;
    /*donnée de connection*/
    private String url = "jdbc:mysql://localhost:8889/BDVF";
    private String login = "root";
    private String password = "root";

    /**
     * Constructeur de la classe permettant la communication avec la base de
     * donnnées
     */
    public bd() {

        //Chargement du driver par la JVM
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erreur chargement driver" + ex.getMessage());

        }

        //Ouverture de la connexion avec la BD
        try {
            this.cx = DriverManager.getConnection(url, login, password);
        } catch (SQLException ex) {
            System.out.println("Erreur ouverture connexion" + ex.getMessage());
        }

    }

    /**
     * fonction pour créer les exercices
     *
     * @param libelleEx
     * @param descriptionEx
     * @param video
     * @param objectif
     * @param dureeExo
     * @param dureeRecuper
     * @param nbrepe
     * @return
     */
    public int creerExercice(String libelleEx, String descriptionEx, String video, String objectif, int dureeExo, int dureeRecuper, int nbrepe) {
        //Espace d'exécution de la requête
        Statement st = null;
        try {
            //Espace d'exécution de la requête
            st = cx.createStatement();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la création de l'espace d'exécution " + ex.getMessage());
        }

        String inscrirebase = "INSERT INTO EXERCICE "
                + "( LibelleEx, DescriptionEx, LIENVIDEO , OBJECTIFEX,DUREERECUPERATIONEX, DUREEEX,NBREPETITIONEX  ) "
                + "VALUES ('" + libelleEx + "','"
                + descriptionEx + "','" + video + "','" + objectif + "','" + dureeExo + "','" + dureeRecuper + "','" + nbrepe + "');";

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

        //Fermeture de la connexion à la base de données
        try {
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de la connexion à la base de données " + ex.getMessage());
        }
        return nb_ligne_modifie;

    }

    /**
     * Fonction permettant de vérifier les logins d'un utilisateur, et
     * d'identifier si il s'agit d'un COACH, d'un ADMIN, ou d'un cliCLIENT
     *
     * @param email l'adresse email de l'utilisateur
     * @param mdp le ot de passe de l'utilisateur
     * @return un entier, 1 pour COACH, 2 ppour CLIENT, 3 pour ADMIN, et 4 si
     * @throws SQLException
     */
    public int verifLogin(String email, String mdp) throws SQLException {
        Statement st;
        int rs1 = 0;

        String sql = "select TYPEU from UTILISATEUR where MAILU='" + email + "' and MDPU = '" + mdp + "'";
        st = cx.createStatement();
        ResultSet rs = st.executeQuery(sql); //resultat

        //verifier
        if (rs.next()) {
            System.out.println("connect ok");
            //ok
            String type = rs.getString("TYPEU");
            if (type.equals("COACH")) {
                rs1 = 1;
                System.out.println("COACH");
            } else if (type.equals("CLIENT")) {
                rs1 = 2;
                System.out.println("CLIENT");
            } else if (type.equals("ADMIN")) {
                rs1 = 3;
                System.out.println("admin");
            }
        } else //ko
        {
            rs1 = 4;
        }
        return rs1;

    }

    /**
     * FOnctionpermettant de récupérer le code de l'utilisateur qui s'est
     * connecté
     *
     * @param email email de l'utilisateur
     * @param mdp mot de passe de l'utilisateur
     * @return le code de l'utilisateur
     * @throws SQLException
     */
    public int idUser(String email, String mdp) throws SQLException {
        Statement st;
        int id = 0;
        String sql = "select CODEU from UTILISATEUR where MAILU='" + email + "' and MDPU = '" + mdp + "'";
        st = cx.createStatement();
        ResultSet rs = st.executeQuery(sql); //resultat

        //verifier
        if (rs.next()) {
            System.out.println("connect ok");
            //ok
            id = rs.getInt("CODEU");
            // System.out.println(id);
        }
        return id;

    }

    /**
     * Fonction permettant de modifier le mot de passe de l'utilisateur
     *
     * @param codeU le code de l'utilisateur souhaitant modifier son mot de
     * passe
     * @param mdpnouveau le nouveau mot de passe de l'utilisateur
     * @return un entier, 0 si la modification n'a pas été prise en compte, 1
     * sinon
     * @throws SQLException
     */
    public int ModifierMDP(String codeU, String mdpnouveau) throws SQLException {
        int x = 0;
        try {

            Statement st6;
            st6 = cx.createStatement();
            String mdnouveau = "Update UTILISATEUR set MDPU='" + mdpnouveau + "' where CODEU='" + codeU + "'";
            x = st6.executeUpdate(mdnouveau);

        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
        }
        return x;
    }

    /**
     * Fonction permettant de récupérer les informations sur l'utilisateur
     * connecté
     *
     * @param id le code de l'utilisateur
     * @return l'utilisateur connecté, avec toutes ses informations
     * @throws SQLException
     * @throws ParseException
     */
    public ArrayList<Utilisateur> userConnect(int id) throws SQLException, ParseException {
        Statement st;
        String sql = "SELECT NOMU,PRENOMU,MAILU,GENREU,MDPU,DATENAISSANCE,TELU,TYPEU FROM UTILISATEUR WHERE CODEU=" + id;
        st = cx.createStatement();
        ArrayList<Utilisateur> lstI = new ArrayList();
        ResultSet rs = st.executeQuery(sql); //resultat    

        //verifier
        while (rs.next()) {
            SimpleDateFormat forma = new SimpleDateFormat("yyyy-mm-dd");
            lstI.add(new Utilisateur(rs.getString("NOMU"), rs.getString("PRENOMU"),
                    rs.getString("MAILU"), rs.getString("GENREU"), rs.getString("MDPU"),
                    rs.getString("DATENAISSANCE"), rs.getString("TELU"), rs.getString("TYPEU")));
        }

        return lstI;
    }

    /**
     * Fonction permettant de récupérer les informations sur l'utilisateur que
     * l'ADMIN souhaite modifié
     *
     * @param email l'email de l'utilisateur à modifier
     * @return l'utilisateur à modifier avec tutes ses informations
     * @throws SQLException
     * @throws ParseException
     */
    public Utilisateur userInfo(String email) throws SQLException, ParseException {
        Utilisateur user = null;
        Statement st;
        String sql = "SELECT NOMU,PRENOMU,MAILU,MDPU,GENREU,DATENAISSANCE,TELU,STATUTU, DATEINSCRI FROM UTILISATEUR WHERE MAILU= '" + email + "'";
        st = cx.createStatement();
        ResultSet rs = st.executeQuery(sql); //resultat    
        ArrayList<Utilisateur> lstL = new ArrayList();
        //verifier
        while (rs.next()) {
            System.out.println(rs.getString("STATUTU"));

            SimpleDateFormat forma = new SimpleDateFormat("yyyy-mm-dd");
            user = new Utilisateur(rs.getString("NOMU"), rs.getString("PRENOMU"), rs.getString("MAILU"), rs.getString("GENREU"), rs.getString("DATENAISSANCE"), rs.getString("TELU"), rs.getString("STATUTU"));
            System.out.println(user.getStatutu());
        }

        return user;
    }

    /**
     * Fonction permettant de récupérer tout les utilisateurs
     *
     * @return la liste des utilisateurs
     * @throws SQLException
     */
    public ArrayList<Utilisateur> ConsulterUtilisateur() throws SQLException {
        String nomu;
        String prenomu;
        String mailu;
        String mdpu;
        String genreu;
        String datenaissance;
        String telu;
        String typeu;
        Date dateinscri;
        String statutu;
        Statement st;
        ResultSet rs;

        String sql = "select NOMU, PRENOMU, MAILU, MDPU,GENREU, DATENAISSANCE, TELU, TYPEU, DATEINSCRI, STATUTU from UTILISATEUR;";
        st = cx.createStatement();
        ArrayList<Utilisateur> liste = new ArrayList();

        try {
            rs = st.executeQuery(sql);

            while (rs.next()) {
                nomu = rs.getString("NOMU");
                prenomu = rs.getString("PRENOMU");
                mailu = rs.getString("MAILU");
                mdpu = rs.getString("MDPU");
                genreu = rs.getString("GENREU");
                datenaissance = rs.getString("DATENAISSANCE");
                telu = rs.getString("TELU");
                typeu = rs.getString("TYPEU");
                dateinscri = rs.getDate("DATEINSCRI");
                statutu = rs.getString("STATUTU");

                liste.add(new Utilisateur(nomu, prenomu, mailu, mdpu, genreu, datenaissance, telu, typeu, dateinscri, statutu));
            }
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
        }
        return liste;
    }

    /**
     * Fonction permettant de récupérer la proportion des CLIENTS en fontion des
     * statuts
     *
     * @return une liste de String avec les différentes valeurs des indicateurs
     * @throws SQLException
     */
    public ArrayList<String> indicClientStatu() throws SQLException {
        int nbv = 0, nbatt = 0, nbtotal = 0, nbpot = 0;
        Statement st, st2, st3, st4;
        //nb de client valide
        String sql = "SELECT COUNT(*)AS NBVALIDE FROM UTILISATEUR WHERE STATUTU='VALIDE'";
        st = cx.createStatement();
        ResultSet rs = st.executeQuery(sql); //resultat    
        //result
        while (rs.next()) {
            nbv = Integer.parseInt(rs.getString("NBVALIDE"));
        }
        //nb client en attente
        String sql2 = "SELECT COUNT(*)AS NBATTENTE FROM UTILISATEUR WHERE STATUTU='EN ATTENTE'";
        st2 = cx.createStatement();
        ResultSet rs2 = st2.executeQuery(sql2); //resultat    
        //result
        while (rs2.next()) {
            nbatt = Integer.parseInt(rs2.getString("NBATTENTE"));
        }

        String sql4 = "SELECT COUNT(*)AS NBPOTENTIEL FROM UTILISATEUR WHERE STATUTU='POTENTIEL'";
        st4 = cx.createStatement();
        ResultSet rs4 = st4.executeQuery(sql4); //resultat    
        //result
        while (rs4.next()) {
            nbpot = Integer.parseInt(rs4.getString("NBPOTENTIEL"));
        }

        //nb client total
        String sql3 = "SELECT COUNT(*)AS NBTOTAL FROM UTILISATEUR WHERE TYPEU='CLIENT'";
        st3 = cx.createStatement();
        ResultSet rs3 = st3.executeQuery(sql3); //resultat    
        //verifier
        while (rs3.next()) {
            nbtotal = Integer.parseInt(rs3.getString("NBTOTAL"));
        }
        ArrayList<String> indic = new ArrayList<String>();
        indic.add(String.valueOf((nbv * 100) / nbtotal));//% de client valider  0
        indic.add(String.valueOf((nbatt * 100) / nbtotal));//% de client en attente  1

        indic.add(String.valueOf(nbtotal));  //2 client total
        indic.add(String.valueOf(nbv));  //3 client valider
        indic.add(String.valueOf(nbatt));  //4 client en attente
        indic.add(String.valueOf((nbpot * 100) / nbtotal));//% de client potentiel  5
        indic.add(String.valueOf(nbpot));  //6 client potentiel

        return indic;

    }

    /**
     * Procédure permettant de modifier le statut et le numéro de téléphone d'un
     * utilisateur en fonction de son email
     *
     * @param mail l'email de l'utilisateur à modifier
     * @param statut le nouveau statut de l'utilisateur
     * @param tel le numéro de téléphone de l'utilisateur
     * @throws SQLException
     */
    public void ModifierMessage(String mail, String statut, String tel) throws SQLException {
        try {
            if (statut.equals("VALIDE")) {
                Date now = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String dateAuj = dateFormat.format(now); //date aujourd'hui
                Statement st4;
                st4 = cx.createStatement();
                /*requete SQL*/
                String sq1 = "update UTILISATEUR set STATUTU='" + statut + "',TELU='" + tel + "',DATEVALID='" + dateAuj + "' Where MAILU='" + mail + "'";
                int nb1 = st4.executeUpdate(sq1);

            } else {
                Statement st3;
                st3 = cx.createStatement();
                /*requete SQL*/
                String sq = "update UTILISATEUR set STATUTU='" + statut + "',TELU='" + tel + "' Where MAILU='" + mail + "'";
                int nb = st3.executeUpdate(sq);
            }
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
        }
    }

    /**
     * Procédure permettant de creer un nouveau profil
     *
     * @param nomp le nom du profil à créer
     * @throws SQLException
     */
    public void ajouterProfil(String nomp) throws SQLException {
        //espace de requete
        Statement st;
        /*requete sql*/
        String sql1 = "INSERT INTO PROFIL (DESCRIPTPRO)VALUES('" + nomp + "');";
        /*ouverture de l'espace de requete*/
        st = cx.createStatement();
        //retourne le nombre de lignes modifiées
        int nb = st.executeUpdate(sql1);
    }

    /**
     * Procédure permettant de créer un type de séance
     *
     * @param nomts le nom du type de séance
     * @throws SQLException
     */
    public void ajouterTypeSeance(String nomts) throws SQLException {
        //espace de requete
        Statement st;
        /*requete sql*/
        String sql1 = "INSERT INTO TYPES (LIBELLETS) VALUES('" + nomts + "');";
        /*ouverture de l'espace de requete*/
        st = cx.createStatement();
        //retourne le nombre de lignes modifiées
        int nb = st.executeUpdate(sql1);
    }

    /**
     * Fonction permettant de modifier le nom, le prénom, l'email, le genre, le
     * numéro de téléphone, la date de naissance d'un utilisateur
     *
     * @param codeu le code de l'utilisateur à modifier
     * @param genre le nouveau genre de l'utilisateur
     * @param nom le nouveau nom de l'utilisateur
     * @param prenom le nouveau prénom de l'utilisateur
     * @param datenaissance la nouvelle date de naissance de l'utilisateur
     * @param tel le nouveau numéro de téléphone de l'utilisateur
     * @param mail le nouvel email de l'utilisateur
     * @return un entier, 1 si la modification a été prise en compte, 0 sinon
     */
    public int modifUtilisateur(int codeu, String genre, String nom, String prenom,
            String datenaissance, String tel, String mail) {

        Statement st = null;
        try {
            //Espace d'exécution de la requête
            st = cx.createStatement();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la création de l'espace d'exécution " + ex.getMessage());
        }

        //Requête SQL
        String inscrirebase = "UPDATE UTILISATEUR "
                + "SET  NOMU = '" + nom + "', PRENOMU = '" + prenom + "', MAILU='" + mail + "',  GENREU ='" + genre + "',"
                + " TELU = '" + tel + "', DATENAISSANCE = '" + datenaissance + "' "
                + " WHERE UTILISATEUR.CODEU= ' " + codeu + "' ;";

        int nb_ligne_modifie = 0;

        try {
            //Ouverture de l'espace de requête
            nb_ligne_modifie = st.executeUpdate(inscrirebase);
        } catch (SQLException ex) {
            System.out.println("Echec lors de la modification de l'utilisateur " + ex.getMessage());
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
        return nb_ligne_modifie;

    }

    /**
     * Fonction permettant de récupérer yout les utilisateurs
     *
     * @return une liste des utiilisateurs
     */
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
        String recupererUtilisateur = "SELECT NOMU, PRENOMU FROM UTILISATEUR";

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
                listeUtilisateur.add(new Utilisateur(rs.getString("NOMU"),
                        rs.getString("PRENOMU"), rs.getString("STATUTU"),
                        rs.getDate("DATEINSCRI")));
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

    /**
     * FOnction permettant de faire l'inscription de base d'un utilisateur
     *
     * @param lutilisateur l'utilisateur à inscrire
     * @return un entier, 0 si l'inscription n'a pas été prise en compte, 1
     * sinon
     */
    public int inscrirebaseutilisateur(Utilisateur lutilisateur) {
        //Espace d'exécution de la requête
        Statement st = null;
        try {
            //Espace d'exécution de la requête
            st = cx.createStatement();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la création de l'espace d'exécution " + ex.getMessage());
        }

        Date x = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
        String pi = formatDate.format(x);

        //Requête SQL
        String inscrirebase = "INSERT INTO UTILISATEUR "
                + "(CODEU, NOMU, PRENOMU, MAILU, MDPU, GENREU, TELU,TYPEU,DATEINSCRI,STATUTU,DATENAISSANCE) "
                + "VALUES ('" + lutilisateur.getCodeu() + "','" + lutilisateur.getNomu() + "','"
                + lutilisateur.getPrenomu() + "','" + lutilisateur.getMailu() + "','" + lutilisateur.getMdpu() + "','"
                + lutilisateur.getGenreu() + "','" + lutilisateur.getTelu()
                + "','" + "CLIENT" + "','" + pi + "','" + "POTENTIEL" + "','" + lutilisateur.getDatenaissanceu() + "');";

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

        //Fermeture de la connexion à la base de données
        try {
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de la connexion à la base de données " + ex.getMessage());
        }
        return nb_ligne_modifie;
    }

    /**
     * Fonction permettant à l'ADMIN de faire l'inscription d'un utilisateur
     *
     * @param lutilisateur l'utilisateur à inscrire
     * @return un entier, 0 si l'inscription n'a pas été prise en compte, 1
     * sinon
     */
    public void inscrireDefinir(int codeU, int codePro) throws SQLException {
        Statement st = null;
        st = cx.createStatement();

        String inscrirebase = "INSERT INTO DEFINIR (CODEU, CODEPRO) VALUES (" + codeU + ", " + codePro + ")";
        st.executeUpdate(inscrirebase);

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
    }

    /**
     * fonction permettre de inscrire un client par admin
     *
     * @param lutilisateur
     * @return
     */
    public int inscrirebaseutilisateurAdmin(Utilisateur lutilisateur) {
        //Espace d'exécution de la requête
        Statement st = null;
        try {
            //Espace d'exécution de la requête
            st = cx.createStatement();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la création de l'espace d'exécution " + ex.getMessage());
        }

        Date x = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
        String pi = formatDate.format(x);

        //Requête SQL
        String inscrirebase = "INSERT INTO UTILISATEUR "
                + "(CODEU, NOMU, PRENOMU, MAILU, MDPU, GENREU, TELU,TYPEU,DATEINSCRI,STATUTU,DATENAISSANCE) "
                + "VALUES ('" + lutilisateur.getCodeu() + "','" + lutilisateur.getNomu() + "','"
                + lutilisateur.getPrenomu() + "','" + lutilisateur.getMailu() + "','" + lutilisateur.getMdpu() + "','"
                + lutilisateur.getGenreu() + "','" + lutilisateur.getTelu()
                + "','" + "CLIENT" + "','" + pi + "','" + "VALIDE" + "','" + lutilisateur.getDatenaissanceu() + "');";

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

        //Fermeture de la connexion à la base de données
        try {
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de la connexion à la base de données " + ex.getMessage());
        }
        return nb_ligne_modifie;
    }

    /**
     * Fonction permettant de supprimer un utilisateur
     *
     * @param email l'email de l'utilisateur à supprimer
     * @return un entier, 0 si la suppression n'a pas été prise en compte, 1
     * sinon
     */
    public static int supprimerutilisateur(String email) {
        //Espace d'exécution de la requête
        Statement st = null;
        try {
            //Espace d'exécution de la requête
            st = cx.createStatement();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la création de l'espace "
                    + "d'exécution " + ex.getMessage());
        }

        //Requête SQL
        String supclient = "DELETE FROM UTILISATEUR WHERE MAILU = '"
                + email + "';";

        int nb_ligne_modifie = 0;
        try {
            //Ouverture de l'espace de requête
            nb_ligne_modifie = st.executeUpdate(supclient);
        } catch (SQLException ex) {
            System.out.println("Echec lors de l'insertion de l'utilisateur "
                    + ex.getMessage());
        }

        //Fermeture de l'espace d'exécution de la requête
        try {
            st.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de l'espace "
                    + "d'exécution de la requête " + ex.getMessage());
        }

        //Fermeture de la connexion à la base de données
        try {
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de la connexion à la "
                    + "base de données " + ex.getMessage());
        }
        return nb_ligne_modifie;
    }

    /**
     * Procédure permettant de faire l'inscription sportive d'un CLIENT
     *
     * @param u1 le CLIENT souhaitant faire l'inscription sportive
     * @param ps1 le profil sportif du CLIENT
     * @throws SQLException
     */
    public void remplirProfilSportif(Utilisateur u1, ProfilSportif ps1) throws SQLException {
        //espace de requêtes
        Statement st;

        //requete sql
        String sql = "Insert into PROFILSPORTIF (CODEU,CODE,DATEPS)" + "VALUES ('" + u1.getCodeu() + "'," + ps1.getCodePs() + "',"
                + "";

        //ouverture de l'espace de requetes
        st = cx.createStatement();
        ResultSet rs = st.executeQuery(sql);

    }

    /**
     * Fonction permettant de récupérer la liste des CLIENTS en fonction de leur
     * statut
     *
     * @param statut le statut pour lequel on souhaite avoir la liste des
     * clients
     * @return une liste des utilisateurs ayant ce statut
     */
    public static ArrayList<Utilisateur> obtenirClientSelonStatut(String statut) {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        String recupererUtilisateur = null;
        ArrayList<Utilisateur> listeUtilisateur = new ArrayList();
        //Espace d'exécution de la requête
        Statement st = null;
        try {
            //Espace d'exécution de la requête
            st = cx.createStatement();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la création de l'espace "
                    + "d'exécution " + ex.getMessage());
        }

        //Requête SQL
        if (statut.equals("VALIDE")) {
            recupererUtilisateur = "SELECT NOMU, PRENOMU, STATUTU, DATEINSCRI, MAILU "
                    + "FROM UTILISATEUR WHERE TYPEU = 'CLIENT' AND STATUTU = '"
                    + statut + "' ORDER BY NOMU, PRENOMU ;";
        } else {
            recupererUtilisateur = "SELECT NOMU, PRENOMU, STATUTU, DATEINSCRI, MAILU  "
                    + "FROM UTILISATEUR WHERE TYPEU = 'CLIENT' AND STATUTU LIKE "
                    + "'%" + statut + "%' ORDER BY DATEINSCRI ;";
        }

        //Ouverture de l'espace de requête
        ResultSet rs = null;
        try {
            rs = st.executeQuery(recupererUtilisateur);
        } catch (SQLException ex) {
            System.out.println("Echec lors de l'interrogation de la base de "
                    + "données " + ex.getMessage());
        }

        //Ecriture des résultats de la requête dans la liste des messages
        try {
            while (rs.next()) {
                String[] date = rs.getString("DATEINSCRI").split("-");
                listeUtilisateur.add(new Utilisateur(rs.getString("NOMU"),
                        rs.getString("PRENOMU"), rs.getString("STATUTU"),
                        (formatDate.parse(date[0] + "/" + date[1] + "/" + date[2])), rs.getString("MAILU")));
            }
        } catch (SQLException ex) {
            System.out.println("Echec lors de l'écriture dans la liste des "
                    + "utilisateurs --> Erreur niveau SQL " + ex.getMessage());
        } catch (ParseException ex) {
            System.out.println("Echec lors de l'écriture dans la liste des "
                    + "utilisateurs --> Erreur niveau parse " + ex.getMessage());
        }

        //Fermeture de l'espace de requête
        try {
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de l'espace de "
                    + "requête " + ex.getMessage());
        }

        //Fermeture de l'espace d'exécution de la requête
        try {
            st.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de l'espace "
                    + "d'exécution de la requête " + ex.getMessage());
        }

        //Fermeture de la connexion à la base de données
        try {
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de la connexion à la "
                    + "base de données " + ex.getMessage());
        }
        return listeUtilisateur;
    }

    /**
     * Fonction permettant de récupérer le mot de passe d'un utilisateur en
     * fonction de son email
     *
     * @param mail l'email de l'utilisateur souhaitant récupérer son omot de
     * passe
     * @return le mot de passe de l'utilisateur
     * @throws SQLException
     */
    public String Envoyer(String mail) throws SQLException {
        String mdp = null;
        try {
            Statement st5;
            st5 = cx.createStatement();
            String recherche = "SELECT MDPU FROM `UTILISATEUR` WHERE MAILU = '" + mail + "'";
            ResultSet rs = st5.executeQuery(recherche);
            while (rs.next()) {

                mdp = rs.getString("MDPU");
                System.out.println(mdp);
            }
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
        }
        return mdp;
    }

    //////////////////////////////////////////////////////////////////////////////////////
    /**
     * Fonction permettant de récupérer la liste des séances
     *
     * @return la liste des séances
     * @throws SQLException
     */
    public ArrayList<Seance> recuperationSeance() throws SQLException {
        Statement st1;
        String libel;
        String type;
        String des;

        int codest = 0;
        int CodeTS = 0;
        Seance s = null;
        String sq = "SELECT t.CodeTS,s.CODEST,s.DESCRIPTIONST,s.libellest,t.libellets FROM SEANCETYPE s,TYPES t  WHERE t.Codets=s.codets ";
        st1 = cx.createStatement();
        ArrayList<Seance> listeSeance = new ArrayList();
        ResultSet rs = st1.executeQuery(sq);
        while (rs.next()) {
            libel = rs.getString("libellest");
            type = rs.getString("libellets");
            codest = Integer.parseInt(rs.getString("CODEST"));
            CodeTS = Integer.parseInt(rs.getString("CodeTS"));
            des = rs.getString("DESCRIPTIONST");

            TypeS types = new TypeS(CodeTS, type);
            s = new Seance(codest, libel, des, types);
            listeSeance.add(s);
        }
        return listeSeance;
    }

    /**
     * Fonction permettant de récupérer la liste des types de séances
     *
     * @return la liste des types de séances
     * @throws SQLException
     */
    public ArrayList<TypeS> recuperationTypeSeance() throws SQLException {
        Statement st1;
        String sq = "select CODETS,LIBELLETS from TYPES ";
        st1 = cx.createStatement();
        ArrayList<TypeS> lstTS = new ArrayList();
        ResultSet rs = st1.executeQuery(sq);

        while (rs.next()) {
            System.out.println(rs.getString("LIBELLETS"));
            lstTS.add(new TypeS(rs.getInt("CODETS"), rs.getString("LIBELLETS")));

        }
        return lstTS;

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Fonction permettant de récupérer une liste des séances avec les
     * programmes auquel ils sont rattachés
     *
     * @param codePT le code du programme
     * @return
     * @throws SQLException
     */
    public ArrayList<Seance> recuperationSeancePro(int codePT) throws SQLException {
        Statement st1;
        String titrepro = null;
        String descriptionPT = null;
        String descriptionST;
        String typeSeance;
        String titreseance;
        int nbrepet;
        String type;
        String des;
        Programme pro;

        int codest = 0;
        int CodeTS = 0;
        Seance s = null;
        String sq = "select PT.DESCRIPTIONPT,PT.LIBELLEPT,ST.CODEST,ST.CODETS,LIBELLETS,C.NBREPETITIONS,LIBELLEST,DESCRIPTIONST,FCARDICIBLE,FCARDIREPO,ORDRES from CONCERNER AS C, SEANCETYPE AS ST, TYPES AS TS ,PROGRAMMETYPE PT where C.CODEST=ST.CODEST AND ST.CODETS=TS.CODETS AND PT.CODEPT=C.CODEPT AND C.CODEPT=" + codePT + " ORDER BY ORDRES";
        st1 = cx.createStatement();
        ArrayList<Seance> listeSeance = new ArrayList();

        ResultSet rs = st1.executeQuery(sq);

        while (rs.next()) {

            codest = Integer.parseInt(rs.getString("CODEST"));
            CodeTS = Integer.parseInt(rs.getString("CODETS"));
            titrepro = rs.getString("LIBELLEPT");
            descriptionPT = rs.getString("DESCRIPTIONPT");
            typeSeance = rs.getString("LIBELLETS");
            titreseance = rs.getString("LIBELLEST");
            nbrepet = Integer.parseInt(rs.getString("NBREPETITIONS"));
            descriptionST = rs.getString("DESCRIPTIONST");
            pro = new Programme(titrepro, descriptionPT);
            System.out.println(pro.getLibellePT());
            TypeS types = new TypeS(CodeTS, typeSeance);
            s = new Seance(codest, titreseance, descriptionST, types, nbrepet, pro);
            listeSeance.add(s);
        }

        return listeSeance;
    }

    /**
     * Fonction permettant de récupérer la liste de sprogrammes
     *
     * @return la liste des programmes existant
     * @throws SQLException
     */
    public ArrayList<Programme> recuperationProgramme() throws SQLException {
        Statement st1;
        String sq = "select CODEPT, DESCRIPTIONPT, LIBELLEPT from PROGRAMMETYPE ";
        st1 = cx.createStatement();

        ArrayList<Programme> listeProg = new ArrayList();

        ResultSet rs = st1.executeQuery(sq);

        while (rs.next()) {

            listeProg.add(new Programme(rs.getInt("CODEPT"), rs.getString("LIBELLEPT"), rs.getString("DESCRIPTIONPT")));
        }
        return listeProg;

    }

    /**
     * Fonction permettant de récupérer la liste des profils
     *
     * @return la liste des profils existant
     * @throws SQLException
     */
    public ArrayList<Profil> recuperationProfil() throws SQLException {
        Statement st1;
        String sq = "select CODEPRO,DESCRIPTPRO from profil ";
        st1 = cx.createStatement();
        ArrayList<Profil> listeProfil = new ArrayList();
        ResultSet rs = st1.executeQuery(sq);
        while (rs.next()) {
            System.out.println(rs.getString("DESCRIPTPRO"));
            listeProfil.add(new Profil(rs.getInt("CODEPRO"), rs.getString("DESCRIPTPRO")));
        }
        return listeProfil;
    }

    /**
     * Fonction permettant de récupérer le nom d'un profil en fonction de son
     * code
     *
     * @param codeP le code du profil dont on souhaite obtenir le nom
     * @return le nom du profil
     * @throws SQLException
     */
    public String recupNomProfil(int codeP) throws SQLException {
        Statement st1;
        String descriptionProfil = "";
        String sq = "select DESCRIPTPRO from PROFIL where CODEPRO=" + codeP + "";
        st1 = cx.createStatement();

        ResultSet rs = st1.executeQuery(sq);

        while (rs.next()) {
            descriptionProfil = rs.getString("DESCRIPTPRO");
        }
        return descriptionProfil;

    }

    /**
     * Fonction permettant de créer un programme
     *
     * @param pro le programme à créer
     * @param codeProfill le code du profil associé au programme
     * @return un entier, 0 si la création n'a pas été prise en compte, 1 sinon
     */
    public int SaisirProgramme(Programme pro, int codeProfill) {
        int nb = 0;
        int nb2 = 0;
        int tot = 0;
        try {
            Statement st1;
            st1 = cx.createStatement();
            String sq = "Insert into PROGRAMMETYPE(LibellePT, DescriptionPT) value('" + pro.getLibellePT() + "','" + pro.getDescriptionPT() + "')";
            nb = st1.executeUpdate(sq);

            Programme objPro = recupProgramme(pro.getLibellePT());
            int codePro = objPro.getCodePT();
            Statement st2;
            st2 = cx.createStatement();
            String sql2 = "insert into CORRESPONDRE (CODEPRO,CodePT) value('" + codeProfill + "','" + codePro + "')";
            nb2 = st2.executeUpdate(sql2);

            System.out.println(nb2 + nb);
        } catch (SQLException ex) {
            System.out.println("erreur" + ex.getMessage());
        }

        tot = nb + nb2;
        return tot;
    }

    /**
     * Fonction permettant d'associer une séance à un prorgamme
     *
     * @param codePT le code du programme
     * @param CodeST le code de la séance
     * @param ordre la position de la séance dans e programme
     * @param nbrepet le nombre de répétition de la séance
     * @return un entier, 0 si la création n'a pas été prise en compte, 1 sinon
     * @throws SQLException
     */
    public int insererConcerner(int codePT, int CodeST, int ordre, int nbrepet) throws SQLException {
        Statement st1;
        int nb2 = 0;
        st1 = cx.createStatement();

        String sql2 = "INSERT INTO CONCERNER(CODEPT, CODEST, ORDRES, NBREPETITIONS) value('" + codePT + "','" + CodeST + "','" + ordre + "','" + nbrepet + "')";
        nb2 = st1.executeUpdate(sql2);
        return nb2;
    }

    /**
     * Fonction permettant de récupérer un programme en fonction de son libellé
     *
     * @param libelle le libellé du programme
     * @return le programme en question
     * @throws SQLException
     */
    public Programme recupProgramme(String libelle) throws SQLException {

        Statement st1;
        int codeP = 0;
        String libelleP = null;
        String descri = null;
        Programme pro;
        st1 = cx.createStatement();
        String sq = "select CodePT ,LibellePT,DescriptionPT from PROGRAMMETYPE  where LibellePT='" + libelle + "'";

        ResultSet rs = st1.executeQuery(sq);

        //verifier
        if (rs.next()) {
            System.out.println("connect ok");
            //ok
            codeP = rs.getInt("CodePT");
            libelleP = rs.getString("LibellePT");
            descri = rs.getString("DescriptionPT");
        }

        pro = new Programme(codeP, libelleP, descri);
        return pro;

    }

    /**
     * Fonction permettant de créer un exercice
     *
     * @param libelleEx lelibellé de l'exercice
     * @param descriptionEx la description de l'exercice
     * @param image l'adresse de l'image de l'exercice
     * @param video le lien vers la vidéo de l'exercice
     * @param objectif l'objectif de l'exercice
     * @return un entier, 0 si la création n'a pas été prise en compte, 1 sinon
     */
    public int creerExercice(String libelleEx, String descriptionEx, String image, String video, String objectif) {
        //Espace d'exécution de la requête
        Statement st = null;
        try {
            //Espace d'exécution de la requête
            st = cx.createStatement();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la création de l'espace d'exécution " + ex.getMessage());
        }

        String inscrirebase = "INSERT INTO EXERCICE "
                + "(LIBELLEEX, DESCRIPTIONEX, LIENVIDEO , OBJECTIFEX) "
                + "VALUES ('" + libelleEx + "','"
                + descriptionEx + "','" + image + "','" + video + "','" + objectif + "');";

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

        //Fermeture de la connexion à la base de données
        try {
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de la connexion à la base de données " + ex.getMessage());
        }
        return nb_ligne_modifie;

    }

    //Programme de test de la connexion à la bd
    public static void main(String[] args) throws SQLException, ParseException {
        bd unebd = new bd();

    }

    /**
     * Procédure permettant de créer une séance
     *
     * @param maseance la séance à créer
     */
    public static void creerSeance(Seance maseance) {
        //Espace d'exécution de la requête
        Statement st = null;
        try {
            //Espace d'exécution de la requête
            st = cx.createStatement();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la création de l'espace "
                    + "d'exécution " + ex.getMessage());
        }

        //Requête SQL
        String creer = "INSERT INTO SEANCETYPE (CODETS, LIBELLEST, "
                + "DESCRIPTIONST) VALUES (" + maseance.getTypeST().getCodeTS() + ",'" + maseance.getLibelleST()
                + "','" + maseance.getDescriptionST() + "');";
        int nb_ligne_modifie = 0;
        try {
            //Ouverture de l'espace de requête
            nb_ligne_modifie = st.executeUpdate(creer);
            //Requête SQL
            String recupererSeance = "SELECT MAX(CODEST) FROM SEANCETYPE;";

            //Ouverture de l'espace de requête
            ResultSet rs = null;
            rs = st.executeQuery(recupererSeance);

            //Ecriture des résultats de la requête dans la liste des messages
            try {
                while (rs.next()) {
                    maseance.setCodeST(rs.getInt("MAX(CODEST)"));
                }
                for (Map.Entry<Integer, Exercice> entry : maseance.getMapExo().entrySet()) {
                    //Requête SQL
                    String creerLien = "INSERT INTO ORGANISER (CODEST, CODEEX, ORDREEX) "
                            + "VALUES ('" + maseance.getCodeST() + "','" + entry.getValue().getCodeEx()
                            + "','" + entry.getKey() + "');";
                    try {
                        //Ouverture de l'espace de requête
                        nb_ligne_modifie = nb_ligne_modifie + st.executeUpdate(creerLien);
                    } catch (SQLException ex) {
                        System.out.println("Echec lors de l'insertion de l'utilisateur "
                                + ex.getMessage());
                    }

                }
            } catch (SQLException ex) {
                System.out.println("Echec lors de l'écriture dans la séance "
                        + " --> Erreur niveau SQL " + ex.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Echec lors de l'insertion de l'utilisateur "
                    + ex.getMessage());
        }

        //Fermeture de l'espace d'exécution de la requête
        try {
            st.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de l'espace "
                    + "d'exécution de la requête " + ex.getMessage());
        }

        try {
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de la connexion à la "
                    + "base de données " + ex.getMessage());
        }
    }

    /**
     * Fonction permettant de récupérer la liste des types séances
     *
     * @return la liste des types de éances existantes
     */
    public static ArrayList<TypeS> obtenirListeTypeSeance() {
        String recupererTypeS = null;
        ArrayList<TypeS> listeTypeS = new ArrayList();
        //Espace d'exécution de la requête
        Statement st = null;
        try {
            //Espace d'exécution de la requête
            st = cx.createStatement();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la création de l'espace "
                    + "d'exécution " + ex.getMessage());
        }

        //Requête SQL
        recupererTypeS = "SELECT CODETS, LIBELLETS FROM TYPES;";

        //Ouverture de l'espace de requête
        ResultSet rs = null;
        try {
            rs = st.executeQuery(recupererTypeS);
        } catch (SQLException ex) {
            System.out.println("Echec lors de l'interrogation de la base de "
                    + "données " + ex.getMessage());
        }

        //Ecriture des résultats de la requête dans la liste des messages
        try {
            while (rs.next()) {
                listeTypeS.add(new TypeS(rs.getInt("CODETS"),
                        rs.getString("LIBELLETS")));
            }
        } catch (SQLException ex) {
            System.out.println("Echec lors de l'écriture dans la liste des "
                    + "types de séances --> Erreur niveau SQL " + ex.getMessage());
        }

        //Fermeture de l'espace de requête
        try {
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de l'espace de "
                    + "requête " + ex.getMessage());
        }

        //Fermeture de l'espace d'exécution de la requête
        try {
            st.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de l'espace "
                    + "d'exécution de la requête " + ex.getMessage());
        }

        //Fermeture de la connexion à la base de données
        try {
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de la connexion à la "
                    + "base de données " + ex.getMessage());
        }
        return listeTypeS;
    }

    /**
     * Fonction permettant d'obtenir la liste des exercices
     *
     * @return la liste des exercices existants
     */
    public static ArrayList<Exercice> obtenirListeExo() {
        String recupererExo = null;
        ArrayList<Exercice> listeExo = new ArrayList();
        //Espace d'exécution de la requête
        Statement st = null;
        try {
            //Espace d'exécution de la requête
            st = cx.createStatement();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la création de l'espace "
                    + "d'exécution " + ex.getMessage());
        }

        //Requête SQL
        recupererExo = "SELECT CODEEX, LIBELLEEX FROM EXERCICE;";

        //Ouverture de l'espace de requête
        ResultSet rs = null;
        try {
            rs = st.executeQuery(recupererExo);
        } catch (SQLException ex) {
            System.out.println("Echec lors de l'interrogation de la base de "
                    + "données " + ex.getMessage());
        }

        //Ecriture des résultats de la requête dans la liste des messages
        try {
            while (rs.next()) {
                listeExo.add(new Exercice(rs.getInt("CODEEX"),
                        rs.getString("LIBELLEEX")));
            }
        } catch (SQLException ex) {
            System.out.println("Echec lors de l'écriture dans la liste des "
                    + "types de séances --> Erreur niveau SQL " + ex.getMessage());
        }

        //Fermeture de l'espace de requête
        try {
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de l'espace de "
                    + "requête " + ex.getMessage());
        }

        //Fermeture de l'espace d'exécution de la requête
        try {
            st.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de l'espace "
                    + "d'exécution de la requête " + ex.getMessage());
        }

        //Fermeture de la connexion à la base de données
        try {
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de la connexion à la "
                    + "base de données " + ex.getMessage());
        }
        return listeExo;
    }

    /**
     * Fonction permettant de récupérer un exercice en fonction de son code
     *
     * @param codeEx la code de l'exercice à récupérer
     * @return l'exercice
     */
    public static Exercice obtenirInfoExo(int codeEx) {
        String recupererExo = null;
        Exercice exo = null;
        //Espace d'exécution de la requête
        Statement st = null;
        try {
            //Espace d'exécution de la requête
            st = cx.createStatement();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la création de l'espace "
                    + "d'exécution " + ex.getMessage());
        }

        //Requête SQL
        recupererExo = "SELECT CODEEX, LIBELLEEX, DUREERECUPERATIONEX, DUREEEX,"
                + " NBREPETITIONEX FROM EXERCICE WHERE CODEEX = " + codeEx + ";";

        //Ouverture de l'espace de requête
        ResultSet rs = null;
        try {
            rs = st.executeQuery(recupererExo);
        } catch (SQLException ex) {
            System.out.println("Echec lors de l'interrogation de la base de "
                    + "données " + ex.getMessage());
        }

        //Ecriture des résultats de la requête dans la liste des messages
        try {
            while (rs.next()) {
                exo = new Exercice(rs.getInt("CODEEX"),
                        rs.getString("LIBELLEEX"),
                        rs.getString("DUREERECUPERATIONEX"), rs.getString("DUREEEX"),
                        rs.getInt("NBREPETITIONEX"));
            }
        } catch (SQLException ex) {
            System.out.println("Echec lors de l'écriture dans la liste des "
                    + "types de séances --> Erreur niveau SQL " + ex.getMessage());
        }

        //Fermeture de l'espace de requête
        try {
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de l'espace de "
                    + "requête " + ex.getMessage());
        }

        //Fermeture de l'espace d'exécution de la requête
        try {
            st.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de l'espace "
                    + "d'exécution de la requête " + ex.getMessage());
        }

        //Fermeture de la connexion à la base de données
        try {
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de la connexion à la "
                    + "base de données " + ex.getMessage());
        }
        return exo;
    }

    /**
     * Fonction permettant de récupérer une séance à partir de son code
     *
     * @param codeS le code de la séance à récupérer
     * @return la séance
     */
    public static Seance obtenirInfoSeance(int codeS) {
        String recupererSeance = null;
        Seance laseance = null;
        //Espace d'exécution de la requête
        Statement st = null;
        try {
            //Espace d'exécution de la requête
            st = cx.createStatement();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la création de l'espace "
                    + "d'exécution " + ex.getMessage());
        }

        //Requête SQL
        recupererSeance = "SELECT st.CODEST, st.LIBELLEST, st.DESCRIPTIONST, "
                + "ts.CODETS, ts.LIBELLETS, e.CODEEX, e.LIBELLEEX, "
                + "e.DUREERECUPERATIONEX, e.DUREEEX, e.NBREPETITIONEX, e.LIENVIDEO,  "
                + "o.ORDREEX "
                + "FROM SEANCETYPE st, TYPES ts, ORGANISER o, EXERCICE e "
                + "WHERE st.CODETS = ts.CODETS AND st.CODEST = o.CODEST "
                + "AND o.CODEEX = e.CODEEX AND st.CODEST = " + codeS + ";";

        //Ouverture de l'espace de requête
        ResultSet rs = null;
        try {
            rs = st.executeQuery(recupererSeance);
        } catch (SQLException ex) {
            System.out.println("Echec lors de l'interrogation de la base de "
                    + "données " + ex.getMessage());
        }

        //Ecriture des résultats de la requête dans la liste des messages
        try {
            int j = 0;
            while (rs.next()) {
                //Exercice(int codeEx, String libelleEx, String dureeRecup, String dureeEx, int nbRepetitionEx)
                if (j == 0) {
                    laseance = new Seance(codeS, rs.getString("LIBELLEST"),
                            rs.getString("DESCRIPTIONST"),
                            new TypeS(rs.getInt("CODETS"), rs.getString("LIBELLETS")));
                }
                laseance.getMapExo().put(rs.getInt("ORDREEX"),
                        new Exercice(rs.getInt("CODEEX"),
                                rs.getString("LIBELLEEX"),
                                rs.getString("DUREERECUPERATIONEX"),
                                rs.getString("DUREEEX"), rs.getInt("NBREPETITIONEX"), rs.getString("LIENVIDEO")));
                j++;
            }
        } catch (SQLException ex) {
            System.out.println("Echec lors de l'écriture de la séance --> Erreur niveau SQL " + ex.getMessage());
        }

        //Fermeture de l'espace de requête
        try {
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de l'espace de "
                    + "requête " + ex.getMessage());
        }

        //Fermeture de l'espace d'exécution de la requête
        try {
            st.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de l'espace "
                    + "d'exécution de la requête " + ex.getMessage());
        }

        //Fermeture de la connexion à la base de données
        try {
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de la connexion à la "
                    + "base de données " + ex.getMessage());
        }
        return laseance;
    }

    /**
     * Procédure permettant de réaliser l'inscription sportive d'un utilisateur
     *
     * @param ps le profil sportif de l'utilisateur
     * @param codeu le code permettant d'identifier l'utilisateur
     * @throws SQLException
     */
    public void saisirProfilSportif(ProfilSportif ps, int codeu) throws SQLException {
        Statement st3;
        String sql3 = "SELECT CODEPS FROM MESURER WHERE CODEU='" + codeu + "'";
        st3 = cx.createStatement();
        ResultSet rs3 = st3.executeQuery(sql3); //resultat    

        while (rs3.next()) {
            int codeps = rs3.getInt("CODEPS");

            //espace de requêtes
            try {
                Statement st2;
                st2 = cx.createStatement();
                //requete sql

                String sql = "UPDATE PROFILSPORTIF" + " set TAILLE = '" + ps.getTaille()
                        + "',POIDS = '" + ps.getPoids() + "',HANCHE = '"
                        + ps.getHanche() + "', CUISSEGAUCHE = '" + ps.getCuisse() + "', BRASGAUCHE='"
                        + ps.getBras() + "', POITRINE = '" + ps.getPoitrine() + "' where CODEPS='" + codeps + "';";
                System.out.println(sql);
                int nb1 = st2.executeUpdate(sql);

                // System.out.println(sql);
            } catch (SQLException ex) {
                System.out.println("erreur" + ex.getMessage());
            }
        }
    }

    /**
     * Fonction permettant de récupérer le profil sportif d'un utilisateur
     *
     * @param codeu le code de l'utilisateur
     * @return le profil sportif de l'utilisateur
     * @throws SQLException
     */
    public ProfilSportif voirProfilSportif(int codeu) throws SQLException {
        ProfilSportif ps = null;
        Statement st3;
        String sql3 = "SELECT CODEPS FROM MESURER WHERE CODEU='" + codeu + "'";
        st3 = cx.createStatement();
        ResultSet rs3 = st3.executeQuery(sql3); //resultat    

        while (rs3.next()) {
            int codeps = rs3.getInt("CODEPS");

            //espace de requêtes
            try {
                Statement st2;
                st2 = cx.createStatement();
                //requete sql
                String sql2 = "SELECT TAILLE,POIDS,HANCHE,CUISSEGAUCHE,BRASGAUCHE,POITRINE FROM PROFILSPORTIF WHERE CODEPS='" + codeps + "'";
                st2 = cx.createStatement();
                ResultSet rs2 = st2.executeQuery(sql2); //resultat    
                while (rs2.next()) {
                    ps = new ProfilSportif(rs2.getString("TAILLE"), rs2.getString("POIDS"), rs2.getString("HANCHE"), rs2.getString("CUISSEGAUCHE"), rs2.getString("BRASGAUCHE"), rs2.getString("POITRINE"));

                }
                // System.out.println(sql);
            } catch (SQLException ex) {
                System.out.println("erreur" + ex.getMessage());
            }
        }

        return ps;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Fonction permettant de récupérer
     *
     * @param email l'email de l'utilisateur
     * @return
     * @throws SQLException
     */
    public String recupererUtiPG(String email) throws SQLException {
        String lstutipg = null;
        Statement st1;
        String sq = "select LIBELLEPT,NOMU,PRENOMU from AFFECTER AS A,UTILISATEUR AS U,PROGRAMMETYPE PT WHERE A.CODEU=U.CODEU AND A.CODEPT=PT.CODEPT AND U.MAILU='" + email + "'";
        st1 = cx.createStatement();
        ResultSet rs = st1.executeQuery(sq);
        // ArrayList<String> lstutipg = new ArrayList();
        if (rs.next()) {
            System.out.println(rs.getString("LIBELLEPT"));
            lstutipg = "<div class=\"section-header\">\n"
                    + "                        <h2 class=\"section-heading animated\" data-animation=\"bounceInUp\">" + rs.getString("NOMU") + " " + rs.getString("PRENOMU") + " </h2></div>"
                    + "<div class='row mar-bot40'><div class='col-md-offset-4 col-md-6'><h3> Est affecté au Programme " + rs.getString("LIBELLEPT") + "</h3></div></div>";
            System.out.println(lstutipg);
        } else {
            lstutipg = null;
        }
        return lstutipg;
    }

    /**
     * Fonction permettant d'affecter un CLIENT à un programme
     *
     * @param mail l'email du CLIENT à affecter
     * @param codept le code du programme auquel affecter le CLIENT
     * @throws SQLException
     */
    public void affecterCliPG(String mail, int codept) throws SQLException {
        int codeu = 0;
        Statement st1;
        String sq = "select CODEU from UTILISATEUR WHERE MAILU='" + mail + "'";
        System.out.println(sq);
        st1 = cx.createStatement();
        ResultSet rs = st1.executeQuery(sq);

        while (rs.next()) {
            codeu = rs.getInt("CODEU");

            //espace de requete
            Statement st;

            /*requete sql*/
            String sql1 = "INSERT INTO AFFECTER (CODEU,CODEPT) VALUES('" + codeu + "','" + codept + "');";
            /*ouverture de l'espace de requete*/
            System.out.println(sql1);
            st = cx.createStatement();
            //retourne le nombre de lignes modifiées
            int nb = st.executeUpdate(sql1);
        }
    }

    /**
     * Fonction permettant de récupérer le nom d'un programme à partir de son
     * code
     *
     * @param codept le code du programme
     * @return le nom du programme
     * @throws SQLException
     */
    public String trouverProgParCode(int codept) throws SQLException {
        String Prog = null;
        Statement st1;
        String sq = "select LIBELLEPT from PROGRAMMETYPE where CODEPT='" + codept + "'";
        st1 = cx.createStatement();
        ResultSet rs = st1.executeQuery(sq);
        while (rs.next()) {
            Prog = rs.getString("LIBELLEPT");
        }

        return Prog;

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Fonction permettant de r
     *
     * @param email l'email de l'utilisateur
     * @return
     * @throws SQLException
     */
    public ArrayList<String> recupererUtiPG2(String email) throws SQLException {
        Statement st1;
        String sq = "select PT.CODEPT,LIBELLEPT,NOMU,PRENOMU from AFFECTER AS A,UTILISATEUR AS U,PROGRAMMETYPE PT WHERE A.CODEU=U.CODEU AND A.CODEPT=PT.CODEPT AND U.MAILU='" + email + "'";
        st1 = cx.createStatement();
        ResultSet rs = st1.executeQuery(sq);
        ArrayList<String> lstutipg = new ArrayList<String>();
        if (rs.next()) {
            int codept = rs.getInt("CODEPT");
            lstutipg.add(String.valueOf(codept));
            lstutipg.add("<h2 class=\"section-heading animated\" data-animation=\"bounceInUp\">Vous êtes affecté au programme " + rs.getString("LIBELLEPT") + "</h2>\n"
                    + "                        </div>");
        } else {
            lstutipg = null;
        }
        return lstutipg;
    }

    /**
     * Fonction permettant de récupérer la liste de séances d'un programme
     *
     * @param codept le code du programme pour lequel on veut récupérer la liste
     * de sséances
     * @return la liste des séances du programme
     * @throws SQLException
     */
    public ArrayList<Seance> trouverSeanceParProg(int codept) throws SQLException {
        String type, seance, des;
        int codest, codets;
        Statement st1;
        String sq = "select ST.CODEST,ST.CODETS,LIBELLETS,LIBELLEST,DESCRIPTIONST,FCARDICIBLE,FCARDIREPO,ORDRES "
                + "from CONCERNER AS C, SEANCETYPE AS ST, TYPES AS TS  "
                + "where C.CODEST=ST.CODEST AND ST.CODETS=TS.CODETS AND C.CODEPT='" + codept + "' ORDER BY ORDRES";
        System.out.println(sq);
        st1 = cx.createStatement();
        ArrayList<Seance> listeSeance = new ArrayList<Seance>();
        ResultSet rs = st1.executeQuery(sq);
        while (rs.next()) {
            System.out.println("****" + rs.getString("LIBELLETS"));
            type = rs.getString("LIBELLETS");
            seance = rs.getString("LIBELLEST");
            codest = Integer.parseInt(rs.getString("CODEST"));
            codets = Integer.parseInt(rs.getString("CODETS"));
            des = rs.getString("DESCRIPTIONST");

            TypeS types = new TypeS(codets, type);
            Seance s = new Seance(codest, seance, des, types);

            listeSeance.add(s);
        }

        return listeSeance;
    }

    public Exercice obtenirInfoExo2(int codeEx) throws SQLException {
        String recupererExo = null;
        Exercice exoo = null;
        int CODEEX = 0;
        String LIBELLEEX = null;
        String DUREERECUPERATIONEX = null;
        String DUREEEX = null;
        int NBREPETITIONEX = 0;
        String DESCRIPTIONEX = null;
        String OBJECTIFEX = null;
        String LIENVIDEO = null;

        //Espace d'exécution de la requête
        Statement st = null;
        st = cx.createStatement();
        recupererExo = "SELECT CODEEX, LIBELLEEX, DUREERECUPERATIONEX, DUREEEX,DESCRIPTIONEX,"
                + " OBJECTIFEX,NBREPETITIONEX,LIENVIDEO FROM EXERCICE WHERE CODEEX = " + codeEx + ";";
        ResultSet rs = null;
        rs = st.executeQuery(recupererExo);

        if (rs.next()) {
            System.out.println("connect ok");
            CODEEX = rs.getInt("CODEEX");
            LIBELLEEX = rs.getString("LIBELLEEX");
            DUREERECUPERATIONEX = rs.getString("DUREERECUPERATIONEX");
            DUREEEX = rs.getString("DUREEEX");
            NBREPETITIONEX = rs.getInt("NBREPETITIONEX");
            DESCRIPTIONEX = rs.getString("DESCRIPTIONEX");
            OBJECTIFEX = rs.getString("OBJECTIFEX");
            LIENVIDEO = rs.getString("LIENVIDEO");

        }

        exoo = new Exercice(CODEEX, LIBELLEEX, DESCRIPTIONEX, LIENVIDEO, DUREERECUPERATIONEX, DUREEEX, NBREPETITIONEX, OBJECTIFEX);

        return exoo;
    }

}
