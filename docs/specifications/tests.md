---
title: Tests
nav_order: 3
parent: "Specifications"
---

{% include abbreviations.md %}
{% assign javadocs = site.aux_links.Javadocs %}

# {{ page.title }}
{:.no_toc}

For the testing component of the assignment, your test code **must** use annotations and assertions from the JUnit5 testing framework for the following: 

1. Using appropriate test cases (of your choice), your test class **must** verify the correctness of values returned by the `mean()`, `median()`, and `mode()` methods in your `RatingAnalyzer` implementation class. The expected behavior, with example inputs and outputs (which can be used as test cases), can be found in the [Javadocs]({{ javadocs }}org/stats/RatingAnalyzer.html){:target='_blank'} for those methods.

    If you choose to come up with your own test cases, it would be a good idea to compute the expected mean, median, and mode using a mechanism other than your implementation code; otherwise, you run the risk of confirming an incorrect calculation by the same incorrect calculation! Spreadsheets are well-suited to this purpose, as are calculators and calculator applications with statistical capabilities, such as the web-based ["Mean, Median, Mode, Range Calculator"](https://www.calculator.net/mean-median-mode-range-calculator.html) of [Calculator.net](https://www.calculator.net/). 

2. Your test code **must** verify the correct operation, under exceptional conditions, of the constructor of your `RatingAnalyzer` implementation class. 
    
    However, your test code must not create an instance of your implementation class directly (see item 7); instead, it must invoke the `RatingAnalyzer.newInstance(int[])` static factory method. When that method is invoked with an invalid argument value, your test code must verify that `org.stats.AnalyzerConfigurationException` is thrown, and that that exception instance contains a nested exception (i.e. a _cause_) of the type(s) specified for your constructor to throw. 

3. Your test class **must be** located within the `src/test/java` source root.

4. Your test class **must be** in the same package as your implementation class (both relative to their respective source roots).

5. Your test class **must be** named following the pattern *`ImplementationClass`*`Test`, where *`ImplementationClass`* is the name of your implementation class.

    For example, given the above three requirements, if your implementation class is named `MyAnalyzer`, and is located in the `com.analyticspro` package (i.e. it has a fully qualified class name of `com.analyticspro.MyAnalyzer`) in the `src/main/java` source root, your test class must be named `MyAnalyzerTest`, and must be in the `com.analyticspro` package in the `src/test/java` source root. (Note that using IntelliJ's features for creating a JUnit test class will take care of most of this.)  

6. There **must be** _at least_ one test method to test _each_ of the `mean`, `median`, and `mode` methods of your implementation class, and at _at least_ one more to test (indirectly, via `RatingAnalyzer.newInstance(int[])`) its constructor.

7. Your test code **must not** create instances of your implementation class directly (i.e. using the `new` keyword). Instead, the `RatingAnalyzer.newInstance(int[])` static factory method must be invoked to obtain any instances used in the tests.

8. Your test code _should_ use multiple test cases to test different aspects of the behavior of the tested methods, to increase the confidence in their correctness. For example, your code could test that the `median()` method properly handles odd- and even-length arrays, and that the computation for the latter correctly handles a non-integral median value.

   Note that it's quite common for many code deficiencies that are easily fixed to escape detection for some time, due to insufficient test coverage. Thus, time spent on including additional test cases (including boundary or degenerate cases) for all tested methods is usually more than justified.

10. Your test code **must** follow the standard (according to the [Sun/Oracle Java code conventions](http://www.oracle.com/technetwork/java/codeconvtoc-136057.html){:target='_blank'} or the [Google Java style guide](https://google.github.io/styleguide/javaguide.html){:target='_blank'}) letter-casing conventions for class, method, field, parameter, and variable names.

11. Your test code _should be_ readable and well-formatted.

12. If there are comments in the code, these _should be_ clear and relevant; if there are no comments (or minimal comments), the code itself should be self-documenting.