package no.oslomet.cs.algdat.Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;


public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() // Dette er konstruktøren vår for å opprette ny tom liste, så det er her vi "produserer" fra blueprints.
    {
        hode = null;
        hale = null;
        antall = 0;
        endringer = 0;
    }

    public DobbeltLenketListe(T[] a) // Er dette da konstruktøren for å endre lister? Vanskelig dette...
    {
        Objects.requireNonNull(a, "Tabellen a er null!");
        hode = null;
        hale = null;
        int i = 0;

        // Finner første verdi som ikke er null, og setter denne til head.
        while (hode == null && i < a.length)
        {
            if (a[i] != null)
            {
                hode = hale = new Node<>(a[i], null, null);
                antall++;
            }
            i++;
        }
        // Finner neste verdi som ikke er null, og setter denne til hale.
        while (hale == hode && i < a.length)
        {
            if (a[i] != null)
            {
                hale = new Node<>(a[i], hode, null);
                hode.neste = hale;
                antall++;
            }
            i++;
        }
        while (i < a.length)
        {
            if (a[i] != null)
            {
                hale = hale.neste = new Node<>(a[i],hale,null); // er spent på om forrige rakk å bli til neste før den pekte, ellers peker den på seg selv...
                antall++;
            }
            i++;
        }


    }


        //for (T value : a) if (value != null) leggInn(value); // Får vente med denne til en annen anledning



    public Liste<T> subliste(int fra, int til) {
        throw new UnsupportedOperationException();
    }

    /**
     * @antall er en variabel vi oppdaterer i funksjonene:
     * @tom() returnerer true hvis liste er tom og false hvis den ikke er det
     * @leggInn() øker antall
     * @fjern() senker antall
     * @nullstill() nullstiller antall
     * @return verdien til antall.
    */
    @Override
    public int antall() {

        return antall;
    }

    /**
     * @return true om antall er lik 0
     */
    @Override
    public boolean tom() {
        return (antall == 0) ? true : false;
    }

    /**
     *
     * @param verdi blir lagt inn bakerst i listen
     * @return true om alt er greit
     */
    @Override
    public boolean leggInn(T verdi) {
        Objects.requireNonNull(verdi); // Null-verdi er ikke tillatt å legge til, kontrollerer derfor med requireNonNull-metode fra klassen Objects
        Node<T> nyNode = new Node<>(verdi, null, null); // Lager ny node, med ny verdi, som skal legges inn bakerst i listen (peker ingen steder enda)

        if (tom() & hale == null & hode == null) { // Tilfelle 1 - listen er på forhånd tom
            hode = nyNode; // Ettersom listen er tom vil nye noden og hode være samme
        }

        else { // Tilfelle 2 - listen er ikke tom så vi oppdaterer kun hale ettersom vi legger til ny node bakerst i liste
            hale.neste = nyNode; // gamle hale skal peke på ny hale
            nyNode.forrige = hale; // ny hale må peke tilbake på gammel hale
        }

        hale = nyNode; // I begge tilfeller vil hale være nye noden da vi skal legge den inn bakerst

        antall++; // Inkrementerer antall ettersom vi får en ekstra node i listen
        endringer++; // Inkrementerer endringer ettersom vi har utført en endring i listen

        return true;
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean inneholder(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T hent(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indeksTil(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // Vanlig concatination for generiske verdier. Trenger ikke sette capacity da stringBuilder justerer seg selv hvis vi går over
        sb.append('['); // Alle lister, uansett om den er tom, skal stare med klammeparantes ( [ )

        if (!tom()) {
            Node<T> tempNode = hode; // Lager ny midlertidig node class med generisk veri og setter den til hode noden i vår doblet lenket liste
            sb.append(tempNode.verdi); // Setter første verdi fra dobbelLenketListe inn i stringBuilder
            tempNode = tempNode.neste; // Går vidre til neste node i liste

            while (tempNode != null) { // Sjekker om det er enden av listen, hvis ikke fortsetter vi å legge til verdiene til nodene i sb
                sb.append(", " + tempNode.verdi); // Legger til node data i string sb
                tempNode = tempNode.neste; // Går vidre til neste node
            }
        }
        sb.append(']'); // Vi kom til enden av listen og legger da til klammeparantes for å lukke liste
        return sb.toString(); // Returnerer hele stringen
        //throw new UnsupportedOperationException();
    }

    public String omvendtString() {
        StringBuilder sb = new StringBuilder(); // Vanlig concatination for generiske verdier. Trenger ikke sette capacity da stringBuilder justerer seg selv hvis vi går over
        sb.append('['); // Alle lister, uansett om den er tom, skal stare med klammeparantes ( [ )

        if (!tom()) {
            Node<T> tempNode = hale; // Lager ny midlertidig node class med generisk veri og setter den til hale noden i vår doblet lenket liste
            sb.append(tempNode.verdi); // Setter første verdi fra dobbelLenketListe inn i stringBuilder
            tempNode = tempNode.forrige; // Går bakover til forrige node i liste

            while (tempNode != null) { // Sjekker om det er starten av listen, hvis ikke fortsetter vi å legge til verdiene til nodene i sb
                sb.append(", " + tempNode.verdi); // Legger til node data i string sb
                tempNode = tempNode.forrige; // Går bakover til forrige node
            }
        }
        sb.append(']'); // Vi kom til starten av listen og legger da til klammeparantes for å lukke liste
        return sb.toString(); // Returnerer hele stringen
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

} // class DobbeltLenketListe


