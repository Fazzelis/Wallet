package backend.wallet.api.dto.transfer;

import java.util.UUID;

public record TransferDto(
        UUID fromUserId,
        UUID toUserId,
        long amount
) {
}
