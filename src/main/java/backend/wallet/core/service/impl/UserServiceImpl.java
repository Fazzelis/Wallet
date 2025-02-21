package backend.wallet.core.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import backend.wallet.api.dto.user.UserSignInDto;
import backend.wallet.core.model.User;
import backend.wallet.core.model.Wallet;
import backend.wallet.core.repository.UserRepository;
import backend.wallet.core.service.UserService;
import backend.wallet.core.service.WalletService;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final WalletService walletService;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);

    @Override
    public HashMap<String, UUID> create(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        UUID id = userRepository.save(user).getId();
        Wallet wallet = walletService.create(user);
        user.setWallet(wallet);
        userRepository.save(user);
        HashMap<String, UUID> hashMap = new HashMap<>();
        hashMap.put("id", id);
        return hashMap;
    }

    @Override
    public User getById(UUID id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public void update(UUID id, User user) {
        Optional<User> foundUser = userRepository.findById(id);
        if (foundUser.isPresent()) {
            User updateUser = foundUser.get();
            if (user.getLastName() != null) {updateUser.setLastName(user.getLastName());}
            if (user.getFirstName() != null) {updateUser.setFirstName(user.getFirstName());}
            if (user.getMiddleName() != null) {updateUser.setMiddleName(user.getMiddleName());}
            if (user.getBirthday() != null) {updateUser.setBirthday(user.getBirthday());}
            userRepository.save(updateUser);
        }
    }

    @Override
    public User signIn(UserSignInDto userSignInDto) {
        Optional<User> optionalFoundUser = userRepository.findByEmail(userSignInDto.email());
        if (optionalFoundUser.isPresent()){
            User FoundUser = optionalFoundUser.get();
            if (encoder.matches(userSignInDto.password(), FoundUser.getPassword())){
                return FoundUser;
            }
            log.warn("Неправильный пароль!");
            return null;
        }
        log.info("Такого пользователя не существует");
        return null;
    }
}
