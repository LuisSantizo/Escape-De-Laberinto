package com.mycompany.Partes;

import java.util.Random;
import java.util.Scanner;

public class Jugar {

    Scanner sc = new Scanner(System.in);
    String Comando2;
    int variablei;
    int variablej;
    int OrpXMapa;
    int Oroganado;
    boolean SalirJuego;
    int XB;
    int YB;
    public int XJ;
    public int YJ;
    int Xinicial;
    int Xfinal;
    int Yinicial;
    int Yfinal;
    public static Mapa Mapa1 = new Mapa();
    public static MenuPrincipal Menup = new MenuPrincipal();
    public static CrearMapa CrearNuevoM = new CrearMapa();
    public static Variables Var = new Variables();
    int BotAtrapa, PartidasGanadas, NoPartidas, Noperdidas, NoGanadas;

    public void GenararJugador() {
        Mapa1.Mapa1();
        OrpXMapa = 0;
        Random Ran = new Random();
        boolean salir = false;
        while (!salir) {
            int X = Ran.nextInt(30);
            int Y = Ran.nextInt(30);
            if ("O".equals(Mapa1.Mapa[Y][X])) {
                Mapa1.Mapa[Y][X] = "J";
                YJ = Y;
                XJ = X;
                salir = true;
            }
        }
        Random RanBot = new Random();
        boolean salirb = false;
        int VerT = 0;
        while (!salirb) {
            XB = RanBot.nextInt(30);
            YB = RanBot.nextInt(30);
            if (0 <= (XB - 4) & 0 <= (YB - 4) & (XB + 4) <= 30 & (YB + 4) <= 30) {
                if ("O".equals(Mapa1.Mapa[YB][XB])) {
                    for (int i = (XB - 4); i < XB + 5; i++) {
                        for (int j = (YB - 4); j < (YB + 4); j++) {
                            if ("J".equals(Mapa1.Mapa[i][j])) {
                                VerT = VerT + 1;
                            }
                        }
                    }
                    if (VerT == 0) {
                        NoPartidas = NoPartidas + 1;
                        Mapa1.Mapa[YB][XB] = "B";
                        Mostrar1x1();
                        salirb = true;
                    }
                }
            }
        }
    }

    public void MoverBotT() {
        Random RanBot = new Random();
        boolean MoverBot = false;
        while (!MoverBot) {
            int Direccion = RanBot.nextInt(4);
            switch (Direccion) {
                case 0:
                    if ("O".equals(Mapa1.Mapa[YB - 1][XB])) {
                        Mapa1.Mapa[YB][XB] = "O";
                        Mapa1.Mapa[YB - 1][XB] = "B";
                        YB = YB - 1;
                        MoverBot = true;
                    } else if ("J".equals(Mapa1.Mapa[YB - 1][XB])) {
                        System.out.println("Perdio la partida");
                        System.out.println("El bot Mato al jugador");
                        BotAtrapa = BotAtrapa + 1;
                        Noperdidas = Noperdidas + 1;
                        MoverBot = true;
                        SalirJuego = true;
                    }
                    break;
                case 1:
                    if ("O".equals(Mapa1.Mapa[YB + 1][XB])) {
                        Mapa1.Mapa[YB][XB] = "O";
                        Mapa1.Mapa[YB + 1][XB] = "B";
                        YB = YB + 1;
                        MoverBot = true;
                    } else if ("J".equals(Mapa1.Mapa[YB + 1][XB])) {
                        System.out.println("Perdio la partida");
                        System.out.println("El bot Mato al jugador");
                        BotAtrapa = BotAtrapa + 1;
                        Noperdidas = Noperdidas + 1;
                        MoverBot = true;
                        SalirJuego = true;
                    }
                    break;
                case 2:
                    if ("O".equals(Mapa1.Mapa[YB][XB - 1])) {
                        Mapa1.Mapa[YB][XB] = "O";
                        Mapa1.Mapa[YB][XB - 1] = "B";
                        XB = XB - 1;
                        MoverBot = true;
                    } else if ("J".equals(Mapa1.Mapa[YB][XB - 1])) {
                        System.out.println("Perdio la partida");
                        System.out.println("El bot Mato al jugador");
                        BotAtrapa = BotAtrapa + 1;
                        Noperdidas = Noperdidas + 1;
                        MoverBot = true;
                        SalirJuego = true;
                    }
                    break;
                case 3:
                    if ("O".equals(Mapa1.Mapa[YB][XB + 1])) {
                        Mapa1.Mapa[YB][XB] = "O";
                        Mapa1.Mapa[YB][XB + 1] = "B";
                        XB = XB + 1;
                        MoverBot = true;
                    } else if ("J".equals(Mapa1.Mapa[YB][XB + 1])) {
                        System.out.println("Perdio la partida");
                        System.out.println("El bot Mato al jugador");
                        BotAtrapa = BotAtrapa + 1;
                        Noperdidas = Noperdidas + 1;
                        MoverBot = true;
                        SalirJuego = true;
                    }
                    break;
                default:
                    System.out.println("No se econtro la opcion\n");
            }
        }
    }

