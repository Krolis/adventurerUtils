package xyz.yeahbunny.adventurer.utils.action.transform;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Transform<DEST, SOURCE> {

    public abstract DEST toResponse(SOURCE source);

    public Set<DEST> toSet(Collection<SOURCE> discoveredPlayers) {
        return discoveredPlayers.stream()
                .map(this::toResponse)
                .collect(Collectors.toSet());
    }

}
