package br.com.product.showcase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.product.showcase.entity.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
  
}
