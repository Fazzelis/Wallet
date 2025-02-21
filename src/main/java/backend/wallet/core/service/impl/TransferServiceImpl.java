package backend.wallet.core.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import backend.wallet.api.dto.transfer.TransferDto;
import backend.wallet.core.model.Transfer;
import backend.wallet.core.model.User;
import backend.wallet.core.model.Wallet;
import backend.wallet.core.repository.TransferRepository;
import backend.wallet.core.repository.UserRepository;
import backend.wallet.core.repository.WalletRepository;
import backend.wallet.core.service.TransferService;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class TransferServiceImpl implements TransferService {
    private final UserRepository userRepository;
    private final WalletRepository walletRepository;
    private final TransferRepository transferRepository;

    @Override
    public Transfer doTransfer(TransferDto transferDto) {
        User fromUser = userRepository.findById(transferDto.fromUserId()).get();
        Optional<User> optionalToUser = userRepository.findById(transferDto.toUserId());
        if (optionalToUser.isPresent()){
            Wallet fromWallet = fromUser.getWallet();
            if (fromWallet.getBalance() >= transferDto.amount()){
                User toUser = optionalToUser.get();
                Wallet toWallet = toUser.getWallet();
                toWallet.setBalance(toWallet.getBalance() + transferDto.amount());
                fromWallet.setBalance(fromWallet.getBalance() - transferDto.amount());
                walletRepository.save(fromWallet);
                walletRepository.save(toWallet);
                Transfer transfer = Transfer.builder()
                        .creationTime(LocalDateTime.now())
                        .fromUseerUUID(transferDto.fromUserId())
                        .toUserUUID(transferDto.toUserId())
                        .amount(transferDto.amount())
                        .build();
                transferRepository.save(transfer);
                return transfer;
            }
            log.info("Недостаточно средств!");
            return null;
        }
        log.info("Пользователь, которому вы хотите перевести деньги, не найден!");
        return null;
    }

    @Override
    public Transfer getTransfer(UUID transferUUID) {
        Optional<Transfer> optionalTransfer = transferRepository.findById(transferUUID);
        return optionalTransfer.orElse(null);
    }
}
