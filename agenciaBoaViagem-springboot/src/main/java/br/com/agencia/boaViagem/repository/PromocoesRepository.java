package br.com.agencia.boaViagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agencia.boaViagem.model.PromocoesModel;

@Repository
public interface PromocoesRepository extends JpaRepository<PromocoesModel,Integer> {


}
