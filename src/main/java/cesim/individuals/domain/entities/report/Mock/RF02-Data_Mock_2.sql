INSERT INTO patients (id, resource) VALUES
('0e3c7b0f-3f1e-4b8d-8c8b-1a2b3c4d5e6f', '{
  "resourceType": "Patient",
  "id": "0e3c7b0f-3f1e-4b8d-8c8b-1a2b3c4d5e6f",
  "name": [{"use": "official", "family": "Hernández", "given": ["Carlos"]}],
  "gender": "male",
  "birthDate": "1980-05-15",
  "identifier": [{"system": "http://hospital.org/patient", "value": "80051523457"}],
  "telecom": [{"system": "phone", "value": "+53 51234567", "use": "mobile"}],
  "address": [{"line": ["Calle 23 #45"], "city": "La Habana", "country": "Cuba"}]
}'::jsonb),
('1f4b8e6d-2c3a-4b7d-9e5f-7a8b9c0d1e2f', '{
  "resourceType": "Patient",
  "id": "1f4b8e6d-2c3a-4b7d-9e5f-7a8b9c0d1e2f",
  "name": [{"use": "official", "family": "Martínez", "given": ["Ana María"]}],
  "gender": "female",
  "birthDate": "1975-11-20",
  "identifier": [{"system": "http://hospital.org/patient", "value": "75112098765"}],
  "telecom": [{"system": "phone", "value": "+53 51234678", "use": "home"}],
  "address": [{"line": ["Calle 8 #123"], "city": "Santiago de Cuba", "country": "Cuba"}]
}'::jsonb),
('2a6b9d8e-4c5f-4a7b-8e9d-0b1c2d3e4f5a', '{
  "resourceType": "Patient",
  "id": "2a6b9d8e-4c5f-4a7b-8e9d-0b1c2d3e4f5a",
  "name": [{"use": "official", "family": "Gómez", "given": ["Luis"]}],
  "gender": "male",
  "birthDate": "1988-07-10",
  "identifier": [{"system": "http://hospital.org/patient", "value": "88071012345"}],
  "telecom": [{"system": "phone", "value": "+53 51234789", "use": "mobile"}],
  "address": [{"line": ["Ave. 1ra #456"], "city": "Camagüey", "country": "Cuba"}]
}'::jsonb),
('3b7c8e9d-5a6b-4c7d-8e9f-1a2b3c4d5e6f', '{
  "resourceType": "Patient",
  "id": "3b7c8e9d-5a6b-4c7d-8e9f-1a2b3c4d5e6f",
  "name": [{"use": "official", "family": "Pérez", "given": ["María"]}],
  "gender": "female",
  "birthDate": "1992-03-05",
  "identifier": [{"system": "http://hospital.org/patient", "value": "92030567890"}],
  "telecom": [{"system": "phone", "value": "+53 51234890", "use": "home"}],
  "address": [{"line": ["Calle 10 #789"], "city": "Holguín", "country": "Cuba"}]
}'::jsonb),
('4c8d9e0f-6b7a-4c8d-9e0f-2b3c4d5e6f7a', '{
  "resourceType": "Patient",
  "id": "4c8d9e0f-6b7a-4c8d-9e0f-2b3c4d5e6f7a",
  "name": [{"use": "official", "family": "Rodríguez", "given": ["Jorge"]}],
  "gender": "male",
  "birthDate": "1970-12-15",
  "identifier": [{"system": "http://hospital.org/patient", "value": "70121523456"}],
  "telecom": [{"system": "phone", "value": "+53 51234901", "use": "mobile"}],
  "address": [{"line": ["Calle 5 #321"], "city": "Santa Clara", "country": "Cuba"}]
}'::jsonb);

