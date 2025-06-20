-- 1. Patient(24) ✔
INSERT INTO patients (id, resource) VALUES
('bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a',
'{
  "resourceType": "Patient",
  "id": "bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a",
  "identifier": [{"system": "http://minsap.cu/ci", "value": "92020254321"}],
  "active": true,
  "name": [{"use": "official", "family": "Rodríguez", "given": ["María", "Elena"]}],
  "telecom": [{
  "use": "work"
  },
  {"system": "phone", "value": "+5355512345"}],
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
    "location": {"reference": "Location/0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a"}
  }],
  "maritalStatus": {"coding": [{"code": "M", "display": "Casada"}]},
  "contact": [{
    "relationship": [{
      "coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0131","code": "C"}]
    }],
    "name": {"use": "usual", "family": "Vazques", "given": ["Juan Pablo"]},
    "telecom": [{"system": "phone", "value": "+5358337269"}]
  }],
  "generalPractitioner": [{"reference": "Practitioner/12345678-1234-1234-1234-123456789abc"}]
}'::jsonb),
('c1d2e3f4-5678-90ab-cdef-1234567890ab',
'{
  "resourceType": "Patient",
  "id": "c1d2e3f4-5678-90ab-cdef-1234567890ab",
  "identifier": [{"system": "http://minsap.cu/ci", "value": "83010112345"}],
  "active": true,
  "name": [{"use": "official", "family": "Pérez", "given": ["Luis", "Alberto"]}],
  "gender": "male",
  "birthDate": "1983-01-01",
  "address": [{
    "use": "home",
    "line": ["Carretera Central km 5"],
    "city": "Pinar del Río",
    "state": "Pinar del Río",
    "postalCode": "20100",
    "country": "Cuba"
  }],
  "maritalStatus": {"coding": [{"code": "S", "display": "Soltero"}]},
  "contact": [{
    "relationship": [{
      "coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0131","code": "E"}]
    }],
    "name": {"use": "usual", "family": "Pérez", "given": ["Raúl"]},
    "telecom": [{"system": "phone", "value": "+5355543344"}]
  }]
}'::jsonb),
('d5e6f7a8-1234-4567-89ab-cdef12345678',
'{
  "resourceType": "Patient",
  "id": "d5e6f7a8-1234-4567-89ab-cdef12345678",
  "identifier": [{"system": "http://minsap.cu/ci", "value": "71050567891"}],
  "active": true,
  "name": [{"use": "official", "family": "González", "given": ["Ana", "Lucía"]}],
  "gender": "female",
  "birthDate": "1971-05-05",
  "address": [{
    "use": "home",
    "line": ["Ave. Garzón 123"],
    "city": "Santiago de Cuba",
    "state": "Santiago de Cuba",
    "postalCode": "90100",
    "country": "Cuba"
  }],
  "maritalStatus": {"coding": [{"code": "M", "display": "Casada"}]},
  "generalPractitioner": [{"reference": "Practitioner/65432109-abcd-4321-abcd-9876543210ff"}]
}'::jsonb),
('f8a9b0c1-2222-3333-4444-555566667777',
'{
  "resourceType": "Patient",
  "id": "f8a9b0c1-2222-3333-4444-555566667777",
  "identifier": [{"system": "http://minsap.cu/ci", "value": "10040878912"}],
  "active": true,
  "name": [{"use": "official", "family": "Suárez", "given": ["Carlos", "Eduardo"]}],
  "gender": "male",
  "birthDate": "2010-04-08",
  "address": [{
    "use": "home",
    "type": "both",
    "line": ["Calle Independencia #33"],
    "city": "Camagüey",
    "state": "Camagüey",
    "postalCode": "70100",
    "country": "Cuba"
  }],
  "contact": [{
    "relationship": [{
      "coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0131","code": "N"}]
    }],
    "name": {"use": "official", "family": "Suárez", "given": ["Rosa"]},
    "telecom": [{"system": "phone", "value": "+5358245698"}]
  }]
}'::jsonb),
('01a2b3c4-d5e6-7890-abcd-ef1234567890',
'{
  "resourceType": "Patient",
  "id": "01a2b3c4-d5e6-7890-abcd-ef1234567890",
  "identifier": [{"system": "http://minsap.cu/ci", "value": "65020234567"}],
  "active": true,
  "name": [{"use": "official", "family": "Hernández", "given": ["María", "Isabel"]}],
  "gender": "female",
  "birthDate": "1965-02-02",
  "address": [{
    "use": "home",
    "line": ["Calle 10 #123"],
    "city": "Matanzas",
    "state": "Matanzas",
    "postalCode": "40100",
    "country": "Cuba"
  }],
  "maritalStatus": {"coding": [{"code": "M", "display": "Casada"}]},
  "contact": [{
    "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0131","code": "S"}]}],
    "name": {"use": "usual", "family": "Hernández", "given": ["José"]},
    "telecom": [{"system": "phone", "value": "+5355123456"}]
  }]
}'::jsonb),
('02b3c4d5-e6f7-890a-bcde-f12345678901',
'{
  "resourceType": "Patient",
  "id": "02b3c4d5-e6f7-890a-bcde-f12345678901",
  "identifier": [{"system": "http://minsap.cu/ci", "value": "72010123456"}],
  "active": true,
  "name": [{"use": "official", "family": "Ramírez", "given": ["Luis"]}],
  "gender": "male",
  "birthDate": "1972-01-01",
  "address": [{
    "use": "home",
    "line": ["Ave. 3ra #456"],
    "city": "Cienfuegos",
    "state": "Cienfuegos",
    "postalCode": "55100",
    "country": "Cuba"
  }],
  "maritalStatus": {"coding": [{"code": "S", "display": "Soltero"}]},
  "contact": [{
    "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0131","code": "E"}]}],
    "name": {"use": "usual", "family": "Ramírez", "given": ["Ana"]},
    "telecom": [{"system": "phone", "value": "+5355987654"}]
  }]
}'::jsonb),
('03c4d5e6-f7a8-9012-bcde-f23456789012',
'{
  "resourceType": "Patient",
  "id": "03c4d5e6-f7a8-9012-bcde-f23456789012",
  "identifier": [{"system": "http://minsap.cu/ci", "value": "81030345678"}],
  "active": true,
  "name": [{"use": "official", "family": "Gómez", "given": ["Ana", "Lucía"]}],
  "gender": "female",
  "birthDate": "1981-03-03",
  "address": [{
    "use": "home",
    "line": ["Calle 7 #789"],
    "city": "Holguín",
    "state": "Holguín",
    "postalCode": "80100",
    "country": "Cuba"
  }],
  "maritalStatus": {"coding": [{"code": "D", "display": "Divorciada"}]},
  "contact": [{
    "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0131","code": "C"}]}],
    "name": {"use": "usual", "family": "Gómez", "given": ["Carlos"]},
    "telecom": [{"system": "phone", "value": "+5355778899"}]
  }]
}'::jsonb),
('04d5e6f7-a8b9-0123-cdef-345678901234',
'{
  "resourceType": "Patient",
  "id": "04d5e6f7-a8b9-0123-cdef-345678901234",
  "identifier": [{"system": "http://minsap.cu/ci", "value": "90040456789"}],
  "active": true,
  "name": [{"use": "official", "family": "Santos", "given": ["Carlos"]}],
  "gender": "male",
  "birthDate": "1990-04-04",
  "address": [{
    "use": "home",
    "line": ["Ave. 1ra #234"],
    "city": "Las Tunas",
    "state": "Las Tunas",
    "postalCode": "75100",
    "country": "Cuba"
  }],
  "maritalStatus": {"coding": [{"code": "S", "display": "Soltero"}]},
  "contact": [{
    "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0131","code": "F"}]}],
    "name": {"use": "usual", "family": "Santos", "given": ["María"]},
    "telecom": [{"system": "phone", "value": "+5355332211"}]
  }]
}'::jsonb),
('05e6f7a8-b9c0-1234-def0-567890123456',
'{
  "resourceType": "Patient",
  "id": "05e6f7a8-b9c0-1234-def0-567890123456",
  "identifier": [{"system": "http://minsap.cu/ci", "value": "95050567890"}],
  "active": true,
  "name": [{"use": "official", "family": "Morales", "given": ["Lucía"]}],
  "gender": "female",
  "birthDate": "1995-05-05",
  "address": [{
    "use": "home",
    "line": ["Calle 12 #567"],
    "city": "Guantánamo",
    "state": "Guantánamo",
    "postalCode": "95100",
    "country": "Cuba"
  }],
  "maritalStatus": {"coding": [{"code": "S", "display": "Soltera"}]},
  "contact": [{
    "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0131","code": "M"}]}],
    "name": {"use": "usual", "family": "Morales", "given": ["José"]},
    "telecom": [{"system": "phone", "value": "+5355778890"}]
  }]
}'::jsonb),
('06f7a8b9-c0d1-2345-ef01-678901234567',
'{
  "resourceType": "Patient",
  "id": "06f7a8b9-c0d1-2345-ef01-678901234567",
  "identifier": [{"system": "http://minsap.cu/ci", "value": "82060678901"}],
  "active": true,
  "name": [{"use": "official", "family": "Fernández", "given": ["Jorge"]}],
  "gender": "male",
  "birthDate": "1982-06-06",
  "address": [{
    "use": "home",
    "line": ["Calle 15 #890"],
    "city": "Villa Clara",
    "state": "Villa Clara",
    "postalCode": "50100",
    "country": "Cuba"
  }],
  "maritalStatus": {"coding": [{"code": "M", "display": "Casado"}]},
  "contact": [{
    "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0131","code": "E"}]}],
    "name": {"use": "usual", "family": "Fernández", "given": ["Marta"]},
    "telecom": [{"system": "phone", "value": "+5355991234"}]
  }]
}'::jsonb),
('07a8b9c0-d1e2-3456-f012-789012345678',
'{
  "resourceType": "Patient",
  "id": "07a8b9c0-d1e2-3456-f012-789012345678",
  "identifier": [{"system": "http://minsap.cu/ci", "value": "76070789012"}],
  "active": true,
  "name": [{"use": "official", "family": "Rodríguez", "given": ["Ana"]}],
  "gender": "female",
  "birthDate": "1976-07-07",
  "address": [{
    "use": "home",
    "line": ["Ave. Central #345"],
    "city": "Ciego de Ávila",
    "state": "Ciego de Ávila",
    "postalCode": "60300",
    "country": "Cuba"
  }],
  "maritalStatus": {"coding": [{"code": "D", "display": "Divorciada"}]},
  "contact": [{
    "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0131","code": "S"}]}],
    "name": {"use": "usual", "family": "Rodríguez", "given": ["Carlos"]},
    "telecom": [{"system": "phone", "value": "+5355445566"}]
  }]
}'::jsonb),
('08b9c0d1-e2f3-4567-0123-890123456789',
'{
  "resourceType": "Patient",
  "id": "08b9c0d1-e2f3-4567-0123-890123456789",
  "identifier": [{"system": "http://minsap.cu/ci", "value": "84080890123"}],
  "active": true,
  "name": [{"use": "official", "family": "Sánchez", "given": ["Luis"]}],
  "gender": "male",
  "birthDate": "1984-08-08",
  "address": [{
    "use": "home",
    "line": ["Calle 20 #678"],
    "city": "Artemisa",
    "state": "Artemisa",
    "postalCode": "12400",
    "country": "Cuba"
  }],
  "maritalStatus": {"coding": [{"code": "S", "display": "Soltero"}]},
  "contact": [{
    "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0131","code": "F"}]}],
    "name": {"use": "usual", "family": "Sánchez", "given": ["Marta"]},
    "telecom": [{"system": "phone", "value": "+5355112233"}]
  }]
}'::jsonb),
('09c0d1e2-f345-6789-0123-901234567890',
'{
  "resourceType": "Patient",
  "id": "09c0d1e2-f345-6789-0123-901234567890",
  "identifier": [{"system": "http://minsap.cu/ci", "value": "90090901234"}],
  "active": true,
  "name": [{"use": "official", "family": "Vega", "given": ["María"]}],
  "gender": "female",
  "birthDate": "1990-09-09",
  "address": [{
    "use": "home",
    "line": ["Ave. 7ma #123"],
    "city": "Mayabeque",
    "state": "Mayabeque",
    "postalCode": "18800",
    "country": "Cuba"
  }],
  "maritalStatus": {"coding": [{"code": "S", "display": "Soltera"}]},
  "contact": [{
    "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0131","code": "M"}]}],
    "name": {"use": "usual", "family": "Vega", "given": ["José"]},
    "telecom": [{"system": "phone", "value": "+5355993344"}]
  }]
}'::jsonb),
('10d1e2f3-4567-8901-2345-012345678901',
'{
  "resourceType": "Patient",
  "id": "10d1e2f3-4567-8901-2345-012345678901",
  "identifier": [{"system": "http://minsap.cu/ci", "value": "91010123456"}],
  "active": true,
  "name": [{"use": "official", "family": "Mora", "given": ["Carlos"]}],
  "gender": "male",
  "birthDate": "1991-01-01",
  "address": [{
    "use": "home",
    "line": ["Calle 3 #456"],
    "city": "Granma",
    "state": "Granma",
    "postalCode": "85100",
    "country": "Cuba"
  }],
  "maritalStatus": {"coding": [{"code": "S", "display": "Soltero"}]},
  "contact": [{
    "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0131","code": "E"}]}],
    "name": {"use": "usual", "family": "Mora", "given": ["Ana"]},
    "telecom": [{"system": "phone", "value": "+5355123344"}]
  }]
}'::jsonb);

-- 2. Practitioner(33) ✔
INSERT INTO practitioners (id, resource) VALUES
('12345678-1234-1234-1234-123456789abc',
'{
  "resourceType": "Practitioner",
  "id": "12345678-1234-1234-1234-123456789abc",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC123"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "López",
    "given": ["Ana"]}],
    "telecom": [{
      "system": "phone", "value": "+5355512345"
    }],
    "gender": "female",
    "birthDate": "1985-04-12",
    "address": [{
      "use": "work",
      "type": "physical",
      "line": ["Calle 4 #102"],
      "city": "La Habana",
      "state": "La Habana",
      "postalCode": "10400",
      "country": "Cuba",
      "location": {"reference": "Location/0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a"}
    }],
    "qualification": [{
      "identifier": [{
        "system": "http://minsap.cu/certificados",
        "value": "CERT-456"}],
        "code": {
          "coding": [{
            "system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7",
            "code": "MD",
            "display": "Doctor of Medicine"
          }],
        "text": "Doctor en Medicina"
      },
      "period": {"start": "2010-01-01T08:00:00Z"},
      "issuer": {"reference": "Organization/0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a"}
      }]
    }'::jsonb),
('f1a2b3c4-d5e6-7890-ab12-34567890abcd',
'{
  "resourceType": "Practitioner",
  "id": "f1a2b3c4-d5e6-7890-ab12-34567890abcd",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC789"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Pérez", "given": ["Luis", "Alberto"]}], "telecom": [{"system": "phone", "value": "+5358223344"}], "gender": "male", "address": [{"use": "work", "type": "physical", "line": ["Ave. de los Presidentes #345"], "city": "Santa Clara", "state": "Villa Clara", "postalCode": "50200", "country": "Cuba", "location": {"reference": "Location/1a2b3c4d-5e6f-7890-abcd-1234567890ef"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT-789"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "END", "display": "Endocrinologist"}], "text": "Especialista en Endocrinología"}, "period": {"start": "2012-06-15T08:00:00Z"}, "issuer": {"reference": "Organization/1a2b3c4d-5e6f-7890-abcd-1234567890ef"}}]}'::jsonb),
('a1b2c3d4-e5f6-7890-abcd-9876543210fe',
'{
  "resourceType": "Practitioner",
  "id": "a1b2c3d4-e5f6-7890-abcd-9876543210fe",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC456"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Gómez", "given": ["Isabel"]
  }],
  "telecom": [{
    "system": "phone", "value": "+5358772211"
  }],
  "gender": "female",
  "address": [{
    "use": "work", "type": "physical", "line": ["Calle Martí #22"],
    "city": "Santiago de Cuba", "state": "Santiago de Cuba",
    "postalCode": "90100",
    "country": "Cuba",
    "location": {"reference": "Location/9e8d7c6b-5a4f-3210-badc-654321fedcba"}
  }],
  "qualification": [{
    "identifier": [{
      "system": "http://minsap.cu/certificados", "value": "CERT-321"
    }],
    "code": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "PUL", "display": "Pulmonologist"
      }],
      "text": "Especialista en Neumología"
    },
    "period": {"start": "2015-03-01T08:00:00Z"},
    "issuer": {"reference": "Organization/9e8d7c6b-5a4f-3210-badc-654321fedcba"}
  }]
}'::jsonb),
('22345678-1234-1234-1234-123456789abc',
'{
  "resourceType": "Practitioner",
  "id": "22345678-1234-1234-1234-123456789abc",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC723"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Ramírez", "given": ["José"]}], "telecom": [{"system": "phone", "value": "+5355512345"}], "gender": "male", "birthDate": "1975-04-12", "address": [{"use": "work", "type": "physical", "line": ["Calle 10 #100"], "city": "La Habana", "state": "La Habana", "postalCode": "10400", "country": "Cuba", "location": {"reference": "Location/0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT123"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "MD", "display": "Doctor en Medicina"}], "text": "Doctor en Medicina"}, "period": {"start": "2000-01-01T08:00:00Z"}, "issuer": {"reference": "Organization/c1d2e3f4-5678-90ab-cdef-1234567890ab"}}]}'::jsonb),
