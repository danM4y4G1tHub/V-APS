INSERT INTO patients (id, resource) VALUES
('7e1b2c3d-4f5a-6b7c-8d9e-0f1a2b3c4d5e', '{
  "resourceType": "Patient",
  "id": "7e1b2c3d-4f5a-6b7c-8d9e-0f1a2b3c4d5e",
  "name": [{"use": "official", "family": "Cruz", "given": ["Marta"]}],
  "gender": "female",
  "birthDate": "1965-10-12",
  "telecom": [{"system": "phone", "value": "+53 55512345", "use": "home"}],
  "address": [{"line": ["Calle 12 #45"], "city": "La Habana", "country": "Cuba"}],
  "maritalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-MaritalStatus", "code": "M", "display": "Married"}]}
}'::jsonb),
('8f2c3d4e-5a6b-7c8d-9e0f-1a2b3c4d5e6f', '{
  "resourceType": "Patient",
  "id": "8f2c3d4e-5a6b-7c8d-9e0f-1a2b3c4d5e6f",
  "name": [{"use": "official", "family": "García", "given": ["Luis"]}],
  "gender": "male",
  "birthDate": "1978-03-25",
  "telecom": [{"system": "phone", "value": "+53 55523456", "use": "mobile"}],
  "address": [{"line": ["Calle Martí #101"], "city": "Santiago de Cuba", "country": "Cuba"}],
  "maritalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-MaritalStatus", "code": "S", "display": "Single"}]}
}'::jsonb),
('9a3d4e5f-6b7c-8d9e-0f1a-2b3c4d5e6f7a', '{
  "resourceType": "Patient",
  "id": "9a3d4e5f-6b7c-8d9e-0f1a-2b3c4d5e6f7a",
  "name": [{"use": "official", "family": "Pérez", "given": ["Juan"]}],
  "gender": "male",
  "birthDate": "1985-07-19",
  "telecom": [{"system": "phone", "value": "+53 55534567", "use": "mobile"}],
  "address": [{"line": ["Calle 23 #87"], "city": "Camagüey", "country": "Cuba"}],
  "maritalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-MaritalStatus", "code": "D", "display": "Divorced"}]}
}'::jsonb),
('a4e5f6b7-c8d9-e0f1-a2b3-c4d5e6f7a8b9', '{
  "resourceType": "Patient",
  "id": "a4e5f6b7-c8d9-e0f1-a2b3-c4d5e6f7a8b9",
  "name": [{"use": "official", "family": "Rodríguez", "given": ["Ana"]}],
  "gender": "female",
  "birthDate": "1990-02-28",
  "telecom": [{"system": "phone", "value": "+53 55545678", "use": "home"}],
  "address": [{"line": ["Avenida 5ta #300"], "city": "Holguín", "country": "Cuba"}],
  "maritalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-MaritalStatus", "code": "W", "display": "Widowed"}]}
}'::jsonb),
('b5f6a7c8-d9e0-f1a2-b3c4-d5e6f7a8b9c0', '{
  "resourceType": "Patient",
  "id": "b5f6a7c8-d9e0-f1a2-b3c4-d5e6f7a8b9c0",
  "name": [{"use": "official", "family": "López", "given": ["Carlos"]}],
  "gender": "male",
  "birthDate": "2000-12-01",
  "telecom": [{"system": "phone", "value": "+53 55556789", "use": "mobile"}],
  "address": [{"line": ["Calle Real #15"], "city": "Santa Clara", "country": "Cuba"}],
  "maritalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-MaritalStatus", "code": "S", "display": "Single"}]}
}'::jsonb);

