package com.vssystem.model;

import com.vssystem.Enum.Perfil;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Produto extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "produto")
    private List<Venda> vendas = new ArrayList<>();

    public Produto() {
        super();
        addPerfis(Perfil.CLIENTE);
    }

    public Produto(Integer id, String nome, String cpf, String email, String senha, List<Venda> vendas) {
        super(id, nome, cpf, email, senha);
        addPerfis(Perfil.CLIENTE);

    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
}
