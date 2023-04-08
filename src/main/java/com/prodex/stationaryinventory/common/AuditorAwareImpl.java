package com.prodex.stationaryinventory.common;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Optional<Authentication> authentication = Optional
        //         .ofNullable(SecurityContextHolder.getContext().getAuthentication());

        return Optional.of("DEFUSER");
    }

}
