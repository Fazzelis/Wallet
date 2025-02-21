package backend.wallet.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import backend.wallet.api.dto.wallet.WalletDto;
import backend.wallet.api.mapper.WalletMapper;
import backend.wallet.core.service.WalletService;

import java.util.UUID;

@RestController
@RequestMapping("/wallets")
@RequiredArgsConstructor
@Slf4j
public class WalletController {
    private final WalletService walletService;
    private final WalletMapper walletMapper;

    @GetMapping("/{id}")
    public WalletDto get(@PathVariable(name = "id") UUID id) {
        return walletMapper.map(walletService.getWallet(id));
    }
}
