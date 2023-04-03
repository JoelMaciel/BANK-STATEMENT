package com.bank.statement.domain.services.impl;

import com.bank.statement.api.dtos.StatementDTO;
import com.bank.statement.domain.exceptions.AccountNotExistsException;
import com.bank.statement.domain.models.Statement;
import com.bank.statement.domain.repositories.StatementRepository;
import com.bank.statement.domain.services.StatementService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StatementServiceImpl implements StatementService {

    private final static String MSG_ACCOUNT_NOT_FOUND = "There is no account registered with this id";
    private final static String MSG_PERMISSION_DENIED = "Access is denied for this resource.";
    private final StatementRepository statementRepository;

    @Override
    public Page<StatementDTO> findByStatementAccount(UUID accountId, Pageable pageable) {
            existsAccountId(accountId);
            Page<Statement> statementPage = statementRepository.findAll(pageable);
            List<StatementDTO> statementList = statementRepository.findByAccountId(accountId, pageable)
                    .stream().map(StatementDTO::toDTO)
                    .collect(Collectors.toList());
            return new PageImpl<>(statementList, pageable, statementPage.getTotalElements());
    }

    @Override
    public StatementDTO save(Statement statement) {
        return StatementDTO.toDTO(statementRepository.save(statement));
    }

    @Override
    public Statement findByAccount(UUID accountId) {
        return statementRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotExistsException(MSG_ACCOUNT_NOT_FOUND));
    }

    @Override
    public boolean existsAccountId(UUID accountId) {
        if (!statementRepository.existsByAccountId(accountId)) {
            throw new AccountNotExistsException(MSG_ACCOUNT_NOT_FOUND);
        }
        return true;
    }
}