('a1b2c3d4-1111-2222-3333-444455556666',
'{
  "resourceType": "Practitioner",
  "id": "a1b2c3d4-1111-2222-3333-444455556666",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC450"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Martínez", "given": ["Ana"]}], "telecom": [{"system": "phone", "value": "+5355987654"}], "gender": "female", "birthDate": "1980-11-30", "address": [{"use": "work", "type": "physical", "line": ["Ave. 5ta #789"], "city": "Santiago de Cuba", "state": "Santiago de Cuba", "postalCode": "90100", "country": "Cuba", "location": {"reference": "Location/2b3c4d5e-6f7a-8b9c-0d1e-2f3a4b5c6d7e"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT456"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "PED", "display": "Pediatría"}], "text": "Especialista en Pediatría"}, "period": {"start": "2010-06-15T08:00:00Z"}, "issuer": {"reference": "Organization/456789ab-cdef-1234-5678-90abcdef1234"}}]}'::jsonb),
('b2c3d4e5-2222-3333-4444-555566667777',
'{
  "resourceType": "Practitioner",
  "id": "b2c3d4e5-2222-3333-4444-555566667777",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC789"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Fernández", "given": ["Carlos"]}], "telecom": [{"system": "phone", "value": "+5355332211"}], "gender": "male", "birthDate": "1978-07-15", "address": [{"use": "work", "type": "physical", "line": ["Calle 23 #456"], "city": "Camagüey", "state": "Camagüey", "postalCode": "70100", "country": "Cuba", "location": {"reference": "Location/5e6f7a8b-9c0d-1e2f-3a4b-5c6d7e8f9a0b"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT789"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "CARD", "display": "Cardiología"}], "text": "Especialista en Cardiología"}, "period": {"start": "2005-03-01T08:00:00Z"}, "issuer": {"reference": "Organization/9c858901-8a57-4791-81fe-4c455b099bc9"}}]}'::jsonb),
('65432109-abcd-4321-abcd-9876543210ff',
'{
  "resourceType": "Practitioner",
  "id": "65432109-abcd-4321-abcd-9876543210ff",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC321"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Gómez", "given": ["Lucía"]}], "telecom": [{"system": "phone", "value": "+5355998877"}], "gender": "female", "birthDate": "1985-09-20", "address": [{"use": "work", "type": "physical", "line": ["Ave. Central #123"], "city": "Holguín", "state": "Holguín", "postalCode": "80100", "country": "Cuba", "location": {"reference": "Location/5f6a7b8c-9d0e-1f2a-3b4c-5d6e7f8a9b0c"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT321"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "DERM", "display": "Dermatología"}], "text": "Especialista en Dermatología"}, "period": {"start": "2012-07-01T08:00:00Z"}, "issuer": {"reference": "Organization/d4c3b2a1-5e6f-7a8b-9c0d-1e2f3a4b5c6d"}}]}'::jsonb),
('11111111-2222-3333-4444-555555555555',
'{
  "resourceType": "Practitioner",
  "id": "11111111-2222-3333-4444-555555555555",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC111"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "López", "given": ["Ana"]}], "telecom": [{"system": "phone", "value": "+5355123450"}], "gender": "female", "birthDate": "1979-05-15", "address": [{"use": "work", "type": "physical", "line": ["Calle 12 #100"], "city": "La Habana", "state": "La Habana", "postalCode": "10400", "country": "Cuba", "location": {"reference": "Location/0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT111"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "NEUR", "display": "Neurología"}], "text": "Especialista en Neurología"}, "period": {"start": "2008-01-01T08:00:00Z"}, "issuer": {"reference": "Organization/c1d2e3f4-5678-90ab-cdef-1234567890ab"}}]}'::jsonb),
('22222222-3333-4444-5555-666666666666',
'{
  "resourceType": "Practitioner",
  "id": "22222222-3333-4444-5555-666666666666",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC222"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Sánchez", "given": ["Carlos"]}], "telecom": [{"system": "phone", "value": "+5355234567"}], "gender": "male", "birthDate": "1983-08-20", "address": [{"use": "work", "type": "physical", "line": ["Ave. 7ma #200"], "city": "Santiago de Cuba", "state": "Santiago de Cuba", "postalCode": "90100", "country": "Cuba", "location": {"reference": "Location/2b3c4d5e-6f7a-8b9c-0d1e-2f3a4b5c6d7e"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT222"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "CARD", "display": "Cardiología"}], "text": "Especialista en Cardiología"}, "period": {"start": "2011-06-01T08:00:00Z"}, "issuer": {"reference": "Organization/456789ab-cdef-1234-5678-90abcdef1234"}}]}'::jsonb),
('33333333-4444-5555-6666-777777777777',
'{
  "resourceType": "Practitioner",
  "id": "33333333-4444-5555-6666-777777777777",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC333"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Vega", "given": ["María"]}], "telecom": [{"system": "phone", "value": "+5355123001"}], "gender": "female", "birthDate": "1980-02-15", "address": [{"use": "work", "type": "physical", "line": ["Calle 1 #101"], "city": "Matanzas", "state": "Matanzas", "postalCode": "40100", "country": "Cuba", "location": {"reference": "Location/9c0d1e2f-3a4b-5c6d-7e8f-9a0b1c2d3e4f"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT333"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "NEUR", "display": "Neurología"}], "text": "Especialista en Neurología"}, "period": {"start": "2009-04-01T08:00:00Z"}, "issuer": {"reference": "Organization/b2c3d4e5-6789-0abc-def1-234567890abc"}}]}'::jsonb),
('44444444-5555-6666-7777-888888888888',
'{
  "resourceType": "Practitioner",
  "id": "44444444-5555-6666-7777-888888888888",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC444"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Castro", "given": ["Luis"]}], "telecom": [{"system": "phone", "value": "+5355234002"}], "gender": "male", "birthDate": "1975-07-20", "address": [{"use": "work", "type": "physical", "line": ["Ave. 2 #202"], "city": "Cienfuegos", "state": "Cienfuegos", "postalCode": "55100", "country": "Cuba", "location": {"reference": "Location/0e1f2a3b-4c5d-6e7f-8a9b-0c1d2e3f4a5b"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT444"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "CARD", "display": "Cardiología"}], "text": "Especialista en Cardiología"}, "period": {"start": "2007-09-01T08:00:00Z"}, "issuer": {"reference": "Organization/7c9e6679-7425-40de-944b-e07fc1f90ae7"}}]}'::jsonb),
('55555555-6666-7777-8888-999999999999',
'{
  "resourceType": "Practitioner",
  "id": "55555555-6666-7777-8888-999999999999",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC555"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Molina", "given": ["Ana"]}], "telecom": [{"system": "phone", "value": "+5355345003"}], "gender": "female", "birthDate": "1987-11-10", "address": [{"use": "work", "type": "physical", "line": ["Calle 3 #303"], "city": "Holguín", "state": "Holguín", "postalCode": "80100", "country": "Cuba", "location": {"reference": "Location/5f6a7b8c-9d0e-1f2a-3b4c-5d6e7f8a9b0c"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT555"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "DERM", "display": "Dermatología"}], "text": "Especialista en Dermatología"}, "period": {"start": "2013-05-01T08:00:00Z"}, "issuer": {"reference": "Organization/d4c3b2a1-5e6f-7a8b-9c0d-1e2f3a4b5c6d"}}]}'::jsonb),
('66666666-7777-8888-9999-000000000000',
'{
  "resourceType": "Practitioner",
  "id": "66666666-7777-8888-9999-000000000000",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC666"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Pérez", "given": ["Carlos"]}], "telecom": [{"system": "phone", "value": "+5355456004"}], "gender": "male", "birthDate": "1970-12-25", "address": [{"use": "work", "type": "physical", "line": ["Ave. 4 #404"], "city": "Camagüey", "state": "Camagüey", "postalCode": "70100", "country": "Cuba", "location": {"reference": "Location/5e6f7a8b-9c0d-1e2f-3a4b-5c6d7e8f9a0b"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT666"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "ORTH", "display": "Ortopedia"}], "text": "Especialista en Ortopedia"}, "period": {"start": "2000-02-01T08:00:00Z"}, "issuer": {"reference": "Organization/9c858901-8a57-4791-81fe-4c455b099bc9"}}]}'::jsonb),
('77777777-8888-9999-0000-111111111111',
'{
  "resourceType": "Practitioner",
  "id": "77777777-8888-9999-0000-111111111111",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC777"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Rodríguez", "given": ["Lucía"]}], "telecom": [{"system": "phone", "value": "+5355567005"}], "gender": "female", "birthDate": "1983-03-18", "address": [{"use": "work", "type": "physical", "line": ["Calle 5 #505"], "city": "Santiago de Cuba", "state": "Santiago de Cuba", "postalCode": "90100", "country": "Cuba", "location": {"reference": "Location/2b3c4d5e-6f7a-8b9c-0d1e-2f3a4b5c6d7e"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT777"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "PED", "display": "Pediatría"}], "text": "Especialista en Pediatría"}, "period": {"start": "2011-09-01T08:00:00Z"}, "issuer": {"reference": "Organization/456789ab-cdef-1234-5678-90abcdef1234"}}]}'::jsonb),
('88888888-9999-0000-1111-222222222222',
'{
  "resourceType": "Practitioner",
  "id": "88888888-9999-0000-1111-222222222222",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC888"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Gutiérrez", "given": ["José"]}], "telecom": [{"system": "phone", "value": "+5355678006"}], "gender": "male", "birthDate": "1977-10-10", "address": [{"use": "work", "type": "physical", "line": ["Ave. 6 #606"], "city": "Holguín", "state": "Holguín", "postalCode": "80100", "country": "Cuba", "location": {"reference": "Location/5f6a7b8c-9d0e-1f2a-3b4c-5d6e7f8a9b0c"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT888"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "NEPH", "display": "Nefrología"}], "text": "Especialista en Nefrología"}, "period": {"start": "2009-11-01T08:00:00Z"}, "issuer": {"reference": "Organization/d4c3b2a1-5e6f-7a8b-9c0d-1e2f3a4b5c6d"}}]}'::jsonb),
('99999999-0000-1111-2222-333333333333',
'{
  "resourceType": "Practitioner",
  "id": "99999999-0000-1111-2222-333333333333",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC999"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Martín", "given": ["Ana"]}], "telecom": [{"system": "phone", "value": "+5355789007"}], "gender": "female", "birthDate": "1986-12-12", "address": [{"use": "work", "type": "physical", "line": ["Calle 7 #707"], "city": "Las Tunas", "state": "Las Tunas", "postalCode": "75100", "country": "Cuba", "location": {"reference": "Location/loc011"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT999"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "ENDO", "display": "Endocrinología"}], "text": "Especialista en Endocrinología"}, "period": {"start": "2014-01-01T08:00:00Z"}, "issuer": {"reference": "Organization/org011"}}]}'::jsonb),
('aaaaaaaa-bbbb-cccc-dddd-eeeeeeeeeeee',
'{
  "resourceType": "Practitioner",
  "id": "aaaaaaaa-bbbb-cccc-dddd-eeeeeeeeeeee",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOCAAA"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Fernández", "given": ["Jorge"]}], "telecom": [{"system": "phone", "value": "+5355890008"}], "gender": "male", "birthDate": "1973-03-03", "address": [{"use": "work", "type": "physical", "line": ["Ave. 8 #808"], "city": "Villa Clara", "state": "Villa Clara", "postalCode": "50100", "country": "Cuba", "location": {"reference": "Location/loc012"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERTAAA"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "PSY", "display": "Psiquiatría"}], "text": "Especialista en Psiquiatría"}, "period": {"start": "2006-02-01T08:00:00Z"}, "issuer": {"reference": "Organization/org012"}}]}'::jsonb),
('bbbbbbbb-cccc-dddd-eeee-ffffffffffff',
'{
  "resourceType": "Practitioner",
  "id": "bbbbbbbb-cccc-dddd-eeee-ffffffffffff",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOCBBB"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "García", "given": ["María"]}], "telecom": [{"system": "phone", "value": "+5355900010"}], "gender": "female", "birthDate": "1988-04-04", "address": [{"use": "work", "type": "physical", "line": ["Calle 9 #909"], "city": "Camagüey", "state": "Camagüey", "postalCode": "70100", "country": "Cuba", "location": {"reference": "Location/5e6f7a8b-9c0d-1e2f-3a4b-5c6d7e8f9a0b"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERTBBB"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "GAST", "display": "Gastroenterología"}], "text": "Especialista en Gastroenterología"}, "period": {"start": "2015-03-01T08:00:00Z"}, "issuer": {"reference": "Organization/9c858901-8a57-4791-81fe-4c455b099bc9"}}]}'::jsonb),
('cccccccc-dddd-eeee-ffff-000000000000',
'{
  "resourceType": "Practitioner",
  "id": "cccccccc-dddd-eeee-ffff-000000000000",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOCCCC"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Luna", "given": ["José"]}], "telecom": [{"system": "phone", "value": "+5355910011"}], "gender": "male", "birthDate": "1979-05-05", "address": [{"use": "work", "type": "physical", "line": ["Ave. 10 #1010"], "city": "Pinar del Río", "state": "Pinar del Río", "postalCode": "20100", "country": "Cuba", "location": {"reference": "Location/3c4d5e6f-7a8b-9c0d-1e2f-3a4b5c6d7e8f"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERTCCC"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "ONC", "display": "Oncología"}], "text": "Especialista en Oncología"}, "period": {"start": "2012-04-01T08:00:00Z"}, "issuer": {"reference": "Organization/a1b2c3d4-e5f6-7890-abcd-ef0123456789"}}]}'::jsonb),
('dddddddd-eeee-ffff-0000-111111111111',
'{
  "resourceType": "Practitioner",
  "id": "dddddddd-eeee-ffff-0000-111111111111",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOCDDD"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Pérez", "given": ["María"]}], "telecom": [{"system": "phone", "value": "+5355920012"}], "gender": "female", "birthDate": "1981-06-06", "address": [{"use": "work", "type": "physical", "line": ["Calle 11 #1111"], "city": "Ciego de Ávila", "state": "Ciego de Ávila", "postalCode": "60300", "country": "Cuba", "location": {"reference": "Location/6a7b8c9d-0e1f-2a3b-4c5d-6e7f8a9b0c1d"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERTDDD"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "PSY", "display": "Psiquiatría"}], "text": "Especialista en Psiquiatría"}, "period": {"start": "2010-05-01T08:00:00Z"}, "issuer": {"reference": "Organization/16fd2706-8baf-433b-82eb-8c7fada847da"}}]}'::jsonb),
('eeeeeeee-ffff-0000-1111-222222222222',
'{
  "resourceType": "Practitioner",
  "id": "eeeeeeee-ffff-0000-1111-222222222222",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOCEEE"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Soto", "given": ["Jorge"]}], "telecom": [{"system": "phone", "value": "+5355930013"}], "gender": "male", "birthDate": "1976-07-07", "address": [{"use": "work", "type": "physical", "line": ["Ave. 12 #1212"], "city": "Guantánamo", "state": "Guantánamo", "postalCode": "95100", "country": "Cuba", "location": {"reference": "Location/1d2e3f4a-5b6c-7d8e-9f0a-1b2c3d4e5f6a"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERTEEE"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "GAST", "display": "Gastroenterología"}], "text": "Especialista en Gastroenterología"}, "period": {"start": "2013-08-01T08:00:00Z"}, "issuer": {"reference": "Organization/e358a3f0-4f45-4f0a-9a3f-4b3e4f9a6f7b"}}]}'::jsonb),
('ffffffff-0000-1111-2222-333333333333',
'{
  "resourceType": "Practitioner",
  "id": "ffffffff-0000-1111-2222-333333333333",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOCFFF"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Ruiz", "given": ["Ana"]}], "telecom": [{"system": "phone", "value": "+5355940014"}], "gender": "female", "birthDate": "1984-08-08", "address": [{"use": "work", "type": "physical", "line": ["Calle 13 #1313"], "city": "Las Tunas", "state": "Las Tunas", "postalCode": "75100", "country": "Cuba", "location": {"reference": "Location/loc017"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERTFFF"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "ENDO", "display": "Endocrinología"}], "text": "Especialista en Endocrinología"}, "period": {"start": "2015-09-01T08:00:00Z"}, "issuer": {"reference": "Organization/org017"}}]}'::jsonb),
('88888888-9999-aaaa-bbbb-cccccccccccc',
'{
  "resourceType": "Practitioner",
  "id": "88888888-9999-aaaa-bbbb-cccccccccccc",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC888"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Suárez", "given": ["Marta"]}], "telecom": [{"system": "phone", "value": "+5355987123"}], "gender": "female", "birthDate": "1972-09-15", "address": [{"use": "work", "type": "physical", "line": ["Calle 15 #202"], "city": "Pinar del Río", "state": "Pinar del Río", "postalCode": "20100", "country": "Cuba", "location": {"reference": "Location/3c4d5e6f-7a8b-9c0d-1e2f-3a4b5c6d7e8f"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT-888"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "CAR", "display": "Cardiología"}], "text": "Especialista en Cardiología"}, "period": {"start": "2002-05-01T08:00:00Z"}, "issuer": {"reference": "Organization/a1b2c3d4-e5f6-7890-abcd-ef0123456789"}}]}'::jsonb),
('99999999-aaaa-bbbb-cccc-dddddddddddd',
'{
  "resourceType": "Practitioner",
  "id": "99999999-aaaa-bbbb-cccc-dddddddddddd",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC998"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Santos", "given": ["Ramón"]}], "telecom": [{"system": "phone", "value": "+5355841234"}], "gender": "male", "birthDate": "1980-11-23", "address": [{"use": "work", "type": "physical", "line": ["Ave. 2da #321"], "city": "Matanzas", "state": "Matanzas", "postalCode": "40100", "country": "Cuba", "location": {"reference": "Location/9c0d1e2f-3a4b-5c6d-7e8f-9a0b1c2d3e4f"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT-999"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "NEUR", "display": "Neurología"}], "text": "Especialista en Neurología"}, "period": {"start": "2007-10-01T08:00:00Z"}, "issuer": {"reference": "Organization/b2c3d4e5-6789-0abc-def1-234567890abc"}}]}'::jsonb),
('aaaaaaa1-bbbb-cccc-dddd-eeeeeeeeeeee',
'{
  "resourceType": "Practitioner",
  "id": "aaaaaaa1-bbbb-cccc-dddd-eeeeeeeeeeee",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC101"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "García", "given": ["Elena"]}], "telecom": [{"system": "phone", "value": "+5355994321"}], "gender": "female", "birthDate": "1988-03-12", "address": [{"use": "work", "type": "physical", "line": ["Calle 8 #88"], "city": "Camagüey", "state": "Camagüey", "postalCode": "70100", "country": "Cuba", "location": {"reference": "Location/5e6f7a8b-9c0d-1e2f-3a4b-5c6d7e8f9a0b"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT-101"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "DERM", "display": "Dermatología"}], "text": "Especialista en Dermatología"}, "period": {"start": "2014-03-01T08:00:00Z"}, "issuer": {"reference": "Organization/9c858901-8a57-4791-81fe-4c455b099bc9"}}]}'::jsonb),
('bbbbbbb2-cccc-dddd-eeee-ffffffffffff',
'{
  "resourceType": "Practitioner",
  "id": "bbbbbbb2-cccc-dddd-eeee-ffffffffffff",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC102"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Paredes", "given": ["Manuel"]}], "telecom": [{"system": "phone", "value": "+5355887654"}], "gender": "male", "birthDate": "1976-06-25", "address": [{"use": "work", "type": "physical", "line": ["Ave. 10 #1010"], "city": "Holguín", "state": "Holguín", "postalCode": "80100", "country": "Cuba", "location": {"reference": "Location/5f6a7b8c-9d0e-1f2a-3b4c-5d6e7f8a9b0c"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT-102"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "GAST", "display": "Gastroenterología"}], "text": "Especialista en Gastroenterología"}, "period": {"start": "2011-05-01T08:00:00Z"}, "issuer": {"reference": "Organization/d4c3b2a1-5e6f-7a8b-9c0d-1e2f3a4b5c6d"}}]}'::jsonb),
('ccccccc3-dddd-eeee-ffff-000000000000',
'{
  "resourceType": "Practitioner",
  "id": "ccccccc3-dddd-eeee-ffff-000000000000",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC103"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Ruiz", "given": ["Carmen"]}], "telecom": [{"system": "phone", "value": "+5355778888"}], "gender": "female", "birthDate": "1983-08-19", "address": [{"use": "work", "type": "physical", "line": ["Calle 20 #200"], "city": "Granma", "state": "Granma", "postalCode": "85100", "country": "Cuba", "location": {"reference": "Location/loc019"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT-103"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "PED", "display": "Pediatría"}], "text": "Especialista en Pediatría"}, "period": {"start": "2010-03-01T08:00:00Z"}, "issuer": {"reference": "Organization/loc019"}}]}'::jsonb),
('ddddddd4-eeee-ffff-0000-111111111111',
'{
  "resourceType": "Practitioner",
  "id": "ddddddd4-eeee-ffff-0000-111111111111",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC104"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Martí", "given": ["Julio"]}], "telecom": [{"system": "phone", "value": "+5355667788"}], "gender": "male", "birthDate": "1970-02-11", "address": [{"use": "work", "type": "physical", "line": ["Ave. 5ta #505"], "city": "Ciego de Ávila", "state": "Ciego de Ávila", "postalCode": "60300", "country": "Cuba", "location": {"reference": "Location/6a7b8c9d-0e1f-2a3b-4c5d-6e7f8a9b0c1d"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT-104"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "PSY", "display": "Psiquiatría"}], "text": "Especialista en Psiquiatría"}, "period": {"start": "1998-06-01T08:00:00Z"}, "issuer": {"reference": "Organization/16fd2706-8baf-433b-82eb-8c7fada847da"}}]}'::jsonb),
('eeeeeee5-ffff-0000-1111-222222222222',
'{
  "resourceType": "Practitioner",
  "id": "eeeeeee5-ffff-0000-1111-222222222222",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC105"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Luna", "given": ["Marcos"]}], "telecom": [{"system": "phone", "value": "+5355991234"}], "gender": "male", "birthDate": "1975-12-22", "address": [{"use": "work", "type": "physical", "line": ["Calle 18 #18"], "city": "Artemisa", "state": "Artemisa", "postalCode": "12400", "country": "Cuba", "location": {"reference": "Location/5d6e7f8a-9b0c-1d2e-3f4a-5b6c7d8e9f0a"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT-105"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "ONC", "display": "Oncología"}], "text": "Especialista en Oncología"}, "period": {"start": "2003-11-01T08:00:00Z"}, "issuer": {"reference": "Organization/f47ac10b-58cc-4372-a567-0e02b2c3d479"}}]}'::jsonb),
('fffffff6-0000-1111-2222-333333333333',
'{
  "resourceType": "Practitioner",
  "id": "fffffff6-0000-1111-2222-333333333333",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC106"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Vidal", "given": ["Rosa"]}], "telecom": [{"system": "phone", "value": "+5355771234"}], "gender": "female", "birthDate": "1982-10-30", "address": [{"use": "work", "type": "physical", "line": ["Ave. 8va #88"], "city": "Mayabeque", "state": "Mayabeque", "postalCode": "18800", "country": "Cuba", "location": {"reference": "Location/loc022"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT-106"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "NEPH", "display": "Nefrología"}], "text": "Especialista en Nefrología"}, "period": {"start": "2012-02-01T08:00:00Z"}, "issuer": {"reference": "Organization/loc022"}}]}'::jsonb),
('11111112-2222-3333-4444-555555555556',
'{
  "resourceType": "Practitioner",
  "id": "11111112-2222-3333-4444-555555555556",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC107"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Alonso", "given": ["Pedro"]}], "telecom": [{"system": "phone", "value": "+5355667890"}], "gender": "male", "birthDate": "1978-04-14", "address": [{"use": "work", "type": "physical", "line": ["Calle 30 #300"], "city": "Sancti Spíritus", "state": "Sancti Spíritus", "postalCode": "60100", "country": "Cuba", "location": {"reference": "Location/3d4e5f6a-7b8c-9d0e-1f2a-3b4c5d6e7f8a"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT-107"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "INF", "display": "Infectología"}], "text": "Especialista en Infectología"}, "period": {"start": "2008-08-01T08:00:00Z"}, "issuer": {"reference": "Organization/123e4567-e89b-12d3-a456-426614174000"}}]}'::jsonb),
('22222223-3333-4444-5555-666666666667',
'{
  "resourceType": "Practitioner",
  "id": "22222223-3333-4444-5555-666666666667",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC108"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Valdés", "given": ["Susana"]}], "telecom": [{"system": "phone", "value": "+5355998765"}], "gender": "female", "birthDate": "1985-12-01", "address": [{"use": "work", "type": "physical", "line": ["Ave. 12 #1200"], "city": "Guantánamo", "state": "Guantánamo", "postalCode": "95100", "country": "Cuba", "location": {"reference": "Location/1d2e3f4a-5b6c-7d8e-9f0a-1b2c3d4e5f6a"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT-108"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "OPHTH", "display": "Oftalmología"}], "text": "Especialista en Oftalmología"}, "period": {"start": "2015-09-01T08:00:00Z"}, "issuer": {"reference": "Organization/e358a3f0-4f45-4f0a-9a3f-4b3e4f9a6f7b"}}]}'::jsonb),
('33333334-4444-5555-6666-777777777778',
'{
  "resourceType": "Practitioner",
  "id": "33333334-4444-5555-6666-777777777778",
  "identifier": [{
    "system": "http://minsap.cu/licencia",
    "value": "DOC109"
  }],
  "active": true,
  "name": [{
    "use": "official",
    "family": "Pino", "given": ["Ernesto"]}], "telecom": [{"system": "phone", "value": "+5355126789"}], "gender": "male", "birthDate": "1981-02-22", "address": [{"use": "work", "type": "physical", "line": ["Calle 22 #222"], "city": "Las Tunas", "state": "Las Tunas", "postalCode": "75100", "country": "Cuba", "location": {"reference": "Location/loc025"}}], "qualification": [{"identifier": [{"system": "http://minsap.cu/certificados", "value": "CERT-109"}], "code": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v2-0360/2.7", "code": "UROL", "display": "Urología"}], "text": "Especialista en Urología"}, "period": {"start": "2012-07-01T08:00:00Z"}, "issuer": {"reference": "Organization/loc025"}}]}'::jsonb);

-- 3. Encounter(26) ✔
INSERT INTO encounters (id, resource) VALUES
('8f9a0b1c-2d3e-4f5a-6b7c-8d9e0f1a2b3c',
'{
  "resourceType": "Encounter",
  "id": "8f9a0b1c-2d3e-4f5a-6b7c-8d9e0f1a2b3c",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "AMB",
      "display": "Ambulatory"
    }],
    "text": "Consulta ambulatoria"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "185349003",
      "display": "Consulta de control"
    }]
  }],
  "subject": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "actualPeriod": {
    "start": "2023-10-05T08:00:00Z",
    "end": "2023-10-05T08:30:00Z"
  },
  "participant": [{
      "type": [{
        "coding": [{
          "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
          "code": "PPRF",
          "display": "Intérprete principal"
        }]
      }],
      "period": {"start": "2023-10-05T08:00:00Z", "end": "2023-10-05T08:30:00Z"},
      "actor": {"reference": "Practitioner/12345678-1234-1234-1234-123456789abc", "display": "Dra. Ana López"}}],
  "appointment": [{"reference": "Appointment/2b3c4d5e-6f7a-8b9c-0d1e-2f3a4b5c6d7e"}],
  "reason": [{
      "use": [{
          "coding": [{
              "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
              "code": "PATPREF",
              "display": "Patient preference"
            }]
          "text": "El paciente ha sufrido de una crisis diabética"
        }],
      "value": [{
          "reference": "Condition/6d7e8f9a-1b2c-3d4e-5f6a-7b8c9d0e1f2a",
          "display": "Crisis diabética"
        }]
    }],
  "diagnosis": [{
    "condition": [{"reference": "Condition/6d7e8f9a-1b2c-3d4e-5f6a-7b8c9d0e1f2a"}],
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/diagnosis-role",
        "code": "AD",
        "display": "Admission diagnosis"
      }]
    }]
  }]
}'::jsonb),
('a1b2c3d4-5678-1234-9abc-def012345678',
'{
  "resourceType": "Encounter",
  "id": "a1b2c3d4-5678-1234-9abc-def012345678",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "AMB",
      "display": "Ambulatory"
    }],
    "text": "Consulta ambulatoria"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "185349003",
      "display": "Consulta de control"
    }]
  }],
  "subject": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "actualPeriod": {
    "start": "2024-01-10T09:00:00Z",
    "end": "2024-01-10T09:30:00Z"
  },
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2024-01-10T09:00:00Z", "end": "2024-01-10T09:30:00Z"},
    "actor": {"reference": "Practitioner/f1a2b3c4-d5e6-7890-ab12-34567890abcd", "display": "Dr. Juan Pérez"}
  }],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "PATPREF",
        "display": "Patient preference"
      }]
    }],
    "value": [{
      "reference": "Condition/cc1111cc-2222-3333-4444-555566667777",
      "display": "Hipertensión arterial"
    }]
  }]
}'::jsonb),
('b2c3d4e5-6789-2345-9bcd-ef1234567890',
'{
  "resourceType": "Encounter",
  "id": "b2c3d4e5-6789-2345-9bcd-ef1234567890",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "EMER",
      "display": "Emergency"
    }],
    "text": "Urgencia"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "50849002",
      "display": "Consulta de urgencia"
    }]
  }],
  "subject": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"},
  "actualPeriod": {
    "start": "2024-02-15T18:00:00Z",
    "end": "2024-02-15T18:45:00Z"
  },
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2024-02-15T18:00:00Z", "end": "2024-02-15T18:45:00Z"},
    "actor": {"reference": "Practitioner/22345678-1234-1234-1234-123456789abc", "display": "Dra. Marta Rodríguez"}
  }],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "MEDNEC",
        "display": "Medical necessity"
      }]
    }],
    "value": [{
      "reference": "Condition/dd2222dd-3333-4444-5555-666677778888",
      "display": "Asma bronquial"
    }]
  }]
}'::jsonb),
('c3d4e5f6-7890-3456-9cde-f01234567890',
'{
  "resourceType": "Encounter",
  "id": "c3d4e5f6-7890-3456-9cde-f01234567890",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "AMB",
      "display": "Ambulatory"
    }],
    "text": "Consulta ambulatoria"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "162673000",
      "display": "Consulta de seguimiento"
    }]
  }],
  "subject": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"},
  "actualPeriod": {
    "start": "2024-03-20T10:00:00Z",
    "end": "2024-03-20T10:40:00Z"
  },
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2024-03-20T10:00:00Z", "end": "2024-03-20T10:40:00Z"},
    "actor": {"reference": "Practitioner/a1b2c3d4-e5f6-7890-abcd-9876543210fe", "display": "Dr. Ernesto Gómez"}
  }],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "FUP",
        "display": "Follow-up"
      }]
    }],
    "value": [{
      "reference": "Condition/ee3333ee-4444-5555-6666-777788889999",
      "display": "Diabetes mellitus tipo 2"
    }]
  }]
}'::jsonb),
('d4e5f6a7-8901-4567-9def-0123456789ab',
'{
  "resourceType": "Encounter",
  "id": "d4e5f6a7-8901-4567-9def-0123456789ab",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "IMP",
      "display": "Inpatient encounter"
    }],
    "text": "Ingreso hospitalario"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "324851000000109",
      "display": "Ingreso por neumonía"
    }]
  }],
  "subject": {"reference": "Patient/f1a2b3c4-5678-90ab-cdef-1234567890ad"},
  "actualPeriod": {
    "start": "2024-04-05T14:00:00Z",
    "end": "2024-04-12T10:00:00Z"
  },
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2024-04-05T14:00:00Z", "end": "2024-04-12T10:00:00Z"},
    "actor": {"reference": "Practitioner/65432109-abcd-4321-abcd-9876543210ff", "display": "Dra. Teresa Suárez"}
  }],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "MEDNEC",
        "display": "Medical necessity"
      }]
    }],
    "value": [{
      "reference": "Condition/ff4444ff-5555-6666-7777-888899990000",
      "display": "Neumonía adquirida en la comunidad"
    }]
  }]
}'::jsonb),
('e5f6a7b8-9012-5678-9efa-123456789abc',
'{
  "resourceType": "Encounter",
  "id": "e5f6a7b8-9012-5678-9efa-123456789abc",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "AMB",
      "display": "Ambulatory"
    }],
    "text": "Consulta ambulatoria"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "225929007",
      "display": "Consulta por dolor abdominal"
    }]
  }],
  "subject": {"reference": "Patient/10d1e2f3-4567-8901-2345-012345678901"},
  "actualPeriod": {
    "start": "2024-05-12T11:00:00Z",
    "end": "2024-05-12T11:25:00Z"
  },
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2024-05-12T11:00:00Z", "end": "2024-05-12T11:25:00Z"},
    "actor": {"reference": "Practitioner/33333333-4444-5555-6666-777777777777", "display": "Dr. Carlos Ramírez"}
  }],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "PATPREF",
        "display": "Patient preference"
      }]
    }],
    "value": [{
      "reference": "Condition/aa5555aa-6666-7777-8888-999900001111",
      "display": "Dolor abdominal inespecífico"
    }]
  }]
}'::jsonb),
('f1e2d3c4-b5a6-7890-1234-56789abcdef0',
'{
  "resourceType": "Encounter",
  "id": "f1e2d3c4-b5a6-7890-1234-56789abcdef0",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "AMB",
      "display": "Ambulatory"
    }],
    "text": "Consulta ambulatoria"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "162673000",
      "display": "Consulta de seguimiento"
    }]
  }],
  "subject": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "actualPeriod": {
    "start": "2024-06-01T08:30:00Z",
    "end": "2024-06-01T09:00:00Z"
  },
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2024-06-01T08:30:00Z", "end": "2024-06-01T09:00:00Z"},
    "actor": {"reference": "Practitioner/12345678-1234-1234-1234-123456789abc", "display": "Dra. Ana López"}
  }],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "FUP",
        "display": "Follow-up"
      }]
    }],
    "value": [{
      "reference": "Condition/cc1111cc-2222-3333-4444-555566667777",
      "display": "Hipertensión arterial"
    }]
  }]
}'::jsonb),
('a2b3c4d5-e6f7-890a-bcde-1234567890ab',
'{
  "resourceType": "Encounter",
  "id": "a2b3c4d5-e6f7-890a-bcde-1234567890ab",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "EMER",
      "display": "Emergency"
    }],
    "text": "Urgencia"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "50849002",
      "display": "Consulta de urgencia"
    }]
  }],
  "subject": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "actualPeriod": {
    "start": "2024-06-05T17:00:00Z",
    "end": "2024-06-05T17:40:00Z"
  },
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2024-06-05T17:00:00Z", "end": "2024-06-05T17:40:00Z"},
    "actor": {"reference": "Practitioner/f1a2b3c4-d5e6-7890-ab12-34567890abcd", "display": "Dr. Juan Pérez"}
  }],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "MEDNEC",
        "display": "Medical necessity"
      }]
    }],
    "value": [{
      "reference": "Condition/dd2222dd-3333-4444-5555-666677778888",
      "display": "Asma bronquial"
    }]
  }]
}'::jsonb),
('b3c4d5e6-f7a8-9012-bcde-2345678901bc',
'{
  "resourceType": "Encounter",
  "id": "b3c4d5e6-f7a8-9012-bcde-2345678901bc",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "AMB",
      "display": "Ambulatory"
    }],
    "text": "Consulta ambulatoria"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "185349003",
      "display": "Consulta de control"
    }]
  }],
  "subject": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"},
  "actualPeriod": {
    "start": "2024-06-10T11:00:00Z",
    "end": "2024-06-10T11:30:00Z"
  },
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2024-06-10T11:00:00Z", "end": "2024-06-10T11:30:00Z"},
    "actor": {"reference": "Practitioner/a1b2c3d4-e5f6-7890-abcd-9876543210fe", "display": "Dr. Ernesto Gómez"}
  }],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "FUP",
        "display": "Follow-up"
      }]
    }],
    "value": [{
      "reference": "Condition/ee3333ee-4444-5555-6666-777788889999",
      "display": "Diabetes mellitus tipo 2"
    }]
  }]
}'::jsonb),
('c4d5e6f7-a8b9-0123-cdef-345678901234',
'{
  "resourceType": "Encounter",
  "id": "c4d5e6f7-a8b9-0123-cdef-345678901234",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "IMP",
      "display": "Inpatient encounter"
    }],
    "text": "Ingreso hospitalario"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "324851000000109",
      "display": "Ingreso por neumonía"
    }]
  }],
  "subject": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"},
  "actualPeriod": {
    "start": "2024-06-15T15:00:00Z",
    "end": "2024-06-22T10:00:00Z"
  },
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2024-06-15T15:00:00Z", "end": "2024-06-22T10:00:00Z"},
    "actor": {"reference": "Practitioner/65432109-abcd-4321-abcd-9876543210ff", "display": "Dra. Teresa Suárez"}
  }],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "MEDNEC",
        "display": "Medical necessity"
      }]
    }],
    "value": [{
      "reference": "Condition/ff4444ff-5555-6666-7777-888899990000",
      "display": "Neumonía adquirida en la comunidad"
    }]
  }]
}'::jsonb),
('d5e6f7a8-b9c0-1234-def0-567890123456',
'{
  "resourceType": "Encounter",
  "id": "d5e6f7a8-b9c0-1234-def0-567890123456",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "AMB",
      "display": "Ambulatory"
    }],
    "text": "Consulta ambulatoria"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "225929007",
      "display": "Consulta por dolor abdominal"
    }]
  }],
  "subject": {"reference": "Patient/a2b3c4d5-e6f7-890a-bcde-f1234567890e"},
  "actualPeriod": {
    "start": "2024-06-18T13:00:00Z",
    "end": "2024-06-18T13:25:00Z"
  },
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2024-06-18T13:00:00Z", "end": "2024-06-18T13:25:00Z"},
    "actor": {"reference": "Practitioner/33333333-4444-5555-6666-777777777777", "display": "Dr. Carlos Ramírez"}
  }],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "PATPREF",
        "display": "Patient preference"
      }]
    }],
    "value": [{
      "reference": "Condition/aa5555aa-6666-7777-8888-999900001111",
      "display": "Dolor abdominal inespecífico"
    }]
  }]
}'::jsonb),
('e6f7a8b9-c0d1-2345-ef01-678901234567',
'{
  "resourceType": "Encounter",
  "id": "e6f7a8b9-c0d1-2345-ef01-678901234567",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "AMB",
      "display": "Ambulatory"
    }],
    "text": "Consulta ambulatoria"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "185349003",
      "display": "Consulta de control"
    }]
  }],
  "subject": {"reference": "Patient/b3c4d5e6-f7a8-9012-bcde-f2345678901f"},
  "actualPeriod": {
    "start": "2024-06-20T08:00:00Z",
    "end": "2024-06-20T08:30:00Z"
  },
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2024-06-20T08:00:00Z", "end": "2024-06-20T08:30:00Z"},
    "actor": {"reference": "Practitioner/22222222-3333-4444-5555-666666666666", "display": "Dr. Manuel Torres"}
  }],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "FUP",
        "display": "Follow-up"
      }]
    }],
    "value": [{
      "reference": "Condition/bb6666bb-7777-8888-9999-000011112222",
      "display": "Insuficiencia renal crónica"
    }]
  }]
}'::jsonb),
('f7a8b9c0-d1e2-3456-f012-789012345678',
'{
  "resourceType": "Encounter",
  "id": "f7a8b9c0-d1e2-3456-f012-789012345678",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "AMB",
      "display": "Ambulatory"
    }],
    "text": "Consulta ambulatoria"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "162673000",
      "display": "Consulta de seguimiento"
    }]
  }],
  "subject": {"reference": "Patient/01a2b3c4-d5e6-7890-abcd-ef1234567890"},
  "actualPeriod": {
    "start": "2024-06-22T10:30:00Z",
    "end": "2024-06-22T11:00:00Z"
  },
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2024-06-22T10:30:00Z", "end": "2024-06-22T11:00:00Z"},
    "actor": {"reference": "Practitioner/aaaaaaa1-bbbb-cccc-dddd-eeeeeeeeeeee", "display": "Dra. Lucía Martínez"}
  }],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "FUP",
        "display": "Follow-up"
      }]
    }],
    "value": [{
      "reference": "Condition/cc7777cc-8888-9999-0000-111122223333",
      "display": "Hipotiroidismo"
    }]
  }]
}'::jsonb),
('a9b0c1d2-e3f4-5678-9012-34567890abcd',
'{
  "resourceType": "Encounter",
  "id": "a9b0c1d2-e3f4-5678-9012-34567890abcd",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "EMER",
      "display": "Emergency"
    }],
    "text": "Urgencia"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "50849002",
      "display": "Consulta de urgencia"
    }]
  }],
  "subject": {"reference": "Patient/02b3c4d5-e6f7-890a-bcde-f12345678901"},
  "actualPeriod": {
    "start": "2024-06-25T18:00:00Z",
    "end": "2024-06-25T18:45:00Z"
  },
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2024-06-25T18:00:00Z", "end": "2024-06-25T18:45:00Z"},
    "actor": {"reference": "Practitioner/33333334-4444-5555-6666-777777777778", "display": "Dr. Pedro Díaz"}
  }],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "MEDNEC",
        "display": "Medical necessity"
      }]
    }],
    "value": [{
      "reference": "Condition/dd8888dd-9999-0000-1111-222233334444",
      "display": "Crisis hipertensiva"
    }]
  }]
}'::jsonb),
('b0c1d2e3-f456-7890-1234-567890abcdef',
'{
  "resourceType": "Encounter",
  "id": "b0c1d2e3-f456-7890-1234-567890abcdef",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "AMB",
      "display": "Ambulatory"
    }],
    "text": "Consulta ambulatoria"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "185349003",
      "display": "Consulta de control"
    }]
  }],
  "subject": {"reference": "Patient/03c4d5e6-f7a8-9012-bcde-f23456789012"},
  "actualPeriod": {
    "start": "2024-06-28T09:00:00Z",
    "end": "2024-06-28T09:30:00Z"
  },
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2024-06-28T09:00:00Z", "end": "2024-06-28T09:30:00Z"},
    "actor": {"reference": "Practitioner/88888888-9999-aaaa-bbbb-cccccccccccc", "display": "Dr. Mario Herrera"}
  }],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "FUP",
        "display": "Follow-up"
      }]
    }],
    "value": [{
      "reference": "Condition/ee9999ee-aaaa-bbbb-cccc-ddddeeeeffff",
      "display": "Anemia ferropénica"
    }]
  }]
}'::jsonb),
('c1d2e3f4-5678-90ab-cdef-1234567890ac',
'{
  "resourceType": "Encounter",
  "id": "c1d2e3f4-5678-90ab-cdef-1234567890ac",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "AMB",
      "display": "Ambulatory"
    }],
    "text": "Consulta ambulatoria"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "162673000",
      "display": "Consulta de seguimiento"
    }]
  }],
  "subject": {"reference": "Patient/04d5e6f7-a8b9-0123-cdef-345678901234"},
  "actualPeriod": {
    "start": "2024-07-01T10:00:00Z",
    "end": "2024-07-01T10:30:00Z"
  },
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2024-07-01T10:00:00Z", "end": "2024-07-01T10:30:00Z"},
    "actor": {"reference": "Practitioner/99999999-aaaa-bbbb-cccc-dddddddddddd", "display": "Dra. Rosa Pérez"}
  }],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "FUP",
        "display": "Follow-up"
      }]
    }],
    "value": [{
      "reference": "Condition/ffaaaaff-bbbb-cccc-dddd-eeeeffff0000",
      "display": "Hiperglucemia"
    }]
  }]
}'::jsonb),
('e1a2b3c4-d5f6-7890-1a2b-3c4d5e6f7a8b',
'{
  "resourceType": "Encounter",
  "id": "e1a2b3c4-d5f6-7890-1a2b-3c4d5e6f7a8b",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "AMB",
      "display": "Ambulatory"
    }],
    "text": "Consulta ambulatoria"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "185349003",
      "display": "Consulta de control"
    }]
  }],
  "subject": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "actualPeriod": {
    "start": "2024-07-10T09:00:00Z",
    "end": "2024-07-10T09:30:00Z"
  },
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2024-07-10T09:00:00Z", "end": "2024-07-10T09:30:00Z"},
    "actor": {"reference": "Practitioner/12345678-1234-1234-1234-123456789abc", "display": "Dra. Ana Martín"}
  }],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "FUP",
        "display": "Follow-up"
      }]
    }],
    "value": [
      {"reference": "Condition/cc1111cc-2222-3333-4444-555566667777", "display": "Diabetes mellitus tipo 2"},
      {"reference": "AllergyIntolerance/aa1111bb-2222-3333-4444-555566667777", "display": "Alergia a la lactosa"}
    ]
  }]
}'::jsonb),
('f2b3c4d5-e6f7-890a-bcde-1234567890ab',
'{
  "resourceType": "Encounter",
  "id": "f2b3c4d5-e6f7-890a-bcde-1234567890ab",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "EMER",
      "display": "Emergency"
    }],
    "text": "Urgencia"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "417284009",
      "display": "Reacción alérgica aguda"
    }]
  }],
  "subject": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "actualPeriod": {
    "start": "2024-07-12T16:00:00Z",
    "end": "2024-07-12T17:00:00Z"
  },
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2024-07-12T16:00:00Z", "end": "2024-07-12T17:00:00Z"},
    "actor": {"reference": "Practitioner/f1a2b3c4-d5e6-7890-ab12-34567890abcd", "display": "Dr. Juan Pérez"}
  }],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "MEDNEC",
        "display": "Medical necessity"
      }]
    }],
    "value": [
      {"reference": "AllergyIntolerance/cc2222dd-3333-4444-5555-666677778888", "display": "Alergia a la aspirina"},
      {"reference": "Condition/dd2222dd-3333-4444-5555-666677778888", "display": "Reacción alérgica aguda"}
    ]
  }]
}'::jsonb),
('g3c4d5e6-f7a8-9012-bcde-2345678901bc',
'{
  "resourceType": "Encounter",
  "id": "g3c4d5e6-f7a8-9012-bcde-2345678901bc",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "IMP",
      "display": "Inpatient encounter"
    }],
    "text": "Ingreso hospitalario"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "324851000000109",
      "display": "Ingreso por accidente cerebrovascular"
    }]
  }],
  "subject": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"},
  "actualPeriod": {
    "start": "2024-07-15T08:00:00Z",
    "end": "2024-07-22T10:00:00Z"
  },
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2024-07-15T08:00:00Z", "end": "2024-07-22T10:00:00Z"},
    "actor": {"reference": "Practitioner/a1b2c3d4-e5f6-7890-abcd-9876543210fe", "display": "Dr. Ernesto Gómez"}
  }],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "MEDNEC",
        "display": "Medical necessity"
      }]
    }],
    "value": [
      {"reference": "Condition/ee3333ee-4444-5555-6666-777788889999", "display": "Diabetes mellitus tipo 2"},
      {"reference": "Condition/cc1111cc-2222-3333-4444-555566667777", "display": "Hipertensión arterial"}
    ]
  }]
}'::jsonb),
('h4d5e6f7-a8b9-0123-cdef-345678901234',
'{
  "resourceType": "Encounter",
  "id": "h4d5e6f7-a8b9-0123-cdef-345678901234",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "AMB",
      "display": "Ambulatory"
    }],
    "text": "Consulta ambulatoria"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "162673000",
      "display": "Consulta de seguimiento"
    }]
  }],
  "subject": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"},
  "actualPeriod": {
    "start": "2024-07-20T10:00:00Z",
    "end": "2024-07-20T10:40:00Z"
  },
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2024-07-20T10:00:00Z", "end": "2024-07-20T10:40:00Z"},
    "actor": {"reference": "Practitioner/22345678-1234-1234-1234-123456789abc", "display": "Dra. Marta Rodríguez"}
  }],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "FUP",
        "display": "Follow-up"
      }]
    }],
    "value": [
      {"reference": "MedicationRequest/cccccccc-5555-6666-7777-000000000012", "display": "Lopinavir/Ritonavir (Kaletra)"}
    ]
  }]
}'::jsonb),
('i5e6f7a8-b9c0-1234-def0-567890123456',
'{
  "resourceType": "Encounter",
  "id": "i5e6f7a8-b9c0-1234-def0-567890123456",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "AMB",
      "display": "Ambulatory"
    }],
    "text": "Consulta pediátrica"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "185349003",
      "display": "Consulta de control de asma"
    }]
  }],
  "subject": {"reference": "Patient/a2b3c4d5-e6f7-890a-bcde-f1234567890e"},
  "actualPeriod": {
    "start": "2024-07-22T08:00:00Z",
    "end": "2024-07-22T08:30:00Z"
  },
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2024-07-22T08:00:00Z", "end": "2024-07-22T08:30:00Z"},
    "actor": {"reference": "Practitioner/b2c3d4e5-2222-3333-4444-555566667777", "display": "Dr. Manuel Torres"}
  }],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "FUP",
        "display": "Follow-up"
      }]
    }],
    "value": [
      {"reference": "Condition/dd2222dd-3333-4444-5555-666677778888", "display": "Asma bronquial"}
    ]
  }],
  "contact": [{
    "name": {"family": "López", "given": ["María"]},
    "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "code": "MTH", "display": "Madre"}]}],
    "telecom": [{"system": "phone", "value": "+5355589012"}]
  }]
}'::jsonb),
('j6f7a8b9-c0d1-2345-ef01-678901234567',
'{
  "resourceType": "Encounter",
  "id": "j6f7a8b9-c0d1-2345-ef01-678901234567",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "AMB",
      "display": "Ambulatory"
    }],
    "text": "Consulta medicina interna"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "225929007",
      "display": "Consulta por dolor abdominal"
    }]
  }],
  "subject": {"reference": "Patient/b3c4d5e6-f7a8-9012-bcde-f2345678901f"},
  "actualPeriod": {
    "start": "2024-07-24T10:00:00Z",
    "end": "2024-07-24T10:30:00Z"
  },
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2024-07-24T10:00:00Z", "end": "2024-07-24T10:30:00Z"},
    "actor": {"reference": "Practitioner/33333333-4444-5555-6666-777777777777", "display": "Dr. Carlos Ramírez"}
  }],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "PATPREF",
        "display": "Patient preference"
      }]
    }],
    "value": [
      {"reference": "Condition/aa5555aa-6666-7777-8888-999900001111", "display": "Dolor abdominal inespecífico"}
    ]
  }]
}'::jsonb),
('k7a8b9c0-d1e2-3456-f012-789012345678',
'{
  "resourceType": "Encounter",
  "id": "k7a8b9c0-d1e2-3456-f012-789012345678",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "AMB",
      "display": "Ambulatory"
    }],
    "text": "Consulta geriátrica"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "162673000",
      "display": "Consulta de seguimiento"
    }]
  }],
  "subject": {"reference": "Patient/01a2b3c4-d5e6-7890-abcd-ef1234567890"},
  "actualPeriod": {
    "start": "2024-07-26T09:00:00Z",
    "end": "2024-07-26T09:30:00Z"
  },
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2024-07-26T09:00:00Z", "end": "2024-07-26T09:30:00Z"},
    "actor": {"reference": "Practitioner/aaaaaaa1-bbbb-cccc-dddd-eeeeeeeeeeee", "display": "Dra. Lucía Martínez"}
  }],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "FUP",
        "display": "Follow-up"
      }]
    }],
    "value": [
      {"reference": "Condition/ee3333ee-4444-5555-6666-777788889999", "display": "Diabetes mellitus tipo 2"},
      {"reference": "Condition/cc1111cc-2222-3333-4444-555566667777", "display": "Hipertensión arterial"},
      {"reference": "Condition/bb6666bb-7777-8888-9999-000011112222", "display": "Insuficiencia renal crónica"}
    ]
  }]
}'::jsonb),
('l8b9c0d1-e2f3-4567-0123-890123456789',
'{
  "resourceType": "Encounter",
  "id": "l8b9c0d1-e2f3-4567-0123-890123456789",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "AMB",
      "display": "Ambulatory"
    }],
    "text": "Consulta salud mental"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "408443003",
      "display": "Consulta por ansiedad"
    }]
  }],
  "subject": {"reference": "Patient/02b3c4d5-e6f7-890a-bcde-f12345678901"},
  "actualPeriod": {
    "start": "2024-07-28T10:00:00Z",
    "end": "2024-07-28T10:40:00Z"
  },
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2024-07-28T10:00:00Z", "end": "2024-07-28T10:40:00Z"},
    "actor": {"reference": "Practitioner/88888888-9999-aaaa-bbbb-cccccccccccc", "display": "Dra. Rosa Pérez"}
  }],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "PATPREF",
        "display": "Patient preference"
      }]
    }],
    "value": [
      {"reference": "Condition/cc8888cc-9999-0000-1111-222233334444", "display": "Ansiedad generalizada"}
    ]
  }]
}'::jsonb),
('m9c0d1e2-f345-6789-0123-901234567890',
'{
  "resourceType": "Encounter",
  "id": "m9c0d1e2-f345-6789-0123-901234567890",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "AMB",
      "display": "Ambulatory"
    }],
    "text": "Consulta obstétrica"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "4241000179101",
      "display": "Consulta prenatal"
    }]
  }],
  "subject": {"reference": "Patient/03c4d5e6-f7a8-9012-bcde-f23456789012"},
  "actualPeriod": {
    "start": "2024-07-30T09:00:00Z",
    "end": "2024-07-30T09:30:00Z"
  },
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2024-07-30T09:00:00Z", "end": "2024-07-30T09:30:00Z"},
    "actor": {"reference": "Practitioner/99999999-aaaa-bbbb-cccc-dddddddddddd", "display": "Dra. Rosa Pérez"}
  }],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "FUP",
        "display": "Follow-up"
      }]
    }],
    "value": [
      {"reference": "Condition/dd9999dd-aaaa-bbbb-cccc-ddddeeeeffff", "display": "Embarazo normal"}
    ]
  }],
  "contact": [{
    "name": {"family": "Fernández", "given": ["José"]},
    "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "code": "SPO", "display": "Cónyuge"}]}],
    "telecom": [{"system": "phone", "value": "+5355501234"}]
  }]
}'::jsonb),
('n0d1e2f3-4567-8901-2345-012345678901',
'{
  "resourceType": "Encounter",
  "id": "n0d1e2f3-4567-8901-2345-012345678901",
  "status": "finished",
  "classfhir": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-ActCode",
      "code": "HH",
      "display": "Home health"
    }],
    "text": "Atención domiciliaria"
  }],
  "type": [{
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "133931009",
      "display": "Visita domiciliaria"
    }]
  }],
  "subject": {"reference": "Patient/04d5e6f7-a8b9-0123-cdef-345678901234"},
  "actualPeriod": {
    "start": "2024-08-01T08:00:00Z",
    "end": "2024-08-01T08:45:00Z"
  },
  "participant": [
    {
      "type": [{
        "coding": [{
          "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
          "code": "PPRF",
          "display": "Médico de familia"
        }]
      }],
      "period": {"start": "2024-08-01T08:00:00Z", "end": "2024-08-01T08:45:00Z"},
      "actor": {"reference": "Practitioner/11111111-2222-3333-4444-555555555555", "display": "Dr. Mario Herrera"}
    },
    {
      "type": [{
        "coding": [{
          "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
          "code": "PART",
          "display": "Enfermero"
        }]
      }],
      "period": {"start": "2024-08-01T08:00:00Z", "end": "2024-08-01T08:45:00Z"},
      "actor": {"reference": "Practitioner/22222222-3333-4444-5555-666666666666", "display": "Lic. Sandra Pérez"}
    }
  ],
  "reason": [{
    "use": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ActReason",
        "code": "FUP",
        "display": "Follow-up"
      }]
    }],
    "value": [
      {"reference": "Condition/bb6666bb-7777-8888-9999-000011112222", "display": "Insuficiencia renal crónica"}
    ]
  }]
}'::jsonb);

