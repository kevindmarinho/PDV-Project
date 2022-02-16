/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Funcionarios;
import View.frmMenu;
import View.frmLogin;
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
    
    public List<Funcionarios> listarFuncionario(){
        try {
            //criar a lista
            List<Funcionarios> lista = new ArrayList<>();
            
            //criar conexao sql
            String sql = "select * from tb_funcionarios";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Funcionarios obj = new Funcionarios();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setNumero1(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setUsuario(rs.getString("usuario"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                
                lista.add(obj);  
            }
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"DEU B.O AQUI : " + erro);
            
            return null;
        }
    }
    
    public void alterarFuncionario(Funcionarios obj){
        try {
            //sql command
            String sql = "UPDATE tb_funcionarios SET nome=?, cpf=?,email=?,senha=?,cargo=?,nivel_acesso=?,celular=?,"
                    + "cep=?,endereco=?,numero=?,bairro=?,cidade=?,estado=? WHERE usuario = ?";
            
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
            stmt.setString(11,obj.getBairro());
            stmt.setString(12,obj.getCidade());
            stmt.setString(13,obj.getUf());
            
            stmt.setString(14,obj.getUsuario());
            
            //EXCUTAR SQL
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Alteramo o cara!");
        } catch (SQLException erro) {
            JOptionPane.showConfirmDialog(null, "DEU ESSE B.O :" + erro);
        }
    }
    
    public void excluirFuncionario(Funcionarios obj){
        try {
            //sql command
            String sql = "DELETE FROM tb_funcionarios WHERE usuario = ?";
            
            //conectar com o banco
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getUsuario());
            
            //executar comando
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Apagamos o brother!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "DEU ESSE B.O" + erro);
        }
    
    }
    
    public List<Funcionarios> buscarFuncionarioPorNome(String nome){
        try {
            //criar lista
            List<Funcionarios> lista = new ArrayList<>();
            
            //criar sql
            String sql = "select * from tb_funcionarios WHERE nome LIKE ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Funcionarios obj = new Funcionarios();
                
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setNumero1(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setUsuario(rs.getString("usuario"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
                
                lista.add(obj);
            }
            return lista;
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "DEU ESSE B.O: "+ erro);
            
            return null;
            
        }
    
    }
    
    //Metodo Login
    
    public void Login(String usuario, String senha){
        try {
            //1 passo - SQL 
            String sql = "SELECT * FROM tb_funcionarios WHERE usuario = ? AND senha = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                //usuario logado
                JOptionPane.showMessageDialog(null, "Bem-vindo ao Sistema!");
                frmMenu tela = new frmMenu();
                tela.usuarioLogado = rs.getString("nome");
                tela.setVisible(true);
                
            }else{
                //dados incorretos
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorreta!\nTente novamente ou contate o adm.");
                new frmLogin().setVisible(true);

            }
        } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro encontrado :" + erro);
        }
    }
    
}
