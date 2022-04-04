public class StockInsufcientException extends Exception{
    String message= " ";
    public StockInsufcientException(){
        super();
    }
    
    public StockInsufcientException(String message){
        super(message);
    }
}

   