-- 4. Condition(28) ✔
INSERT INTO conditions (id, resource) VALUES
('6d7e8f9a-1b2c-3d4e-5f6a-7b8c9d0e1f2a',
'{
  "resourceType": "Condition",
  "id": "6d7e8f9a-1b2c-3d4e-5f6a-7b8c9d0e1f2a",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "44054006",
      "display": "Diabetes mellitus tipo 2"
    }]
  },
  "subject": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "encounter": {"reference": "Encounter/8f9a0b1c-2d3e-4f5a-6b7c-8d9e0f1a2b3c"},
  "recordedDate": "2023-05-15T14:30:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/12345678-1234-1234-1234-123456789abc"}
  }]
}'::jsonb),
('f1a2b3c4-d5e6-7f8a-9b0c-d1e2f3a4b5c6',
'{
  "resourceType": "Condition",
  "id": "f1a2b3c4-d5e6-7f8a-9b0c-d1e2f3a4b5c6",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/condition-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "38341003", "display": "Hipertensión esencial (primaria)"}]},
  "subject": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "encounter": {"reference": "Encounter/123e4567-e89b-12d3-a456-426614174000"},
  "recordedDate": "2024-01-10T09:00:00",
  "participant": [{
    "function": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type", "code": "enterer", "display": "Enterer"}]},
    "actor": {"reference": "Practitioner/a1b2c3d4-1111-2222-3333-444455556666"}
  }]
}'::jsonb),
('a2b3c4d5-e6f7-8a9b-0c1d-2e3f4a5b6c7d',
'{
  "resourceType": "Condition",
  "id": "a2b3c4d5-e6f7-8a9b-0c1d-2e3f4a5b6c7d",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/condition-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "195967001", "display": "Asma bronquial"}]},
  "subject": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"},
  "encounter": {"reference": "Encounter/223e4567-e89b-12d3-a456-426614174001"},
  "recordedDate": "2024-03-15T14:00:00",
  "participant": [{
    "function": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type", "code": "enterer", "display": "Enterer"}]},
    "actor": {"reference": "Practitioner/b2c3d4e5-2222-3333-4444-555566667777"}
  }]
}'::jsonb),
('bb6666bb-7777-8888-9999-000011112222',
'{
  "resourceType": "Condition",
  "id": "bb6666bb-7777-8888-9999-000011112222",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "90721000119100",
      "display": "Insuficiencia renal crónica"
    }]
  },
  "subject": {"reference": "Patient/b3c4d5e6-f7a8-9012-bcde-f2345678901f"},
  "encounter": {"reference": "Encounter/e6f7a8b9-c0d1-2345-ef01-678901234567"},
  "recordedDate": "2024-06-20T08:30:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/22222222-3333-4444-5555-666666666666"}
  }]
}'::jsonb),

('cc1111cc-2222-3333-4444-555566667777',
'{
  "resourceType": "Condition",
  "id": "cc1111cc-2222-3333-4444-555566667777",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "38341003",
      "display": "Hipertensión arterial"
    }]
  },
  "subject": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "encounter": {"reference": "Encounter/a1b2c3d4-5678-1234-9abc-def012345678"},
  "recordedDate": "2024-01-10T09:00:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/f1a2b3c4-d5e6-7890-ab12-34567890abcd"}
  }]
}'::jsonb),

('dd2222dd-3333-4444-5555-666677778888',
'{
  "resourceType": "Condition",
  "id": "dd2222dd-3333-4444-5555-666677778888",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "195967001",
      "display": "Asma bronquial"
    }]
  },
  "subject": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"},
  "encounter": {"reference": "Encounter/b2c3d4e5-6789-2345-9bcd-ef1234567890"},
  "recordedDate": "2024-02-15T18:00:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/22345678-1234-1234-1234-123456789abc"}
  }]
}'::jsonb),

('ee3333ee-4444-5555-6666-777788889999',
'{
  "resourceType": "Condition",
  "id": "ee3333ee-4444-5555-6666-777788889999",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "44054006",
      "display": "Diabetes mellitus tipo 2"
    }]
  },
  "subject": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"},
  "encounter": {"reference": "Encounter/c3d4e5f6-7890-3456-9cde-f01234567890"},
  "recordedDate": "2024-03-20T10:00:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/a1b2c3d4-e5f6-7890-abcd-9876543210fe"}
  }]
}'::jsonb),

('ff4444ff-5555-6666-7777-888899990000',
'{
  "resourceType": "Condition",
  "id": "ff4444ff-5555-6666-7777-888899990000",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "233604007",
      "display": "Neumonía adquirida en la comunidad"
    }]
  },
  "subject": {"reference": "Patient/f1a2b3c4-5678-90ab-cdef-1234567890ad"},
  "encounter": {"reference": "Encounter/d4e5f6a7-8901-4567-9def-0123456789ab"},
  "recordedDate": "2024-04-05T14:00:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/65432109-abcd-4321-abcd-9876543210ff"}
  }]
}'::jsonb),
('aa5555aa-6666-7777-8888-999900001111',
'{
  "resourceType": "Condition",
  "id": "aa5555aa-6666-7777-8888-999900001111",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "271327008",
      "display": "Dolor abdominal inespecífico"
    }]
  },
  "subject": {"reference": "Patient/a2b3c4d5-e6f7-890a-bcde-f1234567890e"},
  "encounter": {"reference": "Encounter/d5e6f7a8-b9c0-1234-def0-567890123456"},
  "recordedDate": "2024-06-18T13:00:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/33333333-4444-5555-6666-777777777777"}
  }]
}'::jsonb),

('cc7777cc-8888-9999-0000-111122223333',
'{
  "resourceType": "Condition",
  "id": "cc7777cc-8888-9999-0000-111122223333",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "40930008",
      "display": "Hipotiroidismo"
    }]
  },
  "subject": {"reference": "Patient/01a2b3c4-d5e6-7890-abcd-ef1234567890"},
  "encounter": {"reference": "Encounter/f7a8b9c0-d1e2-3456-f012-789012345678"},
  "recordedDate": "2024-06-22T10:30:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/aaaaaaa1-bbbb-cccc-dddd-eeeeeeeeeeee"}
  }]
}'::jsonb),

('dd8888dd-9999-0000-1111-222233334444',
'{
  "resourceType": "Condition",
  "id": "dd8888dd-9999-0000-1111-222233334444",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "386661006",
      "display": "Crisis hipertensiva"
    }]
  },
  "subject": {"reference": "Patient/02b3c4d5-e6f7-890a-bcde-f12345678901"},
  "encounter": {"reference": "Encounter/a9b0c1d2-e3f4-5678-9012-34567890abcd"},
  "recordedDate": "2024-06-25T18:00:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/33333334-4444-5555-6666-777777777778"}
  }]
}'::jsonb),

('ee9999ee-aaaa-bbbb-cccc-ddddeeeeffff',
'{
  "resourceType": "Condition",
  "id": "ee9999ee-aaaa-bbbb-cccc-ddddeeeeffff",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "271442005",
      "display": "Anemia ferropénica"
    }]
  },
  "subject": {"reference": "Patient/03c4d5e6-f7a8-9012-bcde-f23456789012"},
  "encounter": {"reference": "Encounter/b0c1d2e3-f456-7890-1234-567890abcdef"},
  "recordedDate": "2024-06-28T09:00:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/88888888-9999-aaaa-bbbb-cccccccccccc"}
  }]
}'::jsonb),

('ffaaaaff-bbbb-cccc-dddd-eeeeffff0000',
'{
  "resourceType": "Condition",
  "id": "ffaaaaff-bbbb-cccc-dddd-eeeeffff0000",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "302866003",
      "display": "Hiperglucemia"
    }]
  },
  "subject": {"reference": "Patient/04d5e6f7-a8b9-0123-cdef-345678901234"},
  "encounter": {"reference": "Encounter/c1d2e3f4-5678-90ab-cdef-1234567890ac"},
  "recordedDate": "2024-07-01T10:00:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/99999999-aaaa-bbbb-cccc-dddddddddddd"}
  }]
}'::jsonb),

('cc8888cc-9999-0000-1111-222233334444',
'{
  "resourceType": "Condition",
  "id": "cc8888cc-9999-0000-1111-222233334444",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "324220009",
      "display": "Ansiedad generalizada"
    }]
  },
  "subject": {"reference": "Patient/02b3c4d5-e6f7-890a-bcde-f12345678901"},
  "encounter": {"reference": "Encounter/l8b9c0d1-e2f3-4567-0123-890123456789"},
  "recordedDate": "2024-07-28T10:00:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/88888888-9999-aaaa-bbbb-cccccccccccc"}
  }]
}'::jsonb),

('dd9999dd-aaaa-bbbb-cccc-ddddeeeeffff',
'{
  "resourceType": "Condition",
  "id": "dd9999dd-aaaa-bbbb-cccc-ddddeeeeffff",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "72892002",
      "display": "Embarazo normal"
    }]
  },
  "subject": {"reference": "Patient/03c4d5e6-f7a8-9012-bcde-f23456789012"},
  "encounter": {"reference": "Encounter/m9c0d1e2-f345-6789-0123-901234567890"},
  "recordedDate": "2024-07-30T09:00:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/99999999-aaaa-bbbb-cccc-dddddddddddd"}
  }]
}'::jsonb),

('bb7777bb-8888-9999-0000-111122223334',
'{
  "resourceType": "Condition",
  "id": "bb7777bb-8888-9999-0000-111122223334",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "233604007",
      "display": "Neumonía adquirida en la comunidad"
    }]
  },
  "subject": {"reference": "Patient/05e6f7a8-b9c0-1234-def0-567890123456"},
  "encounter": {"reference": "Encounter/c4d5e6f7-a8b9-0123-cdef-345678901234"},
  "recordedDate": "2024-06-15T15:00:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/65432109-abcd-4321-abcd-9876543210ff"}
  }]
}'::jsonb),

('ee4444ee-5555-6666-7777-888899990001',
'{
  "resourceType": "Condition",
  "id": "ee4444ee-5555-6666-7777-888899990001",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "195967001",
      "display": "Asma bronquial"
    }]
  },
  "subject": {"reference": "Patient/a2b3c4d5-e6f7-890a-bcde-f1234567890e"},
  "encounter": {"reference": "Encounter/i5e6f7a8-b9c0-1234-def0-567890123456"},
  "recordedDate": "2024-07-22T08:00:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/b2c3d4e5-2222-3333-4444-555566667777"}
  }]
}'::jsonb),

('bb8888bb-9999-0000-1111-222233334445',
'{
  "resourceType": "Condition",
  "id": "bb8888bb-9999-0000-1111-222233334445",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "44054006",
      "display": "Diabetes mellitus tipo 2"
    }]
  },
  "subject": {"reference": "Patient/06f7a8b9-c0d1-2345-ef01-678901234567"},
  "encounter": {"reference": "Encounter/e6f7a8b9-c0d1-2345-ef01-678901234567"},
  "recordedDate": "2024-06-20T08:00:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/22222222-3333-4444-5555-666666666666"}
  }]
}'::jsonb),
('cc9999cc-8888-7777-6666-555544443333',
'{
  "resourceType": "Condition",
  "id": "cc9999cc-8888-7777-6666-555544443333",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "195967001",
      "display": "Asma bronquial"
    }]
  },
  "subject": {"reference": "Patient/08b9c0d1-e2f3-4567-0123-890123456789"},
  "encounter": {"reference": "Encounter/n0d1e2f3-4567-8901-2345-012345678901"},
  "recordedDate": "2024-08-01T08:00:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/11111111-2222-3333-4444-555555555555"}
  }]
}'::jsonb),

('bb1111bb-2222-3333-4444-555566667777',
'{
  "resourceType": "Condition",
  "id": "bb1111bb-2222-3333-4444-555566667777",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "44054006",
      "display": "Diabetes mellitus tipo 2"
    }]
  },
  "subject": {"reference": "Patient/09c0d1e2-f345-6789-0123-901234567890"},
  "encounter": {"reference": "Encounter/e5f6a7b8-9012-5678-9efa-123456789abc"},
  "recordedDate": "2024-05-12T11:00:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/33333333-4444-5555-6666-777777777777"}
  }]
}'::jsonb),

('aa2222aa-3333-4444-5555-666677778888',
'{
  "resourceType": "Condition",
  "id": "aa2222aa-3333-4444-5555-666677778888",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "233604007",
      "display": "Neumonía adquirida en la comunidad"
    }]
  },
  "subject": {"reference": "Patient/10d1e2f3-4567-8901-2345-012345678901"},
  "encounter": {"reference": "Encounter/e5f6a7b8-9012-5678-9efa-123456789abc"},
  "recordedDate": "2024-05-12T11:00:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/33333333-4444-5555-6666-777777777777"}
  }]
}'::jsonb),

('dd3333dd-4444-5555-6666-777788889999',
'{
  "resourceType": "Condition",
  "id": "dd3333dd-4444-5555-6666-777788889999",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "38341003",
      "display": "Hipertensión arterial"
    }]
  },
  "subject": {"reference": "Patient/07a8b9c0-d1e2-3456-f012-789012345678"},
  "encounter": {"reference": "Encounter/f7a8b9c0-d1e2-3456-f012-789012345678"},
  "recordedDate": "2024-06-22T10:30:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/aaaaaaa1-bbbb-cccc-dddd-eeeeeeeeeeee"}
  }]
}'::jsonb),

('ee5555ee-6666-7777-8888-999900001111',
'{
  "resourceType": "Condition",
  "id": "ee5555ee-6666-7777-8888-999900001111",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "324220009",
      "display": "Ansiedad generalizada"
    }]
  },
  "subject": {"reference": "Patient/02b3c4d5-e6f7-890a-bcde-f12345678901"},
  "encounter": {"reference": "Encounter/l8b9c0d1-e2f3-4567-0123-890123456789"},
  "recordedDate": "2024-07-28T10:00:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/88888888-9999-aaaa-bbbb-cccccccccccc"}
  }]
}'::jsonb),

('ff6666ff-7777-8888-9999-000011112222',
'{
  "resourceType": "Condition",
  "id": "ff6666ff-7777-8888-9999-000011112222",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "72892002",
      "display": "Embarazo normal"
    }]
  },
  "subject": {"reference": "Patient/04d5e6f7-a8b9-0123-cdef-345678901234"},
  "encounter": {"reference": "Encounter/m9c0d1e2-f345-6789-0123-901234567890"},
  "recordedDate": "2024-07-30T09:00:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/99999999-aaaa-bbbb-cccc-dddddddddddd"}
  }]
}'::jsonb),

('aa3333aa-4444-5555-6666-777788889999',
'{
  "resourceType": "Condition",
  "id": "aa3333aa-4444-5555-6666-777788889999",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "90721000119100",
      "display": "Insuficiencia renal crónica"
    }]
  },
  "subject": {"reference": "Patient/06f7a8b9-c0d1-2345-ef01-678901234567"},
  "encounter": {"reference": "Encounter/e6f7a8b9-c0d1-2345-ef01-678901234567"},
  "recordedDate": "2024-06-20T08:00:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/22222222-3333-4444-5555-666666666666"}
  }]
}'::jsonb),

('bb2222bb-3333-4444-5555-666677778888',
'{
  "resourceType": "Condition",
  "id": "bb2222bb-3333-4444-5555-666677778888",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "271442005",
      "display": "Anemia ferropénica"
    }]
  },
  "subject": {"reference": "Patient/03c4d5e6-f7a8-9012-bcde-f23456789012"},
  "encounter": {"reference": "Encounter/b0c1d2e3-f456-7890-1234-567890abcdef"},
  "recordedDate": "2024-06-28T09:00:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/88888888-9999-aaaa-bbbb-cccccccccccc"}
  }]
}'::jsonb),

('cc4444cc-5555-6666-7777-888899990000',
'{
  "resourceType": "Condition",
  "id": "cc4444cc-5555-6666-7777-888899990000",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "302866003",
      "display": "Hiperglucemia"
    }]
  },
  "subject": {"reference": "Patient/04d5e6f7-a8b9-0123-cdef-345678901234"},
  "encounter": {"reference": "Encounter/c1d2e3f4-5678-90ab-cdef-1234567890ac"},
  "recordedDate": "2024-07-01T10:00:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/99999999-aaaa-bbbb-cccc-dddddddddddd"}
  }]
}'::jsonb),

('dd5555dd-6666-7777-8888-999900001111',
'{
  "resourceType": "Condition",
  "id": "dd5555dd-6666-7777-8888-999900001111",
  "clinicalStatus": {
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/condition-clinical",
      "code": "active"
    }]
  },
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "40930008",
      "display": "Hipotiroidismo"
    }]
  },
  "subject": {"reference": "Patient/01a2b3c4-d5e6-7890-abcd-ef1234567890"},
  "encounter": {"reference": "Encounter/f7a8b9c0-d1e2-3456-f012-789012345678"},
  "recordedDate": "2024-06-22T10:30:00",
  "participant": [{
    "function": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/provenance-participant-type",
        "code": "enterer",
        "display": "Enterer"
      }]
    },
    "actor": {"reference": "Practitioner/aaaaaaa1-bbbb-cccc-dddd-eeeeeeeeeeee"}
  }]
}'::jsonb);

-- 5. Appointment(21) ✔
INSERT INTO appointments (id, resource) VALUES
('2b3c4d5e-6f7a-8b9c-0d1e-2f3a4b5c6d7e',
'{
  "resourceType": "Appointment",
  "id": "2b3c4d5e-6f7a-8b9c-0d1e-2f3a4b5c6d7e",
  "status": "booked",
  "start": "2025-06-20T09:00:00Z",
  "participant": [{
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PPRF",
        "display": "Intérprete principal"
      }]
    }],
    "period": {"start": "2025-06-20T09:00:00Z", "end": "2025-06-20T09:30:00Z"},
    "actor": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a", "display": "María Elena"},
    "required": true,
    "status": "accepted"
  },
  {
    "type": [{
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType",
        "code": "PRF",
        "display": "Profesional"
      }]
    }],
    "period": {"start": "2025-06-20T09:00:00Z", "end": "2025-06-20T09:30:00Z"},
    "actor": {
      "reference": "Practitioner/12345678-1234-1234-1234-123456789abc",
      "display": "Dra. Ana López"
    },
    "required": true,
    "status": "accepted"
  }],
  "description": "Consulta de control de diabetes"
}'::jsonb),
('a1b2c3d4-5678-1234-9abc-def0123456789',
'{
  "resourceType": "Appointment",
  "id": "a1b2c3d4-5678-1234-9abc-def0123456789",
  "status": "booked",
  "start": "2025-06-21T10:00:00Z",
  "participant": [
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PPRF", "display": "Intérprete principal"}]}],
      "period": {"start": "2025-06-21T10:00:00Z", "end": "2025-06-21T10:30:00Z"},
      "actor": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab", "display": "Lázaro González"},
      "required": true,
      "status": "accepted"
    },
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PRF", "display": "Profesional"}]}],
      "period": {"start": "2025-06-21T10:00:00Z", "end": "2025-06-21T10:30:00Z"},
      "actor": {"reference": "Practitioner/f1a2b3c4-d5e6-7890-ab12-34567890abcd", "display": "Dr. Juan Pérez"},
      "required": true,
      "status": "accepted"
    }
  ],
  "description": "Consulta de urgencia por asma bronquial"
}'::jsonb),

('b2c3d4e5-6789-2345-9bcd-ef1234567891',
'{
  "resourceType": "Appointment",
  "id": "b2c3d4e5-6789-2345-9bcd-ef1234567891",
  "status": "booked",
  "start": "2025-06-22T11:00:00Z",
  "participant": [
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PPRF", "display": "Intérprete principal"}]}],
      "period": {"start": "2025-06-22T11:00:00Z", "end": "2025-06-22T11:30:00Z"},
      "actor": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777", "display": "Isabel Valdés"},
      "required": true,
      "status": "accepted"
    },
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PRF", "display": "Profesional"}]}],
      "period": {"start": "2025-06-22T11:00:00Z", "end": "2025-06-22T11:30:00Z"},
      "actor": {"reference": "Practitioner/22345678-1234-1234-1234-123456789abc", "display": "Dra. Marta Rodríguez"},
      "required": true,
      "status": "accepted"
    }
  ],
  "description": "Consulta de seguimiento por diabetes"
}'::jsonb),

('c3d4e5f6-7890-3456-9cde-f01234567891',
'{
  "resourceType": "Appointment",
  "id": "c3d4e5f6-7890-3456-9cde-f01234567891",
  "status": "booked",
  "start": "2025-06-23T09:00:00Z",
  "participant": [
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PPRF", "display": "Intérprete principal"}]}],
      "period": {"start": "2025-06-23T09:00:00Z", "end": "2025-06-23T09:30:00Z"},
      "actor": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678", "display": "Lázaro González"},
      "required": true,
      "status": "accepted"
    },
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PRF", "display": "Profesional"}]}],
      "period": {"start": "2025-06-23T09:00:00Z", "end": "2025-06-23T09:30:00Z"},
      "actor": {"reference": "Practitioner/a1b2c3d4-e5f6-7890-abcd-9876543210fe", "display": "Dr. Ernesto Gómez"},
      "required": true,
      "status": "accepted"
    }
  ],
  "description": "Consulta de control por hipertensión arterial"
}'::jsonb),

('d4e5f6a7-8901-4567-9def-012345678912',
'{
  "resourceType": "Appointment",
  "id": "d4e5f6a7-8901-4567-9def-012345678912",
  "status": "booked",
  "start": "2025-06-24T08:00:00Z",
  "participant": [
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PPRF", "display": "Intérprete principal"}]}],
      "period": {"start": "2025-06-24T08:00:00Z", "end": "2025-06-24T08:30:00Z"},
      "actor": {"reference": "Patient/f1a2b3c4-5678-90ab-cdef-1234567890ad", "display": "Roberto Díaz"},
      "required": true,
      "status": "accepted"
    },
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PRF", "display": "Profesional"}]}],
      "period": {"start": "2025-06-24T08:00:00Z", "end": "2025-06-24T08:30:00Z"},
      "actor": {"reference": "Practitioner/65432109-abcd-4321-abcd-9876543210ff", "display": "Dra. Teresa Suárez"},
      "required": true,
      "status": "accepted"
    }
  ],
  "description": "Consulta por neumonía adquirida en la comunidad"
}'::jsonb),

('e5f6a7b8-9012-5678-9efa-123456789913',
'{
  "resourceType": "Appointment",
  "id": "e5f6a7b8-9012-5678-9efa-123456789913",
  "status": "booked",
  "start": "2025-06-25T13:00:00Z",
  "participant": [
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PPRF", "display": "Intérprete principal"}]}],
      "period": {"start": "2025-06-25T13:00:00Z", "end": "2025-06-25T13:30:00Z"},
      "actor": {"reference": "Patient/10d1e2f3-4567-8901-2345-012345678901", "display": "Carlos Pérez"},
      "required": true,
      "status": "accepted"
    },
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PRF", "display": "Profesional"}]}],
      "period": {"start": "2025-06-25T13:00:00Z", "end": "2025-06-25T13:30:00Z"},
      "actor": {"reference": "Practitioner/33333333-4444-5555-6666-777777777777", "display": "Dr. Carlos Ramírez"},
      "required": true,
      "status": "accepted"
    }
  ],
  "description": "Consulta por dolor abdominal inespecífico"
}'::jsonb),

('f6a7b8c9-0123-4567-89ab-cdef12345678',
'{
  "resourceType": "Appointment",
  "id": "f6a7b8c9-0123-4567-89ab-cdef12345678",
  "status": "booked",
  "start": "2025-06-26T09:00:00Z",
  "participant": [
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PPRF", "display": "Intérprete principal"}]}],
      "period": {"start": "2025-06-26T09:00:00Z", "end": "2025-06-26T09:30:00Z"},
      "actor": {"reference": "Patient/a2b3c4d5-e6f7-890a-bcde-f1234567890e", "display": "Marta Suárez"},
      "required": true,
      "status": "accepted"
    },
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PRF", "display": "Profesional"}]}],
      "period": {"start": "2025-06-26T09:00:00Z", "end": "2025-06-26T09:30:00Z"},
      "actor": {"reference": "Practitioner/b2c3d4e5-2222-3333-4444-555566667777", "display": "Dr. Manuel Torres"},
      "required": true,
      "status": "accepted"
    }
  ],
  "description": "Consulta pediátrica de control de asma"
}'::jsonb),

('a7b8c9d0-1234-5678-9abc-def012345679',
'{
  "resourceType": "Appointment",
  "id": "a7b8c9d0-1234-5678-9abc-def012345679",
  "status": "booked",
  "start": "2025-06-27T10:00:00Z",
  "participant": [
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PPRF", "display": "Intérprete principal"}]}],
      "period": {"start": "2025-06-27T10:00:00Z", "end": "2025-06-27T10:30:00Z"},
      "actor": {"reference": "Patient/01a2b3c4-d5e6-7890-abcd-ef1234567890", "display": "Yanelis Martínez"},
      "required": true,
      "status": "accepted"
    },
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PRF", "display": "Profesional"}]}],
      "period": {"start": "2025-06-27T10:00:00Z", "end": "2025-06-27T10:30:00Z"},
      "actor": {"reference": "Practitioner/aaaaaaa1-bbbb-cccc-dddd-eeeeeeeeeeee", "display": "Dra. Lucía Martínez"},
      "required": true,
      "status": "accepted"
    }
  ],
  "description": "Consulta de geriatría por polifarmacia"
}'::jsonb),

