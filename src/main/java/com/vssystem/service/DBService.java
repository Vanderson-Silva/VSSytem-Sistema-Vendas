package com.vssystem.service;

import com.vssystem.Enum.Perfil;
import com.vssystem.model.Cliente;
import com.vssystem.model.Produto;
import com.vssystem.model.Venda;
import com.vssystem.repository.ClienteRepository;
import com.vssystem.repository.ProdutoRepository;
import com.vssystem.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {


    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VendaRepository vendaRepository;

    public void instanciaDB() {

        Produto prod1 = new Produto(null, "vanderson", "123.349.960-25", "wandersonwandao@hotmail.com", "seila");
        prod1.addPerfis(Perfil.ADMIN);

        Cliente cli1 = new Cliente(null, "Cirlene", "725.601.520-88", "cirlene@hotmail.com", "seila");
        cli1.addPerfis(Perfil.CLIENTE);

        Venda v1 = new Venda(null, "teste aplicacao", "sitema", prod1, cli1);

        produtoRepository.saveAll(Arrays.asList(prod1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        vendaRepository.saveAll(Arrays.asList(v1));
    }
}
