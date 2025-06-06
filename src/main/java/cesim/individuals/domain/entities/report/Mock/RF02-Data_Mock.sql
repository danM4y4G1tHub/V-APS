-- Insert Patients
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
}'::jsonb),
('7d4e3b2a-1c0f-4a5b-9d8e-7f6c5b4a3d2e', '{
  "resourceType": "Patient",
  "id": "7d4e3b2a-1c0f-4a5b-9d8e-7f6c5b4a3d2e",
  "name": [{"use": "official", "family": "Hernández", "given": ["Carlos"]}],
  "gender": "male",
  "birthDate": "1980-05-15",
  "identifier": [{"system": "http://hospital.org/patient", "value": "80051523457"}],
  "telecom": [{"system": "phone", "value": "+53 51234567", "use": "mobile"}],
  "address": [{"line": ["Calle 23 #45"], "city": "La Habana", "country": "Cuba"}],
}'::jsonb),
('a1b2c3d4-e5f6-47g8-9h0i-j1k2l3m4n5o6', '{
  "resourceType": "Patient",
  "id": "a1b2c3d4-e5f6-47g8-9h0i-j1k2l3m4n5o6",
  "name": [{"use": "official", "family": "Martínez", "given": ["Ana María"]}],
  "gender": "female",
  "birthDate": "1975-11-20",
  "identifier": [{"system": "http://hospital.org/patient", "value": "75112098765"}],
  "telecom": [{"system": "phone", "value": "+53 51234678", "use": "home"}],
  "address": [{"line": ["Calle 8 #123"], "city": "Santiago de Cuba", "country": "Cuba"}],
}'::jsonb),
('c1d2e3f4-a5b6-4708-9c0d-e1f2a3b4c5d6', '{
  "resourceType": "Patient",
  "id": "c1d2e3f4-a5b6-4708-9c0d-e1f2a3b4c5d6",
  "name": [{"use": "official", "family": "Gómez", "given": ["Luis"]}],
  "gender": "male",
  "birthDate": "1988-07-10",
  "identifier": [{"system": "http://hospital.org/patient", "value": "88071012345"}],
  "telecom": [{"system": "phone", "value": "+53 51234789", "use": "mobile"}],
  "address": [{"line": ["Ave. 1ra #456"], "city": "Camagüey", "country": "Cuba"}],
}'::jsonb),
('d4e5f6a7-b8c9-4d0e-9f1a-b2c3d4e5f6a7', '{
  "resourceType": "Patient",
  "id": "d4e5f6a7-b8c9-4d0e-9f1a-b2c3d4e5f6a7",
  "name": [{"use": "official", "family": "Pérez", "given": ["María"]}],
  "gender": "female",
  "birthDate": "1992-03-05",
  "identifier": [{"system": "http://hospital.org/patient", "value": "92030567890"}],
  "telecom": [{"system": "phone", "value": "+53 51234890", "use": "home"}],
  "address": [{"line": ["Calle 10 #789"], "city": "Holguín", "country": "Cuba"}],
}'::jsonb),
('e7f8a9b0-c1d2-4e3f-8a9b-0c1d2e3f4a5b', '{
  "resourceType": "Patient",
  "id": "e7f8a9b0-c1d2-4e3f-8a9b-0c1d2e3f4a5b",
  "name": [{"use": "official", "family": "Rodríguez", "given": ["Jorge"]}],
  "gender": "male",
  "birthDate": "1970-12-15",
  "identifier": [{"system": "http://hospital.org/patient", "value": "70121523456"}],
  "telecom": [{"system": "phone", "value": "+53 51234901", "use": "mobile"}],
  "address": [{"line": ["Calle 5 #321"], "city": "Santa Clara", "country": "Cuba"}],
}'::jsonb);

