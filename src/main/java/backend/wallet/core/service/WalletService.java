package backend.wallet.core.service;

import backend.wallet.core.model.User;
import backend.wallet.core.model.Wallet;

import java.util.UUID;

public interface WalletService {
    Wallet getWallet(UUID id);
    Wallet create(User user);
}
