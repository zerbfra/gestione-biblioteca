# gestione-biblioteca
Progetto corso di Ingegneria del software, Laurea Triennale

_Il progetto è estramamente didattico e ben documentato, utile per progetti Java delle lauree triennali in informatica o ingegneria informatica_

_Ho deciso di renderlo pubblico molto più tardi rispetto alla sua creazione quindi ad oggi potrebbe contenere anche codice deprecato. In ogni caso, per l'utilizzo in classe/distribuzione come demo menzionare l'autore originale e questo repository_

## Ambito di validità
Il fine principale del software è la gestione di una biblioteca, agevolando la fase di amministrazione e quella di prestito dei libri da parte degli utenti della biblioteca.
Si farà riferimento a una singola biblioteca, contenente un numero variabile di libri e di utenti, ogni libro in singola copia.
Vi saranno utenti amministratori (che avranno privilegi e accesso ai pannelli di gestione della biblioteca) e clienti in grado di consultare i libri disponibili e gestirne il prelievo e la restituzione in modo autonomo.
Si suppone che la biblioteca disponga di un singolo volume per ogni libro archiviato nel sistema, quindi quando un cliente preleva un libro questo diventa automaticamente non più disponibile per gli altri utenti.
Il prestito avviene secondo le seguenti modalità:
Un utente può prendere in prestito un numero non precisato di libri
Al momento dell’inserimento del prestito l’utente ha tempo 30 giorni per restituire il libro Nel sistema si tiene traccia dei seguenti dati:

* Data inizio prestito
* Data fine prestito “teorica”
* Data restituzione effettiva

# Funzioni principali del software

Il pacchetto si suddivide in due moduli.

La parte “amministrativa” a uso dell’utente amministratore e la parte “Catalogo” a disposizione dell’utente cliente della biblioteca.

Parte amministrativa:
- Gestione Utenti
- Inserimento utente
- Elenco utenti
- Ricerca utenti
- Gestione Libri
- Inserimento libro
- Elenco libri
- Ricerca libri
- Gestione Prestiti
- Ricerca prestiti per utente
- Ricerca prestiti per libro


Catalogo utenti:

- Catalogo
- Sfoglia nel catalogo
- Prestito di un libro
- Visualizzazione informazioni libri
- Ricerca nel catalogo
- Prestiti
- Elenco prestiti in corso
- Cronologia prestiti passati
- Restituzione libro
