import java.util.Scanner;
import java.util.ArrayList;

public class Metodos {
    public void RegistrarVisitante(ArrayList<Visitantes> visitantesGuiados, ArrayList<Visitantes> visitantesNoGuiados, Scanner sc) {
        Visitantes v = new Visitantes();

        System.out.println("Ingrese el nombre del visitante:");
        v.setNombre(sc.nextLine());

        System.out.println("Ingrese el tipo de visita");
        System.out.println("1. Guiada");
        System.out.println("2. No guiada");
        v.setTipoVisita(sc.nextInt());
        sc.nextLine();
        v.setTipoVisita(0);
        v.setEstado(true);
        v.setTurno(GenerarTurno(visitantesNoGuiados, visitantesGuiados, sc));
        
        if (v.getTipoVisita() == 1) {
            visitantesGuiados.add(v);
        } else {
            visitantesNoGuiados.add(v);
        }
            System.out.println("Visitante registrado con éxito.");
            System.out.println("Su turno es: " + v.getTurno());
            System.out.println("==================================");
    }
        
    
    public int GenerarTurno(ArrayList<Visitantes> visitantesGuiados, ArrayList<Visitantes> visitantesNoGuiados, Scanner sc) {
        return visitantesGuiados.size() + visitantesNoGuiados.size() + 1;
    }
    public void MostrarVisitantes(ArrayList<Visitantes> visitantesGuiados, ArrayList<Visitantes> visitantesNoGuiados) {
        System.out.println("Lista de visitantes:");
        for (Visitantes v : visitantesGuiados) {
            if (v.isEstado()) {
                MostrarDatos(v);
            }
        }
        for (Visitantes v : visitantesNoGuiados) {
            if (v.isEstado()) {
                MostrarDatos(v);
            }
        }
    }
    private void mostrarDatos(Visitantes v) {
        System.out.println("==================================");
        System.out.println("Nombre: " + v.getNombre());
        System.out.println("Turno: " + v.getTurno());
        System.out.println("Tipo de visita: " + (v.getTipoVisita() == 1 ? "Guiada" : "No guiada"));
        System.out.println("Estado: " + (v.isEstado() ? "Activo" : "Inactivo"));
        System.out.println("==================================");
    }

