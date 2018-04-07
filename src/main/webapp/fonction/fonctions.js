/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getXMLHttpRequest()
{
    var xhr = null;

    // Firefox et bien d'autres.
    if (window.XMLHttpRequest)
        xhr = new XMLHttpRequest();
    else

    // Internet Explorer.
    if (window.ActiveXObject)
    {
        try {
            xhr = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e)
        {
            xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }

    // XMLHttpRequest non supporté.
    else
    {
        alert("Votre navigateur ne supporte pas l'objet XmlHttpRequest.");
        xhr = false;
    }

    return xhr;
}


function checkEmail(Formulaires) {
    if (Formulaires.mail1.value !== theForm.mail2.value)
    {
        alert('Those emails don\'t match!');
        return false;
    } else {
        return true;
    }
}

function affichercontenuProg(i){
        
    var elt = document.getElementById("ajoutS"+i+"");  
    elt.hidden=false ; 
    
    var elt2 = document.getElementById("btnAff"+i+"");  
    elt2.hidden=true ;
    
   
}

function affbtn(i){
        j= i+1 ; 
    var X = document.getElementById("btnAff"+j+"");  
        X.hidden=false ;
    }

function affichercontenuProg2(){
    var elt3 = document.getElementById("ajoutS2");  
    elt3.hidden=false ; 
    
    var elt4 = document.getElementById("btnAff2");  
    elt4.hidden=true ;
    
}

function encodageURL (lien){
    
    var res = encodeURIComponent(lien);
    
    var eltEnAttente = document.getElementById("id");
            
            eltEnAttente.innerHTML = res ;
  
}


function liste_Client_EnAttente() {
    requeteXML = new XMLHttpRequest();
    requeteXML.onreadystatechange = function ()
    {
        //Si l'on a tout reçu et que la requête http s'est bien passée.
        if (requeteXML.readyState === 4 && requeteXML.status === 200) {
            listeEnAttente = chargerListeClient(requeteXML.responseXML);

            var eltEnAttente = document.getElementById("clientEnAttente");

            eltEnAttente.innerHTML = listeEnAttente;
        }
    };
    // Requête au serveur avec les paramètres éventuels.
    requeteXML.open("GET", "ServletListerClientStatut?statut=EN ATTENTE", true);
    requeteXML.send(null);
}

function liste_Client_Potentiel() {
    requeteXML = new XMLHttpRequest();
    requeteXML.onreadystatechange = function ()
    {
        //Si l'on a tout reçu et que la requête http s'est bien passée.
        if (requeteXML.readyState === 4 && requeteXML.status === 200) {
            listePotentiel = chargerListeClient(requeteXML.responseXML);

            var eltPotentiel = document.getElementById("clientPotentiel");

            eltPotentiel.innerHTML = listePotentiel;
        }
    };
    // Requête au serveur avec les paramètres éventuels.
    requeteXML.open("GET", "ServletListerClientStatut?statut=POTENTIEL", true);
    requeteXML.send(null);
}

function liste_Client_Abonne() {
    requeteXML = new XMLHttpRequest();
    requeteXML.onreadystatechange = function ()
    {
        //Si l'on a tout reçu et que la requête http s'est bien passée.
        if (requeteXML.readyState === 4 && requeteXML.status === 200) {
            listeAbonne = chargerListeAbonne(requeteXML.responseXML);

            var eltAbonne = document.getElementById("clientValider");
            eltAbonne.innerHTML = listeAbonne;
        }
    };
    // Requête au serveur avec les paramètres éventuels.
    requeteXML.open("GET", "ServletListerClientStatut?statut=VALIDE", true);
    requeteXML.send(null);
}

function chargerListeClient(listeClientXML) {
    var i, client, liste, user, utilisateur;

    liste = "<table>";
    liste = liste + "<th> Nom </th>";
    liste = liste + "<th> Prenom </th>";
    liste = liste + "<th> Statut </th>";
    liste = liste + "<th> Date d'inscription </th>";
    liste = liste + "<th> Modifier </th>";
    liste = liste + "<tr>";

    client = listeClientXML.getElementsByTagName("utilisateur");
    for (i = 0; i < client.length; i++) {
        user = client[i].firstChild.nodeValue;
        utilisateur = user.split("|");
        liste = liste + "<td>" + utilisateur[0] + "</td>";
        liste = liste + "<td>" + utilisateur[1] + "</td>";
        liste = liste + "<td>" + utilisateur[2] + "</td>";
        liste = liste + "<td>" + utilisateur[3] + "</td>";
        liste = liste + "<td> <input type = 'radio' name ='email' value = '" +
                utilisateur[4] + "' checked> </td>";
        liste = liste + "</tr>";
    }
    liste = liste + "</table>";

    return liste;
}

function chargerListeAbonne(listeClientXML) {
    var i, client, liste, user, utilisateur;

    liste = "<table>";
    liste = liste + "<th> Nom </th>";
    liste = liste + "<th> Prénom </th>";
    liste = liste + "<th> Statut </th>";
    liste = liste + "<th> Date d'inscription </th>";
    liste = liste + "<th> Supprimer </th>";

    client = listeClientXML.getElementsByTagName("utilisateur");
    for (i = 0; i < client.length; i++) {
        user = client[i].firstChild.nodeValue;
        utilisateur = user.split("|");
        if (utilisateur[5].toString() === "last") {
            liste = liste + "<tr bgcolor='yellow'>";
        } else {
            liste = liste + "<tr>"
        }
        liste = liste + "<td>" + utilisateur[0] + "</td>";
        liste = liste + "<td>" + utilisateur[1] + "</td>";
        liste = liste + "<td>" + utilisateur[2] + "</td>";
        liste = liste + "<td>" + utilisateur[3] + "</td>";
        liste = liste + "<td> <input type = 'radio' name ='email' value = '" +
                utilisateur[4] + "' checked> </td>";
        liste = liste + "</tr>";
    }
    liste = liste + "</table>";

    return liste;
}

function verifMDP(mdp1) {

    var i = document.getElementById("ou");
    i.innerHTML = "blablablablablabla";

    mdp2 = document.getElementById("mdpancien");
    
    
    if (mdp1 == mdp2) {

        var elt = document.getElementById("eunice");
        var elt = document.getElementById("bouton");
        elt.innerHTML = "mot de passe similaire"
    } else {
//.disabled = true
        var elt = document.getElementById("bouton");
        elt.innerHTML = "mot de passe pas similaire";

    }

}

function supprimerclient() {
    var decision;
    decision = confirm("Etes-vous sur de vouloir supprimer le client?");
    if (decision === true) {
        return true;
    } else {
        return false;
    }
}

function verifierInscription() {
    var nom, prenom, daten, tel, email1, email2, mdp, autorise;
    nom = document.getElementById("nom").value;
    prenom = document.getElementById("prenom").value;
    daten = document.getElementById("date").value;
    tel = document.getElementById("tel").value;
    email1 = document.getElementById("mail1").value;
    email2 = document.getElementById("mail2").value;
    mdp = document.getElementById("mdp").value;

    autorise = true;

    if (!verifierEspaceText(nom)) {
        alert('Saisir un nom valide.');
        autorise = false;
    }
    if (!verifierEspaceText(prenom)) {
        alert('Saisir un prenom valide.');
        autorise = false;
    }
    if (!verifierEspaceText(mdp)) {
        alert('Saisir un mot de passe valide.');
        autorise = false;
    }
    if (email1 !== email2) {
        alert('Votre deuxième adresse email ne correspond pas au premier.');
        autorise = false;
    }

    return autorise;
}

function verifierEspaceText(texte) {
    if (texte.replace(" ", "").length > 0) {
        return true;
    } else {
        return false;
    }
}

function controlDateNaissance() {
    var today, dd, mm, yyyy, pastyyy, past;

    today = new Date();
    dd = today.getDate();
    mm = today.getMonth() + 1;
    yyyy = today.getFullYear();
    pastyyy = yyyy - 120;
    if (dd < 10) {
        dd = '0' + dd
    }
    if (mm < 10) {
        mm = '0' + mm
    }

    today = yyyy + '-' + mm + '-' + dd;
    past = pastyyy + '-' + mm + '-' + dd;
    document.getElementById("date").setAttribute("max", today);
    document.getElementById("date").setAttribute("min", past);
}

//RECUPERATION DU TYPE DES SEANCES
function recupererTypeSeance() {
    requeteXML = new XMLHttpRequest();
    requeteXML.onreadystatechange = function () {
        //Si l'on a tout reçu et que la requête http s'est bien passée.
        if (requeteXML.readyState === 4 && requeteXML.status === 200) {
            listeTypeS = chargerListeTypeS(requeteXML.responseXML);

            var elt = document.getElementById("typeS");
            elt.innerHTML = listeTypeS;
            ajouterExo();
        }
    };
    //Requête au serveur.
    requeteXML.open("GET", "ServletListerTypeS", true);
    requeteXML.send(null);
}

//CHARGEMENT DU TYPE DES SEANCES POUR AFFICHAGE
function chargerListeTypeS(listeTypeSeanceXML) {
    var liste, type, typeseance;
    liste = "";
    type = listeTypeSeanceXML.getElementsByTagName("typeseance");
    for (i = 0; i < type.length; i++) {
        typeseance = type[i].firstChild.nodeValue;
        seance = typeseance.split("|");
        liste = liste + "<option selected value='" + seance[0] + "'>" + seance[1] + "</option>";
    }
    return liste;
}

//AJOUT D'UN EXERCICE A LA SEANCE
function ajouterExo() {
    var partieExo, choixExo, contenu;

    requeteXML = new XMLHttpRequest();
    requeteXML.onreadystatechange = function () {
        //Si l'on a tout reçu et que la requête http s'est bien passée.
        if (requeteXML.readyState === 4 && requeteXML.status === 200) {
            listeExo = chargerListeExo(requeteXML.responseXML);

            choixExo = document.getElementById("choixExo");
            content = choixExo.innerHTML + listeExo;
            choixExo.innerHTML = content;
        }
    };
    //Requête au serveur.
    requeteXML.open("GET", "ServletListeExo", true);
    requeteXML.send(null);
}

//CHERGEMENT DES EXERCICES POUR AFFICHAGE
function chargerListeExo(listeExoXML) {
    var liste, exo, infoexo, exercice;

    choixExo = document.getElementById("choixExo");
    idExo = choixExo.innerHTML.split("Choisir").length;

    exo = listeExoXML.getElementsByTagName("exo");
    liste = "<div id='divExo" + idExo + "'>";
    liste = liste + "<h2 id='ordre" + idExo + "'>Exercice " + idExo + " </h2>";
    liste = liste + "<p> Choisir exercice : ";
    liste = liste + "<select id='select" + idExo + "' onchange='recupererInfoExo(" + idExo + ",this.value)' required>";
    liste = liste + "<option value='' selected>Exercice</option>"
    for (i = 0; i < exo.length; i++) {
        infoexo = exo[i].firstChild.nodeValue;
        exercice = infoexo.split("|");
        liste = liste + "<option value='" + exercice[0] + "'>"
                + exercice[1] + "</option>";
    }
    liste = liste + "</select>";
    liste = liste + "</p>";
    liste = liste + "<div id='divInfo" + idExo + "'></div>";
    if (idExo > 1) {
        liste = liste + "<input type='button' value='Retirer cet exercice de la seance' onclick='retirerExo(" + idExo + ")'";
    }
    liste = liste + "</div>";
    return liste;
}

//RECUPERATION DES INFORMATIONS SUR L'EXERCICE CHOISI
function recupererInfoExo(ordre, valeur) {
    var exercice;
    requeteXML = new XMLHttpRequest();
    exercice = "exercice=" + valeur;
    requeteXML.onreadystatechange = function () {
        //Si l'on a tout reçu et que la requête http s'est bien passée.
        if (requeteXML.readyState === 4 && requeteXML.status === 200) {
            infoExo = chargerInfoExo(requeteXML.responseXML);

            selectModifier = document.getElementById("select" + ordre);
            selectModifierTexte = selectModifier.innerHTML;
            selectModifierReinitialiser = selectModifierTexte.replace("selected=\"\"", " ");
            newSelect = selectModifierReinitialiser.replace("option value=\"" + valeur + "\"", "option value=\"" + valeur + "\" selected");
            selectModifier.innerHTML = newSelect;

            var elt = document.getElementById("divInfo" + ordre);
            elt.innerHTML = infoExo;
        }
    };
    //Requête au serveur.
    requeteXML.open("GET", "ServletInfoExo?" + exercice, true);
    requeteXML.send(null);
}

//CHARGEMENT DES INFORMATIONS DE L'EXERCICE CHOISI
function chargerInfoExo(infoExoXML) {
    var liste, exo, infoexo, exercice;

    exo = infoExoXML.getElementsByTagName("information");
    infoexo = exo[0].firstChild.nodeValue;
    exercice = infoexo.split("|");
    liste = "<p>Duree de recuperation : " + exercice[0] + "</p>";
    liste = liste + "<p>Duree de l'exercice : " + exercice[1] + "</p>";
    liste = liste + "<p>Nombre de repetition : " + exercice[2] + "</p>";
    return liste;
}

//RETIRER UN EXERCICE D'UNE SEANCE
function retirerExo(ordre) {
    var listeExo, exosup, i, choixExo, nbExo, divExo;
    var ordre, exercice, select, recuperer, divInfo, retirer;

    //Recupération du nombre d'exercice de la séance
    choixExo = document.getElementById("choixExo");
    nbExo = choixExo.innerHTML.split("Choisir").length;

    //Suppression de l'exercice
    exosup = document.getElementById("divExo" + ordre);
    exosup.parentNode.removeChild(exosup);

    //Si on supprime un exercice qui est suivi par d'autres exercice
    //Alors on décale les exercices qui le suivent
    if (nbExo - 1 > ordre) {
        for (i = ordre; i < nbExo; i++) {
            j = i + 1;
            //Repercusion de la suppression de l'exercice
            listeExo = choixExo.innerHTML;
            divExo = listeExo.replace("divExo" + j, "divExo" + i);
            ordre = divExo.replace("ordre" + j, "ordre" + i);
            exercice = ordre.replace("Exercice " + j, "Exercice " + i);
            select = exercice.replace("select" + j, "select" + i);
            recuperer = select.replace("recupererInfoExo(" + j, "recupererInfoExo(" + i);
            divInfo = recuperer.replace("divInfo" + j, "divInfo" + i);
            retirer = recuperer.replace("retirerExo(" + j, "retirerExo(" + i);

            //Modification du script pou prendre en compte les répercussions
            choixExo.innerHTML = retirer;
        }
    }
}

//CREATION DE LA SEANCE DANS LA BD
function creerSeance() {
    requeteXML = new XMLHttpRequest();
    var titre = "titre=" + document.getElementById("titreS").value;
    var type = "type=" + document.getElementById("typeS").value;
    var description = "description=" + document.getElementById("descriptionS").value;
    var listeExo = "listeExo=";

    //Recupération du nombre d'exercice de la séance
    choixExo = document.getElementById("choixExo");
    nbExo = choixExo.innerHTML.split("Choisir").length;

    for (i = 1; i < nbExo; i++) {
        listeExo = listeExo + document.getElementById("select" + i).value + "_";
    }

    requeteXML.onreadystatechange = function () {
        //Si l'on a tout reçu et que la requête http s'est bien passée.
        if (requeteXML.readyState === 4 && requeteXML.status === 200) {
            window.open('pageCoach.jsp', "_self");
        }
    };

    // Requête au serveur avec les paramètres éventuels.
    requeteXML.open("GET", "ServletCreateSeance" + "?" + titre + "&" + type
            + "&" + description + "&" + listeExo.toString(), true);
    requeteXML.send(null);
}

//ALLER A LA PAGE DE CREATION D'EXERCICE OU DE SEANCE
function goToCreationPage(provenance) {
      if (provenance === "listeSeance") {
        window.open('creationSeance.jsp?provenance=listeSeance', '_self');
    } else if (provenance === "seance") {
        window.open('creationExercice.jsp?provenance=seance', '_blank');
    } else if (provenance === "listeExercice") {
        window.open('creationExercice.jsp?provenance=listeExercice', '_self');
    }else{
         window.open('creationSeance.jsp?provenance=programme', '_blank');
    }
}

//ANNULER LA CREATION D'UNE SEANCE
function annulerCreerSeance(provenance) {
    if (provenance === "listeSeance") {
        window.open('listeTtClient.html', "_self");
    } else {
        window.close();
    }
}

//RECUPERATION DES SEANCES EXISTANTES
function recuperationSeance() {
    requeteXML = new XMLHttpRequest();
    requeteXML.onreadystatechange = function () {
        //Si l'on a tout reçu et que la requête http s'est bien passée.
        if (requeteXML.readyState === 4 && requeteXML.status === 200) {
            listSeance = chargerListeSeance(requeteXML.responseXML);
            var elt = document.getElementById("listeSeance");
            elt.innerHTML = listSeance;
        }
    };
    //Requête au serveur.
    requeteXML.open("GET", "ServletListerSeance", true);
    requeteXML.send(null);
}

//CHARGEMENT DES SEANCES EXISTANTES
function chargerListeSeance(listeSeanceXML) {
    var i, seance, theseance, laseance, liste;
    liste = "<div>";
    seance = listeSeanceXML.getElementsByTagName("seance");
    if (seance.length > 0) {
        for (i = 0; i < seance.length; i++) {
            theseance = seance[i].firstChild.nodeValue;
            laseance = theseance.split("|");
            liste = liste + "<p>";
            liste = liste + "<input type='radio' name='seanceChoisie' value='" + laseance[0] + "' checked>";
            liste = liste + " " + laseance[1];
            liste = liste + "</p><br>";
        }
        liste = liste + "</div>";
    } else {
        liste = liste + "<p onclick='goToCreationPage('listeSeance')'>Il n'existe pas encore de séance, voulez vous en créer une?</a></p>";
    }

    return liste;
}

function inscrireUtilisateur(){
    var xhr = getXMLHttpRequest();
    
    var genre = "genre=" + document.getElementById("genre").value;
    var nom = "nom=" + document.getElementById("nom").value;
    var prenom = "prenom=" + document.getElementById("prenom").value;
    var date = "date=" + document.getElementById("date").value;
    var tel = "tel=" + document.getElementById("tel").value;
    var mail1 = "mail1=" + document.getElementById("mail1").value;
     var mail2 = "mail2=" + document.getElementById("mail2").value;
     var mdp = "mdp=" + document.getElementById("mdp").value;
     var obj = "obj=" + document.getElementById("obj").value;
     
   
            var elt = document.getElementById("eunice");
            elt.innerHTML = "sssssssssssssssssssss"
            
     
      requeteXML.onreadystatechange = function ()
    {
        //Si l'on a tout reçu et que la requête http s'est bien passée.
        if (requeteXML.readyState === 4 && requeteXML.status === 200) {

            var elt = document.getElementById("eunice");
            elt.innerHTML = "sssssssssssssssssssss"        
        }
    };
     

    xhr.open("GET", "ServletInscriptionUtilisation?genre=" + genre & "?nom="+ nom & "?prenom=" + prenom  & "?datenaissance=" + date & "?tel="+tel & "?mail1=" + mail1 & "?mdp=" + mdp & "?obj=" + obj);
    requeteXML.send(null);
    
     
}