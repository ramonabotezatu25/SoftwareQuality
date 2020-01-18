public class Food {

    private String name;
    private int calorioes;
    private ETaste taste;
    private boolean isHealthy;
    private int[] possibleGrams;

    public Food() { }

    public Food(String name, int calorioes, ETaste taste, boolean isHealthy, int[] possibleGrams) {
        this.name = name;
        this.calorioes = calorioes;
        this.taste = taste;
        this.isHealthy = isHealthy;
        this.possibleGrams = possibleGrams;
    }

    public Food(String name, int calorioes, ETaste taste, boolean isHealthy) {
        this.name = name;
        this.calorioes = calorioes;
        this.taste = taste;
        this.isHealthy = isHealthy;
    }

    public String getName() {
        return name;
    }

    public int getCalorioes() {
        return calorioes;
    }

    public ETaste getTaste() {
        return taste;
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    public int[] getPossibleGrams(){
        return this.possibleGrams;
    }

    public void setName(String name) throws CustomException {
        if(name.length() > 3) {
            this.name = name;
        } else throw new CustomException("The length for the foos is incorect");
    }

    public void setCalorioes(int calorioes) throws CustomException {
        if(calorioes > 3 && calorioes <=500) {
            this.calorioes = calorioes;
        } else throw new CustomException("The calories number is incorect");

    }

    public void setTaste(ETaste taste) {
        this.taste = taste;
    }

    public void setHealthy(boolean healthy, int calorioes) throws CustomException {
        if(calorioes<500){
            isHealthy = healthy;
        } else throw new CustomException("Calories number is to big to be a healthy food");

    }

    public void setPossibleGrams(int[] possibleGrams){
        this.possibleGrams = possibleGrams;
    }

    public int maxGrams() {
        int max = 0;
        for(int grams : this.possibleGrams){
            if(grams>max)
                max=grams;
        }
        return max;
    }

    public int averageGrams() {
        int sum = 0;
        for(int grams : this.possibleGrams){
            sum +=grams;
        }
        return sum/this.possibleGrams.length;

    }
}
