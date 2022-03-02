package com.mycompany.Partes;

public class Mapa {

    public static Variables Var = new Variables();
    public String Mapa[][] = new String[31][31];
    public static Jugar Jugar = new Jugar();

    public void Mapa1() {
        //----------------------------------- i = y
        //----------------------------------- j = x
        MapaLaberinto1();
        //MostrarMapa1();
    }

    public void Mostrar1x1() {
        int Xinicial = Jugar.YJ -1;
        int Xfinal = Jugar.YJ +2;
        int Yinicial = Jugar.XJ -1;
        int Yfinal = Jugar.XJ +2;
        for (int i = Xinicial; i < Xfinal; i++) {
            for (int j = Yinicial; j < Yfinal; j++) {
                if (Mapa[i][j] == null) {
                    Mapa[i][j] = "#";
                }
                if ("#".equals(Mapa[i][j])) {
                    System.out.print(" " + Var.Azul + Mapa[i][j] + " ");
                }
                if ("G".equals(Mapa[i][j])) {
                    System.out.print(" " + Var.Amarillo + Mapa[i][j] + " ");
                }
                if ("S".equals(Mapa[i][j])) {
                    System.out.print(Var.Verde + " " + Mapa[i][j] + " ");
                }
                if ("O".equals(Mapa[i][j])) {
                    System.out.print(" " + Var.Cyan + Mapa[i][j] + " ");
                }
                if ("J".equals(Mapa[i][j])) {
                    System.out.print(" " + Var.White + Mapa[i][j] + " ");
                }
                if ("B".equals(Mapa[i][j])) {
                    System.out.print(" " + Var.Rojo + Mapa[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void MostrarMapa1() {
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                if (Mapa[i][j] == null) {
                    Mapa[i][j] = "#";
                }
                if ("#".equals(Mapa[i][j])) {
                    System.out.print(" " + Var.Azul + Mapa[i][j] + " ");
                }
                if ("G".equals(Mapa[i][j])) {
                    System.out.print(" " + Var.Amarillo + Mapa[i][j] + " ");
                }
                if ("S".equals(Mapa[i][j])) {
                    System.out.print(Var.Verde + " " + Mapa[i][j] + " ");
                }
                if ("O".equals(Mapa[i][j])) {
                    System.out.print(" " + Var.Cyan + Mapa[i][j] + " ");
                }
                if ("J".equals(Mapa[i][j])) {
                    System.out.print(" " + Var.White + Mapa[i][j] + " ");
                }
                if ("B".equals(Mapa[i][j])) {
                    System.out.print(" " + Var.Rojo + Mapa[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void MapaLaberinto1() {

        //casillas con oro
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {

                //casillas con oro
                if (i == 3 & j == 3 || i == 3 & j == 8 || i == 3 & j == 9 || i == 3 & j == 13 || i == 3 & j == 17 || i == 4 & j == 11 || i == 5 & j == 1 || i == 7 & j == 28 || i == 8 & j == 28 || i == 9 & j == 26 || i == 10 & j == 19 || i == 11 & j == 3 || i == 14 & j == 12 || i == 15 & j == 8 || i == 16 & j == 26 || i == 17 & j == 18 || i == 18 & j == 1 || i == 19 & j == 1 || i == 19 & j == 13 || i == 19 & j == 17 || i == 19 & j == 21 || i == 23 & j == 12 || i == 24 & j == 8 || i == 25 & j == 17 || i == 25 & j == 25 || i == 28 & j == 6 || i == 28 & j == 28) {
                    Mapa[i][j] = "G";
                }

                //casilla de salida
                if (i == 0 & j == 8 || i == 1 & j == 0 || i == 1 & j == 29 || i == 21 & j == 29 || i == 29 & j == 13) {
                    Mapa[i][j] = "S";
                }
            }
        }
        //poner espacios en blanco

        for (int i = 1; i < 30; i++) {

            //renglon No.1
            if (1 <= i & i <= 6 || 8 <= i & i <= 16 || 18 <= i & i <= 25 || i == 27 || i == 28) {
                Mapa[1][i] = "O";
            }

            //renglon No.2
            if (i == 6 || i == 7 || i == 11 || i == 15 || i == 17 || i == 18 || i == 25 || i == 26 || i == 28) {
                Mapa[2][i] = "O";
            }

            //renglon No.3
            if (i == 1 || i == 2 || i == 4 || i == 6 || i == 11 || i == 15 || i == 19 || i == 21 || i == 22 || i == 23 || i == 26 || i == 27 || i == 28) {
                Mapa[3][i] = "O";
            }

            //renglon No.4
            if (i == 1 || i == 4 || 6 <= i & i <= 9 || i == 13 || i == 15 || i == 18 || i == 19 || i == 21 || i == 23 || i == 24 || i == 26 || i == 28) {
                Mapa[4][i] = "O";
            }

            //renglon No.5
            if (i == 3 || i == 4 || i == 6 || i == 13 || i == 15 || i == 16 || i == 17 || i == 19 || i == 21 || i == 26 || i == 28) {
                Mapa[5][i] = "O";
            }

            //renglon No.6
            if (i == 1 || 4 <= i & i <= 9 || i == 11 || 13 <= i & i <= 21 || 23 <= i & i <= 26) {
                Mapa[6][i] = "O";
            }

            //renglon No.7
            if (i == 2 || i == 3 || i == 4 || i == 6 || i == 8 || i == 10 || i == 11 || i == 14 || i == 17 || i == 23 || i == 25) {
                Mapa[7][i] = "O";
            }

            //renglon No.8
            if (i == 1 || i == 2 || i == 4 || i == 6 || i == 7 || i == 8 || i == 10 || i == 12 || i == 14 || i == 15 || i == 17 || i == 19 || i == 20 || i == 21 || i == 22 || i == 23 || i == 25 || i == 26) {
                Mapa[8][i] = "O";
            }

            //renglon No.9
            if (i == 1 || i == 4 || i == 8 || i == 10 || i == 12 || i == 15 || i == 17 || i == 21 || i == 28) {
                Mapa[9][i] = "O";
            }

            //renglon No.10
            if (i == 1 || i == 2 || i == 3 || i == 4 || i == 6 || i == 8 || i == 10 || i == 12 || i == 14 || i == 15 || i == 17 || i == 18 || i == 21 || i == 22 || i == 24 || i == 26 || i == 28) {
                Mapa[10][i] = "O";
            }

            //renglon No.11
            if (i == 5 || i == 6 || i == 7 || i == 8 || i == 10 || i == 12 || i == 15 || i == 21 || i == 23 || i == 26 || i == 28) {
                Mapa[11][i] = "O";
            }

            //renglon No.12
            if (i == 1 || i == 2 || i == 4 || i == 5 || i == 9 || i == 10 || i == 12 || 14 <= i & i <= 24 || i == 26 || i == 28) {
                Mapa[12][i] = "O";
            }

            //renglon No.13
            if (i == 2 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12 || i == 13 || i == 14 || i == 16 || i == 19 || i == 21 || i == 22 || i == 24 || i == 26 || i == 28) {
                Mapa[13][i] = "O";
            }

            //renglon No.14
            if (i == 1 || i == 2 || i == 4 || i == 5 || i == 7 || i == 10 || i == 17 || i == 18 || i == 20 || i == 21 || i == 23 || i == 24 || i == 26 || i == 28) {
                Mapa[14][i] = "O";
            }

            //renglon No.15
            if (i == 2 || i == 5 || i == 6 || i == 7 || i == 10 || i == 14 || 16 <= i & i <= 20 || i == 22 || i == 23 || i == 26 || i == 28) {
                Mapa[15][i] = "O";
            }

            //renglon No.16
            if (i == 1 || i == 2 || i == 4 || i == 5 || i == 7 || i == 10 || i == 11 || i == 13 || i == 14 || i == 16 || i == 22 || i == 24 || i == 28) {
                Mapa[16][i] = "O";
            }

            //renglon No.17
            if (i == 2 || i == 3 || i == 4 || i == 8 || i == 10 || i == 12 || i == 14 || i == 15 || i == 16 || 19 <= i & i <= 25 || i == 28) {
                Mapa[17][i] = "O";
            }

            //renglon No.18
            if (i == 3 || 5 <= i & i <= 8 || i == 10 || i == 11 || 25 <= i & i <= 28) {
                Mapa[18][i] = "O";
            }
            //renglon No.19
            if (3 <= i & i <= 5 || 8 <= i & i <= 12 || 14 <= i & i <= 16 || 18 <= i & i <= 20 || i == 22 || i == 23 || i == 26 || i == 28) {
                Mapa[19][i] = "O";
            }

            //renglon No.20
            if (i == 1 || i == 7 || i == 8 || i == 23 || i == 24 || i == 26) {
                Mapa[20][i] = "O";
            }

            //renglon No.21
            if (i == 1 || 3 <= i & i <= 5 || i == 7 || 9 <= i & i <= 22 || i == 24 || 26 <= i & i <= 28) {
                Mapa[21][i] = "O";
            }
            //renglon No.22
            if (1 <= i & i <= 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 17 || 21 <= i & i <= 24 || i == 26) {
                Mapa[22][i] = "O";
            }

            //renglon No.23
            if (i == 5 || i == 7 || i == 9 || i == 10 || 13 <= i & i <= 15 || 17 <= i & i <= 19 || i == 21 || i == 26 || i == 28) {
                Mapa[23][i] = "O";
            }

            //renglon No.24
            if (i == 1 || 3 <= i & i <= 5 || i == 7 || i == 10 || i == 15 || i == 19 || 21 <= i & i <= 24 || 26 <= i & i <= 28) {
                Mapa[24][i] = "O";
            }

            //renglon No.25
            if (i == 1 || i == 5 || i == 10 || 12 <= i & i <= 15 || i == 19 || i == 23 || i == 28) {
                Mapa[25][i] = "O";
            }
            //renglon No.26
            if (i == 1 || 3 <= i & i <= 12 || i == 14 || i == 15 || i == 17 || 19 <= i & i <= 23 || i == 25 || i == 27 || i == 28) {
                Mapa[26][i] = "O";
            }

            //renglon No.27
            if (i == 1 || i == 11 || i == 13 || i == 17 || i == 19 || 25 <= i & i <= 27) {
                Mapa[27][i] = "O";
            }

            //renglon No.28
            if (1 <= i & i <= 5 || 8 <= i & i <= 11 || 13 <= i & i <= 25 || i == 17) {
                Mapa[28][i] = "O";
            }
        }

    }
}
