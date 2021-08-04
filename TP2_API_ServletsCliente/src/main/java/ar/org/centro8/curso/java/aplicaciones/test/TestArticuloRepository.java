package ar.org.centro8.curso.java.aplicaciones.test;

import ar.org.centro8.curso.java.aplicaciones.entities.Articulo;
import ar.org.centro8.curso.java.aplicaciones.enums.Temporada;
import ar.org.centro8.curso.java.aplicaciones.enums.Tipo;
import ar.org.centro8.curso.java.aplicaciones.repositories.interfaces.I_ArticuloRepository;
import ar.org.centro8.curso.java.aplicaciones.repositories.interfaces.list.ArticuloRepositoryFactory;
import ar.org.centro8.curso.java.aplicaciones.repositories.jdbc.ArticuloRepository;
import ar.org.centro8.curso.java.connectors.Connector;

public class TestArticuloRepository {
    public static void main(String[] args) {
        //I_ArticuloRepository ar = ArticuloRepositoryFactory.getArticuloRepository();
        I_ArticuloRepository ar = new ArticuloRepository(Connector.getConnection());
        
        ar.save(null);
        ar.save(new Articulo("Bota de cuero", Tipo.CALZADO, "Rojo", "36", 20, 10, 40, 100, 500, Temporada.INVIERNO));
        ar.save(new Articulo("Remera", Tipo.ROPA, "Rojo", "L", 20, 10, 40, 200, 600, Temporada.VERANO));
        ar.save(new Articulo("Blusa", Tipo.ROPA, "Rojo", "M", 20, 10, 40, 200, 600, Temporada.OTOÑO));
        ar.save(new Articulo("Sandalia", Tipo.CALZADO, "Rojo", "36", 20, 10, 40, 250, 750, Temporada.VERANO));
        
        ar.remove(ar.getById(32));
        ar.remove(ar.getById(26));
        
        Articulo articulo = ar.getById(8);
        if(articulo != null && articulo.getId()!=0){
            articulo.setColor("ROJO");
            ar.update(articulo);
        }
        
        ar.getAll().forEach(System.out::println);
        System.out.println("**************************************");
        ar.getLikeDescripcion("sa").forEach(System.out::println);
    }
}
