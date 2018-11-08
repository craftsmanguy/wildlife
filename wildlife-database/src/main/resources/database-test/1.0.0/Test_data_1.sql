INSERT INTO RACE (id, name, scientist_name, code, specie, clan,  is_active) VALUES
    (RACE_SEQ_ID.NEXTVAL, 'AFFENPINSCHER', '', 'AFFEN_DOG', 'DOG', 'MAMMALIA', true),
    (RACE_SEQ_ID.NEXTVAL, 'AIREDALE_TERRIER', '', 'AI_TE_DOG', 'DOG', 'MAMMALIA', true),
    (RACE_SEQ_ID.NEXTVAL, 'AKITA_AMERICAIN', '', 'AK_AM_DOG', 'DOG', 'MAMMALIA', true),
    (RACE_SEQ_ID.NEXTVAL, 'AKITA_INU', '', 'AI_IN_DOG', 'DOG', 'MAMMALIA', true),
    (RACE_SEQ_ID.NEXTVAL, 'AMERICAN_STAFFORDSHIRE', '', 'AM_ST_DOG', 'DOG', 'MAMMALIA', true),
    (RACE_SEQ_ID.NEXTVAL, 'ARIEGOIS', '', 'ARIEG_DOG', 'DOG', 'MAMMALIA', true),
    (RACE_SEQ_ID.NEXTVAL, 'AZAWAKH', '', 'AZAWA_DOG', 'DOG', 'MAMMALIA', true),
    (RACE_SEQ_ID.NEXTVAL, 'ABYSSIN', '', 'ABYSS_CAT', 'CAT', 'MAMMIFERE', false);

    
INSERT INTO FORMAT (id, name, code, feature, is_active) VALUES
    (FORMAT_SEQ_ID.NEXTVAL, 'REQUEST', 'REQ_PET_CAR', 'PET_CARE', true),
    (FORMAT_SEQ_ID.NEXTVAL, 'REQUEST', 'REQ_BOA_SCH', 'BOARDING_SCHOOL', true),
    (FORMAT_SEQ_ID.NEXTVAL, 'REQUEST', 'REQ_WAL', 'WALK',  true),
    (FORMAT_SEQ_ID.NEXTVAL, 'REQUEST', 'REQ_TRA', 'TRAINING', true),
    (FORMAT_SEQ_ID.NEXTVAL, 'OFFER', 'OFF_PET_CAR', 'PET_CARE', true),
    (FORMAT_SEQ_ID.NEXTVAL, 'OFFER', 'OFF_BOA_SCH', 'BOARDING_SCHOOL', true),
    (FORMAT_SEQ_ID.NEXTVAL, 'OFFER', 'OFF_WAL', 'WALK', true),
    (FORMAT_SEQ_ID.NEXTVAL, 'OFFER', 'OFF_TRA', 'TRAINING', false);

    
INSERT INTO PARTICIPANT (id, insertion_date, pseudonym, email, country, postal_code, city, pass) VALUES
    ('1d7f8438-e845-4c7f-94bd-016c9531bc44', '2013-09-22 16:19:43', 'Matthieu', 'm@ya.fr', 'France', '78210', 'Paris', '$2a$08$9QVBIMRQTnK3gYZCszPbGudQwdH7yzIzxWzDQq5UB8'),
    ('609eaa18-d4e7-4135-a6e1-ed9085cb5379', '2013-04-02 12:45:34', 'Alan', 'ou@pas.gh', 'France', '78210', 'Toulouse', '$2a$12$CKx9TW96souUe/AhpyU5mO.cHf/PHCWuw/8d1pYNY/xi7pgWjRC1a'),
    ('804db619-7be4-489d-9bde-256150629264', '2013-04-11 17:36:11', 'Raschord', 'la@question.com', 'Italie', '78210', 'Rome', 'Toto12345');
    
    
INSERT INTO PET (id, functional_id, insertion_date, name, description, is_lof, gender, birth, race_id, participant_id) VALUES
    ('1726590e-477d-4af6-8500-edb13b53dc9c', 'rex-pet-dog-affenpinsher-1995-0001', '2013-09-22 16:19:43', 'Rex', 'aucune', false, 'MALE', 1995, 1, '1d7f8438-e845-4c7f-94bd-016c9531bc44'),
    ('01de7281-2af8-44dd-ba3c-0659692e88a2', 'alan-pet-dog-airedale_terrier-1997-002', '2013-04-02 12:45:34', 'Alan', 'ou pas', true, 'FEMALE', 1997, 2, '1d7f8438-e845-4c7f-94bd-016c9531bc44'),
    ('cffb99e4-6e99-43b0-9e02-0d23549486dc', 'coby-pet-dog-akita_americain-1999-003', '2013-04-11 17:36:11', 'Coby', 'la question',false, 'FEMALE', 1999, 1, '1d7f8438-e845-4c7f-94bd-016c9531bc44'),
    ('6e3dd86d-fffd-4c17-a0e9-5e423ea5a640', 'cocotte-pet-dog-akita_inu-2001-004', '2013-09-02 09:08:47', 'cocotte', 'pas une seule des descriptions ', true, 'FEMALE', 2001, 5, '1d7f8438-e845-4c7f-94bd-016c9531bc44'),
    ('5b693a8f-e1fa-459c-bcb7-e2146edefa8d', 'bra-pet-dog-american_staffordshire-2003-005', '2018-04-06 12:45:34', 'bra', 'seulement', false, 'MALE', 2003, 3, '609eaa18-d4e7-4135-a6e1-ed9085cb5379'),
    ('67a742f0-4ed6-4695-b2cf-a3ff3c4a206d', 'pain-pet-dog-ariegois-2005-006', '2013-09-22 17:06:22', 'pain', 'rien', false, 'FEMALE', 2005, 6, '609eaa18-d4e7-4135-a6e1-ed9085cb5379'),
    ('023156c1-a04f-4562-8503-b51ba6bd6871', 'et_si-pet-dog-azawakh-2007-007', '2018-09-22 17:06:22', 'et si', '', true, 'MALE', 2007, 1, '609eaa18-d4e7-4135-a6e1-ed9085cb5379'),
    ('69cb490a-4d36-4056-8858-f608eea5d845', 'quoi-pet-cat-abyssin-2009-008', '2018-09-22 17:06:22', 'quoi', '', true, 'FEMALE', 2009, 8, '804db619-7be4-489d-9bde-256150629264');
    
    
