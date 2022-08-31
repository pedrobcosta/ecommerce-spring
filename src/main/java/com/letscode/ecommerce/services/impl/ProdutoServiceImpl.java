package com.letscode.ecommerce.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.letscode.ecommerce.dao.ProdutoDao;
import com.letscode.ecommerce.dto.ProdutoDto;
import com.letscode.ecommerce.models.Produto;
import com.letscode.ecommerce.services.ProdutoService;

public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    ProdutoDao produtoDao;

    @Override
    public Produto listarProduto(long id) {

        try {
            return produtoDao.findById(id).get();
        } 
        catch(Exception e) {
            return null;
        }
    }

    @Override
    public boolean novoProduto(ProdutoDto produtoDto) {
        try {
            Produto produto = new Produto(produtoDto.getNome(), produtoDto.getPreco(), produtoDto.getDescricao());
            produtoDao.save(produto);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

    @Override
    public boolean atualizarProduto(Produto produto) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removerProduto(long id) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
