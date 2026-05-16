package com.example.sciencequiz

import android.Manifest
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Datenklasse
data class SciencQuizEntry(
    var discipline: List<String>,
    val person: List<String>,
    val discovery: List<String>
)

object ScienceQuizyData {
    val unit_2 = listOf(
// --- MATHEMATIKER (ERWEITERT) ---
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Carl Friedrich Gauß"), discovery = listOf("Gaußsche Normalverteilung und Fundamentalsatz der Algebra")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Leonhard Euler"), discovery = listOf("Eulersche Zahl e und die Eulersche Identität")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Alan Turing"), discovery = listOf("Turingmaschine und Grundlagen der Informatik")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Ada Lovelace"), discovery = listOf("Erster Algorithmus für die Analytical Engine")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Pythagoras"), discovery = listOf("Satz des Pythagoras (a² + b² = c²)")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Euclid"), discovery = listOf("Axiome der Geometrie und Primzahltheorie")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Emmy Noether"), discovery = listOf("Noether-Theorem (Zusammenhang Symmetrie und Erhaltungssätze)")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Blaise Pascal"), discovery = listOf("Wahrscheinlichkeitsrechnung und Pascalsches Dreieck")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Gottfried Wilhelm Leibniz"), discovery = listOf("Unabhängige Entwicklung der Differential- und Integralrechnung")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Bernhard Riemann"), discovery = listOf("Nichteuklidische Geometrie als Basis für die Relativitätstheorie")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Augustin-Louis Cauchy"), discovery = listOf("Formulierung der mathematischen Strenge in der Analysis")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("John von Neumann"), discovery = listOf("Mathematische Grundlagen der Quantenmechanik und Spieltheorie")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Kurt Gödel"), discovery = listOf("Beweis der Unvollständigkeit formaler Systeme")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Joseph Fourier"), discovery = listOf("Zerlegung periodischer Signale in Sinus- und Kosinuswellen")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Srinivasa Ramanujan"), discovery = listOf("Hochkomplexe unendliche Reihen und Partitionsfunktionen")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("David Hilbert"), discovery = listOf("Konzept der unendlichdimensionalen Räume in der Analysis")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Évariste Galois"), discovery = listOf("Theorie zur Lösbarkeit algebraischer Gleichungen mittels Gruppen")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("René Descartes"), discovery = listOf("Erfindung des kartesischen Koordinatensystems zur Verknüpfung von Algebra und Geometrie")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Pierre de Fermat"), discovery = listOf("Begründung der modernen Zahlentheorie und ein berühmter, jahrhundertelang unbewiesener Satz")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Henri Poincaré"), discovery = listOf("Begründung der algebraischen Topologie und Vorläufer der Chaosforschung")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Andrew Wiles"), discovery = listOf("Spektakulärer Beweis des Großen Fermatschen Satzes im Jahr 1994")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Georg Cantor"), discovery = listOf("Begründung der Mengenlehre und Definition unterschiedlicher Unendlichkeiten")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Simeon Denis Poisson"), discovery = listOf("Wahrscheinlichkeitsverteilung für seltene, unabhängige Ereignisse")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Carl Gustav Jacob Jacobi"), discovery = listOf("Theorie der elliptischen Funktionen und Determinanten in der mehrdimensionalen Analysis")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Bonaventura Cavalieri"), discovery = listOf("Prinzip zur Volumenberechnung von Körpern mittels paralleler Schnitte")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Stefan Banach"), discovery = listOf("Konzept der vollständigen normierten Vektorräume in der Funktionalanalysis")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Katherine Johnson"), discovery = listOf("Präzise Berechnung der Flugbahnen für die ersten bemannten Raumflüge der NASA")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Maryna Viazovska"), discovery = listOf("Beweis der dichtesten Kugelpackung in den Dimensionen 8 und 24")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("George Boole"), discovery = listOf("Formulierung einer algebraischen Logik, die auf den Werten Wahr und Falsch basiert")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Grace Hopper"), discovery = listOf("Erfindung des ersten Compilers und Pionierarbeit bei maschinenunabhängigen Programmiersprachen")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Andrei Kolmogorow"), discovery = listOf("Axiomatische Begründung der modernen Wahrscheinlichkeitsrechnung")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Archimedes"), discovery = listOf("Näherungsverfahren für die Kreiszahl Pi und Hebelgesetz der Mechanik")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Al-Chwarizmi"), discovery = listOf("Systematische Regeln zur Lösung linearer und quadratischer Gleichungen")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("John Napier"), discovery = listOf("Erfindung der Logarithmen zur Vereinfachung komplexer Multiplikationen")),
        SciencQuizEntry(discipline = listOf("Mathematik"), person = listOf("Fibonacci"), discovery = listOf("Einführung des arabischen Zahlensystems in Europa und eine unendliche Zahlenfolge aus Summen")),
