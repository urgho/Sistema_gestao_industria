package menu;

import dao.FuncionarioDAO;
import dao.SetorDAO;
import model.Funcionario;
import model.Produto;
import model.Setor;

import java.util.ArrayList;
import java.util.Scanner;

public class FuncionarioMenu {
    private static FuncionarioDAO dao = new FuncionarioDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n--- MENU FUNCIONARIOS ---");
            System.out.println("[1] Listar funcionários");
            System.out.println("[2] Buscar funcionário por ID");
            System.out.println("[3] Cadastrar funcionário");
            System.out.println("[4] Atualizar funcionário");
            System.out.println("[5] Remover funcionária");
            System.out.println("[0] Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    listarFuncionarios();
                    break;
                case 2:
                    buscarPorId();
                    break;
                case 3:
                    cadastrarFuncionario();
                    break;
                case 4:
                    atualizarFuncionario();
                    break;
                case 5:
                    removerFuncionario();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void listarFuncionarios() {
        ArrayList<Funcionario> funcionarios = dao.listar();
        if (funcionarios != null && !funcionarios.isEmpty()) {
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
            }
        } else {
            System.out.println("Erro ao listar todos os Funcionários");
        }
    }

    public static void buscarPorId() {
        System.out.print("Insira o ID do Funcionario que deseja buscar: ");
        int id = scanner.nextInt();

        Funcionario funcionario = dao.buscarPorId(id);

        if (funcionario != null) {
            System.out.println(funcionario);
        } else {

        }
    }

    public static void cadastrarFuncionario() {
        SetorDAO setorDAO = new SetorDAO();

        System.out.print("Nome do Funcionário: ");
        String nome = scanner.nextLine();

        System.out.print("ID Setor: ");
        Integer idSetor = scanner.nextInt();
        Setor setor = setorDAO.buscarPorId(idSetor);

        System.out.print("Cargo: ");
        scanner.next();
        String cargo = scanner.nextLine();

        Funcionario funcionario = new Funcionario(null, nome, setor, cargo);
        if (dao.cadastrar(funcionario)) {
            System.out.println("Funcionário cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar funcionário.");
        }
    }

    public static void atualizarFuncionario() {
        SetorDAO setorDAO = new SetorDAO();

        System.out.print("Digite o ID do Funcionário que deseja atualizar: ");
        int id = scanner.nextInt();
        Funcionario funcionario = dao.buscarPorId(id);
        if (funcionario == null) {
            System.out.println("Funcionário não encontrado.");
        }

        System.out.print("Nome do Funcionário: ");
        String nomeFuncionario = scanner.next();
        System.out.print("ID do Setor: ");
        Integer idSetor = scanner.nextInt();
        Setor setor = setorDAO.buscarPorId(idSetor);
        System.out.print("Cargo: ");
        String cargo = scanner.next();

        funcionario.setNome(nomeFuncionario);
        funcionario.setSetor(setor);
        funcionario.setCargo(cargo);

        if (dao.atualizar(funcionario)) {
            System.out.println("Funcionário atualizado com sucesso.");
        } else {
            System.out.println("Erro ao tentar atualizar Funcionário.");
        }
    }

    public static void removerFuncionario() {
        System.out.print("Insira o ID do Funcionário que deseja remover: ");
        int id = scanner.nextInt();

        if (dao.remover(id)) {
            System.out.println("Funcionário removido com Sucesso.");
        } else {
            System.out.println("Erro ao remover o Funcionário.");
        }
    }
}