-- Insert Practitioners
INSERT INTO practitioners (id, resource) VALUES
('pract-001', '{
  "resourceType": "Practitioner",
  "id": "pract-001",
  "name": [{"family": "López", "given": ["Ana"]}],
  "identifier": [{"system": "http://hospital.org/practitioner", "value": "MED12345"}],
  "qualification": [{"code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "MD", "display": "Doctor of Medicine"}]}}]
}'::jsonb),
('pract-002', '{
  "resourceType": "Practitioner",
  "id": "pract-002",
  "name": [{"family": "Martínez", "given": ["Carlos"]}],
  "identifier": [{"system": "http://hospital.org/practitioner", "value": "MED67890"}],
  "qualification": [{"code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "RN", "display": "Registered Nurse"}]}}]
}'::jsonb),
('pract-003', '{
  "resourceType": "Practitioner",
  "id": "pract-003",
  "name": [{"family": "García", "given": ["Lucía"]}],
  "identifier": [{"system": "http://hospital.org/practitioner", "value": "MED11223"}],
  "qualification": [{"code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "MD", "display": "Doctor of Medicine"}]}}]
}'::jsonb),
('pract-004', '{
  "resourceType": "Practitioner",
  "id": "pract-004",
  "name": [{"family": "Fernández", "given": ["Miguel"]}],
  "identifier": [{"system": "http://hospital.org/practitioner", "value": "MED44556"}],
  "qualification": [{"code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "PA", "display": "Physician Assistant"}]}}]
}'::jsonb),
('pract-005', '{
  "resourceType": "Practitioner",
  "id": "pract-005",
  "name": [{"family": "Sánchez", "given": ["Isabel"]}],
  "identifier": [{"system": "http://hospital.org/practitioner", "value": "MED77889"}],
  "qualification": [{"code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "MD", "display": "Doctor of Medicine"}]}}]
}'::jsonb);

-- Insert RelatedPersons
INSERT INTO related_persons (id, resource) VALUES
('rel-001', '{
  "resourceType": "RelatedPerson",
  "id": "rel-001",
  "name": [{"family": "Hernández", "given": ["María"]}],
  "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "code": "SIS", "display": "Spouse"}]}],
  "telecom": [{"system": "phone", "value": "+53 51234568", "use": "home"}],
  "patient": {"reference": "Patient/7d4e3b2a-1c0f-4a5b-9d8e-7f6c5b4a3d2e"}
}'::jsonb),
('rel-002', '{
  "resourceType": "RelatedPerson",
  "id": "rel-002",
  "name": [{"family": "Martínez", "given": ["José"]}],
  "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "code": "FTH", "display": "Father"}]}],
  "telecom": [{"system": "phone", "value": "+53 51234679", "use": "mobile"}],
  "patient": {"reference": "Patient/a1b2c3d4-e5f6-47g8-9h0i-j1k2l3m4n5o6"}
}'::jsonb),
('rel-003', '{
  "resourceType": "RelatedPerson",
  "id": "rel-003",
  "name": [{"family": "Gómez", "given": ["Ana"]}],
  "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "code": "MTH", "display": "Mother"}]}],
  "telecom": [{"system": "phone", "value": "+53 51234780", "use": "home"}],
  "patient": {"reference": "Patient/c1d2e3f4-a5b6-4708-9c0d-e1f2a3b4c5d6"}
}'::jsonb),
('rel-004', '{
  "resourceType": "RelatedPerson",
  "id": "rel-004",
  "name": [{"family": "Pérez", "given": ["Luis"]}],
  "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "code": "BRO", "display": "Brother"}]}],
  "telecom": [{"system": "phone", "value": "+53 51234891", "use": "mobile"}],
  "patient": {"reference": "Patient/d4e5f6a7-b8c9-4d0e-9f1a-b2c3d4e5f6a7"}
}'::jsonb),
('rel-005', '{
  "resourceType": "RelatedPerson",
  "id": "rel-005",
  "name": [{"family": "Rodríguez", "given": ["Ana"]}],
  "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "code": "SIS", "display": "Sister"}]}],
  "telecom": [{"system": "phone", "value": "+53 51234902", "use": "home"}],
  "patient": {"reference": "Patient/e7f8a9b0-c1d2-4e3f-8a9b-0c1d2e3f4a5b"}
}'::jsonb);

-- Insert Encounters
INSERT INTO encounters (id, resource) VALUES
('enc-001', '{
  "resourceType": "Encounter",
  "id": "enc-001",
  "status": "in-progress",
  "class": {"code": "EMER", "display": "Emergency"},
  "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "EMER", "display": "Emergency"}]}],
  "subject": {"reference": "Patient/7d4e3b2a-1c0f-4a5b-9d8e-7f6c5b4a3d2e"},
  "period": {"start": "2025-06-01T09:30:00Z"},
  "participant": [{"individual": {"reference": "Practitioner/pract-001"}}],
  "reasonCode": [{"text": "Dolor torácico"}]
}'::jsonb),
('enc-002', '{
  "resourceType": "Encounter",
  "id": "enc-002",
  "status": "finished",
  "class": {"code": "AMB", "display": "Ambulatory"},
  "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "AMB", "display": "Ambulatory"}]}],
  "subject": {"reference": "Patient/a1b2c3d4-e5f6-47g8-9h0i-j1k2l3m4n5o6"},
  "period": {"start": "2025-05-20T14:00:00Z", "end": "2025-05-20T15:00:00Z"},
  "participant": [{"individual": {"reference": "Practitioner/pract-002"}}],
  "reasonCode": [{"text": "Control diabetes"}]
}'::jsonb),
('enc-003', '{
  "resourceType": "Encounter",
  "id": "enc-003",
  "status": "in-progress",
  "class": {"code": "EMER", "display": "Emergency"},
  "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "EMER", "display": "Emergency"}]}],
  "subject": {"reference": "Patient/c1d2e3f4-a5b6-4708-9c0d-e1f2a3b4c5d6"},
  "period": {"start": "2025-06-01T10:15:00Z"},
  "participant": [{"individual": {"reference": "Practitioner/pract-003"}}],
  "reasonCode": [{"text": "Dificultad respiratoria"}]
}'::jsonb),
('enc-004', '{
  "resourceType": "Encounter",
  "id": "enc-004",
  "status": "finished",
  "class": {"code": "AMB", "display": "Ambulatory"},
  "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "AMB", "display": "Ambulatory"}]}],
  "subject": {"reference": "Patient/d4e5f6a7-b8c9-4d0e-9f1a-b2c3d4e5f6a7"},
  "period": {"start": "2025-05-25T09:00:00Z", "end": "2025-05-25T09:30:00Z"},
  "participant": [{"individual": {"reference": "Practitioner/pract-004"}}],
  "reasonCode": [{"text": "Chequeo general"}]
}'::jsonb),
('enc-005', '{
  "resourceType": "Encounter",
  "id": "enc-005",
  "status": "in-progress",
  "class": {"code": "EMER", "display": "Emergency"},
  "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "EMER", "display": "Emergency"}]}],
  "subject": {"reference": "Patient/e7f8a9b0-c1d2-4e3f-8a9b-0c1d2e3f4a5b"},
  "period": {"start": "2025-06-01T11:00:00Z"},
  "participant": [{"individual": {"reference": "Practitioner/pract-005"}}],
  "reasonCode": [{"text": "Fiebre alta"}]
}'::jsonb);

-- Insert Observations
INSERT INTO observations (id, resource) VALUES
('obs-001', '{
  "resourceType": "Observation",
  "id": "obs-001",
  "code": {"coding": [{"system": "http://loinc.org", "code": "8480-6", "display": "Presión arterial sistólica"}]},
  "valueQuantity": {"value": 120, "unit": "mmHg"},
  "effectiveDateTime": "2025-06-01T09:45:00Z",
  "subject": {"reference": "Patient/7d4e3b2a-1c0f-4a5b-9d8e-7f6c5b4a3d2e"}
}'::jsonb),
('obs-002', '{
  "resourceType": "Observation",
  "id": "obs-002",
  "code": {"coding": [{"system": "http://loinc.org", "code": "8867-4", "display": "Frecuencia cardíaca"}]},
  "valueQuantity": {"value": 85, "unit": "bpm"},
  "effectiveDateTime": "2025-06-01T09:46:00Z",
  "subject": {"reference": "Patient/7d4e3b2a-1c0f-4a5b-9d8e-7f6c5b4a3d2e"}
}'::jsonb),
('obs-003', '{
  "resourceType": "Observation",
  "id": "obs-003",
  "code": {"coding": [{"system": "http://loinc.org", "code": "8310-5", "display": "Temperatura corporal"}]},
  "valueQuantity": {"value": 38.5, "unit": "°C"},
  "effectiveDateTime": "2025-06-01T11:05:00Z",
  "subject": {"reference": "Patient/e7f8a9b0-c1d2-4e3f-8a9b-0c1d2e3f4a5b"}
}'::jsonb),
('obs-004', '{
  "resourceType": "Observation",
  "id": "obs-004",
  "code": {"coding": [{"system": "http://loinc.org", "code": "29463-7", "display": "Peso corporal"}]},
  "valueQuantity": {"value": 70, "unit": "kg"},
  "effectiveDateTime": "2025-05-25T09:15:00Z",
  "subject": {"reference": "Patient/d4e5f6a7-b8c9-4d0e-9f1a-b2c3d4e5f6a7"}
}'::jsonb),
('obs-005', '{
  "resourceType": "Observation",
  "id": "obs-005",
  "code": {"coding": [{"system": "http://loinc.org", "code": "8310-5", "display": "Temperatura corporal"}]},
  "valueQuantity": {"value": 37.0, "unit": "°C"},
  "effectiveDateTime": "2025-05-20T14:05:00Z",
  "subject": {"reference": "Patient/a1b2c3d4-e5f6-47g8-9h0i-j1k2l3m4n5o6"}
}'::jsonb);

-- Insert AllergyIntolerances
INSERT INTO allergy_intolerances (id, resource) VALUES
('allergy-001', '{
  "resourceType": "AllergyIntolerance",
  "id": "allergy-001",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "293962007", "display": "Alergia a penicilina"}]},
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "patient": {"reference": "Patient/7d4e3b2a-1c0f-4a5b-9d8e-7f6c5b4a3d2e"}
}'::jsonb),
('allergy-002', '{
  "resourceType": "AllergyIntolerance",
  "id": "allergy-002",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "300916003", "display": "Alergia a mariscos"}]},
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "patient": {"reference": "Patient/a1b2c3d4-e5f6-47g8-9h0i-j1k2l3m4n5o6"}
}'::jsonb),
('allergy-003', '{
  "resourceType": "AllergyIntolerance",
  "id": "allergy-003",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "256259004", "display": "Alergia a ácaros del polvo"}]},
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "patient": {"reference": "Patient/c1d2e3f4-a5b6-4708-9c0d-e1f2a3b4c5d6"}
}'::jsonb),
('allergy-004', '{
  "resourceType": "AllergyIntolerance",
  "id": "allergy-004",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "419511007", "display": "Alergia a látex"}]},
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "patient": {"reference": "Patient/d4e5f6a7-b8c9-4d0e-9f1a-b2c3d4e5f6a7"}
}'::jsonb),
('allergy-005', '{
  "resourceType": "AllergyIntolerance",
  "id": "allergy-005",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "294638003", "display": "Alergia a huevo"}]},
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "patient": {"reference": "Patient/e7f8a9b0-c1d2-4e3f-8a9b-0c1d2e3f4a5b"}
}'::jsonb);

