package dao;

import model.Setor;
import config.ConnectionMySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

public class SetorDAO {
    private Connection conn = ConnectionMySQL.getConnection();

    public ArrayList<Setor> listar() {
        try {
            ArrayList<Setor> setores = new ArrayList<>(); // Criar uma lista dos Setores

            String sql = "SELECT * FROM setores;"; // Comando dentro do SQL
            PreparedStatement ps = conn.prepareStatement(sql); // Executar o comando dentro do SQL

            ResultSet rs = ps.executeQuery(); // Capturar os dados do SQL

            while (rs.next()) { // Retorna se há um proximo objeto - Caso haja = true
                Integer id = rs.getInt("id_setor");
                String nome = rs.getString("nome_setor");
                String responsavel = rs.getString("responsavel");

                // model.Setor setor = new model.Setor(id, nome, responsavel);
                // setores.add(setor);

                setores.add(new Setor(id, nome, responsavel));
            }
            return setores;
        } catch (SQLException e) {
            System.out.println("Erro ao listar os Setores: " + e.getMessage());
        }
        return null;
    }

    public Setor buscarPorId(Integer id) {
        try {
            String sql = "SELECT * FROM setores WHERE id_setor = ? ;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                // Integer idSetor = rs.getInt("id_setor");
                String nome = rs.getString("nome_setor");
                String responsavel = rs.getString("responsavel");
                Setor setor = new Setor(id, nome, responsavel);
                //model.Setor setor = new model.Setor(idSetor, nome, responsavel);
                return setor;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar pelo ID. " + e.getMessage());
        }
        return null;
    }

    public Boolean cadastrar(Setor setor) {
        try {
            String sql = "INSERT INTO setores (nome_setor, responsavel) VALUES (?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, setor.getNome()); // Ordem dos dados - posição e logo após o valor que será adicionado
            ps.setString(2, setor.getResponsavel());

            int qtdeLinhas = ps.executeUpdate(); // Para adicionar os dados no Banco de dados
            if (qtdeLinhas > 0) { // Para confirmar que os dados foram adicionados
                return true;
            }
            return false;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar setor: " + e.getMessage());
        }
        return false;
    }

    public Boolean atualizar(Setor setor) {
        try {
            String sql = "UPDATE setores SET nome_setor = ?, responsavel = ? WHERE id_setor = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, setor.getNome());
            ps.setString(2, setor.getResponsavel());
            ps.setInt(3, setor.getId());

            int qtdeAtualizacao = ps.executeUpdate();

            if (qtdeAtualizacao > 0) {
                return true;
            }
            return false;


        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        }
        return null;
    }

    public Boolean remover(Integer id) {
        try {
            String sql = "DELETE FROM setores WHERE id_setor = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            Setor setorRetornado = buscarPorId(id);
            if (setorRetornado != null) {
                ps.executeUpdate();
                return true;
            }
            return false;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar model.Setor: " + e.getMessage());
        }
        return false;
    }

}
