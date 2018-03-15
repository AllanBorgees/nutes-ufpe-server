package com.nutes.ufpe.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.nutes.ufpe.domain.Pessoa;
import com.nutes.ufpe.services.PessoaServices;

@Controller
@RequestMapping("/pessoa")
public class PessoaResources {

	@Autowired
	private PessoaServices p;

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ResponseEntity<?> salvarPessoa(@RequestBody Pessoa pessoa) {
		
		Pessoa pe = p.salvar(pessoa);
		
		return pe!=null?ResponseEntity.ok(pe):ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Pessoa>> listarPessoas() {
		List<Pessoa> pessoas = p.listar();
		return new ResponseEntity<List<Pessoa>>(pessoas, HttpStatus.OK);
	}

	@RequestMapping(value = "/remover/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerPessoa(@PathVariable("id") Long id) {
		p.remover(id);
	}
	@RequestMapping(value = "/atualizar", method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity<Pessoa> atualizarPessoa(@RequestBody Pessoa pessoa) {
		Pessoa pessoaAtualizada = p.salvar(pessoa);
		return new ResponseEntity<Pessoa>(pessoaAtualizada, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Pessoa> buscarPessoa(@PathVariable("id") Long id) {
		Pessoa pessoa = p.buscar(id);
		return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
	}

	
	
}
