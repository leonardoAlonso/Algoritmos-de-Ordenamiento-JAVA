/**
 * Algoritmos de ordenamiento 
 * bubble sort
 * insertion sort
 * selection sort
 * quicksort
 * @autor Leonardo Alonso
 * 
 * **/

import java.util.Random;
import java.util.Scanner;
public class AlgoritmosOrdenamiento {
	
	static int op;
	static Scanner es = new Scanner(System.in);
	public static void main(String [] args){
		long TIn, TFi, tBurbuja, tSeleccion, tInsercion, tQuick;
		double arrs[] = new double[10000];		
		do{
			System.out.println("Algoritmos de ordenamiento: ");
			System.out.println("[1]Bubble sort ");
			System.out.println("[2]Seleccion sort ");
			System.out.println("[3]Insertion sort ");
			System.out.println("[4]QuickSort ");
			System.out.println("[0]Salir ");
			System.out.print("Ingresa una opcion: ");
			op = es.nextInt();
			switch(op){
				case 1:{
					arrs = arr_ale();
					TIn = System.currentTimeMillis();
					arrs = burbuja(arrs);
					TFi = System.currentTimeMillis();
					imprime(arrs);
					tBurbuja = TFi - TIn;
					System.out.println("El tiempo de bubble sort es: " + tBurbuja + " milisegundos");
					break;
				}
				case 2:{
					arrs = arr_ale();
					TIn = System.currentTimeMillis();
					arrs = selection_sort(arrs);
					TFi = System.currentTimeMillis();
					imprime(arrs);
					tSeleccion = TFi - TIn;
					System.out.println("El tiempo de selection sort es: " + tSeleccion + " milisegundos");
					break;
				}
				case 3:{
					arrs = arr_ale();
					TIn = System.currentTimeMillis();
					arrs = insertion_sort(arrs);
					TFi = System.currentTimeMillis();
					imprime(arrs);
					tInsercion = TFi - TIn;
					System.out.println("El tiempo de insertion sort es: " + tInsercion + " milisegundos");
					break;
				}
				case 4:{
					arrs = arr_ale();
					TIn = System.currentTimeMillis();
					arrs = quick_srt(arrs, 0, arrs.length-1);
					TFi = System.currentTimeMillis();
					imprime(arrs);
					tQuick = TFi - TIn;
					System.out.println("El tiempo de ordenacion de QuickSort es: " + tQuick + " milisegundos");
					break;
				}
				case 0:{
					System.out.println("Adios :3");
					System.exit(0);
				}
				default:{
					System.out.println("Opcion Invalia :( intenta de nuevo");
				}
			}
		}while(op != 0);
				
	}
	
	static double[] burbuja(double array[]){
		double temp;
		for(int i = 1; i < array.length; i++){
			for(int j = 0; j< array.length - 1; j++){
				if(array[j] > array[j+1]){
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		return array;
	}
	
	  public static double[] quick_srt(double array[],int low, int n){
	      int lo = low;
	      int hi = n;
	      if (lo >= n) {
	          return array;
	      }
	      double mid = array[(lo + hi) / 2];
	      while (lo < hi) {
	          while (lo<hi && array[lo] < mid) {
	              lo++;
	          }
	          while (lo<hi && array[hi] > mid) {
	              hi--;
	          }
	          if (lo < hi) {
	              double T = array[lo];
	              array[lo] = array[hi];
	              array[hi] = T;
	          }
	      }
	      if (hi < lo) {
	          int T = hi;
	          hi = lo;
	          lo = T;
	      }
	      quick_srt(array, low, lo);
	      quick_srt(array, lo == low ? lo+1 : lo, n);
	      return array;
	   }
	  
	public static double[] insertion_sort(double array[]){
		for(int i = 1; i < array.length; i++){
			double temp = array[i];
			int j;
			for(j = i - 1; j >=0 && temp < array[j];j--)
				array[j + 1] = array[j];
			array[j + 1] = temp;
		}
		return array;
	}
	
	public static double[] selection_sort(double array[]){
		for(int i = 0; i< array.length - 1; i++){
			int index = i;
			for(int j = i + 1; j < array.length;j++)
				if(array[j] < array[index])
					index = j;
			
			double small = array[index];
			array[index] = array[i];
			array[i] = small;
		}
		return array;
	}	
	public static void imprime(double arr[]){
		for(int i = 0 ; i< arr.length; i++){
			System.out.println(arr[i]);
		}
	}
	public static double[] arr_ale(){
		double arrs[] = new double[10000];
		Random rnd = new Random();
		for(int i = 0; i < 10000; i++){
			arrs[i] = rnd.nextDouble();
		}
		return arrs;
	}
	
}

