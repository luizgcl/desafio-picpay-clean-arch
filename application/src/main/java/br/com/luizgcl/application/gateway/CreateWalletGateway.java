package br.com.luizgcl.application.gateway;

import br.com.luizgcl.core.domain.Wallet;

public interface CreateWalletGateway {

    void execute(Wallet wallet);
}
