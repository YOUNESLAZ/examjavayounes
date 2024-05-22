
import java.time.LocalDate;
import java.util.Scanner;

interface Paiement {

    void payer(double montant);
}

abstract class CarteDeCredit implements Paiement {

    private String numeroCarte;
    private LocalDate dateExpiration;

    public CarteDeCredit(String numeroCarte, LocalDate dateExpiration) {
        this.numeroCarte = numeroCarte;
        this.dateExpiration = dateExpiration;
    }

    public String getNumeroCarte() {
        return numeroCarte;
    }

    public void setNumeroCarte(String numeroCarte) {
        this.numeroCarte = numeroCarte;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    @Override
    public String toString() {
        return "CarteDeCredit{"
                + "numeroCarte='" + numeroCarte + '\''
                + ", dateExpiration=" + dateExpiration
                + '}';
    }
}

class Visa extends CarteDeCredit {

    public Visa(String numeroCarte, LocalDate dateExpiration) {
        super(numeroCarte, dateExpiration);
    }

    @Override
    public void payer(double montant) {
        System.out.println("Paiement de " + montant + " avec la carte Visa.");
    }
}

class Mastercard extends CarteDeCredit {

    public Mastercard(String numeroCarte, LocalDate dateExpiration) {
        super(numeroCarte, dateExpiration);
    }

    @Override
    public void payer(double montant) {
        System.out.println("Paiement de " + montant + "  avec la carte Mastercard.");
    }
}

class Express extends CarteDeCredit {

    public Express(String numeroCarte, LocalDate dateExpiration) {
        super(numeroCarte, dateExpiration);
    }

    @Override
    public void payer(double montant) {
        System.out.println("Paiement de " + montant + "  avec la carte Express.");
    }
}

public class TraitementPaiement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("donner le type de carte  ");
        String typeCarte = scanner.nextLine();
        System.out.print("donner le numéro de carte  ");
        String numeroCarte = scanner.nextLine();
        System.out.print("donner la date d'expiration  ");
        LocalDate dateExpiration = LocalDate.parse(scanner.nextLine());
        System.out.print("donner le montant à payer  ");
        double montant = scanner.nextDouble();
        CarteDeCredit carte;
        switch (typeCarte) {
            case "Mastercard":
                carte = new Mastercard(numeroCarte, dateExpiration);
                break;
            case "Express":
                carte = new Express(numeroCarte, dateExpiration);
                break;
            case "Visa":
                carte = new Visa(numeroCarte, dateExpiration);
                break;
            default:
                System.out.println("Type de carte n'existe pas");
                return;
        }

        carte.payer(montant);
        System.out.println(carte);
    }
}
