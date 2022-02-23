/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Fornecedores;
import Model.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;

/**
 *
 * @author kevin
 */
public class ProdutoDAO {
    
    private Connection con;
    
    public ProdutoDAO(){
        this.con =  new ConnectionFactory().getConnection();
    }
    
        //Metodo cadastrarProduto
    public void cadastrarProduto(Produtos obj){
        try {
            // sql comand
            String sql = "INSERT INTO tb_produtos (codigo,descricao,preco,qtd_estoque,for_id)"
                    + "VALUES (?,?,?,?,?)";
            
            //conectar com o banco
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getCodigo());
            stmt.setString(2,obj.getDescricao());
            stmt.setDouble(3,obj.getPreco());
            stmt.setInt(4,obj.getQtd_estoque());
            
            
            stmt.setInt(5,obj.getFornecedor().getId());
            
            // excutar e fechar o comando sql
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Produto cadastro com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "DEU B.O" + erro );
        }
    }
    
        //Metodo listarProduto
    public List<Produtos> listarProduto(){
        try {
            
            //criar  a lista
            List<Produtos> lista = new ArrayList<>();
            
            //criar sql
            String sql = "SELECT p.id, p.codigo, p.descricao, p.preco, p.qtd_estoque, f.razao FROM tb_produtos AS p INNER JOIN tb_fornecedores as f on (p.for_id = f.id)";

            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Produtos obj  = new Produtos();
                Fornecedores f= new Fornecedores();
                
                obj.setId(rs.getInt("p.id"));
                obj.setCodigo(rs.getString("p.codigo"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                
                f.setRazao(rs.getString(("f.razao")));
                
                obj.setFornecedor(f);
                lista.add(obj);
                
            }            
            return lista;
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "DEU ESSE B.O: "+ erro);
            
            return null;
        }
    }
    
}
