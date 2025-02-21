package backend.wallet.api.mapper;

import org.springframework.stereotype.Component;
import backend.wallet.api.dto.wallet.WalletDto;
import backend.wallet.core.model.Wallet;

@Component
public class WalletMapper {
    public WalletDto map(Wallet wallet) {
        return WalletDto.builder()
                .number(wallet.getId())
                .balance(wallet.getBalance())
                .build();
    }
}
