/*
 * CRUD GYM SCORPION
 */
package DAO;

import java.util.List;

/**
 *
 * @author Koke
 */
public interface CRUD {
    public List listar();
    public int add(Object[] o);
    public int actualizar(Object[] o);
    public void eliminar (int id);
    
}
