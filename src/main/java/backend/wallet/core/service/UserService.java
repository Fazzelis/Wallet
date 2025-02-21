package backend.wallet.core.service;

import backend.wallet.api.dto.user.UserSignInDto;
import backend.wallet.core.model.User;

import java.util.HashMap;
import java.util.UUID;

public interface UserService {
    HashMap<String, UUID> create(User user);
    User getById(UUID id);
    void update(UUID id, User user);
    User signIn(UserSignInDto userSignInDto);
}
