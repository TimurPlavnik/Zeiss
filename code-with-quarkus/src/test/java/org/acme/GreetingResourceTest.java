package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {
  
  @Inject
  TestClass service;

  @Test
  @DisplayName("Hello test")
  public void testHelloEndpoint() {
      given()
        .when().get("/hello")
        .then()
          .statusCode(200)
          .body(is("Hello from RESTEasy Reactive"));
  }

  @Test
  @DisplayName("Test test")
  @Transactional
  public void testTest() {

    service  = new TestClass();
    service.number=4;
    
    service.persist();
    if(service.isPersistent()){
      assertEquals(20, service.multiply(5),     
    "Regular multiplication should work");
    }
  }

}