INSERT INTO practitioners (id, resource) VALUES
('5d9e0f1a-7b8c-4d9e-0f1a-3c4d5e6f7a8b', '{
  "resourceType": "Practitioner",
  "id": "5d9e0f1a-7b8c-4d9e-0f1a-3c4d5e6f7a8b",
  "name": [{"family": "López", "given": ["Ana"]}],
  "identifier": [{"system": "http://hospital.org/practitioner", "value": "MED12345"}]
}'::jsonb),
('6e0f1a2b-8c9d-4e0f-1a2b-4d5e6f7a8b9c', '{
  "resourceType": "Practitioner",
  "id": "6e0f1a2b-8c9d-4e0f-1a2b-4d5e6f7a8b9c",
  "name": [{"family": "Martínez", "given": ["Carlos"]}],
  "identifier": [{"system": "http://hospital.org/practitioner", "value": "MED67890"}]
}'::jsonb),
('7f1a2b3c-9d0e-4f1a-2b3c-5e6f7a8b9c0d', '{
  "resourceType": "Practitioner",
  "id": "7f1a2b3c-9d0e-4f1a-2b3c-5e6f7a8b9c0d",
  "name": [{"family": "García", "given": ["Lucía"]}],
  "identifier": [{"system": "http://hospital.org/practitioner", "value": "MED11223"}]
}'::jsonb),
('8a2b3c4d-0e1f-4a2b-3c4d-6f7a8b9c0d1e', '{
  "resourceType": "Practitioner",
  "id": "8a2b3c4d-0e1f-4a2b-3c4d-6f7a8b9c0d1e",
  "name": [{"family": "Fernández", "given": ["Miguel"]}],
  "identifier": [{"system": "http://hospital.org/practitioner", "value": "MED44556"}]
}'::jsonb),
('9b3c4d5e-1f2a-4b3c-4d5e-7a8b9c0d1e2f', '{
  "resourceType": "Practitioner",
  "id": "9b3c4d5e-1f2a-4b3c-4d5e-7a8b9c0d1e2f",
  "name": [{"family": "Sánchez", "given": ["Isabel"]}],
  "identifier": [{"system": "http://hospital.org/practitioner", "value": "MED77889"}]
}'::jsonb);

INSERT INTO related_persons (id, resource) VALUES
('a4d5e6f7-2b3c-4d5e-6f7a-8b9c0d1e2f3a', '{
  "resourceType": "RelatedPerson",
  "id": "a4d5e6f7-2b3c-4d5e-6f7a-8b9c0d1e2f3a",
  "name": [{"family": "Hernández", "given": ["María"]}],
  "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "code": "SPS", "display": "Spouse"}]}],
  "telecom": [{"system": "phone", "value": "+53 51234568", "use": "home"}],
  "patient": {"reference": "Patient/0e3c7b0f-3f1e-4b8d-8c8b-1a2b3c4d5e6f"}
}'::jsonb),
('b5e6f7a8-3c4d-5e6f-7a8b-9c0d1e2f3a4b', '{
  "resourceType": "RelatedPerson",
  "id": "b5e6f7a8-3c4d-5e6f-7a8b-9c0d1e2f3a4b",
  "name": [{"family": "Martínez", "given": ["José"]}],
  "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "code": "FTH", "display": "Father"}]}],
  "telecom": [{"system": "phone", "value": "+53 51234679", "use": "mobile"}],
  "patient": {"reference": "Patient/1f4b8e6d-2c3a-4b7d-9e5f-7a8b9c0d1e2f"}
}'::jsonb),
('c6f7a8b9-4d5e-6f7a-8b9c-0d1e2f3a4b5c', '{
  "resourceType": "RelatedPerson",
  "id": "c6f7a8b9-4d5e-6f7a-8b9c-0d1e2f3a4b5c",
  "name": [{"family": "Gómez", "given": ["Ana"]}],
  "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "code": "MTH", "display": "Mother"}]}],
  "telecom": [{"system": "phone", "value": "+53 51234780", "use": "home"}],
  "patient": {"reference": "Patient/2a6b9d8e-4c5f-4a7b-8e9d-0b1c2d3e4f5a"}
}'::jsonb),
('d7a8b9c0-5e6f-7a8b-9c0d-1e2f3a4b5c6d', '{
  "resourceType": "RelatedPerson",
  "id": "d7a8b9c0-5e6f-7a8b-9c0d-1e2f3a4b5c6d",
  "name": [{"family": "Pérez", "given": ["Luis"]}],
  "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "code": "BRO", "display": "Brother"}]}],
  "telecom": [{"system": "phone", "value": "+53 51234891", "use": "mobile"}],
  "patient": {"reference": "Patient/3b7c8e9d-5a6b-4c7d-8e9f-1a2b3c4d5e6f"}
}'::jsonb),
('e8b9c0d1-6f7a-8b9c-0d1e-2f3a4b5c6d7e', '{
  "resourceType": "RelatedPerson",
  "id": "e8b9c0d1-6f7a-8b9c-0d1e-2f3a4b5c6d7e",
  "name": [{"family": "Rodríguez", "given": ["Ana"]}],
  "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "code": "SIS", "display": "Sister"}]}],
  "telecom": [{"system": "phone", "value": "+53 51234902", "use": "home"}],
  "patient": {"reference": "Patient/4c8d9e0f-6b7a-4c8d-9e0f-2b3c4d5e6f7a"}
}'::jsonb);

