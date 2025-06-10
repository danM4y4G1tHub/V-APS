-- 1. Patient
INSERT INTO patients (id, resource) VALUES
('bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a',
'{
  "resourceType": "Patient",
  "id": "bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a",
  "identifier": [{"system": "http://minsap.cu/ci", "value": "92020254321"}],
  "active": true,
  "name": [{"use": "official", "family": "Rodríguez", "given": ["María", "Elena"]}],
  "telecom": [{"system": "phone", "value": "+5355512345", "use": "work"}],
  "gender": "female",
  "birthDate": "1992-02-02",
  "address": [{
    "use": "home",
    "type": "both",
    "line": ["Calle 23 #456"],
    "city": "La Habana",
    "state": "La Habana",
    "postalCode": "10400",
    "country": "Cuba",
    "location": "Location/0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a"
  }],
  "maritalStatus": {"coding": [{"code": "M", "display": "Casada"}]},
  "contact": [{
    "relationship": [{
      "coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0131","code": "C"}],
      "name": {"use": "usual", "family": "Vazques", "given": ["Juan Pablo"]},
      "telecom": [{"system": "phone", "value": "+5358337269"}]
    }]
  }],
  "generalPractitioner": "Practitioner/12345678-1234-1234-1234-123456789abc"
}'::jsonb);

-- 2. Practitioner
INSERT INTO practitioners (id, resource) VALUES
('12345678-1234-1234-1234-123456789abc',
'{
  "resourceType": "Practitioner",
  "id": "12345678-1234-1234-1234-123456789abc",
  "identifier": [{"system": "http://minsap.cu/licencia", "value": "DOC123"}],
  "active": true,
  "name": [{"use": "official", "family": "López", "given": ["Ana"]}],
  "telecom": [{"system": "phone", "value": "+5355512345"}],
  "gender": "female",
  "address": [{
    "use": "work",
    "type": "physical",
    "line": ["Calle 4 #102"],
    "city": "La Habana",
    "state": "La Habana",
    "postalCode": "10400",
    "country": "Cuba",
    "location": "Location/0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a"
  }],
  "qualification": [{
    "identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT-456"}],
    "code": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7",
        "code": "MD",
        "display": "Doctor of Medicine"
      }],
      "text": "Doctor en Medicina"
    },
    "status": {"coding": [{"code": "active", "display": "Active"}]},
    "period": {"start": "2010-01-01", "end": null},
    "issuer": {"reference": "Organization/0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a"}
  }]
}'::jsonb);

-- 3. Encounter
INSERT INTO encounters (id, resource) VALUES
('8f9a0b1c-2d3e-4f5a-6b7c-8d9e0f1a2b3c',
'{
  "resourceType": "Encounter",
  "id": "8f9a0b1c-2d3e-4f5a-6b7c-8d9e0f1a2b3c",
  "status": "finished",
  "classfhir": [{"code": "AMB"}],
  "type": [{"coding": [{"system": "http://snomed.info/sct", "code": "185349003", "display": "Consulta de control"}]}],
  "subject": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "period": {"start": "2023-10-05T08:00:00Z", "end": "2023-10-05T08:30:00Z"},
  "participant": [{
    "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PPRF", "display": "primary performer"}]}],
    "period": {"start": "2023-10-05T08:00:00Z", "end": "2023-10-05T08:30:00Z"},
    "individual": {"reference": "Practitioner/12345678-1234-1234-1234-123456789abc", "display": "Dra. Ana López"}
  }],
  "appointment": [{"reference": "Appointment/2b3c4d5e-6f7a-8b9c-0d1e-2f3a4b5c6d7e"}],
  "reason": [{"value": [{"concept": {"text": "El paciente ha sufrido de una crisis diabética"}}]}],
  "diagnosis": [{"condition": [{"reference": {"reference": "Condition/6d7e8f9a-1b2c-3d4e-5f6a-7b8c9d0e1f2a"}}]}]
}'::jsonb);

