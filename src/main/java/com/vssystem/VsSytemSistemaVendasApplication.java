package com.vssystem;

import com.vssystem.Enum.Perfil;
import com.vssystem.model.Cliente;
import com.vssystem.model.Produto;
import com.vssystem.repository.ClienteRepository;
import com.vssystem.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class VsSytemSistemaVendasApplication implements CommandLineRunner {


    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public static void main(String[] args) {
        SpringApplication.run(VsSytemSistemaVendasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Produto prod1 = new Produto(null, "vanderson", "123.349.960-25", "wandersonwandao@hotmail.com", "seila");
        prod1.addPerfis(Perfil.ADMIN);

        Cliente cli1 = new Cliente(null, "Cirlene", "725.601.520-88", "cirlene@hotmail.com", "seila");
        cli1.addPerfis(Perfil.CLIENTE);

        produtoRepository.saveAll(Arrays.asList(prod1));
        clienteRepository.saveAll(Arrays.asList(cli1));

    }
}
