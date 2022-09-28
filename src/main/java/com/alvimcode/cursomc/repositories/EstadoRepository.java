package com.alvimcode.cursomc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alvimcode.cursomc.domain.Categoria;
import com.alvimcode.cursomc.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Categoria, Integer>{

	void saveAll(List<Estado> asList);

}
