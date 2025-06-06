-- ===========================
-- Pacientes (n registros)
-- ===========================
INSERT INTO patients (id, resource) VALUES
('7d4e3b2a-1c0f-4a5b-9d8e-7f6c5b4a3d2e', '{
  "resourceType": "Patient",
  "id": "7d4e3b2a-1c0f-4a5b-9d8e-7f6c5b4a3d2e",
  "name": [{"use": "official", "family": "Hernández", "given": ["Carlos"]}],
  "gender": "male",
  "birthDate": "1980-05-15",
  "identifier": [{"system": "http://hospital.org/patient", "value": "80051523457"}]
}'::jsonb),
('a1b2c3d4-e5f6-47g8-9h0i-j1k2l3m4n5o6', '{
  "resourceType": "Patient",
  "id": "a1b2c3d4-e5f6-47g8-9h0i-j1k2l3m4n5o6",
  "name": [{"use": "official", "family": "Valdés", "given": ["Marta"]}],
  "gender": "female",
  "birthDate": "1995-12-03",
  "identifier": [{"system": "http://hospital.org/patient", "value": "95120387652"}]
}'::jsonb),
('p0q9r8s7-t6u5-v4w3-x2y1-z0a1b2c3d4e5', '{
  "resourceType": "Patient",
  "id": "p0q9r8s7-t6u5-v4w3-x2y1-z0a1b2c3d4e5",
  "name": [{"use": "official", "family": "González", "given": ["Lázaro"]}],
  "gender": "male",
  "birthDate": "1972-08-22",
  "identifier": [{"system": "http://hospital.org/patient", "value": "72082212341"}]
}'::jsonb),
('f5g6h7i8-j9k0-l1m2-n3o4-p5q6r7s8t9u0', '{
  "resourceType": "Patient",
  "id": "f5g6h7i8-j9k0-l1m2-n3o4-p5q6r7s8t9u0",
  "name": [{"use": "official", "family": "Pérez", "given": ["Yamila"]}],
  "gender": "female",
  "identifier": [{"system": "http://hospital.org/patient", "value": "00000000000"}]
}'::jsonb),
('v1w2x3y4-z5a6-b7c8-d9e0-f1g2h3i4j5k6', '{
  "resourceType": "Patient",
  "id": "v1w2x3y4-z5a6-b7c8-d9e0-f1g2h3i4j5k6",
  "name": [{"use": "official", "family": null, "given": ["Juan"]}],
  "gender": "unknown",
  "birthDate": "2005-03-10",
  "identifier": [{"system": "http://hospital.org/patient", "value": "05031098763"}]
}'::jsonb),
('d2f1a8e0-3b6c-4f9e-9a7c-5a3d2f1b6c4e', '{
  "resourceType": "Patient",
  "id": "d2f1a8e0-3b6c-4f9e-9a7c-5a3d2f1b6c4e",
  "name": [{"use": "official", "family": "Martínez", "given": ["José"]}],
  "gender": "male",
  "birthDate": "1975-03-12",
  "identifier": [{"system": "http://hospital.org/patient", "value": "75031212345"}]
}'::jsonb),
('a3b4c5d6-e7f8-4901-a2b3-c4d5e6f7a8b9', '{
  "resourceType": "Patient",
  "id": "a3b4c5d6-e7f8-4901-a2b3-c4d5e6f7a8b9",
  "name": [{"use": "official", "family": "Rodríguez", "given": ["Ana María"]}],
  "gender": "female",
  "birthDate": "1988-07-25",
  "identifier": [{"system": "http://hospital.org/patient", "value": "88072567890"}]
}'::jsonb),
('c1d2e3f4-a5b6-4708-9c0d-e1f2a3b4c5d6', '{
  "resourceType": "Patient",
  "id": "c1d2e3f4-a5b6-4708-9c0d-e1f2a3b4c5d6",
  "name": [{"use": "official", "family": "López", "given": ["Miguel"]}],
  "gender": "male",
  "birthDate": "1969-11-03",
  "identifier": [{"system": "http://hospital.org/patient", "value": "69110323456"}]
}'::jsonb),
('e7f8a9b0-c1d2-4e3f-8a9b-0c1d2e3f4a5b', '{
  "resourceType": "Patient",
  "id": "e7f8a9b0-c1d2-4e3f-8a9b-0c1d2e3f4a5b",
  "name": [{"use": "official", "family": "García", "given": ["Yamila"]}],
  "gender": "female",
  "birthDate": "1992-05-18",
  "identifier": [{"system": "http://hospital.org/patient", "value": "92051834567"}]
}'::jsonb),
('f0e1d2c3-b4a5-4768-9f0e-1d2c3b4a5f6e', '{
  "resourceType": "Patient",
  "id": "f0e1d2c3-b4a5-4768-9f0e-1d2c3b4a5f6e",
  "name": [{"use": "official", "family": null, "given": ["Luis"]}],
  "gender": "unknown",
  "birthDate": null,
  "identifier": [{"system": "http://hospital.org/patient", "value": "00000000000"}]
}'::jsonb),
('b1c2d3e4-f5a6-4789-8b0c-d1e2f3a4b5c6', '{
  "resourceType": "Patient",
  "id": "b1c2d3e4-f5a6-4789-8b0c-d1e2f3a4b5c6",
  "name": [{"use": "official", "family": "Fernández", "given": ["Carla"]}],
  "gender": "female",
  "birthDate": "1977-09-30",
  "identifier": [{"system": "http://hospital.org/patient", "value": "77093098765"}]
}'::jsonb),
('d4e5f6a7-b8c9-4d0e-9f1a-b2c3d4e5f6a7', '{
  "resourceType": "Patient",
  "id": "d4e5f6a7-b8c9-4d0e-9f1a-b2c3d4e5f6a7",
  "name": [{"use": "official", "family": "Sánchez", "given": ["Raúl"]}],
  "gender": "male",
  "birthDate": "1983-02-14",
  "identifier": [{"system": "http://hospital.org/patient", "value": "83021412347"}]
}'::jsonb),
('e8f9a0b1-c2d3-4e4f-8a9b-c0d1e2f3a4b5', '{
  "resourceType": "Patient",
  "id": "e8f9a0b1-c2d3-4e4f-8a9b-c0d1e2f3a4b5",
  "name": [{"use": "official", "family": "Vega", "given": ["María"]}],
  "gender": "female",
  "birthDate": "1990-12-01",
  "identifier": [{"system": "http://hospital.org/patient", "value": "90120187654"}]
}'::jsonb),
('f1a2b3c4-d5e6-4789-8a0b-c1d2e3f4a5b6', '{
  "resourceType": "Patient",
  "id": "f1a2b3c4-d5e6-4789-8a0b-c1d2e3f4a5b6",
  "name": [{"use": "official", "family": "Mora", "given": ["Javier"]}],
  "gender": "male",
  "birthDate": "1970-06-20",
  "identifier": [{"system": "http://hospital.org/patient", "value": "70062023456"}]
}'::jsonb),
('a9b8c7d6-e5f4-4a3b-9c0d-e1f2a3b4c5d6', '{
  "resourceType": "Patient",
  "id": "a9b8c7d6-e5f4-4a3b-9c0d-e1f2a3b4c5d6",
  "name": [{"use": "official", "family": "Rojas", "given": ["Isabel"]}],
  "gender": "female",
  "birthDate": "1985-10-10",
  "identifier": [{"system": "http://hospital.org/patient", "value": "85101034567"}]
}'::jsonb),
('11111111-aaaa-4bbb-8ccc-000000000001', '{
  "resourceType": "Patient",
  "id": "11111111-aaaa-4bbb-8ccc-000000000001",
  "name": [{"use": "official", "family": "García", "given": ["María"]}],
  "gender": "female",
  "birthDate": "1978-05-10",
  "identifier": [{"system": "http://hospital.org/patient", "value": "78051012348"}]
}'::jsonb),
('22222222-bbbb-4ccc-8ddd-000000000002', '{
  "resourceType": "Patient",
  "id": "22222222-bbbb-4ccc-8ddd-000000000002",
  "name": [{"use": "official", "family": "Rodríguez", "given": ["Carlos"]}],
  "gender": "male",
  "birthDate": "1985-11-23",
  "identifier": [{"system": "http://hospital.org/patient", "value": "85112356789"}]
}'::jsonb),
('33333333-cccc-4ddd-8eee-000000000003', '{
  "resourceType": "Patient",
  "id": "33333333-cccc-4ddd-8eee-000000000003",
  "name": [{"use": "official", "family": "Fernández", "given": ["Lucía"]}],
  "gender": "female",
  "birthDate": "1990-07-15",
  "identifier": [{"system": "http://hospital.org/patient", "value": "90071523456"}]
}'::jsonb),
('44444444-aaaa-4bbb-8ccc-000000000004', '{
  "resourceType": "Patient",
  "id": "44444444-aaaa-4bbb-8ccc-000000000004",
  "name": [{"use": "official", "family": "López", "given": ["Ana"]}],
  "gender": "female",
  "birthDate": "1970-04-20",
  "identifier": [{"system": "http://hospital.org/patient", "value": "70042012346"}]
}'::jsonb),
('55555555-bbbb-4ccc-8ddd-000000000005', '{
  "resourceType": "Patient",
  "id": "55555555-bbbb-4ccc-8ddd-000000000005",
  "name": [{"use": "official", "family": "Martínez", "given": ["José"]}],
  "gender": "male",
  "birthDate": "1983-08-15",
  "identifier": [{"system": "http://hospital.org/patient", "value": "83081523457"}]
}'::jsonb),
('66666666-cccc-4ddd-8eee-000000000006', '{
  "resourceType": "Patient",
  "id": "66666666-cccc-4ddd-8eee-000000000006",
  "name": [{"use": "official", "family": "Gómez", "given": ["María"]}],
  "gender": "female",
  "birthDate": "1992-12-10",
  "identifier": [{"system": "http://hospital.org/patient", "value": "92121034568"}]
}'::jsonb),
('77777777-dddd-4eee-8fff-000000000007', '{
  "resourceType": "Patient",
  "id": "77777777-dddd-4eee-8fff-000000000007",
  "name": [{"use": "official", "family": "Fernández", "given": ["Carlos"]}],
  "gender": "male",
  "birthDate": "1975-06-30",
  "identifier": [{"system": "http://hospital.org/patient", "value": "75063045679"}]
}'::jsonb),
('88888888-eeee-4fff-9000-000000000008', '{
  "resourceType": "Patient",
  "id": "88888888-eeee-4fff-9000-000000000008",
  "name": [{"use": "official", "family": "Sánchez", "given": ["Lucía"]}],
  "gender": "female",
  "birthDate": "1988-09-05",
  "identifier": [{"system": "http://hospital.org/patient", "value": "88090556780"}]
}'::jsonb),
('99999999-ffff-4000-9111-000000000009', '{
  "resourceType": "Patient",
  "id": "99999999-ffff-4000-9111-000000000009",
  "name": [{"use": "official", "family": "Ramírez", "given": ["Pedro"]}],
  "gender": "male",
  "birthDate": "1969-11-20",
  "identifier": [{"system": "http://hospital.org/patient", "value": "69112067891"}]
}'::jsonb),
('aaaaaaaa-0000-4111-9222-00000000000a', '{
  "resourceType": "Patient",
  "id": "aaaaaaaa-0000-4111-9222-00000000000a",
  "name": [{"use": "official", "family": "Torres", "given": ["Isabel"]}],
  "gender": "female",
  "birthDate": "1995-01-15",
  "identifier": [{"system": "http://hospital.org/patient", "value": "95011578902"}]
}'::jsonb),
('bbbbbbbb-1111-4222-9333-00000000000b', '{
  "resourceType": "Patient",
  "id": "bbbbbbbb-1111-4222-9333-00000000000b",
  "name": [{"use": "official", "family": "Vargas", "given": ["Jorge"]}],
  "gender": "male",
  "birthDate": "1982-03-25",
  "identifier": [{"system": "http://hospital.org/patient", "value": "82032589013"}]
}'::jsonb),
('cccccccc-2222-4333-9444-00000000000c', '{
  "resourceType": "Patient",
  "id": "cccccccc-2222-4333-9444-00000000000c",
  "name": [{"use": "official", "family": "Morales", "given": ["Sofía"]}],
  "gender": "female",
  "birthDate": "1978-07-18",
  "identifier": [{"system": "http://hospital.org/patient", "value": "78071890124"}]
}'::jsonb),
('dddddddd-3333-4444-9555-00000000000d', '{
  "resourceType": "Patient",
  "id": "dddddddd-3333-4444-9555-00000000000d",
  "name": [{"use": "official", "family": "Castillo", "given": ["Luis"]}],
  "gender": "male",
  "birthDate": "1990-10-02",
  "identifier": [{"system": "http://hospital.org/patient", "value": "90100201235"}]
}'::jsonb);
-- ===========================
-- Condiciones (n registros)
-- ===========================