// --- PHYSIKER (ERWEITERT) ---
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Albert Einstein"), discovery = listOf("Relativitätstheorie und photoelektrischer Effekt")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Isaac Newton"), discovery = listOf("Gravitationsgesetz und die Gesetze der Mechanik")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Max Planck"), discovery = listOf("Quantenhypothese und Plancksches Wirkungsquantum")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Niels Bohr"), discovery = listOf("Bohrsches Atommodell und Quantensprünge")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Werner Heisenberg"), discovery = listOf("Heisenbergsche Unschärferelation")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Marie Curie"), discovery = listOf("Forschung zur Radioaktivität")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("James Clerk Maxwell"), discovery = listOf("Maxwell-Gleichungen des Elektromagnetismus")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Stephen Hawking"), discovery = listOf("Theorie der Hawking-Strahlung schwarzer Löcher")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Erwin Schrödinger"), discovery = listOf("Schrödingergleichung (Wellenmechanik)")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Richard Feynman"), discovery = listOf("Quantenelektrodynamik und Feynman-Diagramme")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Michael Faraday"), discovery = listOf("Elektromagnetische Induktion und die Gesetze der Elektrolyse")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Galileo Galilei"), discovery = listOf("Entdeckung der vier größten Monde des Planeten Jupiter")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Heinrich Hertz"), discovery = listOf("Experimenteller Nachweis von elektromagnetischen Wellen")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Ernest Rutherford"), discovery = listOf("Nachweis des winzigen, positiv geladenen Atomkerns")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Wilhelm Conrad Röntgen"), discovery = listOf("Entdeckung einer neuen Art von unsichtbaren Strahlen")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Lise Meitner"), discovery = listOf("Theoretische Erklärung der Kernspaltung von Uran")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Alessandro Volta"), discovery = listOf("Konstruktion der ersten funktionierenden chemischen Batterie")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Christian Doppler"), discovery = listOf("Frequenzverschiebung bei bewegten Wellenquellen")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Paul Dirac"), discovery = listOf("Theoretische Vorhersage der Existenz von Antimaterie")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Johannes Kepler"), discovery = listOf("Gesetze über die elliptischen Bahnen der Planeten")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Lord Kelvin"), discovery = listOf("Bestimmung des absoluten Nullpunkts der Temperatur")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Christiaan Huygens"), discovery = listOf("Wellentheorie des Lichts und Entdeckung der Saturnringe")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Enrico Fermi"), discovery = listOf("Konstruktion des ersten kontrollierten Kernreaktors")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("James Prescott Joule"), discovery = listOf("Nachweis der Äquivalenz von mechanischer Arbeit und Wärme")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Chien-Shiung Wu"), discovery = listOf("Experimenteller Nachweis der Paritätsverletzung bei der schwachen Wechselwirkung")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Wolfgang Pauli"), discovery = listOf("Ausschlussprinzip, nach dem zwei Elektronen nicht im selben Quantenzustand sein können")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Louis de Broglie"), discovery = listOf("Theorie des Welle-Teilchen-Dualismus für Materie (Materiewellen)")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Robert Hooke"), discovery = listOf("Gesetz über die proportionale Elastizität von Federn und Entdeckung von Zellen")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Peter Higgs"), discovery = listOf("Postulat eines Feldes, das Elementarteilchen ihre Masse verleiht")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Thomas Young"), discovery = listOf("Doppelspaltexperiment zum Nachweis der Wellennatur des Lichts")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Anders Jonas Ångström"), discovery = listOf("Pionier der Astronomischen Spektroskopie und Vermessung von Wasserstofflinien")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Subrahmanyan Chandrasekhar"), discovery = listOf("Berechnung der maximalen Masse für die Stabilität eines Weißen Zwergs")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Edwin Hubble"), discovery = listOf("Nachweis der Expansion des Universums und Existenz anderer Galaxien")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("Blaise Pascal"), discovery = listOf("Nachweis des hydrostatischen Drucks und der Existenz des Vakuums")),
        SciencQuizEntry(discipline = listOf("Physik"), person = listOf("J. J. Thomson"), discovery = listOf("Entdeckung des Elektrons als subatomares Teilchen")),
