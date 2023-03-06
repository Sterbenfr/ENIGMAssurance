package ENIGMAssurance.App;
class Produit {
    String nom;
    double prix;
    int quantite;

    Produit(String nom, double prix, int quantite) {
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    public void setQuantite(int quantite2) {
        this.quantite += quantite2;
    }
}
