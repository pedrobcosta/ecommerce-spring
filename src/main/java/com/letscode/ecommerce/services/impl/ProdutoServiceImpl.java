package com.letscode.ecommerce.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letscode.ecommerce.dao.ProdutoDao;
import com.letscode.ecommerce.dto.ProdutoDto;
import com.letscode.ecommerce.models.Produto;
import com.letscode.ecommerce.services.ProdutoService;

@Service
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
    public boolean atualizarProduto(long id, ProdutoDto produtoDto) {
        try {
            Produto produto = produtoDao.findById(id).get();
            produto.setNome(produtoDto.getNome());
            produto.setPreco(produtoDto.getPreco());
            produto.setDescricao(produtoDto.getDescricao());
            produtoDao.save(produto);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean removerProduto(long id) {
        try {
            produtoDao.deleteById(id);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
    
}
