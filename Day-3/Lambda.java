public class Lambda {
    public static void main(String[] args) {

        // Lambda Function: is a defined function not bound to an identifier!

        // A function has 4 things: 
        // 1. name - anonymous
            // 2. parameter list
            // 3. body
        // 4. return - inferred

        // what it looks like originally
        // Thread th = new Thread(new Runnable() {
        //     public void run(){
        //         System.out.println("I'm in another Thread!");
        //     }        
        // });

        // what Lambda expresssion makes it look like-> it removes name and return type just contains parameter and body

        // invokedynamic -> you can attach a detach to the function you want to invoke dynamically
        // this thread down the line is how lambda's are actually invoked dynamically under the hood!

        Thread th = new Thread(() -> System.out.println("I'm in another Thread!"));

        
        th.start();
        System.out.println("In main!");
    }
}
