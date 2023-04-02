package com.bank.statement.api.controllers;

import com.bank.statement.api.dtos.StatementDTO;
import com.bank.statement.domain.services.StatementService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RestController
public class StatementController {

    private final StatementService statementService;

    @PreAuthorize("hasAnyRole('CUSTOMER')")
    @GetMapping("/statements/{accountId}")
    public Page<StatementDTO> getStatementAccount(@PathVariable UUID accountId, Pageable pageable ,
                                                  Authentication authentication) {
        return statementService.findByStatementAccount(accountId, pageable);
    }
}
