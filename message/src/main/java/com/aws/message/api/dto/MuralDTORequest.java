package com.aws.message.api.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record MuralDTORequest(
        int id,
        @NotNull String name,
        @NotNull @Max(250) String message
                              ) {
}
