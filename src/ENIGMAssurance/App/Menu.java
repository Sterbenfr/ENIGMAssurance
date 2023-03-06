package ENIGMAssurance.App;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Client> clients = new ArrayList<>();

        while (true) {
            afficherMenu();

            int choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:
                    creerClient(clients, sc);
                    break;
                case 2:
                    ajouterProduit(clients, sc);
                    break;
                case 3:
                    afficherValeurTotale(clients, sc);
                    break;
                case 4:
                    addAUnProduit(clients,sc);
                    break;
                case 5:
                    clearPortefeuille(clients,sc);
                    break;
                case 6:
                    supprimerProduit(clients,sc);
                    break;
                case 7:
                    supprAUnProduit(clients,sc);
                    break;
                case 8:
                    affPortefeuille(clients,sc);
                    break;
                case 9:
                    System.out.println("Au revoir !");
                    return;
                default:
                    System.out.println("Choix invalide.");
                    break;
            }
        }
    }

    /* Selection des options*/
    private static void afficherMenu() {
        System.out.println("Que souhaitez-vous faire ?");
        System.out.println("1-Créer un nouveau client");
        System.out.println("2-Ajouter un produit à un portefeuille");
        System.out.println("3-Afficher la valeur totale d'un portefeuille");
        System.out.println("4-Ajouter une quantitée a un produit déja existant");
        System.out.println("5-Clear un portefeuille");
        System.out.println("6-Supprimer un produit");
        System.out.println("7-Supprimer une quantitée a un produit déja existant");
        System.out.println("8-Afficher un portefeuille");
        System.out.println("9-Quitter");
    }

    /*Ajouter un client*/
    private static void creerClient(ArrayList<Client> clients, Scanner sc) {
        System.out.println("Nom du nouveau client :");
        String nomClient = sc.nextLine();
        Client client = new Client(nomClient);
        clients.add(client);
        System.out.println("Le client " + nomClient + " a été créé.");
    }

    /*Supprimer un produit d'un portefeuille*/
    private static void supprimerProduit(ArrayList<Client> clients,Scanner sc){
        System.out.println("Nom du client");
        String nomClient = sc.nextLine();
        Client client5 = trouverClient(clients,nomClient);
        if (client5 == null) {
            System.out.println("Le client " + nomClient + " n'existe pas.");
            return;
        }
        System.out.println("Quel produit souhaitez-vous supprimer ?");
        client5.portefeuille.printPortefeuille();
        String quelProduit = sc.nextLine();
        if (client5.portefeuille.produitExist(quelProduit)){
            client5.portefeuille.supprimerUnProduit(quelProduit);
        }
        else{
            System.out.println("Produit inconnu");
            return;
        }
    }

    /*Supprimer le portefeuille complet d'un client*/
    private static void clearPortefeuille(ArrayList<Client> clients,Scanner sc){
        System.out.println("Nom du client qui vide son portefeuille");
        String nomClient = sc.nextLine();
        Client client4 = trouverClient(clients,nomClient);
        if (client4 == null) {
            System.out.println("Le client " + nomClient + " n'existe pas.");
            return;
        }
        System.out.println("Etes-vous sur ?");
        System.out.println("y ou n");
        String sur = sc.nextLine();
        if (sur.equals("y")){
            client4.portefeuille.clear();
        }else if(sur.equals("n")){
            return;
        }else {
            System.out.println("Cette commande n'est pas reconnue");
            return;
        }
    }

