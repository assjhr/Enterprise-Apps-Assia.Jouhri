# Enterprise Apps - NGO Anderlecht Website

## Project Informatie
- **Student:** Assia Jouhri
- **Project:** Enterprise Applications - Prototype NGO Website

## Gebruikte Libraries en Frameworks
- **Spring Boot 3.5.0** - Framework voor Java enterprise applicaties
- **Spring Web MVC** - Voor het afhandelen van HTTP requests
- **Spring Data JPA** - Voor database toegang en ORM
- **Spring Boot Starter Validation** - Voor form validatie
- **Spring Boot Starter Mail** - Voor email versturen
- **Thymeleaf** - Template engine voor dynamische HTML pagina's
- **MySQL Connector** - Database driver voor MySQL
- **Tailwind CSS** - CSS framework voor styling (via CDN)
- **Mailtrap.io** - Service voor het testen van email versturen

## Documentatie en Tutorials
- **Spring Boot Official Documentation:** https://spring.io/projects/spring-boot
- **Thymeleaf Documentation:** https://www.thymeleaf.org/documentation.html
- **Spring Data JPA:** https://spring.io/projects/spring-data-jpa
- **Tailwind CSS:** https://tailwindcss.com/docs
- **Mailtrap.io Documentation:** https://mailtrap.io/blog/send-email-in-spring-boot/
- **Baeldung Spring Boot Tutorials:** https://www.baeldung.com/spring-boot

## AI Chat Geschiedenis
Dit project is voornamelijk ontwikkeld aan de hand van de cursusmateriaal op Canvas. AI-assistentie is beperkt gebruikt voor het opzetten van de projectstructuur en het debuggen van enkele problemen.

## Manual - Project Uitvoeren

### Vereisten
1. **Java 25** of hoger geïnstalleerd
2. **MySQL** database server draaiend
3. **Gradle** (inbegrepen in het project via gradlew)
4. **Mailtrap.io account** voor email testing

### Stap 1: Database Opzetten
```sql
CREATE DATABASE ngo_events;
```

### Stap 2: Mailtrap.io Configureren
1. Ga naar https://mailtrap.io en maak een account aan
2. Maak een nieuwe inbox aan
3. Kopieer je SMTP credentials (username en password)
4. Open `src/main/resources/application.properties`
5. Vervang `YOUR_MAILTRAP_USERNAME` en `YOUR_MAILTRAP_PASSWORD` met je credentials

### Stap 3: Project Bouwen en Starten
```bash
./gradlew bootRun
```

### Stap 4: Applicatie Gebruiken
Open je browser en ga naar: http://localhost:8080

### Pagina's
- **Index (/)** - Overzicht van laatste 10 evenementen
- **New (/new)** - Nieuw evenement toevoegen
- **Details (/details/{id})** - Details van een specifiek evenement
- **About (/about)** - Informatie over de NGO
- **Contact (/contact)** - Contactformulier

## Project Structuur
```
src/main/java/com/example/entrapps/
├── controller/
│   └── EventController.java
├── model/
│   ├── Event.java
│   ├── Locatie.java
│   └── ContactMessage.java
├── repository/
│   ├── EventRepository.java
│   └── LocatieRepository.java
├── service/
│   └── MailService.java
└── EntrAppsApplication.java

src/main/resources/
├── templates/
│   ├── fragments/
│   │   └── layout.html
│   ├── index.html
│   ├── new.html
│   ├── details.html
│   ├── about.html
│   └── contact.html
└── application.properties
```

## Functionaliteit
- Evenementen bekijken (laatste 10)
- Nieuwe evenementen toevoegen met validatie
- Details van evenementen bekijken
- Contactformulier met email versturen
- Responsive design met Tailwind CSS
- Herbruikbare menu en footer via Thymeleaf fragments

## Opmerkingen
- Zorg dat MySQL draait voordat je de applicatie start
- De database tabellen worden automatisch aangemaakt door Hibernate
- Emails worden via mailtrap.io fictief verstuurd (komen niet echt aan)
