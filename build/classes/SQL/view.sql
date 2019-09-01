


create view AllEmploye as 
SELECT e.CIN_E as  cin ,ROLEPERSONNEL as Role ,Nom,Prenom,Telephone,cp.DATEDEBUC as date debut,cp.DATEFINC as date fin FROM employe as e inner JOIN contratpersonnelhIstorique as cp  on e.cin_E=cp.CIN_E
union 
SELECT e.CIN_E as  cin ,ROLEPERSONNEL as Role ,Nom,Prenom,Telephone,cp.DATEDEBUC as date debut,cp.DATEFINC as date fin FROM employe as e inner JOIN contratpersonnel as cp  on e.cin_E=cp.CIN_E ;



	
	
	/* creation de la vue contrat :  */ 
	create view contrat  as  select  * from (
	select IDC, CIN_E, CIN_D, DATEDEBUC, DATEFINC , TYPECONTRAT , ROLEPERSONNEL, SALAIRE , DESCRIPTION , dateC from `contratpersonnel` 
	union 
	select IDC , CIN_E ,CIN_D , DATEDEBUC , DATEFINC ,TYPECONTRAT , ROLEPERSONNEL ,SALAIRE, DESCIPTION as DESCRIPTION , dateC 
	from contratpersonnelhistorique as cph where `dateC`>=all ( select max(dateC) from contratpersonnelhistorique as cplh where cplh.CIN_E=cph.cin_e )
	and cin_e not in ( select cin_e from contratpersonnel ) )
	`result` order by `result`.`DATEFINC` desc;
	

	/* creation la vue  employeactuel : */ 
	create or replace view  employeactuel as 
  select `e`.`CIN_E` AS `cin`,`cp`.`ROLEPERSONNEL` AS `Role`,`e`.`NOM` AS `Nom`,`e`.`PRENOM` AS `Prenom`,`e`.`TELEPHONE` AS `Telephone`,
	`cp`.`DATEDEBUC` AS `date debut`,
	`cp`.`DATEFINC` AS `date fin` from `employe` `e` 
	join `contratpersonnel` `cp` on(`e`.`CIN_E` = `cp`.`CIN_E`)
	
	

	 
	/* creation  la vue EmployePrecedent*/
	create view  employeprecedent as 
	select `e`.`CIN_E` AS `cin`,`cp`.`ROLEPERSONNEL` AS `Role`,`e`.`NOM` AS `Nom`,`e`.`PRENOM` AS `Prenom`, `e`.`TELEPHONE` AS `Telephone`,`cp`.`DATEDEBUC` AS `date debut`,`cp`.`DATEFINC` AS `date fin` 
	from `employe` `e` join `contratpersonnelhistorique` `cp` on `e`.`CIN_E` = `cp`.`CIN_E` where `dateC`>=all ( select max(dateC) from contratpersonnelhistorique as cplh where cplh.CIN_E=cp.cin_e )
	and cp.cin_e not in ( select cin_e from contratpersonnel ) ;