INSERT INTO conditions (id, resource) VALUES
('1a2b3c4d-e5f6-4789-9abc-def012345678', '{
  "resourceType": "Condition",
  "code": {
    "coding": [{"system": "http://snomed.info/sct", "code": "38341003", "display": "Hipertensión esencial"}]
  },
  "subject": {"reference": "Patient/d2f1a8e0-3b6c-4f9e-9a7c-5a3d2f1b6c4e"}
}'::jsonb),
('b2c3d4e5-f6a7-4890-0bcd-ef123456789a', '{
  "resourceType": "Condition",
  "code": {
    "coding": [{"system": "http://snomed.info/sct", "code": "44054006", "display": "Diabetes mellitus tipo 2"}]
  },
  "subject": {"reference": "Patient/a3b4c5d6-e7f8-4901-a2b3-c4d5e6f7a8b9"}
}'::jsonb),
('c3d4e5f6-a7b8-4a90-1cde-f23456789abc', '{
  "resourceType": "Condition",
  "code": {
    "coding": [{"system": "http://snomed.info/sct", "code": "195967001", "display": "Asma persistente"}]
  },
  "subject": {"reference": "Patient/c1d2e3f4-a5b6-4708-9c0d-e1f2a3b4c5d6"}
}'::jsonb),
('d4e5f6a7-b8c9-4b01-2def-3456789abcd0', '{
  "resourceType": "Condition",
  "code": {
    "coding": [{"system": "http://snomed.info/sct", "code": "35489007", "display": "Artritis reumatoide"}]
  },
  "subject": {"reference": "Patient/e7f8a9b0-c1d2-4e3f-8a9b-0c1d2e3f4a5b"}
}'::jsonb),
('e5f6a7b8-c9d0-4c12-3efa-456789abcde1', '{
  "resourceType": "Condition",
  "code": {
    "coding": [{"system": "http://snomed.info/sct", "code": "386661006", "display": "Infección respiratoria aguda"}]
  },
  "subject": {"reference": "Patient/f0e1d2c3-b4a5-4768-9f0e-1d2c3b4a5f6e"}
}'::jsonb),
('f6a7b8c9-d0e1-4d23-4fab-56789abcdef2', '{
  "resourceType": "Condition",
  "code": {
    "coding": [{"system": "http://snomed.info/sct", "code": "38341003", "display": "Hipertensión esencial"}]
  },
  "subject": {"reference": "Patient/b1c2d3e4-f5a6-4789-8b0c-d1e2f3a4b5c6"}
}'::jsonb),
('a7b8c9d0-e1f2-4e34-5abc-6789abcdef03', '{
  "resourceType": "Condition",
  "code": {
    "coding": [{"system": "http://snomed.info/sct", "code": "44054006", "display": "Diabetes mellitus tipo 2"}]
  },
  "subject": {"reference": "Patient/d4e5f6a7-b8c9-4b01-2def-3456789abcd0"}
}'::jsonb),
('b8c9d0e1-f2a3-4f45-6bcd-789abcdef014', '{
  "resourceType": "Condition",
  "code": {
    "coding": [{"system": "http://snomed.info/sct", "code": "195967001", "display": "Asma persistente"}]
  },
  "subject": {"reference": "Patient/e8f9a0b1-c2d3-4e4f-8a9b-c0d1e2f3a4b5"}
}'::jsonb),
('c9d0e1f2-a3b4-5046-7cde-89abcdef025', '{
  "resourceType": "Condition",
  "code": {
    "coding": [{"system": "http://snomed.info/sct", "code": "35489007", "display": "Artritis reumatoide"}]
  },
  "subject": {"reference": "Patient/f1a2b3c4-d5e6-4789-8a0b-c1d2e3f4a5b6"}
}'::jsonb),
('d0e1f2a3-b4c5-6157-8def-9abcdef0367', '{
  "resourceType": "Condition",
  "code": {
    "coding": [{"system": "http://snomed.info/sct", "code": "386661006", "display": "Infección respiratoria aguda"}]
  },
  "subject": {"reference": "Patient/a9b8c7d6-e5f4-4a3b-9c0d-e1f2a3b4c5d6"}
}'::jsonb),
('cond-0001', '{
  "resourceType": "Condition",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "38341003", "display": "Hipertensión esencial"}]},
  "subject": {"reference": "Patient/11111111-aaaa-4bbb-8ccc-000000000001"}
}'::jsonb),
('cond-0002', '{
  "resourceType": "Condition",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "44054006", "display": "Diabetes mellitus tipo 2"}]},
  "subject": {"reference": "Patient/11111111-aaaa-4bbb-8ccc-000000000001"}
}'::jsonb),
('cond-0003', '{
  "resourceType": "Condition",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "195967001", "display": "Asma persistente"}]},
  "subject": {"reference": "Patient/22222222-bbbb-4ccc-8ddd-000000000002"}
}'::jsonb),
('cond-0004', '{
  "resourceType": "Condition",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "386661006", "display": "Infección respiratoria aguda"}]},
  "subject": {"reference": "Patient/33333333-cccc-4ddd-8eee-000000000003"}
}'::jsonb),
('cond-0011', '{
  "resourceType": "Condition",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "38341003", "display": "Hipertensión esencial"}]},
  "subject": {"reference": "Patient/44444444-aaaa-4bbb-8ccc-000000000004"}
}'::jsonb),
('cond-0012', '{
  "resourceType": "Condition",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "44054006", "display": "Diabetes mellitus tipo 2"}]},
  "subject": {"reference": "Patient/55555555-bbbb-4ccc-8ddd-000000000005"}
}'::jsonb),
('cond-0013', '{
  "resourceType": "Condition",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "195967001", "display": "Asma persistente"}]},
  "subject": {"reference": "Patient/66666666-cccc-4ddd-8eee-000000000006"}
}'::jsonb),
('cond-0014', '{
  "resourceType": "Condition",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "35489007", "display": "Artritis reumatoide"}]},
  "subject": {"reference": "Patient/77777777-dddd-4eee-8fff-000000000007"}
}'::jsonb),
('cond-0015', '{
  "resourceType": "Condition",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "386661006", "display": "Infección respiratoria aguda"}]},
  "subject": {"reference": "Patient/88888888-eeee-4fff-9000-000000000008"}
}'::jsonb),
('cond-0016', '{
  "resourceType": "Condition",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "38341003", "display": "Hipertensión esencial"}]},
  "subject": {"reference": "Patient/99999999-ffff-4000-9111-000000000009"}
}'::jsonb),
('cond-0017', '{
  "resourceType": "Condition",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "44054006", "display": "Diabetes mellitus tipo 2"}]},
  "subject": {"reference": "Patient/aaaaaaaa-0000-4111-9222-00000000000a"}
}'::jsonb),
('cond-0018', '{
  "resourceType": "Condition",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "195967001", "display": "Asma persistente"}]},
  "subject": {"reference": "Patient/bbbbbbbb-1111-4222-9333-00000000000b"}
}'::jsonb),
('cond-0019', '{
  "resourceType": "Condition",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "35489007", "display": "Artritis reumatoide"}]},
  "subject": {"reference": "Patient/cccccccc-2222-4333-9444-00000000000c"}
}'::jsonb),
('cond-0020', '{
  "resourceType": "Condition",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "386661006", "display": "Infección respiratoria aguda"}]},
  "subject": {"reference": "Patient/dddddddd-3333-4444-9555-00000000000d"}
}'::jsonb);

