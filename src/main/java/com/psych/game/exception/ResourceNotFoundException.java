package com.psych.game.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

        @Setter @Getter
        private String resource, field;
        @Getter @Setter
        private Object value;

        public ResourceNotFoundException(String resource, String field, Object value){
            super(String.format("%s not found with %s: %s", resource,field,value));
            this.resource = resource;
            this.field = field;
            this.value = value;
        }

}
