CREATE TABLE receitas(
    id              BIGINT          NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    descricao       VARCHAR(255)    NOT NULL                            ,
    data_pagamento  DATE            NULL                                ,
    valor           DECIMAL(10,2)   NOT NULL                            ,
    categoria       VARCHAR(255)    NOT NULL                            ,
    id_unidade      BIGINT          NULL                                ,
    data_vencimento DATE            NOT NULL                            ,
    id_usuario      BIGINT          NOT NULL                            ,
    data_criacao    TIMESTAMP       NOT NULL DEFAULT NOW()              ,
    CONSTRAINT fk_receitas_usuarios FOREIGN KEY(id_usuario) REFERENCES usuarios(id)
);