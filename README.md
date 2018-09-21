# casestudy

#Tools/.jars used
JAVA,TestNG,Maven,Log4J,Seleimum WebDriver,apache.poi,Listners

# this is a Maven project , import this as a maven project or after importing as normal project update the maven dependcies
#For API tests used endpoint "https://api.github.com/repos/SeleniumHQ/selenium/issues"
# for UI automation, used GITHub registration form  "https://github.com/"

# we can run business scripts(actual test case execution files) or direct run the testNG file (TestSuite.xml)  
# added all the test cases into single executable file with TestNG annoatation(means mutliple test cases added into one java file with @Test)
# if we want to run github registration multiple times, please modify user name & email in the Registration.xlsx file otherwise it will throw duplicate error

