package tads.eaj.ufrn.backend;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;


public class MyArchitectureTest {
  private JavaClasses importedClasses;

  @BeforeEach
  public void setup() {
    importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("tads.eaj.ufrn.backend");
  }

    @Test
    void serviceClassesShouldHaveSpringServiceAnnotation() {
      classes()
              .that().resideInAPackage("..services..")
              .should().beAnnotatedWith(Service.class)
              .check(importedClasses);
    }

  @Test
  void repositoryClassesShouldBeNamedXRepository() {
    classes()
            .that().resideInAPackage("..repositories..")
            .should().haveSimpleNameEndingWith("Repository")
            .check(importedClasses);
  }


  @Test
  //Testa se as classes de services só podem ser acessadas pelos Controllers ou Services
  public void Services_should_only_be_accessed_by_Controllers() {

    // Importa o pacote que será analisado.
    JavaClasses importedClasses = new ClassFileImporter().importPackages("tads.eaj.ufrn.backend");

    // Define uma nova regra.
    ArchRule myRule = classes()
            .that().resideInAPackage("..services..")
            .should().onlyBeAccessed().byAnyPackage("..controllers..", "..services..");

    // Realiza a verificação.
    myRule.check(importedClasses);

  }
  //as classes de serviços devem depender apenas dos controllers ou serviços
  //testes de dependencias
  @Test
  public void services_should_only_be_depended_on_by_controllers_or_other_services(){
          classes().that().resideInAPackage("..services..")
     .should().onlyHaveDependentClassesThat().resideInAnyPackage("..controllers..", "..services..");

  }


  @Test
  //Testa a classe repositorio só podem ser acessado por service
  public void Repository_accessed_by_Controllers() {

    // Importa o pacote que será analisado.
    JavaClasses importedClasses = new ClassFileImporter().importPackages("tads.eaj.ufrn.backend");

    // Define uma nova regra.
    ArchRule myRule = classes()
            .that().resideInAPackage("..repositories..")
            .should().onlyBeAccessed().byAnyPackage( "..services..");

    // Realiza a verificação.
    myRule.check(importedClasses);

  }

}
