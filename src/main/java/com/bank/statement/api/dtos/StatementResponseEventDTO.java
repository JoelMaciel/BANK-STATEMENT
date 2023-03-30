package com.bank.statement.api.dtos;

import com.bank.statement.domain.models.Statement;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatementResponseEventDTO {

    private UUID statementId;
    private UUID accountId;
    private String number;
    private String type;
    private BigDecimal amount;
    private String transaction;
    private OffsetDateTime transactionDate;

    public static Statement toEntity(StatementResponseEventDTO  statementResponseEventDTO) {
        return Statement.builder()
                .statementId(statementResponseEventDTO.getStatementId())
                .accountId(statementResponseEventDTO.getAccountId())
                .numberAccount(statementResponseEventDTO.getNumber())
                .type(statementResponseEventDTO.getType())
                .amount(statementResponseEventDTO.getAmount())
                .transaction(statementResponseEventDTO.getTransaction())
                .transactionDate(statementResponseEventDTO.getTransactionDate())
                .build();
    }
}
