package backend.wallet.api.dto.user;

import lombok.Builder;

@Builder
public record UserSignInDto(
        String email,
        String password
) {
}
