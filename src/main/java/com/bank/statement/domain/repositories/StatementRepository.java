package com.bank.statement.domain.repositories;

import com.bank.statement.domain.models.Statement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StatementRepository extends JpaRepository<Statement, UUID> {
}
