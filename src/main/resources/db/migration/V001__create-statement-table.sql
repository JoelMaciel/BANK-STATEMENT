CREATE TABLE `statement` (
  `statement_id` varchar(255) NOT NULL,
  `transaction` varchar(50) NOT NULL,
  `transaction_amount` decimal(19,2) NOT NULL,
  `creation_date` datetime NOT NULL,
  PRIMARY KEY (`statement_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci