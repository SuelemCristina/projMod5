package br.com.agencia.boaViagem.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agencia.boaViagem.model.PromocoesModel;
import br.com.agencia.boaViagem.service.PromocoesService;

@RestController
@RequestMapping("/promocoes")
@CrossOrigin(origins = "http://localhost:3000")
public class PromocoesController {

	@Autowired
	private PromocoesService promocoesService;
	private PromocoesService promocoesModel;

	@GetMapping("/getAll")
	public List<PromocoesModel> list() {
		return promocoesService.listAll();
	}

	@PostMapping("/add")
	public String add(@RequestBody PromocoesModel promocoes) {
		promocoesService.save(promocoes);
		return "New Promocoes Added";
	}

	@GetMapping("/{id}")
	public ResponseEntity<PromocoesModel> get(@PathVariable Integer id) {
		try {
			PromocoesModel promocoes = promocoesService.get(id);
			return new ResponseEntity<PromocoesModel>(promocoes, HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<PromocoesModel>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<PromocoesModel> update(@RequestBody PromocoesModel newPromocoes, @PathVariable Integer id) {
		try {
			promocoesService.update(id, newPromocoes);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<PromocoesModel>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		promocoesService.delete(id);
		return "Promocoes Excluido.";
	}

	@PostMapping(value = "/")
	public ResponseEntity<PromocoesModel> save(@RequestBody PromocoesModel promocoes) {
		promocoesModel.save(promocoes);
		return ResponseEntity.ok().body(promocoes);
	}

}
