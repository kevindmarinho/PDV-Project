/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;


import Model.Fornecedores;
import java.sql.Connection;
import jdbc.ConnectionFactory;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author kevin
 */
public class FornecedorDAO {
    
    //conexao com o banco
    private Connection con;
    
    public FornecedorDAO(){
        this.con =  new ConnectionFactory().getConnection();
    }
    
    public void cadastrarFornecedor(Fornecedores obj){
        try {
            //sql comand
            String sql = "INSERT INTO tb_fornecedores (razao, cnpj, email, telefone, cep, endereco, numero, bairro, cidade, estado)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?)";
            
            //conectar com o banco
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getRazao());
            stmt.setString(2,obj.getCnpj());
            stmt.setString(3,obj.getEmail());
            stmt.setString(4,obj.getTelefone());
            stmt.setString(5,obj.getCep());
            stmt.setString(6,obj.getEndereco());
            stmt.setInt(7,obj.getNumero());
            stmt.setString(8,obj.getBairro());
            stmt.setString(9,obj.getCidade());
            stmt.setString(10,obj.getUf());
            
            //executar comando 
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Empresa cadastrada!");
        } catch (SQLException erro) {
           JOptionPane.showMessageDialog(null, "iiih deu esse erro aqui :!" + erro); 
        }

    }
    
    public List<Fornecedores> listarFornecedores(){
        try {
            //criar lista
            List<Fornecedores> lista = new ArrayList<>();
            //conexao com o sql
            String sql = "SELECT * FROM tb_fornecedores";
            //conexao com o banco 
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Fornecedores obj = new Fornecedores();
                
                obj.setId(rs.getInt("id"));
                obj.setRazao(rs.getString("razao"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                
                lista.add(obj);           
            }
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "DEU ESSE B.O AQUI  :" + erro);
            
            return null;
        }
    }
    
    public void alterarFornecedor(Fornecedores obj){
        try {
            //sql command
            String sql = "UPDATE tb_fornecedores SET razao = ?, cnpj = ?, email = ?, telefone = ?, cep = ?, "
                    + "endereco = ?, numero = ?, bairro = ?, cidade = ?, estado = ? WHERE id = ?";
            
            //conectar com o banco
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getRazao());
            stmt.setString(2,obj.getCnpj());
            stmt.setString(3,obj.getEmail());
            stmt.setString(4,obj.getTelefone());
            stmt.setString(5,obj.getCep());
            stmt.setString(6,obj.getEndereco());
            stmt.setInt(7,obj.getNumero());
            stmt.setString(8,obj.getBairro());
            stmt.setString(9,obj.getCidade());
            stmt.setString(10,obj.getUf());
            
            stmt.setInt(11,obj.getId());
            
            //executar sql command
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Empresa alterada!");           
        } catch (SQLException erro) {           
          JOptionPane.showMessageDialog(null, "DEU ESSE B.O aqui :" + erro);           

        }
    }
    
    public List<Fornecedores> buscaFornecedorPorRazao(String razao){
        try {
            //criar lista
            List<Fornecedores> lista = new ArrayList<>();
            
            //criar sql 
            String sql = "SELECT * FROM tb_fornecedores WHERE razao LIKE ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, razao);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Fornecedores obj = new Fornecedores();
                
                obj.setId(rs.getInt("id"));
                obj.setRazao(rs.getString("razao"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                
                lista.add(obj);
            }
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "DEU ESSE B.O AQUI : "+ erro);
            
            return null;
        }
    }
    
    public void excluirFornecedor(Fornecedores obj){
        try {
            //sql command
            String sql = "DELETE FROM tb_fornecedores WHERE id = ?";
            
            // conectar com o banco 
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,obj.getId());
            
            //executar comando
            stmt.execute();
            stmt.close();
            
            
            JOptionPane.showMessageDialog(null, "Fornecedor Excluído!");
        } catch (SQLException erro) {
            JOptionPane.showConfirmDialog(null, "DEU ESSE B.O AQUI :" + erro);
        }
    }
  
}
