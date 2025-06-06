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
}'::jsonb);

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
}'::jsonb);

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
}'::jsonb);

INSERT INTO encounters (id, resource) VALUES
('1f2a3b4c-5d6e-7f8a-9b0c-1d2e3f4a5b6c', '{
  "resourceType": "Encounter",
  "id": "1f2a3b4c-5d6e-7f8a-9b0c-1d2e3f4a5b6c",
  "status": "in-progress",
  "class": {"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "EMER", "display": "Emergency"},
  "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "EMER", "display": "Emergency"}]}],
  "subject": {"reference": "Patient/7e1b2c3d-4f5a-6b7c-8d9e-0f1a2b3c4d5e"},
  "period": {"start": "2025-06-01T09:30:00Z"},
  "participant": [{"individual": {"reference": "Practitioner/e1f2a3b4-c5d6-7890-1abc-def234567890"}}],
  "reasonCode": [{"text": "Dolor torácico"}]
}'::jsonb),
('2a3b4c5d-6e7f-8a9b-0c1d-2e3f4a5b6c7d', '{
  "resourceType": "Encounter",
  "id": "2a3b4c5d-6e7f-8a9b-0c1d-2e3f4a5b6c7d",
  "status": "finished",
  "class": {"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "AMB", "display": "Ambulatory"},
  "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "AMB", "display": "Ambulatory"}]}],
  "subject": {"reference": "Patient/8f2c3d4e-5a6b-7c8d-9e0f-1a2b3c4d5e6f"},
  "period": {"start": "2025-05-20T14:00:00Z", "end": "2025-05-20T15:00:00Z"},
  "participant": [{"individual": {"reference": "Practitioner/f2a3b4c5-d6e7-8901-2bcd-ef3456789012"}}],
  "reasonCode": [{"text": "Control de diabetes"}]
}'::jsonb),
('3b4c5d6e-7f8a-9b0c-1d2e-3f4a5b6c7d8e', '{
  "resourceType": "Encounter",
  "id": "3b4c5d6e-7f8a-9b0c-1d2e-3f4a5b6c7d8e",
  "status": "in-progress",
  "class": {"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "EMER", "display": "Emergency"},
  "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ActCode", "code": "EMER", "display": "Emergency"}]}],
  "subject": {"reference": "Patient/9a3d4e5f-6b7c-8d9e-0f1a-2b3c4d5e6f7a"},
  "period": {"start": "2025-06-01T10:15:00Z"},
  "participant": [{"individual": {"reference": "Practitioner/a3b4c5d6-e7f8-9012-3cde-f45678901234"}}],
  "reasonCode": [{"text": "Dificultad respiratoria"}]
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
}'::jsonb);

INSERT INTO care_teams (id, resource) VALUES
('a7b8c9d0-e1f2-3a4b-5c6d-7e8f90123456', '{
  "resourceType": "CareTeam",
  "id": "a7b8c9d0-e1f2-3a4b-5c6d-7e8f90123456",
  "participant": [
    {"member": {"reference": "Practitioner/e1f2a3b4-c5d6-7890-1abc-def234567890"}},
    {"member": {"reference": "Practitioner/f2a3b4c5-d6e7-8901-2bcd-ef3456789012"}}
  ],
  "subject": {"reference": "Patient/7e1b2c3d-4f5a-6b7c-8d9e-0f1a2b3c4d5e"}
}'::jsonb),
('b8c9d0e1-f2a3-4b5c-6d7e-8f9012345678', '{
  "resourceType": "CareTeam",
  "id": "b8c9d0e1-f2a3-4b5c-6d7e-8f9012345678",
  "participant": [
    {"member": {"reference": "Practitioner/a3b4c5d6-e7f8-9012-3cde-f45678901234"}}
  ],
  "subject": {"reference": "Patient/8f2c3d4e-5a6b-7c8d-9e0f-1a2b3c4d5e6f"}
}'::jsonb),
('c9d0e1f2-a3b4-5c6d-7e8f-90123456789a', '{
  "resourceType": "CareTeam",
  "id": "c9d0e1f2-a3b4-5c6d-7e8f-90123456789a",
  "participant": [
    {"member": {"reference": "Practitioner/e1f2a3b4-c5d6-7890-1abc-def234567890"}},
    {"member": {"reference": "Practitioner/a3b4c5d6-e7f8-9012-3cde-f45678901234"}}
  ],
  "subject": {"reference": "Patient/9a3d4e5f-6b7c-8d9e-0f1a-2b3c4d5e6f7a"}
}'::jsonb);

