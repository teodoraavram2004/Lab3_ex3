// Clasa pentru data nașterii
class Birth(val year: Int, val month: Int, val day: Int) {
    override fun toString(): String {
        return "($day.$month.$year)"
    }
}

// Clasa pentru contact
class Contact(val name: String, var phone: String, val birthDate: Birth) {
    fun printContact() {
        println("Name: $name, Mobile: $phone, Date: $birthDate")
    }
}

// Funcție de căutare contact după nume sau număr
fun searchContact(agenda: List<Contact>, query: String): List<Contact> {
    return agenda.filter { it.name.equals(query, ignoreCase = true) || it.phone == query }
}

// Funcție de actualizare număr de telefon
fun updatePhone(agenda: MutableList<Contact>, name: String, newPhone: String): Boolean {
    val contact = agenda.find { it.name.equals(name, ignoreCase = true) }
    return if (contact != null) {
        contact.phone = newPhone
        true
    } else {
        false
    }
}

fun main() {
    // Crearea agendei
    val agenda = mutableListOf<Contact>()

    // Adăugarea contactelor
    agenda.add(Contact("Mihai", "0744321987", Birth(1900, 11, 25)))
    agenda += Contact("George", "0761332100", Birth(2002, 3, 14))
    agenda += Contact("Liviu", "0231450211", Birth(1999, 7, 30))
    agenda += Contact("Popescu", "0211342787", Birth(1955, 5, 12))

    println("Agenda inițială:")
    agenda.forEach { it.printContact() }

    // Ștergerea contactului George
    println("\nAgenda după eliminarea contactului [George]:")
    agenda.removeIf { it.name.equals("George", ignoreCase = true) }
    agenda.forEach { it.printContact() }

    // Ștergerea contactului Liviu
    println("\nAgenda după eliminarea contactului [Liviu]:")
    agenda.removeIf { it.name.equals("Liviu", ignoreCase = true) }
    agenda.forEach { it.printContact() }

    // Căutare contact
    println("\nCăutare contact după nume/telefon:")
    val results = searchContact(agenda, "Mihai")
    results.forEach { it.printContact() }

    // Actualizare număr telefon
    println("\nActualizare număr telefon pentru Popescu:")
    val updated = updatePhone(agenda, "Popescu", "0777123456")
    if (updated) {
        println("Număr actualizat cu succes!")
    } else {
        println("Contactul nu a fost găsit!")
    }

    // Afișarea agendei finale
    println("\nAgenda finală:")
    agenda.forEach { it.printContact() }
}