class Birth(val year: Int, val month: Int, val day: Int) {
    override fun toString(): String = "($day.$month.$year)"
}

class Contact(val name: String, var phone: String, val birthDate: Birth) {
    fun printContact() {
        println("Name: $name, Mobile: $phone, Date: $birthDate")
    }
}

fun addContact(agenda: MutableList<Contact>, contact: Contact) {
    agenda.add(contact)
}

fun findContactByName(agenda: List<Contact>, name: String): Contact? {
    return agenda.find { it.name.equals(name, ignoreCase = true) }
}

fun findContactByPhone(agenda: List<Contact>, phone: String): Contact? {
    return agenda.find { it.phone == phone }
}

fun updatePhone(agenda: MutableList<Contact>, name: String, newPhone: String): Boolean {
    val contact = findContactByName(agenda, name)
    return if (contact != null) {
        contact.phone = newPhone
        true
    } else false
}

fun deleteContactByName(agenda: MutableList<Contact>, name: String): Boolean {
    val contact = findContactByName(agenda, name)
    return if (contact != null) {
        agenda.remove(contact)
        true
    } else false
}

fun main() {
    val agenda = mutableListOf<Contact>()

    addContact(agenda, Contact("Mihai", "0744321987", Birth(1900, 11, 25)))
    addContact(agenda, Contact("George", "0761332100", Birth(2002, 3, 14)))
    addContact(agenda, Contact("Liviu", "0231450211", Birth(1999, 7, 30)))

    println("agenda initiala:")
    agenda.forEach { it.printContact() }

    println("\nCautare după nume 'George':")
    findContactByName(agenda, "George")?.printContact() ?: println("Contact inexistent")

    println("\nActualizare numar George:")
    if (updatePhone(agenda, "George", "0777777777")) {
        println("Numar actualizat cu succes")
    }

    agenda.forEach { it.printContact() }

    println("\nStergere contact Liviu:")
    if (deleteContactByName(agenda, "Liviu")) {
        println("Contact sters")
    }

    agenda.forEach { it.printContact() }
}