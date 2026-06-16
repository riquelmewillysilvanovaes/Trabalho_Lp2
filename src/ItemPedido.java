public class ItemPedido {

    private Item item;
    private int quantidade;

    public ItemPedido(Item item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }

    // ---- Getters e Setters ----
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Retorna o subtotal deste item do pedido (preço × quantidade).
     */
    public double getSubtotal() {
        return item.getPreco() * quantidade;
    }
}
