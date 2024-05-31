package br.com.luizgcl.application.usecaseimpl;

import br.com.luizgcl.application.gateway.CreateWalletGateway;
import br.com.luizgcl.core.domain.Wallet;
import br.com.luizgcl.usecase.CreateWalletUseCase;

public class CreateWalletUseCaseImpl implements CreateWalletUseCase {

    private final CreateWalletGateway createWalletGateway;

    public CreateWalletUseCaseImpl(CreateWalletGateway createWalletGateway) {
        this.createWalletGateway = createWalletGateway;
    }

    @Override
    public void execute(Wallet wallet) {
        this.createWalletGateway.execute(wallet);
    }
}