-- ===========================
-- Medicación (n registros)
-- ===========================
INSERT INTO medication_requests (id, resource) VALUES
('f1e2d3c4-b5a6-4789-9abc-def012345678', '{
  "resourceType": "MedicationRequest",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/Losartán"},
  "subject": {"reference": "Patient/d2f1a8e0-3b6c-4f9e-9a7c-5a3d2f1b6c4e"},
  "dosageInstruction": [{"text": "50 mg cada 24 horas"}]
}'::jsonb),
('e2f3g4h5-i6j7-4890-0bcd-ef123456789a', '{
  "resourceType": "MedicationRequest",
  "status": "completed",
  "intent": "order",
  "medication": {"reference": "Medication/Metformina"},
  "subject": {"reference": "Patient/a3b4c5d6-e7f8-4901-a2b3-c4d5e6f7a8b9"},
  "dosageInstruction": [{"text": "850 mg cada 12 horas con alimentos"}]
}'::jsonb),
('g3h4i5j6-k7l8-4a90-1cde-f23456789abc', '{
  "resourceType": "MedicationRequest",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/Salbutamol"},
  "subject": {"reference": "Patient/c1d2e3f4-a5b6-4708-9c0d-e1f2a3b4c5d6"},
  "dosageInstruction": [{"text": "2 inhalaciones cada 6 horas según necesidad"}]
}'::jsonb),
('h4i5j6k7-l8m9-4b01-2def-3456789abcd0', '{
  "resourceType": "MedicationRequest",
  "status": "stopped",
  "intent": "order",
  "medication": {"reference": "Medication/Paracetamol"},
  "subject": {"reference": "Patient/e7f8a9b0-c1d2-4e3f-8a9b-0c1d2e3f4a5b"},
  "dosageInstruction": [{"text": "500 mg cada 8 horas si hay fiebre"}]
}'::jsonb),
('i5j6k7l8-m9n0-4c12-3efa-456789abcde1', '{
  "resourceType": "MedicationRequest",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/Omeprazol"},
  "subject": {"reference": "Patient/f0e1d2c3-b4a5-4768-9f0e-1d2c3b4a5f6e"},
  "dosageInstruction": [{"text": "20 mg cada 24 horas antes del desayuno"}]
}'::jsonb),
('j6k7l8m9-n0o1-4d23-4fab-56789abcdef2', '{
  "resourceType": "MedicationRequest",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/Aspirina"},
  "subject": {"reference": "Patient/b1c2d3e4-f5a6-4789-8b0c-d1e2f3a4b5c6"},
  "dosageInstruction": [{"text": "100 mg una vez al día"}]
}'::jsonb),
('k7l8m9n0-o1p2-4e34-5abc-6789abcdef03', '{
  "resourceType": "MedicationRequest",
  "status": "completed",
  "intent": "order",
  "medication": {"reference": "Medication/Enalapril"},
  "subject": {"reference": "Patient/d4e5f6a7-b8c9-4b01-2def-3456789abcd0"},
  "dosageInstruction": [{"text": "10 mg cada 12 horas"}]
}'::jsonb),
('l8m9n0o1-p2q3-5046-7cde-89abcdef014', '{
  "resourceType": "MedicationRequest",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/Atorvastatina"},
  "subject": {"reference": "Patient/e8f9a0b1-c2d3-4e4f-8a9b-c0d1e2f3a4b5"},
  "dosageInstruction": [{"text": "20 mg cada 24 horas"}]
}'::jsonb),
('m9n0o1p2-q3r4-6157-8def-9abcdef0367', '{
  "resourceType": "MedicationRequest",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/Clortalidona"},
  "subject": {"reference": "Patient/a9b8c7d6-e5f4-4a3b-9c0d-e1f2a3b4c5d6"},
  "dosageInstruction": [{"text": "25 mg una vez al día"}]
}'::jsonb),
('med-0001', '{
  "resourceType": "MedicationRequest",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/Losartán"},
  "subject": {"reference": "Patient/11111111-aaaa-4bbb-8ccc-000000000001"},
  "dosageInstruction": [{"text": "50 mg cada 24 horas"}]
}'::jsonb),
('med-0002', '{
  "resourceType": "MedicationRequest",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/Metformina"},
  "subject": {"reference": "Patient/11111111-aaaa-4bbb-8ccc-000000000001"},
  "dosageInstruction": [{"text": "850 mg cada 12 horas con alimentos"}]
}'::jsonb),
('med-0003', '{
  "resourceType": "MedicationRequest",
  "status": "completed",
  "intent": "order",
  "medication": {"reference": "Medication/Salbutamol"},
  "subject": {"reference": "Patient/22222222-bbbb-4ccc-8ddd-000000000002"},
  "dosageInstruction": [{"text": "2 inhalaciones cada 6 horas según necesidad"}]
}'::jsonb),
('med-0004', '{
  "resourceType": "MedicationRequest",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/Paracetamol"},
  "subject": {"reference": "Patient/33333333-cccc-4ddd-8eee-000000000003"},
  "dosageInstruction": [{"text": "500 mg cada 8 horas si hay fiebre"}]
}'::jsonb),
('med-0011', '{
  "resourceType": "MedicationRequest",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/Losartán"},
  "subject": {"reference": "Patient/44444444-aaaa-4bbb-8ccc-000000000004"},
  "dosageInstruction": [{"text": "50 mg cada 24 horas"}]
}'::jsonb),
('med-0012', '{
  "resourceType": "MedicationRequest",
  "status": "completed",
  "intent": "order",
  "medication": {"reference": "Medication/Metformina"},
  "subject": {"reference": "Patient/55555555-bbbb-4ccc-8ddd-000000000005"},
  "dosageInstruction": [{"text": "850 mg cada 12 horas con alimentos"}]
}'::jsonb),
('med-0013', '{
  "resourceType": "MedicationRequest",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/Salbutamol"},
  "subject": {"reference": "Patient/66666666-cccc-4ddd-8eee-000000000006"},
  "dosageInstruction": [{"text": "2 inhalaciones cada 6 horas según necesidad"}]
}'::jsonb),
('med-0014', '{
  "resourceType": "MedicationRequest",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/Paracetamol"},
  "subject": {"reference": "Patient/77777777-dddd-4eee-8fff-000000000007"},
  "dosageInstruction": [{"text": "500 mg cada 8 horas si hay fiebre"}]
}'::jsonb),
('med-0015', '{
  "resourceType": "MedicationRequest",
  "status": "completed",
  "intent": "order",
  "medication": {"reference": "Medication/Omeprazol"},
  "subject": {"reference": "Patient/88888888-eeee-4fff-9000-000000000008"},
  "dosageInstruction": [{"text": "20 mg cada 24 horas antes del desayuno"}]
}'::jsonb),
('med-0016', '{
  "resourceType": "MedicationRequest",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/Aspirina"},
  "subject": {"reference": "Patient/99999999-ffff-4000-9111-000000000009"},
  "dosageInstruction": [{"text": "100 mg una vez al día"}]
}'::jsonb),
('med-0017', '{
  "resourceType": "MedicationRequest",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/Enalapril"},
  "subject": {"reference": "Patient/aaaaaaaa-0000-4111-9222-00000000000a"},
  "dosageInstruction": [{"text": "10 mg cada 12 horas"}]
}'::jsonb),
('med-0018', '{
  "resourceType": "MedicationRequest",
  "status": "completed",
  "intent": "order",
  "medication": {"reference": "Medication/Atorvastatina"},
  "subject": {"reference": "Patient/bbbbbbbb-1111-4222-9333-00000000000b"},
  "dosageInstruction": [{"text": "20 mg cada 24 horas"}]
}'::jsonb),
('med-0019', '{
  "resourceType": "MedicationRequest",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/Clortalidona"},
  "subject": {"reference": "Patient/cccccccc-2222-4333-9444-00000000000c"},
  "dosageInstruction": [{"text": "25 mg una vez al día"}]
}'::jsonb),
('med-0020', '{
  "resourceType": "MedicationRequest",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/Losartán"},
  "subject": {"reference": "Patient/dddddddd-3333-4444-9555-00000000000d"},
  "dosageInstruction": [{"text": "50 mg cada 24 horas"}]
}'::jsonb);

