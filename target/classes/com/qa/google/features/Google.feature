Feature: Google Search
  Testing google search functionalities
  Scenario Outline: Validate that number of results displayed is constant across different pages
    Given Desired "<browser>" is opened
    When User searches "<link>" using "<text>" and navigates to 2nd page
    When User checks number of links of 2nd and 3rd page
    Then Number of links on 2nd page matches 3rd page
    Examples:
      | browser | link                   | text     |
      | Chrome  | https://www.google.com | Fiserv   |
      | Chrome  | https://www.google.com | $%$%12#@ |
      | Chrome  | https://www.google.com | null     |
      | Firefox | https://www.google.com | Fiserv   |
      | Edge    | https://www.google.com | Fiserv   |
