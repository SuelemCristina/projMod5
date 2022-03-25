package br.com.agencia.boaViagem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agencia.boaViagem.model.ContatoModel;
import br.com.agencia.boaViagem.repository.ContatoRepository;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

   public List<ContatoModel> listAll(){
       return contatoRepository.findAll();
   }

   public void save(ContatoModel contato){
       contatoRepository.save(contato);
   }

   public ContatoModel get(Integer id){
       return contatoRepository.findById(id).get();
   }
   
   public void update(Integer id, ContatoModel newContato) {
       ContatoModel oldContato = contatoRepository.getById(id);
       oldContato.setNome(newContato.getNome());
       oldContato.setMensagem(newContato.getMensagem());
       contatoRepository.save(oldContato);
   }


   public void delete(Integer id){
       contatoRepository.deleteById(id);
   }
}
