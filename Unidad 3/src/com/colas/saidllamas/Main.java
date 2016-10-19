package com.colas.saidllamas;

import java.util.Scanner;

public class Main {
	
	static char[] cola = new char[5]; 
	private static int fre = 0, fin = 0, max = 4;

	public static void main(String[] args) {
		System.out.println("¡Bienvenido/a!");
		inicio();
		int opc = 0;
		do{
			opc = menu();
			if(opc == 1) 		insertar();
			else if(opc == 2)	eliminar();
			else if(opc == 3){
				System.out.println("Fin del programa.");
				break;
			} else System.out.println("Opcion invalida.");
		}while(opc != 3);
	}
	
	private static void inicio(){
		for (int i = 0; i < cola.length; i++) {
			cola[i] = ' ';
		} 
	}
	
	private static int menu(){
		int opc = 0;
		System.out.println("Elija una opcion: ");
		System.out.println("1) Insertar.");
		System.out.println("2) Eliminar.");
		System.out.println("[3] Terminar.");
		try {
			Scanner en = new Scanner(System.in);
			opc = en.nextInt();
		} catch (Exception e) {
			System.out.println("Ocurrio un error.");
		}
		return opc;
	}
	
	private static void insertar(){
		boolean isChar = false;
		char c = ' ';
		//System.out.println(c);
		if(fin == max && fre == 1 || fin+1 == fre){
			System.out.println("Error, no hay espacio.");
			menu();
		}else{
			do{
				Scanner temp = new Scanner(System.in);
				System.out.println("Ingrese caracter");
				c = temp.next().charAt(0);
				isChar = validarExpresion(c);
			}while(!isChar);
			if(fin == max) fin = 1;
			else fin += 1;
			cola[fin] = c;
			if(fre == 0) fre = 1;
			imprimirArreglo();
		}
		
	}
	
	private static void eliminar(){
		if(fre == 0){
			System.out.println("No hay datos");
		}
		else{
			cola[fre] = ' ';
			if(fre == fin){
				fre = 0;
				fin = 0;
			}else{
				if(fre == max) fre = 1;
				else fre += 1;
			}
		}
		imprimirArreglo();
	}
	
	private static boolean validarExpresion(char c){
		//operadores matematicos
		if(c == 'a' | c == 'A' | c == 'b' | c == 'B' | c == 'c' | c == 'C' | c == 'd' | c == 'D' | c == 'e' | c == 'E' | c == 'f' | c == 'F' | c == 'g' | c == 'G' | c == 'h' | c == 'H' | c == 'i' | c == 'I' | c == 'j' | c == 'J' | c == 'k' | c == 'K' | c == 'l' | c == 'L' | c == 'm' | c == 'M' | c == 'n' | c == 'N' | c == 'ñ' | c == 'Ñ' | c == 'o' | c == 'O' | c == 'p' | c == 'P' | c == 'q' | c == 'Q' | c == 'r' | c == 'R' | c == 's' | c == 'S' | c == 't' | c == 'T' | c == 'u' | c == 'U' | c == 'v' | c == 'V' | c == 'w' | c == 'W' | c == 'x' | c == 'X' | c == 'y' | c == 'Y' | c == 'z' | c == 'Z') return true;
		else return false;
	}
	
	private static void imprimirArreglo(){
		String msj = "";
		for (int i = 0; i < cola.length; i++) {
			if(cola[i] == ' ') System.out.print("[ ]  "); 
			else System.out.print("["+cola[i]+"]  ");
			if(fre == i) msj += "Fr    ";
			else if(fin == i) msj += "Fi    ";
			else msj += "     ";
		}
		System.out.println("");
		System.out.print(msj);
		System.out.println("");
	}

}
