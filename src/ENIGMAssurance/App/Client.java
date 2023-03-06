package ENIGMAssurance.App;
class Client {
    String nom;
    Portefeuille portefeuille;

    Client(String nom) {
        this.nom = nom;
        portefeuille = new Portefeuille();
    }
}
