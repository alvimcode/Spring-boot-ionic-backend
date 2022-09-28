package com.alvimcode.cursomc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alvimcode.cursomc.domain.Cidade;
import com.alvimcode.cursomc.domain.Produto;

@Repository
public interface CidadeRepository extends JpaRepository<Produto, Integer> {

	void saveAll(List<Cidade> asList);

}
