import java.util.Scanner;

public class Torneo {
    static String nombreTorneo;

    public static void main(String[] args) {

        jugarTorneo();
    }

    public static String nombrarTorneo() {
        System.out.println("Nombre del torneo");
        Scanner nombre = new Scanner(System.in);

        nombreTorneo = nombre.nextLine();
        System.out.println("El nombre del torneo es: " + nombreTorneo);
        return nombreTorneo;

    }
    public static void revancha() {

        System.out.println("Desea jugar la revancha? S/N");
        Scanner scanner = new Scanner(System.in);
        String respuestaRevancha = scanner.nextLine();

        if (respuestaRevancha.equals("S")) {
            jugarTorneo();
        }

    }

    public static void jugarTorneo() {
        nombreTorneo = nombrarTorneo();

        Jugador jugadorA = new Jugador();
        Jugador jugadorB = new Jugador();

        System.out.println("Nombre del jugador A: " + jugadorA.nombreDelJugador);
        System.out.println("Nombre del jugador B: " + jugadorB.nombreDelJugador);

        System.out.println("Probabilidad de ganar del jugador A: " + jugadorA.probabilidadDelJugador);
        System.out.println("Probabilidad de ganar del jugador B: " + jugadorB.probabilidadDelJugador);

        Sets sets = new Sets(
                jugadorA.nombreDelJugador,
                jugadorA.probabilidadDelJugador,
                jugadorB.nombreDelJugador,
                jugadorB.probabilidadDelJugador);


        boolean ganador = sets.jugarSets();

        if (ganador) {
            System.out.println("El ganador del torneo "+ nombreTorneo + " es " + jugadorA.nombreDelJugador + ". ¡FELICITACIONES!");
            revancha();
        } else {
            System.out.println("El ganador del torneo "+ nombreTorneo + " es " + jugadorB.nombreDelJugador + ". ¡FELICITACIONES!");
            revancha();
        }
    }

}
