package br.com.luizgcl.usecase;

import br.com.luizgcl.core.domain.TaxNumber;

public interface TaxNumberAvailableUseCase {

    Boolean execute(String taxNumber);

}