--Allergy Intolerances
INSERT INTO allergy_intolerances (id, resource) VALUES
('c6d7e8f9-0a1b-2c3d-4e5f-6a7b8c9d0e1f', '{
  "resourceType": "AllergyIntolerance",
  "id": "c6d7e8f9-0a1b-2c3d-4e5f-6a7b8c9d0e1f",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "91936005", "display": "Alergia a polvo"}]},
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "patient": {"reference": "Patient/7e1b2c3d-4f5a-6b7c-8d9e-0f1a2b3c4d5e"},
  "reaction": [{"manifestation": [{"coding": [{"system": "http://snomed.info/sct", "code": "271807003", "display": "Estornudos"}]}]}]
}'::jsonb),
('d7e8f9a0-1b2c-3d4e-5f6a-7b8c9d0e1f2a', '{
  "resourceType": "AllergyIntolerance",
  "id": "d7e8f9a0-1b2c-3d4e-5f6a-7b8c9d0e1f2a",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "91930004", "display": "Alergia a mariscos"}]},
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "patient": {"reference": "Patient/8f2c3d4e-5a6b-7c8d-9e0f-1a2b3c4d5e6f"},
  "reaction": [{"manifestation": [{"coding": [{"system": "http://snomed.info/sct", "code": "39579001", "display": "Urticaria"}]}]}]
}'::jsonb),
('e8f9a0b1-2c3d-4e5f-6a7b-8c9d0e1f2a3b', '{
  "resourceType": "AllergyIntolerance",
  "id": "e8f9a0b1-2c3d-4e5f-6a7b-8c9d0e1f2a3b",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "91935003", "display": "Alergia a penicilina"}]},
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "patient": {"reference": "Patient/9a3d4e5f-6b7c-8d9e-0f1a-2b3c4d5e6f7a"},
  "reaction": [{"manifestation": [{"coding": [{"system": "http://snomed.info/sct", "code": "247472004", "display": "Rash"}]}]}]
}'::jsonb),
('f9a0b1c2-3d4e-5f6a-7b8c-9d0e1f2a3b4c', '{
  "resourceType": "AllergyIntolerance",
  "id": "f9a0b1c2-3d4e-5f6a-7b8c-9d0e1f2a3b4c",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "91934002", "display": "Alergia a látex"}]},
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "patient": {"reference": "Patient/a4e5f6b7-c8d9-e0f1-a2b3-c4d5e6f7a8b9"},
  "reaction": [{"manifestation": [{"coding": [{"system": "http://snomed.info/sct", "code": "271807003", "display": "Estornudos"}]}]}]
}'::jsonb),
('0a1b2c3d-4e5f-6a7b-8c9d-0e1f2a3b4c5d', '{
  "resourceType": "AllergyIntolerance",
  "id": "0a1b2c3d-4e5f-6a7b-8c9d-0e1f2a3b4c5d",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "91932000", "display": "Alergia a huevo"}]},
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "patient": {"reference": "Patient/b5f6a7c8-d9e0-f1a2-b3c4-d5e6f7a8b9c0"},
  "reaction": [{"manifestation": [{"coding": [{"system": "http://snomed.info/sct", "code": "247472004", "display": "Rash"}]}]}]
}'::jsonb);

