/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salvaend;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.*;

/**
 *
 * @author Administrador
 */
@WebService(serviceName = "SalvaEnd")
public class SalvaEnd {

    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "salvaEnd")
    public String salvaEnd(@WebParam(name = "cep") String cep, @WebParam(name = "rua") String rua, @WebParam(name = "bairro") String bairro, @WebParam(name = "cidade") String cidade, @WebParam(name = "uf") String uf) {
        
        String status = "";
        String sql = "";
        Connection connection = null;  
        try
        {  
            String driverName = "org.gjt.mm.mysql.Driver";
            Class.forName(driverName);
            String serverName = "localhost";  
            String mydatabase = "aula";  
            String url = "jdbc:mysql://" + serverName +  "/" + mydatabase;  
            String username = "root";  
            String password = "";  
            connection = DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement();  
           
            sql = "INSERT into endereco values('"+cep+"','"+rua+"','"+bairro+"','"+cidade+"','"+uf+"')";  
            if(stmt.executeUpdate(sql) == 1)
            {
                status = "Dados inseridos com sucesso!!!";
            }
            else
            {
                status = "Falha no cadastro dos dados!!!";
            }
        }
        catch (ClassNotFoundException e)
        {  
            status = e.getMessage();
        }
        catch (SQLException e)
        {  
            status = e.getMessage();
        }
       
        return status;     
    }
}