-- 4. Condition
INSERT INTO conditions (id, resource) VALUES
('6d7e8f9a-1b2c-3d4e-5f6a-7b8c9d0e1f2a',
'{
  "resourceType": "Condition",
  "id": "6d7e8f9a-1b2c-3d4e-5f6a-7b8c9d0e1f2a",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/condition-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "44054006", "display": "Diabetes mellitus tipo 2"}]},
  "subject": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "encounter": {"reference": "Encounter/8f9a0b1c-2d3e-4f5a-6b7c-8d9e0f1a2b3c"},
  "recordedDate": "2023-05-15T14:30:00Z",
  "participant": [{
    "function": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type", "code": "enterer", "display": "Enterer"}]},
    "actor": {"reference": "Practitioner/12345678-1234-1234-1234-123456789abc"}
  }]
}'::jsonb);

-- 5. Appointment
INSERT INTO appointments (id, resource) VALUES
('2b3c4d5e-6f7a-8b9c-0d1e-2f3a4b5c6d7e',
'{
  "resourceType": "Appointment",
  "id": "2b3c4d5e-6f7a-8b9c-0d1e-2f3a4b5c6d7e",
  "status": "booked",
  "start": "2025-06-20T09:00:00Z",
  "participant": [
    {"actor": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a", "display": "María Elena"}, "status": "accepted"},
    {"actor": {"reference": "Practitioner/12345678-1234-1234-1234-123456789abc", "display": "Dra. Ana López"}, "status": "accepted"}
  ],
  "description": "Consulta de control de diabetes"
}'::jsonb);

-- 6. MedicationRequest
INSERT INTO medication_requests (id, resource) VALUES
('b2c3d4e5-f6a7-8b9c-0d1e-2f3a4b5c6d7e',
'{
  "resourceType": "MedicationRequest",
  "id": "b2c3d4e5-f6a7-8b9c-0d1e-2f3a4b5c6d7e",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/654321987", "display": "Heberprot-P 0.6mg"},
  "subject": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "dosageInstruction": [{"text": "Aplicar semanalmente en lesión"}]
}'::jsonb);

-- 7. AllergyIntolerance
INSERT INTO allergy_intolerances (id, resource) VALUES
('b2c3d4e5-f6a7-8b9c-0d1e-2f3a4b5c6d7e',
'{
  "resourceType": "AllergyIntolerance",
  "id": "b2c3d4e5-f6a7-8b9c-0d1e-2f3a4b5c6d7e",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "91930004", "display": "Penicilina"}]},
  "patient": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "criticality": "high"
}'::jsonb);

-- 8. ServiceRequest
INSERT INTO service_requests (id, resource) VALUES
('f6a7b8c9-d0e1-2f3a-4b5c-6d7e8f9a0b1c',
'{
  "resourceType": "ServiceRequest",
  "id": "f6a7b8c9-d0e1-2f3a-4b5c-6d7e8f9a0b1c",
  "status": "active",
  "intent": "order",
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "3457005", "display": "Remisión a endocrinología"}]},
  "subject": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "occurrenceDateTime": "2023-10-11T10:30:00Z",
  "requester": {"reference": "Practitioner/12345678-1234-1234-1234-123456789abc"}
}'::jsonb);

-- 9. CarePlan
INSERT INTO care_plans (id, resource) VALUES
('2d3e4f5a-6b7c-8d9e-0f1a-2b3c4d5e6f7a',
'{
  "resourceType": "CarePlan",
  "id": "2d3e4f5a-6b7c-8d9e-0f1a-2b3c4d5e6f7a",
  "status": "active",
  "intent": "plan",
  "subject": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "period": {"start": "2023-10-01", "end": "2024-10-01"}
}'::jsonb);

