/*
set schema azsnprod;

select * from couvert where numeco=2000220 and cdfing=20171231;

select sum(prinet) from azsntest.grpmvt where nuquit=2017000427;

select * from AZSNTEST.quittanc where nuquit=2017000259;

select *  from produit where cdprod=20;
select * from azsnprod.polchar where numeco=2000220;

select * from polgrp where numeco=2000220;

select * from police  where numeco=2000220;

select * from garpol where numeco=2000220;

select * from azsntest.polchar where numeco=2000220 ;
select * from azsnprod.garpol where numeco=2000220 ;

select * from azsnprod.grpmvt where nuquit=2017000538;

select * from polchar where numeco=2000220;

select * from azsnprod.garass where numeco=2000220 and noassu=111696;

set schema azsntest;

SELECT * from couvert where numeco=2000220 and noassu=111696;

select * from azsnprod.grpmvt where nuquit=2017000538;

select * from azsntest.quittanc where nuquit=2017000259;

select sum(cprttc) from azsnprod.couvert where cdfing=20171231 and numeco=2000220;

set schema azsnprod;

select * from azsnprod.quittanc where cdprod=20 and numeco=2000220;

select cvdmaj,sum(cprttc) from couvert where numeco=2000220 and cdfing=20171231 group by cvdmaj;

select * from polchar where numeco=2000220;
*/


set schema azsnprod;

select * from quittanc where nuquit=2017000427;

/***/

 update azsnprod.quittanc
 set prinet=21764986, pritot=21774986, commis=3266024
 where nuquit=2017000259;

/***/

select * from azsntest.quittanc where nuquit=2017000259;
