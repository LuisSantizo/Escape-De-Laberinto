package com.mycompany.Partes;

import static com.mycompany.Partes.Mapa.Var;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class CrearMapa1Usuario {

    public String CrearMapa[][] = new String[50][50];
    public String CrearMapaZ[][] = new String[50][50];
    Scanner ScanerCrearMatriz = new Scanner(System.in);
    Scanner OPCIONcOMANDO = new Scanner(System.in);
    Scanner sInO = new Scanner(System.in);
    int Col, Fil, Mc, Mf, P;
    int BotAtrapa, PartidasGanadas, NoPartidas, Noperdidas, NoGanadas;
    int OrpXMapa;
    int Oroganado;
    int XB;
    int YB;
    public int XJ;
    public int YJ;
    public boolean salir1 = false;
    boolean SalirJuego;
    int Xinicial;
    int Xfinal;
    int Yinicial;
    int Yfinal;
    String Comando2;
//crear mapa

    public void Mapa1() {
        IngresarVal();
        CambiarCasillaM1();
    }

    public void IngresarVal() {
        boolean salir = false;
        while (!salir) {
            try {
                System.out.println("ingrese valores entre 20 a 50:");
                System.out.print("Numero de columnas: ");
                Col = ScanerCrearMatriz.nextInt();
                if (20 <= Col & Col <= 50) {
                    System.out.print("Numero de filas: ");
                    Fil = ScanerCrearMatriz.nextInt();
                    if (20 <= Fil & Fil <= 50) {
                        salir = true;
                        CrearM();
                    } else {
                        System.out.println("el valor no esta en el rango");
                    }
                } else {
                    System.out.println("el valor no esta en el rango");
                }
            } catch (InputMismatchException e) {
                System.out.println("debe ser un numero\n");
                ScanerCrearMatriz.next();
            }
        }
    }

    public void CrearM() {
//        for (int i = Fil; i >= 0; i--) {
//            for (int j = Col; j >= 0; j--) {
//                if (CrearMapa[0][j] == null) {
//                    CrearMapa[0][j] = "#";
//                } else if (CrearMapa[i][0] == null) {
//                    CrearMapa[i][0] = "#";
//                } else if (CrearMapa[i][j] == null) {
//                    CrearMapa[i][Col-1] = "#";
//                }else if (CrearMapa[i][j] == null) {
//                    CrearMapa[i][j] = "O";
//                }
//            }
//        }
        for (int i = 0; i < Fil; i++) {
            for (int j = 0; j < Col; j++) {
                if (CrearMapa[0][j] == null) {
                    CrearMapa[0][j] = "#";
                } else if (CrearMapa[i][0] == null) {
                    CrearMapa[i][0] = "#";
                } else if (CrearMapa[i][j] == null) {
                    CrearMapa[i][Fil-1] = "#";
                }else if (CrearMapa[i][j] == null) {
                    CrearMapa[i][j] = "O";
                }
            }
        }
    }

    public void CambiarCasillaM1() {
        salir1 = false;
        while (!salir1) {
            try {
                Mostrar();
                System.out.println("ingrese los datos para modificar la casilla");
                System.out.print("Columnas: ");
                Mc = ScanerCrearMatriz.nextInt();
                System.out.print("Fila: ");
                Mf = ScanerCrearMatriz.nextInt();
                for (int i = 0; i < Fil; i++) {
                    for (int j = 0; j < Col; j++) {
                        if (Mf == i & Mc == j) {
                            boolean salir2 = false;
                            while (!salir2) {
                                try {
                                    System.out.println("ingrese opcion");
                                    System.out.println("1) Casilla de Salida");
                                    System.out.println("2) Casilla de Oro");
                                    System.out.println("3) Casilla de Pared");
                                    System.out.println("4) Casilla Vacia");
                                    int OPP;
                                    OPP = ScanerCrearMatriz.nextInt();
                                    switch (OPP) {
                                        case 1:
                                            CrearMapa[i][j] = "S";
                                            salir2 = true;
                                            salirAsignacion();
                                            break;
                                        case 2:
                                            CrearMapa[i][j] = "G";
                                            salir2 = true;
                                            salirAsignacion();
                                            break;
                                        case 3:
                                            CrearMapa[i][j] = "#";
                                            salir2 = true;
                                            salirAsignacion();
                                            break;
                                        case 4:
                                            CrearMapa[i][j] = "O";
                                            salir2 = true;
                                            salirAsignacion();
                                            break;
                                        case 5:
                                            CrearMapa[i][j] = "O";
                                            salir2 = true;
                                            salirAsignacion();
                                            break;
                                        default:
                                            System.out.println("No se econtro la opcion\n");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("debe ser un numero\n");
                                    ScanerCrearMatriz.next();
                                }
                            }
                        }
                    }
                }
                if (P == 0) {
                    System.out.println("no existe esa columna");
                }
            } catch (InputMismatchException e) {
                System.out.println("debe ser un numero\n");
                ScanerCrearMatriz.next();
            }
        }
    }

    public void salirAsignacion() {
        P = 1;
        boolean RRRRR = false;
        System.out.println("Desea slair: SI O NO");
        while (!RRRRR) {
            String Sal = sInO.nextLine();
            if ("SI".equals(Sal)) {
                System.out.println("salio");
                salir1 = true;
                RRRRR = true;
            } else if ("NO".equals(Sal)) {
                RRRRR = true;
            } else {
                System.out.println("Opcion no valida-----");
            }
        }
    }

    //mapa a jugar
//    MapaUsuario1.GenararJugador2 ();
//    MapaUsuario1.Mostrar ();
    public void JugarM2() {
        MatrizEditar();
        GenararJugador2();
        MoverZ();
    }

    public void MatrizEditar() {
        System.out.println(Col + "--------------" + Fil);
        for (int i = 0; i < Col; i++) {
            for (int j = 0; j < Fil; j++) {
                CrearMapaZ[i][j] = CrearMapa[i][j];
            }
        }
    }

    public void GenararJugador2() {
        OrpXMapa = 0;
        Random Ran = new Random();
        boolean salir = false;
        while (!salir) {
            int X = Ran.nextInt(Fil);
            int Y = Ran.nextInt(Col);
            if ("O".equals(CrearMapaZ[Y][X])) {
                CrearMapaZ[Y][X] = "J";
                YJ = Y;
                XJ = X;
                salir = true;
            }
        }
        Random RanBot = new Random();
        boolean salirb = false;
        int VerT = 0;
        while (!salirb) {
            XB = RanBot.nextInt(Fil);
            YB = RanBot.nextInt(Col);
            if (0 <= (XB - 4) & 0 <= (YB - 4) & (XB + 4) <= 30 & (YB + 4) <= 30) {
                if ("O".equals(CrearMapaZ[YB][XB])) {
                    for (int i = (XB - 4); i < XB + 5; i++) {
                        for (int j = (YB - 4); j < (YB + 4); j++) {
                            if ("J".equals(CrearMapaZ[i][j])) {
                                VerT = VerT + 1;
                            }
                        }
                    }
                    if (VerT == 0) {
                        NoPartidas = NoPartidas + 1;
                        CrearMapaZ[YB][XB] = "B";
                        MostrarZ();
                        salirb = true;
                    }
                }
            }
        }
    }

    public void Mostrar() {
        for (int i = 0; i < Fil; i++) {
            for (int j = 0; j < Col; j++) {
                if ("#".equals(CrearMapa[i][j])) {
                    System.out.print(" " + Var.Azul + CrearMapa[i][j] + " ");
                }
                if ("G".equals(CrearMapa[i][j])) {
                    System.out.print(" " + Var.Amarillo + CrearMapa[i][j] + " ");
                }
                if ("S".equals(CrearMapa[i][j])) {
                    System.out.print(Var.Verde + " " + CrearMapa[i][j] + " ");
                }
                if ("O".equals(CrearMapa[i][j])) {
                    System.out.print(" " + Var.Cyan + CrearMapa[i][j] + " ");
                }
                if ("J".equals(CrearMapa[i][j])) {
                    System.out.print(" " + Var.White + CrearMapa[i][j] + " ");
                }
                if ("B".equals(CrearMapa[i][j])) {
                    System.out.print(" " + Var.Rojo + CrearMapa[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void MostrarZ() {
        for (int i = 0; i < Fil; i++) {
            for (int j = 0; j < Col; j++) {
                if ("#".equals(CrearMapaZ[i][j])) {
                    System.out.print(" " + Var.Azul + CrearMapaZ[i][j] + " ");
                }
                if ("G".equals(CrearMapaZ[i][j])) {
                    System.out.print(" " + Var.Amarillo + CrearMapaZ[i][j] + " ");
                }
                if ("S".equals(CrearMapaZ[i][j])) {
                    System.out.print(Var.Verde + " " + CrearMapaZ[i][j] + " ");
                }
                if ("O".equals(CrearMapaZ[i][j])) {
                    System.out.print(" " + Var.Cyan + CrearMapaZ[i][j] + " ");
                }
                if ("J".equals(CrearMapaZ[i][j])) {
                    System.out.print(" " + Var.White + CrearMapaZ[i][j] + " ");
                }
                if ("B".equals(CrearMapaZ[i][j])) {
                    System.out.print(" " + Var.Rojo + CrearMapaZ[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void Mover() {
        boolean salir = false;
        String Comando;
        int Errores = 0;

        while (!salir) {
            if (Errores == 3) {
                System.out.println("Cometio tres errores seguidos");
                System.out.println("Perdio la partida");
                salir = true;
            } else {
                System.out.println("Ingrese un comando:");
                Comando = OPCIONcOMANDO.nextLine();
                if ("MOVER N".equals(Comando)) {
                    for (int i = 0; i < 30; i++) {
                        for (int j = 0; j < 30; j++) {
                            if ("J".equals(CrearMapaZ[i][j])) {
                                if ("O".equals(CrearMapaZ[i - 1][j]) || "S".equals(CrearMapaZ[i - 1][j])) {
                                    CrearMapaZ[i][j] = "O";
                                    CrearMapaZ[i - 1][j] = "J";
                                    MostrarZ();
                                    Errores = 0;
                                } else if ("G".equals(CrearMapaZ[i - 1][j])) {
                                    CrearMapaZ[i][j] = "O";
                                    CrearMapaZ[i - 1][j] = "J";
                                    MostrarZ();
                                    //tira bot
                                    System.out.println("Esta en casilla de oro");
                                    //RecOro();
                                } else {
                                    System.out.println("mo s epuede");
                                    Errores = Errores + 1;
                                }
                            }
                        }
                    }
                } else if ("MOVER S".equals(Comando)) {
                    for (int i = 0; i < 30; i++) {
                        for (int j = 0; j < 30; j++) {
                            if ("J".equals(CrearMapaZ[i][j])) {
                                if ("O".equals(CrearMapaZ[i + 1][j]) || "S".equals(CrearMapaZ[i + 1][j])) {
                                    CrearMapaZ[i][j] = "O";
                                    CrearMapaZ[i + 1][j] = "J";
                                    MostrarZ();
                                    i = 30;
                                    j = 30;
                                    Errores = 0;
                                } else if ("G".equals(CrearMapaZ[i + 1][j])) {
                                    CrearMapaZ[i][j] = "O";
                                    CrearMapaZ[i + 1][j] = "J";
                                    i = 30;
                                    j = 30;
                                    MostrarZ();
                                    //tira bot
                                    System.out.println("Esta en casilla de oro");
                                    //RecOro();
                                } else {
                                    System.out.println("mo s epuede");
                                    Errores = Errores + 1;
                                }
                            }
                        }
                    }
                } else if ("MOVER E".equals(Comando)) {
                    for (int i = 0; i < 30; i++) {
                        for (int j = 0; j < 30; j++) {
                            if ("J".equals(CrearMapaZ[i][j])) {
                                if ("O".equals(CrearMapaZ[i][j - 1]) || "S".equals(CrearMapaZ[i][j - 1])) {
                                    CrearMapaZ[i][j] = "O";
                                    CrearMapaZ[i][j - 1] = "J";
                                    MostrarZ();
                                    Errores = 0;
                                } else if ("G".equals(CrearMapaZ[i][j - 1])) {
                                    //tira bot
                                    CrearMapaZ[i][j] = "O";
                                    CrearMapaZ[i][j - 1] = "J";
                                    MostrarZ();
                                    System.out.println("Esta en casilla de oro");
                                    //RecOro();
                                } else {
                                    System.out.println("mo s epuede");
                                    Errores = Errores + 1;
                                }
                            }
                        }
                    }
                } else if ("MOVER O".equals(Comando)) {
                    for (int i = 0; i < 30; i++) {
                        for (int j = 0; j < 30; j++) {
                            if ("J".equals(CrearMapaZ[i][j])) {
                                if ("O".equals(CrearMapaZ[i][j + 1]) || "S".equals(CrearMapaZ[i][j + 1])) {
                                    CrearMapaZ[i][j] = "O";
                                    CrearMapaZ[i][j + 1] = "J";
                                    MostrarZ();
                                    i = 30;
                                    j = 30;
                                    Errores = 0;
                                } else if ("G".equals(CrearMapaZ[i][j + 1])) {
                                    //tira bot
                                    CrearMapaZ[i][j] = "O";
                                    CrearMapaZ[i][j + 1] = "J";
                                    i = 30;
                                    j = 30;
                                    MostrarZ();
                                    System.out.println("Esta en casilla de oro");
                                    //RecOro();
                                } else {
                                    System.out.println("mo s epuede");
                                    Errores = Errores + 1;
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("No existe el comando");
                    Errores = Errores + 1;
                    OPCIONcOMANDO.reset();
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
        if ((YJ + 2) > Fil - 1) {
            Xfinal = Fil;
        }
        if ((XJ + 2) > Col - 1) {
            Yfinal = Col;
        }
        for (int i = Xinicial; i < Xfinal; i++) {
            for (int j = Yinicial; j < Yfinal; j++) {
                if (CrearMapaZ[i][j] == null) {
                    CrearMapaZ[i][j] = "#";
                }
                if ("#".equals(CrearMapaZ[i][j])) {
                    System.out.print(" " + Var.Azul + CrearMapaZ[i][j] + " ");
                }
                if ("G".equals(CrearMapaZ[i][j])) {
                    System.out.print(" " + Var.Amarillo + CrearMapaZ[i][j] + " ");
                }
                if ("S".equals(CrearMapaZ[i][j])) {
                    System.out.print(Var.Verde + " " + CrearMapaZ[i][j] + " ");
                }
                if ("O".equals(CrearMapaZ[i][j])) {
                    System.out.print(" " + Var.Cyan + CrearMapaZ[i][j] + " ");
                }
                if ("J".equals(CrearMapaZ[i][j])) {
                    System.out.print(" " + Var.White + CrearMapaZ[i][j] + " ");
                }
                if ("B".equals(CrearMapaZ[i][j])) {
                    System.out.print(" " + Var.Rojo + CrearMapaZ[i][j] + " ");
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
        if ((YJ - 5) < 6) {
            Xinicial = 0;
        }
        if ((XJ - 5) < 6) {
            Yinicial = 0;
        }
        if ((YJ + 6) > Fil - 5) {
            Xfinal = Fil;
        }
        if ((XJ + 6) > Col - 5) {
            Yfinal = Col;
        }
        for (int i = Xinicial; i < Xfinal; i++) {
            for (int j = Yinicial; j < Yfinal; j++) {
                if (CrearMapaZ[i][j] == null) {
                    CrearMapaZ[i][j] = "#";
                }
                if ("#".equals(CrearMapaZ[i][j])) {
                    System.out.print(" " + Var.Azul + CrearMapaZ[i][j] + " ");
                }
                if ("G".equals(CrearMapaZ[i][j])) {
                    System.out.print(" " + Var.Amarillo + CrearMapaZ[i][j] + " ");
                }
                if ("S".equals(CrearMapaZ[i][j])) {
                    System.out.print(Var.Verde + " " + CrearMapaZ[i][j] + " ");
                }
                if ("O".equals(CrearMapaZ[i][j])) {
                    System.out.print(" " + Var.Cyan + CrearMapaZ[i][j] + " ");
                }
                if ("J".equals(CrearMapaZ[i][j])) {
                    System.out.print(" " + Var.White + CrearMapaZ[i][j] + " ");
                }
                if ("B".equals(CrearMapaZ[i][j])) {
                    System.out.print(" " + Var.Rojo + CrearMapaZ[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void MoverBotT() {
        Random RanBot = new Random();
        boolean MoverBot = false;
        while (!MoverBot) {
            int Direccion = RanBot.nextInt(4);
            switch (Direccion) {
                case 0:
                    if ("O".equals(CrearMapaZ[YB - 1][XB])) {
                        CrearMapaZ[YB][XB] = "O";
                        CrearMapaZ[YB - 1][XB] = "B";
                        YB = YB - 1;
                        MoverBot = true;
                    } else if ("J".equals(CrearMapaZ[YB - 1][XB])) {
                        System.out.println("Perdio la partida");
                        System.out.println("El bot Mato al jugador");
                        BotAtrapa = BotAtrapa + 1;
                        Noperdidas = Noperdidas + 1;
                        MoverBot = true;
                        SalirJuego = true;
                    }
                    break;
                case 1:
                    if ("O".equals(CrearMapaZ[YB + 1][XB])) {
                        CrearMapaZ[YB][XB] = "O";
                        CrearMapaZ[YB + 1][XB] = "B";
                        YB = YB + 1;
                        MoverBot = true;
                    } else if ("J".equals(CrearMapaZ[YB + 1][XB])) {
                        System.out.println("Perdio la partida");
                        System.out.println("El bot Mato al jugador");
                        BotAtrapa = BotAtrapa + 1;
                        Noperdidas = Noperdidas + 1;
                        MoverBot = true;
                        SalirJuego = true;
                    }
                    break;
                case 2:
                    if ("O".equals(CrearMapaZ[YB][XB - 1])) {
                        CrearMapaZ[YB][XB] = "O";
                        CrearMapaZ[YB][XB - 1] = "B";
                        XB = XB - 1;
                        MoverBot = true;
                    } else if ("J".equals(CrearMapaZ[YB][XB - 1])) {
                        System.out.println("Perdio la partida");
                        System.out.println("El bot Mato al jugador");
                        BotAtrapa = BotAtrapa + 1;
                        Noperdidas = Noperdidas + 1;
                        MoverBot = true;
                        SalirJuego = true;
                    }
                    break;
                case 3:
                    if ("O".equals(CrearMapaZ[YB][XB + 1])) {
                        CrearMapaZ[YB][XB] = "O";
                        CrearMapaZ[YB][XB + 1] = "B";
                        XB = XB + 1;
                        MoverBot = true;
                    } else if ("J".equals(CrearMapaZ[YB][XB + 1])) {
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

    public void MoverZ() {
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
                Comando = OPCIONcOMANDO.nextLine();
                if ("MOVER N".equals(Comando)) {
                    for (int i = 0; i < 30; i++) {
                        for (int j = 0; j < 30; j++) {
                            if ("J".equals(CrearMapaZ[i][j])) {
                                if ("O".equals(CrearMapaZ[i - 1][j])) {
                                    CrearMapaZ[i][j] = "O";
                                    CrearMapaZ[i - 1][j] = "J";
                                    YJ = i - 1;
                                    MoverBotT();
                                    MoverBotT();
                                    Mostrar1x1();
                                    Errores = 0;
                                } else if ("G".equals(CrearMapaZ[i - 1][j])) {
                                    CrearMapaZ[i][j] = "O";
                                    CrearMapaZ[i - 1][j] = "J";
                                    YJ = i - 1;
                                    MoverBotT();
                                    MoverBotT();
                                    Mostrar1x1();
                                    System.out.println("Esta en casilla de oro");
                                    RecOro();
                                } else if ("S".equals(CrearMapaZ[i - 1][j])) {
                                    CrearMapaZ[i][j] = "O";
                                    CrearMapaZ[i - 1][j] = "J";
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
                            if ("J".equals(CrearMapaZ[i][j])) {
                                if ("O".equals(CrearMapaZ[i + 1][j])) {
                                    CrearMapaZ[i][j] = "O";
                                    CrearMapaZ[i + 1][j] = "J";
                                    YJ = i + 1;
                                    MoverBotT();
                                    MoverBotT();
                                    Mostrar1x1();
                                    i = 30;
                                    j = 30;
                                    Errores = 0;
                                } else if ("G".equals(CrearMapaZ[i + 1][j])) {
                                    CrearMapaZ[i][j] = "O";
                                    CrearMapaZ[i + 1][j] = "J";
                                    YJ = i + 1;
                                    i = 30;
                                    j = 30;
                                    MoverBotT();
                                    MoverBotT();
                                    Mostrar1x1();
                                    System.out.println("Esta en casilla de oro");
                                    RecOro();
                                } else if ("S".equals(CrearMapaZ[i + 1][j])) {
                                    CrearMapaZ[i][j] = "O";
                                    CrearMapaZ[i + 1][j] = "J";
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
                            if ("J".equals(CrearMapaZ[i][j])) {
                                if ("O".equals(CrearMapaZ[i][j - 1])) {
                                    CrearMapaZ[i][j] = "O";
                                    CrearMapaZ[i][j - 1] = "J";
                                    XJ = j - 1;
                                    MoverBotT();
                                    MoverBotT();
                                    Mostrar1x1();
                                    Errores = 0;
                                } else if ("G".equals(CrearMapaZ[i][j - 1])) {
                                    //tira bot
                                    CrearMapaZ[i][j] = "O";
                                    CrearMapaZ[i][j - 1] = "J";
                                    XJ = j - 1;
                                    MoverBotT();
                                    MoverBotT();
                                    Mostrar1x1();
                                    System.out.println("Esta en casilla de oro");
                                    RecOro();
                                } else if ("S".equals(CrearMapaZ[i][j - 1])) {
                                    CrearMapaZ[i][j] = "O";
                                    CrearMapaZ[i][j - 1] = "J";
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
                            if ("J".equals(CrearMapaZ[i][j])) {
                                if ("O".equals(CrearMapaZ[i][j + 1])) {
                                    CrearMapaZ[i][j] = "O";
                                    CrearMapaZ[i][j + 1] = "J";
                                    XJ = j + 1;
                                    MoverBotT();
                                    MoverBotT();
                                    Mostrar1x1();
                                    i = 30;
                                    j = 30;
                                    Errores = 0;
                                } else if ("G".equals(CrearMapaZ[i][j + 1])) {
                                    //tira bot
                                    CrearMapaZ[i][j] = "O";
                                    CrearMapaZ[i][j + 1] = "J";
                                    XJ = j + 1;
                                    i = 30;
                                    j = 30;
                                    MoverBotT();
                                    MoverBotT();
                                    Mostrar1x1();
                                    System.out.println("Esta en casilla de oro");
                                    RecOro();
                                } else if ("S".equals(CrearMapaZ[i][j + 1])) {
                                    CrearMapaZ[i][j] = "O";
                                    CrearMapaZ[i][j + 1] = "J";
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
                    OPCIONcOMANDO.reset();
                }
            }

        }
    }

    public void RecOro() {
        System.out.println("Ingrese comando");
        Comando2 = OPCIONcOMANDO.nextLine();
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
        Comando2 = OPCIONcOMANDO.nextLine();
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
