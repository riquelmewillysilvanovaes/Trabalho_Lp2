package model;

import java.time.LocalDateTime;

public class Pagamento {

    private String tipo;            // "credito" ou "debito"
    private LocalDateTime data;
    private double valorPagar;
    private double bonusUsado;

    public Pagamento() {
        this.data = LocalDateTime.now();
        this.tipo = null;
        this.valorPagar = 0;
        this.bonusUsado = 0;
    }

    // ---- Getters e Setters ----
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public double getValorPagar() {
        return valorPagar;
    }

    public void setValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
    }

    public double getBonusUsado() {
        return bonusUsado;
    }

    public void setBonusUsado(double bonusUsado) {
        this.bonusUsado = bonusUsado;
    }

    /**
     * Calcula o bônus gerado a partir do valor efetivamente pago (10% do valor).
     * O bônus é calculado sobre o valorPagar (já descontado o bônus usado).
     */
    public double calcularBonusGerado() {
        return valorPagar * 0.10;
    }
}
