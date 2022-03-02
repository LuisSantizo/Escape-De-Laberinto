package com.mycompany.Partes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {

    Scanner OpcionPrincipal = new Scanner(System.in);

    public static Mapa Mapa1 = new Mapa();
    public static Jugar Jugar = new Jugar();
    public static CrearMapa CrearNuevoM = new CrearMapa();
    public static CrearMapa1Usuario MapaUsuario1 = new CrearMapa1Usuario();
    public static Variables Var = new Variables();

    public boolean salirSM;
    int temporal;
    int Num;
//Hacer el menu principal

    public void Menu() {
        boolean salir = false;
        int Opcion;
        while (!salir) {
            System.out.println("Bienbenido al Laberinto\n");
            System.out.println("1) JUGAR");
            System.out.println("2) CREAR MAPA");
            System.out.println("3) REPORTES");
            System.out.println("4) VISUALIZAR MAPA");
            System.out.println("5) SALIR \n");
            //pedir una opcion, si la ocion es incorrecta pide de nuevo una opcion 
            try {
                System.out.println("Ingrese una opcion:");
                Opcion = OpcionPrincipal.nextInt();
                Var.Cls();
                switch (Opcion) {
                    case 1:
                        Jugarrr();
                        break;
                    case 2:
                        CrearMapas();
                        break;
                    case 3:
                        Reportes();
                        break;
                    case 4:
                        System.out.println("Los mapas son:");
                        System.out.println("Mapa No: 1");
                        Mapa1.MapaLaberinto1();
                        Mapa1.MostrarMapa1();
                        for (int i = 1; i < Num + 1; i++) {
                            System.out.println("Mapa No: " + (i + 1));
                            if (i == 1) {
                                MapaUsuario1.Mostrar();
                            }
                        }
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("No se econtro la opcion\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("debe ser un numero\n");
                OpcionPrincipal.next();
            }
        }
    }

    public void CrearMapas() {
        Num = Num + 1;
        if (Num == 1) {
            MapaUsuario1.Mapa1();
        } else {
            System.out.println("Ya no se puede ingresar mas mapas");
            Num = 1;
        }
    }

    public void Jugarrr() {
        salirSM = false;
        int Opcion;
        while (!salirSM) {
            System.out.println("Elija mapa:");
            System.out.println("1)Salir");
            System.out.println("2)Mapa1: 1");
            int PRO = CrearNuevoM.No;
            for (int i = 1; i < PRO + 1; i++) {
                System.out.println("Mapa No1: " + (i + 1));
            }
            CrearNuevoM.No = PRO;
            try {
                System.out.println("Ingrese una opcion:");
                Opcion = OpcionPrincipal.nextInt();
                //if (Opcion <= CrearNuevoM.No + 1 || Opcion == 5) {
                switch (Opcion) {
                    case 1:
                        salirSM = true;
                        Var.Cls();
                        break;
                    case 2:
                        Jugar.GenararJugador();
                        Jugar.Mover();
                        salirSM = true;
                        break;
                    case 3:
                        if (Num == 1) {
                            MapaUsuario1.JugarM2();
                        } else {
                            Var.Cls();
                            System.out.println("No se econtro la opcion\n");
                        }
                        //Jugar.GenararJugadorM2();
                        break;
                    default:
                        Var.Cls();
                        System.out.println("No se econtro la opcion\n");
                }
            } catch (InputMismatchException e) {
                Var.Cls();
                System.out.println("debe ser un numero\n");
                OpcionPrincipal.next();
            }
        }
    }

    public void Reportes() {
        System.out.println("veces que fue atrapado por el bot: " + Jugar.BotAtrapa);
        System.out.println("partidas ganadas: " + Jugar.PartidasGanadas);
        if (Jugar.NoPartidas != 0) {
            System.out.println("promedio de oro por partida: " + (Jugar.OrpXMapa / Jugar.NoPartidas));
            System.out.println("promedio de movimientos por partida");
        }
        if (1 == 2) {
            System.out.println("mapa más jugado");
        }
        System.out.println("mapa en el que más se ha perdido");
        System.out.println("mapa en el que más se ha ganado");
        System.out.println("total de mapas creados: " + Num);
    }
}
