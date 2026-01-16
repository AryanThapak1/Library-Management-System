package com.example.backend.response;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class ApiResponse<T> {
    private int statusCode;
    private String message;
    private T data;

    public ApiResponse(int statusCode, String message, T data)
    {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> success(int statusCode, String message, T data)
    {
        return new ApiResponse<>(statusCode, message, data);
    }

    public static <T> ApiResponse<T> error(int statusCode, String message, T data)
    {
        return new ApiResponse<>(statusCode, message, data);
    }

}
