package solutions

fun canBeValid(s: String, locked: String): Boolean {
    if (s.length % 2 != 0) return false
    
    var balance = 0
    var wildcards = 0
    
    for (i in s.indices) {
        if (locked[i] == '1') {
            if (s[i] == '(') balance++
            else balance--
        } else {
            wildcards++
        }
        
        if (balance + wildcards < 0) return false
    }
    
    balance = 0
    wildcards = 0
    
    for (i in s.length - 1 downTo 0) {
        if (locked[i] == '1') {
            if (s[i] == ')') balance++
            else balance--
        } else {
            wildcards++
        }
        
        if (balance + wildcards < 0) return false
    }
    
    return true
}