--Medication Request
INSERT INTO medication_requests (id, resource) VALUES
('1b2c3d4e-5f6a-7b8c-9d0e-1f2a3b4c5d6e', '{
  "resourceType": "MedicationRequest",
  "id": "1b2c3d4e-5f6a-7b8c-9d0e-1f2a3b4c5d6e",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/Losartan"},
  "subject": {"reference": "Patient/7e1b2c3d-4f5a-6b7c-8d9e-0f1a2b3c4d5e"},
  "dosageInstruction": [{"text": "50 mg cada 24 horas"}],
  "reasonCode": [{"coding": [{"system": "http://snomed.info/sct", "code": "38341003", "display": "Hipertensión esencial"}]}]
}'::jsonb),
('2c3d4e5f-6a7b-8c9d-0e1f-2a3b4c5d6e7f', '{
  "resourceType": "MedicationRequest",
  "id": "2c3d4e5f-6a7b-8c9d-0e1f-2a3b4c5d6e7f",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/Metformin"},
  "subject": {"reference": "Patient/8f2c3d4e-5a6b-7c8d-9e0f-1a2b3c4d5e6f"},
  "dosageInstruction": [{"text": "850 mg cada 12 horas"}],
  "reasonCode": [{"coding": [{"system": "http://snomed.info/sct", "code": "44054006", "display": "Diabetes tipo 2"}]}]
}'::jsonb),
('3d4e5f6a-7b8c-9d0e-1f2a-3b4c5d6e7f8a', '{
  "resourceType": "MedicationRequest",
  "id": "3d4e5f6a-7b8c-9d0e-1f2a-3b4c5d6e7f8a",
  "status": "completed",
  "intent": "order",
  "medication": {"reference": "Medication/Salbutamol"},
  "subject": {"reference": "Patient/9a3d4e5f-6b7c-8d9e-0f1a-2b3c4d5e6f7a"},
  "dosageInstruction": [{"text": "2 inhalaciones cada 6 horas"}],
  "reasonCode": [{"coding": [{"system": "http://snomed.info/sct", "code": "195967001", "display": "Asma persistente"}]}]
}'::jsonb),
('4e5f6a7b-8c9d-0e1f-2a3b-4c5d6e7f8a9b', '{
  "resourceType": "MedicationRequest",
  "id": "4e5f6a7b-8c9d-0e1f-2a3b-4c5d6e7f8a9b",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/Paracetamol"},
  "subject": {"reference": "Patient/a4e5f6b7-c8d9-e0f1-a2b3-c4d5e6f7a8b9"},
  "dosageInstruction": [{"text": "500 mg cada 8 horas si fiebre"}],
  "reasonCode": [{"coding": [{"system": "http://snomed.info/sct", "code": "386661006", "display": "Infección respiratoria aguda"}]}]
}'::jsonb),
('5f6a7b8c-9d0e-1f2a-3b4c-5d6e7f8a9b0c', '{
  "resourceType": "MedicationRequest",
  "id": "5f6a7b8c-9d0e-1f2a-3b4c-5d6e7f8a9b0c",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/Omeprazol"},
  "subject": {"reference": "Patient/b5f6a7c8-d9e0-f1a2-b3c4-d5e6f7a8b9c0"},
  "dosageInstruction": [{"text": "20 mg cada 24 horas antes del desayuno"}],
  "reasonCode": [{"coding": [{"system": "http://snomed.info/sct", "code": "44054006", "display": "Gastritis"}]}]
}'::jsonb);

INSERT INTO conditions (id, resource) VALUES
('6a7b8c9d-0e1f-2a3b-4c5d-6e7f8a9b0c1d', '{
  "resourceType": "Condition",
  "id": "6a7b8c9d-0e1f-2a3b-4c5d-6e7f8a9b0c1d",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/condition-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "38341003", "display": "Hipertensión esencial"}]},
  "subject": {"reference": "Patient/7e1b2c3d-4f5a-6b7c-8d9e-0f1a2b3c4d5e"},
  "recordedDate": "2024-06-01T12:00:00"
}'::jsonb),
('7b8c9d0e-1f2a-3b4c-5d6e-7f8a9b0c1d2e', '{
  "resourceType": "Condition",
  "id": "7b8c9d0e-1f2a-3b4c-5d6e-7f8a9b0c1d2e",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/condition-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "44054006", "display": "Diabetes mellitus tipo 2"}]},
  "subject": {"reference": "Patient/8f2c3d4e-5a6b-7c8d-9e0f-1a2b3c4d5e6f"},
  "recordedDate": "2023-12-15T09:00:00"
}'::jsonb),
('8c9d0e1f-2a3b-4c5d-6e7f-8a9b0c1d2e3f', '{
  "resourceType": "Condition",
  "id": "8c9d0e1f-2a3b-4c5d-6e7f-8a9b0c1d2e3f",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/condition-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "195967001", "display": "Asma persistente"}]},
  "subject": {"reference": "Patient/9a3d4e5f-6b7c-8d9e-0f1a-2b3c4d5e6f7a"},
  "recordedDate": "2024-04-20T16:30:00"
}'::jsonb),
('9d0e1f2a-3b4c-5d6e-7f8a-9b0c1d2e3f4a', '{
  "resourceType": "Condition",
  "id": "9d0e1f2a-3b4c-5d6e-7f8a-9b0c1d2e3f4a",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/condition-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "386661006", "display": "Infección respiratoria aguda"}]},
  "subject": {"reference": "Patient/a4e5f6b7-c8d9-e0f1-a2b3-c4d5e6f7a8b9"},
  "recordedDate": "2025-01-10T11:15:00"
}'::jsonb),
('0e1f2a3b-4c5d-6e7f-8a9b-0c1d2e3f4a5b', '{
  "resourceType": "Condition",
  "id": "0e1f2a3b-4c5d-6e7f-8a9b-0c1d2e3f4a5b",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/condition-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "29427007", "display": "Alergia a penicilina"}]},
  "subject": {"reference": "Patient/b5f6a7c8-d9e0-f1a2-b3c4-d5e6f7a8b9c0"},
  "recordedDate": "2023-10-05T08:00:00"
}'::jsonb);

