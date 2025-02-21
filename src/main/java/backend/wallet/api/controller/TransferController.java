package backend.wallet.api.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import backend.wallet.api.dto.transfer.TransferDto;
import backend.wallet.core.model.Transfer;
import backend.wallet.core.service.TransferService;

import java.util.UUID;

@AllArgsConstructor
@RestController
@Slf4j
@RequestMapping("/transfers")
public class TransferController {
    private final TransferService transferService;

    @PostMapping
    public Transfer doTransfer(@RequestBody TransferDto transferDto){
        return transferService.doTransfer(transferDto);
    }

    @GetMapping("/{id}")
    public Transfer getTransfer(@PathVariable(name = "id") UUID transferUUID){
        return transferService.getTransfer(transferUUID);
    }
}
