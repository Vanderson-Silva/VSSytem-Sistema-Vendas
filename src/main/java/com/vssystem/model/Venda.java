package com.vssystem.model;


import ch.qos.logback.core.status.Status;

import java.time.LocalDate;
import java.util.Objects;


public class Venda {
    private Integer id;
    private LocalDate dataVenda = LocalDate.now();
    private Status status;
    private String obervacoes;

    private String titulo;


    private Produto produto;
    private Cliente cliente;

    public Venda() {
        super();
    }

    public Venda(Integer id, Status status, String obervacoes, String titulo, Produto produto, Cliente cliente) {
        this.id = id;
        this.status = status;
        this.obervacoes = obervacoes;
        this.titulo = titulo;
        this.produto = produto;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getObervacoes() {
        return obervacoes;
    }

    public void setObervacoes(String obervacoes) {
        this.obervacoes = obervacoes;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venda venda = (Venda) o;
        return Objects.equals(id, venda.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
