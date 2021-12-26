<h1> Ohjelmistotekniikka, harjoitustyö </h1> 

Harjoitustyön aiheena on kielen opiskelu ohjelma johon pystyy lisäämään ja harjoittelemaan erillaisten uusien sanojen ja lauseiden kirjoittamista ja muistamista.

<h2>Dokumentaatio</h2>

[Työaikakirjanpito](https://github.com/Branuz/ot-harjoitustyo/blob/master/documents/tuntikirjanpito.md)

[Määrittelydokumentti](https://github.com/Branuz/ot-harjoitustyo/blob/master/documents/specificationOfRequirements.md)

[Alustava käyttöohje](https://github.com/Branuz/ot-harjoitustyo/blob/master/documents/Usage%20instructions.md)

[Arkkitehtuuri](https://github.com/Branuz/ot-harjoitustyo/blob/master/documents/Architecture.md)

[Release](https://github.com/Branuz/ot-harjoitustyo/releases/tag/viikko6)


<h2>Ohjeet</h2>

Ohjelman saa suoritettua hakemistossa languageApplication komennolla: 
```
mvn compile exec:java -Dexec.mainClass=com.poussu.studymate.Main
```

<h2>Komentorivi komennot</h2>

<h3>Testit</h3>

Testit suoritetaan komennolla


```
mvn test
```
Testikattavuus raportti saadaan luotua komennolla

```
mvn test jacoco:report
```
Testikattavuutta pääse tarkatselamaan selaimen kautta hakemistosta /target/site/jacoco/index.html

<h3>Jarin generointi</h3>

Komento
```
mvn package 
```
Ohjelma luodaan hakemistoon target nimellä studymate-1.0-SNAPSHOT.jar


<h3>Checkstyle</h3>

Komento

```
mvn jxr:jxr checkstyle:checkstyle
```
<h3>Javadoc</h3>

Javadocin saa luotua komennolla 

```
mvn javadoc:javadoc
```
Tämä luo hakemistoon /target/site/apidocs/index.html jonka kautta voi päästä tukimaan javdocia.
  
<h2> Tehtävät</h2>
<h3> Viikko 1</h3>

[komentorivi.txt](https://github.com/Branuz/ot-harjoitustyo/blob/master/laskarit/viikko1/komentorivi.txt)

[gitlog.txt](https://github.com/Branuz/ot-harjoitustyo/blob/master/laskarit/viikko1/gitlog.txt)
<h3> Viikko 2</h3>

[Maksukortti: MaksukorttiTest.java](https://github.com/Branuz/ot-harjoitustyo/blob/master/laskarit/viikko2/Maksukortti/src/test/java/MaksukorttiTest.java)

[Unicafe: MaksukorttiTest.java](https://github.com/Branuz/ot-harjoitustyo/blob/master/laskarit/viikko2/Unicafe/src/test/java/com/mycompany/unicafe/MaksukorttiTest.java)

[Unicafe: KassapaateTest.java](https://github.com/Branuz/ot-harjoitustyo/blob/master/laskarit/viikko2/Unicafe/src/test/java/com/mycompany/unicafe/KassapaateTest.java)

[Unicafe: KattavuusRaportti.png](https://github.com/Branuz/ot-harjoitustyo/blob/master/laskarit/viikko2/Kattavuusraportti.png)

<h3> Viikko 3</h3>

[Monopoly1-2.jpg](https://github.com/Branuz/ot-harjoitustyo/blob/master/laskarit/viikko3/Monopoly_1-2.jpg)


[Sekvenssi3.png](https://github.com/Branuz/ot-harjoitustyo/blob/master/laskarit/viikko3/Sekvenssi3.png)

[Sekvenssi4.png](https://github.com/Branuz/ot-harjoitustyo/blob/master/laskarit/viikko3/Sekvenssi4.png)
