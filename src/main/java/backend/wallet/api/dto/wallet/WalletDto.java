package backend.wallet.api.dto.wallet;

import lombok.Builder;

import java.util.UUID;

@Builder
public record WalletDto(
        UUID number,
        long balance
) {
}