-- Insert MedicationRequests
INSERT INTO medication_requests (id, resource) VALUES
('med-001', '{
  "resourceType": "MedicationRequest",
  "id": "med-001",
  "status": "active",
  "intent": "order",
  "priority": "urgent",
  "authoredOn": "2025-06-01T10:00:00Z",
  "medicationCodeableConcept": {"coding": [{"system": "http://www.nlm.nih.gov/research/umls/rxnorm", "code": "860975", "display": "Losartán"}]},
  "subject": {"reference": "Patient/7d4e3b2a-1c0f-4a5b-9d8e-7f6c5b4a3d2e"},
  "dosageInstruction": [{"text": "50 mg cada 24 horas"}],
  "requester": {"reference": "Practitioner/pract-001"},
  "encounter": {"reference": "Encounter/enc-001"},
  "reasonCode": [{"coding": [{"system": "http://snomed.info/sct", "code": "38341003", "display": "Hipertensión esencial"}]}]
}'::jsonb),
('med-002', '{
  "resourceType": "MedicationRequest",
  "id": "med-002",
  "status": "active",
  "intent": "order",
  "priority": "routine",
  "authoredOn": "2025-05-20T14:30:00Z",
  "medicationCodeableConcept": {"coding": [{"system": "http://www.nlm.nih.gov/research/umls/rxnorm", "code": "860975", "display": "Metformina"}]},
  "subject": {"reference": "Patient/a1b2c3d4-e5f6-47g8-9h0i-j1k2l3m4n5o6"},
  "dosageInstruction": [{"text": "850 mg cada 12 horas con alimentos"}],
  "requester": {"reference": "Practitioner/pract-002"},
  "encounter": {"reference": "Encounter/enc-002"},
  "reasonCode": [{"coding": [{"system": "http://snomed.info/sct", "code": "44054006", "display": "Diabetes mellitus tipo 2"}]}]
}'::jsonb),
('med-003', '{
  "resourceType": "MedicationRequest",
  "id": "med-003",
  "status": "completed",
  "intent": "order",
  "priority": "asap",
  "authoredOn": "2025-06-01T10:20:00Z",
  "medicationCodeableConcept": {"coding": [{"system": "http://www.nlm.nih.gov/research/umls/rxnorm", "code": "860975", "display": "Salbutamol"}]},
  "subject": {"reference": "Patient/c1d2e3f4-a5b6-4708-9c0d-e1f2a3b4c5d6"},
  "dosageInstruction": [{"text": "2 inhalaciones cada 6 horas según necesidad"}],
  "requester": {"reference": "Practitioner/pract-003"},
  "encounter": {"reference": "Encounter/enc-003"},
  "reasonCode": [{"coding": [{"system": "http://snomed.info/sct", "code": "195967001", "display": "Asma persistente"}]}]
}'::jsonb),
('med-004', '{
  "resourceType": "MedicationRequest",
  "id": "med-004",
  "status": "active",
  "intent": "order",
  "priority": "routine",
  "authoredOn": "2025-05-25T09:15:00Z",
  "medicationCodeableConcept": {"coding": [{"system": "http://www.nlm.nih.gov/research/umls/rxnorm", "code": "860975", "display": "Paracetamol"}]},
  "subject": {"reference": "Patient/d4e5f6a7-b8c9-4d0e-9f1a-b2c3d4e5f6a7"},
  "dosageInstruction": [{"text": "500 mg cada 8 horas si hay fiebre"}],
  "requester": {"reference": "Practitioner/pract-004"},
  "encounter": {"reference": "Encounter/enc-004"},
  "reasonCode": [{"coding": [{"system": "http://snomed.info/sct", "code": "386661006", "display": "Infección respiratoria aguda"}]}]
}'::jsonb),
('med-005', '{
  "resourceType": "MedicationRequest",
  "id": "med-005",
  "status": "active",
  "intent": "order",
  "priority": "urgent",
  "authoredOn": "2025-06-01T11:10:00Z",
  "medicationCodeableConcept": {"coding": [{"system": "http://www.nlm.nih.gov/research/umls/rxnorm", "code": "860975", "display": "Omeprazol"}]},
  "subject": {"reference": "Patient/e7f8a9b0-c1d2-4e3f-8a9b-0c1d2e3f4a5b"},
  "dosageInstruction": [{"text": "20 mg cada 24 horas antes del desayuno"}],
  "requester": {"reference": "Practitioner/pract-005"},
  "encounter": {"reference": "Encounter/enc-005"},
  "reasonCode": [{"coding": [{"system": "http://snomed.info/sct", "code": "44054006", "display": "Gastritis"}]}]
}'::jsonb);

