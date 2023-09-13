import java.util.ArrayList;
import javax.swing.JOptionPane;

public class App {

    static ArrayList<String> playlist = new ArrayList<>();

    public static void lista() {
        if (playlist.isEmpty()) {
            imprecion();
        } else {
            String linea="";
            for(int i = 0; i<playlist.size();i++)
                linea+= (i+1)+" .- " +playlist.get(i) +"\n";
            JOptionPane.showMessageDialog(null, linea,"PlayList",JOptionPane.DEFAULT_OPTION);
        }
        menu();
    }


    public static void agregar() {
        do {
            String cancion = JOptionPane.showInputDialog("Ingresa el nombre de la canción");
            if (cancion != null && !cancion.isEmpty()) {
                playlist.add(cancion);
            } else {
                problema();break;
            }
        } while (0 == JOptionPane.showConfirmDialog(null, "¿Quieres agregar otra canción?", "Opciones", 0));
        menu();
    }

    public static void actualizar() {
        if (playlist.isEmpty()) {
            imprecion();
        } else {
            do {
                try {
                    String inx = JOptionPane.showInputDialog("Número de canción");
                    if (inx == null) {
                        break;
                    }
                    int index = Integer.parseInt(inx);
                    if (index >= 1 && index <= playlist.size()) {
                        String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre de la canción");
                        playlist.set(index - 1, nuevoNombre);
                    } else {
                        problema();
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Debes ingresar un número válido.");
                    break;
                }
            } while (0 == JOptionPane.showConfirmDialog(null, "¿Quieres actualizar otra canción?", "Opciones", 0));
        }
        menu();
    }

    public static void eliminar() {
        if (playlist.isEmpty()) {
            imprecion();
            menu();
            return;
        }

        do {
            try {
                String inx = JOptionPane.showInputDialog("Número de canción a eliminar");
                if (inx == null) {
                    break;
                }
                int index = Integer.parseInt(inx);
                if (index >= 1 && index <= playlist.size()) {
                    playlist.remove(index - 1);
                } else {
                    problema();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debes ingresar un número válido.");
                break;
            }
        } while (0 == JOptionPane.showConfirmDialog(null, "¿Quieres eliminar otra canción?", "Opciones", 0));
        menu();
    }

    public static void problema() {
        JOptionPane.showMessageDialog(null, "Error, valor inválido. Verifica tu respuesta.");
    }

    public static void imprecion() {
        JOptionPane.showMessageDialog(null, "No tienes canciones agregadas", "Ventana", JOptionPane.DEFAULT_OPTION);
    }

    public static void borrar() {
        if (!playlist.isEmpty()) {
            if (0 == JOptionPane.showConfirmDialog(null, "¿Estás seguro de borrar la lista?", "Borrar", 0)) {
                playlist.clear();
            }
        } else {
            imprecion();
        }
        menu();
    }

    public static void menu() {
        String[] opciones = { "Tu lista", "Agregar canción", "Actualizar", "Eliminar canción", "Borrar", "Salir" };
        int choice = JOptionPane.showOptionDialog(null, "¿Qué quieres hacer?", "Menú", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

        switch (choice) {
            case 0:
                lista();
                break;
            case 1:
                agregar();
                break;
            case 2:
                actualizar();
                break;
            case 3:
                eliminar();
                break;
            case 4:
                borrar();
                break;
            case 5:
                int confirmExit = JOptionPane.showConfirmDialog(null, "¿Estás seguro de salir?", "Salir", 0);
                if (confirmExit == 0) {
                    JOptionPane.showMessageDialog(null, "!Adiós!");
                    System.exit(0);
                } else {
                    menu();
                }
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "!Bienvenido!");
        menu();
    }
}

/*
 * ArrayList <String> corridos = new ArrayList<>();
 * 
 * corridos.add("Fin de semana");
 * 
 * corridos.add("no se baila");
 * 
 * System.out.println(corridos);
 * 
 * System.out.println(corridos.get(1));
 * 
 * System.out.println(corridos.size());
 * 
 * corridos.remove(0);
 * 
 * corridos.add("el queria una cancion");
 * corridos.add("Se fue la luz");
 * corridos.add("Las que no tienen papa");
 * System.out.println(corridos);
 * //set sirve para actualizar la lista de array list
 * 
 * corridos.set(2,"ala enamorada");
 * System.out.println(corridos);
 * 
 * //acomoda los datos de la a-z
 * corridos.xort()
 * 
 * //Borra todo
 * corridos.clear();
 */