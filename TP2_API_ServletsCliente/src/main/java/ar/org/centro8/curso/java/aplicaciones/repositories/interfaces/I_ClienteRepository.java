package ar.org.centro8.curso.java.aplicaciones.repositories.interfaces;

import ar.org.centro8.curso.java.aplicaciones.entities.Cliente;
import ar.org.centro8.curso.java.aplicaciones.enums.tipoDocumento;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface I_ClienteRepository {
    void save(Cliente cliente);
    void remove(Cliente cliente);
    void update(Cliente cliente);
    default Cliente getById(int id){
        return getAll()
                .stream()
                .filter(c->c.getId()==id)
                .findAny()
                .orElse(new Cliente());
    }
    List<Cliente> getAll();
    default List<Cliente> getLikeNombre(String nombre){
        if(nombre == null) return new ArrayList();
        return getAll()
                .stream()
                .filter(c->c!=null && c.getNombre() != null &&
                        c.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }
    default List<Cliente> getLikeApellido(String apellido){
        if(apellido == null) return new ArrayList();
        return getAll()
                .stream()
                .filter(c->c!=null && c.getApellido() != null &&
                        c.getApellido().toLowerCase().contains(apellido.toLowerCase()))
                .collect(Collectors.toList());        
    }
    default List<Cliente> getLikeNombreApellido(String nombre, String apellido){
        if(apellido == null || nombre == null) return new ArrayList();
        return getAll()
                .stream()
                .filter(c->c!=null && c.getApellido() != null && c.getNombre() != null &&
                        c.getApellido().toLowerCase().contains(apellido.toLowerCase()) &&
                        c.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());                    
    }
    default List<Cliente> getLikeNombreApellidoTelefono(String nombre, String apellido, String telefono){
        if(apellido == null || nombre == null || telefono == null) return new ArrayList();
        return getAll()
                .stream()
                .filter(c->c!=null && c.getApellido() != null && c.getNombre() != null && c.getTelefono() != null &&
                        c.getApellido().toLowerCase().contains(apellido.toLowerCase()) &&
                        c.getNombre().toLowerCase().contains(nombre.toLowerCase()) &&
                        c.getTelefono().equals(telefono)) 
                .collect(Collectors.toList());           
    }
    default List<Cliente> getLikeNombreApellidoEmail(String nombre, String apellido, String email){
        if(apellido == null || nombre == null || email == null) return new ArrayList();
        return getAll()
                .stream()
                .filter(c->c!=null && c.getApellido() != null && c.getNombre() != null && c.getEmail() != null &&
                        c.getApellido().toLowerCase().contains(apellido.toLowerCase()) &&
                        c.getNombre().toLowerCase().contains(nombre.toLowerCase()) &&
                        c.getEmail().toLowerCase().contains(email.toLowerCase()))
                .collect(Collectors.toList());           
    }
    default List<Cliente> getLikeNombreApellidoDireccion(String nombre, String apellido, String direccion){
        if(apellido == null || nombre == null || direccion == null) return new ArrayList();
        return getAll()
                .stream()
                .filter(c->c!=null && c.getApellido() != null && c.getNombre() != null && c.getDireccion() != null &&
                        c.getApellido().toLowerCase().contains(apellido.toLowerCase()) &&
                        c.getNombre().toLowerCase().contains(nombre.toLowerCase()) &&
                        c.getDireccion().toLowerCase().contains(direccion.toLowerCase()))
                .collect(Collectors.toList());           
    }
    default List<Cliente> getLikeFenaci(LocalDate fenaci){
        if(fenaci == null) return new ArrayList();
        return getAll()
                .stream()
                .filter(c->c!=null && c.getFenaci() != null &&
                        c.getFenaci().equals(fenaci))
                .collect(Collectors.toList());           
    }
    default List<Cliente> getByDireccion(String direccion){
        if(direccion == null) return new ArrayList();
        return getAll()
                .stream()
                .filter(c->c!=null && c.getDireccion()!= null &&
                        c.getDireccion().toLowerCase().contains(direccion.toLowerCase()))
                .collect(Collectors.toList());
    }
    default List<Cliente> getByEmail(String email){
        if(email == null) return new ArrayList();
        return getAll()
                .stream()
                .filter(c->c!=null && c.getEmail()!= null &&
                        c.getEmail().toLowerCase().contains(email.toLowerCase()))
                .collect(Collectors.toList());
    }
    default List<Cliente> getByTelefono(String telefono){
        if(telefono == null) return new ArrayList();
        return getAll()
                .stream()
                .filter(c->c!=null && c.getTelefono()!= null &&
                        c.getTelefono().equals(telefono))
                .collect(Collectors.toList());
    }
    default List<Cliente> getLikeTipoDocumento(tipoDocumento tipoDocumento){
        if(tipoDocumento == null) return new ArrayList();
        return getAll()
                .stream()
                .filter(c->c!=null && c.getTipoDocumento() != null &&
                        c.getTipoDocumento().equals(tipoDocumento))
                .collect(Collectors.toList());
    }
    default Cliente getByDni(int dni){
        return getAll()
                .stream()
                .filter(c->c.getDni()==dni)
                .findAny()
                .orElse(new Cliente());
    }
    default Cliente getByTipoNumeroDocumento(tipoDocumento tipoDocumento, int dni){
        if(tipoDocumento == null) new ArrayList();
        return getAll()
                .stream()
                .filter(c->c!=null && c.getTipoDocumento() != null &&
                        c.getTipoDocumento().equals(tipoDocumento) &&
                        c.getDni()==dni)
                .findAny()
                .orElse(new Cliente());
    }
}