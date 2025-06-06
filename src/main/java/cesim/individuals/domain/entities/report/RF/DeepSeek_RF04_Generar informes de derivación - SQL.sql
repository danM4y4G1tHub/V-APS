SELECT jsonb_build_object(
  'paciente', p.resource->'name',
  'diagnostico', c.resource->'code',
  'tratamiento', m.resource->'dosageInstruction',
  'alergias', a.resource->'code'
) AS informe
FROM patients p
LEFT JOIN conditions c 
  ON c.resource->'subject'->>'reference' = 'Patient/' || p.id
LEFT JOIN medication_requests m 
  ON m.resource->'subject'->>'reference' = 'Patient/' || p.id
LEFT JOIN allergy_intolerances a 
  ON a.resource->'patient'->>'reference' = 'Patient/' || p.id
WHERE p.id = 'd58d8a9d-6c75-414c-8e7d-123456789abc';