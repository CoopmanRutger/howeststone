#title
##title
###title
######title

normal text<br>
_italic_
*italic*<br>
**bold**
__bold__<br>
**big bold text**
***big bold and italic***
****big****

##Groepsfoto en introductie teamleden van '*Finding Nemo*'

! [Group pic](https://172.21.22.52/TI/Project-I/2018-Group-07/blob/backend/group07Pic.jpg)
van links naar rechts

**Bert Vervust**

**Louis Boucquet**

**Rutger Coopman**

**Nino Florizoone**

Bert is een gedreven werker; hij heeft vaak zin om van allerlei features te implementeren, maar heeft soms de technische bagage niet om de voor zichzelf opgelegde taken te voltooien. 
Met wat bijsturing echter, behlpt hij zich wel op weg. Zijn organisatorische drive zorgde ervoor dat heel wat features niet over het hoofd werden gezien.
QUOTE:

# Rutger

Rutger is technisch wat sterker dan Bert en schrijft daardoor vlotter code die ook een stuk kwaliteitsvoller is.
Rutger heeft ook hier en daar een duwtje in de rug nodig om de juiste richting te vinden in de samenhang van de code om een goed resultaat te komen.


# Nino

Nino heeft praktisch geen technische bagage, wat ons ook opviel. In de eerste sprint focuste hij zich uitsluitend op _photoshop_, wat toen ook wel nodig was.
Hoewel we hem aanspoorden af te wisselen in zijn werklast, JS probeerden bij te leren, leek het weinig uit te maken.
En wanneer hij zich probeerde te focussen op de HTML en CSS (JS was te moeilijk), deed hij goedwerkende functionaliteiten in het honderd lopen.

# Louis

Louis heeft waarschijnlijk de meeste technische bagage en probeerde daarmee de anderen zoveel mogelijk te helpen. Hij lette er ook op dat de algemene lijn goed zat, 
het grotere plaatje als het ware. Hij zou best wel wat meer commentaar bij zijn code schrijven en algemeen nettere code schrijven.


##Klassendiagram

cfr. class_diagram_howestStone.pdf

##SQL Database-schema

cfr SQLDatabaseScheme.htm

##Starten van het spel
###Frontend
In u geliefde editor start u het HTML bestand '0_welcomeScreen.html'

##noten en addenda

###acties spelbord

Per actie die uitgevoerd wordt op het spelbord aan de frontend zijde sturen de hele
game state door naar de backend. Wanneer bevoorbeeld aan de minions wat veranderd wordt,
het boosten van de aanvalswaarde, dan wordt de hele lijst met minions teruggestuurd.
Indien het tijdsschema ons toeliet zouden we een efficiëntere manier implementeren, waarbij
alle speldbordfunctionaliteiten dubbel worden gemaakt. Hierdoor zou de gebruikerskant van
het spel minder belast worden en het spel vlotter werken d.m.v. directe feedback. Ook
zou de communicatie tussen cliënt en server beter verlopen omdat dan enkel hetgeen wat 
nodig is wordt doorgestuurd. Zo wordt de gebruikte bandbreedte voor die communicatie beperkt.


###CLI en spelbord frontend

De CLI kan veel meer dan de werking van de applicatie via user input aan de frontend.
We kwamen niet tot de implementatie voor het opslaan van het spel aan de frontendzijde,
hoewel we van mening zijn dat mits enige moeite het opgeslagen spel kan worden voortgezet 
aan de JAVA CLI applicatie.


###werking magische kaarten

De klasse Conditions en onderdaan in de GameCLI (en de benodigde _fields_ in de klasse CardSpell) 
staan methodes geschreven die een begin vormen van de implementatie van de magische kaarten. 
Naast de database die helemaal klaar staat voor het aanspreken van die kaarten, bestaat er dus 
al een soort van basis in de JAVA voor deze functionaliteit. 
U zal merken dat de in commentaar gezette code nog heel wat fouten verscholen zitten. Wegens tijdgebrek
en veranderende prioriteiten konden we die niet meer oplossen.






// frontend refreshen per actie ~ know its not efficient; Min. viable product
 (scrum filosofie) 
 bv lijst met veel koart’n, ix veranderen ~ hele lijst trg drstrn
wat we zouden implementeren if enough time => alle features dubbel implementeren 
(client side minder belasten ~ easy to work, immediate feedback) x COMM server-client 
zorgen dat er zo weinig mogelijk info wordt doorgegeven (enkel verandering door geven
 bv lijst met veel koartn’, ix veranderen ~ enkel specifiek de verandering drstrn 
(zorgen da bij verandering van 1 kaart enkel 1 kaart wordt veranderd ipv 
 ~ enkel verandering doorsturen (om zo weinig mogelijk NETWERK te gebruiken)