INSERT INTO encounters (id, resource) VALUES
('fa1b2c3d-7e8f-4a1b-2c3d-4e5f6a7b8c9d', '{
  "resourceType": "Encounter",
  "id": "fa1b2c3d-7e8f-4a1b-2c3d-4e5f6a7b8c9d",
  "status": "in-progress",
  "class": {"code": "EMER", "display": "Emergency"},
  "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "EMER", "display": "Emergency"}]}],
  "subject": {"reference": "Patient/0e3c7b0f-3f1e-4b8d-8c8b-1a2b3c4d5e6f"},
  "period": {"start": "2025-06-01T09:30:00Z"},
  "participant": [{"individual": {"reference": "Practitioner/5d9e0f1a-7b8c-4d9e-0f1a-3c4d5e6f7a8b"}}],
  "reasonCode": [{"text": "Dolor torácico"}]
}'::jsonb),
('fb2c3d4e-8f9a-4b2c-3d4e-5f6a7b8c9d0e', '{
  "resourceType": "Encounter",
  "id": "fb2c3d4e-8f9a-4b2c-3d4e-5f6a7b8c9d0e",
  "status": "finished",
  "class": {"code": "AMB", "display": "Ambulatory"},
  "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "AMB", "display": "Ambulatory"}]}],
  "subject": {"reference": "Patient/1f4b8e6d-2c3a-4b7d-9e5f-7a8b9c0d1e2f"},
  "period": {"start": "2025-05-20T14:00:00Z", "end": "2025-05-20T15:00:00Z"},
  "participant": [{"individual": {"reference": "Practitioner/6e0f1a2b-8c9d-4e0f-1a2b-4d5e6f7a8b9c"}}],
  "reasonCode": [{"text": "Control diabetes"}]
}'::jsonb),
('fc3d4e5f-9a0b-4c3d-4e5f-6a7b8c9d0e1f', '{
  "resourceType": "Encounter",
  "id": "fc3d4e5f-9a0b-4c3d-4e5f-6a7b8c9d0e1f",
  "status": "in-progress",
  "class": {"code": "EMER", "display": "Emergency"},
  "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "EMER", "display": "Emergency"}]}],
  "subject": {"reference": "Patient/2a6b9d8e-4c5f-4a7b-8e9d-0b1c2d3e4f5a"},
  "period": {"start": "2025-06-01T10:15:00Z"},
  "participant": [{"individual": {"reference": "Practitioner/7f1a2b3c-9d0e-4f1a-2b3c-5e6f7a8b9c0d"}}],
  "reasonCode": [{"text": "Dificultad respiratoria"}]
}'::jsonb),
('fd4e5f6a-0b1c-4d5e-5f6a-7b8c9d0e1f2a', '{
  "resourceType": "Encounter",
  "id": "fd4e5f6a-0b1c-4d5e-5f6a-7b8c9d0e1f2a",
  "status": "finished",
  "class": {"code": "AMB", "display": "Ambulatory"},
  "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "AMB", "display": "Ambulatory"}]}],
  "subject": {"reference": "Patient/3b7c8e9d-5a6b-4c7d-8e9f-1a2b3c4d5e6f"},
  "period": {"start": "2025-05-25T09:00:00Z", "end": "2025-05-25T09:30:00Z"},
  "participant": [{"individual": {"reference": "Practitioner/8a2b3c4d-0e1f-4a2b-3c4d-6f7a8b9c0d1e"}}],
  "reasonCode": [{"text": "Chequeo general"}]
}'::jsonb),
('fe5f6a7b-1c2d-4e5f-6a7b-8c9d0e1f2a3b', '{
  "resourceType": "Encounter",
  "id": "fe5f6a7b-1c2d-4e5f-6a7b-8c9d0e1f2a3b",
  "status": "in-progress",
  "class": {"code": "EMER", "display": "Emergency"},
  "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "EMER", "display": "Emergency"}]}],
  "subject": {"reference": "Patient/4c8d9e0f-6b7a-4c8d-9e0f-2b3c4d5e6f7a"},
  "period": {"start": "2025-06-01T11:00:00Z"},
  "participant": [{"individual": {"reference": "Practitioner/9b3c4d5e-1f2a-4b3c-4d5e-7a8b9c0d1e2f"}}],
  "reasonCode": [{"text": "Fiebre alta"}]
}'::jsonb);

