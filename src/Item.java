public class Item {

    private String nome;
    private double preco;
    private String[] descricao;   // usado para comidas (ingredientes)
    private String fornecedor;    // usado para bebidas

    // Construtor para COMIDA (nome, preço, descrição dos ingredientes)
    public Item(String nome, double preco, String[] descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.fornecedor = null;
    }

    // Construtor para BEBIDA (nome, preço, fornecedor)
    public Item(String nome, double preco, String fornecedor) {
        this.nome = nome;
        this.preco = preco;
        this.fornecedor = fornecedor;
        this.descricao = null;
    }

    // ---- Getters e Setters ----

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String[] getDescricao() {
        return descricao;
    }

    public void setDescricao(String[] descricao) {
        this.descricao = descricao;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public boolean isComida() {
        return descricao != null;
    }

    public boolean isBebida() {
        return fornecedor != null;
    }
}
