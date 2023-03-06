package ENIGMAssurance.App;
class Obligation extends Produit {
    double interet;

    Obligation(String nom, double prix, int quantite, double interet) {
        super(nom, prix, quantite);
        this.interet = interet;
    }
}
