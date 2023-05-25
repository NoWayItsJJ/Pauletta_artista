# Pauletta - Artista di strada

## Consegna
Un artista da strada esegue delle caricature e dei ritratti a carboncino. Chi vuole un ritratto si siede in una delle quattro sedie messe a disposizione e attende il suo turno per spostarsi nella zona di lavoro dove farsi fare il ritratto. Le persone intorno arrivano continuamente e guardano incuriosite, attendendo che una delle quattro sedie si liberi per potersi mettere in attesa del ritratto. Tuttavia, le persone che aspettano per troppo tempo una sedia libera (stabilire un tempo predefinito all’inizio del programma) rinunciano a farsi fare il ritratto. Simulare questa situazione utilizzando i semafori come meccanismo di sincronizzazione tra i processi. In particolare, tenere presente che:
 - all’inizio non c’è nessun cliente
 - i clienti arrivano in numero e a istanti di tempo casuali
 - l’artista non impiega sempre lo stesso tempo per eseguire un ritratto


## Algoritmo

1. All'avvio del programma vengono creati 2 semafori nella classe `artista`:
    - `semaforoArtista`: semaforo mutex che permette un solo ritratto alla volta. 
    - `semaforoSedie`: semaforo a conteggio che gestisce l'occupazione delle sedie in base alla variabile `buffer`.

2. I clienti vengono istanziati come thread e si metteranno in attesa aspettando di acquisire una sedia con il metodo `tryAcquire()` del semaforo `semaforoSedie`. Dopo uno specifico periodo di tempo (`tempoattesaMax`) passato ad aspettare il cliente rinuncierà e andrà via.

3. Se un cliente riesce ad acquisire un posto in una delle sedie aspetterà di fare il proprio ritratto. Questa coda viene gestita dal semaforo `semaforoArtista` attraverso il suo metodo `tryAcquire()`.

4. Al termine del ritratto il cliente interessato se ne andrà liberando il `semaforoArtista` e 1 posto del `semaforoSedie`.

## Variabili

- La dimensione del buffer di sedie può essere modificato tramite la costante `buffer` nella classe `artista`.

- Il tempo massimo di attesa può essere modificato attraverso la costante `tempoAttesaMax` nella classe `artista`.

- Il numero di clienti può essere personalizzato modificando la generazione casuale nella classe `artista`.

- Il tempo impiegato per il singolo ritratto può essere modificato tramite la generazione casuale nella classe `cliente` nel metodo `ritratto()`.
