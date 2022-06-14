import java.util.Scanner;
public class Jugador {
    int probabilidadDelJugador;
    String nombreDelJugador;

    public Jugador() {
        crearJugador();
    }

     private void crearJugador() {
        Scanner inputUsuario = new Scanner(System.in);
        System.out.println("Nombre del jugador: ");

        nombreDelJugador = inputUsuario.nextLine();

        System.out.println("Probabilidad de ganar del jugador: ");

        probabilidadDelJugador = inputUsuario.nextInt();
    }
    public void servir() {
        System.out.println(nombreDelJugador + " realiza el saque");
    }


}