INSERT INTO observations (id, resource) VALUES
('a1f2e3d4-c5b6-4789-9abc-def012345678', '{
  "resourceType": "Observation",
  "id": "a1f2e3d4-c5b6-4789-9abc-def012345678",
  "code": {"coding": [{"system": "http://loinc.org", "code": "8480-6", "display": "Presión arterial sistólica"}]},
  "valueQuantity": {"value": 130, "unit": "mmHg"},
  "effectiveDateTime": "2025-06-01T09:45:00Z",
  "subject": {"reference": "Patient/0e3c7b0f-3f1e-4b8d-8c8b-1a2b3c4d5e6f"},
  "encounter": {"reference": "Encounter/fa1b2c3d-7e8f-4a1b-2c3d-4e5f6a7b8c9d"}
}'::jsonb),
('b2e3d4f5-c6a7-5890-abcd-ef1234567890', '{
  "resourceType": "Observation",
  "id": "b2e3d4f5-c6a7-5890-abcd-ef1234567890",
  "code": {"coding": [{"system": "http://loinc.org", "code": "8867-4", "display": "Frecuencia cardíaca"}]},
  "valueQuantity": {"value": 78, "unit": "bpm"},
  "effectiveDateTime": "2025-06-01T09:50:00Z",
  "subject": {"reference": "Patient/0e3c7b0f-3f1e-4b8d-8c8b-1a2b3c4d5e6f"},
  "encounter": {"reference": "Encounter/fa1b2c3d-7e8f-4a1b-2c3d-4e5f6a7b8c9d"}
}'::jsonb),
('c3d4e5f6-a7b8-6901-bcde-f0123456789a', '{
  "resourceType": "Observation",
  "id": "c3d4e5f6-a7b8-6901-bcde-f0123456789a",
  "code": {"coding": [{"system": "http://loinc.org", "code": "8310-5", "display": "Temperatura corporal"}]},
  "valueQuantity": {"value": 38.2, "unit": "°C"},
  "effectiveDateTime": "2025-06-01T11:00:00Z",
  "subject": {"reference": "Patient/4c8d9e0f-6b7a-4c8d-9e0f-2b3c4d5e6f7a"},
  "encounter": {"reference": "Encounter/fe5f6a7b-1c2d-4e5f-6a7b-8c9d0e1f2a3b"}
}'::jsonb),
('d4e5f6a7-b8c9-4d0e-9f1a-b2c3d4e5f6a7', '{
  "resourceType": "Observation",
  "id": "d4e5f6a7-b8c9-4d0e-9f1a-b2c3d4e5f6a7",
  "code": {"coding": [{"system": "http://loinc.org", "code": "29463-7", "display": "Peso corporal"}]},
  "valueQuantity": {"value": 72, "unit": "kg"},
  "effectiveDateTime": "2025-05-25T09:15:00Z",
  "subject": {"reference": "Patient/3b7c8e9d-5a6b-4c7d-8e9f-1a2b3c4d5e6f"},
  "encounter": {"reference": "Encounter/fd4e5f6a-0b1c-4d5e-5f6a-7b8c9d0e1f2a"}
}'::jsonb),
('e5f6a7b8-c9d0-4e1f-2a3b-4c5d6e7f8901', '{
  "resourceType": "Observation",
  "id": "e5f6a7b8-c9d0-4e1f-2a3b-4c5d6e7f8901",
  "code": {"coding": [{"system": "http://loinc.org", "code": "8310-5", "display": "Temperatura corporal"}]},
  "valueQuantity": {"value": 36.8, "unit": "°C"},
  "effectiveDateTime": "2025-05-20T14:05:00Z",
  "subject": {"reference": "Patient/1f4b8e6d-2c3a-4b7d-9e5f-7a8b9c0d1e2f"},
  "encounter": {"reference": "Encounter/fb2c3d4e-8f9a-4b2c-3d4e-5f6a7b8c9d0e"}
}'::jsonb);

