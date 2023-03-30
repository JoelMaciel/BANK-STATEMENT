package com.bank.statement.api.consumer;

import com.bank.statement.api.dtos.StatementResponseEventDTO;
import com.bank.statement.domain.services.StatementService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StatementConsumer {

    private final StatementService statementService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "${bank.broker.queue.accountEventQueue.name}", durable = "true"),
            exchange = @Exchange(value = "${bank.broker.exchange.accountEventExchange}",
                    type = ExchangeTypes.FANOUT, ignoreDeclarationExceptions = "true")
    ))
    public void listenAccountEvent(@Payload StatementResponseEventDTO statementResponseEventDTO) {
        var statement =  StatementResponseEventDTO.toEntity(statementResponseEventDTO);

        switch (statementResponseEventDTO.getTransaction()) {
            case "WITHDRAW", "TRANSFER", "DEPOSIT" -> statementService.save(statement);
        }
    }
}
