create table usu(
    id serial not null,
    nom varchar not null,
    rg varchar null,
    cpf varchar null,
    cod_cad varchar null,
    dat_ina date null,
    constraint pk_id_usu primary key(id)
);