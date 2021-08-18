

    Maven
    ------
    
    Build tool for java projects and also a project management tool
    
    - provides standard templates for java projects
        - archetypes 
        
    - dependencies management
        - project cordinate
            GAV
                - groupid    - com.brillio
                  artifactid - myproject
                  version    - 1.0.2-RELEASE / SNAPSHOT  
    
    - Build projects
        - compile......
        Lifecycle
            clean
                pre clean
                clean
                post clean
            default
                validate
                compile - compile plugin - goal
                test    
                package
                integration test
                verify
                install
                deploy
            
            site
                generating documentation for your project
            
          
          Maven commands are run ib the folder which contains pom.xml  
            
            
           > mvn clean 
                - deletes the target folder 
           
           > mvn test
           
           > mvn package
           
           > mvn clean package
        
        
    pom.xml
    --------
    Maven refers for all its configuration
        project cordinates
        Dependencies
        plugin configuration
        repo configuration
        packaging
        
        
   Regular Expressions
   --------------------
   
   [a-z] - one character which is any letter from a to z
   [A-Za-z]
   [0-9]
   [a-em-p5-9]
   
   
   
   Quantifiers
   -----------
   
   * - 0 or more characters
   + - 1 or more characters
   ? - 0 or 1 charaters
   {min,max} 
   {3,6}
   
   {min} - exactly min characters
    {5} - exactly 5 chars
   
   {min,} - at least min character 
   {5,} -  5 or more
   
   
   Metacharacters
   --------------
   \d  -  [0-9]
   \D  - Non Digit
   \w - word [A-Za-z_0-9]
   \W - Non word
   \s - new space character - space, tabs, newline character
   \S - non space character
   
   
   - Validate password, color codes, vehile numbers, pan number .....
   - search and replace
 
 
     Group
     -----
     ([a-z]{3,}[0-9]+)|([A-Z]+)
     
     
    Pattern and Matcher classes
  
  
  
  
  
  JUnit
  -----
  
  
  Testing:
  --------
  - Find the bugs
  - Programs are working as per expected functionlity
  - Improve the code quality
  - Reduces the cost and time
  
  
   Unit Testing
   -----------
   - Testing individual components/classes in isolation with other part of the application
   
   Regression Testing

  
  JUnit, Testng
  
  JUnit
    - version 5 - Jupiter
    
    - TestRunners
    - Assertions
        - integrates with popular assertion libraries like Hamcrest, AssertJ
        assertEquals
        assertNotEquals
        assertTrue
        assertFalse
        assertSame
        assertNotSame
        assertThrows
        ...
        
        
    - provides Annotation to mark a method as a test method
        @Test - making a method as test method 
        @BeforeAll @AfterAll @BeforeEach @AfterEach - Setup the test environment
        @Ignore - Test will be ignored
        
        
    Java 8+
    --------
    
    - Functional programming concepts were introduced
    
    Lambda Expression:
        - anonymous functions
        - functions which can be passed to other function and can be executed later
        - can be assigned to specific type of variable
        - Making our code concise, less verbose
        - introduces stream processing
        
        
        public double add(int num1, int num2){
            return num1 + num2;
        }
        
        
        (int num1, int num2) -> {
            return num1 + num2;
        }
        
        (num1, num2) -> {
            return num1 + num2;
        }
    
        (num1, num2) ->  num1 + num2;
        
        
        
      Interface can default, static and private method  
        
        
      Functional Interface
      ---------------------
      - interface which contains only one abstract method
      - can be used as the assignment target for a lambda expression or method reference
      
      - Comparable, Comparator, Runnable..
      
      
      java.util.function - contains lot of predefined functional interface which can be use to create lambda expressions
      
      Consumer - accepts a single input argument and returns no result                  - accept​(T t)
      Supplier - Represents a supplier of results.                                      - get()
      Predicate - Represents a predicate (boolean-valued function) of one argument      - test​(T t)
      Function - Represents a function that accepts one argument and produces a result  - apply​(T t)
      
      BinaryOperator<Integer> operator = (n1,n2)->{ return n1 + n2}
      
      BiPredicate<String, Integer> somePredicate = (str, num1) -> { 
            
            if(str.length() == 5 & num1 > 100{
                return true;
            }else{
                return false;
            }
      }
      
      
      
      
      Method Reference
      ----------------
      Reference to an existing method
      
      syntax:
      
      className::methodName
      objectRef::methodName
      ClassName::new
      
      They can be used in place of Lambda expression and assigned to a Functional interface
      
     
      
      Consumer<String> consumer =  System.out::println;
      
                                   
      
      Comparator Interface
      Streams API
      
      
      Comparator
      
      
      Streams API
      -----------
      
      - sequence of objects obtained from a source like collection, array ...
      - perform operation on each object as they pass in the stream
      
      Two types of operations
      - intermediate operation
        - do not end the stream
        - returns the stream back
        - lazily evaluated
        - chain multiple intermediate operation
        - filter, map, sort, limit ........
      - terminal operation
        - last op on the stream
        - end the stream
        - aggregation(sum, avg), collect, search, match .......
      
      
      coll --> i1 ----> i2 ---> i3 ---> t1
      
      
      Creation of Streams
      -------------------
      
      Integer[] arr = ....
      
      - Arrays.stream(arr).i1.i2.t1
      
      
      List<String> states = ....
      - states.stream().i1.i2.t1
      - states.parallelStream().i1.i2.t1
      
      
      Stream.of(o1,o2,o3...)
      
      Stream.concat(st1, st2)
      
      Stream.iterate(function) -  infinite stream
      Stream.generate(...)
      
      
      
      Intermediate 
        - filter (Predicate)
        - map (Function)
        - sort (Comparator)
        - limit
        - distinct
        - flatmap
        - skip(n)
        - boxed()
        
        
      Terminal
        - Agg. operations like sum, avg, min, max ...
        - summaryStatistics (Primitive streams)
        - forEach(Consumer)
        - collect (Collectors ) // toList, ToSet, ToMap, ToCollection
                                   - joining, 
        - toArray
        - search - findAny, findFirst() 
        - match  - anyMatch(Predicate), allMatch, noneMatch 
        
        
      
      Optional
      ---------
      - Container object which can be empty or can contain a value
      - Handle Nulls better
      
      
      
     Product getProduct(id){}
     ------
     
     Service:
      Product p = dao.getProduct(101);
      if( p != null){
        p.getCategory();
      }
      
      
      
      Optional<Product> getProduct(id){}
      
      
      Optional Methods
        isPresent()
        isEmpty
        orElse
        orElseThrow(Supplier)
        ifPresent(consumer)
        ifPresentOrElse(Consumer, Runnable)
        
        
      Optional.empty()
      Optional.of(....)
      Optional.ofNullable(...)
      
      
      
      Collectors:
        toList, toSet, toMap, toCollection
        
        - mapping
        - grouping
        - maxBy, minBy
        - joining
        - summingInt, Summarizing...
        - counting
        
        
        
   NIO2 - New IO 2
   --------------
   
   Stream<String> data = Files.lines(path)  
   
   Path - represents the path to a file/folder
        - has methods to get the path details and work on the path
        
        Path filePath = Paths.get("", "",....)
        
   Files
        - Utility class for reading/writing to files given a path
        
        
  Files:      
   lines() - Stream<String>
   readAllLines - List<String> 
   list  - Stream<Path>
   walk -- Stream<Path>
   
   newBufferedReader
   newBufferedWriter
   
   
   
   Before Pushing exercises to Gitlab
   
   - Add unnecessary files to .gitignore
   - Format your code
   - check the code using Sonarlint
   
   
   Date and Time API
   -----------------
   java.util....
   
   Old API - Date, Calendar, DateFormatter, SimpleDateFormat...
   
    - Mutable
    - Didnt provide lots of methods to add/search/compare/manipulate the dates
    
    
  java.time --- package     -- (joda time)
  
  Classes
  -------
  
  LocalDate         - Represent only the date portion
  LocalTime         - Represent only the time portion
  LocalDateTime     - Represent only the date and time portion
  ZonedDateTime     - Represent only the date portion for a zone
  
  DateTimeFormatter - Parsing and Formatting Dates
  
  Period            - represent amount of time in days, months and years , time between two LocalDates
  Duration          - represent amount of time in hours, mins and secs-  time between two LocalTime
  
  Chronounits -    DAYS, WEEKS, MONTHS, YEARS....
  
  TemporalAdjuster
    TemporalAdjusters - Factory class
  
  
     
   
  assignments
    https://gitlab.stackroute.in/stack_java_cycle6_exercises/exercise-td-streams-fileoperations.git
    https://gitlab.stackroute.in/stack_java_cycle6_exercises/exercise-td-streams-datetime.git      
   
   
     
        
        
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
        
      
      
      
      
      
      
      
      
      
      
      
      
    
  
   
   
   
   
   
   
   
   
   
   
   
   
   
   
         
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    
    
