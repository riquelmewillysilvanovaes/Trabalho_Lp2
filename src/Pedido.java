import java.util.ArrayList;

public class Pedido {

    private static int contadorId = 1;

    private ArrayList<ItemPedido> itens;
    private boolean isAberto;
    private boolean isEntregue;
    private int id;

    public Pedido(ArrayList<ItemPedido> itens) {
        this.id = contadorId++;
        this.itens = itens;
        this.isAberto = true;
        this.isEntregue = false;
    }

    // ---- Getters e Setters ----

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemPedido> itens) {
        this.itens = itens;
    }

    public boolean isAberto() {
        return isAberto;
    }

    public void setAberto(boolean aberto) {
        isAberto = aberto;
    }

    public boolean isEntregue() {
        return isEntregue;
    }

    public void setEntregue(boolean entregue) {
        isEntregue = entregue;
    }

    public int getId() {
        return id;
    }

    /**
     * Calcula o valor total do pedido somando os subtotais de cada ItemPedido.
     */
    public double calcularTotal() {
        double total = 0;
        for (ItemPedido ip : itens) {
            total += ip.getSubtotal();
        }
        return total;
    }
}
