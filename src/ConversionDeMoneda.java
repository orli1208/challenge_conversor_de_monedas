import java.util.Scanner;

public class ConversionDeMoneda {

    public static void convertir(String tipoDeMoneda, String monedaAConvertir, ApiMonedas consulta, Scanner lectura) {
        double cantidad;
        double cantidadConvertida;

        //Buscar las monedas y verificar si se obtiene un resultado válido
        Monedas monedas = consulta.buscarMoneda(tipoDeMoneda, monedaAConvertir);

        if (monedas == null) {
            System.out.println("No se pudo obtener la tasa de conversión.");
            return;
        }

        System.out.println("Ingrese el valor que deseas convertir de " + tipoDeMoneda + " a " + monedaAConvertir + ":");

        //Aquí se creó un bloque try-catch para manejar la excepción si el usuario ingresa un valor no numérico.
        try {
            cantidad = Double.parseDouble(lectura.nextLine());

            //Calcula el valor convertido multiplicando la cantidad ingresada
            cantidadConvertida = cantidad * monedas.conversion_rate();

            System.out.printf("El valor " + cantidad + " " + tipoDeMoneda + " corresponde al valor final de =>> " + cantidadConvertida + " " + monedaAConvertir);
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un número válido.");
        }
    }
}

