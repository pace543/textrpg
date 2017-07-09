package io.github.pace543.textrpg.item;

import io.github.pace543.textrpg.battle.Element;

public interface ItemType {
    int getCost();
    Element getElement();
    String getName();
}
