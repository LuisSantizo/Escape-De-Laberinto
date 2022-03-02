package com.mycompany.Partes;

import static com.mycompany.Partes.Mapa.Var;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CrearMapa {

    Scanner ScanerCrearMatriz = new Scanner(System.in);
    Scanner sInO = new Scanner(System.in);
    public int No, No2, Fil, Col, Mf, Mc;
    public int Fil1, Col1, Fil2, Col2, Fil3, Col3;
    public String CrearMapa[][] = new String[50][50];
    public String CrearMapa2[][] = new String[50][50];
    public String CrearMapa3[][] = new String[50][50];
    int Opcion;
    boolean salir1 = false;
    int P = 0;

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
                        No = No + 1;
                        No2 = No2 + 1;
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
        if (No == 1) {
            Var.setFil1(Fil);
            Var.setCol1(Col);
//            Fil1 = Fil;
//            Col1 = Col;
            for (int i = 0; i < Fil; i++) {
                for (int j = 0; j < Col; j++) {
                    if (CrearMapa[i][j] == null) {
                        CrearMapa[i][j] = "O";
                    }
                }
            }
            CambiarCasillaM1();
        } else if (No == 2) {
            Var.setFil2(Fil);
            Var.setCol2(Col);
//            Fil2 = Fil;
//            Col2 = Col;
            for (int i = 0; i < Fil; i++) {
                for (int j = 0; j < Col; j++) {
                    if (CrearMapa2[i][j] == null) {
                        CrearMapa2[i][j] = "O";
                    }
                }
            }
            CambiarCasillaM1();
        } else if (No == 3) {
            Var.setFil3(Fil);
            Var.setCol3(Col);
//            Fil3 = Fil;
//            Col3 = Col;
            for (int i = 0; i < Fil; i++) {
                for (int j = 0; j < Col; j++) {
                    if (CrearMapa3[i][j] == null) {
                        CrearMapa3[i][j] = "O";
                    }
                }
            }
            CambiarCasillaM1();
        } else {
            System.out.println("Ya no se puede ingresar mas mapas");
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
                                    if (No == 1) {
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
                                    } else if (No == 2) {
                                        switch (OPP) {
                                            case 1:
                                                CrearMapa2[i][j] = "S";
                                                salir2 = true;
                                                salirAsignacion();
                                                break;
                                            case 2:
                                                CrearMapa2[i][j] = "G";
                                                salir2 = true;
                                                salirAsignacion();
                                                break;
                                            case 3:
                                                CrearMapa2[i][j] = "#";
                                                salir2 = true;
                                                salirAsignacion();
                                                break;
                                            case 4:
                                                CrearMapa2[i][j] = "O";
                                                salir2 = true;
                                                salirAsignacion();
                                                break;
                                            case 5:
                                                CrearMapa2[i][j] = "O";
                                                salir2 = true;
                                                salirAsignacion();
                                                break;
                                            default:
                                                System.out.println("No se econtro la opcion\n");
                                        }
                                    } else if (No == 3) {
                                        switch (OPP) {
                                            case 1:
                                                CrearMapa3[i][j] = "S";
                                                salir2 = true;
                                                salirAsignacion();
                                                break;
                                            case 2:
                                                CrearMapa3[i][j] = "G";
                                                salir2 = true;
                                                salirAsignacion();
                                                break;
                                            case 3:
                                                CrearMapa3[i][j] = "#";
                                                salir2 = true;
                                                salirAsignacion();
                                                break;
                                            case 4:
                                                CrearMapa3[i][j] = "O";
                                                salir2 = true;
                                                salirAsignacion();
                                                break;
                                            case 5:
                                                CrearMapa3[i][j] = "O";
                                                salir2 = true;
                                                salirAsignacion();
                                                break;
                                            default:
                                                System.out.println("No se econtro la opcion\n");
                                        }
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
                //No = No + 1;
            } else if ("NO".equals(Sal)) {
                RRRRR = true;
            } else {
                System.out.println("Opcion no valida-----");
            }
        }
    }

    public void Mostrar() {
        if (No == 1) {
            for (int i = 0; i < Var.getFil1(); i++) {
                for (int j = 0; j < Var.getCol1(); j++) {
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
                }
                System.out.println();
            }
        } else if (No == 2) {
            for (int i = 0; i < Var.getFil2(); i++) {
                for (int j = 0; j < Var.getCol2(); j++) {
                    if ("#".equals(CrearMapa2[i][j])) {
                        System.out.print(" " + Var.Azul + CrearMapa2[i][j] + " ");
                    }
                    if ("G".equals(CrearMapa2[i][j])) {
                        System.out.print(" " + Var.Amarillo + CrearMapa2[i][j] + " ");
                    }
                    if ("S".equals(CrearMapa2[i][j])) {
                        System.out.print(Var.Verde + " " + CrearMapa2[i][j] + " ");
                    }
                    if ("O".equals(CrearMapa2[i][j])) {
                        System.out.print(" " + Var.Cyan + CrearMapa2[i][j] + " ");
                    }
                    if ("J".equals(CrearMapa2[i][j])) {
                        System.out.print(" " + Var.White + CrearMapa2[i][j] + " ");
                    }
                }
                System.out.println();
            }
        } else if (No == 3) {
            for (int i = 0; i < Var.getFil3(); i++) {
                for (int j = 0; j < Var.getCol3(); j++) {
                    if ("#".equals(CrearMapa3[i][j])) {
                        System.out.print(" " + Var.Azul + CrearMapa3[i][j] + " ");
                    }
                    if ("G".equals(CrearMapa3[i][j])) {
                        System.out.print(" " + Var.Amarillo + CrearMapa3[i][j] + " ");
                    }
                    if ("S".equals(CrearMapa3[i][j])) {
                        System.out.print(Var.Verde + " " + CrearMapa3[i][j] + " ");
                    }
                    if ("O".equals(CrearMapa3[i][j])) {
                        System.out.print(" " + Var.Cyan + CrearMapa3[i][j] + " ");
                    }
                    if ("J".equals(CrearMapa3[i][j])) {
                        System.out.print(" " + Var.White + CrearMapa3[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }
    }

    public void MostrarM1() {
        for (int i = 0; i < Fil1; i++) {
            for (int j = 0; j < Col1; j++) {
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
            }
            System.out.println();
        }
    }

    public void MostrarM2() {
        for (int i = 0; i < Var.getFil2(); i++) {
            for (int j = 0; j < Var.getCol2(); j++) {
                if ("#".equals(CrearMapa2[i][j])) {
                    System.out.print(" " + Var.Azul + CrearMapa2[i][j] + " ");
                }
                if ("G".equals(CrearMapa2[i][j])) {
                    System.out.print(" " + Var.Amarillo + CrearMapa2[i][j] + " ");
                }
                if ("S".equals(CrearMapa2[i][j])) {
                    System.out.print(Var.Verde + " " + CrearMapa2[i][j] + " ");
                }
                if ("O".equals(CrearMapa2[i][j])) {
                    System.out.print(" " + Var.Cyan + CrearMapa2[i][j] + " ");
                }
                if ("J".equals(CrearMapa2[i][j])) {
                    System.out.print(" " + Var.White + CrearMapa2[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void MostrarM3() {
        for (int i = 0; i < Var.getFil3(); i++) {
            for (int j = 0; j < Var.getCol3(); j++) {
                if ("#".equals(CrearMapa3[i][j])) {
                    System.out.print(" " + Var.Azul + CrearMapa3[i][j] + " ");
                }
                if ("G".equals(CrearMapa3[i][j])) {
                    System.out.print(" " + Var.Amarillo + CrearMapa3[i][j] + " ");
                }
                if ("S".equals(CrearMapa3[i][j])) {
                    System.out.print(Var.Verde + " " + CrearMapa3[i][j] + " ");
                }
                if ("O".equals(CrearMapa3[i][j])) {
                    System.out.print(" " + Var.Cyan + CrearMapa3[i][j] + " ");
                }
                if ("J".equals(CrearMapa3[i][j])) {
                    System.out.print(" " + Var.White + CrearMapa3[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
