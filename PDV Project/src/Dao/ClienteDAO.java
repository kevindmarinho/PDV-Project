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
import java.util.ArrayList;
import java.util.List;
import javax.xml.transform.Result;
import java.sql.ResultSet;


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
            
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "DEU B.O" + erro );
        }
    }
    
    //Metodo alterarCliente
    public void alterarCliente(Clientes obj){
        
        try {
            // sql comand
            String sql = "UPDATE tb_clientes SET nome=?,rg=?,cpf=?,email=?,numero1=?,numero2=?,cep=?,"
                    + "endereco=?,numero=?,bairro=?,cidade=?,estado=? WHERE id =?";
            
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
            
            stmt.setInt(13,obj.getId());
            
            // excutar e fechar o comando sql
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Alteramo o malandro!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "DEU B.O" + erro );
        }
    
    }
    //Metodo excluirCliente
    public void excluirCliente(Clientes obj){
        
        try {
            // sql comand
            String sql = "DELETE FROM tb_clientes WHERE id = ?";
            
            //conectar com o banco
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,obj.getId());
                       
            // excutar e fechar o comando sql
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Apagamo o malandro!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "DEU B.O" + erro );
        }
    
    }
    
    //Metodo listarCliente
    public List<Clientes> listarCliente(){
        try {
            
            //criar  a lista
            List<Clientes> lista = new ArrayList<>();
            
            //criar sql
            String sql = "select * from tb_clientes";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Clientes obj  = new Clientes();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setNumero1(rs.getString("numero1"));
                obj.setNumero2(rs.getString("numero2"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("Cidade"));
                obj.setUf(rs.getString("estado"));
                
                lista.add(obj);
                
            }            
            return lista;
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "DEU ESSE B.O: "+ erro);
            
            return null;
        }
    }
    
    
        public List<Clientes> buscarClientePorNome(String nome){
        try {
            
            //criar  a lista
            List<Clientes> lista = new ArrayList<>();
            
            //criar sql
            String sql = "select * from tb_clientes WHERE nome LIKE ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,nome);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Clientes obj  = new Clientes();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setNumero1(rs.getString("numero1"));
                obj.setNumero2(rs.getString("numero2"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("Cidade"));
                obj.setUf(rs.getString("estado"));
                
                lista.add(obj);
                
            }            
            return lista;
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "DEU ESSE B.O: "+ erro);
            
            return null;
        }
    }
}
