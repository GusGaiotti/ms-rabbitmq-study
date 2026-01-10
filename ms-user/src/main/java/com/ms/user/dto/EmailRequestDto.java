package com.ms.user.dto;

import java.util.UUID;

public record EmailRequestDto (UUID userId, String emailTo, String subject, String text){
}
