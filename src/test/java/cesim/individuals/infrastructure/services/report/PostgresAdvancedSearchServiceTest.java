package cesim.individuals.infrastructure.services.report;

import cesim.individuals.domain.entities.*;
import cesim.individuals.domain.entities.report.specInput.AdvancedSearchRequestSpec;
import cesim.individuals.domain.entities.report.outputDTO.AdvancedSearchResultsDTO;
import cesim.individuals.domain.utils.Pageable;
import cesim.individuals.infrastructure.repository.ConditionRepository;
import cesim.individuals.infrastructure.repository.PatientRepository;
import cesim.individuals.infrastructure.repository.models.PatientModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostgresAdvancedSearchServiceTest {

  @Mock
  private PatientRepository patientRepository;
  @Mock
  private ConditionRepository conditionRepository;

  @InjectMocks
  private PostgresAdvancedSearchService service;

  @Captor
  private ArgumentCaptor<Specification<PatientModel>> specCaptor;

  private final Pageable pageable = new Pageable(0, 10, "birthDate", "asc");
  private final LocalDate today = LocalDate.now();
  private final LocalDate pastDate = today.minusYears(1);
  private final LocalDate futureDate = today.plusYears(1);

  private PatientModel createMockPatient(String id, String ci, String familyName, String givenName, LocalDate birthDate,
                                         Patient.Gender gender) {
    PatientModel patientModel = new PatientModel();
    patientModel.setId((id));

    Patient patient = new Patient(
            id, List.of(new Identifier(null, null, "http://minsap.cu/ci", ci, null, null)),
            true, List.of(new HumanName(HumanName.Use.OFFICIAL,null, familyName, List.of(givenName),
            null, null, null)), null, gender, birthDate, null, null,
            null, null
    );

    patientModel.setResource(patient);
    return patientModel;
  }

  private void mockRepositoryResponse(List<PatientModel> patients) {
    Page<PatientModel> page = new PageImpl<>(patients);
    when(patientRepository.findAll(
            any(Specification.class),
            any(PageRequest.class))
    ).thenReturn(page);
  }

  @Test
  void searchByIdentification_ValidCI_ShouldReturnPatient() {
    PatientModel patientModel = createMockPatient(
            "bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a",
            "92020254321",
            "Rodríguez",
            "María Elena",
            LocalDate.of(1992, 2, 2),
            Patient.Gender.FEMALE
    );

    AdvancedSearchRequestSpec spec = new AdvancedSearchRequestSpec(
            null, "92020254321", null, null, null
    );

    mockRepositoryResponse(Collections.singletonList(patientModel));
    AdvancedSearchResultsDTO result = service.searchPatients(pageable, spec);

    assertEquals(1, result.patientPage().items().size());
    Patient patient = result.patientPage().items().get(0);
    assertEquals("92020254321", patient.identifier().get(0).value());
    assertEquals("Rodríguez", patient.name().get(0).family());
    assertEquals("María Elena", patient.name().get(0).given().get(0));
    assertEquals("female", patient.gender().getValue());
  }

  @Test
  void searchByName_ShouldMatchFamilyAndGivenNames() {
    PatientModel patient1 = createMockPatient(
            "bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a",
            "92020254321",
            "Rodríguez",
            "María Elena",
            LocalDate.of(1992, 2, 2),
            Patient.Gender.FEMALE
    );

    PatientModel patient2 = createMockPatient(
            "c1d2e3f4-5678-90ab-cdef-1234567890ab",
            "83010112345",
            "Pérez",
            "Luis Alberto",
            LocalDate.of(1983, 1, 1),
            Patient.Gender.MALE
    );

    AdvancedSearchRequestSpec spec = new AdvancedSearchRequestSpec(
            "Rodríguez", null, null, null, null
    );

    mockRepositoryResponse(Collections.singletonList(patient1));
    AdvancedSearchResultsDTO result = service.searchPatients(pageable, spec);

    assertEquals(1, result.patientPage().items().size());
    assertEquals("Rodríguez", result.patientPage().items().get(0).name().get(0).family());
  }

  @Test
  void searchByDateRange_ShouldFilterByBirthDate() {
    PatientModel patient1 = createMockPatient(
            "bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a",
            "92020254321",
            "Rodríguez",
            "María Elena",
            LocalDate.of(1992, 2, 2),
            Patient.Gender.FEMALE
    );

    PatientModel patient2 = createMockPatient(
            "d5e6f7a8-1234-4567-89ab-cdef12345678",
            "71050567891",
            "González",
            "Ana Lucía",
            LocalDate.of(1971, 5, 5),
            Patient.Gender.FEMALE
    );

    AdvancedSearchRequestSpec spec = new AdvancedSearchRequestSpec(
            null, null, null,
            LocalDate.of(1980, 1, 1),
            LocalDate.of(2000, 12, 31)
    );

    mockRepositoryResponse(List.of(patient1));
    AdvancedSearchResultsDTO result = service.searchPatients(pageable, spec);

    assertEquals(1, result.patientPage().items().size());
    assertEquals("Rodríguez", result.patientPage().items().get(0).name().get(0).family());
  }

  @Test
  void emptySearch_ShouldReturnAllPatients() {
    PatientModel patient1 =
            createMockPatient(
            "bce2628f-12e5-4e3f-9a35-7a8e9b8d6f7a",
            "92020254321",
            "Rodríguez",
            "María Elena",
            LocalDate.of(1992, 2, 2),
            Patient.Gender.FEMALE
    );

    PatientModel patient2 = createMockPatient(
            "c1d2e3f4-5678-90ab-cdef-1234567890ab",
            "83010112345",
            "Pérez",
            "Luis Alberto",
            LocalDate.of(1983, 1, 1),
            Patient.Gender.MALE
    );

    PatientModel patient3 = createMockPatient(
            "d5e6f7a8-1234-4567-89ab-cdef12345678",
            "71050567891",
            "González",
            "Ana Lucía",
            LocalDate.of(1971, 5, 5),
            Patient.Gender.FEMALE
    );

    AdvancedSearchRequestSpec spec = new AdvancedSearchRequestSpec(
            null, null, null, null, null
    );

    mockRepositoryResponse(List.of(patient1, patient2, patient3));
    AdvancedSearchResultsDTO result = service.searchPatients(pageable, spec);

    assertEquals(3, result.patientPage().items().size());
  }

  @Test
  void pagination_ShouldReturnCorrectPage() {
    List<PatientModel> patients = new ArrayList<>();
    for (int i = 0; i < 15; i++) {
      patients.add(createMockPatient(
              UUID.randomUUID().toString(),
              String.format("%011d", i),
              "Family" + i,
              "Given" + i,
              LocalDate.now().minusYears(20 + i),
              i % 2 == 0 ? Patient.Gender.MALE : Patient.Gender.FEMALE
      ));
    }

    Pageable customPageable = new Pageable(1, 5, "birthDate", "asc");

    Page<PatientModel> page = new PageImpl<>(
            patients.subList(5, 10),
            PageRequest.of(1, 5),
            15
    );
    when(patientRepository.findAll(any(Specification.class), any(PageRequest.class)))
            .thenReturn(page);

    AdvancedSearchResultsDTO result = service.searchPatients(
            customPageable,
            new AdvancedSearchRequestSpec(null, null, null, null, null)
    );

    assertEquals(5, result.patientPage().items().size());
    assertEquals(1, result.patientPage().pageNumber());
    assertEquals(5, result.patientPage().pageSize());
    assertEquals(3, result.patientPage().totalPages());
    assertTrue(result.patientPage().hasNext());
    assertTrue(result.patientPage().hasPrevious());
  }

  @Test
  void sorting_ShouldOrderResults() {
    PatientModel patient1 = createMockPatient(
            "1", "11111111111", "A", "A", LocalDate.of(2000, 1, 1),
            Patient.Gender.MALE
    );
    PatientModel patient2 = createMockPatient(
            "2", "22222222222", "B", "B", LocalDate.of(1990, 1, 1),
            Patient.Gender.FEMALE
    );
    PatientModel patient3 = createMockPatient(
            "3", "33333333333", "C", "C", LocalDate.of(2010, 1, 1),
            Patient.Gender.MALE
    );

    Pageable ascPageable = new Pageable(0, 10, "birthDate", "asc");
    mockRepositoryResponse(List.of(patient2, patient1, patient3));

    AdvancedSearchResultsDTO result = service.searchPatients(
            ascPageable,
            new AdvancedSearchRequestSpec(null, null, null, null, null)
    );

    List<Patient> items = result.patientPage().items();
    assertEquals(LocalDate.of(1990, 1, 1), items.get(0).birthDate());
    assertEquals(LocalDate.of(2000, 1, 1), items.get(1).birthDate());
    assertEquals(LocalDate.of(2010, 1, 1), items.get(2).birthDate());

    Pageable descPageable = new Pageable(0, 10, "birthDate", "desc");
    mockRepositoryResponse(List.of(patient3, patient1, patient2));

    result = service.searchPatients(
            descPageable,
            new AdvancedSearchRequestSpec(null, null, null, null, null)
    );

    items = result.patientPage().items();
    assertEquals(LocalDate.of(2010, 1, 1), items.get(0).birthDate());
    assertEquals(LocalDate.of(2000, 1, 1), items.get(1).birthDate());
    assertEquals(LocalDate.of(1990, 1, 1), items.get(2).birthDate());
  }

  @Test
  void searchByNameWithSpecialCharacters_ShouldReturnPatients() {
    PatientModel patient1 = createMockPatient(String.valueOf(UUID.randomUUID()), "11111111111",
            "García-Márquez", "Gabriel", LocalDate.of(1927, 3, 6),
            Patient.Gender.MALE
    );
    PatientModel patient2 = createMockPatient(
            "2", "22222222222", "Ñañez", "Juán", LocalDate.of(1985, 7, 15),
            Patient.Gender.MALE
    );
    PatientModel patient3 = createMockPatient(
            "3", "33333333333", "O'Connor", "Sarah", LocalDate.of(1995, 11, 22),
            Patient.Gender.FEMALE
    );

    AdvancedSearchRequestSpec spec1 = new AdvancedSearchRequestSpec(
            "García-Márquez", null, null, null, null
    );
    mockRepositoryResponse(List.of(patient1));
    AdvancedSearchResultsDTO result = service.searchPatients(pageable, spec1);
    assertEquals(1, result.patientPage().items().size());

    AdvancedSearchRequestSpec spec2 = new AdvancedSearchRequestSpec(
            "Ñañez", null, null, null, null
    );
    mockRepositoryResponse(List.of(patient2));
    result = service.searchPatients(pageable, spec2);
    assertEquals(1, result.patientPage().items().size());

    AdvancedSearchRequestSpec spec3 = new AdvancedSearchRequestSpec(
            "O'Connor", null, null, null, null
    );
    mockRepositoryResponse(List.of(patient3));
    result = service.searchPatients(pageable, spec3);
    assertEquals(1, result.patientPage().items().size());
  }

  @Test
  void searchByIdentificationWithFormattedCI_ShouldReturnPatients() {
    PatientModel patient = createMockPatient(String.valueOf(UUID.randomUUID()), "92020254321", "Rodríguez",
            "María", LocalDate.of(1992, 2, 2), Patient.Gender.FEMALE
    );

    String[] validFormats = {
            "92020254321",
            "92.020.254-321",
            "92-020-254-321",
            "92020 254321"
    };

    for (String ci : validFormats) {
      AdvancedSearchRequestSpec spec = new AdvancedSearchRequestSpec(
              null, ci, null, null, null
      );
      mockRepositoryResponse(List.of(patient));
      AdvancedSearchResultsDTO result = service.searchPatients(pageable, spec);
      assertEquals(1, result.patientPage().items().size(),
              "Failed for CI format: " + ci);
    }
  }

  @Test
  void searchForPatientWithMissingData_ShouldNotFail() {
    // Paciente sin nombre
    PatientModel namelessPatient = new PatientModel();
    namelessPatient.setId(String.valueOf(UUID.randomUUID()));
    namelessPatient.setResource(new Patient(
            "1", List.of(new Identifier(null, null,"http://minsap.cu/ci", "92020254321",
            null, null)),true, null, null, null,
            LocalDate.of(1992, 2, 2), null,null,null, null
    ));

    PatientModel birthdatelessPatient = new PatientModel();
    birthdatelessPatient.setId(String.valueOf(UUID.randomUUID()));
    birthdatelessPatient.setResource(new Patient(
            "2", List.of(new Identifier(null, null, "http://minsap.cu/ci", "83010112345",
            null, null)), true, List.of(new HumanName(HumanName.Use.OFFICIAL,null, "Pérez",
            List.of("Luis"),null, null, null)), null, Patient.Gender.MALE,null,
            null,null,null,null)
    );

    AdvancedSearchRequestSpec nameSpec = new AdvancedSearchRequestSpec(
            "Pérez", null, null, null, null
    );
    mockRepositoryResponse(List.of(birthdatelessPatient));
    assertDoesNotThrow(() -> service.searchPatients(pageable, nameSpec));

    AdvancedSearchRequestSpec dateSpec = new AdvancedSearchRequestSpec(
            null, null, null, LocalDate.MIN, LocalDate.MAX
    );
    mockRepositoryResponse(Collections.emptyList());
    AdvancedSearchResultsDTO result = service.searchPatients(pageable, dateSpec);
    assertTrue(result.patientPage().items().isEmpty());
  }

  @Test
  void searchWithMultipleFilters_ShouldApplyAllConditions() {
    // Crear pacientes
    PatientModel matchingPatient = createMockPatient(
            "1", "92020254321", "Rodríguez", "María",
            LocalDate.of(1992, 2, 2), Patient.Gender.FEMALE
    );

    PatientModel nonMatchingPatient1 = createMockPatient(
            "2", "83010112345", "Pérez", "Luis",
            LocalDate.of(1983, 1, 1), Patient.Gender.MALE
    );

    PatientModel nonMatchingPatient2 = createMockPatient(
            "3", "71050567891", "Rodríguez", "Carlos",
            LocalDate.of(1971, 5, 5), Patient.Gender.MALE
    );

    AdvancedSearchRequestSpec spec = new AdvancedSearchRequestSpec(
            "Rodríguez",
            null,
            null,
            LocalDate.of(1990, 1, 1),
            LocalDate.of(2000, 12, 31)
    );

    mockRepositoryResponse(List.of(matchingPatient));
    AdvancedSearchResultsDTO result = service.searchPatients(pageable, spec);

    assertEquals(1, result.patientPage().items().size());
    Patient patient = result.patientPage().items().get(0);
    assertEquals("92020254321", patient.identifier().get(0).value());
    assertEquals("Rodríguez", patient.name().get(0).family());
  }

@Test
  void searchWithBoundaryDates_ShouldIncludeBoundaries() {
    PatientModel patient1 = createMockPatient(String.valueOf(UUID.randomUUID()), "92020254321", "A",
            "A", LocalDate.of(1992, 2, 2), Patient.Gender.FEMALE
    );
    PatientModel patient2 = createMockPatient(String.valueOf(UUID.randomUUID()), "83010112345", "B",
            "B", LocalDate.of(1983, 1, 1), Patient.Gender.MALE
    );
    PatientModel patient3 = createMockPatient(String.valueOf(UUID.randomUUID()), "71050567891", "C",
            "C", LocalDate.of(1971, 5, 5), Patient.Gender.MALE
    );

    AdvancedSearchRequestSpec spec = new AdvancedSearchRequestSpec(
            null, null, null,
            LocalDate.of(1983, 1, 1),
            LocalDate.of(1992, 2, 2)
    );

    mockRepositoryResponse(List.of(patient1, patient2));
    AdvancedSearchResultsDTO result = service.searchPatients(pageable, spec);

    assertEquals(2, result.patientPage().items().size());
    assertTrue(result.patientPage().items().stream()
            .anyMatch(p -> p.identifier().get(0).value().equals("92020254321")));
    assertTrue(result.patientPage().items().stream()
            .anyMatch(p -> p.identifier().get(0).value().equals("83010112345")));
  }
}
