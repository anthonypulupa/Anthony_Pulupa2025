

package ec.edu.espoch.anthony_pulupa2025;

import java.util.Scanner;


public class Anthony_Pulupa2025 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        double[] agua = new double[7];
        boolean salir = false;

       
        for (int i = 0; i < 7; i++) {
            double monto;
            do {
                System.out.print("Ingrese los litros consumidos del dia " + (i + 1) + ": ");
                monto = scanner.nextDouble();
                if (monto < 0) {
                    System.out.println("El monto debe ser un numero positivo. Intente de nuevo.");
                }
            } while (monto < 0);
            agua[i] = monto;
        }

        while (!salir) {
            System.out.println("Menu de Opciones:");
            System.out.println("1. Total de litros consumidos en la semana");
            System.out.println("2. Dia con consumo mas cernano al promedio");
            System.out.println("3. Mostrar dia de mayor y menor consumo");
            System.out.println("4. Sumar los consumos de Lunes a Miercoles y de Viernes a Domingo");
            System.out.println("5. Salir ");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    double total = 0;
                    for (double venta : agua) {
                        total += venta;
                    }
                    System.out.println("Total de ventas de la semana: " + total);
                    break;
                    

                case 2:
                    double promedio = 0;
                    for (double venta : agua) {
                        promedio += venta;
                    }
                    promedio /= 7;

                    double diferenciaMinima = Math.abs(agua[0] - promedio);
                    int diaCercano = 0;
                    for (int i = 1; i < 7; i++) {
                        double diferencia = Math.abs(agua[i] - promedio);
                        if (diferencia < diferenciaMinima) {
                            diferenciaMinima = diferencia;
                            diaCercano = i;
                        }
                    }
                    System.out.println("Dia con ventas mas cercanas al promedio: Dia " + (diaCercano + 1));
                    break;

                case 3:
                    double ventaMax = agua[0];
                    double ventaMin = agua[0];
                    int diaMax = 0;
                    int diaMin = 0;
                    for (int i = 1; i < 7; i++) {
                        if (agua[i] > ventaMax) {
                            ventaMax = agua[i];
                            diaMax = i;
                        }
                        if (agua[i] < ventaMin) {
                            ventaMin = agua[i];
                            diaMin = i;
                        } 
                    }
                    System.out.println("Dia con la venta mas alta: Dia " + (diaMax + 1));
                    System.out.println("Dia con la venta mas baja: Dia " + (diaMin + 1));
                    break;

                case 4:
                    double totalPrimerosTres = agua [0] + agua[1] + agua[2];
                    double totalUltimosTres = agua[4] + agua[5] + agua[6];
                    System.out.println("el total de consumo de agua de los dias Lunes,Martes y Miercoles : " + totalPrimerosTres);
                    System.out.println("el total de consumo de agua de los dias Viernes, Sabado y Domingo : " + totalUltimosTres);
                    break;
                case 5:
                    salir = true;
                    System.out.println("Programa Finalizado.");
                    break; 

                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
            }
        }   
    }
}
