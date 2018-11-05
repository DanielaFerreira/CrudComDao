
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartamentoDAO {

    private static Connection connection = null;
    private static Departamento departamento;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/scesviteste", "root", "");
            connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        return connection;
    }

    public static void disconnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

    public static Departamento getDepartamento() {
        return departamento;
    }

    public static void adicionar(Departamento departamento) {
        String query = "INSERT INTO DEPARTAMENTO VALUES(?,?,?)";
        try (PreparedStatement pst = getConnection().prepareStatement(query)) {
            pst.setString(1, String.valueOf(departamento.getCodigo()));
            pst.setString(2, departamento.getNome());
            pst.setString(3, departamento.getSigla());

            pst.executeUpdate();
            pst.close();
            disconnection();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

    public static void alterar(Departamento departamento) {
        String query = "UPDATE DEPARTAMENTO SET nome = ?, sigla = ? WHERE codigo = ?";
        try (PreparedStatement pst = getConnection().prepareStatement(query)) {
            pst.setString(1, departamento.getNome());
            pst.setString(2, departamento.getSigla());
            pst.setString(3, String.valueOf(departamento.getCodigo()));

            pst.executeUpdate();
            pst.close();
            disconnection();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

    public static void getLista() {
        String query = "SELECT * FROM DEPARTAMENTO";
        try (PreparedStatement pst = getConnection().prepareStatement(query)) {
            ResultSet resultSet = pst.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("codigo"));
                System.out.println(resultSet.getString("nome"));
                System.out.println(resultSet.getString("sigla"));
            }

            pst.close();
            disconnection();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

    public static void deletar(int codigo) {
        String query = "DELETE FROM DEPARTAMENTO WHERE codigo = " + codigo;
        try (PreparedStatement pst = getConnection().prepareStatement(query)) {
            pst.executeUpdate(query);
            pst.close();
            disconnection();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

    public static Departamento pesquisa(int codigo) {
        String query = "SELECT * FROM DEPARTAMENTO WHERE codigo = " + codigo;
        try (PreparedStatement pst = getConnection().prepareStatement(query)) {
            ResultSet resultSet = pst.executeQuery(query);
            while (resultSet.next()) {
            	departamento.setCodigo(resultSet.getInt(codigo));
            	departamento.setNome(resultSet.getString("nome"));
            	departamento.setSigla(resultSet.getString("sigla"));
            	
            	return departamento;
            }

            pst.close();
            disconnection();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        
        return null;
    }

}