INSERT INTO organizations (id, resource) VALUES
('d0e1f2a3-b4c5-6d7e-8f90-123456789abc', '{
  "resourceType": "Organization",
  "id": "d0e1f2a3-b4c5-6d7e-8f90-123456789abc",
  "name": "Policlínico Vedado",
  "identifier": [{"system": "http://salud.cu/centros", "value": "ORG001"}],
  "address": [{"line": ["Calle 23 #100"], "city": "La Habana", "country": "Cuba"}],
  "telecom": [{"system": "phone", "value": "+53 55500001"}]
}'::jsonb),
('e1f2a3b4-c5d6-7e8f-9012-3456789abcde', '{
  "resourceType": "Organization",
  "id": "e1f2a3b4-c5d6-7e8f-9012-3456789abcde",
  "name": "Hospital Provincial Santiago",
  "identifier": [{"system": "http://salud.cu/centros", "value": "ORG002"}],
  "address": [{"line": ["Avenida Garzón #200"], "city": "Santiago de Cuba", "country": "Cuba"}],
  "telecom": [{"system": "phone", "value": "+53 55500002"}]
}'::jsonb),
('f2a3b4c5-d6e7-8f90-1234-56789abcdef0', '{
  "resourceType": "Organization",
  "id": "f2a3b4c5-d6e7-8f90-1234-56789abcdef0",
  "name": "Centro de Salud Camagüey",
  "identifier": [{"system": "http://salud.cu/centros", "value": "ORG003"}],
  "address": [{"line": ["Calle Independencia #50"], "city": "Camagüey", "country": "Cuba"}],
  "telecom": [{"system": "phone", "value": "+53 55500003"}]
}'::jsonb);

INSERT INTO locations (id, resource) VALUES
('a1b2c3d4-e5f6-7a8b-9c0d-1e2f3a4b5c6d', '{
  "resourceType": "Location",
  "id": "a1b2c3d4-e5f6-7a8b-9c0d-1e2f3a4b5c6d",
  "name": "Consultorio 1",
  "address": {"line": ["Calle 12 #45"], "city": "La Habana", "country": "Cuba"},
  "managingOrganization": {"reference": "Organization/d0e1f2a3-b4c5-6d7e-8f90-123456789abc"}
}'::jsonb),
('b2c3d4e5-f6a7-8b9c-0d1e-2f3a4b5c6d7e', '{
  "resourceType": "Location",
  "id": "b2c3d4e5-f6a7-8b9c-0d1e-2f3a4b5c6d7e",
  "name": "Sala de Emergencias",
  "address": {"line": ["Avenida Garzón #200"], "city": "Santiago de Cuba", "country": "Cuba"},
  "managingOrganization": {"reference": "Organization/e1f2a3b4-c5d6-7e8f-9012-3456789abcde"}
}'::jsonb),
('c3d4e5f6-a7b8-9c0d-1e2f-3a4b5c6d7e8f', '{
  "resourceType": "Location",
  "id": "c3d4e5f6-a7b8-9c0d-1e2f-3a4b5c6d7e8f",
  "name": "Laboratorio Central",
  "address": {"line": ["Calle Independencia #50"], "city": "Camagüey", "country": "Cuba"},
  "managingOrganization": {"reference": "Organization/f2a3b4c5-d6e7-8f90-1234-56789abcdef0"}
}'::jsonb);