INSERT INTO encounters (id, resource) VALUES
('1f2a3b4c-5d6e-7f8a-9b0c-1d2e3f4a5b6c', '{
  "resourceType": "Encounter",
  "id": "1f2a3b4c-5d6e-7f8a-9b0c-1d2e3f4a5b6c",
  "status": "in-progress",
  "classfhir": {"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "EMER", "display": "Emergency"},
  "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "EMER", "display": "Emergency"}]}],
  "subject": {"reference": "Patient/7e1b2c3d-4f5a-6b7c-8d9e-0f1a2b3c4d5e"},
  "period": {"start": "2025-06-01T09:30:00Z"},
  "participant": [{"individual": {"reference": "Practitioner/5d9e0f1a-7b8c-4d9e-0f1a-3c4d5e6f7a8b"}}],
  "reasonCode": [{"text": "Dolor torácico"}]
}'::jsonb),
('2a3b4c5d-6e7f-8a9b-0c1d-2e3f4a5b6c7d', '{
  "resourceType": "Encounter",
  "id": "2a3b4c5d-6e7f-8a9b-0c1d-2e3f4a5b6c7d",
  "status": "finished",
  "classfhir": {"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "AMB", "display": "Ambulatory"},
  "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "AMB", "display": "Ambulatory"}]}],
  "subject": {"reference": "Patient/8f2c3d4e-5a6b-7c8d-9e0f-1a2b3c4d5e6f"},
  "period": {"start": "2025-05-20T14:00:00Z", "end": "2025-05-20T15:00:00Z"},
  "participant": [{"individual": {"reference": "Practitioner/6e0f1a2b-8c9d-4e0f-1a2b-4d5e6f7a8b9c"}}],
  "reasonCode": [{"text": "Control de diabetes"}]
}'::jsonb),
('3b4c5d6e-7f8a-9b0c-1d2e-3f4a5b6c7d8e', '{
  "resourceType": "Encounter",
  "id": "3b4c5d6e-7f8a-9b0c-1d2e-3f4a5b6c7d8e",
  "status": "in-progress",
  "classfhir": {"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "EMER", "display": "Emergency"},
  "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "EMER", "display": "Emergency"}]}],
  "subject": {"reference": "Patient/9a3d4e5f-6b7c-8d9e-0f1a-2b3c4d5e6f7a"},
  "period": {"start": "2025-06-01T10:15:00Z"},
  "participant": [{"individual": {"reference": "Practitioner/7f1a2b3c-9d0e-4f1a-2b3c-5e6f7a8b9c0d"}}],
  "reasonCode": [{"text": "Dificultad respiratoria"}]
}'::jsonb),
('4c5d6e7f-8a9b-0c1d-2e3f-4a5b6c7d8e9f', '{
  "resourceType": "Encounter",
  "id": "4c5d6e7f-8a9b-0c1d-2e3f-4a5b6c7d8e9f",
  "status": "finished",
  "classfhir": {"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "AMB", "display": "Ambulatory"},
  "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "AMB", "display": "Ambulatory"}]}],
  "subject": {"reference": "Patient/a4e5f6b7-c8d9-e0f1-a2b3-c4d5e6f7a8b9"},
  "period": {"start": "2025-05-25T09:00:00Z", "end": "2025-05-25T09:30:00Z"},
  "participant": [{"individual": {"reference": "Practitioner/8a2b3c4d-0e1f-4a2b-3c4d-6f7a8b9c0d1e"}}],
  "reasonCode": [{"text": "Chequeo general"}]
}'::jsonb),
('5d6e7f8a-9b0c-1d2e-3f4a-5b6c7d8e9f0a', '{
  "resourceType": "Encounter",
  "id": "5d6e7f8a-9b0c-1d2e-3f4a-5b6c7d8e9f0a",
  "status": "in-progress",
  "classfhir": {"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "EMER", "display": "Emergency"},
  "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "EMER", "display": "Emergency"}]}],
  "subject": {"reference": "Patient/b5f6a7c8-d9e0-f1a2-b3c4-d5e6f7a8b9c0"},
  "period": {"start": "2025-06-01T11:00:00Z"},
  "participant": [{"individual": {"reference": "Practitioner/9b3c4d5e-1f2a-4b3c-4d5e-7a8b9c0d1e2f"}}],
  "reasonCode": [{"text": "Fiebre alta"}]
}'::jsonb);

INSERT INTO practitioners (id, resource) VALUES
('e1f2a3b4-c5d6-7890-1abc-def234567890', '{
  "resourceType": "Practitioner",
  "id": "e1f2a3b4-c5d6-7890-1abc-def234567890",
  "name": [{"family": "Castillo", "given": ["Roberto"]}],
  "identifier": [{"system": "http://hospital.org/practitioner", "value": "PRAC001"}],
  "qualification": [{"code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7","code": "MD","display": "Doctor en Medicina"}]}}]
}'::jsonb),
('f2a3b4c5-d6e7-8901-2bcd-ef3456789012', '{
  "resourceType": "Practitioner",
  "id": "f2a3b4c5-d6e7-8901-2bcd-ef3456789012",
  "name": [{"family": "Santos", "given": ["María"]}],
  "identifier": [{"system": "http://hospital.org/practitioner", "value": "PRAC002"}],
  "qualification": [{"code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7","code": "RN","display": "Enfermera registrada"}]}}]
}'::jsonb),
('a3b4c5d6-e7f8-9012-3cde-f45678901234', '{
  "resourceType": "Practitioner",
  "id": "a3b4c5d6-e7f8-9012-3cde-f45678901234",
  "name": [{"family": "Pérez", "given": ["Yanelis"]}],
  "identifier": [{"system": "http://hospital.org/practitioner", "value": "PRAC003"}],
  "qualification": [{"code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7","code": "MD","display": "Doctor en Medicina"}]}}]
}'::jsonb),
('b4c5d6e7-f890-1234-4def-567890123456', '{
  "resourceType": "Practitioner",
  "id": "b4c5d6e7-f890-1234-4def-567890123456",
  "name": [{"family": "Gómez", "given": ["Raúl"]}],
  "identifier": [{"system": "http://hospital.org/practitioner", "value": "PRAC004"}],
  "qualification": [{"code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7","code": "PA","display": "Asistente médico"}]}}]
}'::jsonb),
('c5d6e7f8-9012-3456-5ef0-678901234567', '{
  "resourceType": "Practitioner",
  "id": "c5d6e7f8-9012-3456-5ef0-678901234567",
  "name": [{"family": "Martínez", "given": ["Isabel"]}],
  "identifier": [{"system": "http://hospital.org/practitioner", "value": "PRAC005"}],
  "qualification": [{"code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7","code": "MD","display": "Doctor en Medicina"}]}}]
}'::jsonb);

