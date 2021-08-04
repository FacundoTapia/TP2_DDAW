package clase4client;

import ar.org.centro8.curso.java.aplicaciones.entities.Articulo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import java.util.List;

public class Clase4Client {
    public static void main(String[] args) throws Exception {
        
        String url = "https://servicios.usig.buenosaires.gob.ar/normalizar?direccion=Medrano%20162";
        /*System.out.println("***********************************************");
        System.out.println("Servicio de normalización de direcciones");
        System.out.println(responseBody(url));
        */
        
        url = "http://localhost:8088/Clase6/ArticuloAlta?descripcion=Vaso_Vidrio&costo=90";
        System.out.println("***********************************************");
        System.out.println("Servicio Alta Articulos.");
        System.out.println(responseBody(url));

        url = "http://localhost:8088/Clase6/ArticuloAlta?descripcion=Plato_Porcelana&costo=150";
        System.out.println("***********************************************");
        System.out.println("Servicio Alta Articulos.");
        System.out.println(responseBody(url));

        url = "http://localhost:8088/Clase6/ArticuloAlta?descripcion=Cuchillo_Cocina&costo=990";
        System.out.println("***********************************************");
        System.out.println("Servicio Alta Articulos.");
        System.out.println(responseBody(url));

        url = "http://localhost:8088/Clase6/ArticuloAll";
        System.out.println("***********************************************");
        System.out.println("Servicio ArticuloAll.");
        System.out.println(responseBody(url));

        url = "http://localhost:8088/Clase6/ArticuloLikeDescripcion?descripcion=sand";
        System.out.println("***********************************************");
        System.out.println("Servicio ArticuloLikeDescripcion.");
        System.out.println(responseBody(url));

        url = "http://localhost:8088/Clase6/Login";
        System.out.println("***********************************************");
        String user = "root";
        String pass = "123";
        System.out.println(session(url, user, pass));
        
        url = "http://localhost:8088/Clase6/ArticuloBaja?id=0";
        System.out.println("***********************************************");
        System.out.println("Servicio Articulo Baja");
        System.out.println(responseBody(url));

        
        
        //Armar List JSON
        //Type listType = new TypeToken<List<Articulo>>(){}.getType();
        url = "http://localhost:8088/Clase6/ArticuloAll";
        System.out.println("***********************************************");
        System.out.println("List<Articulo>");
        
        List<Articulo> list = new Gson().
                fromJson(responseBody(url), new TypeToken<List<Articulo>>(){}.getType());
        list.forEach(System.out::println);
    }

    private static String session(String url, String user, String pass){
        //create the http client
        
        return "";
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