-- Insert Conditions
INSERT INTO conditions (id, resource) VALUES
('cond-001', '{
  "resourceType": "Condition",
  "id": "cond-001",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/condition-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "38341003", "display": "Hipertensión esencial"}]},
  "subject": {"reference": "Patient/7d4e3b2a-1c0f-4a5b-9d8e-7f6c5b4a3d2e"},
  "recordedDate": "2023-05-10"
}'::jsonb),
('cond-002', '{
  "resourceType": "Condition",
  "id": "cond-002",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/condition-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "44054006", "display": "Diabetes mellitus tipo 2"}]},
  "subject": {"reference": "Patient/a1b2c3d4-e5f6-47g8-9h0i-j1k2l3m4n5o6"},
  "recordedDate": "2022-11-20"
}'::jsonb),
('cond-003', '{
  "resourceType": "Condition",
  "id": "cond-003",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/condition-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "195967001", "display": "Asma persistente"}]},
  "subject": {"reference": "Patient/c1d2e3f4-a5b6-4708-9c0d-e1f2a3b4c5d6"},
  "recordedDate": "2024-01-15"
}'::jsonb),
('cond-004', '{
  "resourceType": "Condition",
  "id": "cond-004",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/condition-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "386661006", "display": "Infección respiratoria aguda"}]},
  "subject": {"reference": "Patient/d4e5f6a7-b8c9-4d0e-9f1a-b2c3d4e5f6a7"},
  "recordedDate": "2025-05-25"
}'::jsonb),
('cond-005', '{
  "resourceType": "Condition",
  "id": "cond-005",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/condition-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "29427007", "display": "Alergia a penicilina"}]},
  "subject": {"reference": "Patient/e7f8a9b0-c1d2-4e3f-8a9b-0c1d2e3f4a5b"},
  "recordedDate": "2023-12-01"
}'::jsonb);
