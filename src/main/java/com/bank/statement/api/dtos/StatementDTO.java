package com.bank.statement.api.dtos;

import com.bank.statement.domain.models.Statement;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatementDTO {

    @JsonIgnore
    private UUID statementId;
    @JsonIgnore
    private UUID accountId;
    private String numberAccount;
    private String type;
    private BigDecimal amount;
    private String transaction;
    private OffsetDateTime transactionDate;

    public static StatementDTO toDTO(Statement statement) {
        return StatementDTO.builder()
                .statementId(statement.getStatementId())
                .accountId(statement.getAccountId())
                .numberAccount(statement.getNumberAccount())
                .type(statement.getType())
                .amount(statement.getAmount())
                .transaction(statement.getTransaction())
                .transactionDate(statement.getTransactionDate())
                .build();
    }
}
