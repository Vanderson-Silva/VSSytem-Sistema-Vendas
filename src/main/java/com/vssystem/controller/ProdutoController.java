package com.vssystem.controller;

import com.vssystem.dtos.ProdutoDTO;
import com.vssystem.model.Produto;
import com.vssystem.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    // ResponseEntity ele representa toda a resposa http
    // Metodo de busca de produto por id.
    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Integer id) {
        Produto obj = produtoService.findById(id);
        return ResponseEntity.ok().body(new ProdutoDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> findAll() {
        List<Produto> list = produtoService.findAll();
        List<ProdutoDTO> listDTO = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
}