('b8c9d0e1-2345-6789-abcd-ef0123456790',
'{
  "resourceType": "Appointment",
  "id": "b8c9d0e1-2345-6789-abcd-ef0123456790",
  "status": "booked",
  "start": "2025-06-28T11:00:00Z",
  "participant": [
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PPRF", "display": "Intérprete principal"}]}],
      "period": {"start": "2025-06-28T11:00:00Z", "end": "2025-06-28T11:30:00Z"},
      "actor": {"reference": "Patient/02b3c4d5-e6f7-890a-bcde-f12345678901", "display": "María Vega"},
      "required": true,
      "status": "accepted"
    },
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PRF", "display": "Profesional"}]}],
      "period": {"start": "2025-06-28T11:00:00Z", "end": "2025-06-28T11:30:00Z"},
      "actor": {"reference": "Practitioner/88888888-9999-aaaa-bbbb-cccccccccccc", "display": "Dra. Rosa Pérez"},
      "required": true,
      "status": "accepted"
    }
  ],
  "description": "Consulta de salud mental por ansiedad"
}'::jsonb),

('c9d0e1f2-3456-789a-bcde-f01234567901',
'{
  "resourceType": "Appointment",
  "id": "c9d0e1f2-3456-789a-bcde-f01234567901",
  "status": "booked",
  "start": "2025-06-29T09:00:00Z",
  "participant": [
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PPRF", "display": "Intérprete principal"}]}],
      "period": {"start": "2025-06-29T09:00:00Z", "end": "2025-06-29T09:30:00Z"},
      "actor": {"reference": "Patient/03c4d5e6-f7a8-9012-bcde-f23456789012", "display": "Ana Fernández"},
      "required": true,
      "status": "accepted"
    },
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PRF", "display": "Profesional"}]}],
      "period": {"start": "2025-06-29T09:00:00Z", "end": "2025-06-29T09:30:00Z"},
      "actor": {"reference": "Practitioner/99999999-aaaa-bbbb-cccc-dddddddddddd", "display": "Dra. Rosa Pérez"},
      "required": true,
      "status": "accepted"
    }
  ],
  "description": "Consulta prenatal"
}'::jsonb),

('d0e1f2a3-4567-89ab-cdef-012345679012',
'{
  "resourceType": "Appointment",
  "id": "d0e1f2a3-4567-89ab-cdef-012345679012",
  "status": "booked",
  "start": "2025-06-30T08:00:00Z",
  "participant": [
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PPRF", "display": "Médico de familia"}]}],
      "period": {"start": "2025-06-30T08:00:00Z", "end": "2025-06-30T08:45:00Z"},
      "actor": {"reference": "Patient/04d5e6f7-a8b9-0123-cdef-345678901234", "display": "Carlos Pérez"},
      "required": true,
      "status": "accepted"
    },
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PRF", "display": "Enfermero"}]}],
      "period": {"start": "2025-06-30T08:00:00Z", "end": "2025-06-30T08:45:00Z"},
      "actor": {"reference": "Practitioner/22222222-3333-4444-5555-666666666666", "display": "Lic. Sandra Pérez"},
      "required": true,
      "status": "accepted"
    }
  ],
  "description": "Atención domiciliaria por insuficiencia renal crónica"
}'::jsonb),
('e1a2b3c4-d5f6-7890-1a2b-3c4d5e6f7a8b',
'{
  "resourceType": "Appointment",
  "id": "e1a2b3c4-d5f6-7890-1a2b-3c4d5e6f7a8b",
  "status": "booked",
  "start": "2025-07-01T09:00:00Z",
  "participant": [
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PPRF", "display": "Intérprete principal"}]}],
      "period": {"start": "2025-07-01T09:00:00Z", "end": "2025-07-01T09:30:00Z"},
      "actor": {"reference": "Patient/b3c4d5e6-f7a8-9012-bcde-f2345678901f", "display": "Yanelis Martínez"},
      "required": true,
      "status": "accepted"
    },
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PRF", "display": "Profesional"}]}],
      "period": {"start": "2025-07-01T09:00:00Z", "end": "2025-07-01T09:30:00Z"},
      "actor": {"reference": "Practitioner/22222222-3333-4444-5555-666666666666", "display": "Dr. Manuel Torres"},
      "required": true,
      "status": "accepted"
    }
  ],
  "description": "Consulta de control renal crónico"
}'::jsonb),

('f2b3c4d5-e6f7-890a-bcde-1234567890ab',
'{
  "resourceType": "Appointment",
  "id": "f2b3c4d5-e6f7-890a-bcde-1234567890ab",
  "status": "booked",
  "start": "2025-07-02T10:00:00Z",
  "participant": [
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PPRF", "display": "Intérprete principal"}]}],
      "period": {"start": "2025-07-02T10:00:00Z", "end": "2025-07-02T10:30:00Z"},
      "actor": {"reference": "Patient/05e6f7a8-b9c0-1234-def0-567890123456", "display": "Miguel García"},
      "required": true,
      "status": "accepted"
    },
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PRF", "display": "Profesional"}]}],
      "period": {"start": "2025-07-02T10:00:00Z", "end": "2025-07-02T10:30:00Z"},
      "actor": {"reference": "Practitioner/65432109-abcd-4321-abcd-9876543210ff", "display": "Dra. Teresa Suárez"},
      "required": true,
      "status": "accepted"
    }
  ],
  "description": "Consulta de control post-neumonía"
}'::jsonb),

('g3c4d5e6-f7a8-9012-bcde-2345678901bc',
'{
  "resourceType": "Appointment",
  "id": "g3c4d5e6-f7a8-9012-bcde-2345678901bc",
  "status": "booked",
  "start": "2025-07-03T08:00:00Z",
  "participant": [
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PPRF", "display": "Intérprete principal"}]}],
      "period": {"start": "2025-07-03T08:00:00Z", "end": "2025-07-03T08:30:00Z"},
      "actor": {"reference": "Patient/06f7a8b9-c0d1-2345-ef01-678901234567", "display": "Elena Rodríguez"},
      "required": true,
      "status": "accepted"
    },
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PRF", "display": "Profesional"}]}],
      "period": {"start": "2025-07-03T08:00:00Z", "end": "2025-07-03T08:30:00Z"},
      "actor": {"reference": "Practitioner/33333334-4444-5555-6666-777777777778", "display": "Dr. Pedro Díaz"},
      "required": true,
      "status": "accepted"
    }
  ],
  "description": "Consulta de seguimiento por diabetes"
}'::jsonb),

('h4d5e6f7-a8b9-0123-cdef-345678901234',
'{
  "resourceType": "Appointment",
  "id": "h4d5e6f7-a8b9-0123-cdef-345678901234",
  "status": "booked",
  "start": "2025-07-04T11:00:00Z",
  "participant": [
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PPRF", "display": "Intérprete principal"}]}],
      "period": {"start": "2025-07-04T11:00:00Z", "end": "2025-07-04T11:30:00Z"},
      "actor": {"reference": "Patient/07a8b9c0-d1e2-3456-f012-789012345678", "display": "Luz Fernández"},
      "required": true,
      "status": "accepted"
    },
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PRF", "display": "Profesional"}]}],
      "period": {"start": "2025-07-04T11:00:00Z", "end": "2025-07-04T11:30:00Z"},
      "actor": {"reference": "Practitioner/aaaaaaa1-bbbb-cccc-dddd-eeeeeeeeeeee", "display": "Dra. Lucía Martínez"},
      "required": true,
      "status": "accepted"
    }
  ],
  "description": "Consulta por control de hipertensión"
}'::jsonb),

('i5e6f7a8-b9c0-1234-def0-567890123456',
'{
  "resourceType": "Appointment",
  "id": "i5e6f7a8-b9c0-1234-def0-567890123456",
  "status": "booked",
  "start": "2025-07-05T10:00:00Z",
  "participant": [
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PPRF", "display": "Intérprete principal"}]}],
      "period": {"start": "2025-07-05T10:00:00Z", "end": "2025-07-05T10:30:00Z"},
      "actor": {"reference": "Patient/08b9c0d1-e2f3-4567-0123-890123456789", "display": "José Molina"},
      "required": true,
      "status": "accepted"
    },
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PRF", "display": "Profesional"}]}],
      "period": {"start": "2025-07-05T10:00:00Z", "end": "2025-07-05T10:30:00Z"},
      "actor": {"reference": "Practitioner/11111111-2222-3333-4444-555555555555", "display": "Dr. Mario Herrera"},
      "required": true,
      "status": "accepted"
    }
  ],
  "description": "Consulta por asma bronquial"
}'::jsonb),

('j6f7a8b9-c0d1-2345-ef01-678901234567',
'{
  "resourceType": "Appointment",
  "id": "j6f7a8b9-c0d1-2345-ef01-678901234567",
  "status": "booked",
  "start": "2025-07-06T09:00:00Z",
  "participant": [
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PPRF", "display": "Intérprete principal"}]}],
      "period": {"start": "2025-07-06T09:00:00Z", "end": "2025-07-06T09:30:00Z"},
      "actor": {"reference": "Patient/09c0d1e2-f345-6789-0123-901234567890", "display": "Luis Castro"},
      "required": true,
      "status": "accepted"
    },
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PRF", "display": "Profesional"}]}],
      "period": {"start": "2025-07-06T09:00:00Z", "end": "2025-07-06T09:30:00Z"},
      "actor": {"reference": "Practitioner/22222222-3333-4444-5555-666666666666", "display": "Dr. Manuel Torres"},
      "required": true,
      "status": "accepted"
    }
  ],
  "description": "Consulta pediátrica por control de hijo"
}'::jsonb),

('k7a8b9c0-d1e2-3456-f012-789012345678',
'{
  "resourceType": "Appointment",
  "id": "k7a8b9c0-d1e2-3456-f012-789012345678",
  "status": "booked",
  "start": "2025-07-07T08:00:00Z",
  "participant": [
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PPRF", "display": "Intérprete principal"}]}],
      "period": {"start": "2025-07-07T08:00:00Z", "end": "2025-07-07T08:30:00Z"},
      "actor": {"reference": "Patient/10d1e2f3-4567-8901-2345-012345678901", "display": "Carlos Pérez"},
      "required": true,
      "status": "accepted"
    },
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PRF", "display": "Profesional"}]}],
      "period": {"start": "2025-07-07T08:00:00Z", "end": "2025-07-07T08:30:00Z"},
      "actor": {"reference": "Practitioner/33333333-4444-5555-6666-777777777777", "display": "Dr. Carlos Ramírez"},
      "required": true,
      "status": "accepted"
    }
  ],
  "description": "Consulta de control de anemia"
}'::jsonb),

('l8b9c0d1-e2f3-4567-0123-890123456789',
'{
  "resourceType": "Appointment",
  "id": "l8b9c0d1-e2f3-4567-0123-890123456789",
  "status": "booked",
  "start": "2025-07-08T11:00:00Z",
  "participant": [
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PPRF", "display": "Intérprete principal"}]}],
      "period": {"start": "2025-07-08T11:00:00Z", "end": "2025-07-08T11:30:00Z"},
      "actor": {"reference": "Patient/02b3c4d5-e6f7-890a-bcde-f12345678901", "display": "María Vega"},
      "required": true,
      "status": "accepted"
    },
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PRF", "display": "Profesional"}]}],
      "period": {"start": "2025-07-08T11:00:00Z", "end": "2025-07-08T11:30:00Z"},
      "actor": {"reference": "Practitioner/88888888-9999-aaaa-bbbb-cccccccccccc", "display": "Dra. Rosa Pérez"},
      "required": true,
      "status": "accepted"
    }
  ],
  "description": "Consulta de seguimiento por alergia alimentaria"
}'::jsonb),

('m9c0d1e2-f345-6789-0123-901234567890',
'{
  "resourceType": "Appointment",
  "id": "m9c0d1e2-f345-6789-0123-901234567890",
  "status": "booked",
  "start": "2025-07-09T09:00:00Z",
  "participant": [
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PPRF", "display": "Intérprete principal"}]}],
      "period": {"start": "2025-07-09T09:00:00Z", "end": "2025-07-09T09:30:00Z"},
      "actor": {"reference": "Patient/03c4d5e6-f7a8-9012-bcde-f23456789012", "display": "Ana Fernández"},
      "required": true,
      "status": "accepted"
    },
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PRF", "display": "Profesional"}]}],
      "period": {"start": "2025-07-09T09:00:00Z", "end": "2025-07-09T09:30:00Z"},
      "actor": {"reference": "Practitioner/99999999-aaaa-bbbb-cccc-dddddddddddd", "display": "Dra. Rosa Pérez"},
      "required": true,
      "status": "accepted"
    }
  ],
  "description": "Consulta prenatal y control de embarazo"
}'::jsonb),

('n0d1e2f3-4567-8901-2345-012345678901',
'{
  "resourceType": "Appointment",
  "id": "n0d1e2f3-4567-8901-2345-012345678901",
  "status": "booked",
  "start": "2025-07-10T08:00:00Z",
  "participant": [
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PPRF", "display": "Médico de familia"}]}],
      "period": {"start": "2025-07-10T08:00:00Z", "end": "2025-07-10T08:45:00Z"},
      "actor": {"reference": "Patient/04d5e6f7-a8b9-0123-cdef-345678901234", "display": "Carlos Pérez"},
      "required": true,
      "status": "accepted"
    },
    {
      "type": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-ParticipationType", "code": "PRF", "display": "Enfermero"}]}],
      "period": {"start": "2025-07-10T08:00:00Z", "end": "2025-07-10T08:45:00Z"},
      "actor": {"reference": "Practitioner/22222222-3333-4444-5555-666666666666", "display": "Lic. Sandra Pérez"},
      "required": true,
      "status": "accepted"
    }
  ],
  "description": "Atención domiciliaria y seguimiento de insuficiencia renal"
}'::jsonb);

-- 6. MedicationRequest(26) ✔
INSERT INTO medication_requests (id, resource) VALUES
('b2c3d4e5-f6a7-8b9c-0d1e-2f3a4b5c6d7e',
'{
  "resourceType": "MedicationRequest",
  "id": "b2c3d4e5-f6a7-8b9c-0d1e-2f3a4b5c6d7e",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/insulina-rdna", "display": "Insulina Recombinante Humana (rDNA)"},
  "subject": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "requester": {
    "reference": "Practitioner/12345678-1234-1234-1234-123456789abc",
    "display": "Dr. José Ramírez"
},
  "reason": [{"reference": "Condition/diabetes-tipo2"}],
  "dosageInstruction": [{"text": "Aplicar 10 unidades subcutáneas antes del desayuno diariamente"}],
  "renderedDosageInstruction": "Aplicar 10 unidades subcutáneas antes del desayuno diariamente",
  "authoredOn": "2023-10-12T10:00:00"
}'::jsonb),
('11111111-aaaa-bbbb-cccc-000000000001',
'{
  "resourceType": "MedicationRequest",
  "id": "11111111-aaaa-bbbb-cccc-000000000001",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/insulina-rdna", "display": "Insulina Recombinante Humana (rDNA)"},
  "subject": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "requester": {"reference": "Practitioner/12345678-1234-1234-1234-123456789abc", "display": "Dr. José Ramírez"},
  "reason": [{"reference": "Condition/diabetes-tipo2"}],
  "dosageInstruction": [{"text": "Aplicar 10 unidades subcutáneas antes del desayuno diariamente"}],
  "renderedDosageInstruction": "Aplicar 10 unidades subcutáneas antes del desayuno diariamente",
  "authoredOn": "2024-04-01T10:00:00Z"
}'::jsonb),
('22222222-bbbb-cccc-dddd-000000000002',
'{
  "resourceType": "MedicationRequest",
  "id": "22222222-bbbb-cccc-dddd-000000000002",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/amlodipino", "display": "Amlodipino"},
  "subject": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "requester": {"reference": "Practitioner/33333333-4444-5555-6666-777777777777", "display": "Dra. María Vega"},
  "reason": [{"reference": "Condition/hipertension"}],
  "dosageInstruction": [{"text": "10 mg vía oral una vez al día"}],
  "renderedDosageInstruction": "10 mg vía oral una vez al día",
  "authoredOn": "2024-03-20T09:00:00Z"
}'::jsonb),
('33333333-cccc-dddd-eeee-000000000003',
'{
  "resourceType": "MedicationRequest",
  "id": "33333333-cccc-dddd-eeee-000000000003",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/heberprot-p", "display": "Heberprot-P"},
  "subject": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"},
  "requester": {"reference": "Practitioner/99999999-0000-1111-2222-333333333333", "display": "Dra. Ana Martín"},
  "dosageInstruction": [{"text": "Aplicar 0.6 mg por vía intralesional cada semana"}],
  "renderedDosageInstruction": "Aplicar 0.6 mg por vía intralesional cada semana",
  "authoredOn": "2024-02-15T08:00:00Z"
}'::jsonb),
('44444444-dddd-eeee-ffff-000000000004',
'{
  "resourceType": "MedicationRequest",
  "id": "44444444-dddd-eeee-ffff-000000000004",
  "status": "completed",
  "intent": "order",
  "medication": {"reference": "Medication/paracetamol", "display": "Paracetamol"},
  "subject": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"},
  "requester": {"reference": "Practitioner/77777777-8888-9999-0000-111111111111", "display": "Dra. Lucía Rodríguez"},
  "dosageInstruction": [{"text": "500 mg cada 8 horas durante 5 días"}],
  "renderedDosageInstruction": "500 mg cada 8 horas durante 5 días",
  "authoredOn": "2024-01-10T07:30:00Z"
}'::jsonb),
('55555555-eeee-ffff-0000-000000000005',
'{
  "resourceType": "MedicationRequest",
  "id": "55555555-eeee-ffff-0000-000000000005",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/losartan", "display": "Losartán"},
  "subject": {"reference": "Patient/f1a2b3c4-5678-90ab-cdef-1234567890ad"},
  "requester": {"reference": "Practitioner/88888888-9999-0000-1111-222222222222", "display": "Dr. José Gutiérrez"},
  "dosageInstruction": [{"text": "50 mg vía oral una vez al día"}],
  "renderedDosageInstruction": "50 mg vía oral una vez al día",
  "authoredOn": "2024-03-01T09:00:00Z"
}'::jsonb),
('66666666-ffff-0000-1111-000000000006',
'{
  "resourceType": "MedicationRequest",
  "id": "66666666-ffff-0000-1111-000000000006",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/salbutamol", "display": "Salbutamol"},
  "subject": {"reference": "Patient/a2b3c4d5-e6f7-890a-bcde-f1234567890e"},
  "requester": {"reference": "Practitioner/cccccccc-dddd-eeee-ffff-000000000000", "display": "Dr. José Luna"},
  "dosageInstruction": [{"text": "Inhalar 2 puff cada 6 horas según necesidad"}],
  "renderedDosageInstruction": "Inhalar 2 puff cada 6 horas según necesidad",
  "authoredOn": "2024-04-10T08:00:00Z"
}'::jsonb),
('77777777-0000-1111-2222-000000000007',
'{
  "resourceType": "MedicationRequest",
  "id": "77777777-0000-1111-2222-000000000007",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/ibuprofeno", "display": "Ibuprofeno"},
  "subject": {"reference": "Patient/b3c4d5e6-f7a8-9012-bcde-f2345678901f"},
  "requester": {"reference": "Practitioner/bbbbbbbb-cccc-dddd-eeee-ffffffffffff", "display": "Dra. María García"},
  "dosageInstruction": [{"text": "400 mg cada 12 horas durante 7 días"}],
  "renderedDosageInstruction": "400 mg cada 12 horas durante 7 días",
  "authoredOn": "2024-02-20T10:00:00Z"
}'::jsonb),
('88888888-1111-2222-3333-000000000008',
'{
  "resourceType": "MedicationRequest",
  "id": "88888888-1111-2222-3333-000000000008",
  "status": "completed",
  "intent": "order",
  "medication": {"reference": "Medication/omeprazol", "display": "Omeprazol"},
  "subject": {"reference": "Patient/05e6f7a8-b9c0-1234-def0-567890123456"},
  "requester": {"reference": "Practitioner/eeeeeeee-ffff-0000-1111-222222222222", "display": "Dr. Jorge Soto"},
  "dosageInstruction": [{"text": "20 mg vía oral una vez al día durante 14 días"}],
  "renderedDosageInstruction": "20 mg vía oral una vez al día durante 14 días",
  "authoredOn": "2024-01-15T09:30:00Z"
}'::jsonb),
('99999999-2222-3333-4444-000000000009',
'{
  "resourceType": "MedicationRequest",
  "id": "99999999-2222-3333-4444-000000000009",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/metformina", "display": "Metformina"},
  "subject": {"reference": "Patient/06f7a8b9-c0d1-2345-ef01-678901234567"},
  "requester": {"reference": "Practitioner/11111111-2222-3333-4444-555555555555", "display": "Dra. Ana López"},
  "dosageInstruction": [{"text": "500 mg vía oral dos veces al día"}],
  "renderedDosageInstruction": "500 mg vía oral dos veces al día",
  "authoredOn": "2024-03-10T08:00:00Z"
}'::jsonb),
('aaaaaaaa-3333-4444-5555-000000000010',
'{
  "resourceType": "MedicationRequest",
  "id": "aaaaaaaa-3333-4444-5555-000000000010",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/losartan", "display": "Losartán"},
  "subject": {"reference": "Patient/07a8b9c0-d1e2-3456-f012-789012345678"},
  "requester": {"reference": "Practitioner/dddddddd-eeee-ffff-0000-111111111111", "display": "Dra. María Pérez"},
  "dosageInstruction": [{"text": "50 mg vía oral una vez al día"}],
  "renderedDosageInstruction": "50 mg vía oral una vez al día",
  "authoredOn": "2024-02-25T09:00:00Z"
}'::jsonb),
('bbbbbbbb-4444-5555-6666-000000000011',
'{
  "resourceType": "MedicationRequest",
  "id": "bbbbbbbb-4444-5555-6666-000000000011",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/salbutamol", "display": "Salbutamol"},
  "subject": {"reference": "Patient/08b9c0d1-e2f3-4567-0123-890123456789"},
  "requester": {"reference": "Practitioner/eeeeeeee-ffff-0000-1111-222222222222", "display": "Dr. Jorge Soto"},
  "dosageInstruction": [{"text": "Inhalar 2 puff cada 6 horas según necesidad"}],
  "renderedDosageInstruction": "Inhalar 2 puff cada 6 horas según necesidad",
  "authoredOn": "2024-04-05T08:00:00Z"
}'::jsonb),
('cccccccc-5555-6666-7777-000000000012',
'{
  "resourceType": "MedicationRequest",
  "id": "cccccccc-5555-6666-7777-000000000012",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/paracetamol", "display": "Paracetamol"},
  "subject": {"reference": "Patient/09c0d1e2-f345-6789-0123-901234567890"},
  "requester": {"reference": "Practitioner/99999999-0000-1111-2222-333333333333", "display": "Dra. Ana Martín"},
  "dosageInstruction": [{"text": "500 mg cada 8 horas durante 5 días"}],
  "renderedDosageInstruction": "500 mg cada 8 horas durante 5 días",
  "authoredOn": "2024-03-01T07:00:00Z"
}'::jsonb),
('dddddddd-6666-7777-8888-000000000013',
'{
  "resourceType": "MedicationRequest",
  "id": "dddddddd-6666-7777-8888-000000000013",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/omeprazol", "display": "Omeprazol"},
  "subject": {"reference": "Patient/10d1e2f3-4567-8901-2345-012345678901"},
  "requester": {"reference": "Practitioner/44444444-5555-6666-7777-888888888888", "display": "Dr. Luis Castro"},
  "dosageInstruction": [{"text": "20 mg vía oral una vez al día durante 14 días"}],
  "renderedDosageInstruction": "20 mg vía oral una vez al día durante 14 días",
  "authoredOn": "2024-02-15T08:30:00Z"
}'::jsonb),
('eeeeeeee-7777-8888-9999-000000000014',
'{
  "resourceType": "MedicationRequest",
  "id": "eeeeeeee-7777-8888-9999-000000000014",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/metformina", "display": "Metformina"},
  "subject": {"reference": "Patient/01a2b3c4-d5e6-7890-abcd-ef1234567890"},
  "requester": {"reference": "Practitioner/33333333-4444-5555-6666-777777777777", "display": "Dra. María Vega"},
  "dosageInstruction": [{"text": "850 mg vía oral dos veces al día"}],
  "renderedDosageInstruction": "850 mg vía oral dos veces al día",
  "authoredOn": "2024-04-20T09:00:00Z"
}'::jsonb),
('ffffffff-8888-9999-0000-000000000015',
'{
  "resourceType": "MedicationRequest",
  "id": "ffffffff-8888-9999-0000-000000000015",
  "status": "completed",
  "intent": "order",
  "medication": {"reference": "Medication/ibuprofeno", "display": "Ibuprofeno"},
  "subject": {"reference": "Patient/02b3c4d5-e6f7-890a-bcde-f12345678901"},
  "requester": {"reference": "Practitioner/44444444-5555-6666-7777-888888888888", "display": "Dr. Luis Castro"},
  "dosageInstruction": [{"text": "400 mg cada 12 horas durante 7 días"}],
  "renderedDosageInstruction": "400 mg cada 12 horas durante 7 días",
  "authoredOn": "2024-01-25T10:00:00Z"
}'::jsonb),
('a1b2c3d4-1111-2222-3333-444455556677',
'{
  "resourceType": "MedicationRequest",
  "id": "a1b2c3d4-1111-2222-3333-444455556677",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/heberferon", "display": "Heberferon"},
  "subject": {"reference": "Patient/03c4d5e6-f7a8-9012-bcde-f23456789012"},
  "requester": {"reference": "Practitioner/aaaaaaa1-bbbb-cccc-dddd-eeeeeeeeeeee", "display": "Dra. Elena García"},
  "dosageInstruction": [{"text": "Inyectar 3 millones de UI tres veces por semana"}],
  "renderedDosageInstruction": "Inyectar 3 millones de UI tres veces por semana",
  "authoredOn": "2024-05-02T08:00:00Z"
}'::jsonb),
('b2c3d4e5-2222-3333-4444-555566667788',
'{
  "resourceType": "MedicationRequest",
  "id": "b2c3d4e5-2222-3333-4444-555566667788",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/amoxicilina", "display": "Amoxicilina"},
  "subject": {"reference": "Patient/04d5e6f7-a8b9-0123-cdef-345678901234"},
  "requester": {"reference": "Practitioner/bbbbbbb2-cccc-dddd-eeee-ffffffffffff", "display": "Dr. Manuel Paredes"},
  "dosageInstruction": [{"text": "500 mg cada 8 horas durante 7 días"}],
  "renderedDosageInstruction": "500 mg cada 8 horas durante 7 días",
  "authoredOn": "2024-04-15T09:30:00Z"
}'::jsonb),
('c3d4e5f6-3333-4444-5555-666677778899',
'{
  "resourceType": "MedicationRequest",
  "id": "c3d4e5f6-3333-4444-5555-666677778899",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/atorvastatina", "display": "Atorvastatina"},
  "subject": {"reference": "Patient/05e6f7a8-b9c0-1234-def0-567890123456"},
  "requester": {"reference": "Practitioner/ccccccc3-dddd-eeee-ffff-000000000000", "display": "Dra. Carmen Ruiz"},
  "dosageInstruction": [{"text": "20 mg vía oral una vez al día por la noche"}],
  "renderedDosageInstruction": "20 mg vía oral una vez al día por la noche",
  "authoredOn": "2024-03-10T08:00:00Z"
}'::jsonb),
('d4e5f6a7-4444-5555-6666-777788889900',
'{
  "resourceType": "MedicationRequest",
  "id": "d4e5f6a7-4444-5555-6666-777788889900",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/ceftriaxona", "display": "Ceftriaxona"},
  "subject": {"reference": "Patient/06f7a8b9-c0d1-2345-ef01-678901234567"},
  "requester": {"reference": "Practitioner/dddddddd-eeee-ffff-0000-111111111111", "display": "Dr. Julio Martí"},
  "dosageInstruction": [{"text": "1 g IV cada 24 horas durante 5 días"}],
  "renderedDosageInstruction": "1 g IV cada 24 horas durante 5 días",
  "authoredOn": "2024-05-05T09:00:00Z"
}'::jsonb),
('e5f6a7b8-5555-6666-7777-888899990011',
'{
  "resourceType": "MedicationRequest",
  "id": "e5f6a7b8-5555-6666-7777-888899990011",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/aspirina", "display": "Aspirina"},
  "subject": {"reference": "Patient/07a8b9c0-d1e2-3456-f012-789012345678"},
  "requester": {"reference": "Practitioner/eeeeeee5-ffff-0000-1111-222222222222", "display": "Dr. Marcos Luna"},
  "dosageInstruction": [{"text": "100 mg vía oral una vez al día"}],
  "renderedDosageInstruction": "100 mg vía oral una vez al día",
  "authoredOn": "2024-05-10T08:00:00Z"
}'::jsonb),
('f6a7b8c9-6666-7777-8888-999900001122',
'{
  "resourceType": "MedicationRequest",
  "id": "f6a7b8c9-6666-7777-8888-999900001122",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/rituximab", "display": "Rituximab"},
  "subject": {"reference": "Patient/08b9c0d1-e2f3-4567-0123-890123456789"},
  "requester": {"reference": "Practitioner/fffffff6-0000-1111-2222-333333333333", "display": "Dra. Rosa Vidal"},
  "dosageInstruction": [{"text": "375 mg/m2 IV semanalmente por 4 semanas"}],
  "renderedDosageInstruction": "375 mg/m2 IV semanalmente por 4 semanas",
  "authoredOn": "2024-05-12T10:00:00Z"
}'::jsonb),
('a7b8c9d0-7777-8888-9999-000011112233',
'{
  "resourceType": "MedicationRequest",
  "id": "a7b8c9d0-7777-8888-9999-000011112233",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/kaletra", "display": "Lopinavir/Ritonavir (Kaletra)"},
  "subject": {"reference": "Patient/09c0d1e2-f345-6789-0123-901234567890"},
  "requester": {"reference": "Practitioner/11111112-2222-3333-4444-555555555556", "display": "Dr. Pedro Alonso"},
  "dosageInstruction": [{"text": "400/100 mg vía oral cada 12 horas"}],
  "renderedDosageInstruction": "400/100 mg vía oral cada 12 horas",
  "authoredOn": "2024-05-15T08:00:00Z"
}'::jsonb),
('b8c9d0e1-8888-9999-0000-111122223344',
'{
  "resourceType": "MedicationRequest",
  "id": "b8c9d0e1-8888-9999-0000-111122223344",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/abacavir", "display": "Abacavir"},
  "subject": {"reference": "Patient/10d1e2f3-4567-8901-2345-012345678901"},
  "requester": {"reference": "Practitioner/22222223-3333-4444-5555-666666666667", "display": "Dra. Susana Valdés"},
  "dosageInstruction": [{"text": "300 mg vía oral dos veces al día"}],
  "renderedDosageInstruction": "300 mg vía oral dos veces al día",
  "authoredOn": "2024-05-18T09:00:00Z"
}'::jsonb),
('c9d0e1f2-9999-0000-1111-222233334455',
'{
  "resourceType": "MedicationRequest",
  "id": "c9d0e1f2-9999-0000-1111-222233334455",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/cefazolina", "display": "Cefazolina"},
  "subject": {"reference": "Patient/01a2b3c4-d5e6-7890-abcd-ef1234567890"},
  "requester": {"reference": "Practitioner/33333334-4444-5555-6666-777777777778", "display": "Dr. Ernesto Pino"},
  "dosageInstruction": [{"text": "1 g IV cada 8 horas durante 5 días"}],
  "renderedDosageInstruction": "1 g IV cada 8 horas durante 5 días",
  "authoredOn": "2024-05-20T08:00:00Z"
}'::jsonb),
('d0e1f2a3-aaaa-bbbb-cccc-ddddeeeeffff',
'{
  "resourceType": "MedicationRequest",
  "id": "d0e1f2a3-aaaa-bbbb-cccc-ddddeeeeffff",
  "status": "active",
  "intent": "order",
  "medication": {"reference": "Medication/azithromycin", "display": "Azitromicina"},
  "subject": {"reference": "Patient/02b3c4d5-e6f7-890a-bcde-f12345678901"},
  "requester": {"reference": "Practitioner/88888888-9999-aaaa-bbbb-cccccccccccc", "display": "Dra. Marta Suárez"},
  "dosageInstruction": [{"text": "500 mg vía oral una vez al día durante 3 días"}],
  "renderedDosageInstruction": "500 mg vía oral una vez al día durante 3 días",
  "authoredOn": "2024-05-22T08:00:00Z"
}'::jsonb);