    public void Mover() {
        SalirJuego = false;
        String Comando;
        int Errores = 0;
        while (!SalirJuego) {
            if (Errores == 3) {
                System.out.println("Cometio tres errores seguidos");
                System.out.println("Perdio la partida");
                Noperdidas = Noperdidas + 1;
                SalirJuego = true;
            } else {
                System.out.println("Ingrese un comando:");
                Comando = sc.nextLine();
                if ("MOVER N".equals(Comando)) {
                    for (int i = 0; i < 30; i++) {
                        for (int j = 0; j < 30; j++) {
                            if ("J".equals(Mapa1.Mapa[i][j])) {
                                if ("O".equals(Mapa1.Mapa[i - 1][j])) {
                                    Mapa1.Mapa[i][j] = "O";
                                    Mapa1.Mapa[i - 1][j] = "J";
                                    YJ = i - 1;
                                    MoverBotT();
                                    MoverBotT();
                                    Mostrar1x1();
                                    Errores = 0;
                                } else if ("G".equals(Mapa1.Mapa[i - 1][j])) {
                                    Mapa1.Mapa[i][j] = "O";
                                    Mapa1.Mapa[i - 1][j] = "J";
                                    YJ = i - 1;
                                    MoverBotT();
                                    MoverBotT();
                                    Mostrar1x1();
                                    System.out.println("Esta en casilla de oro");
                                    RecOro();
                                } else if ("S".equals(Mapa1.Mapa[i - 1][j])) {
                                    Mapa1.Mapa[i][j] = "O";
                                    Mapa1.Mapa[i - 1][j] = "J";
                                    YJ = i - 1;
                                    MoverBotT();
                                    MoverBotT();
                                    Mostrar1x1();
                                    ComSalir();
                                } else {
                                    System.out.println("No es posible moverse");
                                    MoverBotT();
                                    Errores = Errores + 1;
                                }
                            }
                        }
                    }
                } else if ("MOVER S".equals(Comando)) {
                    for (int i = 0; i < 30; i++) {
                        for (int j = 0; j < 30; j++) {
                            if ("J".equals(Mapa1.Mapa[i][j])) {
                                if ("O".equals(Mapa1.Mapa[i + 1][j])) {
                                    Mapa1.Mapa[i][j] = "O";
                                    Mapa1.Mapa[i + 1][j] = "J";
                                    YJ = i + 1;
                                    MoverBotT();
                                    MoverBotT();
                                    Mostrar1x1();
                                    i = 30;
                                    j = 30;
                                    Errores = 0;
                                } else if ("G".equals(Mapa1.Mapa[i + 1][j])) {
                                    Mapa1.Mapa[i][j] = "O";
                                    Mapa1.Mapa[i + 1][j] = "J";
                                    YJ = i + 1;
                                    i = 30;
                                    j = 30;
                                    MoverBotT();
                                    MoverBotT();
                                    Mostrar1x1();
                                    System.out.println("Esta en casilla de oro");
                                    RecOro();
                                } else if ("S".equals(Mapa1.Mapa[i + 1][j])) {
                                    Mapa1.Mapa[i][j] = "O";
                                    Mapa1.Mapa[i + 1][j] = "J";
                                    YJ = i + 1;
                                    MoverBotT();
                                    MoverBotT();
                                    Mostrar1x1();
                                    ComSalir();
                                } else {
                                    System.out.println("No es posible moverse");
                                    MoverBotT();
                                    Errores = Errores + 1;
                                }
                            }
                        }
                    }
                } else if ("MOVER E".equals(Comando)) {
                    for (int i = 0; i < 30; i++) {
                        for (int j = 0; j < 30; j++) {
                            if ("J".equals(Mapa1.Mapa[i][j])) {
                                if ("O".equals(Mapa1.Mapa[i][j - 1])) {
                                    Mapa1.Mapa[i][j] = "O";
                                    Mapa1.Mapa[i][j - 1] = "J";
                                    XJ = j - 1;
                                    MoverBotT();
                                    MoverBotT();
                                    Mostrar1x1();
                                    Errores = 0;
                                } else if ("G".equals(Mapa1.Mapa[i][j - 1])) {
                                    //tira bot
                                    Mapa1.Mapa[i][j] = "O";
                                    Mapa1.Mapa[i][j - 1] = "J";
                                    XJ = j - 1;
                                    MoverBotT();
                                    MoverBotT();
                                    Mostrar1x1();
                                    System.out.println("Esta en casilla de oro");
                                    RecOro();
                                } else if ("S".equals(Mapa1.Mapa[i][j - 1])) {
                                    Mapa1.Mapa[i][j] = "O";
                                    Mapa1.Mapa[i][j - 1] = "J";
                                    XJ = j - 1;
                                    MoverBotT();
                                    MoverBotT();
                                    Mostrar1x1();
                                    ComSalir();
                                } else {
                                    MoverBotT();
                                    System.out.println("No es posible moverse");
                                    Errores = Errores + 1;
                                }
                            }
                        }
                    }
                } else if ("MOVER O".equals(Comando)) {
                    for (int i = 0; i < 30; i++) {
                        for (int j = 0; j < 30; j++) {
                            if ("J".equals(Mapa1.Mapa[i][j])) {
                                if ("O".equals(Mapa1.Mapa[i][j + 1])) {
                                    Mapa1.Mapa[i][j] = "O";
                                    Mapa1.Mapa[i][j + 1] = "J";
                                    XJ = j + 1;
                                    MoverBotT();
                                    MoverBotT();
                                    Mostrar1x1();
                                    i = 30;
                                    j = 30;
                                    Errores = 0;
                                } else if ("G".equals(Mapa1.Mapa[i][j + 1])) {
                                    //tira bot
                                    Mapa1.Mapa[i][j] = "O";
                                    Mapa1.Mapa[i][j + 1] = "J";
                                    XJ = j + 1;
                                    i = 30;
                                    j = 30;
                                    MoverBotT();
                                    MoverBotT();
                                    Mostrar1x1();
                                    System.out.println("Esta en casilla de oro");
                                    RecOro();
                                } else if ("S".equals(Mapa1.Mapa[i][j + 1])) {
                                    Mapa1.Mapa[i][j] = "O";
                                    Mapa1.Mapa[i][j + 1] = "J";
                                    XJ = j + 1;
                                    MoverBotT();
                                    MoverBotT();
                                    Mostrar1x1();
                                    ComSalir();
                                } else {
                                    System.out.println("No es posible moverse");
                                    MoverBotT();
                                    XJ = j + 1;
                                    Errores = Errores + 1;
                                }
                            }
                        }
                    }
                } else if ("MIRAR".equals(Comando)) {
                    MoverBotT();
                    MoverBotT();
                    Mostrar5x5();
                } else if ("SALIR".equals(Comando)) {
                    MoverBotT();
                    MoverBotT();
                    System.out.println("No es posible salir");
                } else if ("ORO_REQUERIDO".equals(Comando)) {
                    MoverBotT();
                    MoverBotT();
                    System.out.println("El oro necesario para salir es de: 100");
                } else if ("ORO".equals(Comando)) {
                    MoverBotT();
                    MoverBotT();
                    System.out.println("Su oro es: " + OrpXMapa);
                } else if ("SALIR".equals(Comando2)) {
                    ComSalir();
                } else {
                    System.out.println("No existe el comando");
                    MoverBotT();
                    Errores = Errores + 1;
                    sc.reset();
                }
            }

        }
    }

