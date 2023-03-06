package ENIGMAssurance.App;
import java.util.ArrayList;
import java.util.Objects;

class Portefeuille {
    ArrayList<Produit> produits;


    Portefeuille() {
        produits = new ArrayList<>();
    }

    /* affiche le portefeuille complet*/
    void afficherPortefeuille(){
        for (Produit produit : produits){
            if (produit instanceof Action){
                System.out.println(produit.nom + ", quantite : " + produit.quantite + ", prix : " + produit.prix + ", dividende : " + ((Action) produit).dividende);
            }
            if (produit instanceof Obligation){
                System.out.println(produit.nom + ", quantite : " + produit.quantite + ", prix : " + produit.prix + ", Interet : " + ((Obligation) produit).interet);
            }
        }
    }

    /*pour avoir les noms de produits dans le portefeuille dans d'autres fonction*/

    void printPortefeuille(){
        int last = produits.size();
        for (Produit produit : produits){
            if (produit == produits.get(last-1)){
                System.out.print(produit.nom);
            }else {
                System.out.print(produit.nom + ", ");
            }

        }
    }

    /* ajouter une quantite a un produit*/
    void ajouterAUnProduit(String name,int Combien){
        for (Produit produit : produits) {
            if (Objects.equals(produit.nom, name)){
                produit.setQuantite(Combien);
            }
        }
    }
    /*Supprimer un produit d'un portefeuille*/
    void supprimerAUnProduit(String name,int Combien){
        for (Produit produit : produits) {
            if (Objects.equals(produit.nom, name)){
                produit.setQuantite(-Combien);
            }
        }
    }

    /*Ajouter un produit au portefeuille*/
    void ajouterDesProduit(Produit produit) {
        produits.add(produit);
    }


    void clear(){
            produits.clear();
    }

    /*savoir si le nom donner est bien un produit existant*/
    boolean produitExist(String name){
        for (Produit produit : produits){
            if (Objects.equals(produit.nom, name)){
                return true;
            }
        }
        return false;
    }

    void supprimerUnProduit(String name){
        produits.removeIf(produit -> Objects.equals(produit.nom, name));
    }

    double valeurTotale() {
        double valeurTotale = 0;
        for (Produit produit : produits) {
            valeurTotale += produit.prix * produit.quantite;
        }
        return valeurTotale;
    }
}