-- 7. AllergyIntolerance(33) ✔
INSERT INTO allergy_intolerances (id, resource) VALUES
('b2c3d4e5-f6a7-8b9c-0d1e-2f3a4b5c6d7e',
'{
  "resourceType": "AllergyIntolerance",
  "id": "b2c3d4e5-f6a7-8b9c-0d1e-2f3a4b5c6d7e",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "91930004", "display": "Penicilina"}]},
  "patient": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "criticality": "high"
}'::jsonb),
('d7f8e9a0-b1c2-3d4e-5f6a-7b8c9d0e1f2b',
'{
  "resourceType": "AllergyIntolerance",
  "id": "d7f8e9a0-b1c2-3d4e-5f6a-7b8c9d0e1f2b",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "300916003", "display": "Alergia al polen"}]},
  "patient": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "criticality": "low"
}'::jsonb),
('e8f9a0b1-c2d3-4e5f-6a7b-8c9d0e1f2a3c',
'{
  "resourceType": "AllergyIntolerance",
  "id": "e8f9a0b1-c2d3-4e5f-6a7b-8c9d0e1f2a3c",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "inactive"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "235719002", "display": "Alergia a los ácaros del polvo"}]},
  "patient": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"},
  "criticality": "medium"
}'::jsonb),
('a1b2c3d4-e5f6-7a8b-9c0d-1e2f3a4b5c6d',
'{
  "resourceType": "AllergyIntolerance",
  "id": "a1b2c3d4-e5f6-7a8b-9c0d-1e2f3a4b5c6d",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "91930004", "display": "Penicilina"}]},
  "patient": {"reference": "Patient/01a2b3c4-d5e6-7890-abcd-ef1234567890"},
  "criticality": "high"
}'::jsonb),
('b2c3d4e5-f6a7-8b9c-0d1e-2f3a4b5c6d8e',
'{
  "resourceType": "AllergyIntolerance",
  "id": "b2c3d4e5-f6a7-8b9c-0d1e-2f3a4b5c6d8e",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "232347008", "display": "Alergia al maní"}]},
  "patient": {"reference": "Patient/02b3c4d5-e6f7-890a-bcde-f12345678901"},
  "criticality": "high"
}'::jsonb),
('c3d4e5f6-a7b8-9c0d-1e2f-3a4b5c6d7e8f',
'{
  "resourceType": "AllergyIntolerance",
  "id": "c3d4e5f6-a7b8-9c0d-1e2f-3a4b5c6d7e8f",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "91930004", "display": "Penicilina"}]},
  "patient": {"reference": "Patient/03c4d5e6-f7a8-9012-bcde-f23456789012"},
  "criticality": "high"
}'::jsonb),
('d4e5f6a7-b8c9-0d1e-2f3a-4b5c6d7e8f90',
'{
  "resourceType": "AllergyIntolerance",
  "id": "d4e5f6a7-b8c9-0d1e-2f3a-4b5c6d7e8f90",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "91936005", "display": "Alergia a la aspirina"}]},
  "patient": {"reference": "Patient/04d5e6f7-a8b9-0123-cdef-345678901234"},
  "criticality": "medium"
}'::jsonb),
('e5f6a7b8-c9d0-1e2f-3a4b-5c6d7e8f9a0b',
'{
  "resourceType": "AllergyIntolerance",
  "id": "e5f6a7b8-c9d0-1e2f-3a4b-5c6d7e8f9a0b",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "91930004", "display": "Penicilina"}]},
  "patient": {"reference": "Patient/05e6f7a8-b9c0-1234-def0-567890123456"},
  "criticality": "high"
}'::jsonb),
('f6a7b8c9-d0e1-2f3a-4b5c-6d7e8f9a0b1c',
'{
  "resourceType": "AllergyIntolerance",
  "id": "f6a7b8c9-d0e1-2f3a-4b5c-6d7e8f9a0b1c",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "91934008", "display": "Alergia a la lactosa"}]},
  "patient": {"reference": "Patient/06f7a8b9-c0d1-2345-ef01-678901234567"},
  "criticality": "low"
}'::jsonb),
('a7b8c9d0-e1f2-3a4b-5c6d-7e8f9a0b1c2d',
'{
  "resourceType": "AllergyIntolerance",
  "id": "a7b8c9d0-e1f2-3a4b-5c6d-7e8f9a0b1c2d",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "91930004", "display": "Penicilina"}]},
  "patient": {"reference": "Patient/07a8b9c0-d1e2-3456-f012-789012345678"},
  "criticality": "high"
}'::jsonb),
('b8c9d0e1-f2a3-4b5c-6d7e-8f9a0b1c2d3e',
'{
  "resourceType": "AllergyIntolerance",
  "id": "b8c9d0e1-f2a3-4b5c-6d7e-8f9a0b1c2d3e",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "inactive"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "300916003", "display": "Alergia al polen"}]},
  "patient": {"reference": "Patient/08b9c0d1-e2f3-4567-0123-890123456789"},
  "criticality": "low"
}'::jsonb),
('c9d0e1f2-a3b4-5c6d-7e8f-9a0b1c2d3e4f',
'{
  "resourceType": "AllergyIntolerance",
  "id": "c9d0e1f2-a3b4-5c6d-7e8f-9a0b1c2d3e4f",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "91934008", "display": "Alergia a la lactosa"}]},
  "patient": {"reference": "Patient/09c0d1e2-f345-6789-0123-901234567890"},
  "criticality": "medium"
}'::jsonb),
('d0e1f2a3-b4c5-6d7e-8f9a-0b1c2d3e4f5a',
'{
  "resourceType": "AllergyIntolerance",
  "id": "d0e1f2a3-b4c5-6d7e-8f9a-0b1c2d3e4f5a",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "91936005", "display": "Alergia a la aspirina"}]},
  "patient": {"reference": "Patient/10d1e2f3-4567-8901-2345-012345678901"},
  "criticality": "medium"
}'::jsonb),
('e1f2a3b4-c5d6-7e8f-9a0b-1c2d3e4f5a6b',
'{
  "resourceType": "AllergyIntolerance",
  "id": "e1f2a3b4-c5d6-7e8f-9a0b-1c2d3e4f5a6b",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "372138002", "display": "Alergia a las sulfamidas"}]},
  "patient": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"},
  "criticality": "high"
}'::jsonb),
('f2a3b4c5-d6e7-8f9a-0b1c-2d3e4f5a6b7c',
'{
  "resourceType": "AllergyIntolerance",
  "id": "f2a3b4c5-d6e7-8f9a-0b1c-2d3e4f5a6b7c",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "293319003", "display": "Alergia a picadura de abeja"}]},
  "patient": {"reference": "Patient/f1a2b3c4-5678-90ab-cdef-1234567890ad"},
  "criticality": "high"
}'::jsonb),
('a3b4c5d6-e7f8-9a0b-1c2d-3e4f5a6b7c8d',
'{
  "resourceType": "AllergyIntolerance",
  "id": "a3b4c5d6-e7f8-9a0b-1c2d-3e4f5a6b7c8d",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "232346004", "display": "Alergia a la caspa de gato"}]},
  "patient": {"reference": "Patient/a2b3c4d5-e6f7-890a-bcde-f1234567890e"},
  "criticality": "low"
}'::jsonb),
('b4c5d6e7-f8a9-0b1c-2d3e-4f5a6b7c8d9e',
'{
  "resourceType": "AllergyIntolerance",
  "id": "b4c5d6e7-f8a9-0b1c-2d3e-4f5a6b7c8d9e",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "232353006", "display": "Alergia al gluten"}]},
  "patient": {"reference": "Patient/b3c4d5e6-f7a8-9012-bcde-f2345678901f"},
  "criticality": "medium"
}'::jsonb),
('c5d6e7f8-a9b0-1c2d-3e4f-5a6b7c8d9e0f',
'{
  "resourceType": "AllergyIntolerance",
  "id": "c5d6e7f8-a9b0-1c2d-3e4f-5a6b7c8d9e0f",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "232349000", "display": "Alergia al huevo"}]},
  "patient": {"reference": "Patient/05e6f7a8-b9c0-1234-def0-567890123456"},
  "criticality": "low"
}'::jsonb),
('d6e7f8a9-b0c1-2d3e-4f5a-6b7c8d9e0f1a',
'{
  "resourceType": "AllergyIntolerance",
  "id": "d6e7f8a9-b0c1-2d3e-4f5a-6b7c8d9e0f1a",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "232352009", "display": "Alergia a los mariscos"}]},
  "patient": {"reference": "Patient/06f7a8b9-c0d1-2345-ef01-678901234567"},
  "criticality": "high"
}'::jsonb),
('e7f8a9b0-c1d2-3e4f-5a6b-7c8d9e0f1a2b',
'{
  "resourceType": "AllergyIntolerance",
  "id": "e7f8a9b0-c1d2-3e4f-5a6b-7c8d9e0f1a2b",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "91930004", "display": "Penicilina"}]},
  "patient": {"reference": "Patient/07a8b9c0-d1e2-3456-f012-789012345678"},
  "criticality": "high"
}'::jsonb),
('f8a9b0c1-d2e3-4f5a-6b7c-8d9e0f1a2b3c',
'{
  "resourceType": "AllergyIntolerance",
  "id": "f8a9b0c1-d2e3-4f5a-6b7c-8d9e0f1a2b3c",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "inactive"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "235719002", "display": "Alergia a los ácaros del polvo"}]},
  "patient": {"reference": "Patient/08b9c0d1-e2f3-4567-0123-890123456789"},
  "criticality": "medium"
}'::jsonb),
('a9b0c1d2-e3f4-5a6b-7c8d-9e0f1a2b3c4d',
'{
  "resourceType": "AllergyIntolerance",
  "id": "a9b0c1d2-e3f4-5a6b-7c8d-9e0f1a2b3c4d",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "300916003", "display": "Alergia al polen"}]},
  "patient": {"reference": "Patient/09c0d1e2-f345-6789-0123-901234567890"},
  "criticality": "low"
}'::jsonb),
('b0c1d2e3-f4a5-6b7c-8d9e-0f1a2b3c4d5e',
'{
  "resourceType": "AllergyIntolerance",
  "id": "b0c1d2e3-f4a5-6b7c-8d9e-0f1a2b3c4d5e",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "91936005", "display": "Alergia a la aspirina"}]},
  "patient": {"reference": "Patient/10d1e2f3-4567-8901-2345-012345678901"},
  "criticality": "medium"
}'::jsonb),
('c1d2e3f4-5678-90ab-cdef-123456781234',
'{
  "resourceType": "AllergyIntolerance",
  "id": "c1d2e3f4-5678-90ab-cdef-123456781234",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "91935003", "display": "Alergia al ibuprofeno"}]},
  "patient": {"reference": "Patient/f1a2b3c4-5678-90ab-cdef-1234567890ad"},
  "criticality": "medium"
}'::jsonb),
('b1c2d3e4-f5a6-7890-bcde-f12345678901',
'{
  "resourceType": "AllergyIntolerance",
  "id": "b1c2d3e4-f5a6-7890-bcde-f12345678901",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "91932002", "display": "Alergia al paracetamol"}]},
  "patient": {"reference": "Patient/a2b3c4d5-e6f7-890a-bcde-f1234567890e"},
  "criticality": "low"
}'::jsonb),
('d2e3f4a5-b6c7-8901-cdef-234567890123',
'{
  "resourceType": "AllergyIntolerance",
  "id": "d2e3f4a5-b6c7-8901-cdef-234567890123",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "91934008", "display": "Alergia a la lactosa"}]},
  "patient": {"reference": "Patient/b3c4d5e6-f7a8-9012-bcde-f2345678901f"},
  "criticality": "medium"
}'::jsonb),
('e3f4a5b6-c7d8-9012-def1-345678901234',
'{
  "resourceType": "AllergyIntolerance",
  "id": "e3f4a5b6-c7d8-9012-def1-345678901234",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "232347008", "display": "Alergia al maní"}]},
  "patient": {"reference": "Patient/05e6f7a8-b9c0-1234-def0-567890123456"},
  "criticality": "high"
}'::jsonb),
('f4a5b6c7-d8e9-0123-ef12-456789012345',
'{
  "resourceType": "AllergyIntolerance",
  "id": "f4a5b6c7-d8e9-0123-ef12-456789012345",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "91930004", "display": "Alergia a la penicilina"}]},
  "patient": {"reference": "Patient/06f7a8b9-c0d1-2345-ef01-678901234567"},
  "criticality": "high"
}'::jsonb),
('a5b6c7d8-e9f0-1234-f123-567890123456',
'{
  "resourceType": "AllergyIntolerance",
  "id": "a5b6c7d8-e9f0-1234-f123-567890123456",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "inactive"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "232353006", "display": "Alergia al gluten"}]},
  "patient": {"reference": "Patient/07a8b9c0-d1e2-3456-f012-789012345678"},
  "criticality": "medium"
}'::jsonb),
('b6c7d8e9-f012-3456-1234-678901234567',
'{
  "resourceType": "AllergyIntolerance",
  "id": "b6c7d8e9-f012-3456-1234-678901234567",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "232346004", "display": "Alergia a la caspa de perro"}]},
  "patient": {"reference": "Patient/08b9c0d1-e2f3-4567-0123-890123456789"},
  "criticality": "low"
}'::jsonb),
('c7d8e9f0-1234-5678-2345-789012345678',
'{
  "resourceType": "AllergyIntolerance",
  "id": "c7d8e9f0-1234-5678-2345-789012345678",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "91936005", "display": "Alergia a la aspirina"}]},
  "patient": {"reference": "Patient/09c0d1e2-f345-6789-0123-901234567890"},
  "criticality": "medium"
}'::jsonb),
('d8e9f012-3456-7890-3456-890123456789',
'{
  "resourceType": "AllergyIntolerance",
  "id": "d8e9f012-3456-7890-3456-890123456789",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "inactive"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "293319003", "display": "Alergia a picadura de avispa"}]},
  "patient": {"reference": "Patient/10d1e2f3-4567-8901-2345-012345678901"},
  "criticality": "high"
}'::jsonb),
('e9f01234-5678-9012-4567-901234567890',
'{
  "resourceType": "AllergyIntolerance",
  "id": "e9f01234-5678-9012-4567-901234567890",
  "clinicalStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "code": "active"}]},
  "code": {"coding": [{"system": "http://snomed.info/sct", "code": "232350005", "display": "Alergia al pescado"}]},
  "patient": {"reference": "Patient/01a2b3c4-d5e6-7890-abcd-ef1234567890"},
  "criticality": "medium"
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
}'::jsonb),
('a1b2c3d4-e5f6-7890-abcd-ef0123456789',
'{
  "resourceType": "ServiceRequest",
  "id": "a1b2c3d4-e5f6-7890-abcd-ef0123456789",
  "status": "active",
  "intent": "order",
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "710824005",
      "display": "Remisión a cardiología"
    }]
  },
  "subject": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "occurrenceDateTime": "2025-06-20T11:00:00Z",
  "requester": {"reference": "Practitioner/99999999-0000-1111-2222-333333333333"},
  "encounter": {"reference": "Encounter/2025-06-20T09:00:00Z"}
}'::jsonb),

('b2c3d4e5-f6a7-8901-2345-67890abcdef1',
'{
  "resourceType": "ServiceRequest",
  "id": "b2c3d4e5-f6a7-8901-2345-67890abcdef1",
  "status": "completed",
  "intent": "order",
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "306206005",
      "display": "Hemograma completo"
    }]
  },
  "subject": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"},
  "occurrenceDateTime": "2025-06-22T08:45:00Z",
  "requester": {"reference": "Practitioner/f1a2b3c4-d5e6-7890-ab12-34567890abcd"}
}'::jsonb),

('c3d4e5f6-a7b8-9012-3456-7890abcdef12',
'{
  "resourceType": "ServiceRequest",
  "id": "c3d4e5f6-a7b8-9012-3456-7890abcdef12",
  "status": "active",
  "intent": "order",
  "code": {
    "coding": [{
      "system": "http://snomed.info/sct",
      "code": "721912009",
      "display": "Ecografía obstétrica"
    }]
  },
  "subject": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"},
  "occurrenceDateTime": "2025-07-09T09:00:00Z",
  "requester": {"reference": "Practitioner/aaaaaaa1-bbbb-cccc-dddd-eeeeeeeeeeee"}
}'::jsonb);

-- 9. CarePlan(16) ✔
INSERT INTO care_plans (id, resource) VALUES
('2d3e4f5a-6b7c-8d9e-0f1a-2b3c4d5e6f7a',
'{
  "resourceType": "CarePlan",
  "id": "2d3e4f5a-6b7c-8d9e-0f1a-2b3c4d5e6f7a",
  "status": "active",
  "intent": "plan",
  "title": "Plan de cuidado para diabetes",
  "description": "Incluye monitoreo de glucosa y visitas regulares.",
  "created": "2023-09-15T10:00:00",
  "subject": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "custodian" : {
    "reference" : "Practitioner/12345678-1234-1234-1234-123456789abc",
    "display" : "Dra Ana López"
  },
  "period": {"start": "2023-10-01T00:00:00Z", "end": "2024-10-01T00:00:00Z"},
  "activity": [
    {
      "performedActivity": [{"reference": "Procedure/monitoring-glucose"}],
      "progress": [{"text": "Paciente ha seguido el plan sin interrupciones."}],
      "plannedActivityReference": {"reference": "ServiceRequest/regular-checkup"}
    }
  ],
  "note": [{"text": "El paciente ha sido informado del plan."}]
}'::jsonb),
('d4e5f6a7-b8c9-0123-4567-89abcdef0123',
'{
  "resourceType": "CarePlan",
  "id": "d4e5f6a7-b8c9-0123-4567-89abcdef0123",
  "status": "active",
  "intent": "plan",
  "title": "Control de hipertensión arterial",
  "description": "Monitoreo de presión arterial y ajuste de medicación.",
  "created": "2025-06-01T08:00:00Z",
  "subject": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "custodian": {
    "reference": "Practitioner/12345678-1234-1234-1234-123456789abc",
    "display": "Dra. Ana Martín"
  },
  "period": {"start": "2025-01-01T00:00:00Z", "end": "2025-06-14T00:00:00Z"},
  "activity": [
    {
      "performedActivity": [{"reference": "ServiceRequest/a1b2c3d4-e5f6-7890-abcd-ef0123456789"}],
      "progress": [{"text": "Paciente con presión arterial estabilizada"}]
    }
  ],
  "note": [{"text": "Se recomienda dieta baja en sodio"}]
}'::jsonb),
('e5f6a7b8-c9d0-1234-5678-9abcdef01234',
'{
  "resourceType": "CarePlan",
  "id": "e5f6a7b8-c9d0-1234-5678-9abcdef01234",
  "status": "active",
  "intent": "plan",
  "title": "Manejo de asma pediátrico",
  "description": "Uso de inhaladores y control de crisis.",
  "created": "2025-05-15T10:00:00Z",
  "subject": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"},
  "custodian": {
    "reference": "Practitioner/f1a2b3c4-d5e6-7890-ab12-34567890abcd",
    "display": "Dr. Juan Pérez"
  },
  "period": {"start": "2025-03-01T00:00:00Z", "end": "2025-06-14T00:00:00Z"},
  "activity": [
    {
      "performedActivity": [{"reference": "ServiceRequest/b2c3d4e5-f6a7-8901-2345-67890abcdef1"}],
      "progress": [{"text": "Reducción de exacerbaciones en un 40%"}]
    }
  ],
  "note": [{"text": "Educar al paciente sobre uso correcto de inhaladores"}]
}'::jsonb),
('f6a7b8c9-d0e1-2345-6789-abcdef012345',
'{
  "resourceType": "CarePlan",
  "id": "f6a7b8c9-d0e1-2345-6789-abcdef012345",
  "status": "active",
  "intent": "plan",
  "title": "Seguimiento prenatal",
  "description": "Controles mensuales y suplementos nutricionales.",
  "created": "2025-04-20T09:00:00Z",
  "subject": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"},
  "custodian": {
    "reference": "Practitioner/aaaaaaa1-bbbb-cccc-dddd-eeeeeeeeeeee",
    "display": "Dra. Lucía Martínez"
  },
  "period": {"start": "2025-02-01T00:00:00Z", "end": "2025-06-14T00:00:00Z"},
  "activity": [
    {
      "performedActivity": [{"reference": "ServiceRequest/c3d4e5f6-a7b8-9012-3456-7890abcdef12"}],
      "progress": [{"text": "Embarazo evolutivo sin complicaciones"}]
    }
  ],
  "note": [{"text": "Suplementar con ácido fólico y hierro"}]
}'::jsonb),
('123e4567-e89b-12d3-a456-426614174001',
'{
  "resourceType": "CarePlan",
  "id": "123e4567-e89b-12d3-a456-426614174001",
  "status": "active",
  "intent": "plan",
  "title": "Plan de rehabilitación post-accidente cerebrovascular",
  "description": "Incluye fisioterapia y control neurológico.",
  "created": "2025-01-15T09:00:00Z",
  "subject": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "custodian": {
    "reference": "Practitioner/12345678-1234-1234-1234-123456789abc",
    "display": "Dra. Ana Martín"
  },
  "period": {"start": "2025-01-20T00:00:00Z", "end": "2025-06-14T00:00:00Z"},
  "activity": [
    {
      "performedActivity": [{"reference": "ServiceRequest/a1b2c3d4-e5f6-7890-abcd-ef0123456789"}],
      "progress": [{"text": "Paciente ha completado sesiones iniciales de fisioterapia."}]
    }
  ],
  "note": [{"text": "Revisar progreso en próxima consulta."}]
}'::jsonb),
('223e4567-e89b-12d3-a456-426614174002',
'{
  "resourceType": "CarePlan",
  "id": "223e4567-e89b-12d3-a456-426614174002",
  "status": "active",
  "intent": "plan",
  "title": "Plan de manejo para hipertensión en adulto mayor",
  "description": "Monitoreo de presión arterial y ajuste de medicación.",
  "created": "2025-03-10T10:30:00Z",
  "subject": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"},
  "custodian": {
    "reference": "Practitioner/f1a2b3c4-d5e6-7890-ab12-34567890abcd",
    "display": "Dr. Juan Pérez"
  },
  "period": {"start": "2025-03-15T00:00:00Z", "end": "2025-06-14T00:00:00Z"},
  "activity": [
    {
      "performedActivity": [{"reference": "ServiceRequest/b2c3d4e5-f6a7-8901-2345-67890abcdef1"}],
      "progress": [{"text": "Paciente responde bien a la medicación."}]
    }
  ],
  "note": [{"text": "Revisión mensual recomendada."}]
}'::jsonb),
('323e4567-e89b-12d3-a456-426614174003',
'{
  "resourceType": "CarePlan",
  "id": "323e4567-e89b-12d3-a456-426614174003",
  "status": "active",
  "intent": "plan",
  "title": "Plan de seguimiento para embarazo de alto riesgo",
  "description": "Controles frecuentes y monitoreo fetal.",
  "created": "2025-04-05T08:45:00Z",
  "subject": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"},
  "custodian": {
    "reference": "Practitioner/aaaaaaa1-bbbb-cccc-dddd-eeeeeeeeeeee",
    "display": "Dra. Lucía Martínez"
  },
  "period": {"start": "2025-04-10T00:00:00Z", "end": "2025-06-14T00:00:00Z"},
  "activity": [
    {
      "performedActivity": [{"reference": "ServiceRequest/c3d4e5f6-a7b8-9012-3456-7890abcdef12"}],
      "progress": [{"text": "Monitoreo fetal sin complicaciones."}]
    }
  ],
  "note": [{"text": "Suplementar con vitaminas prenatales."}]
}'::jsonb),
('423e4567-e89b-12d3-a456-426614174004',
'{
  "resourceType": "CarePlan",
  "id": "423e4567-e89b-12d3-a456-426614174004",
  "status": "active",
  "intent": "plan",
  "title": "Plan de manejo de diabetes tipo 2",
  "description": "Control glucémico y educación nutricional.",
  "created": "2025-01-10T08:00:00Z",
  "subject": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "custodian": {
    "reference": "Practitioner/12345678-1234-1234-1234-123456789abc",
    "display": "Dra. Ana Martín"
  },
  "period": {"start": "2025-01-15T00:00:00Z", "end": "2025-06-14T00:00:00Z"},
  "activity": [
    {
      "performedActivity": [{"reference": "ServiceRequest/a1b2c3d4-e5f6-7890-abcd-ef0123456789"}],
      "progress": [{"text": "Paciente mantiene niveles estables de glucosa."}]
    }
  ],
  "note": [{"text": "Revisar adherencia al tratamiento."}]
}'::jsonb),
('523e4567-e89b-12d3-a456-426614174005',
'{
  "resourceType": "CarePlan",
  "id": "523e4567-e89b-12d3-a456-426614174005",
  "status": "completed",
  "intent": "plan",
  "title": "Rehabilitación pulmonar post-COVID-19",
  "description": "Ejercicios respiratorios y seguimiento clínico.",
  "created": "2024-11-20T09:30:00Z",
  "subject": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"},
  "custodian": {
    "reference": "Practitioner/f1a2b3c4-d5e6-7890-ab12-34567890abcd",
    "display": "Dr. Juan Pérez"
  },
  "period": {"start": "2024-11-25T00:00:00Z", "end": "2025-06-14T00:00:00Z"},
  "activity": [
    {
      "performedActivity": [{"reference": "ServiceRequest/b2c3d4e5-f6a7-8901-2345-67890abcdef1"}],
      "progress": [{"text": "Mejora significativa en capacidad pulmonar."}]
    }
  ],
  "note": [{"text": "Plan finalizado con éxito."}]
}'::jsonb),
('623e4567-e89b-12d3-a456-426614174006',
'{
  "resourceType": "CarePlan",
  "id": "623e4567-e89b-12d3-a456-426614174006",
  "status": "active",
  "intent": "plan",
  "title": "Seguimiento postoperatorio de cirugía ortopédica",
  "description": "Control de heridas y rehabilitación.",
  "created": "2025-02-10T10:00:00Z",
  "subject": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"},
  "custodian": {
    "reference": "Practitioner/aaaaaaa1-bbbb-cccc-dddd-eeeeeeeeeeee",
    "display": "Dra. Lucía Martínez"
  },
  "period": {"start": "2025-02-15T00:00:00Z", "end": "2025-06-14T00:00:00Z"},
  "activity": [
    {
      "performedActivity": [{"reference": "ServiceRequest/c3d4e5f6-a7b8-9012-3456-7890abcdef12"}],
      "progress": [{"text": "Herida cicatrizando correctamente."}]
    }
  ],
  "note": [{"text": "Continuar con fisioterapia."}]
}'::jsonb),
('723e4567-e89b-12d3-a456-426614174007',
'{
  "resourceType": "CarePlan",
  "id": "723e4567-e89b-12d3-a456-426614174007",
  "status": "active",
  "intent": "plan",
  "title": "Plan de manejo para depresión leve",
  "description": "Terapia psicológica y seguimiento farmacológico.",
  "created": "2025-03-05T11:15:00Z",
  "subject": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "custodian": {
    "reference": "Practitioner/12345678-1234-1234-1234-123456789abc",
    "display": "Dra. Ana Martín"
  },
  "period": {"start": "2025-03-10T00:00:00Z", "end": "2025-06-14T00:00:00Z"},
  "activity": [
    {
      "performedActivity": [{"reference": "ServiceRequest/a1b2c3d4-e5f6-7890-abcd-ef0123456789"}],
      "progress": [{"text": "Paciente responde bien a la terapia."}]
    }
  ],
  "note": [{"text": "Evaluar en 3 meses."}]
}'::jsonb),
('823e4567-e89b-12d3-a456-426614174008',
'{
  "resourceType": "CarePlan",
  "id": "823e4567-e89b-12d3-a456-426614174008",
  "status": "active",
  "intent": "plan",
  "title": "Plan de seguimiento para insuficiencia renal crónica",
  "description": "Monitoreo renal y ajuste de dieta.",
  "created": "2025-04-01T09:00:00Z",
  "subject": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"},
  "custodian": {
    "reference": "Practitioner/f1a2b3c4-d5e6-7890-ab12-34567890abcd",
    "display": "Dr. Juan Pérez"
  },
  "period": {"start": "2025-04-05T00:00:00Z", "end": "2025-06-14T00:00:00Z"},
  "activity": [
    {
      "performedActivity": [{"reference": "ServiceRequest/b2c3d4e5-f6a7-8901-2345-67890abcdef1"}],
      "progress": [{"text": "Estabilización de función renal."}]
    }
  ],
  "note": [{"text": "Control trimestral recomendado."}]
}'::jsonb),
('923e4567-e89b-12d3-a456-426614174009',
'{
  "resourceType": "CarePlan",
  "id": "923e4567-e89b-12d3-a456-426614174009",
  "status": "active",
  "intent": "plan",
  "title": "Plan de manejo para artritis reumatoide",
  "description": "Terapia farmacológica y ejercicios de movilidad.",
  "created": "2025-05-10T10:30:00Z",
  "subject": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"},
  "custodian": {
    "reference": "Practitioner/aaaaaaa1-bbbb-cccc-dddd-eeeeeeeeeeee",
    "display": "Dra. Lucía Martínez"
  },
  "period": {"start": "2025-05-15T00:00:00Z", "end": "2025-06-14T00:00:00Z"},
  "activity": [
    {
      "performedActivity": [{"reference": "ServiceRequest/c3d4e5f6-a7b8-9012-3456-7890abcdef12"}],
      "progress": [{"text": "Mejora en la movilidad articular."}]
    }
  ],
  "note": [{"text": "Continuar seguimiento mensual."}]
}'::jsonb),
('a23e4567-e89b-12d3-a456-42661417400a',
'{
  "resourceType": "CarePlan",
  "id": "a23e4567-e89b-12d3-a456-42661417400a",
  "status": "completed",
  "intent": "plan",
  "title": "Plan de cesación tabáquica",
  "description": "Apoyo psicológico y farmacológico.",
  "created": "2024-12-01T08:00:00Z",
  "subject": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "custodian": {
    "reference": "Practitioner/99999999-0000-1111-2222-333333333333",
    "display": "Dra. Ana Martín"
  },
  "period": {"start": "2024-12-05T00:00:00Z", "end": "2025-06-14T00:00:00Z"},
  "activity": [
    {
      "performedActivity": [{"reference": "ServiceRequest/a1b2c3d4-e5f6-7890-abcd-ef0123456789"}],
      "progress": [{"text": "Paciente logró dejar de fumar."}]
    }
  ],
  "note": [{"text": "Plan finalizado con éxito."}]
}'::jsonb),
('b23e4567-e89b-12d3-a456-42661417400b',
'{
  "resourceType": "CarePlan",
  "id": "b23e4567-e89b-12d3-a456-42661417400b",
  "status": "active",
  "intent": "plan",
  "title": "Plan de manejo para obesidad",
  "description": "Dieta, ejercicio y seguimiento psicológico.",
  "created": "2025-02-20T09:30:00Z",
  "subject": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"},
  "custodian": {
    "reference": "Practitioner/f1a2b3c4-d5e6-7890-ab12-34567890abcd",
    "display": "Dr. Juan Pérez"
  },
  "period": {"start": "2025-02-25T00:00:00Z", "end": "2025-06-14T00:00:00Z"},
  "activity": [
    {
      "performedActivity": [{"reference": "ServiceRequest/b2c3d4e5-f6a7-8901-2345-67890abcdef1"}],
      "progress": [{"text": "Paciente ha perdido 5 kg en 3 meses."}]
    }
  ],
  "note": [{"text": "Continuar plan nutricional."}]
}'::jsonb),
('c23e4567-e89b-12d3-a456-42661417400c',
'{
  "resourceType": "CarePlan",
  "id": "c23e4567-e89b-12d3-a456-42661417400c",
  "status": "active",
  "intent": "plan",
  "title": "Plan de seguimiento para enfermedad pulmonar obstructiva crónica",
  "description": "Monitoreo respiratorio y rehabilitación.",
  "created": "2025-03-30T10:00:00Z",
  "subject": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"},
  "custodian": {
    "reference": "Practitioner/aaaaaaa1-bbbb-cccc-dddd-eeeeeeeeeeee",
    "display": "Dra. Lucía Martínez"
  },
  "period": {"start": "2025-04-01T00:00:00Z", "end": "2025-06-14T00:00:00Z"},
  "activity": [
    {
      "performedActivity": [{"reference": "ServiceRequest/c3d4e5f6-a7b8-9012-3456-7890abcdef12"}],
      "progress": [{"text": "Mejora en capacidad respiratoria."}]
    }
  ],
  "note": [{"text": "Revisión mensual recomendada."}]
}'::jsonb);

