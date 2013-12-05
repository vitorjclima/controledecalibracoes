package br.com.vitorjclima.controledeintervencoes.db;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitor
 */
public class BD {

     private Connection conexao;
     private String login;
     private String senha;

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public BD() {
    }

    public void conecta_BD() throws ClassNotFoundException, SQLException {
        
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://maxses.com.br:3306/natura_pesl";

        Class.forName(driver);
        conexao = DriverManager.getConnection(url, login, senha);
        
    }

    public boolean close() {
        try {
            conexao.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void set_login(String usuario, String senha) {
        this.login = usuario;
        this.senha = senha;
    }

    public Connection getConexao() {
        return conexao;
    }
}
