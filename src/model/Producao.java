package model;

public class Producao {
    private Integer id;
    private Produto produto;
    private Funcionario funcionario;
    private String dataProducao;
    private Integer quantidade;

    public Producao(Integer id, Produto produto, Funcionario funcionario, String dataProducao, Integer quantidade) {
        this.id = id;
        this.produto = produto;
        this.funcionario = funcionario;
        this.dataProducao = dataProducao;
        this.quantidade = quantidade;
    }

    public Producao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getDataProducao() {
        return dataProducao;
    }

    public void setDataProducao(String dataProducao) {
        this.dataProducao = dataProducao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "{" +
                "\"idProducao\":" + id + "," +
                "\"produto\":" + produto + "," +
                "\"model.Funcionario\":" + funcionario + "," +
                "\"dataProducao\":\"" + dataProducao + "\"," +
                "\"quantidade\":" + quantidade +
                "}";
    }
}
