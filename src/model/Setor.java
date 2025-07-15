package model;

public class Setor {
    private Integer id;
    private String nome;
    private String responsavel;

    public Setor(Integer id, String nome, String responsavel) {
        this.id = id;
        this.nome = nome;
        this.responsavel = responsavel;
    }

    public Setor() {
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

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "{" +
                "\"idSetor\":" + id + "," +
                "\"nome\":\"" + nome + "\"," +
                "\"responsavel\":\"" + responsavel + "\"" +
                "}";
    }
}