INSERT INTO allergy_intolerances (id, resource) VALUES
('f6a7b8c9-d0e1-4f2a-3b4c-5d6e7f890123', '{
  "resourceType": "AllergyIntolerance",
  "id": "f6a7b8c9-d0e1-4f2a-3b4c-5d6e7f890123",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "293962007", "display": "Alergia a penicilina"}]},
  "patient": {"reference": "Patient/0e3c7b0f-3f1e-4b8d-8c8b-1a2b3c4d5e6f"}
}'::jsonb),
('07b8c9d0-e1f2-4a3b-5c6d-7e8f90123456', '{
  "resourceType": "AllergyIntolerance",
  "id": "07b8c9d0-e1f2-4a3b-5c6d-7e8f90123456",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "300916003", "display": "Alergia a mariscos"}]},
  "patient": {"reference": "Patient/1f4b8e6d-2c3a-4b7d-9e5f-7a8b9c0d1e2f"}
}'::jsonb),
('18c9d0e1-f2a3-4b5c-6d7e-8f9012345678', '{
  "resourceType": "AllergyIntolerance",
  "id": "18c9d0e1-f2a3-4b5c-6d7e-8f9012345678",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "256259004", "display": "Alergia a ácaros del polvo"}]},
  "patient": {"reference": "Patient/2a6b9d8e-4c5f-4a7b-8e9d-0b1c2d3e4f5a"}
}'::jsonb),
('29d0e1f2-a3b4-5c6d-7e8f-90123456789a', '{
  "resourceType": "AllergyIntolerance",
  "id": "29d0e1f2-a3b4-5c6d-7e8f-90123456789a",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "419511007", "display": "Alergia a látex"}]},
  "patient": {"reference": "Patient/3b7c8e9d-5a6b-4c7d-8e9f-1a2b3c4d5e6f"}
}'::jsonb),
('3ad0e1f2-b3c4-5d6e-7f89-0123456789ab', '{
  "resourceType": "AllergyIntolerance",
  "id": "3ad0e1f2-b3c4-5d6e-7f89-0123456789ab",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "294638003", "display": "Alergia a huevo"}]},
  "patient": {"reference": "Patient/4c8d9e0f-6b7a-4c8d-9e0f-2b3c4d5e6f7a"}
}'::jsonb);

