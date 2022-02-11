/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Funcionarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;

/**
 *
 * @author kevin
 */
public class FuncionarioDAO {
        //CONEXAO COM O DB
    
     private Connection con;
    
    public FuncionarioDAO(){
        this.con =  new ConnectionFactory().getConnection();
    }
    
    public void cadastrarFuncionario(Funcionarios obj){
        try {
            // sql comand
            String sql = "INSERT INTO tb_funcionarios (nome,cpf,email,senha,cargo,nivel_acesso,celular,cep,endereco,numero,usuario,bairro,cidade,estado)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            //conectar com o banco
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getNome());
            stmt.setString(2,obj.getCpf());
            stmt.setString(3,obj.getEmail());
            stmt.setString(4,obj.getSenha());
            stmt.setString(5,obj.getCargo());
            stmt.setString(6,obj.getNivel_acesso());
            stmt.setString(7,obj.getNumero1());
            stmt.setString(8,obj.getCep());
            stmt.setString(9,obj.getEndereco());
            stmt.setInt(10,obj.getNumero());
            stmt.setString(11,obj.getUsuario());
            stmt.setString(12,obj.getBairro());
            stmt.setString(13,obj.getCidade());
            stmt.setString(14,obj.getUf());
            
            // excutar e fechar o comando sql
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cadastramo o malandro!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "DEU B.O" + erro );
        }
    }
    
}
