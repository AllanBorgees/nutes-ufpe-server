package com.nutes.ufpe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutes.ufpe.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

}
