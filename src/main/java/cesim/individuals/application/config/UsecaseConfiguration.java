package cesim.individuals.application.config;

import cesim.individuals.domain.usecases.report.*;
import cesim.individuals.domain.usecases.report.dependencies.*;
import cesim.individuals.domain.usecases.specimen.GetSpecimensUseCase;
import cesim.individuals.domain.usecases.specimen.dependencies.GetSpecimensService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cesim.individuals.domain.usecases.patient.CreatePatientUsecase;
import cesim.individuals.domain.usecases.patient.DeletePatientUsecase;
import cesim.individuals.domain.usecases.patient.GetPatientByIdUsecase;
import cesim.individuals.domain.usecases.patient.SearchPatientUsecase;
import cesim.individuals.domain.usecases.patient.UpdatePatientUsecase;
import cesim.individuals.domain.usecases.patient.dependencies.DeletePatientService;
import cesim.individuals.domain.usecases.patient.dependencies.GetPatientByIdService;
import cesim.individuals.domain.usecases.patient.dependencies.SearchPatientService;
import cesim.individuals.domain.usecases.patient.dependencies.UpdatePatientService;
import cesim.individuals.domain.usecases.patient.dependencies.CreatePatientService;
import cesim.individuals.domain.usecases.person.CreatePersonUsecase;
import cesim.individuals.domain.usecases.person.DeletePersonUsecase;
import cesim.individuals.domain.usecases.person.GetPersonByIdUsecase;
import cesim.individuals.domain.usecases.person.SearchPersonUsecase;
import cesim.individuals.domain.usecases.person.UpdatePersonUsecase;
import cesim.individuals.domain.usecases.person.dependencies.CreatePersonService;
import cesim.individuals.domain.usecases.person.dependencies.DeletePersonService;
import cesim.individuals.domain.usecases.person.dependencies.GetPersonByIdService;
import cesim.individuals.domain.usecases.person.dependencies.SearchPersonService;
import cesim.individuals.domain.usecases.person.dependencies.UpdatePersonService;
import cesim.individuals.domain.usecases.practitioner.CreatePractitionerUsecase;
import cesim.individuals.domain.usecases.practitioner.DeletePractitionerUsecase;
import cesim.individuals.domain.usecases.practitioner.GetPractitionerByIdUsecase;
import cesim.individuals.domain.usecases.practitioner.SearchPractitionerUsecase;
import cesim.individuals.domain.usecases.practitioner.UpdatePractitionerUsecase;
import cesim.individuals.domain.usecases.practitioner.dependencies.CreatePractitionerService;
import cesim.individuals.domain.usecases.practitioner.dependencies.DeletePractitionerService;
import cesim.individuals.domain.usecases.practitioner.dependencies.GetPractitionerByIdService;
import cesim.individuals.domain.usecases.practitioner.dependencies.SearchPractitionerService;
import cesim.individuals.domain.usecases.practitioner.dependencies.UpdatePractitionerService;
import cesim.individuals.domain.usecases.relatedPerson.CreateRelatedPersonUsecase;
import cesim.individuals.domain.usecases.relatedPerson.DeleteRelatedPersonUsecase;
import cesim.individuals.domain.usecases.relatedPerson.GetRelatedPersonByIdUsecase;
import cesim.individuals.domain.usecases.relatedPerson.SearchRelatedPersonUsecase;
import cesim.individuals.domain.usecases.relatedPerson.UpdateRelatedPersonUsecase;
import cesim.individuals.domain.usecases.relatedPerson.dependencies.CreateRelatedPersonService;
import cesim.individuals.domain.usecases.relatedPerson.dependencies.DeleteRelatedPersonService;
import cesim.individuals.domain.usecases.relatedPerson.dependencies.GetRelatedPersonByIdService;
import cesim.individuals.domain.usecases.relatedPerson.dependencies.SearchRelatedPersonService;
import cesim.individuals.domain.usecases.relatedPerson.dependencies.UpdateRelatedPersonService;


@Configuration
class UsecaseConfiguration {

  // Person Usecases
  @Bean
  SearchPersonUsecase searchPersonUsecase(
          SearchPersonService searchPersonService) {
    return new SearchPersonUsecase(searchPersonService);
  }

  @Bean
  CreatePersonUsecase createPersonUsecase(CreatePersonService createPersonService) {
    return new CreatePersonUsecase(createPersonService);
  }

  @Bean
  UpdatePersonUsecase updatePersonUsecase(UpdatePersonService updatePersonService) {
    return new UpdatePersonUsecase(updatePersonService);
  }

  @Bean
  GetPersonByIdUsecase getPersonByIdUsecase(GetPersonByIdService getPersonByIdService) {
    return new GetPersonByIdUsecase(getPersonByIdService);
  }

  @Bean
  DeletePersonUsecase deletePersonUsecase(DeletePersonService deletePersonService) {
    return new DeletePersonUsecase(deletePersonService);
  }

  // Practitioner Usecases
  @Bean
  SearchPractitionerUsecase searchPractitionerUsecase(SearchPractitionerService searchPractitionerService) {
    return new SearchPractitionerUsecase(searchPractitionerService);
  }

  @Bean
  CreatePractitionerUsecase createPractitionerUsecase(CreatePractitionerService createPractitionerService) {
    return new CreatePractitionerUsecase(createPractitionerService);
  }

