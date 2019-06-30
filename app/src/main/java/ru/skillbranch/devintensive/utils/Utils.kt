package ru.skillbranch.devintensive.utils

import java.lang.StringBuilder

object Utils {
    fun parseFullName(fullName:String?) : Pair<String?, String?> {
        var list = fullName?.split(" ")
        val firstName = list?.getOrNull(0)
        val lastName = list?.getOrNull(1)
        return Pair(if(firstName == "" || firstName == " ") null else firstName, if(lastName == "" || lastName == " ") null else lastName)
    }

    fun toInitials(firstName: String?, lastName: String?): String {
        var char1 = firstName?.getOrNull(0)?.toTitleCase()
        var char2 = lastName?.getOrNull(0)?.toTitleCase()
        var string = StringBuilder()
        string.append(char1)
        string.append(char2)
        var initials = string.toString()
         if (initials.contains("null")) {
             return if (initials.replace("null", "") == "" || initials.replace("null", "") == " ") {
                 null.toString()
             }else {
                 initials.replace("null", "")
             }
            } else if (initials == "" || initials == " ") {
             return null.toString()
        }
        return initials
    }

    fun transliteration(fullName: String, divider: String = " ") : String {
        var string = StringBuilder()
        fullName.forEach {
            var char = when(it.toString().toLowerCase()) {
                "а"-> "a"
                "б"-> "b"
                "в"-> "v"
                "г"-> "g"
                "д"-> "d"
                "е"-> "e"
                "ё"-> "e"
                "ж"-> "zh"
                "з"-> "z"
                "и"-> "i"
                "й"-> "i"
                "к"-> "k"
                "л"-> "l"
                "м"-> "m"
                "н"-> "n"
                "о"-> "o"
                "п"-> "p"
                "р"-> "r"
                "с"-> "s"
                "т"-> "t"
                "у"-> "u"
                "ф"-> "f"
                "х"-> "h"
                "ц"-> "c"
                "ч"-> "ch"
                "ш"-> "sh"
                "щ"-> "sh'"
                "ъ"-> ""
                "ы"-> "i"
                "ь"-> ""
                "э"-> "e"
                "ю"-> "yu"
                "я"-> "ya"
                " "-> divider
                else -> it
            }
            if (string.isEmpty() || string[string.length - 1].toString() == " " || string[string.length - 1].toString() == divider) {
                string.append(char.toString().toUpperCase())
            }else {
                string.append(char.toString())
            }

        }
        return string.toString()
    }
}