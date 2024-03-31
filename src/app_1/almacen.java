package app_1;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class almacen {
    
    public int opcion;
    public ArrayList<Zapatilla> Listadezapatillas = new ArrayList<>();
    public int rpta;
    public String modelozapatilla;
    public String continuar = "no";
    
    public void CrearObjetosPredefinidos(){
        List<Integer> tallas1 = new ArrayList<Integer>();
        tallas1.add(39);
        tallas1.add(40);
        tallas1.add(41);
        tallas1.add(42);
        Zapatilla modelo1 = new Zapatilla(tallas1, "nike dunk panda");
        Listadezapatillas.add(modelo1);
        List<Integer> tallas2 = new ArrayList<Integer>();
        tallas2.add(39);
        tallas2.add(40);
        tallas2.add(41);
        tallas2.add(42);
        Zapatilla modelo2 = new Zapatilla(tallas2, "air force 1");
        Listadezapatillas.add(modelo2);
        List<Integer> tallas3 = new ArrayList<Integer>();
        tallas3.add(39);
        tallas3.add(40);
        tallas3.add(41);
        tallas3.add(42);
        Zapatilla modelo3 = new Zapatilla(tallas3, "jordan retro 1");
        Listadezapatillas.add(modelo3);
        List<Integer> tallas4 = new ArrayList<Integer>();
        tallas4.add(39);
        tallas4.add(40);
        tallas4.add(41);
        tallas4.add(42);
        Zapatilla modelo4 = new Zapatilla(tallas4, "dc court graffik");
        Listadezapatillas.add(modelo4);
    }
    
    public void eleccion(){
        String[] arreglo = {"[1] Ingresar tallas nuevas", "[2] Comprobar disponibilidad de tallas", "[3] Ver Lista de modelos"};
        
        opcion = JOptionPane.showOptionDialog(null, "Escoga la accion a realizar",
                "Elija una opcion", 0, JOptionPane.QUESTION_MESSAGE,
                null, arreglo, "");
        
        switch(opcion){
            case 0:
                IngresarModelo(opcion);
                break;
            case 1:
                ComprobarDisponibilidad();
                break;
            case 2:
                ListaModelos();
                break;
        }    
    }
    // CASO LISTA DE MODELOS
    public void ListaModelos(){
        List<String> lista = new ArrayList<String>();
        String modelo;
        for(int i = 0; i < Listadezapatillas.size();i++){
            modelo = Listadezapatillas.get(i).nombre;
            lista.add(modelo);
        }
        JOptionPane.showMessageDialog(null, lista );
        Continuar();
    }
    
    // CASO COMPROBAR TALLA DISPONIBLE
    public void ComprobarDisponibilidad(){
        String modelo = JOptionPane.showInputDialog("Ingrese el nombre del modelo");
        ComprobarExistencia(modelo);
    }
    
    public void ComprobarExistencia(String e){
        int talla = 0;
        int existe = 0;
        for (int i = 0; i < Listadezapatillas.size(); i++) {
            if (e.equals(Listadezapatillas.get(i).nombre)) {
                talla = parseInt(JOptionPane.showInputDialog("¿Que talla busca?"));
                existe++;
            }
        }
        
        if(existe > 0){
            BuscarTalla(talla,e);
        }else{
            JOptionPane.showMessageDialog(null, "No se encuentra registrado ese modelo");
            ComprobarDisponibilidad();
        }
        
    }
    
    public void BuscarTalla(int talla,String modelo){
        int contador = 0;
        for(int i = 0; i < Listadezapatillas.size();i++){
            if( modelo.equals(Listadezapatillas.get(i).nombre)){
                for(int j = 0; j < Listadezapatillas.get(i).tallas.size();j++){
                    if(talla == Listadezapatillas.get(i).tallas.get(j)){
                        contador++;
                    }
                }
            }
        }
        
        if(contador > 0){
            JOptionPane.showMessageDialog(null, "Si esta disponible la talla " + talla 
            + ", Queda [" + contador + "] par(es).");
            Continuar();
        }else{
            JOptionPane.showMessageDialog(null, "No esta disponible esa talla, losiento");
            ComprobarDisponibilidad();
        }
    }
   
    
    // CASO INTRODUCIR TALLAS
    public void IngresarModelo(int e){
        String [] siono = {"Si", "No"};
        if (e == 0) {
            rpta = JOptionPane.showOptionDialog(null, "¿Es modelo nuevo?",
                "Eliga una opcion", 0, JOptionPane.QUESTION_MESSAGE,
                null, siono, "");
            if(rpta == 0) {
                modelozapatilla = JOptionPane.showInputDialog("Ingrese el nombre del modelo");
                ComprobarExistenciaNuevo(modelozapatilla);
            }else if(rpta == 1){
                modelozapatilla = JOptionPane.showInputDialog("Ingrese el nombre del modelo");
                ComprobarExistenciaAntiguo(modelozapatilla);
            }
        } 
    }
    
    public void ComprobarExistenciaNuevo(String e){
        for (int i = 0; i < Listadezapatillas.size(); i++) {
            if (e.equals(Listadezapatillas.get(i).nombre)) {
                JOptionPane.showMessageDialog(null, "El modelo ingresado ya existe, \nIngrese un modelo nuevo porfavor.");
                IngresarModelo(opcion);
            }
        }
        IngresarTallas(e);
    }
    
    public void ComprobarExistenciaAntiguo(String e){
        int i;
        int verificacion=0;
        for (i = 0; i < Listadezapatillas.size(); i++) {
            if(e.equals(Listadezapatillas.get(i).nombre)){
                verificacion++;
                break;
            }
        }
        if(verificacion == 1){
            AñadirTallas(e);
        }else{
            JOptionPane.showInputDialog("El modelo ingresado no existe, \nIngrese un modelo ya registrado porfavor.");
        }    
    }
    
    public void AñadirTallas(String e){
        int contadorDePares;
        contadorDePares = parseInt(JOptionPane.showInputDialog("Cuantas tallas va a ingresar"));
        for(int j = 0; j < contadorDePares; j++){
            int talla = parseInt(JOptionPane.showInputDialog("Ingrese la talla 1 por 1"));
            if((talla > 25 && talla < 46)){
                for(int i = 0; i < Listadezapatillas.size();i++){
                    if(e.equals(Listadezapatillas.get(i).nombre)){
                        Listadezapatillas.get(i).tallas.add(talla);
                    }
                }
            }else if(!(talla > 25 && talla < 46)){
                JOptionPane.showMessageDialog(null, "Talla denegada, solo tallas del 26 al 45");
                j--;
            }
        }
        JOptionPane.showMessageDialog(null, "Tallas Añadidas correctamente.");
        Continuar();
        //System.out.println(Listadezapatillas.get(0).tallas.size());
    }
    
    public void IngresarTallas(String e){
        int talla;
        int contadorDePares;
        List<Integer> tallasAgregadas = new ArrayList<Integer>();
        int i = 0;
        contadorDePares = parseInt(JOptionPane.showInputDialog("Cuantas tallas va a ingresar"));
        do{ 
            talla = parseInt(JOptionPane.showInputDialog("Ingrese la talla 1 por 1"));
            if((talla > 25 && talla < 46)){
                tallasAgregadas.add(talla);
            }else if(!(talla > 25 && talla < 46)){
                JOptionPane.showMessageDialog(null, "Talla denegada, solo tallas del 26 al 45");
                i--;
            }
            i++;
        }while(i < contadorDePares);
        RegistrarModelo(tallasAgregadas, e);
        JOptionPane.showMessageDialog(null, "Tallas introducidas correctamente.");
        Continuar();
    } 
    
    public void RegistrarModelo(List<Integer> tallas,String e){
            
            Zapatilla añadido = new Zapatilla(tallas, e);
            Listadezapatillas.add(añadido);
            //System.out.println(Listadezapatillas.size());
    }
    
    // SEGUIR USANDO
    
    public void Continuar(){
        String [] opciones = {"Continuar","Finalizar"};
        int seleccion = JOptionPane.showOptionDialog(null, "¿Desea continuar?", "Continuar", 0,
                JOptionPane.QUESTION_MESSAGE, null, opciones, null);
        if(seleccion == 0){
            eleccion();
        }
    }
    
    public static void main(String[] args) {
        almacen w = new almacen();
        w.CrearObjetosPredefinidos();
        w.eleccion();
    }
    
}