INSERT INTO related_persons (id, resource) VALUES
('d6e7f890-1234-5678-6f01-789012345678', '{
  "resourceType": "RelatedPerson",
  "id": "d6e7f890-1234-5678-6f01-789012345678",
  "name": [{"family": "Cruz", "given": ["Pedro"]}],
  "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "code": "SPS", "display": "Spouse"}]}],
  "telecom": [{"system": "phone", "value": "+53 55512346", "use": "home"}],
  "patient": {"reference": "Patient/7e1b2c3d-4f5a-6b7c-8d9e-0f1a2b3c4d5e"}
}'::jsonb),
('e7f89012-3456-7890-7f12-890123456789', '{
  "resourceType": "RelatedPerson",
  "id": "e7f89012-3456-7890-7f12-890123456789",
  "name": [{"family": "García", "given": ["Carmen"]}],
  "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "code": "MTH", "display": "Mother"}]}],
  "telecom": [{"system": "phone", "value": "+53 55523457", "use": "mobile"}],
  "patient": {"reference": "Patient/8f2c3d4e-5a6b-7c8d-9e0f-1a2b3c4d5e6f"}
}'::jsonb),
('f8901234-5678-9012-8f23-901234567890', '{
  "resourceType": "RelatedPerson",
  "id": "f8901234-5678-9012-8f23-901234567890",
  "name": [{"family": "Pérez", "given": ["Alberto"]}],
  "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "code": "BRO", "display": "Brother"}]}],
  "telecom": [{"system": "phone", "value": "+53 55534568", "use": "mobile"}],
  "patient": {"reference": "Patient/9a3d4e5f-6b7c-8d9e-0f1a-2b3c4d5e6f7a"}
}'::jsonb),
('89012345-6789-0123-9f34-012345678901', '{
  "resourceType": "RelatedPerson",
  "id": "89012345-6789-0123-9f34-012345678901",
  "name": [{"family": "Rodríguez", "given": ["Julia"]}],
  "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "code": "SIS", "display": "Sister"}]}],
  "telecom": [{"system": "phone", "value": "+53 55545679", "use": "home"}],
  "patient": {"reference": "Patient/a4e5f6b7-c8d9-e0f1-a2b3-c4d5e6f7a8b9"}
}'::jsonb),
('90123456-7890-1234-0f45-123456789012', '{
  "resourceType": "RelatedPerson",
  "id": "90123456-7890-1234-0f45-123456789012",
  "name": [{"family": "López", "given": ["Miguel"]}],
  "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "code": "FTH", "display": "Father"}]}],
  "telecom": [{"system": "phone", "value": "+53 55556790", "use": "mobile"}],
  "patient": {"reference": "Patient/b5f6a7c8-d9e0-f1a2-b3c4-d5e6f7a8b9c0"}
}'::jsonb);

