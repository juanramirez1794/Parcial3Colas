import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Visitantes> visitantesGuiados = new ArrayList<>();
        ArrayList<Visitantes> visitantesNoGuiados = new ArrayList<>();
        Metodos metodos = new Metodos();

        while (true) {
            System.out.println("=== GESTIÓN DE VISITANTES ===");
            System.out.println("1. Registrar visitante");
            System.out.println("2. Mostrar visitantes");
            System.out.println("3. Cambiar estado de visitante");
            System.out.println("4. Mostrar visitantes por tipo");
            System.out.println("5. Llamar visitante");
            System.out.println("6. Cancelar turno");
            System.out.println("7. Cantidad de visitantes esperando");
            System.out.println("8. Mostrar visitantes pendientes");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    metodos.RegistrarVisitante(visitantesGuiados, visitantesNoGuiados, sc);
                    break;
                case 2:
                    metodos.MostrarVisitantes(visitantesGuiados, visitantesNoGuiados);
                    break;
                case 3:
                    metodos.CambiarEstadoVisitante(visitantesGuiados, visitantesNoGuiados, sc);
                    break;
                case 4:
                    metodos.MostrarVisitantesPorTipo(visitantesGuiados, visitantesNoGuiados, sc);
                    break;
                case 5:
                    metodos.LlamarVisitante(visitantesGuiados, visitantesNoGuiados, sc);
                    break;
                case 6:
                    metodos.CancelarTurno(visitantesGuiados, visitantesNoGuiados, sc);
                    break;
                case 7:
                    metodos.CantidadEsperando(visitantesGuiados, visitantesNoGuiados);
                    break;
                case 8:
                    metodos.MostrarPendientes(visitantesGuiados, visitantesNoGuiados);
                    break;
                case 9:
                    System.out.println("Saliendo del programa.");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }
}