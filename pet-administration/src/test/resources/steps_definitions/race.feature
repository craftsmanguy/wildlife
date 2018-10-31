Feature: Race
 	- Gerer les differents espèces du site
  Un administrateur veut insérer une nouvelles race pour qu'elle soit visible par tous les utilisateurs.

  Background:
    Given des espèces animales existent:
      | name             | scientistName | code   | specie  | type      | isActive |
      | AFFENPINSCHER    |               | AFFEN  | CHIEN   | MAMMIFERE | true     |
      | AIREDALE_TERRIER |               | AI_TE  | CHIEN   | MAMMIFERE | false    |
      | AKITA_AMERICAIN  |               | AK_AM  | CHIEN   | MAMMIFERE | true     |


  Scenario Outline: insertion d'une nouvelle race possible
    Given je suis authentifié en tant que administrateur
    And j'ai les drois d'insertion d'une race animale
    When je tente d'insérer une nouvelle race "<AKITA_INU>"
    Then l'insertion est possible
    And la liste d'animaux augmente
    Examples:
      | name             | scientistName | code   | specie  | type      | isActive |
      | AFFENPINSCHER    |               | AFFEN  | CHIEN   | MAMMIFERE | true     |
      | AIREDALE_TERRIER |               | AI_TE  | CHIEN   | MAMMIFERE | false    |
      | AKITA_AMERICAIN  |               | AK_AM  | CHIEN   | MAMMIFERE | true     |
      | AKITA_INU        |               | AI_IN  | CHIEN   | MAMMIFERE | true     |

  Scenario Outline: insertion d'une nouvelle race impossible
    Given je suis authentifié en tant que administrateur
    And j'ai les drois d'insertion d'une race animale
    When je tente d'insérer une race "<AFFENPINSCHER>" qui existe déjà
    Then l'insertion n'est pas possible
    And et une alerte pour race déjà existante se lève
    And la liste d'animaux augmente reste la même
    Examples:
      | name             | scientistName | code   | specie  | type      | isActive |
      | AFFENPINSCHER    |               | AFFEN  | CHIEN   | MAMMIFERE | true     |
      | AIREDALE_TERRIER |               | AI_TE  | CHIEN   | MAMMIFERE | false    |
      | AKITA_AMERICAIN  |               | AK_AM  | CHIEN   | MAMMIFERE | true     |