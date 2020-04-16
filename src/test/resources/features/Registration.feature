@Test
Feature: Client registration process

  Scenario: End to End
    Given User sign up with valid data "/clients"
    When User sign in to portal "/login"
    Then Check sign in success massage "/hello"
    When User logout "/logout"

  Scenario Outline: User tries to create account with already exist name and full name
    Given User sign up with valid data "/clients"
    When Tries to create user "/clients" and check "<resultCode>" and "<errorMessage>" and "<statusCode>"

    Examples:
      | resultCode      | errorMessage                                                                      | statusCode |
      | UnexpectedError | org.hibernate.exception.ConstraintViolationException: could not execute statement | 500        |


  Scenario Outline: User tries to create account without name
    Given Tries to create user without name "/clients" and check "<resultCode>" and "<errorMessage>" and "<statusCode>"

    Examples:
      | resultCode      | errorMessage                                                                                                                                               | statusCode |
      | UnexpectedError | org.hibernate.id.IdentifierGenerationException: ids for this class must be manually assigned before calling save(): com.libertex.qa.challenge.model.Client | 500        |


  Scenario Outline: User tries to get hello massage without token
    Given User sign up with valid data "/clients"
    When User sign in to portal "/login"
    When User tries to login without token "/hello" and check "<resultCode>" and "<statusCode>"

    Examples:
      | resultCode   | statusCode |
      | Unauthorized | 401        |


  Scenario Outline: User tries to login with empty user name
    Given User sign up with valid data "/clients"
    When User sign in to portal "/login"
    When User tries to login without token "/hello" and check "<resultCode>" and "<statusCode>"

    Examples:
      | resultCode   | statusCode |
      | Unauthorized | 401        |