  @Bean
  UpdatePractitionerUsecase updatePractitionerUsecase(UpdatePractitionerService updatePractitionerService) {
    return new UpdatePractitionerUsecase(updatePractitionerService);
  }

  @Bean
  GetPractitionerByIdUsecase getPractitionerByIdUsecase(GetPractitionerByIdService getPractitionerByIdService) {
    return new GetPractitionerByIdUsecase(getPractitionerByIdService);
  }

  @Bean
  DeletePractitionerUsecase deletePractitionerUsecase(DeletePractitionerService deletePractitionerService) {
    return new DeletePractitionerUsecase(deletePractitionerService);
  }

  // Patient Usecases
  @Bean
  SearchPatientUsecase searchPatientUsecase(SearchPatientService searchPatientService) {
    return new SearchPatientUsecase(searchPatientService);
  }

  @Bean
  CreatePatientUsecase createPatientUsecase(CreatePatientService createPatientService) {
    return new CreatePatientUsecase(createPatientService);
  }

  @Bean
  UpdatePatientUsecase updatePatientUsecase(UpdatePatientService updatePatientService) {
    return new UpdatePatientUsecase(updatePatientService);
  }

  @Bean
  GetPatientByIdUsecase getPatientByIdUsecase(GetPatientByIdService getPatientByIdService) {
    return new GetPatientByIdUsecase(getPatientByIdService);
  }

  @Bean
  DeletePatientUsecase deletePatientUsecase(DeletePatientService deletePatientService) {
    return new DeletePatientUsecase(deletePatientService);
  }

  // RelatedPerson Usecases
  @Bean
  SearchRelatedPersonUsecase searchRelatedPersonUsecase(SearchRelatedPersonService searchRelatedPersonService) {
    return new SearchRelatedPersonUsecase(searchRelatedPersonService);
  }

  @Bean
  CreateRelatedPersonUsecase createRelatedPersonUsecase(CreateRelatedPersonService createRelatedPersonService) {
    return new CreateRelatedPersonUsecase(createRelatedPersonService);
  }

  @Bean
  UpdateRelatedPersonUsecase updateRelatedPersonUsecase(UpdateRelatedPersonService updateRelatedPersonService) {
    return new UpdateRelatedPersonUsecase(updateRelatedPersonService);
  }

  @Bean
  GetRelatedPersonByIdUsecase getRelatedPersonByIdUsecase(GetRelatedPersonByIdService getRelatedPersonByIdService) {
    return new GetRelatedPersonByIdUsecase(getRelatedPersonByIdService);
  }

  @Bean
  DeleteRelatedPersonUsecase deleteRelatedPersonUsecase(DeleteRelatedPersonService deleteRelatedPersonService) {
    return new DeleteRelatedPersonUsecase(deleteRelatedPersonService);
  }

  // Vigilance Primary Healthcare Attention
  //  RF02 - Urgency Patient Data
  @Bean
  GetCriticalPatientDataUseCase getCriticalPatientDataUseCase(
          GetCriticalPatientDataService criticalPatientDataService
  ) {
    return new GetCriticalPatientDataUseCase(criticalPatientDataService);
  }

  //  RF03 - Report Filter
  @Bean
  ClinicalReportFilterUseCase reportFilterUseCase(
          ClinicalReportFilterService filterService
  ) {
    return new ClinicalReportFilterUseCase(filterService);
  }

  //  RF04 - Derivation Reports
  @Bean
  GenerateDerivationReportUsecase generateDerivationReportUsecase(
          GenerateDerivationReportService generateDerivationReportService
  ) {
    return new GenerateDerivationReportUsecase(generateDerivationReportService);
  }

  //  RF05 - Advanced Patients Seach
  @Bean
  AdvancedSearchUseCase advancedSearchUseCase(
          AdvancedSearchService searchService
  ) {
    return new AdvancedSearchUseCase(searchService);
  }

  //  RF06 - Recent Encounters
  @Bean
  GetRecentEncountersUseCase getRecentEncountersUseCase(
          GetRecentEncounterService recentEncounterService
  ) {
    return new GetRecentEncountersUseCase(recentEncounterService);
  }

  //  RF07 - Patient Risk Priority List
  @Bean
  AssessPatientsRiskUseCase assessPatientsRiskUsecase(
          PatientRiskAssessmentService riskService
  ) {
    return new AssessPatientsRiskUseCase(riskService);
  }

  // Specimens UseCase
  //  RF08 - Get Specimens
  @Bean
  GetSpecimensUseCase getSpecimensUseCase(GetSpecimensService specimensService) {
    return new GetSpecimensUseCase(specimensService);
  }

  //  RF09 - Care Plan Notifications Closure
  @Bean
  GenerateCarePlanNotificationsUseCase generateCarePlanNotificationsUseCase(
          CarePlanNotificationsService planNotificationsService
  ) {
    return new GenerateCarePlanNotificationsUseCase(planNotificationsService);
  }

  //  RF10 - Statistic Report Generation
  @Bean
  public GenerateStatisticsReportUseCase generateStatisticsReportUsecase(
          StatisticsReportService reportService
  ) {
    return new GenerateStatisticsReportUseCase(reportService);
  }
}
