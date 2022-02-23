package io.github.pscarreira;

import io.github.pscarreira.domain.entity.Cliente;
import io.github.pscarreira.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication {
  @Bean
  public CommandLineRunner init(@Autowired ClienteRepository clienteRepository){
    return args -> {
      // Criando 3 clientes
      clienteRepository.save(new Cliente("João das Couves"));
      clienteRepository.save(new Cliente("Maria das Neves"));
      clienteRepository.save(new Cliente("Lucio dos Santos"));

      // Recuperando todos os clientes
      clienteRepository.findAll().forEach(System.out::println);

      // Buscando por nome
      clienteRepository.findByNomeLike("Maria das Neves").forEach(System.out::println);

      // Buscando por nome ou id
      clienteRepository.findByNomeOrIdOrderById(null, 3).forEach(System.out::println);

      // Apagando cliente 2
      clienteRepository.deleteById(2);

      // Verificando existência de cliente 2
      System.out.println(clienteRepository.existsById(2));

      // Atualizando cliente 1
      clienteRepository.save(new Cliente(1, "João das Couves dos Santos"));

      // Recuperando todos os clientes novamente
      clienteRepository.findAll().forEach(System.out::println);

      // Encontrando por nome parecido
      clienteRepository.findClienteByNome("dos Santos").forEach(System.out::println);

    };
  }

  public static void main(String[] args) {
    SpringApplication.run(VendasApplication.class, args);
  }
}
