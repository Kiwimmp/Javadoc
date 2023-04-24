
import java.util.Scanner;

public class EscacsDanielZanon {
    /*Programa en java de un tablero de ajedrez*/
    public static void main(String[] args) {
        // Daniel Zanón López
        Scanner teclado = new Scanner(System.in);
        
        /*Declaracion de variables*/
        int af;
        int lf;
        int l_ficha;
        int a_ficha;
        int opcion;
        char pieza;
        char salir;
        // Creacion de constantes para el tablero
        /*Declaracion de constantes*/
        final char VACIO = '*';
        final char MOV = 'O';
        final char TORRE = 'T';
        final char ALFIL = 'A';
        final char REY = 'R';
        final char DAMA = 'D';
        final char CABALLO = 'C';
        /*Matriz del tablero*/
        char tablero[][];
        int largo, ancho;
        /*Control de error para el tablero*/
        while (true) {
            System.out.println("¿Como de largo quieres el tablero?");
            largo = teclado.nextInt();
            System.out.println("¿Y como de ancho?");
            ancho = teclado.nextInt();
            if (largo >= 5 && largo <= 9 && ancho >= 5 && ancho <= 9) {
                break;
            }
        }
        // Creacion del tablero (asignando casillas vacias)
        tablero = new char[largo + 1][ancho + 1];
        for (int l = 1; l < tablero.length; l++) {
            for (int a = 1; a < tablero[l].length; a++) {
                tablero[l][a] = VACIO;
            }
        }
        ajedrez:
        while (true) {
            // Imprimir tablero con numeros.
            System.out.print("  " + 1);
            for (int i = 2; i < tablero[0].length; i++) {
                System.out.print(" " + i);
            }
            System.out.println("");
            for (int l = 1; l < tablero.length; l++) {
                System.out.print(l + " ");
                for (int a = 1; a < tablero[l].length; a++) {
                    System.out.print(tablero[l][a]);
                    System.out.print(" ");
                }
                System.out.print(l);
                System.out.println("");
            }
            System.out.print("  " + 1);
            for (int i = 2; i < tablero[0].length; i++) {
                System.out.print(" " + i);
            }
            System.out.println("");
            /*Menú Principal*/
            System.out.println("""
                               1. Poner una pieza
                               2. Mostrar los movimientos de una pieza
                               3. Borrar movimientos
                               4. Borrar tablero
                               5. Salir""");
            System.out.print("Introducir opcion: ");
            opcion = teclado.nextInt();
            switch (opcion) {
                /*Funcion de elegir la pieza
                Indicando la posicion de la ficha*/
                case 1:
                    System.out.println("¿Que pieza quieres poner? Torre, Alfil, Caballo, Rey, Dama");
                    pieza = teclado.next().charAt(0);
                    if (pieza != TORRE && pieza != ALFIL && pieza != CABALLO && pieza != REY && pieza != DAMA) {
                        System.out.println("La pieza introducida no existe");
                        break;
                    }
                    System.out.println("¿Donde quieres ponerla?");
                    System.out.print("Largo: ");
                    l_ficha = teclado.nextInt();
                    System.out.print("Ancho: ");
                    a_ficha = teclado.nextInt();
                    tablero[l_ficha][a_ficha] = pieza;
                    break;
                case 2:
                    /**/
                    System.out.println("¿Que pieza quieres seleccionar?");
                    System.out.print("Largo: ");
                    l_ficha = teclado.nextInt();
                    System.out.print("Ancho: ");
                    a_ficha = teclado.nextInt();
                    switch (tablero[l_ficha][a_ficha]) {
                        case TORRE:
                            // ORDEN : arriba, abajo, izquierda, derecha
                            for (int i = l_ficha - 1; i > 0; i--) {
                                if (tablero[i][a_ficha] == MOV || tablero[i][a_ficha] == VACIO) {
                                    tablero[i][a_ficha] = MOV;
                                } else {
                                    break;
                                }
                            }
                            for (int i = l_ficha + 1; i < tablero.length; i++) {
                                if (tablero[i][a_ficha] == MOV || tablero[i][a_ficha] == VACIO) {
                                    tablero[i][a_ficha] = MOV;
                                } else {
                                    break;
                                }
                            }
                            for (int i = a_ficha - 1; i > 0; i--) {
                                if (tablero[l_ficha][i] == MOV || tablero[l_ficha][i] == VACIO) {
                                    tablero[l_ficha][i] = MOV;
                                } else {
                                    break;
                                }
                            }
                            for (int i = a_ficha + 1; i < tablero.length; i++) {
                                if (tablero[l_ficha][i] == MOV || tablero[l_ficha][i] == VACIO) {
                                    tablero[l_ficha][i] = MOV;
                                } else {
                                    break;
                                }
                            }
                            break;
                        case ALFIL:
                            // ORDEN: arriba-izquierda, arriba-derecha, abajo-izquierda, abajo-derecha
                            for (lf = l_ficha - 1, af = a_ficha - 1; lf > 0; lf--, af--) {
                                if (tablero[lf][af] == MOV || tablero[lf][af] == VACIO) {
                                    tablero[lf][af] = MOV;
                                } else {
                                    break;
                                }
                            }
                            for (lf = l_ficha - 1, af = a_ficha + 1; lf > 0 && af <= ancho; lf--, af++) {
                                if (tablero[lf][af] == MOV || tablero[lf][af] == VACIO) {
                                    tablero[lf][af] = MOV;
                                } else {
                                    break;
                                }
                            }
                            for (lf = l_ficha + 1, af = a_ficha - 1; lf <= largo; lf++, af--) {
                                if (tablero[lf][af] == MOV || tablero[lf][af] == VACIO) {
                                    tablero[lf][af] = MOV;
                                } else {
                                    break;
                                }
                            }
                            for (lf = l_ficha + 1, af = a_ficha + 1; lf <= largo; lf++, af++) {
                                if (tablero[lf][af] == MOV || tablero[lf][af] == VACIO) {
                                    tablero[lf][af] = MOV;
                                } else {
                                    break;
                                }
                            }
                            break;
                        case DAMA:
                            // Sigue el orden de la torre primero y despues el del alfil.
                            for (int i = l_ficha - 1; i > 0; i--) {
                                if (tablero[i][a_ficha] == MOV || tablero[i][a_ficha] == VACIO) {
                                    tablero[i][a_ficha] = MOV;
                                } else {
                                    break;
                                }
                            }
                            for (int i = l_ficha + 1; i < tablero.length; i++) {
                                if (tablero[i][a_ficha] == MOV || tablero[i][a_ficha] == VACIO) {
                                    tablero[i][a_ficha] = MOV;
                                } else {
                                    break;
                                }
                            }
                            for (int i = a_ficha - 1; i > 0; i--) {
                                if (tablero[l_ficha][i] == MOV || tablero[l_ficha][i] == VACIO) {
                                    tablero[l_ficha][i] = MOV;
                                } else {
                                    break;
                                }
                            }
                            for (int i = a_ficha + 1; i < tablero.length; i++) {
                                if (tablero[l_ficha][i] == MOV || tablero[l_ficha][i] == VACIO) {
                                    tablero[l_ficha][i] = MOV;
                                } else {
                                    break;
                                }
                            }
                            for (lf = l_ficha - 1, af = a_ficha - 1; lf > 0; lf--, af--) {
                                if (tablero[lf][af] == MOV || tablero[lf][af] == VACIO) {
                                    tablero[lf][af] = MOV;
                                } else {
                                    break;
                                }
                            }
                            for (lf = l_ficha - 1, af = a_ficha + 1; lf > 0 && af <= ancho; lf--, af++) {
                                if (tablero[lf][af] == MOV || tablero[lf][af] == VACIO) {
                                    tablero[lf][af] = MOV;
                                } else {
                                    break;
                                }
                            }
                            for (lf = l_ficha + 1, af = a_ficha - 1; lf <= largo; lf++, af--) {
                                if (tablero[lf][af] == MOV || tablero[lf][af] == VACIO) {
                                    tablero[lf][af] = MOV;
                                } else {
                                    break;
                                }
                            }
                            for (lf = l_ficha + 1, af = a_ficha + 1; lf <= largo; lf++, af++) {
                                if (tablero[lf][af] == MOV || tablero[lf][af] == VACIO) {
                                    tablero[lf][af] = MOV;
                                } else {
                                    break;
                                }
                            }
                            break;
                        case CABALLO:
                            try {
                            if (tablero[l_ficha - 1][a_ficha - 2] == MOV || tablero[l_ficha - 1][a_ficha - 2] == VACIO) {
                                tablero[l_ficha - 1][a_ficha - 2] = MOV;
                            }
                            if (tablero[l_ficha - 2][a_ficha - 1] == MOV || tablero[l_ficha - 2][a_ficha - 1] == VACIO) {
                                tablero[l_ficha - 2][a_ficha - 1] = MOV;
                            }
                            if (tablero[l_ficha - 2][a_ficha + 1] == MOV || tablero[l_ficha - 2][a_ficha + 1] == VACIO) {
                                tablero[l_ficha - 2][a_ficha + 1] = MOV;
                            }
                            if (tablero[l_ficha - 1][a_ficha + 2] == MOV || tablero[l_ficha - 1][a_ficha + 2] == VACIO) {
                                tablero[l_ficha - 1][a_ficha + 2] = MOV;
                            }
                            if (tablero[l_ficha + 1][a_ficha - 2] == MOV || tablero[l_ficha + 1][a_ficha - 2] == VACIO) {
                                tablero[l_ficha + 1][a_ficha - 2] = MOV;
                            }
                            if (tablero[l_ficha + 2][a_ficha - 1] == MOV || tablero[l_ficha + 2][a_ficha - 1] == VACIO) {
                                tablero[l_ficha + 2][a_ficha - 1] = MOV;
                            }
                            if (tablero[l_ficha + 2][a_ficha + 1] == MOV || tablero[l_ficha + 2][a_ficha + 1] == VACIO) {
                                tablero[l_ficha + 2][a_ficha + 1] = MOV;
                            }
                            if (tablero[l_ficha + 1][a_ficha + 2] == MOV || tablero[l_ficha + 1][a_ficha + 2] == VACIO) {
                                tablero[l_ficha + 1][a_ficha + 2] = MOV;
                            }
                        } catch (Exception e) {
                        }
                        break;
                        case REY:
                            try {
                            if (tablero[l_ficha][a_ficha - 1] == MOV || tablero[l_ficha][a_ficha - 1] == VACIO) {
                                tablero[l_ficha][a_ficha - 1] = MOV;
                            }
                            if (tablero[l_ficha - 1][a_ficha - 1] == MOV || tablero[l_ficha - 1][a_ficha - 1] == VACIO) {
                                tablero[l_ficha - 1][a_ficha - 1] = MOV;
                            }
                            if (tablero[l_ficha - 1][a_ficha] == MOV || tablero[l_ficha - 1][a_ficha] == VACIO) {
                                tablero[l_ficha - 1][a_ficha] = MOV;
                            }
                            if (tablero[l_ficha-1][a_ficha + 1] == MOV || tablero[l_ficha-1][a_ficha + 1] == VACIO) {
                                tablero[l_ficha-1][a_ficha + 1] = MOV;
                            }
                            if (tablero[l_ficha][a_ficha + 1] == MOV || tablero[l_ficha][a_ficha + 1] == VACIO) {
                                tablero[l_ficha][a_ficha + 1] = MOV;
                            }
                            if (tablero[l_ficha+1][a_ficha + 1] == MOV || tablero[l_ficha+1][a_ficha + 1] == VACIO) {
                                tablero[l_ficha+1][a_ficha + 1] = MOV;
                            }
                            if (tablero[l_ficha+1][a_ficha] == MOV || tablero[l_ficha+1][a_ficha] == VACIO) {
                                tablero[l_ficha+1][a_ficha] = MOV;
                            }
                            if (tablero[l_ficha+1][a_ficha - 1] == MOV || tablero[l_ficha+1][a_ficha - 1] == VACIO) {
                                tablero[l_ficha+1][a_ficha - 1] = MOV;
                            }
                        } catch (Exception e) {
                        }
                        break;
                        default:
                            System.out.println("La pieza no existe");

                    }
                    break;
                case 3:
                    for (int l = 1; l < tablero.length; l++) {
                        for (int a = 1; a < tablero[l].length; a++) {
                            if (tablero[l][a] == MOV) {
                                tablero[l][a] = VACIO;
                            }
                        }
                    }
                    break;
                case 4:
                    for (int l = 1; l < tablero.length; l++) {
                        for (int a = 1; a < tablero[l].length; a++) {
                            tablero[l][a] = VACIO;
                        }
                    }
                    break;
                case 5:
                    System.out.println("¿Quieres salir?");
                    salir = teclado.next().charAt(0);
                    if (salir == 's' || salir == 'S') {
                        break ajedrez;
                    }
                default:
                    System.out.println("Esa opcion no existe.");
            }
        }
    }
}
