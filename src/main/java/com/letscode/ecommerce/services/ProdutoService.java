package com.letscode.ecommerce.services;

import com.letscode.ecommerce.dto.ProdutoDto;
import com.letscode.ecommerce.models.Produto;

public interface ProdutoService {
    
    Produto listarProduto(long id);

    boolean novoProduto(ProdutoDto produtoDto);

    boolean atualizarProduto(long id, ProdutoDto produtoDto);

    boolean removerProduto(long id);

}
