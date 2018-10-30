Feature: Specie
 	- Gerer les differents espèces du site
  Un administrateur veut insérer une nouvelles espèce pour qu'elle soit visible par tous les utilisateurs.

  Background:
    Given des espèces animales existent:
      | name             | scientistName | code   | race  | raceScientistName      | raceCode | type      | typeScientist | typeCode |
      | AFFENPINSCHER    |               | AFFEN  | CHIEN | Canis lupus familiaris | CHIEN    | MAMMIFERE | Mammalia      | MAMM     |
      | AIREDALE_TERRIER |               | AI_TE  | CHIEN | Canis lupus familiaris | CHIEN    | MAMMIFERE | Mammalia      | MAMM     |
      | AKITA_AMERICAIN  |               | AK_AM  | CHIEN | Canis lupus familiaris | CHIEN    | MAMMIFERE | Mammalia      | MAMM     |


  Scenario Outline: insertion d'une nouvelle espèce possible
    Given je suis authentifié en tant que administrateur
    And j'ai les drois d'insertion d'une espèce animale
    When je tente d'insérer une nouvelle espèce "<AKITA_INU>"
    Then l'insertion est possible
    And la liste d'animaux augmente
    Examples:
      | name             | scientistName | code   | race  | raceScientistName      | raceCode | type      | typeScientist | typeCode |
      | AFFENPINSCHER    |               | AFFEN  | CHIEN | Canis lupus familiaris | CHIEN    | MAMMIFERE | Mammalia      | MAMM     |
      | AIREDALE_TERRIER |               | AI_TE  | CHIEN | Canis lupus familiaris | CHIEN    | MAMMIFERE | Mammalia      | MAMM     |
      | AKITA_AMERICAIN  |               | AK_AM  | CHIEN | Canis lupus familiaris | CHIEN    | MAMMIFERE | Mammalia      | MAMM     |
      | AKITA_INU        |               | AI_IN  | CHIEN | Canis lupus familiaris | CHIEN    | MAMMIFERE | Mammalia      | MAMM     |

  Scenario Outline: insertion d'une nouvelle espèce impossible
    Given je suis authentifié en tant que administrateur
    And j'ai les drois d'insertion d'une espèce animale
    When je tente d'insérer une espèce "<AFFENPINSCHER>" qui existe déjà
    Then l'insertion n'est pas possible
    And et une alerte pour espèce déjà existante se lève
    And la liste d'animaux augmente reste la même
    Examples:
      | name             | scientistName | code   | race  | raceScientistName      | raceCode | type      | typeScientist | typeCode |
      | AFFENPINSCHER    |               | AFFEN  | CHIEN | Canis lupus familiaris | CHIEN    | MAMMIFERE | Mammalia      | MAMM     |
      | AIREDALE_TERRIER |               | AI_TE  | CHIEN | Canis lupus familiaris | CHIEN    | MAMMIFERE | Mammalia      | MAMM     |
      | AKITA_AMERICAIN  |               | AK_AM  | CHIEN | Canis lupus familiaris | CHIEN    | MAMMIFERE | Mammalia      | MAMM     |