/* enlever une quantitée a un produit*/
    static void supprAUnProduit(ArrayList<Client> clients,Scanner sc){
        System.out.println("Nom du client :");
        String nomClient3 = sc.nextLine();
        Client client3 = trouverClient(clients, nomClient3);

        if (client3 == null) {
            System.out.println("Le client " + nomClient3 + " n'existe pas.");
            return;
        }
        System.out.println("A quel produit souhaitez-vous enlever ?");
        client3.portefeuille.printPortefeuille();
        String quelProduit = sc.nextLine();
        if (client3.portefeuille.produitExist(quelProduit)){
            System.out.println("Combien souhaitez-vous enlever ?");
            int nbProduit = sc.nextInt();

            client3.portefeuille.supprimerAUnProduit(quelProduit,nbProduit);

            System.out.println(nbProduit + " ont bien été enlever à : " + quelProduit);
        }
        else{
            System.out.println("Produit inconnu");
            return;
        }

    }

    /* ajouter une quantite a un produit*/
    static void addAUnProduit(ArrayList<Client> clients,Scanner sc){
        System.out.println("Nom du client :");
        String nomClient3 = sc.nextLine();
        Client client3 = trouverClient(clients, nomClient3);

        if (client3 == null) {
            System.out.println("Le client " + nomClient3 + " n'existe pas.");
            return;
        }
        System.out.println("A quel produit souhaitez-vous ajouter ?");
        client3.portefeuille.printPortefeuille();
        String quelProduit = sc.nextLine();
        if (client3.portefeuille.produitExist(quelProduit)){
            System.out.println("Combien souhaitez-vous ajouter ?");
            int nbProduit = sc.nextInt();

            client3.portefeuille.ajouterAUnProduit(quelProduit,nbProduit);

            System.out.println(nbProduit + " ont bien été ajouter à : " + quelProduit);
        }
        else{
            System.out.println("Produit inconnu");
            return;
        }
    }

    /*Ajouter un produit au portefeuille*/
    private static void ajouterProduit(ArrayList<Client> clients, Scanner sc) {
        System.out.println("Nom du client :");
        String nomClient2 = sc.nextLine();
        Client client2 = trouverClient(clients, nomClient2);

        if (client2 == null) {
            System.out.println("Le client " + nomClient2 + " n'existe pas.");
            return;
        }

        System.out.println("Que souhaitez-vous ajouter ?");
        System.out.println("1. Une action");
        System.out.println("2. Une obligation");
        int choixProduit = sc.nextInt();
        sc.nextLine();

        System.out.println("Nom du produit :");
        String nomProduit = sc.nextLine();

        System.out.println("Prix unitaire :");
        double prix = sc.nextDouble();

        System.out.println("Quantité :");
        int quantite = sc.nextInt();

        switch (choixProduit) {
            case 1:
                System.out.println("Dividende :");
                double dividende = sc.nextDouble();
                Action action = new Action(nomProduit, prix, quantite, dividende);
                client2.portefeuille.ajouterDesProduit(action);
                System.out.println("L'action " + nomProduit + " a été ajoutée au portefeuille de " + nomClient2 + ".");
                break;
            case 2:
                System.out.println("Intérêt :");
                double interet = sc.nextDouble();
                Obligation obligation = new Obligation(nomProduit, prix, quantite, interet);
                client2.portefeuille.ajouterDesProduit(obligation);
                System.out.println("L'obligation " + nomProduit + " a été ajoutée au portefeuille de " + nomClient2 + ".");
                break;
            default:
                System.out.println("Choix invalide.");
                break;
        }
    }

    /*affiche la valeure du portefeuille*/
    private static void afficherValeurTotale(ArrayList<Client> clients, Scanner sc) {
        System.out.println("Nom du client :");
        String nomClient3 = sc.nextLine();
        Client client3 = trouverClient(clients, nomClient3);

        if (client3 == null) {
            System.out.println("Le client " + nomClient3 + " n'existe pas.");
            return;
        }

        double valeurTotale = client3.portefeuille.valeurTotale();
        System.out.println("La valeur totale d'achat du portefeuille de " + nomClient3 + " est de " + valeurTotale + " euros.");
    }

    private static Client trouverClient(ArrayList<Client> clients, String nomClient) {
        for (Client client : clients) {
            if (client.nom.equals(nomClient)) {
                return client;
            }
        }
        return null;
    }

    /* affiche le portefeuille complet*/
    private static void affPortefeuille(ArrayList<Client> clients,Scanner sc){
        System.out.println("Nom du client :");
        String nomClient3 = sc.nextLine();
        Client client3 = trouverClient(clients, nomClient3);
        if (client3 == null) {
            System.out.println("Le client " + nomClient3 + " n'existe pas.");
            return;
        }
        System.out.println("Le portefeuille de "+nomClient3);
        client3.portefeuille.afficherPortefeuille();
    }
}