import java.util.ArrayList;

public class Conta {

    private ArrayList<Pedido> pedidos;
    private double saldoDevedor;
    private boolean isAberta;
    private Perfil cliente;

    public Conta(Perfil cliente) {
        this.cliente = cliente;
        this.pedidos = new ArrayList<>();
        this.saldoDevedor = 0;
        this.isAberta = true;
    }

    // ---- Getters e Setters ----

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public double getSaldoDevedor() {
        return saldoDevedor;
    }

    public void setSaldoDevedor(double saldoDevedor) {
        this.saldoDevedor = saldoDevedor;
    }

    public boolean isAberta() {
        return isAberta;
    }

    public void setAberta(boolean aberta) {
        isAberta = aberta;
    }

    public Perfil getCliente() {
        return cliente;
    }

    /**
     * Adiciona um pedido à conta e atualiza o saldo devedor.
     */
    public void adicionarPedido(Pedido p) {
        this.pedidos.add(p);
        this.saldoDevedor += p.calcularTotal();
    }

    /**
     * Fecha a conta, calculando o saldo devedor total.
     * Retorna o valor total a ser pago.
     */
    public double fecharConta() {
        this.isAberta = false;
        return this.saldoDevedor;
    }

    /**
     * Realiza o pagamento da conta.
     * O bônus acumulado do cliente pode ser usado para abater parte do valor.
     * Após o pagamento, o cliente recebe 10% do valor pago em bônus.
     */
    public void pagar(Pagamento p) {
        double bonusDisponivel = cliente.getBonus();
        double bonusUsado = 0;

        // Usa o bônus disponível para abater o saldo devedor
        if (bonusDisponivel > 0) {
            if (bonusDisponivel >= saldoDevedor) {
                bonusUsado = saldoDevedor;
            } else {
                bonusUsado = bonusDisponivel;
            }
        }

        double valorFinal = saldoDevedor - bonusUsado;

        p.setBonusUsado(bonusUsado);
        p.setValorPagar(valorFinal);

        // Desconta o bônus usado do perfil do cliente
        cliente.setBonus(bonusDisponivel - bonusUsado);

        // Gera novo bônus (10% do valor efetivamente pago)
        double bonusGerado = p.calcularBonusGerado();
        cliente.setBonus(cliente.getBonus() + bonusGerado);

        this.saldoDevedor = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Conta do cliente: ").append(cliente.getNome());
        sb.append(" | Aberta: ").append(isAberta);
        sb.append(" | Saldo Devedor: R$ ").append(String.format("%.2f", saldoDevedor)).append("\n");
        for (Pedido p : pedidos) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }
}