-- 10. Immunization
INSERT INTO immunizations (id, resource) VALUES
('5a6b7c8d-9e0f-1a2b-3c4d-5e6f7a8b9c0d',
'{
  "resourceType": "Immunization",
  "id": "5a6b7c8d-9e0f-1a2b-3c4d-5e6f7a8b9c0d",
  "status": "completed",
  "vaccineCode": {"coding": [{"system": "http://hl7.org/fhir/sid/cvx", "code": "207", "display": "COVID-19, Abdala"}]},
  "patient": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "occurrenceDateTime": "2021-08-15T10:00:00Z"
}'::jsonb);

-- 11. Specimen
INSERT INTO specimens (id, resource) VALUES
('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3a4b5c6d',
'{
  "resourceType": "Specimen",
  "id": "1a2b3c4d-5e6f-7a8b-9c0d-1e2f3a4b5c6d",
  "status": "available",
  "type": {"coding": [{"system": "http://snomed.info/sct", "code": "122555007", "display": "Sangre venosa"}]},
  "subject": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "collection": {"collectedDateTime": "2023-10-05T10:00:00Z"}
}'::jsonb);

-- 12. Observation (Paciente)
INSERT INTO observations (id, resource) VALUES
('9f8e7d6c-5b4a-3c2d-1e0f-9a8b7c6d5e4f',
'{
  "resourceType": "Observation",
  "id": "obs-clin-001",
  "status": "final",
  "code": {"coding": [{"system": "http://loinc.org", "code": "15074-8", "display": "Glucosa en sangre"}]},
  "subject": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "effectiveDateTime": {"value": "2023-10-05T08:30:00Z"},
  "valueQuantity": {"value": 5.6, "unit": "mmol/L"}
}'::jsonb);

-- 13. Observation (Comunidad)
INSERT INTO observations (id, resource) VALUES
('d4e5f6a7-b8c9-0d1e-2f3a-4b5c6d7e8f9a',
'{
  "resourceType": "Observation",
  "id": "obs-com-001",
  "context": {"reference": "Location/0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a"},
  "code": {"coding": [{"code": "cleanliness-score", "display": "Cleanliness Score"}]},
  "valueQuantity": {"value": 8, "unit": "score"}
}'::jsonb);

-- 14. RelatedPerson
INSERT INTO related_persons (id, resource) VALUES
('4d5e6f7a-8b9c-0d1e-2f3a-4b5c6d7e8f9a',
'{
  "resourceType": "RelatedPerson",
  "id": "4d5e6f7a-8b9c-0d1e-2f3a-4b5c6d7e8f9a",
  "patient": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "code": "H", "display": "Hija"}]}],
  "name": [{"family": "Rodríguez", "given": ["Laura"]}],
  "telecom": [{"system": "phone", "value": "+5355511111"}]
}'::jsonb);

-- 15. ImmunizationRecommendation
INSERT INTO immunization_recommendations (id, resource) VALUES
('1f8c4a2b-3b5d-4c6e-8e8d-1b2c3d4e5f6a',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "1f8c4a2b-3b5d-4c6e-8e8d-1b2c3d4e5f6a",
  "patient": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "recommendation": [{
    "vaccineCode": [{"system": "http://hl7.org/fhir/sid/cvx", "code": "08", "display": "Hepatitis B"}],
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status","code": "due","display": "Dose is due"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2025-07-01T00:00:00Z"
    }],
    "doseNumberPositiveInt": 3
  }]
}'::jsonb);

-- 16. Organization
INSERT INTO organizations (id, resource) VALUES
('0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a',
'{
  "resourceType": "Organization",
  "id": "0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a",
  "name": "Centro de Ingeniería Genética y Biotecnología",
  "address": [{"line": ["Ave. 31 entre 158 y 190"], "city": "La Habana"}]
}'::jsonb);

-- 17. Location
INSERT INTO locations (id, resource) VALUES
('0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a',
'{
  "resourceType": "Location",
  "id": "0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a",
  "status": "active",
  "name": "Consultorio Médico #5",
  "identifier": [{"value": "cdr-001"}],
  "address": {"line": ["Calle 12 #345"], "city": "La Habana", "state": "La Habana", "postalCode": "10400"}
}'::jsonb);
