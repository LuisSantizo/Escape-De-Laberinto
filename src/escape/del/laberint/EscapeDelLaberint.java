/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escape.del.laberint;

import com.mycompany.Partes.MenuPrincipal;
import com.mycompany.Partes.Mapa;
import com.mycompany.Partes.Variables;
import com.mycompany.Partes.Jugar;
import com.mycompany.Partes.CrearMapa;
import com.mycompany.Partes.CrearMapa1Usuario;

public class EscapeDelLaberint {

    public static Variables Var = new Variables();
    public static MenuPrincipal Menup = new MenuPrincipal();
    public static Mapa Mapa1 = new Mapa();
    public static Jugar Jugar = new Jugar();
    public static CrearMapa CrearNuevoM = new CrearMapa();
    public static CrearMapa1Usuario MapaUsuario1 = new CrearMapa1Usuario();

    public static void main(String[] args) {
        
        //inicio de programa, llamado al menu principal 
        Menup.Menu();
    }

}
