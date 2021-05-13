import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class VistaMenúGeneral {
	ListaNúmeros Lista=new ListaNúmeros();
	ArrayList<Double> listaAñadida;
	static String s;
	int respuesta;
	/**
	 * Crea un atajo a la clase PrintStream.
	 */
	private PrintStream out;
	private Scanner in;

	/**
	 * Declara Titulo del menú.
	 */
	private String título;

	/**
	 * Declara las Opciones del menú.
	 */
	private String[] opciones;

	/**
	 * Inicializa la entrada del scanner
	 */

	public void mostrarBienvenida() {
		System.out.println("Bienvenido al programa SumatorioMVC");
		System.out.println("Elije una ópcion:");
	}
	static String getNúmRespuestas() {
		String respuesta=s;
		return respuesta;
	}
	public VistaMenúGeneral(String títuloMenúPrincipal, String[] opcionesMenúPrincipal, Scanner scEntrada) {
		
		título = títuloMenúPrincipal;
		
		opciones = opcionesMenúPrincipal;
		in = scEntrada;
		out = System.out;
	}

	public void mostrarMenú() {
		final String FORMATO_OPCIONES = " 				%d) %s%n";
		System.out.println("██████████████████████████████████████████████████████████████████████");
		out.println(rellenarListado(título.length(), '-'));
		out.println(título);
		out.println(rellenarListado(título.length(), '-'));

		for (int i = 1; i <= opciones.length; i++) {
			out.printf(FORMATO_OPCIONES, i, opciones[i - 1]);
		}
		out.printf(FORMATO_OPCIONES, 0, "SALIR");

	}
	public void mostrarMensaje(String mensaje) {
		out.printf("[SumatorioMVC]%s", mensaje);
	}

	public static String rellenarListado(int longitud, char c) {
		String resultado;

		char[] relleno = new char[longitud];

		Arrays.fill(relleno, c);
		resultado = new String(relleno);

		return resultado;
	}
	public int elegirOpción() {
		String s, mensaje;
		int entrada = -1;

		boolean salir = false;

		do {
			mostrarMenú();
			mostrarBienvenida();

			// Recoger y validar opciones
			try {
				s = in.nextLine();
				entrada = Integer.parseInt(s);
				if (entrada < 0
						|| entrada > opciones.length) {
					throw new ErrorNumberException(
							"Opción no válida");
				}
				salir = true;
			} catch (NumberFormatException e) {
				mostrarMensaje(
						"[MVC] El sistema solo admite números enteros!");
			} catch (ErrorNumberException e) {
				mensaje = String.format(
						"[MVC] Hay que introducir una opción de menú válida (1-%d, 0 para salir)!",
						opciones.length);
				mostrarMensaje(mensaje);
			}
		} while (!salir);
		return entrada;
	}
	ArrayList<String> entradas = new ArrayList<String>();
	public void decirSumandos() {
		System.out.print(entradas);
	}
	public void getSumando() {
		ListaNúmeros grupo = new ListaNúmeros();
		System.out.println("Introduce el Sumando");
		String entrada=in.nextLine();
		
		

		entradas.add(entrada);
		Lista.ejecutar(entradas);
		

	}
}
