package personnages;

public class Druide {
    private String nom;
    private int force;
    private Chaudron chaudron;

    public Druide(String nom, int force) {
        this.nom = nom;
        this.force = force;
        this.chaudron = new Chaudron(); 
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "\"" + texte + "\"");
    }

    private String prendreParole() {
        return "Le Druide " + nom + " : "; 
    }

    public void fabriquerPotion(int quantite, int forcePotion) {
        chaudron.remplirChaudron(quantite, forcePotion);
        parler("J'ai concocté " + quantite + " doses de potion magique. Elle a une force de " + forcePotion + "."); 
    }

    public void booster(Gaulois gaulois) {
        if ("Obélix".equals(gaulois.getNom())) { 
            parler("Non, " + gaulois.getNom() + " Non!... Et tu le sais très bien !"); 
        } else if (chaudron.resterPotion()) {
            int forcePotion = chaudron.prendreLouche(); 
            gaulois.boirePotion(forcePotion); 
            parler("Tiens " + gaulois.getNom() + " un peu de potion magique."); 
        } else {
            parler("Désolé " + gaulois.getNom() + " il n'y a plus une seule goutte de potion.");
        }
    }
}
