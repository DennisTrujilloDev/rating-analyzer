---
title: Overview
nav_order: 1
---

{% include abbreviations.md %}
{% assign javadocs = site.aux_links.Javadocs %}

# {{ page.title }}
{:.no_toc}

<details markdown="block">
  <summary>Contents</summary>
* TOC
{:toc}
</details>

## Introduction

For this assignment, you'll write a class that implements a hypothetical _JAMS_ (_Java API for Mathematical Statistics_) specification---specifically, an implementation of the [`org.stats.RatingAnalyzer`]({{ javadocs }}org/stats/RatingAnalyzer.html){:target='_blank'} interface, with methods for computing basic statistical measures on an `int[]` (array of `int`). You'll also write a test class for that implementation, to verify that it works as expected.

## Deadline

Work on this assignment **must be** committed to Git and pushed to GitHub (in the repository created in ["Create & Configure"](project-repository/template.md)) by {{ site.deadline.submission }}.

## Assumptions

To complete this assignment, you must have the following software installed; however, note that under certain conditions (described in the footnotes), specific version of the JDKs or Gradle will be downloaded automatically,

* JDK 11[^jdk-version]
* Git 2.0 or higher
* Gradle 6.0 or higher (Gradle v7.5 is used in the build.[^gradle-version])
* Text editor (capable of editing plain text files) or IDE.

[^jdk-version]: If Gradle does not detect a suitable JDK installed, it will provision the build by downloading the required JDK, following the rules given in ["Toolchains for JVM projects: Precedence](https://docs.gradle.org/current/userguide/toolchains.html#sec:precedence){:target='_blank'}. The downloaded JDK will be available to subsequent Gradle builds.

[^gradle-version]: The Gradle project in the code repository for this project includes the [_Gradle Wrapper_](https://docs.gradle.org/current/userguide/gradle_wrapper.html). As long as builds are performed using the Gradle Wrapper (done by default in IntelliJ IDEA and some other IDEs, and via a configurable option in virtually all others), the required version of Gradle will be downloaded if it's not already present on the local system; after downloading, it will remain available for subsequent Gradle builds. 

## [Project & repository](project-repository/)

For your implementation, you won't be creating a new project or repository from scratch; instead, you'll be creating a private repository from a template (but adding your instructor as a collaborator), then closing and opening it in IntelliJ. 

## [Specifications](specifications/)

The specification you'll be implementing is for a hypothetical project (_JAMS---The Java API for Mathematical Statistics_), and consists of a fully documented interface in the `org.stats` package. You **must** read the [Javadocs]({{ javadocs }}org/stats/RatingAnalyzer.html){:target='_blank'} for this interface, as well as the additional [implementation specifications](specifications/implementation.md) and [test specifications](specifications/tests.md). 

In this assignment, you're playing the role of provider, which means you're expected to implement the specifications stated in the Javadocs and accompanying documentation. In practical terms, this means that you must write a class that implements the [`org.stats.RatingAnalyzer`]({{ javadocs }}org/stats/RatingAnalyzer.html){:target='_blank'} interface. Of course, you'll also need to write unit tests for your implementation.

In all, the code you write is likely going to involve only the two classes mentioned above: an implementation class and a test class. (You are free to add supporting classes, if you find it useful to do so.)

## [Evaluation](evaluation/)

Each student is required to submit their own work on this assignment.

Code must be committed to Git _and_ pushed to GitHub no latter than the submission deadline ({{ site.deadline.submission }}) to be eligible for grading. Submitted code will be evaluated in terms of whether it compiles successfully; includes all expected methods and constructors in the interface implementation and test classes; performs the required computations correctly; is written clearly; and is consistently formatted. 
