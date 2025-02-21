package backend.wallet.core.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Transfer")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "from_user")
    private UUID fromUseerUUID;

    @Column(name = "to_user")
    private UUID toUserUUID;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    @Column(name = "amount")
    private long amount;
}