// --- CHEMIKER (ERWEITERT) ---
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Dmitri Mendelejew"), discovery = listOf("Periodensystem der Elemente")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Antoine Lavoisier"), discovery = listOf("Gesetz der Massenerhaltung und Rolle des Sauerstoffs")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Linus Pauling"), discovery = listOf("Natur der chemischen Bindung")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Robert Boyle"), discovery = listOf("Nachweis des umgekehrt proportionalen Verhältnisses von Druck und Volumen bei Gasen")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("John Dalton"), discovery = listOf("Moderne Atomtheorie und Atomgewichte")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Fritz Haber"), discovery = listOf("Haber-Bosch-Verfahren zur Ammoniaksynthese")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Louis Pasteur"), discovery = listOf("Pasteurisierung und optische Isomerie")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Otto Hahn"), discovery = listOf("Entdeckung der Kernspaltung")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Alfred Nobel"), discovery = listOf("Erfindung des Dynamits")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Justus von Liebig"), discovery = listOf("Erfindung des Mineraldüngers für die Landwirtschaft")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Amedeo Avogadro"), discovery = listOf("Hypothese, dass gleiche Gasvolumina die gleiche Teilchenzahl haben")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Svante Arrhenius"), discovery = listOf("Theorie der elektrolytischen Dissoziation von Ionen in Wasser")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Gilbert N. Lewis"), discovery = listOf("Konzept der kovalenten Bindung durch Elektronenpaare")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Jacobus Henricus van 't Hoff"), discovery = listOf("Gesetze der chemischen Dynamik und des osmotischen Drucks")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Jöns Jakob Berzelius"), discovery = listOf("Einführung der modernen Elementsymbole aus Buchstaben")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Friedrich Wöhler"), discovery = listOf("Künstliche Synthese von Harnstoff aus anorganischen Stoffen")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Rosalind Franklin"), discovery = listOf("Röntgenbeugungsaufnahmen zur Entschlüsselung der DNA-Struktur")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Emil Fischer"), discovery = listOf("Schlüssel-Schloss-Prinzip bei Enzymen und Struktur von Zucker")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("August Kekulé"), discovery = listOf("Entdeckung der Ringstruktur des Benzols im Traum")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Humphry Davy"), discovery = listOf("Entdeckung von Natrium, Kalium und Calcium mittels Elektrolyse")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Marie Curie"), discovery = listOf("Entdeckung und Reindarstellung der neuen Elemente Polonium und Radium")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Dorothy Hodgkin"), discovery = listOf("Strukturanalyse von Penicillin und Vitamin B12 mittels Röntgenkristallographie")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Søren Sørensen"), discovery = listOf("Einführung der pH-Wert-Skala zur Messung von Säuren und Basen")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Robert Bunsen"), discovery = listOf("Entwicklung der Spektralanalyse zur Entdeckung neuer chemischer Elemente")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Glenn Seaborg"), discovery = listOf("Synthese und Identifikation von Plutonium und weiteren Transuranen")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Wilhelm Ostwald"), discovery = listOf("Katalyseforschung und Erfindung eines Verfahrens zur Salpetersäureherstellung")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Leo Baekeland"), discovery = listOf("Erfindung des ersten vollständig synthetischen Kunststoffs")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Martin Lowry"), discovery = listOf("Unabhängige Definition von Säuren als Protonendonatoren und Basen als Protonenakzeptoren")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Joseph Priestley"), discovery = listOf("Isolierung von gasförmigem Sauerstoff durch Erhitzen von Quecksilberoxid")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Carl Wilhelm Scheele"), discovery = listOf("Unabhängige Entdeckung von Sauerstoff, Chlor und Molybdän")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Henri Moissan"), discovery = listOf("Isolierung des extrem reaktiven Gases Fluor und Erfindung des elektrischen Lichtbogenofens")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Mario Molina"), discovery = listOf("Nachweis der Zerstörung der Ozonschicht durch Fluorchlorkohlenwasserstoffe")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Wallace Carothers"), discovery = listOf("Erfindung von Nylon und Neopren sowie Pionierarbeit bei Polymeren")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Richard Smalley"), discovery = listOf("Entdeckung der hohlen, fußballförmigen Kohlenstoffmoleküle")),
        SciencQuizEntry(discipline = listOf("Chemie"), person = listOf("Stephanie Kwolek"), discovery = listOf("Erfindung einer extrem reißfesten Kunstfaser für schussichere Westen")),
        // --- BIOLOGEN ---
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Charles Darwin"), discovery = listOf("Theorie der Evolution durch natürliche Selektion und Anpassung")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Gregor Mendel"), discovery = listOf("Vererzungsregeln von Merkmalen durch Kreuzungsversuche mit Erbsen")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Louis Pasteur"), discovery = listOf("Widerlegung der Urzeugung und Begründung der Mikrobiologie")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Alexander Fleming"), discovery = listOf("Zufällige Entdeckung des ersten wirksamen Antibiotikums aus Schimmelpilzen")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("James Watson"), discovery = listOf("Entschlüsselung der dreidimensionalen Doppelhelix-Struktur der DNA")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Francis Crick"), discovery = listOf("Formulierung des zentralen Dogmas der Molekularbiologie über den Informationsfluss")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Robert Hooke"), discovery = listOf("Erstmalige Beschreibung von pflanzlichen Zellen unter einem Mikroskop")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Carl von Linné"), discovery = listOf("Entwicklung der binären Nomenklatur zur Klassifizierung von Pflanzen und Tieren")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Robert Koch"), discovery = listOf("Postulate zum Nachweis von bakteriellen Krankheitserregern wie der Tuberkulose")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Rosalind Franklin"), discovery = listOf("Kristallisationsaufnahmen, die die Struktur der Erbsubstanz bewiesen")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Barbara McClintock"), discovery = listOf("Entdeckung von beweglichen Genelementen, den sogenannten springenden Genen")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Antoni van Leeuwenhoek"), discovery = listOf("Erstmalige Beobachtung von lebenden Einzellern und Bakterien mit selbstgebauten Linsen")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Rachel Carson"), discovery = listOf("Dokumentation der ökologischen Schäden durch Pestizide und Begründung der Umweltbewegung")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Konrad Lorenz"), discovery = listOf("Erforschung des Verhaltens von Vögeln und das Prinzip der Prägung")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Karl Landsteiner"), discovery = listOf("Entdeckung des ABO-Blutgruppensystems beim Menschen")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Lynn Margulis"), discovery = listOf("Formulierung der Endosymbiontentheorie zur Entstehung komplexer Zellen")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Thomas Hunt Morgan"), discovery = listOf("Nachweis an Fruchtfliegen, dass Gene auf Chromosomen liegen")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Jane Goodall"), discovery = listOf("Langzeitstudien über das komplexe Sozial- und Werkzeugverhalten von Schimpansen")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Paul Ehrlich"), discovery = listOf("Entwicklung der Seitenkettentheorie der Immunität und der ersten gezielten Chemotherapie")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Emmanuelle Charpentier"), discovery = listOf("Entwicklung der molekularen Genschere zur präzisen Bearbeitung von DNA")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Jennifer Doudna"), discovery = listOf("Pionierarbeit bei der Umwandlung eines bakteriellen Immunsystems in ein Werkzeug zur Genomeditierten")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Melvin Calvin"), discovery = listOf("Aufklärung des zyklischen Pfades der Kohlenstofffixierung bei der Fotosynthese")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Ernst Haeckel"), discovery = listOf("Formulierung des biogenetischen Grundgesetzes und Prägung des Begriffs Ökologie")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Alexander von Humboldt"), discovery = listOf("Begründung der Biogeographie durch die Untersuchung von Pflanzenverteilungen in Höhenzonen")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Edward Jenner"), discovery = listOf("Entwicklung der allerersten Schutzimpfung durch die Nutzung von Kuhpockenviren")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Georges Cuvier"), discovery = listOf("Begründung der Paläontologie und der vergleichenden Anatomie")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Matthias Schleiden"), discovery = listOf("Erkenntnis, dass alle Pflanzen aus Zellen aufgebaut sind")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Theodor Schwann"), discovery = listOf("Erweiterung der Zelltheorie auf alle tierischen Organismen")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Rudolf Virchow"), discovery = listOf("Formulierung des Grundsatzes, dass jede Zelle aus einer bereits existierenden Zelle entsteht")),
        SciencQuizEntry(discipline = listOf("Biologie"), person = listOf("Kary Mullis"), discovery = listOf("Erfindung der Polymerase-Kettenreaktion zur millionenfachen Vervielfältigung von DNA")),
    )
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loadNextQuestion()
    }

    private fun checkNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.POST_NOTIFICATIONS), 101)
            }
        }
    }

    private fun scheduleDailyNotification() {
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, QuizReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        // Zeit auf 20:00 Uhr setzen
        val calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, 20)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)

            // Wenn es heute schon nach 20 Uhr ist, plane für morgen
            if (before(Calendar.getInstance())) {
                add(Calendar.DATE, 1)
            }
        }

        // Tägliche Wiederholung
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )
    }

    private fun loadNextQuestion() {
        val tvDiscipline = findViewById<TextView>(R.id.tvDiscipline)
        val tvDiscovery = findViewById<TextView>(R.id.tvDiscovery)
        val buttons = listOf(
            findViewById<Button>(R.id.btnOpt1),
            findViewById<Button>(R.id.btnOpt2),
            findViewById<Button>(R.id.btnOpt3),
            findViewById<Button>(R.id.btnOpt4)
        )

        val correctEntry = ScienceQuizyData.unit_2.random()
        val correctAnswer = correctEntry.person.first()

        val wrongAnswers = ScienceQuizyData.unit_2
            .map { it.person.first() }
            .filter { it != correctAnswer }
            .distinct()
            .shuffled()
            .take(3)

        val allOptions = (wrongAnswers + correctAnswer).shuffled()

        // UI Texte setzen
        tvDiscipline.text = correctEntry.discipline.first().uppercase() // Disziplin in Großbuchstaben
        tvDiscovery.text = correctEntry.discovery.first()

        for (i in buttons.indices) {
            buttons[i].text = allOptions[i]
            buttons[i].setOnClickListener {
                if (buttons[i].text == correctAnswer) {
                    Toast.makeText(this, "Richtig! 🚀", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Falsch! Das war $correctAnswer", Toast.LENGTH_SHORT).show()
                }
                loadNextQuestion()
            }
        }
    }
}