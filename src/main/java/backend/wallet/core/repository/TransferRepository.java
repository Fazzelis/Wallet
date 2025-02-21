package backend.wallet.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import backend.wallet.core.model.Transfer;

import java.util.UUID;

public interface TransferRepository extends JpaRepository<Transfer, UUID> {
}
