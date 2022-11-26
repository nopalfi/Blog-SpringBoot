package xyz.nopalfi.blog.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceAlreadyExistException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public ResourceAlreadyExistException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("'%s': '%s' with '%s' already exist", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
