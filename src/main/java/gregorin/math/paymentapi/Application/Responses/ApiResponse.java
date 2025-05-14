package gregorin.math.paymentapi.Application.Responses;

import org.springframework.http.ResponseEntity;

public class ApiResponse<T> {

    private String status;
    private String message;
    private T data;

    public ApiResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    // Métodos auxiliares estáticos
    public static <T> ResponseEntity<ApiResponse<T>> success(String message, T data) {
        return ResponseEntity.status(200).body(new ApiResponse<>("success", message, data));
    }

    public static <T> ResponseEntity<ApiResponse<T>> error(String message, Integer status, T data) {
        return ResponseEntity.status(status).body(new ApiResponse<>("failed", message, data));
    }
}
