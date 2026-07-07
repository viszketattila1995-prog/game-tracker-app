# Game Tracker App

Egy full-stack játékkövető alkalmazás: Spring Boot REST backend + Angular frontend.
A full-stack game tracking application: Spring Boot REST backend + Angular frontend.

A felhasználók platformokat és játékokat tarthatnak nyilván, minden játék egy
platformhoz tartozik, és követhető az állapota (kívánságlista, folyamatban, befejezett, elhagyott).
Users can track platforms and games; each game belongs to a platform and has a
status (wishlist, playing, completed, dropped).

---

## Magyar

### Technológiák

- Java + Spring Boot (REST API)
- Spring Data JPA
- MySQL adatbázis
- Angular frontend
- Bootstrap (navbar és stílus)
- Logback logger
- Maven build

### Funkciók

- **Platform létrehozása** – új platform felvétele (egyedi név, gyártó).
- **Játék felvétele** – új játék hozzáadása és platformhoz rendelése, státusszal.
- **Játékok listája** – az összes játék kártyás nézetben, `addedAt` szerint csökkenő sorrendben, státusz szerint színezett badge-ekkel.
- **Játék részletei** – egy játék teljes adatlapja, formázott dátummal.
- **Összesítő oldal** – platformonkénti kimutatás: összes és befejezett játékok száma.

### Adatmodell

**Platform**
- `name` (String, kötelező, egyedi)
- `manufacturer` (String, kötelező) – pl. Sony, Microsoft, Nintendo, PC

**Game**
- `title` (String, kötelező)
- `developer` (String, kötelező) – a fejlesztő stúdió
- `releaseYear` (Integer, kötelező) – 1970 és 2030 között
- `platform` (Platform, kötelező) – legördülő listából
- `status` (Enum, kötelező) – WISHLIST, PLAYING, COMPLETED, DROPPED
- `coverUrl` (String, opcionális) – borítókép URL-je
- `addedAt` (LocalDateTime) – a szerver állítja be

### Projekt felépítése

```
backend/    Spring Boot REST API (JPA, MySQL, Logback)
frontend/   Angular alkalmazás (Bootstrap)
```

### Indítás

**Adatbázis:** hozz létre egy MySQL adatbázist, és állítsd be a kapcsolatot az
`application.properties` fájlban (URL, felhasználónév, jelszó).

**Backend:**
```bash
cd backend
mvn spring-boot:run
```

**Frontend:**
```bash
cd frontend
npm install
ng serve
```

Ezután a frontend a `http://localhost:4200`, a backend a `http://localhost:8080` címen érhető el.

### Megjegyzések

- A státuszok színezése: COMPLETED = zöld, PLAYING = kék, DROPPED = piros, WISHLIST = szürke.
- Az adatátvitel DTO-kon keresztül történik.
- Nincs szerkesztés, törlés, felhasználókezelés vagy bejelentkezés (a specifikáció szerint).

---

## English

### Tech stack

- Java + Spring Boot (REST API)
- Spring Data JPA
- MySQL database
- Angular frontend
- Bootstrap (navbar and styling)
- Logback logger
- Maven build

### Features

- **Create platform** – add a new platform (unique name, manufacturer).
- **Add game** – add a new game and assign it to a platform, with a status.
- **Game list** – all games in a card view, sorted by `addedAt` descending, with status-colored badges.
- **Game details** – a full detail page for a game, with a formatted date.
- **Summary page** – per-platform breakdown: total and completed game counts.

### Data model

**Platform**
- `name` (String, required, unique)
- `manufacturer` (String, required) – e.g. Sony, Microsoft, Nintendo, PC

**Game**
- `title` (String, required)
- `developer` (String, required) – the developer studio
- `releaseYear` (Integer, required) – between 1970 and 2030
- `platform` (Platform, required) – selected from a dropdown
- `status` (Enum, required) – WISHLIST, PLAYING, COMPLETED, DROPPED
- `coverUrl` (String, optional) – cover image URL
- `addedAt` (LocalDateTime) – set by the server

### Project structure

```
backend/    Spring Boot REST API (JPA, MySQL, Logback)
frontend/   Angular application (Bootstrap)
```

### Running

**Database:** create a MySQL database and configure the connection in
`application.properties` (URL, username, password).

**Backend:**
```bash
cd backend
mvn spring-boot:run
```

**Frontend:**
```bash
cd frontend
npm install
ng serve
```

The frontend runs at `http://localhost:4200` and the backend at `http://localhost:8080`.

### Notes

- Status colors: COMPLETED = green, PLAYING = blue, DROPPED = red, WISHLIST = grey.
- Data transfer uses DTOs.
- No editing, deletion, user management or authentication (per the specification).

---

Built as a full-stack practice project: Spring Boot REST, JPA, an Angular frontend and Bootstrap styling.