INSERT INTO procedures (id, resource) VALUES
('d1e2f3a4-b5c6-7d8e-9f01-23456789abcd', '{
  "resourceType": "Procedure",
  "id": "d1e2f3a4-b5c6-7d8e-9f01-23456789abcd",
  "status": "completed",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "80146002", "display": "Electrocardiograma"}]},
  "subject": {"reference": "Patient/7e1b2c3d-4f5a-6b7c-8d9e-0f1a2b3c4d5e"},
  "performedDateTime": "2025-06-01T10:00:00Z",
  "performer": [{"actor": {"reference": "Practitioner/e1f2a3b4-c5d6-7890-1abc-def234567890"}}],
  "location": {"reference": "Location/a1b2c3d4-e5f6-7a8b-9c0d-1e2f3a4b5c6d"}
}'::jsonb),
('e2f3a4b5-c6d7-8e9f-0123-456789abcde0', '{
  "resourceType": "Procedure",
  "id": "e2f3a4b5-c6d7-8e9f-0123-456789abcde0",
  "status": "completed",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "386637004", "display": "Nebulización"}]},
  "subject": {"reference": "Patient/8f2c3d4e-5a6b-7c8d-9e0f-1a2b3c4d5e6f"},
  "performedDateTime": "2025-05-20T14:30:00Z",
  "performer": [{"actor": {"reference": "Practitioner/f2a3b4c5-d6e7-8901-2bcd-ef3456789012"}}],
  "location": {"reference": "Location/b2c3d4e5-f6a7-8b9c-0d1e-2f3a4b5c6d7e"}
}'::jsonb),
('f3a4b5c6-d7e8-9f01-2345-6789abcdef01', '{
  "resourceType": "Procedure",
  "id": "f3a4b5c6-d7e8-9f01-2345-6789abcdef01",
  "status": "completed",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "710081004", "display": "Monitoreo de glucosa en sangre"}]},
  "subject": {"reference": "Patient/9a3d4e5f-6b7c-8d9e-0f1a-2b3c4d5e6f7a"},
  "performedDateTime": "2025-06-01T11:00:00Z",
  "performer": [{"actor": {"reference": "Practitioner/a3b4c5d6-e7f8-9012-3cde-f45678901234"}}],
  "location": {"reference": "Location/c3d4e5f6-a7b8-9c0d-1e2f-3a4b5c6d7e8f"}
}'::jsonb);

INSERT INTO immunizations (id, resource) VALUES
('a5b6c7d8-e9f0-1234-5678-9abcdef01234', '{
  "resourceType": "Immunization",
  "id": "a5b6c7d8-e9f0-1234-5678-9abcdef01234",
  "status": "completed",
  "vaccineCode": {"coding": [{"system": "http://hl7.org/fhir/sid/cvx", "code": "140", "display": "Influenza, seasonal"}]},
  "patient": {"reference": "Patient/7e1b2c3d-4f5a-6b7c-8d9e-0f1a2b3c4d5e"},
  "occurrenceDateTime": "2025-01-15T08:30:00Z",
  "location": {"reference": "Location/a1b2c3d4-e5f6-7a8b-9c0d-1e2f3a4b5c6d"}
}'::jsonb),
('b6c7d8e9-f012-3456-789a-bcdef0123456', '{
  "resourceType": "Immunization",
  "id": "b6c7d8e9-f012-3456-789a-bcdef0123456",
  "status": "completed",
  "vaccineCode": {"coding": [{"system": "http://hl7.org/fhir/sid/cvx", "code": "21", "display": "Varicela"}]},
  "patient": {"reference": "Patient/8f2c3d4e-5a6b-7c8d-9e0f-1a2b3c4d5e6f"},
  "occurrenceDateTime": "2025-02-10T09:00:00Z",
  "location": {"reference": "Location/b2c3d4e5-f6a7-8b9c-0d1e-2f3a4b5c6d7e"}
}'::jsonb),
('c7d8e9f0-1234-5678-9abc-def012345678', '{
  "resourceType": "Immunization",
  "id": "c7d8e9f0-1234-5678-9abc-def012345678",
  "status": "completed",
  "vaccineCode": {"coding": [{"system": "http://hl7.org/fhir/sid/cvx", "code": "10", "display": "Polio"}]},
  "patient": {"reference": "Patient/9a3d4e5f-6b7c-8d9e-0f1a-2b3c4d5e6f7a"},
  "occurrenceDateTime": "2025-03-20T10:00:00Z",
  "location": {"reference": "Location/c3d4e5f6-a7b8-9c0d-1e2f-3a4b5c6d7e8f"}
}'::jsonb);
