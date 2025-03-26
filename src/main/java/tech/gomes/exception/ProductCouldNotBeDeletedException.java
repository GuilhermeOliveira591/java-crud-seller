
package tech.gomes.exception;

public class ProductCouldNotBeDeletedException extends RuntimeException{
    public ProductCouldNotBeDeletedException(String message){
        super(message);
    }
}