INSERT INTO medication_requests (id, resource) VALUES
('4bd5e6f7-8a9b-0c1d-2e3f-4a5b6c7d8e9f', '{
  "resourceType": "MedicationRequest",
  "id": "4bd5e6f7-8a9b-0c1d-2e3f-4a5b6c7d8e9f",
  "status": "active",
  "intent": "order",
  "priority": "urgent",
  "authoredOn": "2025-06-01T10:00:00Z",
  "medication": {"reference": "Medication/Losartan"},
  "subject": {"reference": "Patient/0e3c7b0f-3f1e-4b8d-8c8b-1a2b3c4d5e6f"},
  "dosageInstruction": [{"text": "50 mg cada 24 horas"}],
  "requester": {"reference": "Practitioner/5d9e0f1a-7b8c-4d9e-0f1a-3c4d5e6f7a8b"},
  "encounter": {"reference": "Encounter/fa1b2c3d-7e8f-4a1b-2c3d-4e5f6a7b8c9d"},
  "reasonCode": [{"coding": [{"system": "http://snomed.info/sct", "code": "38341003", "display": "Hipertensión esencial"}]}]
}'::jsonb),
('5ce6f7a8-9b0c-1d2e-3f4a-5b6c7d8e9f0a', '{
  "resourceType": "MedicationRequest",
  "id": "5ce6f7a8-9b0c-1d2e-3f4a-5b6c7d8e9f0a",
  "status": "active",
  "intent": "order",
  "priority": "routine",
  "authoredOn": "2025-05-20T14:30:00Z",
  "medication": {"reference": "Medication/Metformin"},
  "subject": {"reference": "Patient/1f4b8e6d-2c3a-4b7d-9e5f-7a8b9c0d1e2f"},
  "dosageInstruction": [{"text": "850 mg cada 12 horas con alimentos"}],
  "requester": {"reference": "Practitioner/6e0f1a2b-8c9d-4e0f-1a2b-4d5e6f7a8b9c"},
  "encounter": {"reference": "Encounter/fb2c3d4e-8f9a-4b2c-3d4e-5f6a7b8c9d0e"},
  "reasonCode": [{"coding": [{"system": "http://snomed.info/sct", "code": "44054006", "display": "Diabetes mellitus tipo 2"}]}]
}'::jsonb),
('6df7a8b9-0c1d-2e3f-4a5b-6c7d8e9f0a1b', '{
  "resourceType": "MedicationRequest",
  "id": "6df7a8b9-0c1d-2e3f-4a5b-6c7d8e9f0a1b",
  "status": "completed",
  "intent": "order",
  "priority": "asap",
  "authoredOn": "2025-06-01T10:20:00Z",
  "medication": {"reference": "Medication/Salbutamol"},
  "subject": {"reference": "Patient/2a6b9d8e-4c5f-4a7b-8e9d-0b1c2d3e4f5a"},
  "dosageInstruction": [{"text": "2 inhalaciones cada 6 horas según necesidad"}],
  "requester": {"reference": "Practitioner/7f1a2b3c-9d0e-4f1a-2b3c-5e6f7a8b9c0d"},
  "encounter": {"reference": "Encounter/fc3d4e5f-9a0b-4c3d-4e5f-6a7b8c9d0e1f"},
  "reasonCode": [{"coding": [{"system": "http://snomed.info/sct", "code": "195967001", "display": "Asma persistente"}]}]
}'::jsonb),
('7ea8b9c0-d1e2-3f4a-5b6c-7d8e9f0a1b2c', '{
  "resourceType": "MedicationRequest",
  "id": "7ea8b9c0-d1e2-3f4a-5b6c-7d8e9f0a1b2c",
  "status": "active",
  "intent": "order",
  "priority": "routine",
  "authoredOn": "2025-05-25T09:15:00Z",
  "medication": {"reference": "Medication/Paracetamol"},
  "subject": {"reference": "Patient/3b7c8e9d-5a6b-4c7d-8e9f-1a2b3c4d5e6f"},
  "dosageInstruction": [{"text": "500 mg cada 8 horas si hay fiebre"}],
  "requester": {"reference": "Practitioner/8a2b3c4d-0e1f-4a2b-3c4d-6f7a8b9c0d1e"},
  "encounter": {"reference": "Encounter/fd4e5f6a-0b1c-4d5e-5f6a-7b8c9d0e1f2a"},
  "reasonCode": [{"coding": [{"system": "http://snomed.info/sct", "code": "386661006", "display": "Infección respiratoria aguda"}]}]
}'::jsonb),
('8fb9c0d1-e2f3-4a5b-6c7d-8e9f0a1b2c3d', '{
  "resourceType": "MedicationRequest",
  "id": "8fb9c0d1-e2f3-4a5b-6c7d-8e9f0a1b2c3d",
  "status": "active",
  "intent": "order",
  "priority": "urgent",
  "authoredOn": "2025-06-01T11:10:00Z",
  "medication": {"reference": "Medication/Omeprazole"},
  "subject": {"reference": "Patient/4c8d9e0f-6b7a-4c8d-9e0f-2b3c4d5e6f7a"},
  "dosageInstruction": [{"text": "20 mg cada 24 horas antes del desayuno"}],
  "requester": {"reference": "Practitioner/9b3c4d5e-1f2a-4b3c-4d5e-7a8b9c0d1e2f"},
  "encounter": {"reference": "Encounter/fe5f6a7b-1c2d-4e5f-6a7b-8c9d0e1f2a3b"},
  "reasonCode": [{"coding": [{"system": "http://snomed.info/sct", "code": "44054006", "display": "Gastritis"}]}]
}'::jsonb);

