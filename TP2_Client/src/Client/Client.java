package Client;

import ar.org.centro8.curso.java.aplicaciones.entities.Articulo;
import ar.org.centro8.curso.java.aplicaciones.entities.Cliente;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Client {
    public static void main(String[] args) throws Exception {
        String url = "http://localhost:8088/TP2/ClienteAlta?nombre=Martin&apellido=Tapia&direccion=aguero%201318&email=martin@gmail.com&telefono=1142537485&numeroDocumento=48856666";
        System.out.println("***********************************************");
        System.out.println("Servicio Alta Cliente.");
        System.out.println(responseBody(url));

        url = "http://localhost:8088/TP2/ClienteBaja?id=28";
        System.out.println("***********************************************");
        System.out.println("Servicio Cliente Baja");
        System.out.println(responseBody(url));

        url = "http://localhost:8088/TP2/ClienteAll";
        System.out.println("***********************************************");
        System.out.println("Servicio Cliente All");
        System.out.println(responseBody(url));

        url = "http://localhost:8088/TP2/ClienteLikeApellido?apellido=ga";
        System.out.println("***********************************************");
        System.out.println("Servicio ClienteLikeApellido");
        System.out.println(responseBody(url));
        
        Type listType = new TypeToken<List<Articulo>>(){}.getType();
        url = "http://localhost:8088/TP2/ClienteAll";
        System.out.println("***********************************************");
        System.out.println("List<Cliente>");
        
        List<Cliente> lista = new Gson()
                .fromJson(responseBody(url), new TypeToken<List<Cliente>>(){}.getType());
        lista.forEach(System.out::println);
    }
    
    private static String responseBody(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        response.headers().map().forEach((k, v)->System.out.println(k + " " + v));
        return response.body();
    }
}
