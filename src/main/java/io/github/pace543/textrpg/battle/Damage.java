package io.github.pace543.textrpg.battle;

public enum Damage {
    NORMAL, LESS_EFFECTIVE, SUPER_EFFECTIVE, NON_EFFECTIVE;

    public static Damage getEffectiveness(Element attacker, Element defender) {
        switch (attacker) {
            case FIRE:
                switch (defender) {
                    case FIRE:      return NORMAL;
                    case WATER:     return LESS_EFFECTIVE;
                    case AIR:       return NORMAL;
                    case EARTH:     return SUPER_EFFECTIVE;
                    case ELECTRIC:  return NORMAL;
                    case NEUTRAL:   return NORMAL;
                    default:        return NORMAL;
                }
            case WATER:
                switch (defender) {
                    case FIRE:      return SUPER_EFFECTIVE;
                    case WATER:     return NORMAL;
                    case AIR:       return NORMAL;
                    case EARTH:     return SUPER_EFFECTIVE;
                    case ELECTRIC:  return LESS_EFFECTIVE;
                    case NEUTRAL:   return NORMAL;
                    default:        return NORMAL;
                }
            case AIR:
                switch (defender) {
                    case FIRE:      return NORMAL;
                    case WATER:     return NORMAL;
                    case AIR:       return NORMAL;
                    case EARTH:     return LESS_EFFECTIVE;
                    case ELECTRIC:  return NORMAL;
                    case NEUTRAL:   return NORMAL;
                    default:        return NORMAL;
                }
            case EARTH:
                switch (defender) {
                    case FIRE:      return SUPER_EFFECTIVE;
                    case WATER:     return LESS_EFFECTIVE;
                    case AIR:       return LESS_EFFECTIVE;
                    case EARTH:     return NORMAL;
                    case ELECTRIC:  return SUPER_EFFECTIVE;
                    case NEUTRAL:   return NORMAL;
                    default:        return NORMAL;
                }
            case ELECTRIC:
                switch (defender) {
                    case FIRE:      return NORMAL;
                    case WATER:     return SUPER_EFFECTIVE;
                    case AIR:       return SUPER_EFFECTIVE;
                    case EARTH:     return LESS_EFFECTIVE;
                    case ELECTRIC:  return NORMAL;
                    case NEUTRAL:   return NORMAL;
                    default:        return NORMAL;
                }
            case NEUTRAL:
                switch (defender) {
                    case FIRE:      return NORMAL;
                    case WATER:     return NORMAL;
                    case AIR:       return NORMAL;
                    case EARTH:     return NORMAL;
                    case ELECTRIC:  return NORMAL;
                    case NEUTRAL:   return NORMAL;
                    default:        return NORMAL;
                }
            case HEAL:
                switch (defender) {
                    case HEAL:      return SUPER_EFFECTIVE;
                    default:        return NON_EFFECTIVE;
                }
            default: return NORMAL;
        }
    }
}
