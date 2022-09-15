DELETE FROM user;
INSERT INTO user (ID, USERNAME, PHONE, RATING) VALUES
(1, 'Rui', '777888', 7.0),
(2, 'Zé', '777999', 4.0),
(3, 'Zequinha', '777111', 3.0),
(4, 'Urso', '777000', 9.0);

DELETE FROM challenge;
INSERT INTO challenge (CHALLENGEID, CHALLENGEDESCRIPTION ,DIFFICULTYLEVEL, WASEXECUTED) VALUES
(1,'Drink shot while doing a handstand', 5, false),
(2, 'Snort a line of coke', 9, false),
(3, 'Shotgun a beer', 3, false ),
(4, 'Do a backflip and take a shot', 7, true);

