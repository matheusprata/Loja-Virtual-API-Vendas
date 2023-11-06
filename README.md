# Loja-Virtual-API-Vendas
API de vendas com carrinho de compras, promoções e produtos

## Link da aplicação funcionando no railway e usando o swagger para consultar e passar os valores
https://loja-virtual-api-vendas-production.up.railway.app/venda/api/public/swagger-ui/index.html#/

```
INSERT INTO TB_PRODUCT (id_product, name, price, promotion) VALUES (1, 'sabão', 12, 'BUY_ONE_GET_ONE_FREE');
INSERT INTO TB_PRODUCT (id_product, name, price, promotion) VALUES (2, 'shampoo', 8, 'NONE');
INSERT INTO TB_PRODUCT (id_product, name, price, promotion) VALUES (3, 'toalha', 15, 'NONE');
INSERT INTO TB_PRODUCT (id_product, name, price, promotion) VALUES (4, 'sabonete', 5, 'BUY_ONE_GET_ONE_FREE');
INSERT INTO TB_PRODUCT (id_product, name, price, promotion) VALUES (5, 'escova de dentes', 3, 'NONE');
INSERT INTO TB_PRODUCT (id_product, name, price, promotion) VALUES (6, 'pasta de dente', 4.5, 'BUY_ONE_GET_ONE_FREE');
INSERT INTO TB_PRODUCT (id_product, name, price, promotion) VALUES (7, 'condicionador', 7.5, 'NONE');
INSERT INTO TB_PRODUCT (id_product, name, price, promotion) VALUES (8, 'sabonete líquido', 6.5, 'BUY_ONE_GET_ONE_FREE');
INSERT INTO TB_PRODUCT (id_product, name, price, promotion) VALUES (9, 'papel higiênico', 2.75, 'NONE');
INSERT INTO TB_PRODUCT (id_product, name, price, promotion) VALUES (10, 'cotonetes', 1.25, 'NONE');
INSERT INTO TB_PRODUCT (id_product, name, price, promotion) VALUES (11, 'escova de cabelo', 5.0, 'NONE');
INSERT INTO TB_PRODUCT (id_product, name, price, promotion) VALUES (12, 'desodorante', 6.25, 'BUY_ONE_GET_ONE_FREE');
INSERT INTO TB_PRODUCT (id_product, name, price, promotion) VALUES (13, 'shampoo para bebê', 3.75, 'BUY_ONE_GET_ONE_FREE');
INSERT INTO TB_PRODUCT (id_product, name, price, promotion) VALUES (14, 'alvejante', 4.0, 'NONE');
INSERT INTO TB_PRODUCT (id_product, name, price, promotion) VALUES (15, 'lâmina de barbear', 1.0, 'NONE');
```
```
INSERT INTO tb_buy (product_id, type_pay, valor_entrada, desconto, quantidade_parcelas, valor_final, data_buy, observacao, status)
VALUES (1, 'CARTAO_CREDITO', 100.00, 10, 3, 270.00, '2023-11-05', 'Observação da compra', 'DISPONIVEL');
```
