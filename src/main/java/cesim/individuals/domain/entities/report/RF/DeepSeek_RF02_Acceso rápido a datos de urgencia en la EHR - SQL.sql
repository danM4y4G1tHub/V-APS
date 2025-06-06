-- Obtener datos críticos de un paciente por CI
SELECT p.resource AS paciente, 
       a.resource->'code' AS alergias,
       m.resource->'medicationCodeableConcept' AS medicamentos,
       c.resource->'code' AS diagnosticos
FROM patients p
LEFT JOIN allergy_intolerances a 
  ON a.resource->'subject'->>'reference' = 'Patient/' || p.id
LEFT JOIN medication_requests m 
  ON m.resource->'subject'->>'reference' = 'Patient/' || p.id
LEFT JOIN conditions c 
  ON c.resource->'subject'->>'reference' = 'Patient/' || p.id
WHERE p.resource->'identifier'->0->>'value' = '5.678.901-2';