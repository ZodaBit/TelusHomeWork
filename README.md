The project directory structure looks like below 

src
+ test
    + java                        Test runners and supporting code
    + amazon
      + actions                     does the actual action 
      + navigation                  responsible for opening the amazon home page:
      + pageComponents              where i keep  track of locators
      + stepDefinitions             //describes testes in the form of Screenplay pattern
    + resources
        + features                  Feature files  a.k.a Cucumber scenario
        serenity.conf               configuration file , if we want to run headless mode  and many more