-- 10. Immunization(30) ✔
INSERT INTO immunizations (id, resource) VALUES
('5a6b7c8d-9e0f-1a2b-3c4d-5e6f7a8b9c0d',
'{
  "resourceType": "Immunization",
  "id": "5a6b7c8d-9e0f-1a2b-3c4d-5e6f7a8b9c0d",
  "status": "completed",
  "vaccineCode": {"coding": [{"system": "http://hl7.org/fhir/sid/cvx", "code": "207", "display": "COVID-19, Abdala"}]},
  "patient": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "occurrenceDateTime": "2021-08-15T10:00:00Z"
}'::jsonb),
('1f2e3d4c-5b6a-7980-9c0d-1e2f3a4b5c6d',
'{
  "resourceType": "Immunization",
  "id": "1f2e3d4c-5b6a-7980-9c0d-1e2f3a4b5c6d",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "03",
      "display": "BCG"
    }]
  },
  "patient": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "occurrenceDateTime": "2020-01-10T09:00:00Z",
  "note": [{"text": "Aplicada a recién nacido"}]
}'::jsonb),

('2a3b4c5d-6e7f-8091-2a3b-4c5d6e7f8091',
'{
  "resourceType": "Immunization",
  "id": "2a3b4c5d-6e7f-8091-2a3b-4c5d6e7f8091",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "08",
      "display": "Hepatitis B"
    }]
  },
  "patient": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "occurrenceDateTime": "2020-01-11T10:00:00Z",
  "note": [{"text": "Primera dosis en las 24h de nacido"}]
}'::jsonb),

('3b4c5d6e-7f80-9123-4b5c-6d7e8f901234',
'{
  "resourceType": "Immunization",
  "id": "3b4c5d6e-7f80-9123-4b5c-6d7e8f901234",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "20",
      "display": "Pentavalente (DTP-HepB-Hib)"
    }]
  },
  "patient": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"},
  "occurrenceDateTime": "2020-02-15T11:00:00Z",
  "note": [{"text": "Aplicada en múltiples dosis"}]
}'::jsonb),

('4c5d6e7f-8091-2345-6d7e-8f9012345678',
'{
  "resourceType": "Immunization",
  "id": "4c5d6e7f-8091-2345-6d7e-8f9012345678",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "10",
      "display": "Polio oral (OPV)"
    }]
  },
  "patient": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"},
  "occurrenceDateTime": "2020-03-20T09:30:00Z",
  "note": [{"text": "Aplicada en campañas"}]
}'::jsonb),

('5d6e7f80-9123-4567-8f90-1234567890ab',
'{
  "resourceType": "Immunization",
  "id": "5d6e7f80-9123-4567-8f90-1234567890ab",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "17",
      "display": "Polio inactivada (IPV)"
    }]
  },
  "patient": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "occurrenceDateTime": "2020-04-25T10:15:00Z",
  "note": [{"text": "Parte del esquema rutinario"}]
}'::jsonb),

('6e7f8091-2345-6789-0abc-def123456789',
'{
  "resourceType": "Immunization",
  "id": "6e7f8091-2345-6789-0abc-def123456789",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "03",
      "display": "Triple viral (MMR)"
    }]
  },
  "patient": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "occurrenceDateTime": "2020-05-30T08:00:00Z",
  "note": [{"text": "A partir del año"}]
}'::jsonb),

('7f809123-4567-890a-bcde-f1234567890a',
'{
  "resourceType": "Immunization",
  "id": "7f809123-4567-890a-bcde-f1234567890a",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "50",
      "display": "DTP (refuerzos)"
    }]
  },
  "patient": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"},
  "occurrenceDateTime": "2021-01-10T09:00:00Z",
  "note": [{"text": "Refuerzos escolares"}]
}'::jsonb),

('80912345-6789-0abc-def1-234567890abc',
'{
  "resourceType": "Immunization",
  "id": "80912345-6789-0abc-def1-234567890abc",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "52",
      "display": "dT (difteria-tétanos adultos)"
    }]
  },
  "patient": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"},
  "occurrenceDateTime": "2021-02-15T10:30:00Z",
  "note": [{"text": "Para embarazadas y adultos"}]
}'::jsonb),

('90123456-7890-abcd-ef12-34567890abcd',
'{
  "resourceType": "Immunization",
  "id": "90123456-7890-abcd-ef12-34567890abcd",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "100",
      "display": "Neumocócica conjugada (PCV)"
    }]
  },
  "patient": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "occurrenceDateTime": "2021-03-20T11:00:00Z",
  "note": [{"text": "Ampliada en años recientes"}]
}'::jsonb),

('a0123456-7890-abcd-ef12-34567890abcd',
'{
  "resourceType": "Immunization",
  "id": "a0123456-7890-abcd-ef12-34567890abcd",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "116",
      "display": "Rotavirus"
    }]
  },
  "patient": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "occurrenceDateTime": "2021-04-10T09:15:00Z",
  "note": [{"text": "Limitada, depende del año"}]
}'::jsonb),
('b1234567-89ab-cdef-0123-456789abcdef',
'{
  "resourceType": "Immunization",
  "id": "b1234567-89ab-cdef-0123-456789abcdef",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "21",
      "display": "Hepatitis B (Refuerzo)"
    }]
  },
  "patient": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"},
  "occurrenceDateTime": "2022-05-15T10:00:00Z",
  "note": [{"text": "Segunda dosis de refuerzo"}]
}'::jsonb),

('c2345678-9abc-def0-1234-56789abcdef0',
'{
  "resourceType": "Immunization",
  "id": "c2345678-9abc-def0-1234-56789abcdef0",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "49",
      "display": "Varicela"
    }]
  },
  "patient": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"},
  "occurrenceDateTime": "2022-06-10T09:30:00Z",
  "note": [{"text": "Primera dosis"}]
}'::jsonb),

('d3456789-abcd-ef01-2345-6789abcdef01',
'{
  "resourceType": "Immunization",
  "id": "d3456789-abcd-ef01-2345-6789abcdef01",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "94",
      "display": "Hepatitis A"
    }]
  },
  "patient": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "occurrenceDateTime": "2022-07-20T11:00:00Z",
  "note": [{"text": "Vacuna Hepatitis A completa"}]
}'::jsonb),

('e456789a-bcde-f012-3456-789abcdef012',
'{
  "resourceType": "Immunization",
  "id": "e456789a-bcde-f012-3456-789abcdef012",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "110",
      "display": "Virus del Papiloma Humano (VPH)"
    }]
  },
  "patient": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "occurrenceDateTime": "2022-08-15T10:30:00Z",
  "note": [{"text": "Primera dosis"}]
}'::jsonb),

('f56789ab-cdef-0123-4567-89abcdef0123',
'{
  "resourceType": "Immunization",
  "id": "f56789ab-cdef-0123-4567-89abcdef0123",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "111",
      "display": "Virus del Papiloma Humano (VPH) Refuerzo"
    }]
  },
  "patient": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"},
  "occurrenceDateTime": "2022-09-15T09:00:00Z",
  "note": [{"text": "Segunda dosis"}]
}'::jsonb),

('a6789abc-def0-1234-5678-9abcdef01234',
'{
  "resourceType": "Immunization",
  "id": "a6789abc-def0-1234-5678-9abcdef01234",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "107",
      "display": "Meningocócica conjugada"
    }]
  },
  "patient": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"},
  "occurrenceDateTime": "2022-10-10T08:45:00Z",
  "note": [{"text": "Dosis única"}]
}'::jsonb),

('b789abcd-ef01-2345-6789-abcdef012345',
'{
  "resourceType": "Immunization",
  "id": "b789abcd-ef01-2345-6789-abcdef012345",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "140",
      "display": "Tos ferina acelular"
    }]
  },
  "patient": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "occurrenceDateTime": "2022-11-05T10:15:00Z",
  "note": [{"text": "Vacuna combinada"}]
}'::jsonb),

('c89abcde-f012-3456-789a-bcdef0123456',
'{
  "resourceType": "Immunization",
  "id": "c89abcde-f012-3456-789a-bcdef0123456",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "150",
      "display": "Varicela Refuerzo"
    }]
  },
  "patient": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "occurrenceDateTime": "2022-12-10T09:30:00Z",
  "note": [{"text": "Segunda dosis"}]
}'::jsonb),

('d90abcdef-1234-5678-9abc-def012345678',
'{
  "resourceType": "Immunization",
  "id": "d90abcdef-1234-5678-9abc-def012345678",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "140",
      "display": "Tos ferina acelular"
    }]
  },
  "patient": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"},
  "occurrenceDateTime": "2023-01-15T10:00:00Z",
  "note": [{"text": "Vacuna combinada"}]
}'::jsonb),

('e01abcdef-2345-6789-abcd-ef0123456789',
'{
  "resourceType": "Immunization",
  "id": "e01abcdef-2345-6789-abcd-ef0123456789",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "21",
      "display": "Hepatitis B (Refuerzo)"
    }]
  },
  "patient": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"},
  "occurrenceDateTime": "2023-02-10T09:00:00Z",
  "note": [{"text": "Tercera dosis"}]
}'::jsonb);

-- 11. Specimen(14) ✔
INSERT INTO specimens (id, resource) VALUES
('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3a4b5c6d',
'{
  "resourceType": "Specimen",
  "id": "1a2b3c4d-5e6f-7a8b-9c0d-1e2f3a4b5c6d",
  "status": "AVAILABLE",
  "type": {
    "coding": [
      {
        "system": "http://snomed.info/sct",
        "code": "122555007",
        "display": "Sangre venosa"
      }
    ]
  },
  "subject": {
    "reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"
  },
  "collection": {
    "collectedDateTime": "2023-10-05T10:00:00"
  }
}'::jsonb),
('2b3c4d5e-6f7a-8b9c-0d1e-2f3a4b5c6d7e',
'{
  "resourceType": "Specimen",
  "id": "2b3c4d5e-6f7a-8b9c-0d1e-2f3a4b5c6d7e",
  "status": "AVAILABLE",
  "type": {
    "coding": [
      {
        "system": "http://snomed.info/sct",
        "code": "122555007",
        "display": "Sangre venosa"
      }
    ]
  },
  "subject": {
    "reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"
  },
  "collection": {
    "collectedDateTime": "2025-06-10T09:15:00"
  }
}'::jsonb),
('3c4d5e6f-7a8b-9c0d-1e2f-3a4b5c6d7e8f',
'{
  "resourceType": "Specimen",
  "id": "3c4d5e6f-7a8b-9c0d-1e2f-3a4b5c6d7e8f",
  "status": "AVAILABLE",
  "type": {
    "coding": [
      {
        "system": "http://snomed.info/sct",
        "code": "119364003",
        "display": "Orina"
      }
    ]
  },
  "subject": {
    "reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"
  },
  "collection": {
    "collectedDateTime": "2025-06-12T08:45:00"
  }
}'::jsonb),
('4d5e6f7a-8b9c-0d1e-2f3a-4b5c6d7e8f9a',
'{
  "resourceType": "Specimen",
  "id": "4d5e6f7a-8b9c-0d1e-2f3a-4b5c6d7e8f9a",
  "status": "AVAILABLE",
  "type": {
    "coding": [
      {
        "system": "http://snomed.info/sct",
        "code": "119364003",
        "display": "Orina"
      }
    ]
  },
  "subject": {
    "reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"
  },
  "collection": {
    "collectedDateTime": "2025-06-15T14:30:00"
  }
}'::jsonb),
('5e6f7a8b-9c0d-1e2f-3a4b-5c6d7e8f9a0b',
'{
  "resourceType": "Specimen",
  "id": "5e6f7a8b-9c0d-1e2f-3a4b-5c6d7e8f9a0b",
  "status": "AVAILABLE",
  "type": {
    "coding": [
      {
        "system": "http://snomed.info/sct",
        "code": "119364003",
        "display": "Orina"
      }
    ]
  },
  "subject": {
    "reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"
  },
  "collection": {
    "collectedDateTime": "2025-06-20T10:00:00"
  }
}'::jsonb),
('6f7a8b9c-0d1e-2f3a-4b5c-6d7e8f9a0b1c',
'{
  "resourceType": "Specimen",
  "id": "6f7a8b9c-0d1e-2f3a-4b5c-6d7e8f9a0b1c",
  "status": "AVAILABLE",
  "type": {
    "coding": [
      {
        "system": "http://snomed.info/sct",
        "code": "122555007",
        "display": "Sangre venosa"
      }
    ]
  },
  "subject": {
    "reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"
  },
  "collection": {
    "collectedDateTime": "2025-06-22T08:00:00"
  }
}'::jsonb),

('7a8b9c0d-1e2f-3a4b-5c6d-7e8f9a0b1c2d',
'{
  "resourceType": "Specimen",
  "id": "7a8b9c0d-1e2f-3a4b-5c6d-7e8f9a0b1c2d",
  "status": "AVAILABLE",
  "type": {
    "coding": [
      {
        "system": "http://snomed.info/sct",
        "code": "119364003",
        "display": "Orina"
      }
    ]
  },
  "subject": {
    "reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"
  },
  "collection": {
    "collectedDateTime": "2025-06-23T09:30:00"
  }
}'::jsonb),

('8b9c0d1e-2f3a-4b5c-6d7e-8f9a0b1c2d3e',
'{
  "resourceType": "Specimen",
  "id": "8b9c0d1e-2f3a-4b5c-6d7e-8f9a0b1c2d3e",
  "status": "AVAILABLE",
  "type": {
    "coding": [
      {
        "system": "http://snomed.info/sct",
        "code": "119364003",
        "display": "Orina"
      }
    ]
  },
  "subject": {
    "reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"
  },
  "collection": {
    "collectedDateTime": "2025-06-24T10:15:00"
  }
}'::jsonb),

('9c0d1e2f-3a4b-5c6d-7e8f-9a0b1c2d3e4f',
'{
  "resourceType": "Specimen",
  "id": "9c0d1e2f-3a4b-5c6d-7e8f-9a0b1c2d3e4f",
  "status": "AVAILABLE",
  "type": {
    "coding": [
      {
        "system": "http://snomed.info/sct",
        "code": "122555007",
        "display": "Sangre venosa"
      }
    ]
  },
  "subject": {
    "reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"
  },
  "collection": {
    "collectedDateTime": "2025-06-25T11:00:00"
  }
}'::jsonb),

('0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a',
'{
  "resourceType": "Specimen",
  "id": "0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a",
  "status": "AVAILABLE",
  "type": {
    "coding": [
      {
        "system": "http://snomed.info/sct",
        "code": "119364003",
        "display": "Orina"
      }
    ]
  },
  "subject": {
    "reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"
  },
  "collection": {
    "collectedDateTime": "2025-06-26T08:45:00"
  }
}'::jsonb),

('1e2f3a4b-5c6d-7e8f-9a0b-1c2d3e4f5a6b',
'{
  "resourceType": "Specimen",
  "id": "1e2f3a4b-5c6d-7e8f-9a0b-1c2d3e4f5a6b",
  "status": "AVAILABLE",
  "type": {
    "coding": [
      {
        "system": "http://snomed.info/sct",
        "code": "122555007",
        "display": "Sangre venosa"
      }
    ]
  },
  "subject": {
    "reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"
  },
  "collection": {
    "collectedDateTime": "2025-06-27T09:00:00"
  }
}'::jsonb),

('2e3f4a5b-6c7d-8e9f-0a1b-2c3d4e5f6a7b',
'{
  "resourceType": "Specimen",
  "id": "2e3f4a5b-6c7d-8e9f-0a1b-2c3d4e5f6a7b",
  "status": "AVAILABLE",
  "type": {
    "coding": [
      {
        "system": "http://snomed.info/sct",
        "code": "119364003",
        "display": "Orina"
      }
    ]
  },
  "subject": {
    "reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"
  },
  "collection": {
    "collectedDateTime": "2025-06-28T10:30:00"
  }
}'::jsonb),

('3e4f5a6b-7c8d-9e0f-1a2b-3c4d5e6f7a8b',
'{
  "resourceType": "Specimen",
  "id": "3e4f5a6b-7c8d-9e0f-1a2b-3c4d5e6f7a8b",
  "status": "AVAILABLE",
  "type": {
    "coding": [
      {
        "system": "http://snomed.info/sct",
        "code": "122555007",
        "display": "Sangre venosa"
      }
    ]
  },
  "subject": {
    "reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"
  },
  "collection": {
    "collectedDateTime": "2025-06-29T11:15:00"
  }
}'::jsonb),

('4f5a6b7c-8d9e-0f1a-2b3c-4d5e6f7a8b9c',
'{
  "resourceType": "Specimen",
  "id": "4f5a6b7c-8d9e-0f1a-2b3c-4d5e6f7a8b9c",
  "status": "AVAILABLE",
  "type": {
    "coding": [
      {
        "system": "http://snomed.info/sct",
        "code": "119364003",
        "display": "Orina"
      }
    ]
  },
  "subject": {
    "reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"
  },
  "collection": {
    "collectedDateTime": "2025-06-30T08:45:00"
  }
}'::jsonb),
('e1f2a3b4-c5d6-4789-9abc-def012345678',
'{
  "resourceType": "Immunization",
  "id": "e1f2a3b4-c5d6-4789-9abc-def012345678",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "03",
      "display": "BCG"
    }]
  },
  "patient": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "occurrenceDateTime": "2019-12-01T09:00:00Z",
  "note": [{"text": "Vacuna aplicada a recién nacido"}]
}'::jsonb),

('f2e3d4c5-b6a7-4890-abcd-ef0123456789',
'{
  "resourceType": "Immunization",
  "id": "f2e3d4c5-b6a7-4890-abcd-ef0123456789",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "08",
      "display": "Hepatitis B"
    }]
  },
  "patient": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "occurrenceDateTime": "2020-01-10T10:00:00Z",
  "note": [{"text": "Primera dosis en las 24h de nacido"}]
}'::jsonb),

('a3b4c5d6-e7f8-4901-bcde-1234567890ab',
'{
  "resourceType": "Immunization",
  "id": "a3b4c5d6-e7f8-4901-bcde-1234567890ab",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "20",
      "display": "Pentavalente (DTP-HepB-Hib)"
    }]
  },
  "patient": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"},
  "occurrenceDateTime": "2020-02-15T11:00:00Z",
  "note": [{"text": "Aplicada en múltiples dosis"}]
}'::jsonb),

('b4c5d6e7-f809-1234-5678-90abcdef1234',
'{
  "resourceType": "Immunization",
  "id": "b4c5d6e7-f809-1234-5678-90abcdef1234",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "10",
      "display": "Polio oral (OPV)"
    }]
  },
  "patient": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"},
  "occurrenceDateTime": "2020-03-20T09:30:00Z",
  "note": [{"text": "Aplicada en campañas"}]
}'::jsonb),

('c5d6e7f8-0912-3456-7890-abcdef123456',
'{
  "resourceType": "Immunization",
  "id": "c5d6e7f8-0912-3456-7890-abcdef123456",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "17",
      "display": "Polio inactivada (IPV)"
    }]
  },
  "patient": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "occurrenceDateTime": "2020-04-25T10:15:00Z",
  "note": [{"text": "Parte del esquema rutinario"}]
}'::jsonb),

('d6e7f809-1234-5678-90ab-cdef12345678',
'{
  "resourceType": "Immunization",
  "id": "d6e7f809-1234-5678-90ab-cdef12345678",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "03",
      "display": "Triple viral (MMR)"
    }]
  },
  "patient": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "occurrenceDateTime": "2020-05-30T08:00:00Z",
  "note": [{"text": "A partir del año"}]
}'::jsonb),

('e7f80912-3456-7890-abcd-ef1234567890',
'{
  "resourceType": "Immunization",
  "id": "e7f80912-3456-7890-abcd-ef1234567890",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "50",
      "display": "DTP (refuerzos)"
    }]
  },
  "patient": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"},
  "occurrenceDateTime": "2021-01-10T09:00:00Z",
  "note": [{"text": "Refuerzos escolares"}]
}'::jsonb),

('f8091234-5678-90ab-cdef-1234567890ab',
'{
  "resourceType": "Immunization",
  "id": "f8091234-5678-90ab-cdef-1234567890ab",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "52",
      "display": "dT (difteria-tétanos adultos)"
    }]
  },
  "patient": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"},
  "occurrenceDateTime": "2021-02-15T10:30:00Z",
  "note": [{"text": "Para embarazadas y adultos"}]
}'::jsonb),

('08901234-5678-90ab-cdef-1234567890ab',
'{
  "resourceType": "Immunization",
  "id": "08901234-5678-90ab-cdef-1234567890ab",
  "status": "completed",
  "vaccineCode": {
    "coding": [{
      "system": "http://hl7.org/fhir/sid/cvx",
      "code": "100",
      "display": "Neumocócica conjugada (PCV)"
    }]
  },
  "patient": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "occurrenceDateTime": "2021-03-20T11:00:00Z",
  "note": [{"text": "Ampliada en años recientes"}]
}'::jsonb);

-- 12. Observation(17) ✔
INSERT INTO observations (id, resource) VALUES
('9f8e7d6c-5b4a-3c2d-1e0f-9a8b7c6d5e4f',
'{
  "resourceType": "Observation",
  "id": "obs-clin-001",
  "status": "final",
  "code": {
    "coding": [{
      "system": "http://loinc.org",
      "code": "15074-8",
      "display": "Glucosa en sangre"
    }]
  },
  "subject": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "effectiveDateTime": "2023-10-05T08:30:00",
  "valueQuantity": {"value": 5.6, "unit": "mmol/L"}
}'::jsonb),
('c1a2b3d4-e5f6-4789-abcd-1234567890ab',
'{
  "resourceType": "Observation",
  "id": "obs-clin-002",
  "status": "final",
  "code": {
    "coding": [{
      "system": "http://loinc.org",
      "code": "2093-3",
      "display": "Colesterol total en sangre"
    }]
  },
  "subject": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "effectiveDateTime": "2025-06-10T09:00:00",
  "valueQuantity": {"value": 4.8, "unit": "mmol/L"}
}'::jsonb),

('d2b3c4e5-f6a7-4890-bcde-2345678901bc',
'{
  "resourceType": "Observation",
  "id": "obs-clin-003",
  "status": "final",
  "code": {
    "coding": [{
      "system": "http://loinc.org",
      "code": "4548-4",
      "display": "Hemoglobina"
    }]
  },
  "subject": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"},
  "effectiveDateTime": "2025-06-12T08:30:00",
  "valueQuantity": {"value": 13.5, "unit": "g/dL"}
}'::jsonb),

('e3c4d5f6-a7b8-4901-cdef-3456789012cd',
'{
  "resourceType": "Observation",
  "id": "obs-clin-004",
  "status": "final",
  "code": {
    "coding": [{
      "system": "http://loinc.org",
      "code": "8310-5",
      "display": "Temperatura corporal"
    }]
  },
  "subject": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"},
  "effectiveDateTime": "2025-06-15T14:00:00",
  "valueQuantity": {"value": 36.7, "unit": "°C"}
}'::jsonb),
('f1e2d3c4-b5a6-4789-9abc-1234567890ab',
'{
  "resourceType": "Observation",
  "id": "obs-clin-005",
  "status": "final",
  "code": {
    "coding": [{
      "system": "http://loinc.org",
      "code": "4548-4",
      "display": "Hemoglobina"
    }]
  },
  "subject": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "effectiveDateTime": "2025-06-20T08:00:00",
  "valueQuantity": {"value": 14.2, "unit": "g/dL"}
}'::jsonb),

('a2b3c4d5-e6f7-4890-abcd-2345678901bc',
'{
  "resourceType": "Observation",
  "id": "obs-clin-006",
  "status": "final",
  "code": {
    "coding": [{
      "system": "http://loinc.org",
      "code": "15074-8",
      "display": "Glucosa en sangre"
    }]
  },
  "subject": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "effectiveDateTime": "2025-06-21T09:30:00",
  "valueQuantity": {"value": 5.9, "unit": "mmol/L"}
}'::jsonb),

('b3c4d5e6-f7a8-4901-bcde-3456789012cd',
'{
  "resourceType": "Observation",
  "id": "obs-clin-007",
  "status": "final",
  "code": {
    "coding": [{
      "system": "http://loinc.org",
      "code": "8310-5",
      "display": "Temperatura corporal"
    }]
  },
  "subject": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"},
  "effectiveDateTime": "2025-06-22T14:00:00",
  "valueQuantity": {"value": 37.1, "unit": "°C"}
}'::jsonb),
('d4e5f6a7-b8c9-0d1e-2f3a-4b5c6d7e8f9a',
'{
  "resourceType": "Observation",
  "id": "obs-com-001",
  "status": "final",
  "context": {"reference": "Location/0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a"},
  "code": {
    "coding": [{
        "code": "cleanliness-score",
        "display": "Cleanliness Score"
      }]
  },
  "valueQuantity": {"value": 8, "unit": "score"}
}'::jsonb),
('f4d5e6a7-b8c9-4012-def3-4567890123de',
'{
  "resourceType": "Observation",
  "id": "obs-com-002",
  "status": "final",
  "context": {"reference": "Location/f47ac10b-58cc-4372-a567-0e02b2c3d479"},
  "code": {
    "coding": [{
      "code": "water-quality-score",
      "display": "Water Quality Score"
    }]
  },
  "valueQuantity": {"value": 7, "unit": "score"}
}'::jsonb),

('a5b6c7d8-e9f0-4123-abc4-5678901234ef',
'{
  "resourceType": "Observation",
  "id": "obs-com-003",
  "status": "final",
  "context": {"reference": "Location/a3bb189e-8bf9-3888-9912-ace4e6543002"},
  "code": {
    "coding": [{
      "code": "air-quality-index",
      "display": "Air Quality Index"
    }]
  },
  "valueQuantity": {"value": 42, "unit": "AQI"}
}'::jsonb),

('b6c7d8e9-f0a1-4234-bcd5-6789012345f0',
'{
  "resourceType": "Observation",
  "id": "obs-com-004",
  "status": "final",
  "context": {"reference": "Location/9c858901-8a57-4791-81fe-4c455b099bc9"},
  "code": {
    "coding": [{
      "code": "noise-level",
      "display": "Noise Level"
    }]
  },
  "valueQuantity": {"value": 55, "unit": "dB"}
}'::jsonb),
('c4d5e6f7-a8b9-4012-cdef-4567890123de',
'{
  "resourceType": "Observation",
  "id": "obs-com-005",
  "status": "final",
  "context": {"reference": "Location/f47ac10b-58cc-4372-a567-0e02b2c3d479"},
  "code": {
    "coding": [{
      "code": "cleanliness-score",
      "display": "Cleanliness Score"
    }]
  },
  "valueQuantity": {"value": 9, "unit": "score"}
}'::jsonb),

('d5e6f7a8-b9c0-4123-def0-5678901234ef',
'{
  "resourceType": "Observation",
  "id": "obs-com-006",
  "status": "final",
  "context": {"reference": "Location/a3bb189e-8bf9-3888-9912-ace4e6543002"},
  "code": {
    "coding": [{
      "code": "cleanliness-score",
      "display": "Cleanliness Score"
    }]
  },
  "valueQuantity": {"value": 7, "unit": "score"}
}'::jsonb),

('e6f7a8b9-c0d1-4234-efa1-6789012345f0',
'{
  "resourceType": "Observation",
  "id": "obs-com-007",
  "status": "final",
  "context": {"reference": "Location/9c858901-8a57-4791-81fe-4c455b099bc9"},
  "code": {
    "coding": [{
      "code": "cleanliness-score",
      "display": "Cleanliness Score"
    }]
  },
  "valueQuantity": {"value": 8, "unit": "score"}
}'::jsonb),

('f7a8b9c0-d1e2-4345-f0a2-7890123456a1',
'{
  "resourceType": "Observation",
  "id": "obs-com-008",
  "status": "final",
  "context": {"reference": "Location/16fd2706-8baf-433b-82eb-8c7fada847da"},
  "code": {
    "coding": [{
      "code": "cleanliness-score",
      "display": "Cleanliness Score"
    }]
  },
  "valueQuantity": {"value": 6, "unit": "score"}
}'::jsonb);