INSERT INTO observations (id, resource) VALUES
('a0123456-7890-1234-1g56-234567890123', '{
  "resourceType": "Observation",
  "id": "a0123456-7890-1234-1g56-234567890123",
  "code": {"coding": [{"system": "http://loinc.org", "code": "8480-6", "display": "Presión arterial sistólica"}]},
  "valueQuantity": {"value": 128, "unit": "mmHg"},
  "effectiveDateTime": "2025-06-01T09:45:00Z",
  "subject": {"reference": "Patient/7e1b2c3d-4f5a-6b7c-8d9e-0f1a2b3c4d5e"}
}'::jsonb),
('b1234567-8901-2345-2h67-345678901234', '{
  "resourceType": "Observation",
  "id": "b1234567-8901-2345-2h67-345678901234",
  "code": {"coding": [{"system": "http://loinc.org", "code": "8867-4", "display": "Frecuencia cardíaca"}]},
  "valueQuantity": {"value": 80, "unit": "bpm"},
  "effectiveDateTime": "2025-06-01T09:50:00Z",
  "subject": {"reference": "Patient/8f2c3d4e-5a6b-7c8d-9e0f-1a2b3c4d5e6f"}
}'::jsonb),
('c2345678-9012-3456-3i78-456789012345', '{
  "resourceType": "Observation",
  "id": "c2345678-9012-3456-3i78-456789012345",
  "code": {"coding": [{"system": "http://loinc.org", "code": "8310-5", "display": "Temperatura corporal"}]},
  "valueQuantity": {"value": 37.8, "unit": "°C"},
  "effectiveDateTime": "2025-06-01T11:00:00Z",
  "subject": {"reference": "Patient/9a3d4e5f-6b7c-8d9e-0f1a-2b3c4d5e6f7a"}
}'::jsonb),
('d3456789-0123-4567-4j89-567890123456', '{
  "resourceType": "Observation",
  "id": "d3456789-0123-4567-4j89-567890123456",
  "code": {"coding": [{"system": "http://loinc.org", "code": "29463-7", "display": "Peso corporal"}]},
  "valueQuantity": {"value": 74, "unit": "kg"},
  "effectiveDateTime": "2025-05-25T09:15:00Z",
  "subject": {"reference": "Patient/a4e5f6b7-c8d9-e0f1-a2b3-c4d5e6f7a8b9"}
}'::jsonb),
('e4567890-1234-5678-5k90-678901234567', '{
  "resourceType": "Observation",
  "id": "e4567890-1234-5678-5k90-678901234567",
  "code": {"coding": [{"system": "http://loinc.org", "code": "8310-5", "display": "Temperatura corporal"}]},
  "valueQuantity": {"value": 36.9, "unit": "°C"},
  "effectiveDateTime": "2025-05-20T14:05:00Z",
  "subject": {"reference": "Patient/b5f6a7c8-d9e0-f1a2-b3c4-d5e6f7a8b9c0"}
}'::jsonb);