    public void Mostrar1x1() {
        Xinicial = YJ - 1;
        Xfinal = YJ + 2;
        Yinicial = XJ - 1;
        Yfinal = XJ + 2;
        //1<0
        //1>0
        if ((YJ - 1) < 2) {
            Xinicial = 0;
        }
        if ((XJ - 1) < 2) {
            Yinicial = 0;
        }
        if ((YJ + 2) > 29) {
            Xfinal = 30;
        }
        if ((XJ + 2) > 29) {
            Yfinal = 30;
        }
        for (int i = Xinicial; i < Xfinal; i++) {
            for (int j = Yinicial; j < Yfinal; j++) {
                if (Mapa1.Mapa[i][j] == null) {
                    Mapa1.Mapa[i][j] = "#";
                }
                if ("#".equals(Mapa1.Mapa[i][j])) {
                    System.out.print(" " + Var.Azul + Mapa1.Mapa[i][j] + " ");
                }
                if ("G".equals(Mapa1.Mapa[i][j])) {
                    System.out.print(" " + Var.Amarillo + Mapa1.Mapa[i][j] + " ");
                }
                if ("S".equals(Mapa1.Mapa[i][j])) {
                    System.out.print(Var.Verde + " " + Mapa1.Mapa[i][j] + " ");
                }
                if ("O".equals(Mapa1.Mapa[i][j])) {
                    System.out.print(" " + Var.Cyan + Mapa1.Mapa[i][j] + " ");
                }
                if ("J".equals(Mapa1.Mapa[i][j])) {
                    System.out.print(" " + Var.White + Mapa1.Mapa[i][j] + " ");
                }
                if ("B".equals(Mapa1.Mapa[i][j])) {
                    System.out.print(" " + Var.Rojo + Mapa1.Mapa[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void Mostrar5x5() {
        Xinicial = YJ - 5;
        Xfinal = YJ + 6;
        Yinicial = XJ - 5;
        Yfinal = XJ + 6;
        if ((YJ - 1) < 6) {
            Xinicial = 0;
        }
        if ((XJ - 1) < 6) {
            Yinicial = 0;
        }
        if ((YJ + 2) > 24) {
            Xfinal = 30;
        }
        if ((XJ + 2) > 24) {
            Yfinal = 30;
        }
        for (int i = Xinicial; i < Xfinal; i++) {
            for (int j = Yinicial; j < Yfinal; j++) {
                if (Mapa1.Mapa[i][j] == null) {
                    Mapa1.Mapa[i][j] = "#";
                }
                if ("#".equals(Mapa1.Mapa[i][j])) {
                    System.out.print(" " + Var.Azul + Mapa1.Mapa[i][j] + " ");
                }
                if ("G".equals(Mapa1.Mapa[i][j])) {
                    System.out.print(" " + Var.Amarillo + Mapa1.Mapa[i][j] + " ");
                }
                if ("S".equals(Mapa1.Mapa[i][j])) {
                    System.out.print(Var.Verde + " " + Mapa1.Mapa[i][j] + " ");
                }
                if ("O".equals(Mapa1.Mapa[i][j])) {
                    System.out.print(" " + Var.Cyan + Mapa1.Mapa[i][j] + " ");
                }
                if ("J".equals(Mapa1.Mapa[i][j])) {
                    System.out.print(" " + Var.White + Mapa1.Mapa[i][j] + " ");
                }
                if ("B".equals(Mapa1.Mapa[i][j])) {
                    System.out.print(" " + Var.Rojo + Mapa1.Mapa[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void RecOro() {
        System.out.println("Ingrese comando");
        Comando2 = sc.nextLine();
        if ("LEVANTAR".equals(Comando2)) {
            Random Ran = new Random();
            int OroGenerado = Ran.nextInt(50) + 50;
            OrpXMapa = OrpXMapa + Ran.nextInt(50) + 50;
            Oroganado = Oroganado + Ran.nextInt(50) + 50;
            System.out.println("Recojio oro" + (OroGenerado));
        } else {
            System.out.println("comando erroneo, perdio el oro");
        }
    }

    public void ComSalir() {
        System.out.println("Esta en la casilla de salida");
        System.out.println("Ingrese comando");
        Comando2 = sc.nextLine();
        if ("SALIR".equals(Comando2)) {
            if (OrpXMapa >= 100) {
                PartidasGanadas = PartidasGanadas + 1;
                System.out.println("Gano");
                SalirJuego = true;
            } else {
                System.out.println("Oro insuficiente");
            }
        } else {
            System.out.println("comando erroneo, perdio esta salida");
        }
    }
}
