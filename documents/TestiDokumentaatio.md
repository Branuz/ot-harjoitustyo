# Testausdokumentti

Ohjelmaa on testattu Junittestin avulla automatisoiduilla yksikkö- ja integraatiotesteiillä sekä manuaalisesti järjestelmätason testeillä. 
## Yksikkö- ja integraatiotestaus

### Sovelluslogiikka

Kukin sovelluslogiikasta vastaavista testeistä on omissa luokissaan.
#### WordTest -luokka
Löydät testaustiedoston [täältä](https://github.com/Branuz/ot-harjoitustyo/blob/master/languageApplication/src/test/java/com/poussu/studymate/wordTest.java)
- Testaa että word objectin nimen sekä käännöksen lisääminen ja hakeminen toimii halutusti.

#### WordListTest -luokka
Löydät testaustiedoston [täältä](https://github.com/Branuz/ot-harjoitustyo/blob/master/languageApplication/src/test/java/com/poussu/studymate/WordListTest.java)
- Testaa listan nimen lisäämistä sekä hakemista.
- Testaa että lista pitää sisällään sinne lisätyn halutun sanan.

#### WordGameTest -luokka
Löydät testaustiedoston [täältä](https://github.com/Branuz/ot-harjoitustyo/blob/master/languageApplication/src/test/java/com/poussu/studymate/wordGameTest.java)
- Testaa word game:n toiminnallisuuksia kuten oikean käännöksen tarkistamista.
- Testaa väärän käännöksen tarkistamista.
- Testaa sekoitetun sanalistan hakemista sanan sinne lisäämisen jälkeen.

#### UserDataTest -luokka
Löydät testaustiedoston [täältä](https://github.com/Branuz/ot-harjoitustyo/blob/master/languageApplication/src/test/java/com/poussu/studymate/userDataTest.java)
- Testaa käyttäjän eri tietojen lisäämistä sekä muokkaamista.
- Testaa UserManagerin toimintaa lisäämällä ja hakemalla käyttäjän tietoja tietokannasta.
- Testaa UserManagerin toimintaa jos käyttäjää ei löydy tietokannasta.

#### TrophieTest -luokka
Löydät testaustiedoston [täältä](https://github.com/Branuz/ot-harjoitustyo/blob/master/languageApplication/src/test/java/com/poussu/studymate/TrophieTest.java)
- Testaa uusien Trophyjen luomista sekä niiden nimien hakemista ja muokkaamista.
- Testaa Trophyjen statusten hakemista ja muokkaamista.
- Testaa että trophyjen aloitus statukset luodaan oikein.
- Testaa että kaikki lisätyt trophyt löytyvät tietokannasta sekä niiden sisältävät tiedot ovat oikein.
### Repositorio -luokka
Tietojen pysyväistalletuksesta päävastaavana toimii dbUpdaterTest luokaa. Ohjelman tietokannan toimivuuksia on myös testattu aikaisemmissakin luokissa niiden tarpeiden mukaisesti.
#### DbUpdaterTest -luokka
Löydät testaustiedoston [täältä](https://github.com/Branuz/ot-harjoitustyo/blob/master/languageApplication/src/test/java/com/poussu/studymate/dbUpdaterTest.java)
- Testaa että tietokanta yhteystoimii taulujen luomisen jälkeen.
- Testaa että tietokanta pitää sisällään sinne lisätyt tiedot ja että ne tallentuvat oikeisiin listoihin ja objekteihin ohjelmassa.

### Testauskattavuus

Testauksen haarautumiskattavuus on 93%.

![coverage report](./documents/photos/testikattavuus.png)

Testauksen ulkopuolelle on jätetty userInterface -hakemiston tiedostot.

## Järjestelmätestaus

Sovelluksen järjestelmätestaus on suoritettu manuaalisesti.

### Asennus ja konfigurointi

Sovellus on haettu ja sitä on testattu [käyttöohjeen](https://github.com/Branuz/ot-harjoitustyo/blob/master/documents/Usage%20instructions.md) kuvaamalla tavalla Linux-ympäristössä.

### Toiminnallisuudet

Kaikki [määrittelydokumentin](https://github.com/Branuz/ot-harjoitustyo/blob/master/documents/specificationOfRequirements.md) ja käyttöohjeen listaamat toiminnallisuudet on käyty läpi. 
Sovellusta on testattu eri syötteillä ja nimillä sekä ohjelman ensimmäistä kertaa käynnistäessä että muiden käyttätietojen siinä ollessa.

## Sovellukseen jääneet laatuongelmat
Sovellusta käyttäessä komentoriville tulee kyseinen viesti "WARNING: Loading FXML document with JavaFX API of version 17 by JavaFX runtime of version 11.0.2". Tämä ei kuitenkaan vaikuta ohjelman toiminnalisuuten millän tavalla.
