create table Student
(
    id uuid default random_uuid()  not null primary key,
    lastName varchar(255) null,
    name varchar(255) null
);

INSERT INTO Student (id, lastName, name) VALUES (0x3CD029C341314B198FCF768299D13188, 'Zucya', 'Anpyu');
INSERT INTO Student (id, lastName, name) VALUES (0x43107AC7FB7B4B12AABFC2A7CAB23290, 'Aransuacey', 'Turun');
INSERT INTO Student (id, lastName, name) VALUES (0x4B6D6448E6B7435689276BBFBA87AC20, 'Xeun', 'Oldoe');
INSERT INTO Student (id, lastName, name) VALUES (0xEC386AA734BB49BC863BB52E453C3F22, 'Zayco', 'Numoa');