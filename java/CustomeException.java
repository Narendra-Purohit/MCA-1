class NegativeValueException extends Exception {
    public NegativeValueException(String message) {
        super(message);
    }
}

class CustomeException{
    public static void main(String[] args){
        
        for(int i=0;i<args.length;i++){
            try{
                int number= Integer.parseInt(args[i]);
                if (number < 0) {
                    throw new NegativeValueException("Number is negative: " + number);
                }
                System.out.println("Valid number : " + number);
                
            }catch(NegativeValueException e){
                    System.out.println("Exception : " + e.getMessage());
            }catch(NumberFormatException e) {
                System.out.println("Invalid input : " + args[i]);
            }
        }
    }
}