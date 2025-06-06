-- POST /api/diagnostic-reports
INSERT INTO diagnostic_reports (resource)
VALUES ('{"resourceType":"DiagnosticReport", ... }'::jsonb)
RETURNING id;

-- GET /api/specimens
SELECT * FROM specimens 
WHERE resource->'collection'->>'collectedDateTime' > '2024-05-01';