CREATE TABLE usuarios (
    id              BIGINT          NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    nome            VARCHAR(255)    NOT NULL                            ,
    email           VARCHAR(255)    NOT NULL UNIQUE                     ,
    senha           VARCHAR(255)    NOT NULL                            ,
    numero_apto     VARCHAR(30)     NULL                                ,
    admin           BOOLEAN         NOT NULL DEFAULT false              ,
    data_criacao    TIMESTAMP     NOT NULL DEFAULT NOW()
);