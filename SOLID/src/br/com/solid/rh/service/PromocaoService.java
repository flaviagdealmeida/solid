package br.com.solid.rh.service;

import br.com.solid.rh.ValidacaoException;
import br.com.solid.rh.model.Cargo;
import br.com.solid.rh.model.Funcionario;

public class PromocaoService {
	public void promover(Funcionario funcionario, boolean metaBatida) {
		Cargo cargoAtual = funcionario.getCargo();

		if (Cargo.GERENTE == cargoAtual) {
			throw new ValidacaoException("Gerentes n�o podem ser promovidos!");
			
		}
		if (metaBatida) {
			Cargo novoCargo = cargoAtual.getProximoCargo();
			funcionario.promover(novoCargo);
		}else {
			throw new ValidacaoException("Funcionario n�o bateu a meta");
		}
	}

}
