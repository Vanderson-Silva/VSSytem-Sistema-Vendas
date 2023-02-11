package com.vssystem.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {

    private List<Venda> vendas = new ArrayList<>(); // evitar excessao de ponteiro nulo.

    public Cliente() {
        super();
    }

    public Cliente(Integer id, String nome, String cpf, String email, String senha, List<Venda> vendas) {
        super(id, nome, cpf, email, senha);

    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
}
