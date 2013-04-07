/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public BD() {
    }

    public void conecta_BD() throws ClassNotFoundException, SQLException {
        
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://maxses.com.br:3306/natura_controle_calibracao";

        Class.forName(driver);
        conexao = DriverManager.getConnection(url, login, senha);
    }

    public void executa(String sql) {
        Statement st = null;
        try {
           st = (Statement) conexao.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        try {
            //st.executeUpdate(sql);
            if (st.execute(sql)==false){
                System.out.println("Erro de execução de comando");
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void close() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void set_login(String usuario, String senha) {
        this.login = usuario;
        this.senha = senha;
    }
}
