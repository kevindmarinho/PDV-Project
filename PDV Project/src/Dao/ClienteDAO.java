/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Clientes;
import java.sql.Connection;
import jdbc.ConnectionFactory;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author kevin
 */
public class ClienteDAO {
    
    private Connection con;
    
    public ClienteDAO(){
        this.con =  new ConnectionFactory().getConnection();
    }
    
    //Metodo cadastrarCliente
    public void cadastrarCliente(Clientes obj){
        try {
            // sql comand
            String sql = "INSERT INTO tb_clientes (nome,rg,cpf,email,numero1,numero2,cep,endereco,numero,bairro,cidade,estado)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            
            //conectar com o banco
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getNome());
            stmt.setString(2,obj.getRg());
            stmt.setString(3,obj.getCpf());
            stmt.setString(4,obj.getEmail());
            stmt.setString(5,obj.getNumero1());
            stmt.setString(6,obj.getNumero2());
            stmt.setString(7,obj.getCep());
            stmt.setString(8,obj.getEndereco());
            stmt.setInt(9,obj.getNumero());
            stmt.setString(10,obj.getBairro());
            stmt.setString(11,obj.getCidade());
            stmt.setString(12,obj.getUf());
            
            // excutar e fechar o comando sql
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cadastramo o malandro!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "DEU B.O" + erro );
        }
    }
    
    //Metodo alterarCliente
    public void alterarCliente(){
    
    }
    //Metodo excluirCliente
    public void excluirCliente(){
    
    }
}
