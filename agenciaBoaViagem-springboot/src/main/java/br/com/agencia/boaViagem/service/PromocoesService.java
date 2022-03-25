package br.com.agencia.boaViagem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agencia.boaViagem.model.PromocoesModel;
import br.com.agencia.boaViagem.repository.PromocoesRepository;

@Service
public class PromocoesService {

    @Autowired
    private PromocoesRepository promocoesRepository;

   public List<PromocoesModel> listAll(){
       return promocoesRepository.findAll();
   }

   public void save(PromocoesModel promocoes){
       promocoesRepository.save(promocoes);
   }

   public PromocoesModel get(Integer id){
       return promocoesRepository.findById(id).get();
   }
   
   public void update(Integer id, PromocoesModel newPromocoes) {
       PromocoesModel oldPromocoes = promocoesRepository.getById(id);
       oldPromocoes.setNome(newPromocoes.getNome());
       oldPromocoes.setEmail(newPromocoes.getEmail());
       oldPromocoes.setTelefone(newPromocoes.getTelefone());


       promocoesRepository.save(oldPromocoes);
   }

   public void delete(Integer id){
       promocoesRepository.deleteById(id);}
}
