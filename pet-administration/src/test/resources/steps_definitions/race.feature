Feature: Race
 	- Manage different animal breeds of the site
  An administrator wants to insert a new race so that it is visible to all users.

  Background:
    Given animal breeds exist:
      | name             | scientistName | code       | specie  | clan     | isActive |
      | AFFENPINSCHER    |               | AFFEN_DOG  | DOG     | MAMMALIA | true     |
      | AIREDALE_TERRIER |               | AI_TE_DOG  | DOG     | MAMMALIA | false    |
      | AKITA_AMERICAIN  |               | AK_AM_DOG  | DOG     | MAMMALIA | true     |


  Scenario Outline: insertion of a new race possible
    Given I am authenticated as an administrator
    And I have the insertion rights of an animal race
    When I am trying to insert a new breed "<AKITA_INU>"
    Then insertion is possible
    And list of animals increases
    And last insertion is not active
    And code is hashe
    And following fields (name, code, specie, clan) are in upper case
    Examples:
      | name             | scientistName | code       | specie  | clan     | isActive |
      | AFFENPINSCHER    |               | AFFEN_DOG  | DOG     | MAMMALIA | true     |
      | AIREDALE_TERRIER |               | AI_TE_DOG  | DOG     | MAMMALIA | false    |
      | AKITA_AMERICAIN  |               | AK_AM_DOG  | DOG     | MAMMALIA | true     |
      | AKITA_INU        |               | AI_IN_DOG  | DOG     | MAMMALIA | false    |

  Scenario Outline: insertion of a new race impossible
    Given jI am authenticated as an administrator
    And I have the insertion rights of an animal race
    When I am trying to insert a breed "<AFFENPINSCHER>" which already exists
    Then insertion is not possible
    And and an existing breed alert is coming up
    And the list of animals increases remains the same
    Examples:
      | name             | scientistName | code       | specie  | clan     | isActive |
      | AFFENPINSCHER    |               | AFFEN_DOG  | DOG     | MAMMALIA | true     |
      | AIREDALE_TERRIER |               | AI_TE_DOG  | DOG     | MAMMALIA | false    |
      | AKITA_AMERICAIN  |               | AK_AM_DOG  | DOG     | MAMMALIA | true     |