INSERT INTO conditions (id, resource) VALUES
('9acbd0e1-f2a3-4b5c-6d7e-8f9012345678', '{
  "resourceType": "Condition",
  "id": "9acbd0e1-f2a3-4b5c-6d7e-8f9012345678",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/condition-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "38341003", "display": "Hipertensión esencial"}]},
  "subject": {"reference": "Patient/0e3c7b0f-3f1e-4b8d-8c8b-1a2b3c4d5e6f"},
  "encounter": {"reference": "Encounter/fa1b2c3d-7e8f-4a1b-2c3d-4e5f6a7b8c9d"},
  "recordedDate": "2023-05-10"
}'::jsonb),
('abdce1f2-a3b4-5c6d-7e8f-90123456789a', '{
  "resourceType": "Condition",
  "id": "abdce1f2-a3b4-5c6d-7e8f-90123456789a",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/condition-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "44054006", "display": "Diabetes mellitus tipo 2"}]},
  "subject": {"reference": "Patient/1f4b8e6d-2c3a-4b7d-9e5f-7a8b9c0d1e2f"},
  "encounter": {"reference": "Encounter/fb2c3d4e-8f9a-4b2c-3d4e-5f6a7b8c9d0e"},
  "recordedDate": "2022-11-20"
}'::jsonb),
('bcdef123-4567-89ab-cdef-0123456789ab', '{
  "resourceType": "Condition",
  "id": "bcdef123-4567-89ab-cdef-0123456789ab",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/condition-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "195967001", "display": "Asma persistente"}]},
  "subject": {"reference": "Patient/2a6b9d8e-4c5f-4a7b-8e9d-0b1c2d3e4f5a"},
  "encounter": {"reference": "Encounter/fc3d4e5f-9a0b-4c3d-4e5f-6a7b8c9d0e1f"},
  "recordedDate": "2024-01-15"
}'::jsonb),
('cdef0123-4567-89ab-cdef-0123456789ab', '{
  "resourceType": "Condition",
  "id": "cdef0123-4567-89ab-cdef-0123456789ab",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/condition-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "386661006", "display": "Infección respiratoria aguda"}]},
  "subject": {"reference": "Patient/3b7c8e9d-5a6b-4c7d-8e9f-1a2b3c4d5e6f"},
  "encounter": {"reference": "Encounter/fd4e5f6a-0b1c-4d5e-5f6a-7b8c9d0e1f2a"},
  "recordedDate": "2025-05-25"
}'::jsonb),
('def01234-5678-9abc-def0-123456789abc', '{
  "resourceType": "Condition",
  "id": "def01234-5678-9abc-def0-123456789abc",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/condition-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "29427007", "display": "Alergia a penicilina"}]},
  "subject": {"reference": "Patient/4c8d9e0f-6b7a-4c8d-9e0f-2b3c4d5e6f7a"},
  "encounter": {"reference": "Encounter/fe5f6a7b-1c2d-4e5f-6a7b-8c9d0e1f2a3b"},
  "recordedDate": "2023-12-01"
}'::jsonb);

