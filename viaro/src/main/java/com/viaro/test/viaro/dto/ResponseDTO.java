package com.viaro.test.viaro.dto;

public record ResponseDTO <T> (boolean success, String message, T data){
}
