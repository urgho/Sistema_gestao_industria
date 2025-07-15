package dao;

import model.Funcionario;
import model.Setor;
import config.ConnectionMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioDAO {
    private Connection conn = ConnectionMySQL.getConnection();
    private SetorDAO setorDAO = new SetorDAO();

    public ArrayList<Funcionario> listar() {
        try {
            ArrayList<Funcionario> funcionarios = new ArrayList<>();

            String sql = "SELECT * FROM funcionarios;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id_funcionario");
                String nome = rs.getString("nome");
                Integer idSetor = rs.getInt("id_setor");
                String cargo = rs.getString("cargo");

                Setor setor = setorDAO.buscarPorId(idSetor);

                funcionarios.add(new Funcionario(id, nome, setor, cargo));
            }
            return funcionarios;
        } catch (SQLException e) {
            System.out.println("Erro ao listar os Funcionários: " + e.getMessage());
        }
        return null;
    }

    public Funcionario buscarPorId(Integer id) {
        try {
            String sql = "SELECT * FROM funcionarios WHERE id_funcionario = ? ;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                String nome = rs.getString("nome");
                Integer idSetor = rs.getInt("id_setor");
                String cargo = rs.getString("cargo");

                Setor setor = setorDAO.buscarPorId(idSetor);

                Funcionario funcionario = new Funcionario(id, nome, setor, cargo );
                return funcionario;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar pelo ID. " + e.getMessage());
        }
        return null;
    }

    public Boolean cadastrar(Funcionario funcionario) {
        try {
            String sql = "INSERT INTO funcionarios (nome, id_setor, cargo) VALUES (?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, funcionario.getNome());
            ps.setInt(2, funcionario.getSetor().getId());
            ps.setString(3, funcionario.getCargo());

            int qtdeLinhas = ps.executeUpdate();
            if (qtdeLinhas > 0) {
                return true;
            }
            return false;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar model.Funcionario: " + e.getMessage());
        }
        return false;
    }

    public Boolean atualizar(Funcionario funcionario) {
        try {
            String sql = "UPDATE funcionarios SET nome = ?, id_setor = ?, cargo = ? WHERE id_funcionario = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, funcionario.getNome());
            ps.setInt(2, funcionario.getSetor().getId());
            ps.setString(3, funcionario.getCargo());
            ps.setInt(4, funcionario.getId());

            int qtdeAtualizacao = ps.executeUpdate();

            if (qtdeAtualizacao > 0) {
                return true;
            }
            return false;


        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Funcionário: " + e.getMessage());
        }
        return null;
    }

    public Boolean remover(Integer id) {
        try {
            String sql = "DELETE FROM funcionarios WHERE id_funcionario = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            Funcionario funcionarioRetornado = buscarPorId(id);
            if (funcionarioRetornado != null) {
                ps.executeUpdate();
                return true;
            }
            return false;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar model.Funcionario: " + e.getMessage());
        }
        return false;
    }
}


