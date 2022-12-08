# Criminal Justice 

> This project models and replicates the ProPublica’s analysis that highlights the racial biases in the COMPAS recidivism algorithm.

<a name="toc"/></a>
## Table of Contents

1. [Overview](#overview)

2. [Technologies](#technologies)

3. [Launch](#launch)

4. [Source](#source)

<a name="overview"/></a>
## 1. Overview
[Back to ToC](#toc)

This project models and replicates ProPublica’s analysis of a tool called COMPAS that is used in the U.S. judicial system to assess the likelihood that a person who has been convicted of a crime will reoffend. The result highlights the discrepancy and racial bias in the way the COMPAS algorithm scores black defendants vs. white defendants.

<a name="technologies"/></a>
## 2. Technologies
[Back to ToC](#toc)

java version "1.8.0_181"<br />
Java(TM) SE Runtime Environment (build 1.8.0_181-b13)<br />
Java HotSpot(TM) 64-Bit Server VM (build 25.181-b13, mixed mode)<br />

<a name="launch"/></a>
## 3. Launch
[Back to ToC](#toc)
```bash
javac -classpath .:target/dependency/* -d . $(find . -type f -name '*.java')

java -classpath .:target/dependency/* Main
```
<a name="source"/></a>
## 4. Source
[Back to ToC](#toc)

This project is based on the [**Criminal Justice**](https://collegescorecard.ed.gov/) assignment from [**Responsible Problem Solving**](https://responsibleproblemsolving.github.io/).