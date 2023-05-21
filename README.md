### Programare avansată pe obiecte :alien:

# Proiect Smart City - partea 3

Proiectul Smart City are ca scop crearea unei platforme care să ofere posibilitatea cetățenilor de a achiziționa bilete la muzeu sau pentru mijloacele de transport. 
În același timp, utilizatorii pot vedea detalii despre muzee cu expozițiile și exponatele acestora.

### Persistența datelor folosind JDBC

În partea a 3-a a proiectului am înlocuit serviciile realizate în etapa a 2-a cu servicii care să asigure persistența datelor folosind JDBC. Serviciile oferă operații de tip CRUD (create, read, update, delete) pentru clasele User, Museum, Exhibition, Exhibit. 

Pentru implementarea acestei cerințe am creat un pachet denumit **Constants** unde am definit 4 clase numite UsersConstants, MuseumsConstants, ExhibitionsConstants, ExhibitsConstants. În fiecare dintre acestea sunt query-uri de prelucrare a datelor din baza de date specifice clasei respective.

- exemplu pentru clasa User
```Java
public static final String QUERY_CREATE_USER = "insert into smartcity.user (lastName, firstName, CNP, address) values (?, ?, ?, ?)";
```

În cadrul pachetului **Repositories** am definit 4 clase numite UserRepository, MuseumRepository, ExhibitionRepository, ExhibitRepository. În cadrul acestora sunt funcții ce integrează operațiile CRUD. Se va folosi clasa Exhibition pentru exemplificarea funcțiilor.
- funcție de adăugare a unei înregistrări în baza de date, având ca parametru un obiect
```Java
public int addExhibition(Exhibition exhibition)
```
- funcție de adăugare a unei înregistrări în baza de date, având ca parametrii diferite date specifice obiectului
```Java
public int addExhibition(String name, Date startDate, Date endDate, int museumId)
```
- funcție de extragere a tuturor înregistrărilor dintr-un anumit tabel
```Java
public List<Exhibition> getAllExhibitions()
```
- funcție de extragere a unei înregistrări pe baza id-ului
```Java
public Exhibition getExhibition(int id)
```
- funcție de extragere a unei înregistrări pe baza numelui
```Java
public List<Exhibition> getExhibition(String name)
```
- funcție de editare a unei înregistrări, având ca parametrii string-uri cu numele proprietății ce se dorește a fi editată, noua valoare, criteriul de selectare a înregistrării și valoarea criteriului
```Java
public void editExhibition(String property, String newValue, String criterion, String value)
```
- funcție de ștergere a tuturor înregistrărilor dintr-un anumit tabel
```Java
public void deleteAllExhibitions()
```
- funcție de ștergere a unei înregistrări pe baza id-ului
```Java
public void deleteExhibition(int id) 
```
- funcție de ștergere a unei înregistrări pe baza numelui
```Java
public void deleteExhibition(String name)
```

Funcțiile definite în pachetul Repositories sunt apelate în cadrul claselor din pachetul **Service**. Funcțiile au același nume, dar în plus tratează erori ce pot apărea la executarea query-urilor.  
