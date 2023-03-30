package com.bank.statement.domain.services;

import com.bank.statement.api.dtos.StatementDTO;
import com.bank.statement.domain.models.Statement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface StatementService {
   Page<StatementDTO> findByStatementAccount(UUID accountId, Pageable pageable);

    StatementDTO save(Statement statement);

    Statement findByAccount(UUID accountId);

    boolean existsAccountId(UUID accountId);
}
