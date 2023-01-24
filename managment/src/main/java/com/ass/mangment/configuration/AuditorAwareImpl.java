package com.ass.mangment.configuration;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {
        // we should have the user from spring security.
        return Optional.of("Bashar : ) ");
    }
}
