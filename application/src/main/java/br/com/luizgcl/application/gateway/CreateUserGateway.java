package br.com.luizgcl.application.gateway;

import br.com.luizgcl.core.domain.User;

public interface CreateUserGateway {

    User execute(User user);

}
