package com.vssystem.Service;


import com.vssystem.Dtos.ProdutoDTO;
import com.vssystem.Exception.ObjectnotFoundException;
import com.vssystem.Entity.Produto;
import com.vssystem.Repository.ProdutoRepository;
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

    public Produto create(ProdutoDTO obj) {
        obj.setId(null);
        Produto newObj = new Produto(obj);
        return produtoRepository.save(newObj);

    }
}