-- 14. RelatedPerson(22) ✔
INSERT INTO related_persons (id, resource) VALUES
('4d5e6f7a-8b9c-0d1e-2f3a-4b5c6d7e8f9a',
'{
  "resourceType": "RelatedPerson",
  "id": "4d5e6f7a-8b9c-0d1e-2f3a-4b5c6d7e8f9a",
  "patient": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "relationship": [{"coding": [{"system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode", "code": "H", "display": "Hija"}]}],
  "name": [{"family": "Rodríguez", "given": ["Laura"]}],
  "telecom": [{"system": "phone", "value": "+5355511111"}]
}'::jsonb),
('a1b2c3d4-e5f6-7890-abcd-ef1234567890',
'{
  "resourceType": "RelatedPerson",
  "id": "a1b2c3d4-e5f6-7890-abcd-ef1234567890",
  "patient": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "relationship": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
      "code": "GRNDDAU",
      "display": "Abuela"
    }]
  }],
  "name": [{"family": "Hernández", "given": ["Carmen","Luisa"]}],
  "telecom": [{"system": "phone", "value": "+5355512345"}]
}'::jsonb),
('b2c3d4e5-f6a7-8b9c-0d1e-2f3a4b5c6d7e',
'{
  "resourceType": "RelatedPerson",
  "id": "b2c3d4e5-f6a7-8b9c-0d1e-2f3a4b5c6d7e",
  "patient": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"},
  "relationship": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
      "code": "BRO",
      "display": "Hermano"
    }]
  }],
  "name": [{"family": "González", "given": ["Lázaro"]}],
  "telecom": [{"system": "phone", "value": "+5355534567"}]
}'::jsonb),
('c3d4e5f6-a7b8-9c0d-1e2f-3a4b5c6d7e8f',
'{
  "resourceType": "RelatedPerson",
  "id": "c3d4e5f6-a7b8-9c0d-1e2f-3a4b5c6d7e8f",
  "patient": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"},
  "relationship": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
      "code": "MAUNT",
      "display": "Tía"
    }]
  }],
  "name": [{"family": "Valdés", "given": ["Isabel"]}],
  "telecom": [{"system": "phone", "value": "+5355545678"}]
}'::jsonb),
('d4e5f6a7-b8c9-0d1e-2f3a-4b5c6d7e8f9a',
'{
  "resourceType": "RelatedPerson",
  "id": "d4e5f6a7-b8c9-0d1e-2f3a-4b5c6d7e8f9a",
  "patient": {"reference": "Patient/f1a2b3c4-5678-90ab-cdef-1234567890ad"},
  "relationship": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
      "code": "FTH",
      "display": "Padre"
    }]
  }],
  "name": [{"family": "Díaz", "given": ["Roberto"]}],
  "telecom": [{"system": "phone", "value": "+5355556789"}]
}'::jsonb),
('e5f6a7b8-c9d0-1e2f-3a4b-5c6d7e8f9a0b',
'{
  "resourceType": "RelatedPerson",
  "id": "e5f6a7b8-c9d0-1e2f-3a4b-5c6d7e8f9a0b",
  "patient": {"reference": "Patient/a2b3c4d5-e6f7-890a-bcde-f1234567890e"},
  "relationship": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
      "code": "CAREGIVER",
      "display": "Cuidador"
    }]
  }],
  "name": [{"family": "Suárez", "given": ["Marta"]}],
  "telecom": [{"system": "phone", "value": "+5355567890"}]
}'::jsonb),
('11111111-aaaa-bbbb-cccc-000000000001',
'{
  "resourceType": "RelatedPerson",
  "id": "11111111-aaaa-bbbb-cccc-000000000001",
  "patient": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "relationship": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
      "code": "GRNDDAU",
      "display": "Abuela"
    }]
  }],
  "name": [{"family": "Hernández", "given": ["Carmen","Luisa"]}],
  "telecom": [{"system": "phone", "value": "+5355512345"}]
}'::jsonb),
('22222222-bbbb-cccc-dddd-000000000002',
'{
  "resourceType": "RelatedPerson",
  "id": "22222222-bbbb-cccc-dddd-000000000002",
  "patient": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"},
  "relationship": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
      "code": "BRO",
      "display": "Hermano"
    }]
  }],
  "name": [{"family": "González", "given": ["Lázaro"]}],
  "telecom": [{"system": "phone", "value": "+5355534567"}]
}'::jsonb),
('33333333-cccc-dddd-eeee-000000000003',
'{
  "resourceType": "RelatedPerson",
  "id": "33333333-cccc-dddd-eeee-000000000003",
  "patient": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"},
  "relationship": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
      "code": "MAUNT",
      "display": "Tía"
    }]
  }],
  "name": [{"family": "Valdés", "given": ["Isabel"]}],
  "telecom": [{"system": "phone", "value": "+5355545678"}]
}'::jsonb),
('44444444-dddd-eeee-ffff-000000000004',
'{
  "resourceType": "RelatedPerson",
  "id": "44444444-dddd-eeee-ffff-000000000004",
  "patient": {"reference": "Patient/f1a2b3c4-5678-90ab-cdef-1234567890ad"},
  "relationship": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
      "code": "FTH",
      "display": "Padre"
    }]
  }],
  "name": [{"family": "Díaz", "given": ["Roberto"]}],
  "telecom": [{"system": "phone", "value": "+5355556789"}]
}'::jsonb),
('55555555-eeee-ffff-0000-000000000005',
'{
  "resourceType": "RelatedPerson",
  "id": "55555555-eeee-ffff-0000-000000000005",
  "patient": {"reference": "Patient/a2b3c4d5-e6f7-890a-bcde-f1234567890e"},
  "relationship": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
      "code": "CAREGIVER",
      "display": "Cuidador"
    }]
  }],
  "name": [{"family": "Suárez", "given": ["Marta"]}],
  "telecom": [{"system": "phone", "value": "+5355567890"}]
}'::jsonb),
('66666666-0000-1111-2222-333333333333',
'{
  "resourceType": "RelatedPerson",
  "id": "66666666-0000-1111-2222-333333333333",
  "patient": {"reference": "Patient/b3c4d5e6-f7a8-9012-bcde-f2345678901f"},
  "relationship": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
      "code": "SIS",
      "display": "Hermana"
    }]
  }],
  "name": [{"family": "Martínez", "given": ["Yanelis"]}],
  "telecom": [{"system": "phone", "value": "+5355578901"}]
}'::jsonb),
('77777777-1111-2222-3333-444444444444',
'{
  "resourceType": "RelatedPerson",
  "id": "77777777-1111-2222-3333-444444444444",
  "patient": {"reference": "Patient/01a2b3c4-d5e6-7890-abcd-ef1234567890"},
  "relationship": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
      "code": "MTH",
      "display": "Madre"
    }]
  }],
  "name": [{"family": "López", "given": ["María"]}],
  "telecom": [{"system": "phone", "value": "+5355589012"}]
}'::jsonb),
('88888888-2222-3333-4444-555555555555',
'{
  "resourceType": "RelatedPerson",
  "id": "88888888-2222-3333-4444-555555555555",
  "patient": {"reference": "Patient/02b3c4d5-e6f7-890a-bcde-f12345678901"},
  "relationship": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
      "code": "FTH",
      "display": "Padre"
    }]
  }],
  "name": [{"family": "Ramírez", "given": ["Jorge"]}],
  "telecom": [{"system": "phone", "value": "+5355590123"}]
}'::jsonb),
('99999999-3333-4444-5555-666666666666',
'{
  "resourceType": "RelatedPerson",
  "id": "99999999-3333-4444-5555-666666666666",
  "patient": {"reference": "Patient/03c4d5e6-f7a8-9012-bcde-f23456789012"},
  "relationship": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
      "code": "SPO",
      "display": "Cónyuge"
    }]
  }],
  "name": [{"family": "Fernández", "given": ["Ana"]}],
  "telecom": [{"system": "phone", "value": "+5355501234"}]
}'::jsonb),
('aaaaaaaa-4444-5555-6666-777777777777',
'{
  "resourceType": "RelatedPerson",
  "id": "aaaaaaaa-4444-5555-6666-777777777777",
  "patient": {"reference": "Patient/04d5e6f7-a8b9-0123-cdef-345678901234"},
  "relationship": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
      "code": "CHILD",
      "display": "Hijo"
    }]
  }],
  "name": [{"family": "Pérez", "given": ["Carlos"]}],
  "telecom": [{"system": "phone", "value": "+5355512346"}]
}'::jsonb),
('bbbbbbbb-5555-6666-7777-888888888888',
'{
  "resourceType": "RelatedPerson",
  "id": "bbbbbbbb-5555-6666-7777-888888888888",
  "patient": {"reference": "Patient/05e6f7a8-b9c0-1234-def0-567890123456"},
  "relationship": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
      "code": "FTH",
      "display": "Padre"
    }]
  }],
  "name": [{"family": "García", "given": ["Miguel"]}],
  "telecom": [{"system": "phone", "value": "+5355523456"}]
}'::jsonb),
('cccccccc-6666-7777-8888-999999999999',
'{
  "resourceType": "RelatedPerson",
  "id": "cccccccc-6666-7777-8888-999999999999",
  "patient": {"reference": "Patient/06f7a8b9-c0d1-2345-ef01-678901234567"},
  "relationship": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
      "code": "SIS",
      "display": "Hermana"
    }]
  }],
  "name": [{"family": "Rodríguez", "given": ["Elena"]}],
  "telecom": [{"system": "phone", "value": "+5355534567"}]
}'::jsonb),
('dddddddd-7777-8888-9999-000000000000',
'{
  "resourceType": "RelatedPerson",
  "id": "dddddddd-7777-8888-9999-000000000000",
  "patient": {"reference": "Patient/07a8b9c0-d1e2-3456-f012-789012345678"},
  "relationship": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
      "code": "MTH",
      "display": "Madre"
    }]
  }],
  "name": [{"family": "Fernández", "given": ["Luz"]}],
  "telecom": [{"system": "phone", "value": "+5355545679"}]
}'::jsonb),
('eeeeeeee-8888-9999-0000-111111111111',
'{
  "resourceType": "RelatedPerson",
  "id": "eeeeeeee-8888-9999-0000-111111111111",
  "patient": {"reference": "Patient/08b9c0d1-e2f3-4567-0123-890123456789"},
  "relationship": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
      "code": "SPO",
      "display": "Cónyuge"
    }]
  }],
  "name": [{"family": "Molina", "given": ["José"]}],
  "telecom": [{"system": "phone", "value": "+5355556780"}]
}'::jsonb),
('ffffffff-9999-0000-1111-222222222222',
'{
  "resourceType": "RelatedPerson",
  "id": "ffffffff-9999-0000-1111-222222222222",
  "patient": {"reference": "Patient/09c0d1e2-f345-6789-0123-901234567890"},
  "relationship": [{
    "coding": [{
      "system": "http://terminology.hl7.org/CodeSystem/v3-RoleCode",
      "code": "CHILD",
      "display": "Hijo"
    }]
  }],
  "name": [{"family": "Castro", "given": ["Luis"]}],
  "telecom": [{"system": "phone", "value": "+5355567891"}]
}'::jsonb);

-- 15. ImmunizationRecommendation(31) ✔
INSERT INTO immunization_recommendations (id, resource) VALUES
('1f8c4a2b-3b5d-4c6e-8e8d-1b2c3d4e5f6a',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "1f8c4a2b-3b5d-4c6e-8e8d-1b2c3d4e5f6a",
  "patient": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "recommendation": [{
    "vaccineCode": {
      "coding": [{
        "system": "http://hl7.org/fhir/sid/cvx",
        "code": "08",
        "display": "Hepatitis B"
      }]
    },
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status",
        "code": "due",
        "display": "Dose is due"
      }]
    },
    "dateCriterion": [{
      "code": {
        "coding": [{
          "system": "http://loinc.org",
          "code": "30980-7",
          "display": "Earliest Date"
        }]
      },
      "value": "2025-07-01T00:00:00"
    }],
    "doseNumber": 3
  }]
}'::jsonb),
('bcg-0001-0001-0001-000000000001',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "bcg-0001-0001-0001-000000000001",
  "patient": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "recommendation": [{
    "vaccineCode": {
      "coding": [{
        "system": "http://hl7.org/fhir/sid/cvx", "code": "01", "display": "BCG"
      }]
    },
    "forecastStatus": {
      "coding": [{
        "system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status",
        "code": "complete",
        "display": "All doses complete"
      }]
    },
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "1990-09-10T00:00:00"
    }],
    "doseNumber": 1
  }]
}'::jsonb),
('opv-0002-0002-0002-000000000002',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "opv-0002-0002-0002-000000000002",
  "patient": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "recommendation": [{
    "vaccineCode": {
      "coding": [{
        "system": "http://hl7.org/fhir/sid/cvx", "code": "89", "display": "Polio (OPV)"
      }]
    },
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "due", "display": "Dose is due"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2025-08-01T00:00:00"
    }],
    "doseNumber": 4
  }]
}'::jsonb),
('pent-0003-0003-0003-000000000003',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "pent-0003-0003-0003-000000000003",
  "patient": {"reference": "Patient/f8a9b0c1-2222-3333-4444-555566667777"},
  "recommendation": [{
    "vaccineCode": {
      "coding": [{
        "system": "http://hl7.org/fhir/sid/cvx", "code": "107", "display": "Pentavalente (DTP-HepB-Hib)"
      }]
      },
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "due", "display": "Dose is due"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2025-07-15T00:00:00"
    }],
    "doseNumber": 3
  }]
}'::jsonb),
('dtp-0004-0004-0004-000000000004',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "dtp-0004-0004-0004-000000000004",
  "patient": {"reference": "Patient/d5e6f7a8-1234-4567-89ab-cdef12345678"},
  "recommendation": [{
    "vaccineCode": {
      "coding": [{
        "system": "http://hl7.org/fhir/sid/cvx", "code": "50", "display": "DTP (Triple bacteriana)"
      }]
    },
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "due", "display": "Dose is due"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2025-09-01T00:00:00"
    }],
    "doseNumber": 1
  }]
}'::jsonb),
('mmr-0005-0005-0005-000000000005',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "mmr-0005-0005-0005-000000000005",
  "patient": {"reference": "Patient/a2b3c4d5-e6f7-890a-bcde-f1234567890e"},
  "recommendation": [{
    "vaccineCode": {
      "coding": [{
        "system": "http://hl7.org/fhir/sid/cvx", "code": "03", "display": "MMR (Triple viral)"
      }]
    },
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "due", "display": "Dose is due"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2025-10-01T00:00:00"
    }],
    "doseNumber": 2
  }]
}'::jsonb),
('sob-0006-0006-0006-000000000006',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "sob-0006-0006-0006-000000000006",
  "patient": {"reference": "Patient/01a2b3c4-d5e6-7890-abcd-ef1234567890"},
  "recommendation": [{
    "vaccineCode": {
      "coding": [{
        "system": "http://hl7.org/fhir/sid/cvx", "code": "SOB", "display": "Soberana 02 (COVID-19)"
      }]
    },
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "due", "display": "Dose is due"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2025-07-20T00:00:00"
    }],
    "doseNumber": 3
  }]
}'::jsonb),
('abd-0007-0007-0007-000000000007',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "abd-0007-0007-0007-000000000007",
  "patient": {"reference": "Patient/02b3c4d5-e6f7-890a-bcde-f12345678901"},
  "recommendation": [{
    "vaccineCode": {
      "coding": [{
        "system": "http://hl7.org/fhir/sid/cvx", "code": "ABD", "display": "Abdala (COVID-19)"
      }]
    },
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "due", "display": "Dose is due"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2025-08-15T00:00:00"
    }],
    "doseNumber": 3
  }]
}'::jsonb),
('hep-0008-0008-0008-000000000008',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "hep-0008-0008-0008-000000000008",
  "patient": {"reference": "Patient/03c4d5e6-f7a8-9012-bcde-f23456789012"},
  "recommendation": [{
    "vaccineCode": {
      "coding": [{
        "system": "http://hl7.org/fhir/sid/cvx",
        "code": "08",
        "display": "Hepatitis B"
        }]
    },
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "complete", "display": "All doses complete"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "1995-06-01T00:00:00"
    }],
    "doseNumber": 3
  }]
}'::jsonb),
('pent-0009-0009-0009-000000000009',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "pent-0009-0009-0009-000000000009",
  "patient": {"reference": "Patient/04d5e6f7-a8b9-0123-cdef-345678901234"},
  "recommendation": [{
    "vaccineCode": {
      "coding": [{
        "system": "http://hl7.org/fhir/sid/cvx",
        "code": "107",
        "display": "Pentavalente (DTP-HepB-Hib)"
        }]
    },
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "complete", "display": "All doses complete"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2000-02-01T00:00:00"
    }],
    "doseNumber": 3
  }]
}'::jsonb),
('bcg-0010-0010-0010-000000000010',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "bcg-0010-0010-0010-000000000010",
  "patient": {"reference": "Patient/05e6f7a8-b9c0-1234-def0-567890123456"},
  "recommendation": [{
    "vaccineCode": {
      "coding": [{
        "system": "http://hl7.org/fhir/sid/cvx", "code": "01", "display": "BCG"
      }]
    },
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "complete", "display": "All doses complete"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2005-03-01T00:00:00"
    }],
    "doseNumber": 1
  }]
}'::jsonb),
('bcg-0011-0011-0011-000000000011',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "bcg-0011-0011-0011-000000000011",
  "patient": {"reference": "Patient/06f7a8b9-c0d1-2345-ef01-678901234567"},
  "recommendation": [{
    "vaccineCode": {
      "coding": [{
        "system": "http://hl7.org/fhir/sid/cvx", "code": "01", "display": "BCG"
      }]
    },
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "complete", "display": "All doses complete"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2010-04-15T00:00:00"
    }],
    "doseNumber": 1
  }]
}'::jsonb),
('opv-0012-0012-0012-000000000012',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "opv-0012-0012-0012-000000000012",
  "patient": {"reference": "Patient/07a8b9c0-d1e2-3456-f012-789012345678"},
  "recommendation": [{
    "vaccineCode": {
      "coding": [{
        "system": "http://hl7.org/fhir/sid/cvx", "code": "89", "display": "Polio (OPV)"
      }]
    },
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "due", "display": "Dose is due"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2025-09-15T00:00:00"
    }],
    "doseNumber": 4
  }]
}'::jsonb),
('pent-0013-0013-0013-000000000013',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "pent-0013-0013-0013-000000000013",
  "patient": {"reference": "Patient/08b9c0d1-e2f3-4567-0123-890123456789"},
  "recommendation": [{
    "vaccineCode": {
      "coding": [{
        "system": "http://hl7.org/fhir/sid/cvx",
        "code": "107", "display": "Pentavalente (DTP-HepB-Hib)"
      }]
    },
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "complete", "display": "All doses complete"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2012-07-01T00:00:00"
    }],
    "doseNumber": 3
  }]
}'::jsonb),
('dtp-0014-0014-0014-000000000014',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "dtp-0014-0014-0014-000000000014",
  "patient": {"reference": "Patient/09c0d1e2-f345-6789-0123-901234567890"},
  "recommendation": [{
    "vaccineCode": {
      "coding": [{
        "system": "http://hl7.org/fhir/sid/cvx",
        "code": "50", "display": "DTP (Triple bacteriana)"
      }]
    },
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "due", "display": "Dose is due"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2025-10-10T00:00:00"
    }],
    "doseNumber": 1
  }]
}'::jsonb),
('mmr-0015-0015-0015-000000000015',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "mmr-0015-0015-0015-000000000015",
  "patient": {"reference": "Patient/10d1e2f3-4567-8901-2345-012345678901"},
  "recommendation": [{
    "vaccineCode": {
      "coding": [{
        "system": "http://hl7.org/fhir/sid/cvx",
      "code": "03", "display": "MMR (Triple viral)"
      }]
    },
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "due", "display": "Dose is due"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2025-11-01T00:00:00"
    }],
    "doseNumber": 2
  }]
}'::jsonb),
('sob-0016-0016-0016-000000000016',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "sob-0016-0016-0016-000000000016",
  "patient": {"reference": "Patient/1a2b3c4d-5e6f-7890-abcd-1234567890ef"},
  "recommendation": [{
    "vaccineCode": {
      "coding": [{
        "system": "http://hl7.org/fhir/sid/cvx",
        "code": "SOB", "display": "Soberana 02 (COVID-19)"
      }]
    },
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "due", "display": "Dose is due"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2025-11-15T00:00:00"
    }],
    "doseNumber": 3
  }]
}'::jsonb),
('abd-0017-0017-0017-000000000017',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "abd-0017-0017-0017-000000000017",
  "patient": {"reference": "Patient/2b3c4d5e-6f7a-8b9c-0d1e-2f3a4b5c6d7e"},
  "recommendation": [{
    "vaccineCode": {
      "coding": [{
        "system": "http://hl7.org/fhir/sid/cvx",
        "code": "ABD",
        "display": "Abdala (COVID-19)"
      }]
    },
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "complete", "display": "All doses complete"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2023-09-01T00:00:00"
    }],
    "doseNumber": 3
  }]
}'::jsonb),
('hep-0018-0018-0018-000000000018',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "hep-0018-0018-0018-000000000018",
  "patient": {"reference": "Patient/3c4d5e6f-7a8b-9c0d-1e2f-3a4b5c6d7e8f"},
  "recommendation": [{
    "vaccineCode": {
      "coding": [{
        "system": "http://hl7.org/fhir/sid/cvx", "code": "08", "display": "Hepatitis B"
      }]},
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "due", "display": "Dose is due"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2025-12-01T00:00:00"
    }],
    "doseNumber": 3
  }]
}'::jsonb),
('pent-0019-0019-0019-000000000019',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "pent-0019-0019-0019-000000000019",
  "patient": {"reference": "Patient/4d5e6f7a-8b9c-0d1e-2f3a-4b5c6d7e8f9a"},
  "recommendation": [{
    "vaccineCode": {
    "coding": [{"system": "http://hl7.org/fhir/sid/cvx",
    "code": "107", "display": "Pentavalente (DTP-HepB-Hib)"}]},
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "due", "display": "Dose is due"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2025-12-10T00:00:00"
    }],
    "doseNumber": 3
  }]
}'::jsonb),
('bcg-0020-0020-0020-000000000020',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "bcg-0020-0020-0020-000000000020",
  "patient": {"reference": "Patient/5e6f7a8b-9c0d-1e2f-3a4b-5c6d7e8f9a0b"},
  "recommendation": [{
    "vaccineCode": {
    "coding": [{"system": "http://hl7.org/fhir/sid/cvx", "code": "01", "display": "BCG"}]},
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "complete", "display": "All doses complete"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2015-03-01T00:00:00"
    }],
    "doseNumber": 1
  }]
}'::jsonb),
('bcg-0021-0021-0021-000000000021',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "bcg-0021-0021-0021-000000000021",
  "patient": {"reference": "Patient/07a8b9c0-d1e2-3456-f012-789012345678"},
  "recommendation": [{
    "vaccineCode": {
    "coding": [{"system": "http://hl7.org/fhir/sid/cvx", "code": "01", "display": "BCG"}]},
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "due", "display": "Dose is due"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2025-06-01T00:00:00"
    }],
    "doseNumber": 1
  }]
}'::jsonb),
('hep-0022-0022-0022-000000000022',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "hep-0022-0022-0022-000000000022",
  "patient": {"reference": "Patient/07a8b9c0-d1e2-3456-f012-789012345678"},
  "recommendation": [{
    "vaccineCode": {
    "coding": [{"system": "http://hl7.org/fhir/sid/cvx", "code": "08", "display": "Hepatitis B"}]},
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "due", "display": "Dose is due"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2025-06-01T00:00:00"
    }],
    "doseNumber": 1
  }]
}'::jsonb),
('opv-0023-0023-0023-000000000023',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "opv-0023-0023-0023-000000000023",
  "patient": {"reference": "Patient/08b9c0d1-e2f3-4567-0123-890123456789"},
  "recommendation": [{
    "vaccineCode": {
    "coding": [{"system": "http://hl7.org/fhir/sid/cvx", "code": "89", "display": "Polio (OPV)"}]},
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "due", "display": "Dose is due"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2025-09-10T00:00:00"
    }],
    "doseNumber": 4
  }]
}'::jsonb),
('pent-0024-0024-0024-000000000024',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "pent-0024-0024-0024-000000000024",
  "patient": {"reference": "Patient/08b9c0d1-e2f3-4567-0123-890123456789"},
  "recommendation": [{
    "vaccineCode": {
    "coding": [{"system": "http://hl7.org/fhir/sid/cvx",
    "code": "107", "display": "Pentavalente (DTP-HepB-Hib)"}]},
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "due", "display": "Dose is due"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2025-09-10T00:00:00"
    }],
    "doseNumber": 3
  }]
}'::jsonb),
('mmr-0025-0025-0025-000000000025',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "mmr-0025-0025-0025-000000000025",
  "patient": {"reference": "Patient/09c0d1e2-f345-6789-0123-901234567890"},
  "recommendation": [{
    "vaccineCode": {
    "coding": [{"system": "http://hl7.org/fhir/sid/cvx", "code": "03", "display": "MMR (Triple viral)"}]},
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "due", "display": "Dose is due"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2025-11-01T00:00:00"
    }],
    "doseNumber": 2
  }]
}'::jsonb),
('dtp-0026-0026-0026-000000000026',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "dtp-0026-0026-0026-000000000026",
  "patient": {"reference": "Patient/09c0d1e2-f345-6789-0123-901234567890"},
  "recommendation": [{
    "vaccineCode": {
      "coding": [{
        "system": "http://hl7.org/fhir/sid/cvx",
        "code": "50",
        "display": "DTP (Triple bacteriana)"
      }]
    },
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "due", "display": "Dose is due"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2025-11-01T00:00:00"
    }],
    "doseNumber": 1
  }]
}'::jsonb),
('dtp-0027-0027-0027-000000000027',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "dtp-0027-0027-0027-000000000027",
  "patient": {"reference": "Patient/10d1e2f3-4567-8901-2345-012345678901"},
  "recommendation": [{
    "vaccineCode": {

    "coding": [{"system": "http://hl7.org/fhir/sid/cvx", "code": "50", "display": "DTP (Triple bacteriana)"}]},
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "due", "display": "Dose is due"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2025-12-01T00:00:00"
    }],
    "doseNumber": 1
  }]
}'::jsonb),
('mmr-0028-0028-0028-000000000028',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "mmr-0028-0028-0028-000000000028",
  "patient": {"reference": "Patient/10d1e2f3-4567-8901-2345-012345678901"},
  "recommendation": [{
    "vaccineCode": {

    "coding": [{"system": "http://hl7.org/fhir/sid/cvx", "code": "03", "display": "MMR (Triple viral)"}]},
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "complete", "display": "All doses complete"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2010-01-01T00:00:00"
    }],
    "doseNumber": 2
  }]
}'::jsonb),
('sob-0029-0029-0029-000000000029',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "sob-0029-0029-0029-000000000029",
  "patient": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "recommendation": [{
    "vaccineCode": {

    "coding": [{"system": "http://hl7.org/fhir/sid/cvx", "code": "SOB", "display": "Soberana 02 (COVID-19)"}]},
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "complete", "display": "All doses complete"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2021-08-01T00:00:00"
    }],
    "doseNumber": 3
  }]
}'::jsonb),
('abd-0030-0030-0030-000000000030',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "abd-0030-0030-0030-000000000030",
  "patient": {"reference": "Patient/c1d2e3f4-5678-90ab-cdef-1234567890ab"},
  "recommendation": [{
    "vaccineCode": {

    "coding": [{"system": "http://hl7.org/fhir/sid/cvx", "code": "ABD", "display": "Abdala (COVID-19)"}]},
    "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "complete", "display": "All doses complete"}]},
    "dateCriterion": [{
      "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
      "value": "2021-09-01T00:00:00"
    }],
    "doseNumber": 3
  }]
}'::jsonb),
('escolares-0001-0001-0001-000000000001',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "escolares-0001-0001-0001-000000000001",
  "patient": {"reference": "Patient/08b9c0d1-e2f3-4567-0123-890123456789"},
  "recommendation": [
    {
      "vaccineCode": {

      "coding": [{"system": "http://hl7.org/fhir/sid/cvx", "code": "89", "display": "Polio (OPV)"}]},
      "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "due", "display": "Dose is due"}]},
      "dateCriterion": [{
        "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
        "value": "2025-09-10T00:00:00"
      }],
      "doseNumber": 4
    },
    {
      "vaccineCode": {
      "coding": [{"system": "http://hl7.org/fhir/sid/cvx",
      "code": "107", "display": "Pentavalente (DTP-HepB-Hib)"}]
      },
      "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "due", "display": "Dose is due"}]},
      "dateCriterion": [{
        "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
        "value": "2025-09-10T00:00:00"
      }],
      "doseNumber": 3
    }
  ]
}'::jsonb),
('embarazo-0002-0002-0002-000000000002',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "embarazo-0002-0002-0002-000000000002",
  "patient": {"reference": "Patient/03c4d5e6-f7a8-9012-bcde-f23456789012"},
  "recommendation": [
    {
      "vaccineCode": {
      "coding": [{"system": "http://hl7.org/fhir/sid/cvx", "code": "50", "display": "DTP (Triple bacteriana)"}]},
      "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "due", "display": "Dose is due"}]},
      "dateCriterion": [{
        "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
        "value": "2025-07-01T00:00:00"
      }],
      "doseNumber": 1
    },
    {
      "vaccineCode": {

      "coding": [{"system": "http://hl7.org/fhir/sid/cvx", "code": "08", "display": "Hepatitis B"}]},
      "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "due", "display": "Dose is due"}]},
      "dateCriterion": [{
        "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
        "value": "2025-07-01T00:00:00"
      }],
      "doseNumber": 3
    }
  ]
}'::jsonb),
('adultomayor-0003-0003-0003-000000000003',
'{
  "resourceType": "ImmunizationRecommendation",
  "id": "adultomayor-0003-0003-0003-000000000003",
  "patient": {"reference": "Patient/bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a"},
  "recommendation": [
    {
      "vaccineCode": {
      "coding": [{"system": "http://hl7.org/fhir/sid/cvx", "code": "ABD", "display": "Abdala (COVID-19)"}]},
      "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "complete", "display": "All doses complete"}]},
      "dateCriterion": [{
        "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
        "value": "2022-01-01T00:00:00"
      }],
      "doseNumber": 3
    },
    {
      "vaccineCode": {
      "coding": [{"system": "http://hl7.org/fhir/sid/cvx", "code": "SOB", "display": "Soberana 02 (COVID-19)"}]},
      "forecastStatus": {"coding": [{"system": "http://terminology.hl7.org/CodeSystem/immunization-recommendation-status", "code": "due", "display": "Refuerzo recomendado"}]},
      "dateCriterion": [{
        "code": {"coding": [{"system": "http://loinc.org", "code": "30980-7", "display": "Earliest Date"}]},
        "value": "2025-10-01T00:00:00"
      }],
      "doseNumber": 4
    }
  ]
}'::jsonb);

-- 16. Organization(19) ✔
INSERT INTO organizations (id, resource) VALUES
('0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a',
'{
  "resourceType": "Organization",
  "id": "0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a",
  "name": "Centro de Ingeniería Genética y Biotecnología",
  "contact": [{"address": {"line": ["Ave. 31 entre 158 y 190"], "city": "La Habana"}}]
}'::jsonb),
('f47ac10b-58cc-4372-a567-0e02b2c3d479',
'{
  "resourceType": "Organization",
  "id": "f47ac10b-58cc-4372-a567-0e02b2c3d479",
  "name": "Hospital General Artemisa",
  "address": [{"line": ["Calle 12 #345"], "city": "Artemisa", "state": "Artemisa", "country": "Cuba"}]
}'::jsonb),
('a3bb189e-8bf9-3888-9912-ace4e6543002',
'{
  "resourceType": "Organization",
  "id": "a3bb189e-8bf9-3888-9912-ace4e6543002",
  "name": "Policlínico Docente Bayamo",
  "address": [{"line": ["Ave. Central #123"], "city": "Bayamo", "state": "Granma", "country": "Cuba"}]
}'::jsonb),
('9c858901-8a57-4791-81fe-4c455b099bc9',
'{
  "resourceType": "Organization",
  "id": "9c858901-8a57-4791-81fe-4c455b099bc9",
  "name": "Hospital Provincial Camagüey",
  "address": [{"line": ["Calle 26 #789"], "city": "Camagüey", "state": "Camagüey", "country": "Cuba"}]
}'::jsonb),
('16fd2706-8baf-433b-82eb-8c7fada847da',
'{
  "resourceType": "Organization",
  "id": "16fd2706-8baf-433b-82eb-8c7fada847da",
  "name": "Hospital General Ciego de Ávila",
  "address": [{"line": ["Ave. 1ra #456"], "city": "Ciego de Ávila", "state": "Ciego de Ávila", "country": "Cuba"}]
}'::jsonb),
('7c9e6679-7425-40de-944b-e07fc1f90ae7',
'{
  "resourceType": "Organization",
  "id": "7c9e6679-7425-40de-944b-e07fc1f90ae7",
  "name": "Centro de Salud Cienfuegos",
  "address": [{"line": ["Calle 37 #234"], "city": "Cienfuegos", "state": "Cienfuegos", "country": "Cuba"}]
}'::jsonb),
('e358a3f0-4f45-4f0a-9a3f-4b3e4f9a6f7b',
'{
  "resourceType": "Organization",
  "id": "e358a3f0-4f45-4f0a-9a3f-4b3e4f9a6f7b",
  "name": "Hospital Provincial Guantánamo",
  "address": [{"line": ["Ave. 5ta #567"], "city": "Guantánamo", "state": "Guantánamo", "country": "Cuba"}]
}'::jsonb),
('d4c3b2a1-5e6f-7a8b-9c0d-1e2f3a4b5c6d',
'{
  "resourceType": "Organization",
  "id": "d4c3b2a1-5e6f-7a8b-9c0d-1e2f3a4b5c6d",
  "name": "Policlínico Holguín",
  "address": [{"line": ["Calle Martí #890"], "city": "Holguín", "state": "Holguín", "country": "Cuba"}]
}'::jsonb),
('c1d2e3f4-5678-90ab-cdef-1234567890ab',
'{
  "resourceType": "Organization",
  "id": "c1d2e3f4-5678-90ab-cdef-1234567890ab",
  "name": "Hospital Clínico La Habana",
  "address": [{"line": ["Ave. San Lázaro #701"], "city": "La Habana", "state": "La Habana", "country": "Cuba"}]
}'::jsonb),
('b2c3d4e5-6789-0abc-def1-234567890abc',
'{
  "resourceType": "Organization",
  "id": "b2c3d4e5-6789-0abc-def1-234567890abc",
  "name": "Centro de Salud Matanzas",
  "address": [{"line": ["Calle 50 #123"], "city": "Matanzas", "state": "Matanzas", "country": "Cuba"}]
}'::jsonb),
('a1b2c3d4-e5f6-7890-abcd-ef0123456789',
'{
  "resourceType": "Organization",
  "id": "a1b2c3d4-e5f6-7890-abcd-ef0123456789",
  "name": "Hospital Provincial Pinar del Río",
  "address": [{"line": ["Carretera Central km 2"], "city": "Pinar del Río", "state": "Pinar del Río", "country": "Cuba"}]
}'::jsonb),
('123e4567-e89b-12d3-a456-426614174000',
'{
  "resourceType": "Organization",
  "id": "123e4567-e89b-12d3-a456-426614174000",
  "name": "Hospital General Sancti Spíritus",
  "address": [{"line": ["Ave. Camilo Cienfuegos s/n"], "city": "Sancti Spíritus", "state": "Sancti Spíritus", "country": "Cuba"}]
}'::jsonb),
('987f6543-21fe-43dc-ba98-76543210fedc',
'{
  "resourceType": "Organization",
  "id": "987f6543-21fe-43dc-ba98-76543210fedc",
  "name": "Policlínico Universitario Santa Clara",
  "address": [{"line": ["Calle Maceo #301"], "city": "Santa Clara", "state": "Villa Clara", "country": "Cuba"}]
}'::jsonb),
('456789ab-cdef-1234-5678-90abcdef1234',
'{
  "resourceType": "Organization",
  "id": "456789ab-cdef-1234-5678-90abcdef1234",
  "name": "Hospital Provincial Santiago de Cuba",
  "address": [{"line": ["Carretera Central km 3"], "city": "Santiago de Cuba", "state": "Santiago de Cuba", "country": "Cuba"}]
}'::jsonb),
('a9f1c3e2-7b4d-4c6a-9f3e-1d2a3b4c5d6e',
'{
  "resourceType": "Organization",
  "id": "a9f1c3e2-7b4d-4c6a-9f3e-1d2a3b4c5d6e",
  "name": "Hospital General Docente Enrique Cabrera",
  "address": [{"line": ["Ave. Rancho Boyeros km 8"], "city": "La Habana", "state": "La Habana", "country": "Cuba"}]
}'::jsonb),
('b2d4e6f8-9a0b-4c3d-8e7f-1a2b3c4d5e6f',
'{
  "resourceType": "Organization",
  "id": "b2d4e6f8-9a0b-4c3d-8e7f-1a2b3c4d5e6f",
  "name": "Hospital Pediátrico William Soler",
  "address": [{"line": ["Ave. 100 #5901"], "city": "La Habana", "state": "La Habana", "country": "Cuba"}]
}'::jsonb),
('c3e5f7a9-0b1c-4d3e-9f8a-2b3c4d5e6f7a',
'{
  "resourceType": "Organization",
  "id": "c3e5f7a9-0b1c-4d3e-9f8a-2b3c4d5e6f7a",
  "name": "Policlínico Universitario 19 de Abril",
  "address": [{"line": ["Calle 19 de Abril #19"], "city": "La Habana", "state": "La Habana", "country": "Cuba"}]
}'::jsonb),
('d4f6a8c0-1b2d-4e3f-9a0b-3c4d5e6f7a8b',
'{
  "resourceType": "Organization",
  "id": "d4f6a8c0-1b2d-4e3f-9a0b-3c4d5e6f7a8b",
  "name": "Hospital General Camilo Cienfuegos",
  "address": [{"line": ["Ave. Camilo Cienfuegos s/n"], "city": "Sancti Spíritus", "state": "Sancti Spíritus", "country": "Cuba"}]
}'::jsonb),
('e5a7c9d1-2c3e-4f5a-8b0c-4d5e6f7a8b9c',
'{
  "resourceType": "Organization",
  "id": "e5a7c9d1-2c3e-4f5a-8b0c-4d5e6f7a8b9c",
  "name": "Hospital Provincial Saturnino Lora",
  "address": [{"line": ["Carretera Central km 3"], "city": "Santiago de Cuba", "state": "Santiago de Cuba", "country": "Cuba"}]
}'::jsonb);

