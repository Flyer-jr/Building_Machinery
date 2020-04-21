INSERT INTO public.m_user (id, first_name, second_name, phone_number, password, post, actual, date_of_dismiss, role,
                           login, email)
VALUES (4, 'Дмитрий', 'николенко', '+375296335142', '+375296335142', 'Главный Инженер', false, '2016-09-27', 2, 'dimon',
        'dimasik@gmail.com');
INSERT INTO public.m_user (id, first_name, second_name, phone_number, password, post, actual, date_of_dismiss, role,
                           login, email)
VALUES (1, 'Алексей', 'летун', '+375293047729', '$2y$08$JLniibofdY71hJqeVoa/p.VZXfxjf0PKtHGfwxPsD7mWXRhEIeoXS',
        'Главный Инженер', true, null, 1, 'flyer', 'alexflyer.jr@gmail.com');
INSERT INTO public.m_user (id, first_name, second_name, phone_number, password, post, actual, date_of_dismiss, role,
                           login, email)
VALUES (3, 'Александр', 'третьяк', '+375293935878', '+375293935878', 'Прораб', true, null, 2, 'sid',
        'tretyaksancho@tut.by');
INSERT INTO public.m_user (id, first_name, second_name, phone_number, password, post, actual, date_of_dismiss, role,
                           login, email)
VALUES (2, 'Юрий', 'медведев', '+375296221161', '+375296221161', 'Директор', true, null, 1, 'medvedev',
        'yurimedvedev@gmail.com');
INSERT INTO public.m_user (id, first_name, second_name, phone_number, password, post, actual, date_of_dismiss, role,
                           login, email)
VALUES (5, 'Денис', 'чехлинков', '+375293772906', '+375293772906', 'Главный Инженер', false, '2015-04-24', 1, 'den',
        'denchik@mail.by');

INSERT INTO public.m_roles (role_id, role_name)
VALUES (1, 'ROLE_ADMIN');
INSERT INTO public.m_roles (role_id, role_name)
VALUES (2, 'ROLE_USER');

