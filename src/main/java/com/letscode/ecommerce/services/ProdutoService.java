package com.letscode.ecommerce.services;

import com.letscode.ecommerce.dto.ProdutoDto;
import com.letscode.ecommerce.models.Produto;

public interface ProdutoService {
    
    Produto listarProduto(long id);

    boolean novoProduto(ProdutoDto produto);

    boolean atualizarProduto(Produto produto);

    boolean removerProduto(long id);

}
