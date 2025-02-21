package backend.wallet.core.service;

import backend.wallet.api.dto.transfer.TransferDto;
import backend.wallet.core.model.Transfer;

import java.util.UUID;

public interface TransferService {
    Transfer doTransfer(TransferDto transferDto);
    Transfer getTransfer(UUID transferUUID);
}
