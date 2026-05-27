import java.util.ArrayList;

public class Restaurante {

    private ArrayList<Perfil> perfis;
    private ArrayList<Item> cardapio;
    private ArrayList<Conta> contasAtivas;

    public Restaurante() {
        this.perfis = new ArrayList<>();
        this.cardapio = new ArrayList<>();
        this.contasAtivas = new ArrayList<>();
    }

    // ---- Getters ----

    public ArrayList<Perfil> getPerfis() {
        return perfis;
    }

    public ArrayList<Item> getCardapio() {
        return cardapio;
    }

    public ArrayList<Conta> getContasAtivas() {
        return contasAtivas;
    }

    /**
     * Retorna todos os pedidos abertos (visão da cozinha).
     * A cozinha visualiza os pedidos que ainda não foram entregues.
     */
    public ArrayList<Pedido> verPedidos() {
        ArrayList<Pedido> pedidosAbertos = new ArrayList<>();
        for (Conta conta : contasAtivas) {
            for (Pedido pedido : conta.getPedidos()) {
                if (pedido.isAberto() && !pedido.isEntregue()) {
                    pedidosAbertos.add(pedido);
                }
            }
        }
        return pedidosAbertos;
    }

    /**
     * A cozinha marca um pedido como entregue ao cliente pelo ID.
     * Fecha o pedido após a entrega.
     */
    public void entregarPedido(int id) {
        for (Conta conta : contasAtivas) {
            for (Pedido pedido : conta.getPedidos()) {
                if (pedido.getId() == id) {
                    pedido.setEntregue(true);
                    pedido.setAberto(false);
                    return;
                }
            }
        }
        System.out.println("Pedido #" + id + " não encontrado.");
    }

    /**
     * Insere um item no cardápio (gerente).
     */
    public void inserirCard(Item item) {
        this.cardapio.add(item);
    }

    /**
     * Remove um item do cardápio (gerente).
     */
    public void retirarCard(Item item) {
        this.cardapio.remove(item);
    }

    /**
     * Exibe todos os itens do cardápio.
     */
    public ArrayList<Item> exibirCard() {
        return this.cardapio;
    }

    /**
     * Cadastra um novo perfil de cliente no sistema.
     */
    public void adicionarPerfil(String nome, String cpf, String email) {
        Perfil novoPerfil = new Perfil(nome, cpf, email);
        this.perfis.add(novoPerfil);
    }

    /**
     * Busca um perfil de cliente pelo CPF.
     * Retorna null se não encontrado.
     */
    public Perfil buscarPerfil(String cpf) {
        for (Perfil p : perfis) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }
}
