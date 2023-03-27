package com.bank.statement.domain.services.impl;

import com.bank.statement.domain.repositories.StatementRepository;
import com.bank.statement.domain.services.StatementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StatementServiceImpl implements StatementService {

    private final StatementRepository statementRepository;
}
