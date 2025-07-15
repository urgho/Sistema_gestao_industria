package model;

public class Funcionario {
    private Integer id;
    private String nome;
    private Setor setor;
    private String cargo;

    public Funcionario(Integer id, String nome, Setor setor, String cargo) {
        this.id = id;
        this.nome = nome;
        this.setor = setor;
        this.cargo = cargo;
    }

    public Funcionario() {
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id + "," +
                "\"nomeFuncionario\":\"" + nome + "\"," +
                "\"setor\":\"" + setor + "\"" +
                "\"cargo\":\"" + cargo + "\"" +
                "}";
    }
}
