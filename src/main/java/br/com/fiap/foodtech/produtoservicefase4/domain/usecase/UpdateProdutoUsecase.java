package br.com.fiap.foodtech.produtoservicefase4.domain.usecase;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import br.com.fiap.foodtech.produtoservicefase4.domain.entities.Produto;
import br.com.fiap.foodtech.produtoservicefase4.domain.provider.ProdutoRepositoryPort;

import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class UpdateProdutoUsecase {

	private final ProdutoRepositoryPort produtoPort;
	
	public Produto update(Long id, Produto produto) {
		if (Objects.nonNull(id)) {
			produto.setId(id);
			Produto produto1 = produtoPort.get(id);

			if (Objects.isNull(produto1))
				return null;

			return produtoPort.save(produto);
		}
		return null;
	}

}
