---
title: Dependencies
nav_order: 1
parent: "Specifications"
---

{% include abbreviations.md %}
{% assign javadocs = site.aux_links.Javadocs %}

# {{ page.title }}
{:.no_toc}

* The compiled code from the `org.stats` package, including the `RatingAnalyzer` interface and two supporting classes, is included in a JAR file in the `libs` directory of this project. This JAR file (as well as another others in the same directory) is included as a compile- and runtime dependency of this project by the properties of the `dependencies` task in `build.gradle`. 

* The JUnit5 library and engine are included (again by properties set for the `dependencies` task in `build.gradle`) as test-scoped dependencies of this project. When building and running tests, Gradle will automatically download these components, if they haven't been downloaded already.

Given the above, there's no need for you to download any libraries or add dependencies to `build.gradle` (or declare any new dependencies via **File/Project Structure**).  
