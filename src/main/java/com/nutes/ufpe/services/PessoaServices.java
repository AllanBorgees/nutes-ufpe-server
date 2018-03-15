package com.nutes.ufpe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nutes.ufpe.domain.Pessoa;
import com.nutes.ufpe.repository.PessoaRepository;

@Service
public class PessoaServices {

	@Autowired
	private PessoaRepository p;
	
	public Pessoa salvar(Pessoa pessoa) {
		return p.save(pessoa);
	}
	
	public List<Pessoa> listar() {
		return p.findAll();
	}
	public Pessoa buscar(Long id) {
		return p.findOne(id);
	}

	public void remover(Long id) {
		p.delete(id);
	}
	
	
	
}
