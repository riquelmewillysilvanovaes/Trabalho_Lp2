package model;

public class Bebida extends Item {
    protected String fornecedor;

    public Bebida(String nome, double preco, String fornecedor) {
        super(nome, preco);
        this.fornecedor = fornecedor;
    }

    // ---- Getters e Setters ----
    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
}
