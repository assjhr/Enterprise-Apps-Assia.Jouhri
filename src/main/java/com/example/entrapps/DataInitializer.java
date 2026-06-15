package com.example.entrapps;

import com.example.entrapps.model.Event;
import com.example.entrapps.model.Locatie;
import com.example.entrapps.repository.EventRepository;
import com.example.entrapps.repository.LocatieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private LocatieRepository locatieRepository;

    @Autowired
    private EventRepository eventRepository;

    @Override
    public void run(String... args) {
        if (locatieRepository.count() == 0) {
            Locatie l1 = locatieRepository.save(new Locatie("Gemeenschapscentrum De Kriekelaar", "Joseph Kaeckelstraat 1, 1070 Anderlecht", 200));
            Locatie l2 = locatieRepository.save(new Locatie("CC Anderlecht", "Anderlechtsesteenweg 519, 1070 Anderlecht", 150));
            Locatie l3 = locatieRepository.save(new Locatie("Huis van het Kind", "Kuregemstraat 51, 1070 Anderlecht", 80));
            Locatie l4 = locatieRepository.save(new Locatie("Bibliotheek Anderlecht", "Anderlechtsesteenweg 294, 1070 Anderlecht", 50));
            Locatie l5 = locatieRepository.save(new Locatie("Park van Anderlecht", "Paul-Henri Spaaklaan, 1070 Anderlecht", 500));

            eventRepository.save(new Event(LocalDateTime.of(2026, 7, 1, 14, 0), "Buurtfeest Kuregem", "Een gezellig buurtfeest voor alle inwoners van Kuregem met muziek, eten en activiteiten voor kinderen.", "NGO Anderlecht", "info@ngo-anderlecht.be", l5));
            eventRepository.save(new Event(LocalDateTime.of(2026, 7, 10, 10, 0), "Taalcursus Nederlands", "Vrije taalcursus Nederlands voor nieuwkomers. Alle niveaus welkom.", "Partnernaam OKRA", "taal@okra.be", l3));
            eventRepository.save(new Event(LocalDateTime.of(2026, 7, 15, 18, 30), "Informatiesessie Huisvesting", "Gratis infosessie over huurpremies en sociale huisvesting in Brussel.", "NGO Anderlecht", "info@ngo-anderlecht.be", l1));
            eventRepository.save(new Event(LocalDateTime.of(2026, 7, 20, 9, 0), "Ochtendgymnastiek in het Park", "Gratis ochtendgymnastiek voor alle leeftijden. Breng je eigen matje mee.", "Sportraad Anderlecht", "sport@anderlecht.be", l5));
            eventRepository.save(new Event(LocalDateTime.of(2026, 8, 1, 11, 0), "Zomermarkt voor Kinderen", "Spelen, knutselen en face painting voor kinderen van 4 tot 12 jaar.", "NGO Anderlecht", "info@ngo-anderlecht.be", l2));
            eventRepository.save(new Event(LocalDateTime.of(2026, 8, 5, 15, 0), "Lezing: Gezond Eten met een Klein Budget", "Praktische tips om gezond te eten zonder veel geld uit te geven.", "Partnernaam CM", "gezondheid@cm.be", l4));
            eventRepository.save(new Event(LocalDateTime.of(2026, 8, 12, 19, 0), "Filmavond: Documentaire over Samenleven", "Gratis filmvertoning met nadien een discussie met het publiek.", "NGO Anderlecht", "info@ngo-anderlecht.be", l1));
            eventRepository.save(new Event(LocalDateTime.of(2026, 8, 20, 10, 0), "Werkzoekenden Beurs", "Ontmoet werkgevers en ontdek opleidingsmogelijkheden in je buurt.", "Partnernaam VDAB", "jobs@vdab.be", l2));
            eventRepository.save(new Event(LocalDateTime.of(2026, 9, 1, 16, 0), "Terug naar School: Schoolspullen Ruilbeurs", "Breng overtollige schoolspullen en ruil ze voor wat je nodig hebt.", "NGO Anderlecht", "info@ngo-anderlecht.be", l3));
            eventRepository.save(new Event(LocalDateTime.of(2026, 9, 10, 13, 0), "Community Lunch", "Gratis gemeenschapslunch waar iedereen welkom is. Breng een gerecht mee om te delen!", "NGO Anderlecht", "info@ngo-anderlecht.be", l1));
        }
    }
}
