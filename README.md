<h1> Ohjelmistotekniikka, harjoitustyö </h1> 

Harjoitustyön aiheena on kielen opiskelu ohjelma johon pystyy lisäämään ja harjoittelemaan erillaisten uusien sanojen ja lauseiden kirjoittamista ja muistamista.

<h2>Dokumentaatio</h2>

[Työaikakirjanpito](https://github.com/Branuz/ot-harjoitustyo/blob/master/documents/tuntikirjanpito.md)

[Määrittelydokumentti](https://github.com/Branuz/ot-harjoitustyo/blob/master/documents/specificationOfRequirements.md)

[Käyttöohje](https://github.com/Branuz/ot-harjoitustyo/blob/master/documents/Usage%20instructions.md)

[Testausdokumentti](https://github.com/Branuz/ot-harjoitustyo/blob/master/documents/TestiDokumentaatio.md)

[Arkkitehtuuri](https://github.com/Branuz/ot-harjoitustyo/blob/master/documents/Architecture.md)

[Release](https://github.com/Branuz/ot-harjoitustyo/releases/tag/viikko7)


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
  

