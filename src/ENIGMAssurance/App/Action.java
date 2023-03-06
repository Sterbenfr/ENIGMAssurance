package ENIGMAssurance.App;
class Action extends Produit {
    double dividende;

    Action(String nom, double prix, int quantite, double dividende) {
        super(nom, prix, quantite);
        this.dividende = dividende;
    }
}
