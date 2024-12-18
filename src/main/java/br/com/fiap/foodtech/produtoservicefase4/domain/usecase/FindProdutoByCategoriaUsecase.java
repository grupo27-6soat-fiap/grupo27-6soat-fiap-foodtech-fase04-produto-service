package br.com.fiap.foodtech.produtoservicefase4.domain.usecase;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import br.com.fiap.foodtech.produtoservicefase4.domain.entities.Produto;
import br.com.fiap.foodtech.produtoservicefase4.domain.enums.CategoriaEnum;
import br.com.fiap.foodtech.produtoservicefase4.domain.provider.ProdutoRepositoryPort;

import java.util.List;
import java.util.Objects;


@Service
@Transactional
@RequiredArgsConstructor
public class FindProdutoByCategoriaUsecase {

    private final ProdutoRepositoryPort produtoPort;
    
    public List<Produto> findByCategoria(CategoriaEnum categoria) {
        if(Objects.nonNull(categoria))
            return produtoPort.findByCategoria(categoria);
        return produtoPort.findAll();
    }

}
