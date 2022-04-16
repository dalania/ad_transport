//package tads.eaj.ufrn.backend;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.stereotype.Service;
////import org.springframework.stereotype.Repository;
////import com.tngtech.archunit.core.domain.JavaClasses;
////import com.tngtech.archunit.core.importer.ClassFileImporter;
////import com.tngtech.archunit.core.importer.ImportOption;
////import org.junit.jupiter.api.BeforeEach;
////import org.junit.jupiter.api.Test;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Repository;
////import org.springframework.stereotype.Service;
//
//
//
//
//import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
//import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
//import static jdk.jshell.TreeDissector.classes;
//@RunWith(ArchUnitRunner.class)
//@AnalyzeClasses(packages = "com.tngtech.archunit.example.layers")
//public class Testes {
//  private JavaClasses importedClasses;
//
//  @BeforeEach
//  public void setup() {
//    importedClasses = new ClassFileImporter()
//            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
//            .importPackages("com.springboot.testing.archunit");
//  }
//
//
//  @Test
//  void layeredArchitectureShouldBeRespected() {
//
//    layeredArchitecture()
//            .layer("Controller").definedBy("..controllers..")
//            .layer("Service").definedBy("..services..")
//            .layer("Repository").definedBy("..repositories..")
//
//            .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
//            .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller")
//            .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service")
//            .check(importedClasses);
//  }
//
//}
