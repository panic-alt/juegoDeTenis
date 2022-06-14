import java.util.Scanner;
import java.util.Random;

public class Torneo {
    static String nombreTorneo;

    public static void main(String[] args) {

        nombrarTorneo();

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

        Sets.Game game = sets.new Game(
                jugadorA.nombreDelJugador,
                jugadorA.probabilidadDelJugador,
                jugadorB.nombreDelJugador,
                jugadorB.probabilidadDelJugador);

        boolean ganador = sets.jugarSets();

        if (ganador) {
            System.out.println("El ganador es " + jugadorA.nombreDelJugador);
        } else {
            System.out.println("El ganador es " + jugadorB.nombreDelJugador);
        }








    }
    public void iniciarTorneo(){
        nombrarTorneo();
        Jugador jugadorA = new Jugador();
        Jugador jugadorB = new Jugador();

        System.out.println("Nombre del jugador A: " + jugadorA.nombreDelJugador);
        System.out.println("Nombre del jugador B: " + jugadorB.nombreDelJugador);

        System.out.println("Probabilidad de ganar del jugador A: " + jugadorA.probabilidadDelJugador);
        System.out.println("Probabilidad de ganar del jugador B: " + jugadorB.probabilidadDelJugador);








    }
    public static void nombrarTorneo() {
        System.out.println("Nombre del torneo");
        Scanner nombre = new Scanner(System.in);

        nombreTorneo = nombre.nextLine();
        System.out.println("El nombre del torneo es: " + nombreTorneo);

    }

    public void jugarGame(int probabilidadJugadorA, int probabilidadJugadorB) {
        Random definirSaque = new Random();
        int sacaJugadorA = definirSaque.nextInt(probabilidadJugadorA);
        int sacaJugadorB = definirSaque.nextInt(probabilidadJugadorB);

        if (sacaJugadorA > sacaJugadorB) {

        } else {
            System.out.println("Inicia el saque el jugador B");
        }


    }
    public static String definirSaque (int probabilidadJugadorA, String nombreJugadorA, String nombreJugadorB, int probabilidadJugadorB){
        Random definirSaque = new Random();
        int sacaJugadorA = definirSaque.nextInt(probabilidadJugadorA);
        System.out.println(sacaJugadorA);

        int sacaJugadorB = definirSaque.nextInt(probabilidadJugadorB);
        System.out.println(sacaJugadorB);

        if (sacaJugadorA > sacaJugadorB) {
            return nombreJugadorA;
        } else {
            return nombreJugadorB;
        }
    }

}
