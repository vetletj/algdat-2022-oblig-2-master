# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
* Sondre Trodahl, S351957, s351957@oslomet.no
* Georg Barlindhaug Ellingsen, s348655, s348655@oslomet.no
* Vetle Tønsberg Johansen, S341540, s341540@oslomet.no

# Arbeidsfordeling

I oppgaven har vi hatt følgende arbeidsfordeling: // Her bør vi plukke oppgaver stigende og kikke på de foregående virker det som.

* Georg har hatt hovedansvar for oppgavene: 1,  3,  7. 
* Vetle har hatt hovedansvar for oppgavene: 2,  8,  9. 
* Sondre   har hatt hovedansvar for oppgave 4,  5,  6. 
* Vi har i fellesskap løst oppgave 10. 


# Oppgavebeskrivelse

### Oppgave 1
I oppgave 1 brukte jeg masse tid på å knote. Skjønte vel egentlig ingenting de første dagene.
antall(): Siden dette er en variabel som vi skal oppdatere i de ulike funksjonene var det bare å returnere verdien.
tom(): her fikk jeg brukt den metoden som ble vist i forelesning med return (a>b) ? x : y; // Snedig.
konstruktør tom : Her forstod jeg det som at vi bare skulle initiere tomme verdier.
konstruktør liste : Her begynte morroa og jeg gikk selvfølgelig i fella med å bruke leggInn() først, før jeg leste hele oppgaven på nytt.

For å unngå å spørre potensielt hundrevis av ganger om listen har hode og hale, gjøres det i små while looper initielt.
Ville egentlig brukt en for loop på nederste biten, men (i python kan du følge opp en for loop med "else" om den ikke har noen range) da fikk jeg ikke fanget opp (på en elegant måte) om rangen var lik 0, så ble nok en while loop der.

### Oppgave 2
I oppgave 2a metoden toString() så brukte jeg en stringBuilder som spesifisert i oppgavetekst for å sette sammen generisk data til en string.
Brukte tom() metoden som allerede var programmert opp i DobbeltLenketListe for å sjekke om listen var tom, i disse tilfellene blir en midlertidig node 
som kopierer hode noden laget og vi legger til verdien til denne midlertidig noden i stringBuilder med append metoden. Deretter peker vi midlertidig node 
til neste node i listen og går inn i en while loop som kjører helt fram til midlertidig node har vedi null (som betyr at vi har nådd slutten av listen). 
omvendtString fungerer på nesten akkurat samme måte, det er kun to forskjeller og det er at istedendfor å lage en midlertidig node av hode så lager jeg
den av hale, og istedenfor å gå til neste node går jeg til forrige. 

I oppgave 2b sjekker jeg først om bruker prøver å legge inn en null verdi, dette utføres med requireNonNull-metode beskrevet i oppgavetekst. 
Deretter lager jeg en ny node med verdien vi vil legge inn i liste, sjekker så for to tilfeller; 1. om listen allerede er tom og 2. om den ikke er det. 
For tilfelle 1 setter vi hode lik ny node. For tilfelle 2 endrer vi neste peker for "gammel" hale til ny node og forrige peker til nye noden til hale.
Til slutt, for begge tilfeller, setter vi hale lik ny node og inkrementerer variable antall og endringer med en. 

### Oppgave 3
I oppgave 3 [georg ikke glem å fylle ut denne]

### Oppgave 4 
Oppgave 4 besto av både int indeksTil og boolean inneholder. 
I indeksTil brukte jeg en testnode som startet i hodet. Ved hjelp
av en for løkke går vi gjennom hele listen til vi finner verdien eller slutten av listen.
Dersom verdien er funnet returnerer vi indeksen dens, om ikke returnerer vi -1.

I inneholder bruker vi bare indekstil for å finne indeks til verdien
om den finnes i lista. Dersom returnert int er større enn eller lik 0 vet vi at 
listen inneholder verdien. 

### Oppgave 5
Her sjekker vi først for diverse exceptions. Vi passer på at verdi ikke er null og at indeksen er lovlig.
Deretter bruker vi if statements til å finne ut hvilket av følgende tifleller vi har:
verdien skal plasseres i en tom liste, verdien skal plasseres i hodenode, verdien skal
plasseres i halenode eller verdien skal plasseres tilfeldlig sted som ikke er hale eller hode. 
Deretter plasserer vi den og oppdaterer noder foran og bak slik at pekere stemmer.

### Oppgave 6
Public boolean fjern: Jeg prøvde først å bruke en for løkke til å finne verdi i listen, men dette ble bare tull.
Lånte derfor fremgangsmåten med en while løkke fra kompendiet. Deretter oppdaterer jeg forrige og neste node
slik at noden vi vil slette blir "slettet" Returnerer true om fjernet og false om ikke fjernet. 

Public T fjern: Så og si en kopi av boolean fjern, men sjekker her at indeksen er godkjent før vi finner ut
hvilket tilfelle man har og ved hjelp av if statements. Oppdaterer forrige og neste node slik at noden vi ønsker
å slette blir slettet. 


### Oppgave 8
I oppgave 8 a, b & d har jeg egentlig bare fulgt oppgavebeskrivelsene steg for steg. I deloppgave c satt jeg først denne noden til hode og anvende deretter en for-løkke
til å gå igjennom neste pekerne fram til vi nådde gitt indeks. Resten er copy-pase fra konstruktøren som var ferdig kodet.