INSERT INTO care_plans (id, resource) VALUES
('e0f1a2b3-c4d5-6789-0abc-def123456789', '{
  "resourceType": "CarePlan",
  "id": "e0f1a2b3-c4d5-6789-0abc-def123456789",
  "status": "active",
  "intent": "plan",
  "title": "Manejo de hipertensión",
  "subject": {"reference": "Patient/0e3c7b0f-3f1e-4b8d-8c8b-1a2b3c4d5e6f"},
  "period": {"start": "2025-01-01", "end": "2025-12-31"},
  "activity": [{
    "detail": {
      "code": {"coding": [{"system": "http://snomed.info/sct", "code": "698360004", "display": "Educación dietética"}]},
      "status": "in-progress"
    }
  }]
}'::jsonb),
('f1a2b3c4-d5e6-7890-1abc-def234567890', '{
  "resourceType": "CarePlan",
  "id": "f1a2b3c4-d5e6-7890-1abc-def234567890",
  "status": "active",
  "intent": "plan",
  "title": "Control de diabetes",
  "subject": {"reference": "Patient/1f4b8e6d-2c3a-4b7d-9e5f-7a8b9c0d1e2f"},
  "period": {"start": "2025-01-01", "end": "2025-12-31"},
  "activity": [{
    "detail": {
      "code": {"coding": [{"system": "http://snomed.info/sct", "code": "710081004", "display": "Monitoreo de glucosa en sangre"}]},
      "status": "in-progress"
    }
  }]
}'::jsonb),
('g1b2c3d4-e5f6-8901-2abc-def345678901', '{
  "resourceType": "CarePlan",
  "id": "g1b2c3d4-e5f6-8901-2abc-def345678901",
  "status": "active",
  "intent": "plan",
  "title": "Manejo de asma",
  "subject": {"reference": "Patient/2a6b9d8e-4c5f-4a7b-8e9d-0b1c2d3e4f5a"},
  "period": {"start": "2025-01-01", "end": "2025-12-31"},
  "activity": [{
    "detail": {
      "code": {"coding": [{"system": "http://snomed.info/sct", "code": "225341000000109", "display": "Terapia con corticosteroides inhalados"}]},
      "status": "in-progress"
    }
  }]
}'::jsonb),
('h1c2d3e4-f5a6-9012-3abc-def456789012', '{
  "resourceType": "CarePlan",
  "id": "h1c2d3e4-f5a6-9012-3abc-def456789012",
  "status": "active",
  "intent": "plan",
  "title": "Seguimiento respiratorio",
  "subject": {"reference": "Patient/3b7c8e9d-5a6b-4c7d-8e9f-1a2b3c4d5e6f"},
  "period": {"start": "2025-01-01", "end": "2025-12-31"},
  "activity": [{
    "detail": {
      "code": {"coding": [{"system": "http://snomed.info/sct", "code": "225341000000109", "display": "Rehabilitación pulmonar"}]},
      "status": "in-progress"
    }
  }]
}'::jsonb),
('i1d2e3f4-a5b6-0123-4abc-def567890123', '{
  "resourceType": "CarePlan",
  "id": "i1d2e3f4-a5b6-0123-4abc-def567890123",
  "status": "active",
  "intent": "plan",
  "title": "Prevención de alergias",
  "subject": {"reference": "Patient/4c8d9e0f-6b7a-4c8d-9e0f-2b3c4d5e6f7a"},
  "period": {"start": "2025-01-01", "end": "2025-12-31"},
  "activity": [{
    "detail": {
      "code": {"coding": [{"system": "http://snomed.info/sct", "code": "225341000000109", "display": "Educación sobre alergias"}]},
      "status": "in-progress"
    }
  }]
}'::jsonb);
