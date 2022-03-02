/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Partes;

/**
 *
 * @author Usuario
 */
public class Variables {

    public final static String Negro = "\u001b[30m";
    public final static String Rojo = "\u001b[31m";
    public final static String Verde = "\u001b[32m";
    public final static String Amarillo = "\u001b[33m";
    public final static String Azul = "\u001b[34m";
    public final static String Magenta = "\u001b[35m";
    public final static String Cyan = "\u001b[36m";
    public final static String White = "\u001b[37m";
    public final static String Reset = "\u001b[0m";

    public void Cls() {
        for (int i = 0; i < 30; i++) {
            System.out.println("");
        }
    }

    private static int Fil1, Col1, Fil2, Col2, Fil3, Col3;

    public static int getFil1() {
        return Fil1;
    }

    public static void setFil1(int Fil1) {
        Variables.Fil1 = Fil1;
    }

    public static int getCol1() {
        return Col1;
    }

    public static void setCol1(int Col1) {
        Variables.Col1 = Col1;
    }

    public static int getFil2() {
        return Fil2;
    }

    public static void setFil2(int Fil2) {
        Variables.Fil2 = Fil2;
    }

    public static int getCol2() {
        return Col2;
    }

    public static void setCol2(int Col2) {
        Variables.Col2 = Col2;
    }

    public static int getFil3() {
        return Fil3;
    }

    public static void setFil3(int Fil3) {
        Variables.Fil3 = Fil3;
    }

    public static int getCol3() {
        return Col3;
    }

    public static void setCol3(int Col3) {
        Variables.Col3 = Col3;
    }

}
