CREATE TABLE enderecos(
    id              BIGINT          NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    id_usuario      BIGINT          NULL                                ,
    id_unidade      BIGINT          NULL                                ,
    logradouro      VARCHAR(255)    NOT NULL                            ,
    cep             VARCHAR(15)     NOT NULL                            ,
    uf              VARCHAR(2)      NOT NULL                            ,
    bairro          VARCHAR(255)    NOT NULL                            ,
    numero          VARCHAR(30)     NULL                                ,
    complemento     VARCHAR(255)    NULL                                ,
    cidade          VARCHAR(255)    NOT NULL                            ,
    data_criacao    TIMESTAMP       NOT NULL DEFAULT NOW()
);