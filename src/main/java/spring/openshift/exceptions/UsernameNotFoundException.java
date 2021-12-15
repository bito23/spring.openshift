package spring.openshift.exceptions;

public class UsernameNotFoundException extends Exception {

   public UsernameNotFoundException(int id){
       super(String.valueOf(id));
   }

    public UsernameNotFoundException(String name){
        super(name);
    }

}