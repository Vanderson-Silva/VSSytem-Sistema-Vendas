package com.vssystem.service;

import com.vssystem.Enum.Perfil;
import com.vssystem.model.Cliente;
import com.vssystem.model.Produto;
import com.vssystem.model.Venda;
import com.vssystem.repository.PessoaRepository;
import com.vssystem.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public void instanciaDB() {

        Produto tec1 = new Produto(null, "Valdir Cezar", "550.482.150-95", "valdir@mail.com", "123");
        tec1.addPerfis(Perfil.ADMIN);
        Produto tec2 = new Produto(null, "Richard Stallman", "903.347.070-56", "stallman@mail.com", "123");
        Produto tec3 = new Produto(null, "Claude Elwood Shannon", "271.068.470-54", "shannon@mail.com", "123");
        Produto tec4 = new Produto(null, "Tim Berners-Lee", "162.720.120-39", "lee@mail.com", "123");
        Produto tec5 = new Produto(null, "Linus Torvalds", "778.556.170-27", "linus@mail.com", "123");

        Cliente cli1 = new Cliente(null, "Albert Einstein", "111.661.890-74", "einstein@mail.com", "123");
        Cliente cli2 = new Cliente(null, "Marie Curie", "322.429.140-06", "curie@mail.com", "123");
        Cliente cli3 = new Cliente(null, "Charles Darwin", "792.043.830-62", "darwin@mail.com", "123");
        Cliente cli4 = new Cliente(null, "Stephen Hawking", "177.409.680-30", "hawking@mail.com", "123");
        Cliente cli5 = new Cliente(null, "Max Planck", "081.399.300-83", "planck@mail.com", "123");

        Venda v1 = new Venda(null, "Produto Generico", "Brasileirinhas", tec1, cli1);
        Venda v2 = new Venda(null, "Produto Generico", "Brasileirinhas", tec1, cli2);
        Venda v3 = new Venda(null, "Produto Generico", "Brasileirinhas", tec3, cli1);
        Venda v4 = new Venda(null, "Produto Generico", "Brasileirinhas", tec4, cli2);
        Venda v5 = new Venda(null, "Produto Generico", "Brasileirinhas", tec4, cli4);
        Venda v6 = new Venda(null, "Produto Generico", "Brasileirinhas", tec5, cli5);

        pessoaRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, cli1, cli2, cli3, cli4, cli5));
        vendaRepository.saveAll(Arrays.asList(v1, v2, v3, v4, v5, v6));

    }
}