INSERT INTO public.m_contractor (id, short_name, full_name, address)
VALUES (6, 'ситик', 'Citic Construction LLC', '32nd Floor, CITIC Tower 1 Tim Mei Avenue Central, Hong Kong');
INSERT INTO public.m_contractor (id, short_name, full_name, address)
VALUES (1, 'гарант', 'ООО Гарант качества', 'Минск, ул. Тимирязева 121
');
INSERT INTO public.m_contractor (id, short_name, full_name, address)
VALUES (2, 'литана', 'Litana LLC', 'Минск, ул. Машиностроителей 29
');
INSERT INTO public.m_contractor (id, short_name, full_name, address)
VALUES (3, 'юнионгаз', 'ООО ЮнионГаз', 'Минск, ул. Одоевского 115А');
INSERT INTO public.m_contractor (id, short_name, full_name, address)
VALUES (4, 'магнус', 'Magnus Group LLC', 'Минск, пр-т Притыцкого 156');
INSERT INTO public.m_contractor (id, short_name, full_name, address)
VALUES (5, 'замок', 'ОДО Высокий Замок', 'Минск, ул. Домбровская 29');
INSERT INTO public.m_contractor (id, short_name, full_name, address)
VALUES (7, 'си-трейдинг', 'ООО Си-Трейдинг', 'Минск, ул. Лопатина 5');
INSERT INTO public.m_contractor (id, short_name, full_name, address)
VALUES (8, 'бпплюс', 'ООО БытСтройРемонт', 'Минск, Тимирязева 54');
INSERT INTO public.m_contractor (id, short_name, full_name, address)
VALUES (9, 'никма', 'ООО НикМаСтройСервис', 'Минск, ул. Казинца 64А');
INSERT INTO public.m_contractor (id, short_name, full_name, address)
VALUES (10, 'ослябя', 'ООО Ослябя', 'Минск, ул. Краснозвездная 18
');

INSERT INTO public.m_customers (id, company_name, address, manager, phone_number, short_name)
VALUES (1, 'ОДО Табак-Инвест', 'Минск, ул. Гусовского 22', 'Худяков Андрей', '+375296780837', 'табак');
INSERT INTO public.m_customers (id, company_name, address, manager, phone_number, short_name)
VALUES (2, 'ООО БелДжи', 'Борисовский р-н, Р-54, 35 км', 'Chen Bin', '+375294688779', 'белджи');
INSERT INTO public.m_customers (id, company_name, address, manager, phone_number, short_name)
VALUES (3, 'ООО ОМА', 'Минск, пер. Промышленный 12А', 'Теркин Василий', '+375447090949', 'ома');
INSERT INTO public.m_customers (id, company_name, address, manager, phone_number, short_name)
VALUES (4, 'ООО БелПромСтрой', 'Минск, ул. Липковская 9', 'Дедюля Дмитрий', '+375291237951', 'белпромстрой');
INSERT INTO public.m_customers (id, company_name, address, manager, phone_number, short_name)
VALUES (5, 'ИООО Сокол', 'Минск, пр-т Победителей 25', 'Ахмад ибн Шахид', '+375333221100', 'сокол');
INSERT INTO public.m_customers (id, company_name, address, manager, phone_number, short_name)
VALUES (6, 'ООО ВладПродИмпорт', 'Заславль, ул. Загородная 5', 'Вадим Анатольевич', '+375296332516', 'владпродимпорт');
INSERT INTO public.m_customers (id, company_name, address, manager, phone_number, short_name)
VALUES (7, 'ЗАО Рекомбел',
        'Минская обл., Смолевичский р-н, Смолевичский с/с, Китайско-Белорусский индустриальный парк "Великий камень"',
        'Дедушкин Владимир', '+375295519515', 'рекомбел');
INSERT INTO public.m_customers (id, company_name, address, manager, phone_number, short_name)
VALUES (8, 'ООО БизнесПатронатПлюс', 'Минск, ул. Машиностроителей 29', 'Сапраньков Владимир Анатольевич',
        '+375296331578', 'бизнеспатронатплюс');
INSERT INTO public.m_customers (id, company_name, address, manager, phone_number, short_name)
VALUES (9, 'ООО А-100 Девелоплмент', 'п. Боровая, ул. Леонардо да Винчи 5', 'Алешкин Алексей Алексеевич',
        '+375447445566', 'а-100');
INSERT INTO public.m_customers (id, company_name, address, manager, phone_number, short_name)
VALUES (10, 'ИООО Дана Холдингс', 'Минск, пр-т Независимости 128', 'Василий Васильевич Данов', '+375291251346', 'дана');
INSERT INTO public.m_customers (id, company_name, address, manager, phone_number, short_name)
VALUES (11, 'ООО Халекс', 'п. Дроздово 15', 'Андрей Михайлович', '+375296331564', 'халекс');
INSERT INTO public.m_customers (id, company_name, address, manager, phone_number, short_name)
VALUES (12, 'ООО Моторлэнд', 'д. Малиновка, ул. Центральная 16', 'Глазков Александр Петрович', '+375447461532',
        'моторлэнд');

INSERT INTO public.m_equipment_producers (id, name, post_address)
VALUES (1, 'Whiteman', 'Multiquip Inc.
Corporate Headquarters
6141 Katella Ave, Suite 200
Cypress, CA 90630');
INSERT INTO public.m_equipment_producers (id, name, post_address)
VALUES (2, 'Barikell', 'Barikell Srl
Via C. Razzaboni, 118, 41122 Modena MO');
INSERT INTO public.m_equipment_producers (id, name, post_address)
VALUES (3, 'Somero', 'SOMERO ENTERPRISES INC.
14530 Global Parkway,
Fort Myers, FL 33913');
INSERT INTO public.m_equipment_producers (id, name, post_address)
VALUES (4, 'MBW', '250 Hartford Road
PO Box 440
Slinger, WI 53086-0440
Phone: 800-678-5237
Fax: 262-644-5169');
INSERT INTO public.m_equipment_producers (id, name, post_address)
VALUES (5, 'Husquarna', 'Husqvarna UK Ltd
Preston Road
Aycliffe Industrial Park
Newton Aycliffe
County Durham
DL5 6UP');

INSERT INTO public.m_construction_site (id, full_name, short_name, customer_id, responsible_id, contractor_id,
                                        date_of_start, date_of_finish)
VALUES (1, 'Возведение склада по ул. Монтажников 19 в г. Минске', 'монтажников', 1, 1, 1, null, null);
INSERT INTO public.m_construction_site (id, full_name, short_name, customer_id, responsible_id, contractor_id,
                                        date_of_start, date_of_finish)
VALUES (2, 'Строительство торгового центра на пересечении ул. Косарева-Лазурная в г. Гомеле', 'ома гомель', 3, 4, 2,
        null, null);
INSERT INTO public.m_construction_site (id, full_name, short_name, customer_id, responsible_id, contractor_id,
                                        date_of_start, date_of_finish)
VALUES (3, 'Складской комплекс №5 с административно-бытовыми помещениями в районе д. Королев Стан, Минского района',
        'белпартальянс', 4, 3, 3, null, null);
INSERT INTO public.m_construction_site (id, full_name, short_name, customer_id, responsible_id, contractor_id,
                                        date_of_start, date_of_finish)
VALUES (4,
        'Строительство многофункционального комплекса в городе Минске по проспекту Победителей, включающего гостиницу, спортивный комплекс, сопутствующие объекты',
        'мариот', 5, 5, 4, null, null);
INSERT INTO public.m_construction_site (id, full_name, short_name, customer_id, responsible_id, contractor_id,
                                        date_of_start, date_of_finish)
VALUES (5,
        'Строительство склада на земельном участке площадью 4,6964га с кадастровым номером 6235010001002833, предоставленным для обслуживания зданий и сооружений производственной базы по адресу Минская область, Заславль, ул. Загородная 5',
        'заславль', 6, 2, 5, null, null);
INSERT INTO public.m_construction_site (id, full_name, short_name, customer_id, responsible_id, contractor_id,
                                        date_of_start, date_of_finish)
VALUES (6, 'Строительство завода по производству легковых автомобилей в районе д. Пересады, Борисовского района',
        'белджи', 2, 1, 6, null, null);
INSERT INTO public.m_construction_site (id, full_name, short_name, customer_id, responsible_id, contractor_id,
                                        date_of_start, date_of_finish)
VALUES (7,
        'Строительство завода по производству солнечных батарей общей емкостью 300 МВт в год в Китайско-Белорусском индустриальном парке',
        'рекомбел', 7, 3, 7, null, null);
INSERT INTO public.m_construction_site (id, full_name, short_name, customer_id, responsible_id, contractor_id,
                                        date_of_start, date_of_finish)
VALUES (8,
        'Реконструкция конюшни и телятника под объект торговли и общественного питания с сопутствующими помещениями общественного питания и обслуживающего назначения по адресу Минский район, Сенинский с/с, район аг. Сеница',
        'сеница', 8, 3, 8, null, null);
INSERT INTO public.m_construction_site (id, full_name, short_name, customer_id, responsible_id, contractor_id,
                                        date_of_start, date_of_finish)
VALUES (9,
        'Строительство жилого района с инженерно-транспортной инфраструктурой и объектами социально-гарантированного обслуживания населения в д. Боровая, д. Копище, Боровлянского с/с, Минского района, Минской области. Торговый центр.',
        'а-100', 9, 1, 9, null, null);
INSERT INTO public.m_construction_site (id, full_name, short_name, customer_id, responsible_id, contractor_id,
                                        date_of_start, date_of_finish)
VALUES (10, 'Многоуровневая парковка в районе пересечения улиц Городецкой, Ложинской', 'вивальди', 10, 3, 10, null,
        null);
INSERT INTO public.m_construction_site (id, full_name, short_name, customer_id, responsible_id, contractor_id,
                                        date_of_start, date_of_finish)
VALUES (11,
        'Строительство многофункционального логистического комплекса с помещениями сопутствующего сервиса, площадками открытого складирования и объектами транспортной и инженерной инфраструктуры на территории Минского района',
        'халекс', 11, 3, 3, null, null);
INSERT INTO public.m_construction_site (id, full_name, short_name, customer_id, responsible_id, contractor_id,
                                        date_of_start, date_of_finish)
VALUES (12,
        'Реконструкция здания телятника на 160 голов, здания телятника на 70 голов, здания зернохранилища, здания семенохранилища, арочника, здания навеса для сельскохозяйственных машин №1, производственной базы, рамы лесопильной, здания столярной мастерской под многофункциональный комплекс в районе д. Малиновка, Минского района',
        'моторленд', 12, 2, 1, null, null);

INSERT INTO public.m_equipment (id, store_number, model, producer_id)
VALUES (1, '5', 'MBW 36', 4);
INSERT INTO public.m_equipment (id, store_number, model, producer_id)
VALUES (2, '6', 'MBW 36', 4);
INSERT INTO public.m_equipment (id, store_number, model, producer_id)
VALUES (3, '24', 'MBW F2', 4);
INSERT INTO public.m_equipment (id, store_number, model, producer_id)
VALUES (4, '30', 'MK8-90', 2);
INSERT INTO public.m_equipment (id, store_number, model, producer_id)
VALUES (5, '41', 'MK8-90', 2);
INSERT INTO public.m_equipment (id, store_number, model, producer_id)
VALUES (6, '44', 'MBW 24/4', 4);
INSERT INTO public.m_equipment (id, store_number, model, producer_id)
VALUES (7, '57', 'MK8-90', 2);
INSERT INTO public.m_equipment (id, store_number, model, producer_id)
VALUES (8, '60', 'MBW 24/4', 4);
INSERT INTO public.m_equipment (id, store_number, model, producer_id)
VALUES (9, '73', 'CA 4HC/STHAC', 1);
INSERT INTO public.m_equipment (id, store_number, model, producer_id)
VALUES (10, '80', 'CA 4HC/STHAC', 1);
INSERT INTO public.m_equipment (id, store_number, model, producer_id)
VALUES (11, '81', 'JWN24HTCSL', 1);
INSERT INTO public.m_equipment (id, store_number, model, producer_id)
VALUES (12, '82', 'HHXG5', 1);
INSERT INTO public.m_equipment (id, store_number, model, producer_id)
VALUES (13, '91', 'Laser Screed S-840', 3);
INSERT INTO public.m_equipment (id, store_number, model, producer_id)
VALUES (14, '94', 'CA4HM', 1);
INSERT INTO public.m_equipment (id, store_number, model, producer_id)
VALUES (15, '97', 'MBW F24/4', 4);
INSERT INTO public.m_equipment (id, store_number, model, producer_id)
VALUES (16, '98', 'MBW F24/4', 4);
INSERT INTO public.m_equipment (id, store_number, model, producer_id)
VALUES (17, '100', 'HHNG5', 1);
INSERT INTO public.m_equipment (id, store_number, model, producer_id)
VALUES (18, '105', 'Floor 6', 2);
INSERT INTO public.m_equipment (id, store_number, model, producer_id)
VALUES (19, '70036', 'Soff-Cut 4000', 5);