-- ===========================
-- Alergias (n registros)
-- ===========================
INSERT INTO allergy_intolerances (id, resource) VALUES
('q1w2e3r4-t5y6u7i8o9-p0a1s2d3f4g5h6j7', '{
  "resourceType": "AllergyIntolerance",
  "code": {
    "coding": [{"system": "http://snomed.info/sct", "code": "293962007", "display": "Alergia a penicilina"}]
  },
  "patient": {"reference": "Patient/7d4e3b2a-1c0f-4a5b-9d8e-7f6c5b4a3d2e"}
}'::jsonb),
('k8l7j6h5-g4f3d2s1a0-z9x8c7v6b5n4m3q2', '{
  "resourceType": "AllergyIntolerance",
  "code": {
    "coding": [{"system": "http://snomed.info/sct", "code": "300916003", "display": "Alergia a mariscos"}]
  },
  "patient": {"reference": "Patient/a1b2c3d4-e5f6-47g8-9h0i-j1k2l3m4n5o6"}
}'::jsonb),
('w1e2r3t4-y5u6i7o8p9-a0s1d2f3g4h5j6k7', '{
  "resourceType": "AllergyIntolerance",
  "code": {
    "coding": [{"system": "http://snomed.info/sct", "code": "256259004", "display": "Alergia a ácaros del polvo"}]
  },
  "patient": {"reference": "Patient/p0q9r8s7-t6u5-v4w3-x2y1-z0a1b2c3d4e5"}
}'::jsonb),
('z1x2c3v4-b5n6m7q8w9-e0r1t2y3u4i5o6p7', '{
  "resourceType": "AllergyIntolerance",
  "code": {
    "coding": [{"system": "http://snomed.info/sct", "code": "419511007", "display": "Alergia a látex"}]
  },
  "patient": {"reference": "Patient/v1w2x3y4-z5a6-b7c8-d9e0-f1g2h3i4j5k6"}
}'::jsonb),
('l0k9j8h7-g6f5d4s3a2-q1w2e3r4t5y6u7i8', '{
  "resourceType": "AllergyIntolerance",
  "code": {
    "coding": [{"system": "http://snomed.info/sct", "code": "294638003", "display": "Alergia a huevo"}]
  },
  "patient": {"reference": "Patient/f5g6h7i8-j9k0-l1m2-n3o4-p5q6r7s8t9u0"}
}'::jsonb),
('n1m2b3v4-c5x6z7a8-q9w0e1r2t3y4u5i6', '{
  "resourceType": "AllergyIntolerance",
  "code": {
    "coding": [{"system": "http://snomed.info/sct", "code": "293962007", "display": "Alergia a penicilina"}]
  },
  "patient": {"reference": "Patient/d2f1a8e0-3b6c-4f9e-9a7c-5a3d2f1b6c4e"}
}'::jsonb),
('o2p3q4r5-s6t7u8v9-w0x1y2z3a4b5c6d7', '{
  "resourceType": "AllergyIntolerance",
  "code": {
    "coding": [{"system": "http://snomed.info/sct", "code": "300916003", "display": "Alergia a mariscos"}]
  },
  "patient": {"reference": "Patient/a3b4c5d6-e7f8-4901-a2b3-c4d5e6f7a8b9"}
}'::jsonb),
('p3q4r5s6-t7u8v9w0-x1y2z3a4b5c6d7e8', '{
  "resourceType": "AllergyIntolerance",
  "code": {
    "coding": [{"system": "http://snomed.info/sct", "code": "256259004", "display": "Alergia a ácaros del polvo"}]
  },
  "patient": {"reference": "Patient/c1d2e3f4-a5b6-4708-9c0d-e1f2a3b4c5d6"}
}'::jsonb),
('q4r5s6t7-u8v9w0x1-y2z3a4b5c6d7e8f9', '{
  "resourceType": "AllergyIntolerance",
  "code": {
    "coding": [{"system": "http://snomed.info/sct", "code": "419511007", "display": "Alergia a látex"}]
  },
  "patient": {"reference": "Patient/e7f8a9b0-c1d2-4e3f-8a9b-0c1d2e3f4a5b"}
}'::jsonb),
('r5s6t7u8-v9w0x1y2-z3a4b5c6d7e8f901', '{
  "resourceType": "AllergyIntolerance",
  "code": {
    "coding": [{"system": "http://snomed.info/sct", "code": "294638003", "display": "Alergia a huevo"}]
  },
  "patient": {"reference": "Patient/f0e1d2c3-b4a5-4768-9f0e-1d2c3b4a5f6e"}
}'::jsonb),
('allergy-0001', '{
  "resourceType": "AllergyIntolerance",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "293962007", "display": "Alergia a penicilina"}]},
  "patient": {"reference": "Patient/11111111-aaaa-4bbb-8ccc-000000000001"}
}'::jsonb),
('allergy-0002', '{
  "resourceType": "AllergyIntolerance",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "300916003", "display": "Alergia a mariscos"}]},
  "patient": {"reference": "Patient/11111111-aaaa-4bbb-8ccc-000000000001"}
}'::jsonb),
('allergy-0003', '{
  "resourceType": "AllergyIntolerance",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "256259004", "display": "Alergia a ácaros del polvo"}]},
  "patient": {"reference": "Patient/22222222-bbbb-4ccc-8ddd-000000000002"}
}'::jsonb),
('allergy-0004', '{
  "resourceType": "AllergyIntolerance",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "419511007", "display": "Alergia a látex"}]},
  "patient": {"reference": "Patient/33333333-cccc-4ddd-8eee-000000000003"}
}'::jsonb),
('allergy-0011', '{
  "resourceType": "AllergyIntolerance",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "293962007", "display": "Alergia a penicilina"}]},
  "patient": {"reference": "Patient/44444444-aaaa-4bbb-8ccc-000000000004"}
}'::jsonb),
('allergy-0012', '{
  "resourceType": "AllergyIntolerance",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "300916003", "display": "Alergia a mariscos"}]},
  "patient": {"reference": "Patient/55555555-bbbb-4ccc-8ddd-000000000005"}
}'::jsonb),
('allergy-0013', '{
  "resourceType": "AllergyIntolerance",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "256259004", "display": "Alergia a ácaros del polvo"}]},
  "patient": {"reference": "Patient/66666666-cccc-4ddd-8eee-000000000006"}
}'::jsonb),
('allergy-0014', '{
  "resourceType": "AllergyIntolerance",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "419511007", "display": "Alergia a látex"}]},
  "patient": {"reference": "Patient/77777777-dddd-4eee-8fff-000000000007"}
}'::jsonb),
('allergy-0015', '{
  "resourceType": "AllergyIntolerance",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "294638003", "display": "Alergia a huevo"}]},
  "patient": {"reference": "Patient/88888888-eeee-4fff-9000-000000000008"}
}'::jsonb),
('allergy-0016', '{
  "resourceType": "AllergyIntolerance",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "293962007", "display": "Alergia a penicilina"}]},
  "patient": {"reference": "Patient/99999999-ffff-4000-9111-000000000009"}
}'::jsonb),
('allergy-0017', '{
  "resourceType": "AllergyIntolerance",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "300916003", "display": "Alergia a mariscos"}]},
  "patient": {"reference": "Patient/aaaaaaaa-0000-4111-9222-00000000000a"}
}'::jsonb),
('allergy-0018', '{
  "resourceType": "AllergyIntolerance",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "256259004", "display": "Alergia a ácaros del polvo"}]},
  "patient": {"reference": "Patient/bbbbbbbb-1111-4222-9333-00000000000b"}
}'::jsonb),
('allergy-0019', '{
  "resourceType": "AllergyIntolerance",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "419511007", "display": "Alergia a látex"}]},
  "patient": {"reference": "Patient/cccccccc-2222-4333-9444-00000000000c"}
}'::jsonb),
('allergy-0020', '{
  "resourceType": "AllergyIntolerance",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "294638003", "display": "Alergia a huevo"}]},
  "patient": {"reference": "Patient/dddddddd-3333-4444-9555-00000000000d"}
}'::jsonb);
