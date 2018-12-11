/*
SELECT * FROM jobBoard_DB.worknet 
where 20181203 in
	(SELECT Cast(sdate as unsigned)as sdateInt FROM jobBoard_DB.worknet ) ;
    */
    
SELECT *
FROM (SELECT Cast(sdate as unsigned)as sdateInt , Cast(edate as unsigned)as edateInt , title,name,type,logo,url
		FROM jobBoard_DB.worknet ) as j
WHERE sdateInt>=20181203;