    public void CambiarEstadoVisitante(ArrayList<Visitantes> visitantesGuiados, ArrayList<Visitantes> visitantesNoGuiados, Scanner sc) {
        System.out.println("==================================");
        System.out.println("Ingrese el turno del visitante que desea cambiar de estado:");
        int turno = sc.nextInt();
        sc.nextLine();
        boolean encontrado = false;

        for (Visitantes v : visitantesGuiados) {
            if (v.getTurno() == turno) {
                v.setEstado(!v.isEstado());
                encontrado = true;
                System.out.println("El estado del visitante con turno " + turno + " ha sido cambiado a " + (v.isEstado() ? "Activo" : "Inactivo"));
                break;
            }
        }

        if (!encontrado) {
            for (Visitantes v : visitantesNoGuiados) {
                if (v.getTurno() == turno) {
                    v.setEstado(!v.isEstado());
                    encontrado = true;
                    System.out.println("El estado del visitante con turno " + turno + " ha sido cambiado a " + (v.isEstado() ? "Activo" : "Inactivo"));
                    break;
                }
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró un visitante con el turno ingresado.");
        }
        System.out.println("==================================");
    }
    public void MostrarVisitantesPorTipo(ArrayList<Visitantes> visitantesGuiados, ArrayList<Visitantes> visitantesNoGuiados, Scanner sc) {
        System.out.println("==================================");
        System.out.println("Ingrese el tipo de visita que desea mostrar:");
        System.out.println("1. Guiada");
        System.out.println("2. No guiada");
        int tipoVisita = sc.nextInt();
        sc.nextLine();

        if (tipoVisita == 1) {
            System.out.println("Lista de visitantes guiados:");
            for (Visitantes v : visitantesGuiados) {
                if (v.isEstado()) {
                    MostrarDatos(v);
                }
            }
            System.out.println("==================================");
        } else if (tipoVisita == 2) {
            System.out.println("Lista de visitantes no guiados:");
            for (Visitantes v : visitantesNoGuiados) {
                if (v.isEstado()) {
                    MostrarDatos(v);
                }
            }
            System.out.println("==================================");
        } else {
            System.out.println("Tipo de visita inválido.");
        }
    }
    public void LlamarVisitante(ArrayList<Visitantes> visitantesGuiados, ArrayList<Visitantes> visitantesNoGuiados, Scanner sc) {
        System.out.println("==================================");
        System.out.println("Ingrese el turno del visitante que desea llamar:");
        int turno = sc.nextInt();
        sc.nextLine();
        boolean encontrado = false;

        for (Visitantes v : visitantesGuiados) {
            if (v.getTurno() == turno) {
                System.out.println("Llamando al visitante guiado: " + v.getNombre());
                encontrado = true;
                return;
            }
        }

        if (!encontrado) {
            for (Visitantes v : visitantesNoGuiados) {
                if (v.getTurno() == turno) {
                    System.out.println("Llamando al visitante no guiado: " + v.getNombre());
                    encontrado = true;
                    return;
                }
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró un visitante con el turno ingresado.");
        }
    }
    public void CancelarTurno(ArrayList<Visitantes> visitantesGuiados, ArrayList<Visitantes> visitantesNoGuiados, Scanner sc) {
        System.out.println("==================================");
        System.out.println("Ingrese el turno del visitante que desea cancelar.");
        int turno = sc.nextInt();

        for (int i = 0; i < visitantesGuiados.size(); i++) {
            if (visitantesGuiados.get(i).getTurno() == turno) {
                visitantesGuiados.remove(i);
                System.out.println("Turno cancelado para el visitante con turno: " + turno);
                return;
            }
        }

        for (int i = 0; i < visitantesNoGuiados.size(); i++) {
            if (visitantesNoGuiados.get(i).getTurno() == turno) {
                visitantesNoGuiados.remove(i);
                System.out.println("Turno cancelado para el visitante con turno: " + turno);
                return;
            }
        }
        System.out.println("No se encontró un visitante con el turno ingresado.");
    }
    public void BuscarVisitante(ArrayList<Visitantes> visitantesGuiados, ArrayList<Visitantes> visitantesNoGuiados, Scanner sc) {
        System.out.println("Ingrese el nombre del visitante que desea buscar:");
        String nombre = sc.nextLine();
        boolean encontrado = false;

        for (Visitantes v : visitantesGuiados) {
            if (v.getNombre().equalsIgnoreCase(nombre)) {
                MostrarDatos(v);
                encontrado = true;
            }
        }

        for (Visitantes v : visitantesNoGuiados) {
            if (v.getNombre().equalsIgnoreCase(nombre)) {
                MostrarDatos(v);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró un visitante con el nombre ingresado.");
        }
    }
    public void CantidadEsperando(ArrayList<Visitantes> visitantesGuiados, ArrayList<Visitantes> visitantesNoGuiados) {
        int cantidadGuiados = 0;
        int cantidadNoGuiados = 0;

        for (Visitantes v : visitantesGuiados) {
            if (v.isEstado()) {
                cantidadGuiados++;
            }
        }

        for (Visitantes v : visitantesNoGuiados) {
            if (v.isEstado()) {
                cantidadNoGuiados++;
            }
        }

        System.out.println("Cantidad de visitantes guiados esperando: " + cantidadGuiados);
        System.out.println("Cantidad de visitantes no guiados esperando: " + cantidadNoGuiados);
    }
    public void MostrarPendientes(ArrayList<Visitantes> visitantesGuiados, ArrayList<Visitantes> visitantesNoGuiados) {
        System.out.println("Visitantes guiados pendientes:");
        for (Visitantes v : visitantesGuiados) {
            if (v.isEstado()) {
                MostrarDatos(v);
            }
        }

        System.out.println("Visitantes no guiados pendientes:");
        for (Visitantes v : visitantesNoGuiados) {
            if (v.isEstado()) {
                MostrarDatos(v);
            }
        }
    }
    private void MostrarDatos(Visitantes v) {
        System.out.println("Nombre: " + v.getNombre());
        System.out.println("Turno: " + v.getTurno());
        System.out.println("Tipo de visita: " + (v.getTipoVisita() == 1 ? "Guiada" : "No guiada"));
        System.out.println("Estado: " + (v.isEstado() ? "Activo" : "Inactivo"));
        System.out.println("-------------------------");
        
        if (v.getTipoVisita() == 1) {
            System.out.println("Visitante guiado");
        } else if (v.getTipoVisita() == 2) {
            System.out.println("Visitante no guiado");
        } else {
            System.out.println("Tipo de visita desconocido");
        }

    }
}
