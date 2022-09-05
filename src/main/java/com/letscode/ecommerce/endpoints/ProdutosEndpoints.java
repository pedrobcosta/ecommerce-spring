package com.letscode.ecommerce.endpoints;

import com.letscode.ecommerce.dto.ProdutoDto;
import com.letscode.ecommerce.models.Produto;
import com.letscode.ecommerce.restclient.FinanceiroRestClient;
import com.letscode.ecommerce.services.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ProdutosEndpoints {

    @Autowired
    FinanceiroRestClient financeiroRestClient;

    @Autowired
    ProdutoService produtoService;

    @RequestMapping(path="/produtos/categorias", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getAllCategories() {

        return ResponseEntity.ok(financeiroRestClient.findAll());
    }

    @RequestMapping(path="/produto", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> novoProduto(@RequestBody ProdutoDto produto) {

        boolean sucesso = produtoService.novoProduto(produto);

        if(sucesso) {
            return new ResponseEntity<>("Produto criado com sucesso!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Erro ao criar o produto", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path="/produto/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> listarProduto(@PathVariable long id) {

        Produto produto = produtoService.listarProduto(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @RequestMapping(path="/produto/{id}", method = RequestMethod.PUT, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> atualizarProduto(@PathVariable long id, @RequestBody ProdutoDto produtoDto) {

        boolean sucesso = produtoService.atualizarProduto(id, produtoDto);
        if(sucesso) {
            return new ResponseEntity<>(String.format("Produto de id %d atualizado com sucesso!",id), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Erro ao atualizar produto", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path="/produto/{id}", method = RequestMethod.DELETE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> removerProduto(@PathVariable long id) {

        boolean sucesso = produtoService.removerProduto(id);
        if(sucesso) {
            return new ResponseEntity<>(String.format("Produto de id %d removido com sucesso!",id), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Erro ao remover produto", HttpStatus.BAD_REQUEST);
        }
    }
}