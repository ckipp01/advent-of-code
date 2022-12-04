def priority(c: Char): Int = c match
  case lc if lc.isLower => c - 'a' + 1
  case uc               => uc - 'A' + 27
