import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ApiMonedas consultar = new ApiMonedas();
        int opcion = 0;

        String menu = """
                
        **************************************************************************        
                Sea bienvenido/a al Conversor de Moneda :)
                
                1- Dolar => Peso Argentino
                2- Peso Argentino => Dolar
                3- Dolar => Real brasileño
                4- Real brasileño => Dolar
                5- Dolar => Peso colombiano
                6- Peso colombiano => Dolar
                7- Salir
        ****************************************************************************       
         
                Elija una opcion valida: 
                """;


        Scanner teclado = new Scanner(System.in);

        while (opcion != 7){
            System.out.println(menu);

            try {
            opcion = teclado.nextInt();

            switch (opcion){


                case 1:
                    ConversionDeMoneda.convertir("USD", "ARS", consultar, lectura);
                    break;
                case 2:
                    ConversionDeMoneda.convertir("ARS", "USD", consultar,lectura);
                    break;
                case 3:
                    ConversionDeMoneda.convertir("USD", "BRL", consultar,lectura);
                    break;
                case 4:
                    ConversionDeMoneda.convertir("BRL", "USD", consultar,lectura);
                    break;
                case 5:
                    ConversionDeMoneda.convertir("USD", "COP", consultar,lectura);
                    break;
                case 6:
                    ConversionDeMoneda.convertir("COP", "USD", consultar,lectura);
                    break;
                case 7:
                    System.out.println("Saliendo del programa, gracias por utilizar nuestros servicios");
                    break;
                default:
                    System.out.println("Opcion no valida...");
                }



                }catch (InputMismatchException e){
                    System.out.println("Por favor, ingrese numero.");
                    //Limpia el escáner para evitar un bucle infinito
                    teclado.next();
                }
        }
    }
}
