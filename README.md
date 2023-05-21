### Programare avansată pe obiecte :alien:

# Proiect Smart City - partea 1

Proiectul Smart City are ca scop crearea unei platforme care să ofere posibilitatea cetățenilor de a achiziționa bilete la muzeu sau pentru mijloacele de transport. 
În același timp, utilizatorii pot vedea detalii despre muzee cu expozițiile și exponatele acestora.

## Cuprins
- [Clase](#clase)
- [Enum-uri](#enum-uri)
- [Excepții](#excepții)
- [Funcții](#funcții)
- [Fluxul de testare](#fluxul-de-testare)

## Clase

Pentru a implementa acest proiect, am definit mai multe clase:

- Utilizator
- Bilet
  - BiletTransport
  - BiletMuzeu
- MijlocDeTransport
- Muzeu
- Expozitie
- Exponat

Am definit și câteva clase service pentru a manipula obiectele din proiect. Aceste clase se ocupă cu adăugarea, ștergerea și actualizarea obiectelor. Clasele service 
sunt:
- BiletServiceImpl
- UtilizatorServiceImpl
- MijlocDeTransportServiceImpl
- MuzeuServiceImpl
- ExponatServiceImpl
- ExpozitieServiceImpl 


Clasa Utilizator reprezintă un utilizator al platformei, care poate cumpăra bilete sau vizualiza informații despre muzee și expoziții. Clasa Muzeu este reprezentată 
de un muzeu care conține mai multe expoziții. Fiecare expoziție poate avea mai multe exponate, care sunt reprezentate de clasa Exponat.

Clasa Bilet este o clasă abstractă din care vor fi derivate clasele BiletMuzeu și BiletTransport. BiletMuzeu reprezintă un bilet achiziționat pentru a vizita muzeul, 
în timp ce Biletul Transport reprezintă un bilet achiziționat pentru a călători cu un mijloc de transport.

## Enum-uri

Am definit și câteva enum-uri, cum ar fi InstitutiiEmitere (care specifică ce instituție a emis biletul - STB, METROREX, DPCN, IJC), TipTransport (care 
specifică tipul mijlocului de transport, cum ar fi autobuz, tramvai sau metrou). Acestea se regăsesc în pachetul Utile.

## Excepții

Am inclus și câteva excepții, cum ar fi NuEsteUtilizatorulException (aruncată atunci când un utilizator nu există), InvalidCNPException (aruncată atunci când un CNP 
nu este valid - nu reprezintă un șir de 13 cifre) sau InvalidPretBiletException (aruncată atunci când prețul biletului este mai mic sau egal cu 0), etc.

## Funcții

Pentru a asigura integritatea datelor și pentru a evita introducerea unor date invalide, am inclus și câteva funcții de validare. Aceste funcții se află în pachetul 
Validari și verifică dacă obiectele sunt valide înainte de a fi adăugate.

În pachetul Service, în cadrul fiecărei clase sunt funcții care se ocupă de manipularea obiectelor de tipul respectiv. 

## Fluxul de testare

Pentru a testa funcționalitățile, am definit obiecte de tipul claselor din pachetul Service.Impl. Ulterior, mi-am definit un număr de obiecte de tip Utilizator, 
Exponat, Expoziție, Muzeu, BiletMuzeu, BiletTransport, MijlocDeTransport. Folosindu-mă de funcțiile implementate în clasele din Service, am construit liste în care 
am adăugat obiectele create anterior, pe care le-am și afișat ulterior. 
``` Java
exponateService1.addExponat(exponatVG1);
List<Exponat> exponate1 = exponateService1.getExponat();

expozitieService.addExpozitie(expozitie1);
Set<Expozitie> expozitiiMuzeu1 = expozitieService.getExpozitie();

muzeuService.addMuzeu(muzeu);
List<Muzeu> muzee = muzeuService.getMuzeu();
 
utilizatorService.addUtilizator(utilizator1);
System.out.println(utilizatorService.getUtilizatori());

mijlocDeTransportService.addMijlocDeTransport(mijlocDeTransport);
System.out.println(mijlocDeTransportService.getMijlocDeTransport());

biletService.addBilet(biletT1);
List<Bilet> bilete1 = biletService.getBilet();
```

Ulterior, m-am folosit de funcții pentru:
- validarea biletelor (se verifică dacă biletul mai este valabil în funcție de tipul biletului; Pentru autobuz valabilitatea este de 90 de minute, pe când pentru 
biletul de muzeu, valabilitatea este o zi)
```Java
System.out.println(bilet.esteValabil() ? "Biletul este valid" : "Biletul a expirat");
```
- detalii bilete (se afișează desfășurat detaliile unui bilet)
```Java
bilet.detaliiBilet();
```
- calculul prețului total al biletelor (se calculează suma totală plătită pentru achiziționarea biletelor)
```Java
System.out.println(biletService.pretTotalBilete() + " lei");
```
- obținerea unui utilizator după numele și prenumele acestuia 
```Java
System.out.println(utilizatorService.getUtilizator("Clem", "Daria"));
```
- ștergerea unui utilizator după numele și prenumele acestuia
```Java
utilizatorService.deleteUtilizator("Clem", "Ferguson");
```
- ștergerea unui utilizator dat ca obiect
```Java
utilizatorService.deleteUtilizator(utilizator2);
```

De asemenea, se pot folosi setterii și getterii specifici fiecărei clase pentru a prelucra datele.
