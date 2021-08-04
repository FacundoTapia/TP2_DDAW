package ar.org.centro8.curso.java.aplicaciones.repositories.jdbc;

import ar.org.centro8.curso.java.aplicaciones.entities.Articulo;
import ar.org.centro8.curso.java.aplicaciones.entities.Cliente;
import ar.org.centro8.curso.java.aplicaciones.enums.Temporada;
import ar.org.centro8.curso.java.aplicaciones.enums.Tipo;
import ar.org.centro8.curso.java.aplicaciones.enums.tipoDocumento;
import ar.org.centro8.curso.java.aplicaciones.repositories.interfaces.I_ClienteRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository implements I_ClienteRepository{
    private Connection conn;

    public ClienteRepository(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void save(Cliente cliente) {
        try(PreparedStatement ps = conn.prepareStatement("insert into clientes(nombre, apellido, direccion, email, telefono, tipoDocumento, numeroDocumento) values(?,?,?,?,?,?,?)",
            PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            //ps.setDate(3, LocalDateConverter(cliente.getFenaci()));
            ps.setString(3, cliente.getDireccion());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getTelefono());
            ps.setString(6, cliente.getTipoDocumento().toString());
            ps.setInt(7, cliente.getDni());
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) cliente.setId(rs.getInt(1));            
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void remove(Cliente cliente) {
        try(PreparedStatement ps = conn.prepareStatement("delete from clientes where id = ?")){
            ps.setInt(1, cliente.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(Cliente cliente) {
        try(PreparedStatement ps = conn.prepareStatement("update clientes set nombre = ?, apellido = ?, "
            + "direccion = ?, email = ?, telefono = ?, tipoDocumento = ?, numeroDocumento = ? where id = ?")){
                ps.setString(1, cliente.getNombre());
                ps.setString(2, cliente.getApellido());
                //ps.setDate(3, LocalDateConverter(cliente.getFenaci()));
                ps.setString(3, cliente.getDireccion());
                ps.setString(4, cliente.getEmail());
                ps.setString(5, cliente.getTelefono());
                ps.setString(6, cliente.getTipoDocumento().toString());
                ps.setInt(7, cliente.getDni());            
                ps.setInt(8, cliente.getId());
                ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Cliente> getAll() {
        List<Cliente> list = new ArrayList();
        
        try(ResultSet rs = conn.createStatement().executeQuery("select * from clientes")){
            while (rs.next()) {
                list.add(
                        new Cliente(
                                rs.getInt("id"), 
                                rs.getString("nombre"), 
                                rs.getString("apellido"),
                                rs.getString("direccion"), 
                                rs.getString("email"), 
                                rs.getString("telefono"), 
                                tipoDocumento.valueOf(rs.getString("tipoDocumento")), 
                                rs.getInt("numeroDocumento"))
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return list;
    }
    
    public java.sql.Date LocalDateConverter(LocalDate ld){
        return java.sql.Date.valueOf(ld);
    }    
}