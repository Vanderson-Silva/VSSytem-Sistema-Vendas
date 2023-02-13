package com.vssystem.service;


import com.vssystem.exception.ObjectnotFoundException;
import com.vssystem.model.Produto;
import com.vssystem.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findById(Integer id) {
        Optional<Produto> obj = produtoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto nao encontrado! id:" + id));
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }
}
