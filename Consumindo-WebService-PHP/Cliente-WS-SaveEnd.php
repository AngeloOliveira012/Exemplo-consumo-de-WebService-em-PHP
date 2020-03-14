<?php

include ('C:\xampp\htdocs\cursophp.com\lib/nusoap.php'); //endereço onde esta localizado a lib com nusoap

$cliente = new nusoap_client('http://localhost:8080/WebS.BD.Correios/SalvaEnd?WSDL',true); //criando objeto passando WSDL do webservice

$dados_end = array('cep'=>'12721190','rua'=>'16','bairro'=>'jp','cidade'=>'cruzeiro','uf'=>'sp'); //criando um parametro e inserindo dasos para o consumo do WS

$result = $cliente->call('salvaEnd',$dados_end); //chamando o ws e passando os parametros

print_r ($result);//printando o resultado

?>