package com.opom.bdms.features.hospital.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HospitalRequest(
        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Address is required")
        String address,

        @NotNull(message = "Phone Number is required")
        String phone,

         @Email
         @NotNull(message = "Email is required")
         String email,

         Boolean isVerified
) {}
