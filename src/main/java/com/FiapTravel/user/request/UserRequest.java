package com.FiapTravel.user.request;

import com.FiapTravel.model.enums.UserRole;

public record UserRequest(String login, String password, UserRole role) {
}

