CREATE TABLE despesas (
    id              BIGINT        NOT NULL AUTO_INCREMENT PRIMARY KEY,
    categoria       VARCHAR(100)  NOT NULL,
    descricao       VARCHAR(500)  NOT NULL,
    valor_original  DECIMAL(10,2) NOT NULL,
    valor_pago      DECIMAL(10,2) NULL,
    data_vencimento DATE          NOT NULL,
    data_pagamento  DATE          NULL,
    data_criacao    TIMESTAMP     NOT NULL DEFAULT NOW(),
    status          ENUM('PAGO', 'NAO_PAGO', 'ATRASADO', 'CANCELADO') NOT NULL
);

-- 7/7/25

CRATE TABLE usuarios (
    id              BIGINT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome            VARCHAR(255)    NOT NULL,
    email           VARCHAR(255)    NOT NULL UNIQUE,
    senha           VARCHAR(255)    NOT NULL,
    permite_escrita BOOLEAN         NOT NULL DEFAULT false
);