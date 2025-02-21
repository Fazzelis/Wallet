package backend.wallet.core.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import backend.wallet.core.model.User;
import backend.wallet.core.model.Wallet;
import backend.wallet.core.repository.WalletRepository;
import backend.wallet.core.service.WalletService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;
    @Override
    public Wallet getWallet(UUID id) {
        return walletRepository.findById(id).orElse(null);
    }

    @Override
    public Wallet create(User user) {
        Wallet wallet = Wallet.builder()
                .user(user)
                .balance(5000) // Для теста переводов задал стандартное значение в 5000
                .build();
        walletRepository.save(wallet);
        return wallet;
    }
}
