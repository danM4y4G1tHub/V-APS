package cesim.individuals.application.config;

import cesim.individuals.domain.usecases.patient.*;
import cesim.individuals.domain.usecases.patient.dependencies.*;
import cesim.individuals.domain.usecases.person.*;
import cesim.individuals.domain.usecases.person.dependencies.*;
import cesim.individuals.domain.usecases.practitioner.*;
import cesim.individuals.domain.usecases.practitioner.dependencies.*;
import cesim.individuals.domain.usecases.relatedPerson.*;
import cesim.individuals.domain.usecases.relatedPerson.dependencies.*;
import cesim.individuals.domain.usecases.report.*;
import cesim.individuals.domain.usecases.report.dependencies.*;
import cesim.individuals.domain.usecases.specimen.GetSpecimensUseCase;
import cesim.individuals.domain.usecases.specimen.dependencies.GetSpecimensService;
import cesim.individuals.domain.usecases.vacinne.GenerateVaccineReportUseCase;
import cesim.individuals.domain.usecases.vacinne.depenencies.VaccineManagementService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


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

  // Vigilance Primary Healthcare Attention UseCases
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

  //  RF05 - Advanced Patients Search
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

  //  RF11 - Generate Vaccine Report
  @Bean
  public GenerateVaccineReportUseCase generateVaccineReportUseCase(
          VaccineManagementService managementService
  ){
    return new GenerateVaccineReportUseCase(managementService);
  }

  // RF12 - Community reports Community-CDR
  @Bean
  public GenerateCommunityReportUseCase generateCommunityReportUseCase(
          CommunityReportService reportService){
    return new GenerateCommunityReportUseCase(reportService);
  }

  @Bean
  public GenerateCDRReportsUseCase generateCDRReportsUseCase(
          CommunityReportService reportService
  ){
    return new GenerateCDRReportsUseCase(reportService);
  }

  //  RF13 - Medical Staff Filter
  @Bean
  public MedicalStaffFilterUseCase medicalStaffFilterUseCase(
          MedicalStaffFilterService filterService
  ){
    return new MedicalStaffFilterUseCase(filterService);
  }

  //  RF14 - Absence Report
  @Bean
  public GenerateAbsenceTrackingReportUseCase generateAbsenceTrackingReportUseCase(
          AbsenceTrackingService trackingService
  ) {
    return new GenerateAbsenceTrackingReportUseCase(trackingService);
  }
}
