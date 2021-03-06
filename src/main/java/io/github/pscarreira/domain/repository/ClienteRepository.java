package io.github.pscarreira.domain.repository;

import io.github.pscarreira.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

  List<Cliente> findByNomeLike(String nome);

  List<Cliente> findByNomeOrIdOrderById(String nome, Integer id);

  @Query(value = "select c from Cliente c where c.nome like %:nome%")
  List<Cliente> findClienteByNome(@Param("nome") String nome);
}
