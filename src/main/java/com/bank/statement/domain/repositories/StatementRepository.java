package com.bank.statement.domain.repositories;

import com.bank.statement.domain.models.Statement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface StatementRepository extends JpaRepository<Statement, UUID> {

    Page<Statement> findByAccountId(UUID accountId, Pageable pageable);

    boolean existsByAccountId(UUID accountId);
}
