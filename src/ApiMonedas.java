import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiMonedas {

    public Monedas buscarMoneda(String tipoDeMoneda, String monedaCambio){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/b36556bf5c78d38595f18998/pair/"+tipoDeMoneda+"/"+monedaCambio);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Monedas.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontro este tipo de moneda.");
        }
    }

}