INSERT INTO care_plans (id, resource) VALUES
('f5678901-2345-6789-6l01-789012345678', '{
  "resourceType": "CarePlan",
  "id": "f5678901-2345-6789-6l01-789012345678",
  "status": "active",
  "intent": "plan",
  "title": "Manejo de hipertensión",
  "subject": {"reference": "Patient/7e1b2c3d-4f5a-6b7c-8d9e-0f1a2b3c4d5e"},
  "period": {"start": "2025-01-01", "end": "2025-12-31"},
  "activity": [{
    "performedActivity": [{
      "coding": [{
        "system": "http://snomed.info/sct",
        "code": "698360004",
        "display": "Educación dietética"
      }]
    }],
    "progress": [],
    "plannedActivityReference": null
  }]
}'::jsonb),
('g6789012-3456-7890-7m12-890123456789', '{
  "resourceType": "CarePlan",
  "id": "g6789012-3456-7890-7m12-890123456789",
  "status": "active",
  "intent": "plan",
  "title": "Control de diabetes",
  "subject": {"reference": "Patient/8f2c3d4e-5a6b-7c8d-9e0f-1a2b3c4d5e6f"},
  "period": {"start": "2025-01-01", "end": "2025-12-31"},
  "activity": [{
    "performedActivity": [{
      "coding": [{
        "system": "http://snomed.info/sct",
        "code": "710081004",
        "display": "Monitoreo de glucosa en sangre"
      }]
    }],
    "progress": [],
    "plannedActivityReference": null
  }]
}'::jsonb),
('h7890123-4567-8901-8n23-901234567890', '{
  "resourceType": "CarePlan",
  "id": "h7890123-4567-8901-8n23-901234567890",
  "status": "active",
  "intent": "plan",
  "title": "Manejo de asma",
  "subject": {"reference": "Patient/9a3d4e5f-6b7c-8d9e-0f1a-2b3c4d5e6f7a"},
  "period": {"start": "2025-01-01", "end": "2025-12-31"},
  "activity": [{
    "performedActivity": [{
      "coding": [{
        "system": "http://snomed.info/sct",
        "code": "225341000000109",
        "display": "Terapia con corticosteroides inhalados"
      }]
    }],
    "progress": [],
    "plannedActivityReference": null
  }]
}'::jsonb),
('i8901234-5678-9012-9o34-012345678901', '{
  "resourceType": "CarePlan",
  "id": "i8901234-5678-9012-9o34-012345678901",
  "status": "active",
  "intent": "plan",
  "title": "Seguimiento respiratorio",
  "subject": {"reference": "Patient/a4e5f6b7-c8d9-e0f1-a2b3-c4d5e6f7a8b9"},
  "period": {"start": "2025-01-01", "end": "2025-12-31"},
  "activity": [{
    "performedActivity": [{
      "coding": [{
        "system": "http://snomed.info/sct",
        "code": "225341000000109",
        "display": "Rehabilitación pulmonar"
      }]
    }],
    "progress": [],
    "plannedActivityReference": null
  }]
}'::jsonb),
('j9012345-6789-0123-0p45-123456789012', '{
  "resourceType": "CarePlan",
  "id": "j9012345-6789-0123-0p45-123456789012",
  "status": "active",
  "intent": "plan",
  "title": "Prevención de alergias",
  "subject": {"reference": "Patient/b5f6a7c8-d9e0-f1a2-b3c4-d5e6f7a8b9c0"},
  "period": {"start": "2025-01-01", "end": "2025-12-31"},
  "activity": [{
    "performedActivity": [{
      "coding": [{
        "system": "http://snomed.info/sct",
        "code": "225341000000109",
        "display": "Educación sobre alergias"
      }]
    }],
    "progress": [],
    "plannedActivityReference": null
  }]
}'::jsonb);
