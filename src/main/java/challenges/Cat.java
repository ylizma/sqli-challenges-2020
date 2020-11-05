package challenges;

public class Cat {
    String leap;
    int leapsize;
    public Cat() {
        this.leap = "*";
        this.leapsize = 0;
    }
    public String path(){
        return this.leap;
    }
    public void leap(){
        this.leapsize ++;
        if (leapsize<=4){
            for (int i = 0; i < leapsize ; i++) {
                this.leap += ".";
            }
            this.leap += "*";
        }
        else{
            this.leap +="";
        }
    }


}
