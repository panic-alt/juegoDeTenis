import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Sets {
    int cantidadSets;
    String nombreJugadorA;
    int probabilidadJugadorA;
    int[] gamesJugadorA = {};
    String nombreJugadorB;
    int probabilidadJugadorB;
    int[] gamesJugadorB = {};
    int setsJugadorA;
    int setsJugadorB;





    public Sets(String nombreJugadorA,
                int probabilidadJugadorA,
                String nombreJugadorB,
                int probabilidadJugadorB) {

        this.nombreJugadorA = nombreJugadorA;
        this.probabilidadJugadorA = probabilidadJugadorA;
        this.nombreJugadorB = nombreJugadorB;
        this.probabilidadJugadorB = probabilidadJugadorB;
        this.cantidadSets = definirCantidadSets();

    }

    public static int definirCantidadSets() {

        Scanner numeroDeSets = new Scanner(System.in);
        System.out.println("Elija cantidad de sets (A mejor de 3 o a mejor de 5): ");

        int numeroSets = numeroDeSets.nextInt();
        System.out.println("La cantidad de sets es: " + numeroSets);
        return numeroSets;

    }
    public boolean jugarSets(){

        int gamesGanadosJugadorA = 0;
        int gamesGanadosJugadorB = 0;
        ArrayList<Integer> puntajeSetsJugadorA = new ArrayList<Integer>();
        ArrayList<Integer> puntajeSetsJugadorB = new ArrayList<Integer>();
        boolean partidoFinalizado = false;
        int setsJugados = 0;
        int setsJugadorA = 0;
        int setsJugadorB = 0;
        boolean ganadorDelPartido;



        while (partidoFinalizado != true) {


            Sets.Game game = new Sets.Game(this.nombreJugadorA,
                    this.probabilidadJugadorA,
                    this.nombreJugadorB,
                    this.probabilidadJugadorB);




            boolean resultadoDelGame = game.jugarGame();
            if (resultadoDelGame) {
                gamesGanadosJugadorA += 1;
                System.out.println("------------------------");
                System.out.println("| " + nombreJugadorA + " " + gamesGanadosJugadorA + " |");
                System.out.println("| " + nombreJugadorB + " " + gamesGanadosJugadorB + " |");
                System.out.println("------------------------");


            } else  {
                gamesGanadosJugadorB += 1;
                System.out.println("------------------------");
                System.out.println("| " + nombreJugadorA + " " + gamesGanadosJugadorA + " |" );
                System.out.println("| " + nombreJugadorB + " " + gamesGanadosJugadorB + " |");
                System.out.println("------------------------");


            }

            if ((gamesGanadosJugadorA > 5) && (gamesGanadosJugadorA - gamesGanadosJugadorB) > 1) {

                setsJugadorA += 1;
                System.out.println("------------------------");
                System.out.println("Set : " + nombreJugadorA);
                System.out.println("------------------------");
                puntajeSetsJugadorA.add(gamesGanadosJugadorA);
                puntajeSetsJugadorB.add(gamesGanadosJugadorB);
                gamesGanadosJugadorA = 0;
                gamesGanadosJugadorB = 0;

                System.out.println("------------------------");
                System.out.println("| " + nombreJugadorA + " " + puntajeSetsJugadorA + " |");
                System.out.println("| " + nombreJugadorB + " " + puntajeSetsJugadorB + " |");
                System.out.println("------------------------");




                if (setsJugadorA > cantidadSets/2) {
                    ganadorDelPartido = true;
                    partidoFinalizado = true;

                    return ganadorDelPartido;
                }



            }

            if (gamesGanadosJugadorB > 5 && gamesGanadosJugadorB - gamesGanadosJugadorA > 1) {
                setsJugadorB += 1;

                System.out.println("------------------------");
                System.out.println("Set : " + nombreJugadorB);
                System.out.println("------------------------");
                puntajeSetsJugadorA.add(gamesGanadosJugadorA);
                puntajeSetsJugadorB.add(gamesGanadosJugadorB);
                gamesGanadosJugadorA = 0;
                gamesGanadosJugadorB = 0;

                System.out.println("------------------------");
                System.out.println("| " + nombreJugadorA + " " + puntajeSetsJugadorA + " |");
                System.out.println("| " + nombreJugadorB + " " + puntajeSetsJugadorB + " |");
                System.out.println("------------------------");

                if (setsJugadorB > cantidadSets/2) {
                    ganadorDelPartido = false;
                    partidoFinalizado = true;

                    return ganadorDelPartido;
                }

            }

        }


        return partidoFinalizado;
    }

    class Game {
        String nombreJugadorA;
        String nombreJugadorB;
        int probabilidadJugadorA;
        int probabilidadJugadorB;



        String scoreboard;

        public Game(String nombreJugadorA,
                    int probabilidadJugadorA,
                    String nombreJugadorB,
                    int probabilidadJugadorB) {
            this.nombreJugadorA = nombreJugadorA;
            this.probabilidadJugadorA = probabilidadJugadorA;
            this.nombreJugadorB = nombreJugadorB;
            this.probabilidadJugadorB = probabilidadJugadorB;

        }

        public boolean jugarGame() {

            int puntosJugadorA = 0;
            int puntosJugadorB = 0;

            String puntajeJugadorA = "0";
            String puntajeJugadorB= "0";
            boolean ganadorDelGame = true;
            boolean finDelGame = false;


            Random chanceGanarPunto = new Random();

            while(finDelGame != true) {
                boolean saque = true;
                String jugadorConSaque = nombreJugadorA;
                if (saque) {
                    saque = false;
                    jugadorConSaque = nombreJugadorB;
                } else {
                    saque = true;
                    jugadorConSaque = nombreJugadorA;
                }




                System.out.println("------------------------");
                System.out.println("Sirve : " + jugadorConSaque);
                System.out.println("------------------------");


                int ganaJugadorA = chanceGanarPunto.nextInt(this.probabilidadJugadorA);
                int ganaJugadorB = chanceGanarPunto.nextInt(this.probabilidadJugadorB);

                if (ganaJugadorA > ganaJugadorB) {
                    System.out.println("------------------------");
                    System.out.println(this.nombreJugadorA + " gana el punto");
                    System.out.println("------------------------");
                    puntosJugadorA += 1;

                    if ((puntosJugadorA >= 4) && (puntosJugadorA - puntosJugadorB) > 1) {
                        System.out.println("------------------------");
                        System.out.println("Game " + this.nombreJugadorA);
                        System.out.println("------------------------");
                        puntosJugadorA = 0;
                        puntosJugadorB = 0;
                        ganadorDelGame = true;
                        finDelGame = true;




                        return ganadorDelGame;
                    }
                }

                if (ganaJugadorB > ganaJugadorA) {
                    System.out.println(this.nombreJugadorB + " gana el punto");
                    puntosJugadorB += 1;

                    if ((puntosJugadorB >= 4) && (puntosJugadorB - puntosJugadorA) > 1) {
                        System.out.println("------------------------");
                        System.out.println("Game " + this.nombreJugadorB);
                        System.out.println("------------------------");
                        puntosJugadorA = 0;
                        puntosJugadorB = 0;
                        ganadorDelGame = false;
                        finDelGame = true;


                        return ganadorDelGame;
                    }
                }

                if (puntosJugadorA == 1) {
                    puntajeJugadorA = "15";

                } else if (puntosJugadorA == 2) {
                    puntajeJugadorA = "30";
                } else if (puntosJugadorA == 3) {
                    puntajeJugadorA = "40";
                } else if (puntosJugadorA > 3 && (puntosJugadorA - puntosJugadorB) == 1) {
                    puntajeJugadorA = "AD " + nombreJugadorA;
                }

                if (puntosJugadorB == 1) {
                    puntajeJugadorB = "15";

                } else if (puntosJugadorB == 2) {
                    puntajeJugadorB = "30";
                } else if (puntosJugadorB == 3) {
                    puntajeJugadorB = "40";
                } else if (puntosJugadorB > 3 && (puntosJugadorB - puntosJugadorA) == 1)
                    puntajeJugadorB = "AD " + nombreJugadorB;
                this.scoreboard = puntajeJugadorA + " - " + puntajeJugadorB;

                System.out.println("------------------------");
                System.out.println(scoreboard);
                System.out.println("------------------------");


            }
            return ganadorDelGame;
        }
    }
}