INSERT INTO ADVERT (id, functional_id, insertion_date, start_date, end_date, title, description, state, participant_id) VALUES
    ('967d6dff-7a79-4523-a1c3-de7a3353f711', 'tex1-descrip1-2013-affenpinsher-1995-0001', '2013-09-22 16:19:43', '2015-09-22 16:19:43',
    	'2013-09-22 16:19:43', 'titre 1', 'description 1', 'STEP_1', '1d7f8438-e845-4c7f-94bd-016c9531bc44'),
    ('2def8f49-afdb-461f-9782-a3b4593d028a', 'tex2-descrip2-2013-airedale_terrier-1997-002', '2013-04-02 12:45:34', '2013-04-02 12:45:34',
    	'2013-09-22 16:19:43', 'titre 2', 'description 2', 'STEP_2', '1d7f8438-e845-4c7f-94bd-016c9531bc44'),
    ('80faaf12-af73-4ba1-9ac9-ae6a72f802e8', 'tex3-descrip3-2013-akita_americain-1999-003', '2013-04-11 17:36:11', '2013-04-11 17:36:11',
    	'2013-09-22 16:19:43', 'titre 3', 'description 3', 'STEP_3', '804db619-7be4-489d-9bde-256150629264'),
    ('4d171ced-6058-409a-aedf-613f063b3126', 'tex4-descrip4-2013-american_staffordshire-2003-005', '2018-04-06 12:45:34', '2018-04-06 12:45:34',
    	'2013-09-22 16:19:43', 'titre 4', 'description 4', 'STEP_4', '804db619-7be4-489d-9bde-256150629264'),
    ('5d7d660d-29bc-460e-adff-8fe7720a46ee', 'tex5-descrip5-2013-ariegois-2005-006', '2013-09-22 17:06:22', '2013-09-22 17:06:22',
    	'2013-09-22 16:19:43', 'titre 5', 'description 5', 'STEP_5', '1d7f8438-e845-4c7f-94bd-016c9531bc44'),
    ('54d0c24a-ae20-4c06-a709-29b3a9537473', 'tex6-descrip6-2013-azawakh-2007-007', '2018-09-22 17:06:22', '2018-09-22 17:06:22',
    	'2013-09-22 16:19:43', 'titre 6', 'description 6', 'STEP_6', '1d7f8438-e845-4c7f-94bd-016c9531bc44'),
    ('17c5368b-c1cf-4b6b-a8b2-d9588c641222', 'tex7-descrip7-2013-abyssin-2009-008', '2018-09-22 17:06:22', '2018-09-22 17:06:22',
    	'2013-09-22 16:19:43', 'titre 7', 'description 7', 'STEP_7', '1d7f8438-e845-4c7f-94bd-016c9531bc44');
    	

INSERT INTO ADVERT_JOIN_FORMAT(advert_id, format_id) VALUES
	('967d6dff-7a79-4523-a1c3-de7a3353f711', 1),('967d6dff-7a79-4523-a1c3-de7a3353f711',2),('967d6dff-7a79-4523-a1c3-de7a3353f711',3),
	('2def8f49-afdb-461f-9782-a3b4593d028a', 3),('80faaf12-af73-4ba1-9ac9-ae6a72f802e8', 1),('4d171ced-6058-409a-aedf-613f063b3126', 5),
	('5d7d660d-29bc-460e-adff-8fe7720a46ee', 1), ('54d0c24a-ae20-4c06-a709-29b3a9537473', 6), ('17c5368b-c1cf-4b6b-a8b2-d9588c641222', 6);


INSERT INTO ADVERT_JOIN_PET(advert_id, pet_id) VALUES
	('967d6dff-7a79-4523-a1c3-de7a3353f711', '023156c1-a04f-4562-8503-b51ba6bd6871'),('967d6dff-7a79-4523-a1c3-de7a3353f711','5b693a8f-e1fa-459c-bcb7-e2146edefa8d'),
	('967d6dff-7a79-4523-a1c3-de7a3353f711', 'cffb99e4-6e99-43b0-9e02-0d23549486dc'),('2def8f49-afdb-461f-9782-a3b4593d028a', 'cffb99e4-6e99-43b0-9e02-0d23549486dc'),
	('17c5368b-c1cf-4b6b-a8b2-d9588c641222', '023156c1-a04f-4562-8503-b51ba6bd6871');
    commit;