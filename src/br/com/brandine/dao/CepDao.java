package br.com.brandine.dao;

import br.com.brandine.entity.Cep;
import br.com.brandine.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CepDao {

    public void salvar (Cep cep) {

        String sql = "INSERT INTO cep (cep, logradouro, complemento, bairro , localidade, uf, ibge, gia, ddd,  siafi) values (?,?,?,?,?,?,?,?,?,?)";
        Connection conn =  null;
        PreparedStatement pstm = null;

        try {
            conn =  ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, cep.getCep());
            pstm.setString(2, cep.getLogradouro());
            pstm.setString(3, cep.getComplemento());
            pstm.setString(4, cep.getBairro());
            pstm.setString(5, cep.getLocalidade());
            pstm.setString(6, cep.getUf());
            pstm.setString(7, cep.getIbge());
            pstm.setString(8, cep.getGia());
            pstm.setString(9, cep.getDdd());
            pstm.setString(10, cep.getSiafi());
            pstm.execute();
            System.out.println("O Cep " +  cep.getCep() +" foi salvo com sucesso no banco de dados Mysql!");

        } catch ( Exception e ) {
            e.printStackTrace();
        } finally  {
            try {
                if (pstm != null ) {
                    pstm.close();
                }
                if (pstm != null ) {
                    conn.close(); }
            } catch (Exception e ) {
                e.printStackTrace();
            }
        }
    }

    public List<Cep> getCep(){

        String sql = "Select * from cep";
        List<Cep> cadastro = new ArrayList<Cep>();

        Connection conn =  null;
        PreparedStatement pstm = null;

        ResultSet rset= null;

        try {
            conn =  ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery(sql);

            while (rset.next()) {
                Cep cadastroCep= new Cep();
                cadastroCep.setId(rset.getInt("id"));
                cadastroCep.setCep(rset.getString("cep"));
                cadastroCep.setLogradouro(rset.getString("logradouro"));
                cadastroCep.setComplemento((rset.getString("complemento")));
                cadastroCep.setBairro((rset.getString("bairro")));
                cadastroCep.setLocalidade((rset.getString("localidade")));
                cadastroCep.setUf(rset.getString(("uf")));
                cadastroCep.setIbge(rset.getString("ibge"));
                cadastroCep.setGia(rset.getString("gia"));
                cadastroCep.setDdd(rset.getString("ddd"));
                cadastroCep.setSiafi(rset.getString("siafi"));

                cadastro.add(cadastroCep);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset !=null ) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn!=null ) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } return cadastro;

    }


    public void update (Cep cep) {

        String sql = "UPDATE cep SET cep=?, logradouro=?, complemento=?, bairro=?, localidade=?, uf=?, ibge=?, gia=?, ddd=?, siafi=? WHERE id= ? ";
        Connection conn =  null;
        PreparedStatement pstm = null;

        try {
            conn =  ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, cep.getCep());
            pstm.setString(2, cep.getLogradouro());
            pstm.setString(3, cep.getComplemento());
            pstm.setString(4, cep.getBairro());
            pstm.setString(5, cep.getLocalidade());
            pstm.setString(6, cep.getUf());
            pstm.setString(7, cep.getIbge());
            pstm.setString(8, cep.getGia());
            pstm.setString(9, cep.getDdd());
            pstm.setString(10, cep.getSiafi());
            pstm.setInt(11, cep.getId());
            pstm.execute();

            System.out.println("Cadatro do CEP "+ cep.getCep() + " foi atualizao  com sucesso");

        } catch ( Exception e ) {
            e.printStackTrace();
        } finally  {
            try {
                if (pstm != null ) {
                    pstm.close();
                }
                if (pstm != null ) {
                    conn.close(); }
            } catch (Exception e ) {
                e.printStackTrace();
            }
        }
    }


    public void deletar(int id) {

        String sql = "delete from cep where id = ? ";
        Connection conn =  null;
        PreparedStatement pstm = null;

        try {
            conn =  ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setInt(1, id);
            pstm.execute();
            System.out.println("Cadastro do id "+  id + " foi excluído com sucesso");

        } catch ( Exception e ) {
            e.printStackTrace();
        } finally  {
            try {
                if (pstm != null ) {
                    pstm.close();
                }
                if (pstm != null ) {
                    conn.close(); }
            } catch (Exception e ) {
                e.printStackTrace();
            }
        }
    }
    public void deletarLista() {

        String sql = "delete from cep";
        Connection conn =  null;
        PreparedStatement pstm = null;

        try {
            conn =  ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);


            pstm.execute();
            System.out.println("A lista foi excluida com sucesso");

        } catch ( Exception e ) {
            e.printStackTrace();
        } finally  {
            try {
                if (pstm != null ) {
                    pstm.close();
                }
                if (pstm != null ) {
                    conn.close(); }
            } catch (Exception e ) {
                e.printStackTrace();
            }
        }
    }



}

