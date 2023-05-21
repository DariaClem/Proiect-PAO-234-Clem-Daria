### Programare avansată pe obiecte :alien:

# Proiect Smart City - partea 2

Proiectul Smart City are ca scop crearea unei platforme care să ofere posibilitatea cetățenilor de a achiziționa bilete la muzeu sau pentru mijloacele de transport. 
În același timp, utilizatorii pot vedea detalii despre muzee cu expozițiile și exponatele acestora.

## Cuprins
- [Fișiere CSV](#1-fișiere-csv)
- [Serviciu audit](#2-serviciu-audit)
- [Alte îmbunătățiri](#alte-îmbunătățiri)

## 1. Fișiere CSV

În partea a doua a proiectului am asigurat persistența datelor utilizând fișiere CSV pentru 4 clase și anume clasele User, Museum, Exhibition, Exhibit. Am scris date specifice pentru crearea obiectelor în fișierele users.csv, museums.csv, exhibitions.csv și exhibits.csv din folderul CSVFiles. Ulterior, după prelucrarea datelor am afișat în fișierul test.csv obiectele create.

În pachetul Utils am creat un enum numit FileManagementSingleton. Am ales să utilizez enum-ul pentru a implementa caracteristica de singleton, deoarece reprezintă o opțiune eficientă și sigură pentru a asigura existența unei singure instanțe a unei clase. În cadrul acesteia am redactat 3 funcții principale:
- readFromCsv - funcția primește ca parametru numele fișierului CSV din care trebuie să citească datele și returnează o listă de liste de String-uri
```Java
public List<String[]> readFromCsv(String fileName)
```

- writeInCsv - funcția primește ca parametru numele fișierului CSV în care urmează să scrie și o listă de liste de String-uri cu conținutul de afișat
```Java
public void writeInCsv(String fileName, List<String[]> content)
```

- writeInCsv - funcția primește ca parametru numele fișierului CSV în care urmează să scrie și un String cu conținutul de afișat
```Java
public void writeInCsv(String fileName, String content)
```

## 2. Serviciu audit

În pachetul Utils am creat un enum numit AuditSingleton, în cadrul căruia este implementată funcția writeAction. Aceasta este apelată în cadrul fiecărei funcții definite în prima etapă și scrie în fișierul audit.csv numele acțiunii și momentul când a fost realizată. 
- antetul funcției
```Java
public void writeAction(String actionName)
```
- exemplu de apelare a funcției
```Java
AuditSingleton.INSTANCE.writeAction("Add user");
```
- exemplu de afișare
```Java
Add user,19-05-2023 09:05
```

## Alte îmbunătățiri

Față de prima parte a proiectului, am uniformizat codul prin schimbarea tuturor denumirilor variabilelor, funcțiilor, claselor și pachetelor în engleză. De asemenea, am adăugat funcții noi în Service-uri pentru a putea returna un obiect în funcție de id-ul acestora, întrucât am adăugat tutoror claselor data membră „id” și id-ul obiectului de care aparțin (de exemplu, un exponat are un id propriu și un id al expoziției de care aparține). În final, am extins și pachetul Exceptions cu noi excepții.
