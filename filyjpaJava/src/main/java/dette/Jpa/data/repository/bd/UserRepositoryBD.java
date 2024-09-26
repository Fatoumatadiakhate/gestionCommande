package dette.Jpa.data.repository.bd;

import java.util.List;

import dette.Jpa.core.repository.impl.RepositoryBDImpl;
import dette.Jpa.data.entities.User;
import dette.Jpa.data.enums.RoleEnum;
import dette.Jpa.data.repository.UserRepository;

import java.util.ArrayList;
import java.sql.*;


public class UserRepositoryBD extends RepositoryBDImpl<User> implements UserRepository {

    public UserRepositoryBD(){
        this.tableName = "user";
    }
    @Override
    public User selectByLogin(String login) {
        User result = null;
 
        try {
            String sql = String.format("select * from %s where login like ?",this.tableName);
            this.getConnection();
            this.initPreparedStatement(sql);

            this.ps.setString(1, login);
           
            ResultSet rs = this.executeQuery();
            if (rs.next()) {
                result = this.convertToObject(rs);
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("Erreur de chargement : " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public void insert(User data) {
        // 1-OuvreConnexion
        try {
            // Generer Dynamiquement la requete
            String sql = "INSERT INTO `user` (`nom`, `prenom`, `login`, `password`, `role`, `etat`) VALUES (?,?,?,?,?, '1');";
            this.getConnection();
            this.initPreparedStatement(sql);
            // Generer Dynamiquement
            this.ps.setString(1, data.getNom());
            this.ps.setString(2, data.getPrenom());
            this.ps.setString(3, data.getLogin());
            this.ps.setString(4, data.getPassword());
            this.ps.setString(5, data.getRole().name());
            this.executeUpdate();
            ResultSet rs = this.ps.getGeneratedKeys();
            if (rs.next()) {
                data.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                this.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public List<User> selectAll() {
        List<User> clients = new ArrayList<User>();
        // 1-OuvreConnexion
        try {

            String sql = "select * from user";
            this.getConnection();
            this.initPreparedStatement(sql);
            // ORM
            ResultSet rs = this.ps.executeQuery();
            while (rs.next()) {
                clients.add(this.convertToObject(rs));
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("Erreur de chargement : " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
        return clients;
    }

    @Override
    public User convertToObject(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setNom(rs.getString("nom"));
        user.setPrenom(rs.getString("prenom"));
        user.setLogin(rs.getString("login"));
        user.setRole(RoleEnum.getValue(rs.getString("role")));
        user.setEtat(rs.getBoolean("etat"));
        return user;

    }

    @Override
    public User selectByID(int id) {
        User result = null;
        // 1-OuvreConnexion
        try {
            String sql = "select * from user where id= ?";
            this.getConnection();
            this.initPreparedStatement(sql);
            this.ps.setInt(1, id);
            // Relationnel To Object ==> Base Donnee==> Java
            ResultSet rs = this.executeQuery();
            if (rs.next()) {
                result = this.convertToObject(rs);
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("Erreur de chargement : " + e.getMessage());
        } finally {
            try {
                this.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