-- 17. Location(54) ✔
INSERT INTO locations (id, resource) VALUES
('0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a',
'{
  "resourceType": "Location",
  "id": "0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a",
  "status": "active",
  "name": "Consultorio Médico #5",
  "identifier": [{"value": "cdr-001"}],
  "address": {"line": ["Calle 12 #345"], "city": "La Habana", "state": "La Habana", "postalCode": "10400"},
  "partOf": {"reference": "Location/"}
}'::jsonb),
('1a2b3c4d-5e6f-7890-abcd-1234567890ef',
'{
  "resourceType": "Location",
  "id": "1a2b3c4d-5e6f-7890-abcd-1234567890ef",
  "status": "active",
  "name": "Policlínico Universitario Plaza",
  "identifier": [{"value": "plaza-001"}],
  "address": {"line": ["Calle 23 #456"], "city": "La Habana", "state": "La Habana", "postalCode": "10400"},
  "partOf": {"reference": "Location/0d1e2f3a-4b5c-6d7e-8f9a-0b1c2d3e4f5a"}
}'::jsonb),
('2b3c4d5e-6f7a-8b9c-0d1e-2f3a4b5c6d7e',
'{
  "resourceType": "Location",
  "id": "2b3c4d5e-6f7a-8b9c-0d1e-2f3a4b5c6d7e",
  "status": "active",
  "name": "Consultorio Médico #8",
  "identifier": [{"value": "cdr-008"}],
  "address": {"line": ["Calle Martí #321"], "city": "Santiago de Cuba", "state": "Santiago de Cuba", "postalCode": "90100"},
  "partOf": {"reference": "Location/1a2b3c4d-5e6f-7890-abcd-1234567890ef"}
}'::jsonb),
('3c4d5e6f-7a8b-9c0d-1e2f-3a4b5c6d7e8f',
'{
  "resourceType": "Location",
  "id": "3c4d5e6f-7a8b-9c0d-1e2f-3a4b5c6d7e8f",
  "status": "active",
  "name": "Hospital Provincial Pinar del Río",
  "identifier": [{"value": "hosp-pinar-01"}],
  "address": {"line": ["Carretera Central km 2"], "city": "Pinar del Río", "state": "Pinar del Río", "postalCode": "20100"},
  "partOf": {"reference": "Location/"}
}'::jsonb),
('4d5e6f7a-8b9c-0d1e-2f3a-4b5c6d7e8f9a',
'{
  "resourceType": "Location",
  "id": "4d5e6f7a-8b9c-0d1e-2f3a-4b5c6d7e8f9a",
  "status": "active",
  "name": "Sala de Urgencias Hospital Pinar del Río",
  "identifier": [{"value": "urg-pinar-01"}],
  "address": {"line": ["Carretera Central km 2"], "city": "Pinar del Río", "state": "Pinar del Río", "postalCode": "20100"},
  "partOf": {"reference": "Location/3c4d5e6f-7a8b-9c0d-1e2f-3a4b5c6d7e8f"}
}'::jsonb),
('5e6f7a8b-9c0d-1e2f-3a4b-5c6d7e8f9a0b',
'{
  "resourceType": "Location",
  "id": "5e6f7a8b-9c0d-1e2f-3a4b-5c6d7e8f9a0b",
  "status": "active",
  "name": "Consultorio Médico #12",
  "identifier": [{"value": "cdr-012"}],
  "address": {"line": ["Calle Céspedes #789"], "city": "Camagüey", "state": "Camagüey", "postalCode": "70100"},
  "partOf": {"reference": "Location/"}
}'::jsonb),
('6f7a8b9c-0d1e-2f3a-4b5c-6d7e8f9a0b1c',
'{
  "resourceType": "Location",
  "id": "6f7a8b9c-0d1e-2f3a-4b5c-6d7e8f9a0b1c",
  "status": "active",
  "name": "Consultorio Médico #15",
  "identifier": [{"value": "cdr-015"}],
  "address": {"line": ["Calle 10 #222"], "city": "Santa Clara", "state": "Villa Clara", "postalCode": "50100"},
  "partOf": {"reference": "Location/1a2b3c4d-5e6f-7890-abcd-1234567890ef"}
}'::jsonb),

('7a8b9c0d-1e2f-3a4b-5c6d-7e8f9a0b1c2d',
'{
  "resourceType": "Location",
  "id": "7a8b9c0d-1e2f-3a4b-5c6d-7e8f9a0b1c2d",
  "status": "active",
  "name": "Hospital Clínico Quirúrgico Hermanos Ameijeiras",
  "identifier": [{"value": "hosp-hh-aa"}],
  "address": {"line": ["San Lázaro #701"], "city": "La Habana", "state": "La Habana", "postalCode": "10400"},
  "partOf": {"reference": "Location/1a2b3c4d-5e6f-7890-abcd-1234567890ef"}
}'::jsonb),

('8b9c0d1e-2f3a-4b5c-6d7e-8f9a0b1c2d3e',
'{
  "resourceType": "Location",
  "id": "8b9c0d1e-2f3a-4b5c-6d7e-8f9a0b1c2d3e",
  "status": "active",
  "name": "Sala de Terapia Intensiva H. Ameijeiras",
  "identifier": [{"value": "uci-hh-aa"}],
  "address": {"line": ["San Lázaro #701"], "city": "La Habana", "state": "La Habana", "postalCode": "10400"},
  "partOf": {"reference": "Location/7a8b9c0d-1e2f-3a4b-5c6d-7e8f9a0b1c2d"}
}'::jsonb),

('9c0d1e2f-3a4b-5c6d-7e8f-9a0b1c2d3e4f',
'{
  "resourceType": "Location",
  "id": "9c0d1e2f-3a4b-5c6d-7e8f-9a0b1c2d3e4f",
  "status": "active",
  "name": "Consultorio Médico #21",
  "identifier": [{"value": "cdr-021"}],
  "address": {"line": ["Calle Martí #110"], "city": "Matanzas", "state": "Matanzas", "postalCode": "40200"},
  "partOf": {"reference": "Location/1a2b3c4d-5e6f-7890-abcd-1234567890ef"}
}'::jsonb),

('0b1c2d3e-4f5a-6b7c-8d9e-0f1a2b3c4d5e',
'{
  "resourceType": "Location",
  "id": "0b1c2d3e-4f5a-6b7c-8d9e-0f1a2b3c4d5e",
  "status": "active",
  "name": "Hospital Pediátrico William Soler",
  "identifier": [{"value": "hosp-ws-01"}],
  "address": {"line": ["Ave. 100 #5901"], "city": "La Habana", "state": "La Habana", "postalCode": "10800"},
  "partOf": {"reference": "Location/1a2b3c4d-5e6f-7890-abcd-1234567890ef"}
}'::jsonb),

('1b2c3d4e-5f6a-7b8c-9d0e-1f2a3b4c5d6e',
'{
  "resourceType": "Location",
  "id": "1b2c3d4e-5f6a-7b8c-9d0e-1f2a3b4c5d6e",
  "status": "active",
  "name": "Sala de Neonatología H. William Soler",
  "identifier": [{"value": "neo-ws-01"}],
  "address": {"line": ["Ave. 100 #5901"], "city": "La Habana", "state": "La Habana", "postalCode": "10800"},
  "partOf": {"reference": "Location/0b1c2d3e-4f5a-6b7c-8d9e-0f1a2b3c4d5e"}
}'::jsonb),

('2c3d4e5f-6a7b-8c9d-0e1f-2a3b4c5d6e7f',
'{
  "resourceType": "Location",
  "id": "2c3d4e5f-6a7b-8c9d-0e1f-2a3b4c5d6e7f",
  "status": "active",
  "name": "Consultorio Médico #3",
  "identifier": [{"value": "cdr-003"}],
  "address": {"line": ["Calle Cuba #13"], "city": "Bayamo", "state": "Granma", "postalCode": "85100"},
  "partOf": {"reference": "Location/3c4d5e6f-7a8b-9c0d-1e2f-3a4b5c6d7e8f"}
}'::jsonb),

('3d4e5f6a-7b8c-9d0e-1f2a-3b4c5d6e7f8a',
'{
  "resourceType": "Location",
  "id": "3d4e5f6a-7b8c-9d0e-1f2a-3b4c5d6e7f8a",
  "status": "active",
  "name": "Hospital General Camilo Cienfuegos",
  "identifier": [{"value": "hosp-cc-01"}],
  "address": {"line": ["Ave. Camilo Cienfuegos s/n"], "city": "Sancti Spíritus", "state": "Sancti Spíritus", "postalCode": "60100"},
  "partOf": {"reference": "Location/"}
}'::jsonb),

('4e5f6a7b-8c9d-0e1f-2a3b-4c5d6e7f8a9b',
'{
  "resourceType": "Location",
  "id": "4e5f6a7b-8c9d-0e1f-2a3b-4c5d6e7f8a9b",
  "status": "active",
  "name": "Sala de Urgencias H. Camilo Cienfuegos",
  "identifier": [{"value": "urg-cc-01"}],
  "address": {"line": ["Ave. Camilo Cienfuegos s/n"], "city": "Sancti Spíritus", "state": "Sancti Spíritus", "postalCode": "60100"},
  "partOf": {"reference": "Location/3d4e5f6a-7b8c-9d0e-1f2a-3b4c5d6e7f8a"}
}'::jsonb),

('5f6a7b8c-9d0e-1f2a-3b4c-5d6e7f8a9b0c',
'{
  "resourceType": "Location",
  "id": "5f6a7b8c-9d0e-1f2a-3b4c-5d6e7f8a9b0c",
  "status": "active",
  "name": "Consultorio Médico #27",
  "identifier": [{"value": "cdr-027"}],
  "address": {"line": ["Calle Martí #27"], "city": "Holguín", "state": "Holguín", "postalCode": "80100"},
  "partOf": {"reference": "Location/3d4e5f6a-7b8c-9d0e-1f2a-3b4c5d6e7f8a"}
}'::jsonb),
('6a7b8c9d-0e1f-2a3b-4c5d-6e7f8a9b0c1d',
'{
  "resourceType": "Location",
  "id": "6a7b8c9d-0e1f-2a3b-4c5d-6e7f8a9b0c1d",
  "status": "active",
  "name": "Policlínico 26 de Julio",
  "identifier": [{"value": "pol-26jul-01"}],
  "address": {"line": ["Calle 26 de Julio #100"], "city": "Ciego de Ávila", "state": "Ciego de Ávila", "postalCode": "65100"},
  "partOf": {"reference": "Location/"}
}'::jsonb),

('7b8c9d0e-1f2a-3b4c-5d6e-7f8a9b0c1d2e',
'{
  "resourceType": "Location",
  "id": "7b8c9d0e-1f2a-3b4c-5d6e-7f8a9b0c1d2e",
  "status": "active",
  "name": "Consultorio Médico #30",
  "identifier": [{"value": "cdr-030"}],
  "address": {"line": ["Calle Real #45"], "city": "Ciego de Ávila", "state": "Ciego de Ávila", "postalCode": "65100"},
  "partOf": {"reference": "Location/6a7b8c9d-0e1f-2a3b-4c5d-6e7f8a9b0c1d"}
}'::jsonb),

('8c9d0e1f-2a3b-4c5d-6e7f-8a9b0c1d2e3f',
'{
  "resourceType": "Location",
  "id": "8c9d0e1f-2a3b-4c5d-6e7f-8a9b0c1d2e3f",
  "status": "active",
  "name": "Hospital General Docente Enrique Cabrera",
  "identifier": [{"value": "hosp-ecabrera-01"}],
  "address": {"line": ["Ave. Rancho Boyeros km 8"], "city": "La Habana", "state": "La Habana", "postalCode": "10600"},
  "partOf": {"reference": "Location/"}
}'::jsonb),

('9d0e1f2a-3b4c-5d6e-7f8a-9b0c1d2e3f4a',
'{
  "resourceType": "Location",
  "id": "9d0e1f2a-3b4c-5d6e-7f8a-9b0c1d2e3f4a",
  "status": "active",
  "name": "Sala de Cirugía H. Enrique Cabrera",
  "identifier": [{"value": "cir-ecabrera-01"}],
  "address": {"line": ["Ave. Rancho Boyeros km 8"], "city": "La Habana", "state": "La Habana", "postalCode": "10600"},
  "partOf": {"reference": "Location/8c9d0e1f-2a3b-4c5d-6e7f-8a9b0c1d2e3f"}
}'::jsonb),

('0e1f2a3b-4c5d-6e7f-8a9b-0c1d2e3f4a5b',
'{
  "resourceType": "Location",
  "id": "0e1f2a3b-4c5d-6e7f-8a9b-0c1d2e3f4a5b",
  "status": "active",
  "name": "Consultorio Médico #40",
  "identifier": [{"value": "cdr-040"}],
  "address": {"line": ["Calle Independencia #200"], "city": "Cienfuegos", "state": "Cienfuegos", "postalCode": "55100"},
  "partOf": {"reference": "Location/"}
}'::jsonb),

('1f2a3b4c-5d6e-7f8a-9b0c-1d2e3f4a5b6c',
'{
  "resourceType": "Location",
  "id": "1f2a3b4c-5d6e-7f8a-9b0c-1d2e3f4a5b6c",
  "status": "active",
  "name": "Hospital Provincial Saturnino Lora",
  "identifier": [{"value": "hosp-slora-01"}],
  "address": {"line": ["Carretera Central km 3"], "city": "Santiago de Cuba", "state": "Santiago de Cuba", "postalCode": "90100"},
  "partOf": {"reference": "Location/"}
}'::jsonb),

('2a3b4c5d-6e7f-8a9b-0c1d-2e3f4a5b6c7d',
'{
  "resourceType": "Location",
  "id": "2a3b4c5d-6e7f-8a9b-0c1d-2e3f4a5b6c7d",
  "status": "active",
  "name": "Sala de Urgencias H. Saturnino Lora",
  "identifier": [{"value": "urg-slora-01"}],
  "address": {"line": ["Carretera Central km 3"], "city": "Santiago de Cuba", "state": "Santiago de Cuba", "postalCode": "90100"},
  "partOf": {"reference": "Location/1f2a3b4c-5d6e-7f8a-9b0c-1d2e3f4a5b6c"}
}'::jsonb),

('3b4c5d6e-7f8a-9b0c-1d2e-3f4a5b6c7d8e',
'{
  "resourceType": "Location",
  "id": "3b4c5d6e-7f8a-9b0c-1d2e-3f4a5b6c7d8e",
  "status": "active",
  "name": "Consultorio Médico #55",
  "identifier": [{"value": "cdr-055"}],
  "address": {"line": ["Calle Martí #555"], "city": "Holguín", "state": "Holguín", "postalCode": "80100"},
  "partOf": {"reference": "Location/"}
}'::jsonb),

('4c5d6e7f-8a9b-0c1d-2e3f-4a5b6c7d8e9f',
'{
  "resourceType": "Location",
  "id": "4c5d6e7f-8a9b-0c1d-2e3f-4a5b6c7d8e9f",
  "status": "active",
  "name": "Policlínico Docente 19 de Abril",
  "identifier": [{"value": "pol-19abr-01"}],
  "address": {"line": ["Calle 19 de Abril #19"], "city": "La Habana", "state": "La Habana", "postalCode": "10400"},
  "partOf": {"reference": "Location/"}
}'::jsonb),

('5d6e7f8a-9b0c-1d2e-3f4a-5b6c7d8e9f0a',
'{
  "resourceType": "Location",
  "id": "5d6e7f8a-9b0c-1d2e-3f4a-5b6c7d8e9f0a",
  "status": "active",
  "name": "Consultorio Médico #60",
  "identifier": [{"value": "cdr-060"}],
  "address": {"line": ["Calle Real #60"], "city": "Artemisa", "state": "Artemisa", "postalCode": "32100"},
  "partOf": {"reference": "Location/"}
}'::jsonb),

('6e7f8a9b-0c1d-2e3f-4a5b-6c7d8e9f0a1b',
'{
  "resourceType": "Location",
  "id": "6e7f8a9b-0c1d-2e3f-4a5b-6c7d8e9f0a1b",
  "status": "active",
  "name": "Hospital General Abel Santamaría",
  "identifier": [{"value": "hosp-abel-01"}],
  "address": {"line": ["Ave. 26 de Julio #500"], "city": "Pinar del Río", "state": "Pinar del Río", "postalCode": "20100"},
  "partOf": {"reference": "Location/"}
}'::jsonb),

('7f8a9b0c-1d2e-3f4a-5b6c-7d8e9f0a1b2c',
'{
  "resourceType": "Location",
  "id": "7f8a9b0c-1d2e-3f4a-5b6c-7d8e9f0a1b2c",
  "status": "active",
  "name": "Sala de Maternidad H. Abel Santamaría",
  "identifier": [{"value": "mat-abel-01"}],
  "address": {"line": ["Ave. 26 de Julio #500"], "city": "Pinar del Río", "state": "Pinar del Río", "postalCode": "20100"},
  "partOf": {"reference": "Location/6e7f8a9b-0c1d-2e3f-4a5b-6c7d8e9f0a1b"}
}'::jsonb),

('8a9b0c1d-2e3f-4a5b-6c7d-8e9f0a1b2c3d',
'{
  "resourceType": "Location",
  "id": "8a9b0c1d-2e3f-4a5b-6c7d-8e9f0a1b2c3d",
  "status": "active",
  "name": "Consultorio Médico #75",
  "identifier": [{"value": "cdr-075"}],
  "address": {"line": ["Calle Céspedes #75"], "city": "Camagüey", "state": "Camagüey", "postalCode": "70100"},
  "partOf": {"reference": "Location/"}
}'::jsonb),

('9b0c1d2e-3f4a-5b6c-7d8e-9f0a1b2c3d4e',
'{
  "resourceType": "Location",
  "id": "9b0c1d2e-3f4a-5b6c-7d8e-9f0a1b2c3d4e",
  "status": "active",
  "name": "Hospital Pediátrico Pepe Portilla",
  "identifier": [{"value": "hosp-pepe-01"}],
  "address": {"line": ["Ave. Libertad #100"], "city": "Pinar del Río", "state": "Pinar del Río", "postalCode": "20100"},
  "partOf": {"reference": "Location/"}
}'::jsonb),

('0c1d2e3f-4a5b-6c7d-8e9f-0a1b2c3d4e5f',
'{
  "resourceType": "Location",
  "id": "0c1d2e3f-4a5b-6c7d-8e9f-0a1b2c3d4e5f",
  "status": "active",
  "name": "Sala de Pediatría H. Pepe Portilla",
  "identifier": [{"value": "ped-pepe-01"}],
  "address": {"line": ["Ave. Libertad #100"], "city": "Pinar del Río", "state": "Pinar del Río", "postalCode": "20100"},
  "partOf": {"reference": "Location/9b0c1d2e-3f4a-5b6c-7d8e-9f0a1b2c3d4e"}
}'::jsonb),

('1d2e3f4a-5b6c-7d8e-9f0a-1b2c3d4e5f6a',
'{
  "resourceType": "Location",
  "id": "1d2e3f4a-5b6c-7d8e-9f0a-1b2c3d4e5f6a",
  "status": "active",
  "name": "Consultorio Médico #85",
  "identifier": [{"value": "cdr-085"}],
  "address": {"line": ["Calle Martí #85"], "city": "Guantánamo", "state": "Guantánamo", "postalCode": "95100"},
  "partOf": {"reference": "Location/"}
}'::jsonb),

('2e3f4a5b-6c7d-8e9f-0a1b-2c3d4e5f6a7b',
'{
  "resourceType": "Location",
  "id": "2e3f4a5b-6c7d-8e9f-0a1b-2c3d4e5f6a7b",
  "status": "active",
  "name": "Policlínico Universitario Carlos J. Finlay",
  "identifier": [{"value": "pol-finlay-01"}],
  "address": {"line": ["Ave. Finlay #100"], "city": "Camagüey", "state": "Camagüey", "postalCode": "70100"},
  "partOf": {"reference": "Location/"}
}'::jsonb),

('3f4a5b6c-7d8e-9f0a-1b2c-3d4e5f6a7b8c',
'{
  "resourceType": "Location",
  "id": "3f4a5b6c-7d8e-9f0a-1b2c-3d4e5f6a7b8c",
  "status": "active",
  "name": "Sala de Observación Policlínico Finlay",
  "identifier": [{"value": "obs-finlay-01"}],
  "address": {"line": ["Ave. Finlay #100"], "city": "Camagüey", "state": "Camagüey", "postalCode": "70100"},
  "partOf": {"reference": "Location/2e3f4a5b-6c7d-8e9f-0a1b-2c3d4e5f6a7b"}
}'::jsonb),
('cdra1-0001-0001-0001-000000000001',
'{
  "resourceType": "Location",
  "id": "cdra1-0001-0001-0001-000000000001",
  "status": "active",
  "name": "CDR #1, Vedado",
  "identifier": [{"value": "cdr-vedado-1"}],
  "address": {"line": ["Calle 23 #101"], "city": "La Habana", "state": "La Habana", "postalCode": "10400"},
  "partOf": {"reference": "Location/cdra1-0000-0000-0000-000000000000"}
}'::jsonb),
('cdra1-0001-0001-0001-000000000002',
'{
  "resourceType": "Location",
  "id": "cdra1-0001-0001-0001-000000000002",
  "status": "active",
  "name": "CDR #2, Vedado",
  "identifier": [{"value": "cdr-vedado-2"}],
  "address": {"line": ["Calle 23 #103"], "city": "La Habana", "state": "La Habana", "postalCode": "10400"},
  "partOf": {"reference": "Location/cdra1-0000-0000-0000-000000000000"}
}'::jsonb),
('cdra1-0001-0001-0001-000000000003',
'{
  "resourceType": "Location",
  "id": "cdra1-0001-0001-0001-000000000003",
  "status": "active",
  "name": "CDR #3, Vedado",
  "identifier": [{"value": "cdr-vedado-3"}],
  "address": {"line": ["Calle 23 #105"], "city": "La Habana", "state": "La Habana", "postalCode": "10400"},
  "partOf": {"reference": "Location/cdra1-0000-0000-0000-000000000000"}
}'::jsonb),
('cdra1-0001-0001-0001-000000000004',
'{
  "resourceType": "Location",
  "id": "cdra1-0001-0001-0001-000000000004",
  "status": "active",
  "name": "CDR #4, Vedado",
  "identifier": [{"value": "cdr-vedado-4"}],
  "address": {"line": ["Calle 23 #107"], "city": "La Habana", "state": "La Habana", "postalCode": "10400"},
  "partOf": {"reference": "Location/cdra1-0000-0000-0000-000000000000"}
}'::jsonb),
('cdra2-0002-0002-0002-000000000001',
'{
  "resourceType": "Location",
  "id": "cdra2-0002-0002-0002-000000000001",
  "status": "active",
  "name": "CDR #5, Centro Habana",
  "identifier": [{"value": "cdr-centro-5"}],
  "address": {"line": ["Calle Neptuno #201"], "city": "La Habana", "state": "La Habana", "postalCode": "10200"},
  "partOf": {"reference": "Location/cdra2-0000-0000-0000-000000000000"}
}'::jsonb),
('cdra2-0002-0002-0002-000000000002',
'{
  "resourceType": "Location",
  "id": "cdra2-0002-0002-0002-000000000002",
  "status": "active",
  "name": "CDR #6, Centro Habana",
  "identifier": [{"value": "cdr-centro-6"}],
  "address": {"line": ["Calle Neptuno #203"], "city": "La Habana", "state": "La Habana", "postalCode": "10200"},
  "partOf": {"reference": "Location/cdra2-0000-0000-0000-000000000000"}
}'::jsonb),
('cdra2-0002-0002-0002-000000000003',
'{
  "resourceType": "Location",
  "id": "cdra2-0002-0002-0002-000000000003",
  "status": "active",
  "name": "CDR #7, Centro Habana",
  "identifier": [{"value": "cdr-centro-7"}],
  "address": {"line": ["Calle Neptuno #205"], "city": "La Habana", "state": "La Habana", "postalCode": "10200"},
  "partOf": {"reference": "Location/cdra2-0000-0000-0000-000000000000"}
}'::jsonb),
('cdra2-0002-0002-0002-000000000004',
'{
  "resourceType": "Location",
  "id": "cdra2-0002-0002-0002-000000000004",
  "status": "active",
  "name": "CDR #8, Centro Habana",
  "identifier": [{"value": "cdr-centro-8"}],
  "address": {"line": ["Calle Neptuno #207"], "city": "La Habana", "state": "La Habana", "postalCode": "10200"},
  "partOf": {"reference": "Location/cdra2-0000-0000-0000-000000000000"}
}'::jsonb),
('cdra3-0003-0003-0003-000000000001',
'{
  "resourceType": "Location",
  "id": "cdra3-0003-0003-0003-000000000001",
  "status": "active",
  "name": "CDR #9, Santa Clara",
  "identifier": [{"value": "cdr-stclara-9"}],
  "address": {"line": ["Calle Maceo #301"], "city": "Santa Clara", "state": "Villa Clara", "postalCode": "50100"},
  "partOf": {"reference": "Location/cdra3-0000-0000-0000-000000000000"}
}'::jsonb),
('cdra3-0003-0003-0003-000000000002',
'{
  "resourceType": "Location",
  "id": "cdra3-0003-0003-0003-000000000002",
  "status": "active",
  "name": "CDR #10, Santa Clara",
  "identifier": [{"value": "cdr-stclara-10"}],
  "address": {"line": ["Calle Maceo #303"], "city": "Santa Clara", "state": "Villa Clara", "postalCode": "50100"},
  "partOf": {"reference": "Location/cdra3-0000-0000-0000-000000000000"}
}'::jsonb),
('cdra3-0003-0003-0003-000000000003',
'{
  "resourceType": "Location",
  "id": "cdra3-0003-0003-0003-000000000003",
  "status": "active",
  "name": "CDR #11, Santa Clara",
  "identifier": [{"value": "cdr-stclara-11"}],
  "address": {"line": ["Calle Maceo #305"], "city": "Santa Clara", "state": "Villa Clara", "postalCode": "50100"},
  "partOf": {"reference": "Location/cdra3-0000-0000-0000-000000000000"}
}'::jsonb),
('cdra3-0003-0003-0003-000000000004',
'{
  "resourceType": "Location",
  "id": "cdra3-0003-0003-0003-000000000004",
  "status": "active",
  "name": "CDR #12, Santa Clara",
  "identifier": [{"value": "cdr-stclara-12"}],
  "address": {"line": ["Calle Maceo #307"], "city": "Santa Clara", "state": "Villa Clara", "postalCode": "50100"},
  "partOf": {"reference": "Location/cdra3-0000-0000-0000-000000000000"}
}'::jsonb),
('cdra4-0004-0004-0004-000000000001',
'{
  "resourceType": "Location",
  "id": "cdra4-0004-0004-0004-000000000001",
  "status": "active",
  "name": "CDR #13, Camagüey",
  "identifier": [{"value": "cdr-camaguey-13"}],
  "address": {"line": ["Calle República #401"], "city": "Camagüey", "state": "Camagüey", "postalCode": "70100"},
  "partOf": {"reference": "Location/cdra4-0000-0000-0000-000000000000"}
}'::jsonb),
('cdra4-0004-0004-0004-000000000002',
'{
  "resourceType": "Location",
  "id": "cdra4-0004-0004-0004-000000000002",
  "status": "active",
  "name": "CDR #14, Camagüey",
  "identifier": [{"value": "cdr-camaguey-14"}],
  "address": {"line": ["Calle República #403"], "city": "Camagüey", "state": "Camagüey", "postalCode": "70100"},
  "partOf": {"reference": "Location/cdra4-0000-0000-0000-000000000000"}
}'::jsonb),
('cdra4-0004-0004-0004-000000000003',
'{
  "resourceType": "Location",
  "id": "cdra4-0004-0004-0004-000000000003",
  "status": "active",
  "name": "CDR #15, Camagüey",
  "identifier": [{"value": "cdr-camaguey-15"}],
  "address": {"line": ["Calle República #405"], "city": "Camagüey", "state": "Camagüey", "postalCode": "70100"},
  "partOf": {"reference": "Location/cdra4-0000-0000-0000-000000000000"}
}'::jsonb),
('cdra4-0004-0004-0004-000000000004',
'{
  "resourceType": "Location",
  "id": "cdra4-0004-0004-0004-000000000004",
  "status": "active",
  "name": "CDR #16, Camagüey",
  "identifier": [{"value": "cdr-camaguey-16"}],
  "address": {"line": ["Calle República #407"], "city": "Camagüey", "state": "Camagüey", "postalCode": "70100"},
  "partOf": {"reference": "Location/cdra4-0000-0000-0000-000000000000"}
}'::jsonb),
('cdra5-0005-0005-0005-000000000001',
'{
  "resourceType": "Location",
  "id": "cdra5-0005-0005-0005-000000000001",
  "status": "active",
  "name": "CDR #17, Holguín",
  "identifier": [{"value": "cdr-holguin-17"}],
  "address": {"line": ["Calle Libertad #501"], "city": "Holguín", "state": "Holguín", "postalCode": "80100"},
  "partOf": {"reference": "Location/cdra5-0000-0000-0000-000000000000"}
}'::jsonb),
('cdra5-0005-0005-0005-000000000002',
'{
  "resourceType": "Location",
  "id": "cdra5-0005-0005-0005-000000000002",
  "status": "active",
  "name": "CDR #18, Holguín",
  "identifier": [{"value": "cdr-holguin-18"}],
  "address": {"line": ["Calle Libertad #503"], "city": "Holguín", "state": "Holguín", "postalCode": "80100"},
  "partOf": {"reference": "Location/cdra5-0000-0000-0000-000000000000"}
}'::jsonb),
('cdra5-0005-0005-0005-000000000003',
'{
  "resourceType": "Location",
  "id": "cdra5-0005-0005-0005-000000000003",
  "status": "active",
  "name": "CDR #19, Holguín",
  "identifier": [{"value": "cdr-holguin-19"}],
  "address": {"line": ["Calle Libertad #505"], "city": "Holguín", "state": "Holguín", "postalCode": "80100"},
  "partOf": {"reference": "Location/cdra5-0000-0000-0000-000000000000"}
}'::jsonb),
('cdra5-0005-0005-0005-000000000004',
'{
  "resourceType": "Location",
  "id": "cdra5-0005-0005-0005-000000000004",
  "status": "active",
  "name": "CDR #20, Holguín",
  "identifier": [{"value": "cdr-holguin-20"}],
  "address": {"line": ["Calle Libertad #507"], "city": "Holguín", "state": "Holguín", "postalCode": "80100"},
  "partOf": {"reference": "Location/cdra5-0000-0000-0000-000000000000"}
}'::jsonb);

Rol: Eres un experto en generacion de datos sinteticos de los recursos del estandard FHIR
Contexto:
Analiza la estructura de estos datos:

Luego siguendola al pie de la letra genera nuevos
datos en el contexto cubano
con datos reales variando los tipos en dependencia de la informacion de cada recurso.

Te dare uno de los datos de cada recurso para que entiendas la relacion que existen
entre los recursos FHIR de mi sistema. Teniendo eso en cuenta quiero que generes 5
ejemplos mas de los recursos:
-Conditions,
-RelatedPerson,
-Observation

Instrucciones especificas:
1-Los id debe ser en formato UUID
2-Los ejemplos deben ser de contexto cubano, sobre enfermedades del mismo contexto, etc.
3-Ante cualquier duda pregunta antes de comenzar con la tarea.
4-Te dare los IDS de los datos generados por recurso para que los nuevos datos se relacionen
con los otros recursos ya existentes en mi app:
