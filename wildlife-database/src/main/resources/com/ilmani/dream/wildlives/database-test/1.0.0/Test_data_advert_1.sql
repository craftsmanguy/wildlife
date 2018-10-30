INSERT INTO ADVERT (id, functional_id, insertion_date, start_date, end_date, title, description, state) VALUES
    ('967d6dff-7a79-4523-a1c3-de7a3353f711', 'tex1-descrip1-2013-affenpinsher-1995-0001', '2013-09-22 16:19:43', '2015-09-22 16:19:43',
    	'2013-09-22 16:19:43', 'titre 1', 'description 1', 'STEP_1'),
    ('2def8f49-afdb-461f-9782-a3b4593d028a', 'tex2-descrip2-2013-airedale_terrier-1997-002', '2013-04-02 12:45:34', '2013-04-02 12:45:34',
    	'2013-09-22 16:19:43', 'titre 2', 'description 2', 'STEP_2'),
    ('80faaf12-af73-4ba1-9ac9-ae6a72f802e8', 'tex3-descrip3-2013-akita_americain-1999-003', '2013-04-11 17:36:11', '2013-04-11 17:36:11',
    	'2013-09-22 16:19:43', 'titre 3', 'description 3', 'STEP_3'),
    ('4d171ced-6058-409a-aedf-613f063b3126', 'tex4-descrip4-2013-american_staffordshire-2003-005', '2018-04-06 12:45:34', '2018-04-06 12:45:34',
    	'2013-09-22 16:19:43', 'titre 4', 'description 4', 'STEP_4'),
    ('5d7d660d-29bc-460e-adff-8fe7720a46ee', 'tex5-descrip5-2013-ariegois-2005-006', '2013-09-22 17:06:22', '2013-09-22 17:06:22',
    	'2013-09-22 16:19:43', 'titre 5', 'description 5', 'STEP_5'),
    ('54d0c24a-ae20-4c06-a709-29b3a9537473', 'tex6-descrip6-2013-azawakh-2007-007', '2018-09-22 17:06:22', '2018-09-22 17:06:22',
    	'2013-09-22 16:19:43', 'titre 6', 'description 6', 'STEP_6'),
    
    ('17c5368b-c1cf-4b6b-a8b2-d9588c641222', 'tex7-descrip7-2013-abyssin-2009-008', '2018-09-22 17:06:22', '2018-09-22 17:06:22',
    	'2013-09-22 16:19:43', 'titre 7', 'description 7', 'STEP_7');
    	

INSERT INTO ADVERT_JOIN_FORMAT(advert_id, format_id) VALUES
	('967d6dff-7a79-4523-a1c3-de7a3353f711', 1),('967d6dff-7a79-4523-a1c3-de7a3353f711',2),('967d6dff-7a79-4523-a1c3-de7a3353f711',3),
	('2def8f49-afdb-461f-9782-a3b4593d028a', 3),('80faaf12-af73-4ba1-9ac9-ae6a72f802e8', 1),('4d171ced-6058-409a-aedf-613f063b3126', 5),
	('5d7d660d-29bc-460e-adff-8fe7720a46ee', 1), ('54d0c24a-ae20-4c06-a709-29b3a9537473', 6), ('17c5368b-c1cf-4b6b-a8b2-d9588c641222', 6);
    commit;