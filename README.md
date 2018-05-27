
## Groepsfoto en introductie teamleden van '*Finding Nemo*'

![Group pic](../group07Pic.jpg)
_van links naar rechts_<br>
**Bert Vervust**, **Louis Boucquet**, **Rutger Coopman**, **Nino Florizoone**

###Bert

Bert is een gedreven werker; hij heeft vaak zin om van allerlei features te implementeren, maar heeft soms de technische bagage niet om de voor zichzelf opgelegde taken te voltooien.
Met wat bijsturing echter, behlpt hij zich wel op weg. Zijn organisatorische drive zorgde ervoor dat heel wat features niet over het hoofd werden gezien.
QUOTE:


###Louis

Louis heeft de meeste technische bagage en probeerde daarmee de anderen zoveel mogelijk te helpen. Hij lette ook op het grotere geheel zodat de cod niet in het honderd liep.
Als het werkt werkt het, maar ondanks de initieel slordige code zal Louis altijd proberen een zo net mogelijke codecreatie neer te pennen.

###Rutger

Rutger is technisch wat sterker dan Bert en schrijft daardoor vlotter code die ook een stuk kwaliteitsvoller is.
Rutger heeft ook hier en daar een duwtje in de rug nodig om de juiste richting te vinden in de samenhang van de code om tot een goed resultaat te komen.

###Nino

Nino heeft praktisch geen technische bagage, wat ons ook opviel. In de eerste sprint focuste hij zich uitsluitend op _photoshop_, wat toen ook wel nodig was.
Hoewel we hem aanspoorden om af te wisselen in zijn werklast, JS probeerden bij te leren, leek het weinig uit te maken.
Wanneer hij zich probeerde te focussen op de HTML en CSS (JS was te moeilijk), deed hij goedwerkende functionaliteiten in het honderd lopen.




## Klassendiagram

cfr. class_diagram_howestStone.pdf

## SQL Database-schema

cfr SQLDatabaseScheme.htm

##Starten van het spel

###Frontend
In u geliefde editor start u het HTML bestand '0_welcomeScreen.html'. Als we ons werk goed gedaan hebben,
dient de GUI intuitief genoeg te zijn om vanaf hier al geen verdere instructies te voorzien voor de start van het spel ;).

###Backend
Voor de backend te laten werken dient u simpelweg de mooie JAVALIN server op te starten. Zorg er dus voor dat u de klasse Server
(in de _package_ **initialize**, onder API; waarbij API onder playfield terug te vinden is) start: de JAVALIN server zal nu actief worden!
Het belangrijk in het achterhoofd te houden dat deze stap eerst moet genomen worden voor u het frontendbestand zou willen aanspreken.

###JAVA CLI
Voor de CLI dient u de klasse CLI in de package playfield op te starten: hierna krijgt u het bericht dat het u beurt is om een bepaalde zet te doen.
Wanneer u niet weet hoe u een beurt moet spelen, en dus bijgevolg een fout commando intypt, zal de CLI bericht geven van alle mogelijke commando's.
Hierbij hebben we gelet op de naamgeving zodat de naam op zich boekdelen spreekt over de functionaliteit van het commando.

##noten en addenda

### acties spelbord

Per actie die uitgevoerd wordt op het spelbord aan de frontend zijde sturen de hele
game state door naar de backend. Wanneer bevoorbeeld aan de minions wat veranderd wordt,
het boosten van de aanvalswaarde, dan wordt de hele lijst met minions teruggestuurd.
Indien het tijdsschema ons toeliet zouden we een efficiëntere manier implementeren, waarbij
alle speldbordfunctionaliteiten dubbel worden gemaakt. Hierdoor zou de gebruikerskant van
het spel minder belast worden en het spel vlotter werken d.m.v. directe feedback. Ook
zou de communicatie tussen cliënt en server beter verlopen omdat dan enkel hetgeen wat
nodig is wordt doorgestuurd. Zo wordt de gebruikte bandbreedte voor die communicatie beperkt.


### CLI en spelbord frontend

De CLI kan veel meer dan de werking van de applicatie via user input aan de frontend.
We kwamen niet tot de implementatie voor het opslaan van het spel aan de frontendzijde,
hoewel we van mening zijn dat mits enige moeite het opgeslagen spel kan worden voortgezet
aan de JAVA CLI applicatie.


### werking magische kaarten

De klasse Conditions en onderdaan in de GameCLI (en de benodigde _fields_ in de klasse CardSpell)
staan methodes geschreven die een begin vormen van de implementatie van de magische kaarten.
Naast de database die helemaal klaar staat voor het aanspreken van die kaarten, bestaat er dus
al een soort van basis in de JAVA voor deze functionaliteit.
U zal merken dat de in commentaar gezette code nog heel wat fouten verscholen zitten. Wegens tijdgebrek
en veranderende prioriteiten konden we die niet meer oplossen.


###addenda
* De _ability_ methodes staan verspreid en hadden die graag overzichtelijker gemaakt
* We hadden ook graag betere testen geschreven die ook de core functionaliteiten van het spel
onder de loep nemen
* Voor de kaarten opteerden we liever voor nettere en duidelijkere constructors dan de monsters die
het nu geworden zijn
* De hero klasse en alle kaarten als subklasse van de interface Attackable die dan een methode _takeDamage_
zodat de switch met alle mogelijkheden geen objecten teruggeeft (lelijke code), maar _Attackables_ (overzichtelijkere code).
