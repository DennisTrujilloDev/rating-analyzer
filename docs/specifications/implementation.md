---
title: Implementation
nav_order: 2
parent: "Specifications"
---

{% include abbreviations.md %}
{% assign javadocs = site.aux_links.Javadocs %}

# {{ page.title }}
{:.no_toc}

1. Your implementation class **must** implement the [`org.stats.RatingAnalyzer`]({{ javadocs }}org/stats/RatingAnalyzer.html){:target='_blank'} interface. This also means that you **must** implement the [`mean()`]({{ javadocs }}org/stats/RatingAnalyzer.html#mean()){:target='_blank'}, [`median()`]({{ javadocs }}org/stats/RatingAnalyzer.html#median()){:target='_blank'}, and [`mode()`]({{ javadocs }}org/stats/RatingAnalyzer.html#mode()){:target='_blank'} methods declared in that interface. See the documentation of those methods for the implementation specifications of each.

2. Your implementation **must** include a `public` constructor with a single parameter of type `int[]` (i.e. array of `int`). This constructor must include code that checks the value provided for that parameter, and throws an exception if either of two exceptional conditions holds. See the documentation of the [`RatingAnalyzer.newInstance()`]({{ javadocs }}org/stats/RatingAnalyzer.html#newInstance(int[])){:target='_blank'} method for further details.

3. Your constructor _should_ include a `throws` clause with the exception type(s) that the constructor is capable of throwing, as shown in the documentation for the [`RatingAnalyzer.newInstance(int[])`]({{ javadocs }}org/stats/RatingAnalyzer.html#newInstance(int[])){:target='_blank'} method. (Be sure to read the content below the **Specifications for implementation providers** heading.)

4. The value of the `rating.analyzer` property in the `src/main/resources/rating-analyzer.properties` file **must be** the fully qualified class name of your implementation class.

5. Your implementation class **must be** located within the `src/main/java` source root.

6. Your implementation class **must not be** in the default package (i.e. no package at all), but **must be** in a suitably named package of your choice.

7. Your implementation code **must** follow the standard (according to the [Sun/Oracle Java code conventions](http://www.oracle.com/technetwork/java/codeconvtoc-136057.html){:target='_blank'} or the [Google Java style guide](https://google.github.io/styleguide/javaguide.html){:target='_blank'}) letter-casing conventions for class, method, field, parameter, and variable names. 

8. Your implementation _should be_ clear and well-formatted.

9. If there are comments in the code, they _should be_ clear and relevant; if there are no comments (or minimal comments), the code itself should be self-documenting.