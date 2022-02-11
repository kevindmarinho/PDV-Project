/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Dao.FuncionarioDAO;
import java.sql.SQLException;
import java.util.Random;

/**
 *
 * @author kevin
 */
public class Funcionarios extends Clientes {
    
    //atributos
    private String senha;
    private String cargo;
    private String nivel_acesso;
    private String usuario;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNivel_acesso() {
        return nivel_acesso;
    }

    public void setNivel_acesso(String nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String generationUserNumber() throws SQLException{
        String numeroAleatorio = "";
        Random random = new Random();
        int number;
        for (int i = 0; i < 9; i++) {
            number = random.nextInt(9);
            numeroAleatorio+=String.valueOf(number);
         }
        return numeroAleatorio.substring(0, 6);
    }
}
    
    
    
    

