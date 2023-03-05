package com.vssystem.Controller;

import com.vssystem.Dtos.ProdutoDTO;
import com.vssystem.Entity.Produto;
import com.vssystem.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public class ProdutoController {

    // ResponseEntity ele representa toda a resposa http
    // Metodo de busca de produto por id.
    @Autowired
    private ProdutoService produtoService;

    @GetMapping(value = "/produtos/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Integer id) {
        Produto obj = produtoService.findById(id);
        return ResponseEntity.ok().body(new ProdutoDTO(obj));
    }

    @GetMapping(value ="/produtos")
    public ResponseEntity<List<ProdutoDTO>> findAll() {
        List<Produto> list = produtoService.findAll();
        List<ProdutoDTO> listDTO = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> create(@RequestBody ProdutoDTO obj) {
        Produto prod = produtoService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(prod.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }
}
